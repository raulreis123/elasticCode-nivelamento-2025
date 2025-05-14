package veiculos.locadora.locaVeiculos.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.usuario.Sexo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponseDto {
    private Integer id;
    private String nome;
    private Sexo sexo;
}
