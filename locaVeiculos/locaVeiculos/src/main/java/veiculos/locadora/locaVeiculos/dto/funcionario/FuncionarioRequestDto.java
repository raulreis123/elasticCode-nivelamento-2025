package veiculos.locadora.locaVeiculos.dto.funcionario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.usuario.Sexo;

import java.util.Date;

@Getter
@Setter
public class FuncionarioRequestDto {
    @NotBlank
    private String nome;
    @PastOrPresent
    private Date dataNasc;
    @NotBlank
    private String cpf;
    @Email
    @NotBlank
    private String email;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotBlank
    private String matricula;
}
