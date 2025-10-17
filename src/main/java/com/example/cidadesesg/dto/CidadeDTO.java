package com.example.cidadesesg.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CidadeDTO {

    @NotBlank(message = "O nome da cidade é obrigatório.")
    private String nome;

    @NotBlank(message = "O estado é obrigatório.")
    private String estado;

    @NotNull(message = "A população é obrigatória.")
    @Min(value = 1, message = "A população deve ser maior que zero.")
    private Long populacao;

    @NotNull(message = "O índice ESG é obrigatório.")
    @DecimalMin(value = "0.0", message = "O índice ESG deve ser >= 0.")
    @DecimalMax(value = "10.0", message = "O índice ESG deve ser <= 10.")
    private Double indiceEsg;
}
