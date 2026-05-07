package net.nekocurit.netease_skin_server.route.error

import io.ktor.http.HttpStatusCode
import io.ktor.server.routing.RoutingCall
import kotlinx.serialization.Serializable

@Serializable
class ServerRestBadRequestException(override val msg: String = "Bad Request"): ServerRestException(HttpStatusCode.BadRequest) {
    companion object {
        fun RoutingCall.parameter(name: String) = parameters[name] ?: throw ServerRestBadRequestException("Missing parameter $name")
    }
}