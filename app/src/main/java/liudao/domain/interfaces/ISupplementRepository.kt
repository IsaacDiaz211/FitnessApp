package liudao.domain.interfaces

import liudao.domain.models.Supplement
import kotlinx.coroutines.flow.Flow

interface ISupplementRepository {
    fun getAll(): Flow<List<Supplement>>
    suspend fun insert(sup: Supplement): Long
    suspend fun delete(sup: Supplement)
}