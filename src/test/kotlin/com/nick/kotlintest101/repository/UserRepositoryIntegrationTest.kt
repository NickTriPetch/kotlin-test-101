package com.nick.kotlintest101.repository

import com.nick.kotlintest101.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
class UserRepositoryIntegrationTest {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    @Transactional
    fun `should be able to save`() {
        val user = User("JOHN SMITH", "john@smith.co.th")
        userRepository.save(user)
        val userAccountFound = userRepository.findOneById(user.id!!)

        assertThat(userAccountFound == user).isTrue()
    }

    @Test
    @Transactional
    fun `should get one`() {
        userRepository.save(User("JOHN SMITH", "john@smith.co.th"))

        val users = userRepository.findAll()

        assertThat(users.size).isEqualTo(1)
    }
}
