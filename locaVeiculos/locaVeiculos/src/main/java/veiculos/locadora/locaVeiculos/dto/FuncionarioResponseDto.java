package veiculos.locadora.locaVeiculos.dto;

import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.usuario.Sexo;

@Getter
@Setter
public class FuncionarioResponseDto {
    private Integer id;
    private String nome;
    private Sexo sexo;
}
