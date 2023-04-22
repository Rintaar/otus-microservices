package project.jpa

import project.models.User

interface UserRepository {
    fun save(message: User): User
    fun removeById(id: Int)
    fun findById(id: Int): User
}