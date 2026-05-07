package net.nekocurit.netease_skin_server.utils.serializable

import io.ktor.http.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object HttpStatusCodeSerializer: KSerializer<HttpStatusCode> {

    override val descriptor = PrimitiveSerialDescriptor("HttpStatusCode", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: HttpStatusCode) {
        return encoder.encodeInt(value.value)
    }

    override fun deserialize(decoder: Decoder): HttpStatusCode {
        return HttpStatusCode.fromValue(decoder.decodeInt())
    }
}