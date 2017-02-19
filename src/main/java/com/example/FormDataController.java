package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Map;

@RestController
public class FormDataController {
    @PostMapping("/people")
    public String getRawPerson(@RequestBody String rawPerson) {
        return rawPerson;
    }

    @PostMapping(value = "/heroes", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getMapHeroParams(@RequestParam Map<String, String> heroData) {
        return heroData.toString();
    }

    @PostMapping(value = "/wrestlers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getWrestlerParams(WrestlerData wrestler) {
        return String.format("New wrestler named %s created with a finishing move called %s", wrestler.getName(), wrestler.getFinishingMove());
    }
}
