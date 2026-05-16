package com.clase.juego.controller;

import com.clase.juego.model.JuegoForm;
import com.clase.juego.model.JuegoSesion;
import com.clase.juego.service.JuegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/juego")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @GetMapping
    public String mostrar(Model model) {
        model.addAttribute("sesion", juegoService.getSesion());
        model.addAttribute("form", new JuegoForm());
        return "juego";
    }

    @GetMapping("/nuevo")
    public String nuevaPartida() {
        juegoService.nuevaPartida();
        return "redirect:/juego";
    }

    @PostMapping("/adivinar")
    public String adivinar(@Valid @ModelAttribute("form") JuegoForm form,
                           BindingResult errores, Model model) {
        if (errores.hasErrors()) {
            model.addAttribute("sesion", juegoService.getSesion());
            return "juego";
        }

        String pista = juegoService.adivinar(form.getNumero());
        model.addAttribute("pista", pista);
        model.addAttribute("intento", form.getNumero());
        model.addAttribute("sesion", juegoService.getSesion());
        model.addAttribute("form", new JuegoForm());
        return "juego";
    }
}