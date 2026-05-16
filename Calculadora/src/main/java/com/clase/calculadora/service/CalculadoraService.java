package com.clase.calculadora.service;

import com.clase.calculadora.model.Operacion;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CalculadoraService {

    private final List<Operacion> historial = new ArrayList<>();
    private long contador = 1;

    public Operacion calcular(double a, double b, String op) {
        Operacion o = new Operacion();
        o.setId(contador++);
        o.setNumeroA(a);
        o.setNumeroB(b);
        o.setTipo(op);

        switch (op) {
            case "suma"           -> o.setResultado(a + b);
            case "resta"          -> o.setResultado(a - b);
            case "multiplicacion" -> o.setResultado(a * b);
            case "division" -> {
                if (b == 0) o.setError("No se puede dividir entre cero");
                else o.setResultado(a / b);
            }
            default -> o.setError("Operación desconocida: " + op);
        }

        historial.add(o);
        return o;
    }

    public List<Operacion> getHistorial() {
        return Collections.unmodifiableList(historial);
    }
}