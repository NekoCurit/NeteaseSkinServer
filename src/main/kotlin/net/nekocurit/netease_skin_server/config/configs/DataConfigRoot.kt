package net.nekocurit.netease_skin_server.config.configs

import kotlinx.serialization.Serializable

@Serializable
class DataConfigRoot(
    val server: DataConfigServer = DataConfigServer(),
    val account: DataConfigAccount = DataConfigAccount()
)