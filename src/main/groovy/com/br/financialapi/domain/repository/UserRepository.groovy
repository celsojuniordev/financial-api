package com.br.financialapi.domain.repository

import com.br.financialapi.domain.orm.User
import org.springframework.data.repository.CrudRepository

interface UserRepository extends CrudRepository<User, Long> {
}