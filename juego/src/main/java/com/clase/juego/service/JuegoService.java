package com.clase.juego.service;

import com.clase.juego.model.JuegoSesion;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class JuegoService {

    private static final int MAX_INTENTOS = 7;
    private static final int MIN = 1;
    private static final int MAX = 100;

    private JuegoSesion sesionActual;

    public JuegoSesion nuevaPartida() {
        int secreto = new Random().nextInt(MAX - MIN + 1) + MIN;
        sesionActual = new JuegoSesion(secreto, MAX_INTENTOS);
        return sesionActual;
    }

    public JuegoSesion getSesion() {
        return sesionActual;
    }

    public String adivinar(int numero) {
        if (sesionActual == null || sesionActual.isTerminado()) return "SIN_JUEGO";

        sesionActual.setIntentos(sesionActual.getIntentos() + 1);
        int secreto = sesionActual.getNumeroSecreto();
        String pista;

        if (numero == secreto) {
            pista = "GANO";
            sesionActual.setGano(true);
            sesionActual.setTerminado(true);
        } else if (sesionActual.getIntentos() >= sesionActual.getMaxIntentos()) {
            pista = "PERDIO";
            sesionActual.setTerminado(true);
        } else {
            int diferencia = Math.abs(secreto - numero);
            if (diferencia <= 5)       pista = "MUY_CALIENTE";
            else if (diferencia <= 15) pista = "CALIENTE";
            else if (diferencia <= 30) pista = "TIBIO";
            else                       pista = "FRIO";
        }

        String emoji = switch (pista) {
            case "GANO"        -> "🎉";
            case "PERDIO"      -> "💀";
            case "MUY_CALIENTE"-> "🔥";
            case "CALIENTE"    -> "♨️";
            case "TIBIO"       -> "🌡️";
            case "FRIO"        -> "🧊";
            default            -> "❓";
        };

        sesionActual.agregarIntento("Intento " + sesionActual.getIntentos() + ": " + numero + " → " + emoji);
        return pista;
    }
}