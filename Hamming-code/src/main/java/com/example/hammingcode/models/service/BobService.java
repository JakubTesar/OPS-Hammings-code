package com.example.hammingcode.models.service;

import org.springframework.stereotype.Service;

@Service
public class BobService {
    public int getWrongPosition(int[] m) {
        int sum = 0;
        if (isWrong(m)) {
            if (((m[4] + 1) % 2) == ((m[0] + m[1] + m[3]) % 2)) sum += 1;
            if (((m[5] + 1) % 2) == ((m[0] + m[2] + m[3]) % 2)) sum += 2;
            if (((m[6] + 1) % 2) == ((m[1] + m[2] + m[3]) % 2)) sum += 4;
            if (sum == 3) return 1;
            if (sum == 5) return 2;
            if (sum == 6) return 3;
            if (sum == 7) return 4;
            if (sum == 1) return 5;
            if (sum == 2) return 6;
            if (sum == 4) return 7;
        }
        return 0;
    }

    public boolean isWrong(int[] m) {
        if (m[4] != ((m[0] + m[1] + m[3]) % 2)) return true;
        if (m[5] != ((m[0] + m[2] + m[3]) % 2)) return true;
        if (m[6] != ((m[1] + m[2] + m[3]) % 2)) return true;
        return false;
    }

    public int[] repair(int[] m) {
        if (isWrong(m)) {
            m[getWrongPosition(m)-1] = ((m[getWrongPosition(m)-1] + 1) % 2);
            return m;
        } else return m;
    }

    public int getOriginalNumber(int[] m){
        int[] mR = repair(m);
        String a = "";
        for (int i = 0; i < mR.length-3; i++) a += mR[i];
        return Integer.parseInt(a,2);
    }
}
