package com.nick.kotlintest101.controller

import com.nick.kotlintest101.entity.User
import com.nick.kotlintest101.repository.UserRepository
import com.nick.kotlintest101.service.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerIntegrationTest {
    @Autowired
    lateinit var userRepository: UserRepository

    lateinit var userController: UserController

    lateinit var userService: UserService

    @BeforeAll
    fun initTestModule() {
        userService = UserService(userRepository)
        userController = UserController(userService)
    }

    @Test
    @Transactional
    fun `should be able to save`() {
        val user = User("JOHN SMITH", "john@smith.co.th")

        val createdUser = userController.create(user)

        val userAccountFound = userRepository.findOneById(createdUser.id!!)

        assertThat(userAccountFound == createdUser).isTrue()
    }

    @Test
    @Transactional
    fun `should get one`() {
        val user = User("JOHN SMITH", "john@smith.co.th")

        userController.create(user)

        val users = userRepository.findAll()

        assertThat(users.size).isEqualTo(1)
    }
}
