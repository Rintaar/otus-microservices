package project.service

import org.mapstruct.factory.Mappers
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import project.app.model.ApiError
import project.app.model.ApiUser
import project.app.server.UserApi
import project.jpa.UserRepository
import project.mapper.ApiMapper

@RestController
class RestService(
    private val repository: UserRepository
) : UserApi {
    protected val mapper: ApiMapper = Mappers.getMapper(ApiMapper::class.java)

    override fun createUser(apiUser: ApiUser?): ResponseEntity<Void> {
        return try {
            repository.save(mapper.toUser(apiUser)!!)
            ResponseEntity(HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    override fun deleteUser(userId: Long?): ResponseEntity<Void> {
        return try {
            repository.removeById(userId?.toInt()!!)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: Exception) {
            val error = ApiError()
            error.code = HttpStatus.BAD_REQUEST.value()
            error.message = e.localizedMessage
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    override fun findUserById(userId: Long?): ResponseEntity<ApiUser> {
        return try {
            ResponseEntity.ok(mapper.toApiUser(repository.findById(userId?.toInt()!!)))

        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    override fun updateUser(userId: Long?, apiUser: ApiUser?): ResponseEntity<Void> {
        return try {
            val oldUser = repository.findById(userId?.toInt()!!)
            repository.save(
                oldUser.copy(
                    username = if (!apiUser?.username.isNullOrEmpty()) apiUser?.username else oldUser.username,
                    firstName = if (!apiUser?.firstName.isNullOrEmpty()) apiUser?.firstName else oldUser.firstName,
                    lastName = if (!apiUser?.lastName.isNullOrEmpty()) apiUser?.lastName else oldUser.lastName,
                    email = if (!apiUser?.email.isNullOrEmpty()) apiUser?.email else oldUser.email,
                    phone = if (!apiUser?.phone.isNullOrEmpty()) apiUser?.phone else oldUser.phone,
                )
            )
            ResponseEntity(HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }


}