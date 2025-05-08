package br.com.solutis.api_springboot_junit;

import br.com.solutis.api_springboot_junit.dto.TarefaRequestDto;
import br.com.solutis.api_springboot_junit.dto.TarefaResponseDto;
import br.com.solutis.api_springboot_junit.mapper.TarefaMapper;
import br.com.solutis.api_springboot_junit.model.Status;
import br.com.solutis.api_springboot_junit.model.Tarefa;
import br.com.solutis.api_springboot_junit.repository.TarefaRepository;
import br.com.solutis.api_springboot_junit.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {
    @Mock
    private TarefaRepository repository;

    @Mock
    private TarefaMapper mapper;

    // Injeta os mocks na instância, ou seja, as classes que TarefaService utiliza para realizar as operações
    @InjectMocks
    TarefaService tarefaService;

    // Objetos que serão utilizados nos testes
    private TarefaRequestDto requestDto;
    private TarefaResponseDto responseDto;
    private Tarefa tarefa;

    // Configuração de variáveis antes de utilização em testes
    @BeforeEach
    void setUp(){
        requestDto = new TarefaRequestDto();
        requestDto.setTitle("Teste request Mock");
        requestDto.setDescricao("Teste na request com mocks");
        requestDto.setStatus(Status.CONCLUIDA);

        responseDto = new TarefaResponseDto(1, "Teste request Mock",
                "Teste na response com mocks", Status.EM_ANDAMENTO.toString());

        tarefa = new Tarefa();
        tarefa.setTitle("Teste request Mock");
        tarefa.setDescricao("Teste na request com mocks");
        tarefa.setStatus(Status.CONCLUIDA);
    }

    @Test
    void criarTarefa_comDadosValidos_deveRetornarTarefaSalva(){
        // PREPARANDO AMBIENTE
        // Instrução / Retorno esperado
        when(mapper.toEntity(requestDto)).thenReturn(tarefa);
        when(repository.save(any(Tarefa.class))).thenReturn(tarefa);
        when(mapper.toDto(tarefa)).thenReturn(responseDto);

        // REALIZANDO AÇÃO
        TarefaResponseDto resposta = tarefaService.cadastrar(requestDto);

        // VERIFICAÇÃO DE RETORNO E ASSERÇÃO
        assertNotNull(resposta);
        assertEquals("Teste request Mock", resposta.getTitle());
        verify(repository, times(1)).save(tarefa);
        verify(mapper, times(1)).toEntity(requestDto);
        verify(mapper, times(1)).toDto(tarefa);
    }

    @Test
    void listarTarefas_comDadosValidos_deveRetornarTodasTarefas(){
        // AMBIENTE
        List<Tarefa> tarefas = List.of(
                new Tarefa(1, "Tarefa 1", "Descrição 1", Status.PENDENTE)
        );
        List<TarefaResponseDto> tarefasReturn = List.of(
                new TarefaResponseDto(1, "Tarefa 1", "Descrição 1", Status.PENDENTE.toString())
        );

        when(repository.findAll()).thenReturn(tarefas);
        when(mapper.toListDto(tarefas)).thenReturn(tarefasReturn);

        // AÇÃO
        List<TarefaResponseDto> tarefaResposta = tarefaService.listar();

        // Verificação de asserts
        assertNotNull(tarefaResposta);
        assertEquals("Tarefa 1", tarefaResposta.get(0).getTitle());
        assertEquals("Descrição 1", tarefaResposta.get(0).getDescricao());
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toListDto(tarefas);
    }

    @Test
    void deletarTarefa_comTarefaExistente_naoDeveRetornar(){
        // Ambiente
        int id = 1;
        when(repository.existsById(id)).thenReturn(true);

        // Ação
        tarefaService.deletar(id);

        // Verificação
        verify(repository, times(1)).existsById(id);
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void atualizarTarefa_comDadosValidos_deveRetornarTarefa(){
        // Ambiente
        int id = 1;
        TarefaRequestDto dto = new TarefaRequestDto("Tarefa 1", "Teste Tarefa", Status.EM_ANDAMENTO);
        Tarefa tarefaMock = new Tarefa(id, "Tarefa 1", "Teste Tarefa", Status.EM_ANDAMENTO);
        TarefaResponseDto tarefaMockResponse = new TarefaResponseDto(1, "Tarefa 1", "Teste Tarefa", Status.EM_ANDAMENTO.toString());

        when(mapper.toEntity(dto)).thenReturn(tarefaMock);
        when(repository.save(tarefaMock)).thenReturn(tarefaMock);
        when(mapper.toDto(tarefaMock)).thenReturn(tarefaMockResponse);

        // Ação
        TarefaResponseDto resposta = tarefaService.atualizar(id, dto);

        // Verificação
        assertNotNull(resposta);
        assertEquals("Tarefa 1", resposta.getTitle());
    }
}
