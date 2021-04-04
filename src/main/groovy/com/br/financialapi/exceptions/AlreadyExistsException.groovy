package com.br.financialapi.exceptions

/**
 * @project financial-api
 * @author Celso Junior on 31/03/2021
 */
class AlreadyExistsException extends RuntimeException {

    AlreadyExistsException(String message) {
        super(message)
    }
}
