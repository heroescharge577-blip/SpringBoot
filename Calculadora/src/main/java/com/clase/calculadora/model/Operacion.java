package com.clase.calculadora.model;

public class Operacion {

    private long id;
    private double numeroA;
    private double numeroB;
    private String tipo;
    private double resultado;
    private String error;

    public Operacion() {}

    public Operacion(long id, double a, double b, String tipo, double resultado) {
        this.id = id;
        this.numeroA = a;
        this.numeroB = b;
        this.tipo = tipo;
        this.resultado = resultado;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public double getNumeroA() { return numeroA; }
    public void setNumeroA(double numeroA) { this.numeroA = numeroA; }
    public double getNumeroB() { return numeroB; }
    public void setNumeroB(double numeroB) { this.numeroB = numeroB; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getResultado() { return resultado; }
    public void setResultado(double resultado) { this.resultado = resultado; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}