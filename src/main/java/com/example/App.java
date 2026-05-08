package com.example;

public class App {

    public static void main(String[] args) {

        System.out.println("DevOps CI/CD Pipeline Running Successfully");

        while(true) {
            try {
                Thread.sleep(5000);
                System.out.println("Application Running...");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
