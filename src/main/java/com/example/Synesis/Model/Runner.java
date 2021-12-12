package com.example.Synesis.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    MyTimer myTimer;
    @Override
    public void run(String... args) throws Exception {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(myTimer, 0, 30 * 60000);
    }
}
