package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.forms.UserForm;
import ru.kpfu.itis.SoftIlnyr.mvc.services.INTERFACES.UsersService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

/**
 * Created by softi on 23.04.2016.
 */
@Controller
public class UsersController {
    public static final String SAVE_AVATAR = "avatars";
    @Autowired
    UsersService usersService;
    @Autowired
    private ServletContext servletContext;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap, Principal principal) {
        if (principal != null) {
            return "redirect:/test";
        }

        return "/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet(ModelMap modelMap, Principal principal) {
        if (principal != null) {
            return "redirect:/test";
        }
        modelMap.put("regForm", new UserForm());
        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(@Valid @ModelAttribute("regForm") UserForm regForm, BindingResult bindingResult, ModelMap modelMap,
                                   @RequestParam MultipartFile avatar) throws IOException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (usersService.findByNickname(regForm.getNickname()) != null) {
            modelMap.put("error", "Пользователь с таким именем уже существует");
            return "registration";
        }
        if (!regForm.getPassword().equals(regForm.getPasswordConfirmation())) {
            modelMap.put("error", "Подтверждение пароля не то");
        }
        User user = new User();
        user.setNickname(regForm.getNickname());
        user.setFirstName(regForm.getFirstName());
        user.setLastName(regForm.getLastName());
        user.setSurname(regForm.getSurname());
        String cryptPassword = encoder.encode(regForm.getPassword());
        user.setPassword(cryptPassword);
        user.setRating(0);
        user.setEmail(regForm.getEmail());
        user.setRole("ROLE_SIMPLE");


        if (!avatar.isEmpty()) {
            String filename = saveImage(avatar);
            user.setAvatar(filename);
        } else {
            user.setAvatar("default.jpg");
        }

        usersService.addUser(user);



        return "redirect:/login";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registrationPost(@RequestParam String nickname, @RequestParam String first_name,
//                                   @RequestParam String last_name, @RequestParam String surname,
//                                   @RequestParam String password, @RequestParam String email,
//                                   @RequestParam MultipartFile avatar) throws IOException {
//        User user = new User();
//        user.setNickname(nickname);
//        user.setFirstName(first_name);
//        user.setLastName(last_name);
//        user.setSurname(surname);
//        String cryptPassword = encoder.encode(password);
//        user.setPassword(cryptPassword);
//        user.setRating(0);
//        user.setEmail(email);
//        user.setRole("ROLE_SIMPLE");
//
//
//        if (!avatar.isEmpty()) {
//            String filename = saveImage(avatar);
//            user.setAvatar(filename);
//        } else {
//            user.setAvatar("default.jpg");
//        }
//
//        usersService.addUser(user);
//
//
//
//        return "redirect:/login";
//    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    @RequestMapping(value = "/tables/users", method = RequestMethod.GET)
    public String usersGet(ModelMap modelMap) {
        modelMap.put("users", usersService.findAll());
        return "/user_table";
    }

    @RequestMapping(value = "/tables/users/{user_id:\\d+}", method = RequestMethod.POST)
    public String userUpdatePage(@PathVariable int user_id, @RequestParam String nickname, @RequestParam String first_name,
                                 @RequestParam String last_name, @RequestParam String surname,
                                 @RequestParam String password, @RequestParam String email,
                                 @RequestParam MultipartFile avatar, @RequestParam String role, Principal principal) throws IOException {
        if (principal != null) {
            User principal1 = (User) ((Authentication) principal).getPrincipal();
            if ("ROLE_ADMIN".equals(principal1.getRole()) || principal1 == usersService.findById(user_id)) {
                User user = usersService.findById(user_id);
                user.setNickname(nickname);
                user.setFirstName(first_name);
                user.setLastName(last_name);
                user.setSurname(surname);
                if (!"".equals(password.trim())) {
                    String cryptPassword = encoder.encode(password);
                    user.setPassword(cryptPassword);
                }
                user.setEmail(email);
                user.setRole(role);

                if (!avatar.isEmpty()) {
                    String filename = saveImage(avatar);
                    user.setAvatar(filename);
                }

                usersService.update(user);
                return "redirect:/users/" + user_id;
            }
        }
        return "redirect:/403";
    }

    @RequestMapping(value = "/users/{user_id:\\d+}", method = RequestMethod.GET)
    public String userPage(ModelMap modelMap, @PathVariable int user_id, Principal principal) {
        boolean access = false;
        if (principal != null) {
            User pUser = (User) ((Authentication) principal).getPrincipal();
            if (pUser.getId() == user_id || "ROLE_ADMIN".equals(pUser.getRole())) {
                access = true;
            }
        }
        User user = usersService.findById(user_id);
        modelMap.put("userinfo", user);
        modelMap.put("access", access);
        modelMap.put("talons", user.getTalons());
        return "/user_page";
    }


    private String saveImage(MultipartFile image) throws IOException {
        String rootPath = servletContext.getRealPath("") + "resources\\uploads\\user_images";
        String rootPath2 = "C:\\Ilnyr\\Programs\\itis\\2k2s\\sem1_library_v2\\src\\main\\webapp\\resources\\uploads\\user_images";
        File dir = new File(rootPath);
        File dir2 = new File(rootPath2);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!dir2.exists()) {
            dir2.mkdirs();
        }
        String filename = String.valueOf(image.hashCode()) + "." + image.getContentType().split("/")[1];
        File file = new File(dir.getAbsolutePath() + File.separator + filename);
        File file2 = new File(dir2.getAbsolutePath() + File.separator + filename);
        byte[] data = image.getBytes();
        FileUtils.writeByteArrayToFile(file, data);
        FileUtils.writeByteArrayToFile(file2, data);
        return filename;
    }

    @RequestMapping(value = "/tables/users/excel", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<User> users = usersService.findAll();
        return new ModelAndView("usersView", "users", users);
    }


    @ResponseBody
    @RequestMapping(value = "/registration/nickname_validation", method = RequestMethod.POST)
    public Boolean nicknameValidation(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
        String nickname = (String) map.get("data");
        Boolean flag = usersService.findByNickname(nickname) == null;
        return flag;
    }

    @ResponseBody
    @RequestMapping(value = "/registration/email_validation", method = RequestMethod.POST)
    public Boolean emailValidation(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
        String email = (String) map.get("data");
        Boolean flag = usersService.findByEmail(email) == null;
        return flag;
    }

}
