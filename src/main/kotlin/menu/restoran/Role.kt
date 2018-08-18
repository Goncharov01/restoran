package menu.restoran

import javax.persistence.*

@Entity
@Table(name = "app_role")
class Role(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = -1,

  @Column(name = "role_name")
  var roleName: String? = null,

  @Column(name = "description")
  var description: String? = null

) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Role

    if (id != other.id) return false
    if (roleName != other.roleName) return false
    if (description != other.description) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + (roleName?.hashCode() ?: 0)
    result = 31 * result + (description?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return "Role(id=$id, roleName=$roleName, description=$description)"
  }
}
