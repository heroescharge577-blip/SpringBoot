package com.clase.calculadora.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CalculadoraForm {

    @NotNull(message = "El primer número es obligatorio")
    private Double numeroA;

    @NotNull(message = "El segundo número es obligatorio")
    private Double numeroB;

    @NotBlank(message = "Debes elegir una operación")
    private String operacion;

    public Double getNumeroA() { return numeroA; }
    public void setNumeroA(Double numeroA) { this.numeroA = numeroA; }
    public Double getNumeroB() { return numeroB; }
    public void setNumeroB(Double numeroB) { this.numeroB = numeroB; }
    public String getOperacion() { return operacion; }
    public void setOperacion(String op) { this.operacion = op; }
}