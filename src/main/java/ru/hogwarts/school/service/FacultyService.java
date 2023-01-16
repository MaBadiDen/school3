package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> facultyes= new HashMap<>();
    private long lastId = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultyes.put(lastId, faculty);
        return faculty;
    }

    public Faculty getFaculty(long id) {
        return facultyes.get(id);
    }

    public Faculty deleteFaculty(long id) {
        return facultyes.remove(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        facultyes.put(faculty.getId(), faculty);
        return faculty;
    }

    public Collection<Faculty> filterByAge(String color) {
        return facultyes.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
