package net.nekocurit.netease_skin_server.config.configs

import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

@Serializable
data class DataConfigAccount(
    val cookie: String = "",
    val keepalive: Duration = 15.minutes
)