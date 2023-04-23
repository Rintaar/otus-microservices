package project.models

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "username")
    var username: String? = null,
    @Column(name = "firstName")
    var firstName: String? = null,
    @Column(name = "lastName")
    var lastName: String? = null,
    @Column(name = "email")
    var email: String? = null,
    @Column(name = "phone")
    var phone: String? = null,
)