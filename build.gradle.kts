plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)

    application
}

group = "net.nekocurit"
version = "0.0.1"

application {
    mainClass = "net.nekocurit.netease_skin_server.NeteaseSkinServerLoader"
}

repositories {
    mavenCentral()
}

dependencies {
    // Logger
    implementation(libs.slf4j.api)
    implementation(libs.log4j.core)
    implementation(libs.log4j.slf4j2.impl)

    // Config
    implementation(libs.kaml)

    // Ktor
    implementation(platform(libs.ktor.bom))
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.java)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.cio)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(project(":WPLauncherHelper"))
}
