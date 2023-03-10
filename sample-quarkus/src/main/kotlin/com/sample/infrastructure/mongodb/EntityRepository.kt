package com.sample.infrastructure.mongodb

import com.mongodb.MongoClientSettings
import com.sample.core.Sample
import com.sample.core.Repository
import com.sample.core.vo.Id
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import jakarta.enterprise.context.ApplicationScoped
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.pojo.PojoCodecProvider
import org.bson.conversions.Bson
import org.eclipse.microprofile.config.inject.ConfigProperty

@ApplicationScoped
class EntityRepository(
    private val mongodbClient: MongoClient,
    @ConfigProperty(name = "quarkus.mongodb.database") private val database: String,
    @ConfigProperty(name = "database.collection") private val collection: String,
): Repository {

    override fun create(sample: Sample): Sample {
        val entity = sample.toEntity()
        val id = getCollection().insertOne(entity).insertedId?.asString()?.value ?: throw Exception("Fail to create")
        return findById(Id(id))
    }

    override fun update(sample: Sample): Sample {
        TODO("Not yet implemented")
    }

    override fun findById(id: Id): Sample {
        return getCollection().find(byId(id.value)).first()?.toDomain() ?: throw Exception("Not found")
    }

    private fun getCollection(): MongoCollection<SampleEntity> =
        mongodbClient
            .getDatabase(database)
            .withCodecRegistry(
                CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())))
            .getCollection(collection, SampleEntity::class.java)

    companion object {
        private fun byId(id: String): Bson = Filters.eq("_id", id)
    }
}