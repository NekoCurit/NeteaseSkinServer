package net.nekocurit.netease_skin_server.route.error

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable

@Serializable
class ServerRestNotFoundException(override val msg: String = "Not found"): ServerRestException(HttpStatusCode.NotFound) {
    companion object {
        fun notFound(message: String = "Not found"): Nothing = throw ServerRestNotFoundException(message)
    }
}