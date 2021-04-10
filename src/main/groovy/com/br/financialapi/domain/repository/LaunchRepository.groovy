package com.br.financialapi.domain.repository

import com.br.financialapi.domain.orm.Launch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface LaunchRepository extends JpaRepository<Launch, Long> {

}