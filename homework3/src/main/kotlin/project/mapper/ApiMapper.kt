package project.mapper

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import project.app.model.ApiUser
import project.models.User

@Mapper
interface ApiMapper {

    @Mappings(
        Mapping(source = "id", target = "id"),
        Mapping(source = "username", target = "username"),
        Mapping(source = "firstName", target = "firstName"),
        Mapping(source = "lastName", target = "lastName"),
        Mapping(source = "email", target = "email"),
        Mapping(source = "phone", target = "phone"),
    )
    fun toApiUser(value: User?): ApiUser?

    @InheritInverseConfiguration
    fun toUser(value: ApiUser?): User?
}