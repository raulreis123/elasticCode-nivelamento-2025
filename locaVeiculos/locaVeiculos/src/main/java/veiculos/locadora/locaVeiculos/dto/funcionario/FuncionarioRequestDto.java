package veiculos.locadora.locaVeiculos.dto.funcionario;

import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.usuario.Sexo;

import java.util.Date;

@Getter
@Setter
public class FuncionarioRequestDto {
    private String nome;
    private Date dataNasc;
    private String cpf;
    private Sexo sexo;
    private String matricula;
}
