package com.example.hammingcode.controllers;


import com.example.hammingcode.models.DTO.RandomNumberDTO;
import com.example.hammingcode.models.service.AliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alice")
public class AliceController {
    @Autowired
    AliceService aliceService;

    @GetMapping
    public String renderFormRandNum(@ModelAttribute RandomNumberDTO randomNumberDTO) {
        return "alice/index";
    }

    @PostMapping
    public String generateRandomNum(@ModelAttribute RandomNumberDTO randomNumberDTO, Model model) {
        int num = aliceService.generateRandomNumber(randomNumberDTO);
        model.addAttribute("num", num);
        model.addAttribute("binaryNum", aliceService.toBinary(num));
        model.addAttribute("m", aliceService.getHammingCode(aliceService.toBinary(num), randomNumberDTO.isWrong()));
        return "alice/index";
    }


}
