package br.com.solutis.api_springboot_junit.dto;

import br.com.solutis.api_springboot_junit.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TarefaRequestDto {
    public TarefaRequestDto(String title, String descricao, Status status) {
        this.title = title;
        this.descricao = descricao;
        this.status = status;
    }

    public TarefaRequestDto(){}

    @NotBlank
    private String title;

    @NotBlank
    private String descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
