package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PathVariableController {

    @GetMapping("/articles/{id}")
    public String getArticleId(@PathVariable String id) {
        return String.format("Article id is %s", id);
    }

    @GetMapping("/blogger/{bloggerId}/follower/{followerId}")
    public String getFollowerId(@PathVariable Map pathVariables) {
        return pathVariables.toString();
    }

    @GetMapping("/game/{gameId}/studio/{studioId}")
    public String getStudioForGame (GameInfo game) {
        return String.format("Game Id is %d; Studio Id is %d", game.getGameId(), game.getStudioId());
    }
}
