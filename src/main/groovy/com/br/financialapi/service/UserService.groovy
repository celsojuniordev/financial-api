package com.br.financialapi.service

import com.br.financialapi.domain.orm.User

/**
 * @project financial-api
 * @author Celso Junior on 31/03/2021
 */
interface UserService {

    User authenticate(String email, String senha)

    User save(User user)

    void validateEmail(String email)

    User findById(Long id)

}