package com.clase.calculadora.controller;

import com.clase.calculadora.model.*;
import com.clase.calculadora.service.CalculadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("form", new CalculadoraForm());
        model.addAttribute("historial", service.getHistorial());
        return "calculadora";
    }

    @PostMapping
    public String procesar(@Valid @ModelAttribute("form") CalculadoraForm form,
                           BindingResult errores, Model model) {
        model.addAttribute("historial", service.getHistorial());
        if (errores.hasErrors()) return "calculadora";

        var resultado = service.calcular(form.getNumeroA(), form.getNumeroB(), form.getOperacion());
        model.addAttribute("resultado", resultado);
        model.addAttribute("form", new CalculadoraForm());
        model.addAttribute("historial", service.getHistorial());
        return "calculadora";
    }
}