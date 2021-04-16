package com.br.financialapi.controller.dto

import com.br.financialapi.domain.enums.LaunchStatus
import com.br.financialapi.domain.enums.LaunchType
import com.br.financialapi.domain.orm.Launch
import lombok.Data

/**
 * @project financial-api
 * @author Celso Junior on 09/04/2021
 */

@Data
class LaunchDTO {

    Long id

    String description

    Integer month

    Integer year

    Long value

    Long userId

    String type

    String status

    Launch bindData(Launch launch) {
        launch.description = this.description
        launch.month = this.month
        launch.year = this.year
        launch.value = this.value
        this.type ? launch.type = LaunchType.valueOf(this.type) : null
        this.status ? launch.status = LaunchStatus.valueOf(this.status) : null

        launch
    }
}
