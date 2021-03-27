package com.br.financialapi.domain.orm

import lombok.Getter
import lombok.Setter

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Getter @Setter
@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    String email

    String password

}
