package veiculos.locadora.locaVeiculos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* Indica ao Spring a classe controladora que captura as exceptions, ou seja,
 ControllerAdvice é o controller e o Rest indica retorno direto no body da resposta */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Define um método para tratar exceções específicas
    @ExceptionHandler(EntidadeNaoEncontradoException.class)
    // ResponseEntity indica a reposta da requisição e o tipo de retorno, no caso String
    // O Spring consome esse método automaticamente (bean)
    // bean é uma classe gerenciada pelo spring, ou seja, o spring cuida do seu ciclo de vida
    public ResponseEntity<String> handleEntidadeNaoEncontrada(EntidadeNaoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
