package br.com.solutis.api_springboot_junit.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TarefaResponseDto {
    private Integer id;
    private String title;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private String status;
}
