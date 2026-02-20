package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Services.CourseService;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
}
