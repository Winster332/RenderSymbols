package com.company;

import com.company.example.App;

public class Main {
    public static void log(String... texts) {
        System.out.print("Log: ");
        for (String text : texts) {
            System.out.print(text);
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        long time = System.nanoTime();

        new App();

        time = System.nanoTime() - time;
        log("nano time: " + (time));
    }
}
