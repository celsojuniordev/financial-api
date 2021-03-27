package com.br.financialapi.domain.orm

import com.br.financialapi.domain.enums.LaunchStatus
import com.br.financialapi.domain.enums.LaunchType
import lombok.Getter
import lombok.Setter

import javax.persistence.*

@Getter @Setter
@Entity
class Launch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String description

    Integer month

    Integer year

    @ManyToOne(fetch = FetchType.LAZY)
    User user

    Long value

    Date dateCreated

    @Enumerated(EnumType.STRING)
    LaunchType type

    @Enumerated(EnumType.STRING)
    LaunchStatus status


}
