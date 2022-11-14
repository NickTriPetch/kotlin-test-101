package com.nick.kotlintest101.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_t2h")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(length = 254, unique = true)
    var title: String? = null

    @Column(length = 254, unique = true)
    var email: String? = null

    constructor(
        title: String,
        email: String,
    ) {
        this.title = title
        this.email = email
    }
}