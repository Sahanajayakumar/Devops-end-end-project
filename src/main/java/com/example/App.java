package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the DevOps Calculator! Use /add, /sub, /mul, or /div?a=10&b=5";
    }

    @GetMapping("/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        return String.format("%d + %d = %d", a, b, (a + b));
    }

    @GetMapping("/sub")
    public String sub(@RequestParam int a, @RequestParam int b) {
        return String.format("%d - %d = %d", a, b, (a - b));
    }

    @GetMapping("/mul")
    public String mul(@RequestParam int a, @RequestParam int b) {
        return String.format("%d * %d = %d", a, b, (a * b));
    }

    @GetMapping("/div")
    public String div(@RequestParam int a, @RequestParam int b) {
        if (b == 0) return "Error: Cannot divide by zero!";
        return String.format("%d / %d = %.2f", a, b, (double) a / b);
    }
}
