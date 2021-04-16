package com.br.financialapi.service

import com.br.financialapi.domain.enums.LaunchStatus
import com.br.financialapi.domain.orm.Launch

/**
 * @project financial-api
 * @author Celso Junior on 07/04/2021
 */
interface LaunchService {

    Launch save(Launch launch)

    Launch update(Launch launch)

    void delete(Launch launch)

    List<Launch> findAll(Launch launchFilter)

    void updateStatus(Launch launch, LaunchStatus launchStatus)

    void validate(Launch launch)

    Launch findById(Long id)

    Long getBalanceByUser(Long id)

}