package project.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import project.models.User

interface JpaUserRepository : JpaRepository<User, Int>, UserRepository,
    JpaSpecificationExecutor<User> {
    override fun removeById(id: Int) = deleteById(id)
}

