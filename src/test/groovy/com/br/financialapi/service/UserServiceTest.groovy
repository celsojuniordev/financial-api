package com.br.financialapi.service

import com.br.financialapi.domain.orm.User
import com.br.financialapi.domain.repository.UserRepository
import com.br.financialapi.exceptions.AlreadyExistsException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author Celso Junior on 01/04/2021
 * @project financial-api
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    UserService userService

    @Autowired
    UserRepository userRepository

    @Test
    void authenticate() {
    }

    @Test
    void save() {

    }

    @Test()
    void validateEmail() {

        userService.validateEmail("teste@email.com")
    }

    @Test()
    void validateEmailError() {
        User user = createUser()
        userRepository.save(user)

        Assertions.assertThrows(AlreadyExistsException.class, {
            userService.validateEmail("teste@email.com")
        });
    }

    static User createUser() {
        new User(email: "teste@email.com", name: "user")
    }
}