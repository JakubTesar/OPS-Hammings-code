package com.example.hammingcode.models.service;

import com.example.hammingcode.models.DTO.RandomNumberDTO;
import org.springframework.stereotype.Service;

@Service
public class AliceService {

    public int generateRandomNumber(RandomNumberDTO randomNumberDTO) {
        return (int) Math.floor(Math.random() * (randomNumberDTO.getMax() - randomNumberDTO.getMin() + 1) + randomNumberDTO.getMin());
    }

    public String toBinary(int num) {
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(num));
        while (bin.length() < 4) bin.insert(0, "0");
        return bin.toString();
    }

    public int[] getHammingCode(String num, boolean isWrong) {
        int[] m = new int[7];
        String[] numSplit = num.split("");
        for (int i = numSplit.length - 1; i >= 0; i--) {
            m[i] = Integer.parseInt(numSplit[i]);
        }
        m[4] = (m[0] + m[1] + m[3]) % 2;
        m[5] = (m[0] + m[2] + m[3]) % 2;
        m[6] = (m[1] + m[2] + m[3]) % 2;

        if (isWrong) m[(int) (Math.random() * 7)] = (m[(int) (Math.random() * 7)] + 1) % 2;
        return m;
    }

}
