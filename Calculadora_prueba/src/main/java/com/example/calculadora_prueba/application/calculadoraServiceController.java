package com.example.calculadora_prueba.application;

import com.example.calculadora_prueba.service.calculadoraServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que esta clase maneja peticiones HTTP
@RequestMapping("/calculadoraservice") // Ruta base: http://localhost:8080/calculadoraservice
public class calculadoraServiceController {

    private final calculadoraServiceService calculadoraServiceService;

    @Autowired
    public calculadoraServiceController(calculadoraServiceService calculadoraserviceService) {
        this.calculadoraServiceService = calculadoraserviceService;
    }

    // === Endpoints ===

    @GetMapping("/resta/{a}/{b}") // Ruta completa: /calculadoraservice/resta/5/3
    public ResponseEntity<?> restar(@PathVariable Long a, @PathVariable Long b) {
        try {
            Long resultado = calculadoraServiceService.restar(a, b); // Llama al método del servicio
            return ResponseEntity.ok(resultado); // Retorna el resultado con HTTP 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST) // Retorna error 400 si hay error de validación
                    .body("Error 400: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) // Cualquier otro error → 500
                    .body("Error 500: " + e.getMessage());
        }
    }

    @GetMapping("/dividir/{a}/{b}") // Ruta completa: /calculadoraservice/resta/5/3
    public ResponseEntity<?> dividir(@PathVariable Long a, @PathVariable Long b) {
        try {
            Long resultado = calculadoraServiceService.dividir(a, b); // Llama al método del servicio
            return ResponseEntity.ok(resultado); // Retorna el resultado con HTTP 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST) // Retorna error 400 si hay error de validación
                    .body("Error 400: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) // Cualquier otro error → 500
                    .body("Error 500: " + e.getMessage());
        }
    }


}
