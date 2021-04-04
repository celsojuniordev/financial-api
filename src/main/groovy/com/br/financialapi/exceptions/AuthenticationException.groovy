package com.br.financialapi.exceptions

/**
 * @project financial-api
 * @author Celso Junior on 31/03/2021
 */
class AuthenticationException extends RuntimeException {

    AuthenticationException(String message) {
        super(message)
    }
}
