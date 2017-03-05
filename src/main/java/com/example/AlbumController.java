package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumRepository repository;

    public AlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Album> list() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Album create(@RequestBody Album album) {
        this.repository.save(album);
        return album;
    }

}
