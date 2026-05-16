package com.clase.juego.model;

import java.util.ArrayList;
import java.util.List;

public class JuegoSesion {

    private int numeroSecreto;
    private int intentos;
    private int maxIntentos;
    private boolean terminado;
    private boolean gano;
    private List<String> historialIntentos;

    public JuegoSesion(int numeroSecreto, int maxIntentos) {
        this.numeroSecreto = numeroSecreto;
        this.maxIntentos = maxIntentos;
        this.intentos = 0;
        this.terminado = false;
        this.gano = false;
        this.historialIntentos = new ArrayList<>();
    }

    public int getNumeroSecreto() { return numeroSecreto; }
    public int getIntentos() { return intentos; }
    public void setIntentos(int intentos) { this.intentos = intentos; }
    public int getMaxIntentos() { return maxIntentos; }
    public boolean isTerminado() { return terminado; }
    public void setTerminado(boolean t) { this.terminado = t; }
    public boolean isGano() { return gano; }
    public void setGano(boolean gano) { this.gano = gano; }
    public List<String> getHistorialIntentos() { return historialIntentos; }
    public void agregarIntento(String intento) { this.historialIntentos.add(intento); }
    public int getIntentosRestantes() { return maxIntentos - intentos; }
}