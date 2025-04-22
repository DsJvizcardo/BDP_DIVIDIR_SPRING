package com.example.calculadora_prueba.service;

import org.springframework.stereotype.Service; // Importa la anotación @Service para indicar que esta clase es un servicio

@Service // Marca la clase como un servicio Spring que puede ser inyectado como dependencia
public class calculadoraServiceService {

    // Método que realiza una resta entre dos valores Long
    public Long restar(Long a, Long b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("'a' y 'b' no pueden ser nulos.");
        }
        if (a.equals(b)) {
            throw new IllegalArgumentException("'a' no puede ser igual a 'b'.");
        }
        if (a < b) {
            throw new IllegalArgumentException("'a' no puede ser menor que 'b'.");
        }
        return a - b;
    }

    // Método que realiza una división entre dos valores Long
    public Long dividir(Long a, Long b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("'a' y 'b' no pueden ser nulos.");
        }
        if (b == 0) {
            throw new IllegalArgumentException("'b' no puede ser cero (división por cero no permitida).");
        }
        return a / b;
    }
}
