package com.nick.kotlintest101.service

import com.nick.kotlintest101.entity.User
import com.nick.kotlintest101.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun save(
        title: String,
        email: String,
    ): User {
        return userRepository.save(User(
            title = title,
            email = email,
        ))
    }

    fun getOneById(id: Long) = userRepository.findOneById(id)
}
