package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class QuerystringController {
    @GetMapping("/books")
    public String getTitleParam(@RequestParam String title) {
        return String.format("The title is: %s", title);
    }

    @GetMapping("/movies")
    public String getMovieInfo(@RequestParam Map movieInfo) {
        return movieInfo.toString();
    }

    @GetMapping("/comics")
    public String getComicInfo(ComicInfo comicInfo) {
        return String.format("%s by %s", comicInfo.getTitle(), comicInfo.getAuthor());
    }
}
