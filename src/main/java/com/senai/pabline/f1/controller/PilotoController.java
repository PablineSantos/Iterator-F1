package com.senai.pabline.f1.controller;

import org.springframework.ui.Model;
import com.senai.pabline.f1.service.PilotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotoController {

    private final PilotoService pilotoService;

    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @GetMapping("/")
    public String carregarPaginaInicial() {
        return "index";
    }

    @GetMapping("/pilotos")
    public String exibirPilotos(@RequestParam String estruturaSelecionada, Model model) throws Exception {

        model.addAttribute("pilotos", pilotoService.listarPilotos(estruturaSelecionada));

        model.addAttribute("estruturaSelecionada", estruturaSelecionada);

        return "pilotos";
    }
}