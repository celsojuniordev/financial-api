package com.br.financialapi.service.impl

import com.br.financialapi.domain.enums.LaunchStatus
import com.br.financialapi.domain.orm.Launch
import com.br.financialapi.domain.repository.LaunchRepository
import com.br.financialapi.exceptions.BusinessRoleException
import com.br.financialapi.service.LaunchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service

/**
 * @project financial-api
 * @author Celso Junior on 07/04/2021
 */

@Service
class LaunchServiceImpl implements LaunchService {

    @Autowired
    LaunchRepository launchRepository

    @Override
    Launch save(Launch launch) {
        validate(launch)
        launch.status = LaunchStatus.PENDENTE
        return launchRepository.save(launch)
    }

    @Override
    Launch update(Launch launch) {
        Objects.nonNull(launch.id)
        validate(launch)
        return launchRepository.save(launch)
    }

    @Override
    void delete(Launch launch) {
        Objects.nonNull(launch.id)
        launchRepository.delete(launch)
    }

    @Override
    List<Launch> findAll(Launch launchFilter) {
        Example example = Example.of(launchFilter,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING))
        return launchRepository.findAll(example)
    }

    @Override
    void updateStatus(Launch launch, LaunchStatus launchStatus) {
        launch.status = launchStatus
        update(launch)
    }

    @Override
    void validate(Launch launch) {

        if(!launch.description || launch.description.isBlank()) {
            throw new BusinessRoleException("Informe a descrição")
        }

        if(!launch.month || launch.month < 1 || launch.month > 12) {
            throw new BusinessRoleException("Informe um mês válido")
        }

        if(!launch.year || launch.year.toString().length() != 4) {
            throw new BusinessRoleException("Informe um ano valido")
        }

        if(!launch.user?.id) {
            throw new BusinessRoleException("Informe um usuário")
        }

        if(!launch.value || launch.value < 1) {
            throw new BusinessRoleException("Informe um valor válido")
        }

        if(!launch.type) {
            throw new BusinessRoleException("Informe um tipo de lançamento")
        }
    }
}
