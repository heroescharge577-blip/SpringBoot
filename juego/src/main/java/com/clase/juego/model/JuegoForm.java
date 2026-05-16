package com.clase.juego.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class JuegoForm {

    @NotNull(message = "Debes ingresar un número")
    @Min(value = 1, message = "El número debe ser mayor o igual a 1")
    @Max(value = 100, message = "El número debe ser menor o igual a 100")
    private Integer numero;

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
}