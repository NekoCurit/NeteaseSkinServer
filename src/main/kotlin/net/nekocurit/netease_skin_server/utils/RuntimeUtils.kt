package net.nekocurit.netease_skin_server.utils

import kotlinx.coroutines.runBlocking

fun addShutdownHook(block: suspend () -> Unit) {
    Runtime.getRuntime().addShutdownHook(Thread { runBlocking { block()} })
}