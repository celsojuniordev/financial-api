package com.br.financialapi.domain.repository

import com.br.financialapi.domain.orm.User
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

/**
 * @project financial-api
 * @author Celso Junior on 31/03/2021
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository

    @Autowired
    TestEntityManager entityManager

    @Test
    void checkEmailAlreadyExistsTrueTest() {

        User user = createUser()
        entityManager.persist(user)

        boolean result = userRepository.existsByEmail(user.email)

        Assertions.assertThat(result).isTrue()
    }

    @Test
    void checkEmailAlreadyExistsFalseTest() {

        User user = createUser()
        entityManager.persist(user)

        boolean result = userRepository.existsByEmail("email1@test")

        Assertions.assertThat(result).isFalse()
    }

    @Test
    void findUserByEmail() {
        User user = createUser()
        entityManager.persist(user)

        User result = userRepository.findByEmail("email1@test")

        Assertions.assertThat(result)
    }

    static User createUser() {
        new User(email: "email@test", name: "user")

    }
}
