package com.br.financialapi.domain.repository

import com.br.financialapi.domain.orm.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email)

    User findByEmail(String email)

    User findByEmailAndPassword(String email, String password)

}