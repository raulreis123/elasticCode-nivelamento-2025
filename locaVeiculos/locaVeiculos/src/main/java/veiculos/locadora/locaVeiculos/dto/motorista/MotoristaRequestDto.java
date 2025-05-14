package veiculos.locadora.locaVeiculos.dto.motorista;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veiculos.locadora.locaVeiculos.entity.usuario.Sexo;

import java.util.Date;

@Getter
@Setter
public class MotoristaRequestDto {
    @NotBlank
    private String nome;
    @PastOrPresent
    private Date dataNasc;
    @NotNull
    private String cpf;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotBlank
    private String numeroCNH;
}
