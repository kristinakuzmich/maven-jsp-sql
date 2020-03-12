package by.bsuir.lab1.controller;

import by.bsuir.lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/**/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ModelAndView getStudents() {
        ModelAndView modelAndView = new ModelAndView("studentPage");
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.getModel().put("students", studentService.getStudents());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView saveStudent(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String faculty, @RequestParam int course) {
        studentService.saveStudent(firstName, secondName, faculty, course);
        return new ModelAndView("redirect:students");
    }

    public StudentController setStudentService(StudentService studentService) {
        this.studentService = studentService;
        return this;
    }
}
