package com.example.myapplication.data.network.dto

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import java.time.Instant

@Serializable
data class MessageDto(
    val id: String? = null,
    val sender: String? = null,
    val text: String? = null,
    @Serializable(with = CreatedAtSerializer::class)
    val createdAt: Long? = null
)

object CreatedAtSerializer : KSerializer<Long?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("CreatedAt", PrimitiveKind.LONG)

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Long?) {
        if (value == null) {
            encoder.encodeNull()
        } else {
            encoder.encodeLong(value)
        }
    }

    override fun deserialize(decoder: Decoder): Long? {
        val jsonElement = (decoder as? JsonDecoder)?.decodeJsonElement()
        val primitive = jsonElement?.jsonPrimitive ?: return null
        
        return try {
            primitive.longOrNull ?: run {
                val dateStr = primitive.content
                Instant.parse(dateStr).toEpochMilli()
            }
        } catch (_: Exception) {
            null
        }
    }
}

@Serializable
data class NewMessageDto(
    val sender: String,
    val text: String,
    val createdAt: Long
)
