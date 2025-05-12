package veiculos.locadora.locaVeiculos.entity.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    private Fabricante fabricante;
    // Modelo é a composição de carro, ou seja carro não existe sem modelo
    // Um modelo pode ter nenhum ou varios carros
    // Um modelo pode ter apenas uma fabricante
}
