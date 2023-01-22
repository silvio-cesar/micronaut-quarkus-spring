package com.sample.infrastructure.mongodb

import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document
data class SampleEntity @BsonCreator constructor(
    @BsonProperty("id") val id: String,
    @BsonProperty("externalId") val externalId: String? = "",
    @BsonProperty("name") val name: String,
    @BsonProperty("email") val email: String,
    @BsonProperty("cellPhone") val cellPhone: String,
    @BsonProperty("createdAt") val createdAt: Date,
    @BsonProperty("updatedAt") val updatedAt: Date
)