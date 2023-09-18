package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("")
@Controller
public class routes {
    private static final Map<Integer, String> doctorDetails = new HashMap<>();

    static {
        doctorDetails.put(9, "Christopher Eccleston");
        doctorDetails.put(10, "David Tennant");
        doctorDetails.put(11, "Matt Smith");
        doctorDetails.put(12, "Peter Capaldi");
        doctorDetails.put(13, "Jodie Whittaker");
    }

    @GetMapping("/doctor/{number}")
    public ResponseEntity<String> doctor(@PathVariable int number) {
        if (number >= 9 && number <= 13) {
            String doctorName = doctorDetails.get(number);
            return new ResponseEntity<>("Number: " + number + ", Name: " + doctorName, HttpStatus.OK);
        } else if (number <= 8) {
            return ResponseEntity.status(HttpStatus.SEE_OTHER).body("Moved");
        } else {
            return new ResponseEntity<>("Url Not FOund " + number, HttpStatus.NOT_FOUND);
        }
    }
}
