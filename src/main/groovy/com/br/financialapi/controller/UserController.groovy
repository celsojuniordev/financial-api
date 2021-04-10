package com.br.financialapi.controller

import com.br.financialapi.controller.dto.UserDTO
import com.br.financialapi.domain.orm.User
import com.br.financialapi.exceptions.BusinessRoleException
import com.br.financialapi.exceptions.AuthenticationException
import com.br.financialapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @project financial-api
 * @author Celso Junior on 04/04/2021
 */

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    UserService userService

    @PostMapping
    ResponseEntity save(@RequestBody UserDTO userDTO) {
        User user = new User(name: userDTO.name, email: userDTO.email, password: userDTO.password)

        try {
            userService.save(user)
            ResponseEntity.status(HttpStatus.CREATED).body(user)
        } catch(BusinessRoleException e) {
            ResponseEntity.badRequest().body(e.getMessage())
        }
    }

    @PostMapping("/authenticate")
    ResponseEntity authenticate(@RequestBody UserDTO userDTO) {
        try {
            ResponseEntity.ok(userService.authenticate(userDTO.email, userDTO.password))
        } catch(AuthenticationException e) {
            ResponseEntity.badRequest().body(e.getMessage())
        }
    }
}
