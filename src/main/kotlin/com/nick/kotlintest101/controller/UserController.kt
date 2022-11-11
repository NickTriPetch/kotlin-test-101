package com.nick.kotlintest101.controller

import com.nick.kotlintest101.entity.User
import com.nick.kotlintest101.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService,
) {
    @PostMapping(
        path = ["/"],
        consumes = ["application/json"],
        produces = ["application/json"],
    )
    fun create(@RequestBody user: User): User {
        return userService.save(
            title = user.title!!,
            email = user.email!!,
        )
    }

    @GetMapping(
        path = ["/{id}"],
        produces = ["application/json"],
    )
    fun getOne(@PathVariable(value = "id") id: Long) = userService.getOneById(id)
}
