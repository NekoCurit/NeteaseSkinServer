package net.nekocurit.netease_skin_server.config

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import net.nekocurit.netease_skin_server.NeteaseSkinServer
import net.nekocurit.netease_skin_server.config.configs.DataConfigRoot
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

class ConfigManager(val system: NeteaseSkinServer) {
    companion object {
        val yaml = Yaml(
            configuration = YamlConfiguration(
                strictMode = false
            )
        )

        val CONFIG_FILE: File = Paths.get("config.yml").toFile()
    }

    lateinit var base: DataConfigRoot

    fun readConfig() {
        runCatching {
            base = CONFIG_FILE
                .takeIf { it.exists() }
                ?.let {
                    yaml.decodeFromString(DataConfigRoot.serializer(), it.readText(StandardCharsets.UTF_8))
                }
                ?: DataConfigRoot()
                    .also { default ->
                        CONFIG_FILE.writeText(yaml.encodeToString(DataConfigRoot.serializer(), default), StandardCharsets.UTF_8)
                    }
        }
            .onFailure { e ->
                throw RuntimeException("加载配置失败", e)
            }
    }

    fun writeConfig() {
        CONFIG_FILE.writeText(yaml.encodeToString(DataConfigRoot.serializer(), base), StandardCharsets.UTF_8)
    }
}
