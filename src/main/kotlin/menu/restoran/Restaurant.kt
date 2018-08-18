package menu.restoran

import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "restaurants")
class Restaurant {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null

    var name: String? = null

    var location: String? = null

    var lat: Double? = null

    var lng: Double? = null

    @OneToMany(mappedBy = "restaurant")
    var menus: List<Menu>? = null
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Restaurant

        if (id != other.id) return false
        if (name != other.name) return false
        if (location != other.location) return false
        if (lat != other.lat) return false
        if (lng != other.lng) return false
        if (menus != other.menus) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        result = 31 * result + (lat?.hashCode() ?: 0)
        result = 31 * result + (lng?.hashCode() ?: 0)
        result = 31 * result + (menus?.hashCode() ?: 0)
        result = 31 * result + (user?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Restaurant(id=$id, name=$name, location=$location, lat=$lat, lng=$lng, menus=$menus, user=$user)"
    }

//    override fun toString() = "Restaurant($id, $name, $location, $lat, $lng, ${menus?.map { it.id }})"
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Restaurant
//
//        if (id != other.id) return false
//        if (name != other.name) return false
//        if (location != other.location) return false
//        if (lat != other.lat) return false
//        if (lng != other.lng) return false
//        if (menus != other.menus) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = id?.hashCode() ?: 0
//        result = 31 * result + (name?.hashCode() ?: 0)
//        result = 31 * result + (location?.hashCode() ?: 0)
//        result = 31 * result + (lat?.hashCode() ?: 0)
//        result = 31 * result + (lng?.hashCode() ?: 0)
//        return result
//    }

}
