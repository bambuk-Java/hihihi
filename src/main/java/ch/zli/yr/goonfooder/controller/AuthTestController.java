package ch.zli.yr.goonfooder.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/test")
public class AuthTestController {

    @GetMapping
    public String test() {
        return "OK";
    }
}
