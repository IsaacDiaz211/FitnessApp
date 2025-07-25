package com.example.liudao.di

import android.content.Context
import androidx.room.Room
import com.example.liudao.data.local.database.LiuDaoDatabase
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LiuDaoDatabase =
        Room.databaseBuilder(
            context,
            LiuDaoDatabase::class.java,
            "liudao_db"
        ).build()

    @Provides
    fun provideEjercicioDao(db: LiuDaoDatabase) = db.exerciseDao()

    @Provides
    fun provideGrupoMuscularDao(db: LiuDaoDatabase) = db.muscleGroupDao()

    @Provides
    fun provideRutinaDao(db: LiuDaoDatabase) = db.routineDao()

    @Provides
    fun provideSerieDao(db: LiuDaoDatabase) = db.setDao()

    @Provides
    fun provideSuplementoDao(db: LiuDaoDatabase) = db.supplementDao()
}