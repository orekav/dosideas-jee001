package com.dosideas.controller;

import com.dosideas.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaisController {

    @Autowired
    private PaisService paisService;

    @RequestMapping("/paises")
    public String paises(Model model) {
        model.addAttribute("paises", paisService.buscarTodos());
        return "pais";
    }

}
