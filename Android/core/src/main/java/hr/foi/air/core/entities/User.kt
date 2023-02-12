package hr.foi.air.core.entities

import java.io.Serializable

open class User(
    open var id : Int? = null,
    var username : String = "",
    var password : String = ""
) : Serializable
