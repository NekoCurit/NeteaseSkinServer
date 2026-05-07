package net.nekocurit.netease_skin_server

import kotlinx.coroutines.runBlocking

object NeteaseSkinServerLoader {

    @JvmStatic
    fun main(vararg args: String) {
        runBlocking {
            NeteaseSkinServer().start()
        }
    }
}