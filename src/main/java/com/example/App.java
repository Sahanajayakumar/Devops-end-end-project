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
    public String home(@RequestParam(required = false) String result) {
        return "<html><body style='text-align:center; font-family:sans-serif; padding-top:50px;'>" +
               "<h1>DevOps Calculator</h1>" +
               "<form action='/calculate' method='get' style='display:inline-block; border:1px solid #ccc; padding:20px; border-radius:10px;'>" +
               "  <input type='number' name='a' placeholder='First Number' required style='padding:10px; margin:5px;'><br>" +
               "  <input type='number' name='b' placeholder='Second Number' required style='padding:10px; margin:5px;'><br><br>" +
               "  <button name='op' value='add'>Add (+)</button> " +
               "  <button name='op' value='sub'>Sub (-)</button> " +
               "  <button name='op' value='mul'>Mul (*)</button> " +
               "  <button name='op' value='div'>Div (/)</button>" +
               "</form>" +
               (result != null ? "<h2 style='color:blue;'>Result: " + result + "</h2>" : "") +
               "</body></html>";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int a, @RequestParam int b, @RequestParam String op) {
        String res;
        if (op.equals("add")) res = String.valueOf(a + b);
        else if (op.equals("sub")) res = String.valueOf(a - b);
        else if (op.equals("mul")) res = String.valueOf(a * b);
        else if (op.equals("div")) res = (b != 0) ? String.format("%.2f", (double)a / b) : "Error: Div by Zero";
        else res = "Invalid Operation";
        return home(res);
    }
}        if (op.equals("add")) res = String.valueOf(a + b);
        else if (op.equals("sub")) res = String.valueOf(a - b);
        else if (op.equals("mul")) res = String.valueOf(a * b);
        else if (op.equals("div")) res = (b != 0) ? String.format("%.2f", (double)a / b) : "Error: Div by Zero";
        else res = "Invalid Operation";
        
        // Redirect back to home with the result
        return home(res);
    }
}    }

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
