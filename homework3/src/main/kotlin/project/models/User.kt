package project.models

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "username")
    val username: String? = null,
    @Column(name = "firstName")
    val firstName: String? = null,
    @Column(name = "lastName")
    val lastName: String? = null,
    @Column(name = "email")
    val email: String? = null,
    @Column(name = "phone")
    val phone: String? = null,
)