package com.example.tdl.dummypackage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/local")
public class PublicController {

    @GetMapping("/public")
    public ResponseEntity<String> firstGet(){

        return ResponseEntity.ok("success from public!");
    }
}
