package com.br.financialapi.domain.repository

import com.br.financialapi.domain.orm.User
import org.springframework.data.repository.CrudRepository

interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email)

    User findByEmail(String email)

    User findByEmailAndPassword(String email, String password)

}