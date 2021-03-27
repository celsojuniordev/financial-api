package com.br.financialapi.domain.repository

import com.br.financialapi.domain.orm.Launch
import org.springframework.data.repository.CrudRepository

interface LaunchRepository extends CrudRepository<Launch, Long> {

}