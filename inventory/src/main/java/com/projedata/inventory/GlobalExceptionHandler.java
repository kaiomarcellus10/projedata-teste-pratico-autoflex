package com.projedata.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleProdutoNaoEncontrado(
            ProdutoNaoEncontradoException ex) {

        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ProductWithoutMaterialsException.class)
    public ResponseEntity<Map<String, Object>> handleProductWithoutMaterials(
            ProductWithoutMaterialsException ex) {

        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientStock(
            InsufficientStockException ex) {

        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now().toString());
        error.put("status", 400);
        error.put("error", "Validation Error");

        Map<String, String> fields = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> fields.put(e.getField(), e.getDefaultMessage()));

        error.put("campos", fields);

        return ResponseEntity.badRequest().body(error);
    }

    private ResponseEntity<Map<String, Object>> buildError(
            HttpStatus status, String message) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", Instant.now().toString());
        error.put("status", status.value());
        error.put("error", status.getReasonPhrase());
        error.put("message", message);

        return ResponseEntity.status(status).body(error);
    }
}
