package com.br.financialapi.controller

import com.br.financialapi.controller.dto.LaunchDTO
import com.br.financialapi.domain.orm.Launch
import com.br.financialapi.domain.orm.User
import com.br.financialapi.exceptions.BusinessRoleException
import com.br.financialapi.service.LaunchService
import com.br.financialapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @project financial-api
 * @author Celso Junior on 09/04/2021
 */

@RestController
@RequestMapping("/api/launchs")
class LaunchController {

    @Autowired
    LaunchService launchService

    @Autowired
    UserService userService

    @PostMapping
    ResponseEntity save(@RequestBody LaunchDTO launchDTO) {

        try {
            User user = userService.findById(launchDTO.userId)

            Launch launch = new Launch(user: user)
            launchDTO.bindData(launch)

            launchService.save(launch)
            ResponseEntity.status(HttpStatus.CREATED).body(launch)
        } catch (BusinessRoleException e) {
            return ResponseEntity.badRequest().body(e.message)
        }
    }

    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable("id") Long id, @RequestBody LaunchDTO launchDTO) {
        try {
            Launch launch = launchService.findById(id)
            launchDTO.bindData(launch)

            launchService.update(launch)
            ResponseEntity.ok(launch)
        } catch(BusinessRoleException e) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            Launch launch = launchService.findById(id)
            launchService.delete(launch)

            ResponseEntity.noContent().build()
        } catch(BusinessRoleException e) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping
    ResponseEntity find(@RequestParam(value = "description", required = false) String description,
                        @RequestParam(value = "month", required = false) Integer month,
                        @RequestParam(value = "year", required = false) Integer year,
                        @RequestParam("userId") Long userId) {

        try {
            User user = userService.findById(userId)
            Launch launchFilter = new Launch(user: user)
            launchFilter.description = description
            launchFilter.month = month
            launchFilter.year = year

            ResponseEntity.ok(launchService.findAll(launchFilter))
        } catch(BusinessRoleException e) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @PutMapping("/{id}/status")
    ResponseEntity updateStatus(@PathVariable Long id, @RequestBody LaunchDTO launchDTO) {
        try {
            Launch launch = launchService.findById(id)
            launchDTO.bindData(launch)

            launchService.update(launch)
            ResponseEntity.ok(launch)
        } catch(BusinessRoleException e) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}
