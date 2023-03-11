package com.sample.infrastructure.mongodb

import io.quarkus.runtime.annotations.RegisterForReflection
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty
import java.util.Date

@RegisterForReflection
data class SampleEntity @BsonCreator constructor(
    @BsonProperty("id") val id: String,
    @BsonProperty("externalId") val externalId: String? = "",
    @BsonProperty("name") val name: String,
    @BsonProperty("email") val email: String,
    @BsonProperty("cellPhone") val cellPhone: String,
    @BsonProperty("createdAt") val createdAt: Date,
    @BsonProperty("updatedAt") val updatedAt: Date
)