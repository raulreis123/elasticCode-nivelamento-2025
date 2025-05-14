package veiculos.locadora.locaVeiculos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeInvalidaException extends RuntimeException {
    public EntidadeInvalidaException(String message) {
        super(message);
    }
}
