package liudao.domain.repositories

import liudao.data.local.dao.ExerciseDao
import liudao.data.local.entities.ExerciseEntity
import liudao.domain.interfaces.IExerciseRepository
import liudao.domain.models.Exercise
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val dao: ExerciseDao
) : IExerciseRepository {

    override fun getAll(): Flow<List<Exercise>> =
        dao.getExercises().map { list -> list.map { it.toDomain() } }

    override suspend fun insert(exercise: Exercise): Long =
        dao.insert(exercise.toEntity())

    override suspend fun delete(exercise: Exercise) =
        dao.delete(exercise.toEntity())
    override suspend fun search(text: String): Flow<List<Exercise>> =
        dao.search(text).map { list -> list.map { it.toDomain() } }

}

//Mappers
fun ExerciseEntity.toDomain() = Exercise(id, name, idMuscleGroup)
fun Exercise.toEntity() = ExerciseEntity(id, name, muscleGroupId)