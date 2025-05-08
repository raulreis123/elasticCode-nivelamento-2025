package br.com.solutis.api_springboot_junit.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tarefa {
    public Tarefa() {
    }

    public Tarefa(Integer id, String title, String descricao, Status status) {
        this.id = id;
        this.title = title;
        this.descricao = descricao;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
}
