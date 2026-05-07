package net.nekocurit.netease_skin_server.config.configs

import kotlinx.serialization.Serializable

@Serializable
data class DataConfigServer(
    val host: String = "0.0.0.0",
    val port: Int = 8080
)