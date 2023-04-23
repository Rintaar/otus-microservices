package project.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import project.models.User

interface JpaUserRepository : JpaRepository<User, Long>, UserRepository,
    JpaSpecificationExecutor<User> {
    override fun removeById(id: Long) = deleteById(id)

    override fun getById(id: Long) = findById(id).get()
}

