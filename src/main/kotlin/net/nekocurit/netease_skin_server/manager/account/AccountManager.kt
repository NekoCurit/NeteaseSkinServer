package net.nekocurit.netease_skin_server.manager.account

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.nekocurit.netease_skin_server.NeteaseSkinServer
import net.nekocurit.x19.WPLauncherAPI
import net.nekocurit.x19.WPLauncherAccountAPI
import net.nekocurit.x19.data.cookie.WPLauncherCookieRaw
import net.nekocurit.x19.extensions.login

class AccountManager(val system: NeteaseSkinServer) {

    lateinit var job: Job
    lateinit var session: WPLauncherAccountAPI

    suspend fun login() {
        val config = system.configManager.base.account
        require(config.cookie.isNotEmpty()) { "请先配置账号 Cookie" }
        
        logout()

        session = WPLauncherAPI.login(WPLauncherCookieRaw(config.cookie))
        system.logger.info("[账号管理] 登陆 ${session.entity.entityId} 成功")
        job = system.scope.launch {
            runCatching {
                while (true) {
                    delay(config.keepalive)
                    system.logger.debug("[账号管理] 正在刷新用户凭据..")
                    runCatching { session.refresh() }
                        .onSuccess { system.logger.info("[账号管理] 刷新用户凭据成功") }
                        .onFailure { e -> system.logger.error("[账号管理] 未能成功刷新用户凭据", e) }
                }
            }
        }
    }

    suspend fun logout() {
        runCatching {
            session.logout()
            job.cancel()
        }
    }
}