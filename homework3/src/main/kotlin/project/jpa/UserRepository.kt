package project.jpa

import project.models.User

interface UserRepository {
    fun save(message: User): User
    fun removeById(id: Long)
    fun getById(id: Long): User
}