package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "First Home";
    }
    @GetMapping("/product")
    public String product(){
        return "Product page";
    }
    @PostMapping("/create")
    public String addProduct(){
        return "Product page created";
    }
    @DeleteMapping("/delete")
    public String deleteProduct(){
        return "Product page deleted";
    }
}
