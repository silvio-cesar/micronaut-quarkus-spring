package com.sample.core

import com.sample.core.vo.Id

interface Repository {

    fun create(sample: Sample): Sample

    fun update(sample: Sample): Sample

    fun findById(id: Id): Sample
}