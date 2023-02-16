package ca.sheridancollege.controller;

import ca.sheridancollege.beans.Student;
import ca.sheridancollege.databaseaccess.DatabaseAccess;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class HomeController {

    private DatabaseAccess databaseAccess;

        public HomeController(DatabaseAccess databaseAccess){
            this.databaseAccess = databaseAccess;
        }

        @GetMapping("/getStudent")
        public String goHome(Model model){

        List<Student> student = databaseAccess.getStudent();
        model.addAttribute("studentList", student);
        return "students";
        }

        @GetMapping("/getStudent/{id}")
        public String getStudent(Model model, @PathVariable Long id){

            Student student = databaseAccess.getStudentBasedOnId(id);
            model.addAttribute("studentForm", student);
            return "student-details";
        }

}
