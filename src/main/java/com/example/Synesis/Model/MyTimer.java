package com.example.Synesis.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
public class MyTimer extends TimerTask {
    @Autowired
    SaxMyParser parser;

    @Override
    public void run() {
        System.out.println("Старт Таймера");
        parser.parse();
    }
}
