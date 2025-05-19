package veiculos.locadora.locaVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veiculos.locadora.locaVeiculos.dto.aluguel.AluguelRequestDto;
import veiculos.locadora.locaVeiculos.dto.aluguel.AluguelResponseDto;
import veiculos.locadora.locaVeiculos.entity.produto.Aluguel;
import veiculos.locadora.locaVeiculos.entity.produto.Carro;
import veiculos.locadora.locaVeiculos.exceptions.EntidadeNaoEncontradoException;
import veiculos.locadora.locaVeiculos.mapper.AluguelMapper;
import veiculos.locadora.locaVeiculos.repository.AluguelRepository;
import veiculos.locadora.locaVeiculos.repository.CarroRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository repository;

    @Autowired
    private CarroRepository carroRepository;

    private AluguelMapper mapper = new AluguelMapper();

    public AluguelResponseDto cadastrar(AluguelRequestDto request){
        Aluguel aluguel = mapper.toEntity(request);

        Carro carro = carroRepository.findById(request.getCarro().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradoException("Carro com o id %d não encontrado".formatted(request.getCarro().getId())));

        aluguel.setCarro(carro);

        LocalDate dataEntrega = aluguel.getDataEntrega().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate dataDevolucao = aluguel.getDataDevolucao().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        long diferenca = ChronoUnit.DAYS.between(dataEntrega, dataDevolucao);
        BigDecimal totalPedido = aluguel.getCarro().getValorDiaria().multiply(BigDecimal.valueOf(diferenca));

        aluguel.setValorTotal(totalPedido);
        aluguel.setDataPedido(Calendar.getInstance());

        return mapper.toDto(repository.save(aluguel));
    }

    public List<AluguelResponseDto> listar(){
        return mapper.toListDto(repository.findAll());
    }
}
