package net.nekocurit.netease_skin_server.route.error

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable

@Serializable
class ServerRestForbiddenException(override val msg: String =  "Forbidden"): ServerRestException(HttpStatusCode.Forbidden) {
    companion object {
        fun forbidden(message: String): Nothing = throw ServerRestForbiddenException(message)
    }
}