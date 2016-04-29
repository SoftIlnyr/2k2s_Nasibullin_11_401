package ru.kpfu.itis.SoftIlnyr.mvc.controllers;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.SoftIlnyr.mvc.entities.User;
import ru.kpfu.itis.SoftIlnyr.mvc.services.UsersService;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        return "/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet() {

        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(@RequestParam String nickname, @RequestParam String first_name,
                                   @RequestParam String last_name, @RequestParam String surname,
                                   @RequestParam String password, @RequestParam String email,
                                   @RequestParam MultipartFile avatar) throws IOException {
        User user = new User();
        user.setAdmin(false);
        user.setManager(false);
        user.setNickname(nickname);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setRating(0);
        user.setEmail(email);

        if (!avatar.isEmpty()) {
            String filename = saveImage(avatar);
            user.setAvatar(filename);
        }

        usersService.addUser(user);



        return "/user_table";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registrationPost(@ModelAttribute("userInfo")@RequestBody UserInfo userInfo) throws IOException {
//        User user = new User();
//        user.setAdmin(false);
//        user.setManager(false);
//        user.setNickname(userInfo.getNickname());
//        user.setFirstName(userInfo.getFirst_name());
//        user.setLastName(userInfo.getLast_name());
//        user.setSurname(userInfo.getSurname());
//        user.setPassword(userInfo.getPassword());
//        user.setRating(0);
//        user.setEmail(userInfo.getEmail());
//
//        usersService.addUser(user);
//
//        if (!userInfo.getAvatar().isEmpty()) {
//            String filename = userInfo.getNickname() + "." + userInfo.getAvatar().getName().split(".")[1];
//            saveImage(filename, userInfo.getAvatar());
//            user.setAvatar(filename);
//        }
//        return "usersGet";
//    }

    private void saveImage(String filename, MultipartFile image) throws IOException {
        File file = new File(servletContext.getRealPath("/") + filename);
        FileUtils.writeByteArrayToFile(file, image.getBytes());
    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    @RequestMapping(value = "/tables/users", method = RequestMethod.GET)
    public String usersGet() {

        return "/user_table";
    }

    private String saveImage(MultipartFile image) throws IOException {
        String rootPath = servletContext.getRealPath("") + "resources\\uploads\\user_images";
        String rootPath2 = "C:\\Ilnyr\\Programs\\itis\\2k2s\\sem1_library\\src\\main\\webapp\\resources\\uploads\\user_images";
        rootPath2 = rootPath2.replace("\\", File.separator);
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
        FileUtils.writeByteArrayToFile(file, image.getBytes());
        FileUtils.writeByteArrayToFile(file2, image.getBytes());
        return filename;
    }


}
