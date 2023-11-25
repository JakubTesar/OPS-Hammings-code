package com.example.hammingcode.controllers;

import com.example.hammingcode.models.DTO.BobDTO;
import com.example.hammingcode.models.DTO.RandomNumberDTO;
import com.example.hammingcode.models.service.AliceService;
import com.example.hammingcode.models.service.BobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/bob")
public class BobController {

        @Autowired
        BobService bobService;

        @GetMapping
        public String renderFormInput(@ModelAttribute BobDTO bobDTO) {
            return "bob/index";
        }

        @PostMapping
        public String generateAnswer(@ModelAttribute BobDTO bobDTO, Model model) {
            String[] mS = bobDTO.getInput().split("");
            int[] m = new int[mS.length];
            for (int i = 0; i < mS.length; i++) {
                m[i] = Integer.parseInt(mS[i]);
            }
            model.addAttribute("input", bobDTO);
            model.addAttribute("wrongP", bobService.getWrongPosition(m));
            model.addAttribute("isWrong", bobService.isWrong(m));
            model.addAttribute("repaired", bobService.repair(m));
            return "bob/index";
        }

}
