package com.example.dev_intensive_2019.models

import java.util.*
import com.example.dev_intensive_2019.utils.parseFullName

data class User(val id : String,
           var firstName : String?,
           var lastName : String?,
           var avatar : String?,
           var rating : Int = 0,
           var respect : Int = 0,
           var lastVisit : Date? = Date(),
           var isOnline : Boolean = false) {



    companion object Factory {
        private var lastId : Int = -1
        fun makeUser(fullName: String?) : User {
            lastId ++;
            val (first, second) = parseFullName(fullName)
            return User(id = "$lastId", firstName = first,
                lastName = second, avatar = null)
        }
    }


    data class Builder(var id : String = "",
                var firstName : String? = "",
                var lastName : String? = "",
                var avatar : String? = "",
                var rating : Int = 0,
                var respect : Int = 0,
                var lastVisit : Date? = Date(),
                var isOnline : Boolean = false) {
        fun id(id: String) : Builder {
            this.id = id
            return this
        }
        fun firstName(firstName: String?) : Builder {
            this.firstName = firstName
            return this
        }
        fun lastName(lastName: String?) : Builder {
            this.lastName = lastName
            return this
        }
        fun avatar(avatar: String?) : Builder {
            this.avatar = avatar
            return this
        }
        fun rating(rating: Int) : Builder {
            this.rating = rating
            return this
        }
        fun respect(respect: Int) : Builder {
            this.respect = respect
            return this
        }
        fun lastVisit(lastVisit: Date?) : Builder {
            this.lastVisit = lastVisit
            return this
        }
        fun isOnline(isOnline: Boolean) : Builder {
            this.isOnline = isOnline
            return this
        }
        fun build() : User {
            return User(id = id,
                firstName = firstName,
                lastName = lastName,
                avatar = avatar,
                rating = rating,
                respect = respect,
                lastVisit = lastVisit,
                isOnline = isOnline)
        }
    }
}