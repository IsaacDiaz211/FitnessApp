package com.example.liudao.domain.repositories

import com.example.liudao.data.local.dao.SupplementDao
import com.example.liudao.data.local.entities.SupplementEntity
import com.example.liudao.domain.interfaces.ISupplementRepository
import com.example.liudao.domain.models.Supplement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SupplementRepository @Inject constructor(
    private val dao: SupplementDao
): ISupplementRepository {
    override fun getAll(): Flow<List<Supplement>> =
        dao.getSupplements().map { list -> list.map { it.toDomain() } }

    override suspend fun insert(sup: Supplement): Long =
        dao.insert(sup.toEntity())

    override suspend fun delete(sup: Supplement) =
        dao.delete(sup.toEntity())
}

//Mappers
fun SupplementEntity.toDomain() = Supplement(id, name, start)
fun Supplement.toEntity() = SupplementEntity(id, name, start)