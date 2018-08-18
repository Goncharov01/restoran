package menu.restoran

import javax.persistence.*

@Entity
@Table(name = "app_user")
class User(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Long? = -1,

  @Column(name = "username")
  var username: String? = null,

  @Column(name = "password")
  // @JsonIgnore
  var password: String? = null,

  @Column(name = "first_name")
  var firstName: String? = null,

  @Column(name = "last_name")
  var lastName: String? = null,

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "user_role",
    joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
    inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
  )
  var roles: Collection<Role>? = null,
  @OneToMany(mappedBy = "user")
  var restaurants:List<Restaurant>? = null





) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as User

    if (id != other.id) return false
    if (username != other.username) return false
    if (password != other.password) return false
    if (firstName != other.firstName) return false
    if (lastName != other.lastName) return false
    if (roles != other.roles) return false
    if (restaurants != other.restaurants) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id?.hashCode() ?: 0
    result = 31 * result + (username?.hashCode() ?: 0)
    result = 31 * result + (password?.hashCode() ?: 0)
    result = 31 * result + (firstName?.hashCode() ?: 0)
    result = 31 * result + (lastName?.hashCode() ?: 0)
    result = 31 * result + (roles?.hashCode() ?: 0)
    result = 31 * result + (restaurants?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return "User(id=$id, username=$username, password=$password, firstName=$firstName, lastName=$lastName, roles=$roles, restaurants=$restaurants)"
  }
}