package com.nick.kotlintest101.repository

import com.nick.kotlintest101.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findOneById(id: Long): User
}
