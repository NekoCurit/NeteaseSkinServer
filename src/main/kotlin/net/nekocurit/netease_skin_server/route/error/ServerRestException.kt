package net.nekocurit.netease_skin_server.route.error

import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.nekocurit.netease_skin_server.utils.serializable.HttpStatusCodeSerializer

@Serializable
open class ServerRestException(
    @Serializable(with = HttpStatusCodeSerializer::class)
    val code: HttpStatusCode,
    @SerialName("message")
    open val msg: String = ""
): Exception(msg)