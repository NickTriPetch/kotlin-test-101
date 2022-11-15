package com.nick.kotlintest101.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.nick.kotlintest101.entity.User
import com.nick.kotlintest101.repository.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.ArgumentMatchers.any
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UserServiceUnitTest {
    @Mock
    lateinit var mockUserRepository: UserRepository

    @InjectMocks
    lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
//        mockUserRepository = Mockito.mock(UserRepository::class.java)

//        userService = UserService(mockUserRepository)
    }

    @Test
    fun `userRepositorySave should be called once`() {
        Mockito.`when`(mockUserRepository.save(any(User::class.java))).thenReturn(User("No care", "no@care.com"))

        userService.save(
            "whatever title",
            "whatever@email.com",
        )

        val userArgumentCaptor: ArgumentCaptor<User> = ArgumentCaptor.forClass(User::class.java)

        Mockito.verify(mockUserRepository).save(userArgumentCaptor.capture())
        val capturedUser = userArgumentCaptor.value

        println("============================================")
        println("> capturedUser")
        println(ObjectMapper().writeValueAsString(capturedUser))

        Mockito.verify(mockUserRepository, Mockito.times(1)).save(capturedUser)
    }
}