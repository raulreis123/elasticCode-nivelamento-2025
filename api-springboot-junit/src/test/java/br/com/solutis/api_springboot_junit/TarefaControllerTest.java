package br.com.solutis.api_springboot_junit;

import br.com.solutis.api_springboot_junit.dto.TarefaRequestDto;
import br.com.solutis.api_springboot_junit.dto.TarefaResponseDto;
import br.com.solutis.api_springboot_junit.model.Status;
import br.com.solutis.api_springboot_junit.service.TarefaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // Habilita Mvc para requisições HTTP
@Transactional // isso garante que cada teste seja revertido após a execução
public class TarefaControllerTest {
    @Autowired
    private MockMvc mockMvc; // Faz as requisições HTTP simuladas
    @Autowired
    private ObjectMapper objectMapper; // Converte objetos para JSON e vice-versa
    @Autowired
    private TarefaService tarefaService; // Inseri dados no banco de dados

    @Test
    void criarTarefa_comDadosValidos_retornarTarefa() throws Exception {
        // Prepara os dados para teste, no caso, o objeto que sera enviado
        TarefaRequestDto dto = new TarefaRequestDto();
        dto.setTitle("Teste1");
        dto.setDescricao("Teste com Junit");
        dto.setStatus(Status.valueOf("PENDENTE"));

        // Quem realiza o teste, primeira etapa são as configurações da operação HTTP, o tipo de dado trafegado, resposta esperada
        // e como os dados devem ser registrados
        mockMvc.perform(post("/tarefas") // Simula a requisição do tipo POST para o endpoint referênciado
                .contentType(MediaType.APPLICATION_JSON) // Indica o tipo de conteúdo trafegado pelo body (JSON)
                .content(objectMapper.writeValueAsString(dto))) // Converte o objeto para uma String com estrutura de JSON
                .andExpect(status().isCreated()) // Verifica se a resposta HTTP é ok, equivalente ao código 200
                .andExpect(jsonPath("$.title").value("Teste1")) // Referência o campo e o valor esperado para o mesmo
                .andExpect(jsonPath("$.descricao").value("Teste com Junit"))
                .andExpect(jsonPath("$.status").value("PENDENTE"));
    }

    @Test
    void atualizarTarefa_comDadosValidos_retornaTarefaAtualizada() throws Exception {
        TarefaRequestDto dtoInicial = new TarefaRequestDto();
        dtoInicial.setTitle("Tarefa Inicial");
        dtoInicial.setDescricao("Descrição Inicial");
        dtoInicial.setStatus(Status.PENDENTE);

        // Inserindo dados na base para teste
        var tarefaCriada = tarefaService.cadastrar(dtoInicial);

        // Criando o DTO para atualização
        TarefaRequestDto dtoAtualizado = new TarefaRequestDto();
        dtoAtualizado.setTitle("Tarefa Atualizada");
        dtoAtualizado.setDescricao("Descrição Atualizada");
        dtoAtualizado.setStatus(Status.EM_ANDAMENTO);

        // Executando teste para verificação de resposta
        mockMvc.perform(put("/tarefas/" + tarefaCriada.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dtoAtualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Tarefa Atualizada"))
                .andExpect(jsonPath("$.descricao").value("Descrição Atualizada"))
                .andExpect(jsonPath("$.status").value("EM_ANDAMENTO"));
    }

    @Test
    void deletarTarefa_comDadosValidos_naoRertornarTarefa() throws Exception{
        TarefaRequestDto dtoCadastro = new TarefaRequestDto();
        dtoCadastro.setTitle("Teste deleção");
        dtoCadastro.setDescricao("Teste");
        dtoCadastro.setStatus(Status.EM_ANDAMENTO);

        TarefaResponseDto dtoResposta = tarefaService.cadastrar(dtoCadastro);

        // Armazenando resultado em uma variável da biblioteca springframework
        ResultActions resultado = mockMvc.perform(delete("/tarefas/" + dtoResposta.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isNoContent());
    }

    @Test
    void buscarTarefaPorId_comDadosValidos_deveRetornarTarefa() throws Exception{
        TarefaRequestDto dtoCadastro = new TarefaRequestDto();
        dtoCadastro.setTitle("Teste buscar por id");
        dtoCadastro.setDescricao("Teste");
        dtoCadastro.setStatus(Status.EM_ANDAMENTO);

        TarefaResponseDto dtoResposta = tarefaService.cadastrar(dtoCadastro);

        mockMvc.perform(get("/tarefas/" + dtoResposta.getId())
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.title").value("Teste buscar por id"))
                    .andExpect(jsonPath("$.descricao").value("Teste"))
                    .andExpect(jsonPath("$.status").value("EM_ANDAMENTO"));
    }

    @Test
    void buscarTodasAsTarefas_deveRetornarTodasAsTarefas() throws Exception{
        TarefaRequestDto dto1 = new TarefaRequestDto();
        dto1.setTitle("tarefa 1");
        dto1.setDescricao("descricao 1");
        dto1.setStatus(Status.EM_ANDAMENTO);
        tarefaService.cadastrar(dto1);

        TarefaRequestDto dto2 = new TarefaRequestDto();
        dto2.setTitle("tarefa 2");
        dto2.setDescricao("descricao 2");
        dto2.setStatus(Status.EM_ANDAMENTO);
        tarefaService.cadastrar(dto2);

        mockMvc.perform(get("/tarefas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2)) // Representa a função, não referência
                .andExpect(jsonPath("$[0].title").value("tarefa 1"))
                .andExpect(jsonPath("$[0].descricao").value("descricao 1"))
                .andExpect(jsonPath("$[1].title").value("tarefa 2"))
                .andExpect(jsonPath("$[1].descricao").value("descricao 2"));
    }
}
