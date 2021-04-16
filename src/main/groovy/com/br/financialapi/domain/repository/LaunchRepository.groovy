package com.br.financialapi.domain.repository

import com.br.financialapi.domain.enums.LaunchType
import com.br.financialapi.domain.orm.Launch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface LaunchRepository extends JpaRepository<Launch, Long> {

    @Query(value = """SELECT SUM(l.value) 
                    FROM Launch l JOIN l.user u 
                    WHERE u.id = :userId
                    AND l.type = :type 
                    GROUP BY u""")
    Long getBalanceByUser(@Param("userId") Long userId, @Param("type") LaunchType type)
}