package com.example.hammingcode.models.service;

import org.springframework.stereotype.Service;

@Service
public class BobService {
    public int getWrongPosition(int[] m) {
        if (isWrong(m)){

        }
        return 0;
    }

    public boolean isWrong(int[] m) {
        return true;
    }

    public int[] repair(int[] m) {
        return m;
    }
}
