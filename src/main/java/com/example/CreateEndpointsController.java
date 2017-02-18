package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEndpointsController {
    @GetMapping("/createEndpoints")
        public String successfulGet() {
            return "Successful GET to /createEndpoints";
        }


    @PostMapping("/createEndpoints")
        public String successfulePost() {
            return "Successful POST to /createEndpoints";
        }


}
