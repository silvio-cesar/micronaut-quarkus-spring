package com.sample.infrastructure.mongodb

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.sample.core.Sample
import com.sample.core.Repository
import com.sample.core.vo.Id
import io.micronaut.context.annotation.Property
import jakarta.inject.Named
import jakarta.inject.Singleton
import org.bson.conversions.Bson
import java.lang.Exception

@Singleton
@Named("mongodbEntityRepository")
class EntityRepository(
    private val mongodbClient: MongoClient,
    @Property(name = "mongodb.database") private val database: String,
    @Property(name = "mongodb.collection") private val collection: String
): Repository {

    override fun create(sample: Sample): Sample {
        val entity = sample.toEntity()
        val id = getCollection().insertOne(entity).insertedId
        return findById(Id(id?.asString()?.value ?: throw Exception("Fail to create")))
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
            .getCollection(collection, SampleEntity::class.java)

    companion object {
        private fun byId(id: String): Bson = Filters.eq("_id", id)
    }
}