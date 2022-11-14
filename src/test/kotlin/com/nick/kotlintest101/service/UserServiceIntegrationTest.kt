package com.nick.kotlintest101.service

import com.nick.kotlintest101.controller.UserController
import com.nick.kotlintest101.entity.User
import com.nick.kotlintest101.repository.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceIntegrationTest {
    @Autowired
    lateinit var userRepository: UserRepository

    lateinit var userService: UserService

    @BeforeAll
    fun initTestModule() {
        userService = UserService(userRepository)
    }

    @Test
    @Transactional
    fun `should be able to save`() {
        val createdUser = userService.save(
            "JOHN SMITH", "john@smith.co.th"
        )

        val userAccountFound = userRepository.findOneById(createdUser.id!!)

        Assertions.assertThat(userAccountFound == createdUser).isTrue()
    }

    @Test
    @Transactional
    fun `should get one`() {
        userService.save(
            "JOHN SMITH", "john@smith.co.th"
        )

        val users = userRepository.findAll()

        Assertions.assertThat(users.size).isEqualTo(1)
    }
}