package ru.kpfu.itis.softilnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.softilnyr.mvc.dao.impl.StudentIMPL;
import ru.kpfu.itis.softilnyr.mvc.models.Student;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Created by softi on 30.03.2016.
 */
@Controller
public class StudentsController {
    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    @ResponseBody List<Student> getStudents() {
        StudentIMPL impl = new StudentIMPL();
        return impl.allStudents();
    }

    @RequestMapping(value = "/students/{id:\\d+}", method = RequestMethod.GET)
    @ResponseBody Student getStudent(@PathVariable int id) {
        StudentIMPL impl = new StudentIMPL();
        return impl.getStudent(id);
    }

    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    void addStudent(@RequestParam int id, @RequestParam String name) {
        StudentIMPL impl = new StudentIMPL();
        impl.create(id, name);
    }

    @RequestMapping(value = "/students/{id:\\d+}", method = RequestMethod.POST)
    void updateStudent(@PathVariable int id, @RequestParam String name) {
        StudentIMPL impl = new StudentIMPL();
        impl.update(id, name);
    }

    @RequestMapping(value = "/students/new", method = RequestMethod.GET)
    String newStudent() {
        return "newStudent.jsp";
    }

    @RequestMapping(value = "/students/{id:\\d+}/update", method = RequestMethod.GET)
    String updateStudent(ModelMap modelMap, @PathVariable int id) {
        modelMap.put("id", id);
        return "updateStudent.jsp";
    }
}
