package net.nekocurit.netease_skin_server.route.error

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Serializable

@Serializable
class ServerRestInternalServerError(override val msg: String =  "Internal Server Error"): ServerRestException(HttpStatusCode.InternalServerError) {
    companion object {
        fun internalServerError(message: String?): Nothing = throw ServerRestInternalServerError(message ?: "未知错误")
    }
}