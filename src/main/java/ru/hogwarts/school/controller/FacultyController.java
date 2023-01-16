package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;


import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {



    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty addStudent(@RequestBody Faculty student) {
        return facultyService.addFaculty(student);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty student) {
        return facultyService.editFaculty(student);
    }
    @GetMapping("/filter")
    public Collection<Faculty> filterByAge(@RequestParam("color") String color) {
        return facultyService.filterByAge(color);
    }
}
