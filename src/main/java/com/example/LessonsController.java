package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController {
    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> list() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Lesson read(@PathVariable String id) {
        Long pathId = Long.parseLong(id);
        return this.repository.findOne(pathId);
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @PatchMapping("/{id}")
    public Lesson update(@PathVariable String id, @RequestBody Lesson lesson){
        this.repository.save(lesson);
        return lesson;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Long pathId = Long.parseLong(id);
        this.repository.delete(pathId);
    }

}
