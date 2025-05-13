package veiculos.locadora.locaVeiculos.dto.motorista;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.usuario.Sexo;

import java.util.Date;

@Getter
@Setter
public class MotoristaRequestDto {
    private String nome;
    private Date dataNasc;
    private String cpf;
    private Sexo sexo;
    private String numeroCNH;
}
