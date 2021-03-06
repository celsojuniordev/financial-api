package com.br.financialapi.service.impl

import com.br.financialapi.domain.orm.User
import com.br.financialapi.domain.repository.UserRepository
import com.br.financialapi.exceptions.BusinessRoleException
import com.br.financialapi.exceptions.AuthenticationException
import com.br.financialapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @project financial-api
 * @author Celso Junior on 31/03/2021
 */

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository

    @Override
    User authenticate(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password)
        if(!user) {
            throw new AuthenticationException("Email ou senha inválidos")
        }

        user
    }

    @Override
    User save(User user) {
        validateEmail(user.email)
        userRepository.save(user)
    }

    @Override
    void validateEmail(String email) {
        if(userRepository.existsByEmail(email)) {
            throw new BusinessRoleException("Email já existe")
        }
    }

    @Override
    User findById(Long id) {
        userRepository.findById(id).orElseThrow({ ->
            new BusinessRoleException("Usuário não encontrado") })
    }
}
