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
        return "<h1>Welcome to the DevOps Calculator!</h1>" +
               "<p>Use the following endpoints:</p>" +
               "<ul>" +
               "<li>/add?a=10&b=5</li>" +
               "<li>/sub?a=10&b=5</li>" +
               "<li>/mul?a=10&b=5</li>" +
               "<li>/div?a=10&b=5</li>" +
               "</ul>";
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
        if (b == 0) return "Error: You can't divide by zero in a DevOps pipeline (or anywhere else)!";
        return String.format("%d / %d = %.2f", a, b, (double) a / b);
    }
}
