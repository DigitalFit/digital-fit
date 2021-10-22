package com.example.digitalfit.features.exercises.repository

import android.app.Application
import com.example.digitalfit.api.ApiService
import com.example.digitalfit.base.BaseRepository
import com.example.digitalfit.dataBase.DigitalFitDataBase
import com.example.digitalfit.modelApi.*
import com.example.digitalfit.modelDb.*
import com.example.digitalfit.utils.ResponseApi

class ExercisesRepository(
    val application: Application
) : BaseRepository() {
    //chamdas de dados


//    suspend fun getListExercises(): ResponseApi {
//        return safeApiCall {
//            ApiService.wgerApi.getListExercises()
//        }
//
//    }
//


    suspend fun getInfoExercises(page: Int): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getInfoExercises(page)
        }

    }

    suspend fun saveExerciseDatabase(exercises: List<ResultInfo>?) {
        val exercisesDb: MutableList<ExerciseDb> = mutableListOf()

        exercises?.forEach { exercise ->

            if (exercise.equipment.isNotEmpty()) {
                exercise.equipment.forEach { equip ->
                    val exerciseEquipmentCrossRef = ExerciseEquipmentCrossRef(
                        equipmentId = equip.id,
                        exerciseId = exercise.id ?: -1
                    )
                    DigitalFitDataBase
                        .getDatabase(application)
                        .exerciseEquipmentDao()
                        .insertExerciseEquipment(exerciseEquipmentCrossRef)
                }
            }

            if (exercise.muscles.isNotEmpty()) {
                exercise.muscles.forEach { muscle ->
                    val exerciseMuscleCrossRef = ExerciseMuscleCrossRef(
                        muscleId = muscle.id,
                        exerciseId = exercise.id ?: -1
                    )
                    DigitalFitDataBase
                        .getDatabase(application)
                        .exerciseMuscleDao()
                        .insertExerciseMuscle(exerciseMuscleCrossRef)
                }
            }

            if (exercise.muscles_secondary.isNotEmpty()) {
                exercise.muscles_secondary.forEach { muscle ->
                    val exerciseMuscleSecondaryCrossRef = ExerciseMuscleSecondaryCrossRef(
                        muscleId = muscle.id,
                        exerciseId = exercise.id ?: -1
                    )
                    DigitalFitDataBase
                        .getDatabase(application)
                        .exerciseMuscleSecondaryDao()
                        .insertExerciseMuscleSecondary(exerciseMuscleSecondaryCrossRef)
                }
            }
            exercisesDb.add(exercise.toExerciseDb())
        }
        DigitalFitDataBase
            .getDatabase(application)
            .exerciseDao()
            .insertAllExercises(
                exercisesDb
            )
    }

    suspend fun getCategoryExercises(): ResponseApi {
        return  safeApiCall {
            ApiService.wgerApi.getCategoryExercises()
        }

    }

    suspend fun saveCategoryDatabase(categoryApi: List<Category>?) {
        categoryApi?.let { categoryApi ->
            val categoryDb: MutableList<CategoryDb> = mutableListOf()

            categoryApi.forEach {
                categoryDb.add(it.toCategoryDb())
            }

            DigitalFitDataBase
                .getDatabase(application)
                .categoryDao()
                .insertAllCategory(
                    categoryDb
                )
        }
    }

    suspend fun getCommentExercises(): ResponseApi {
        return  safeApiCall {
            ApiService.wgerApi.getCommentExercises()
        }

    }

    suspend fun saveCommentDatabase(commentApi: List<Comment>?) {
        commentApi?.let { commentApi ->
            val commentDb: MutableList<CommentDb> = mutableListOf()

            commentApi.forEach {
                commentDb.add(it.toCommentDb())
            }

            DigitalFitDataBase
                .getDatabase(application)
                .commentDao()
                .insertAllComments(
                    commentDb
                )
        }
    }

    suspend fun getEquipmentExercises(): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getEquipmentExercises()
        }
    }

    suspend fun saveEquipmentDatabase(equipmentApi: List<Equipment>?) {
        equipmentApi?.let { equipmentApi ->
            val equipmentDb: MutableList<EquipmentDb> = mutableListOf()

            equipmentApi.forEach {
                equipmentDb.add(it.toEquipmentDb())
            }

            DigitalFitDataBase
                .getDatabase(application)
                .equipmentDao()
                .insertAllEquipments(
                    equipmentDb
                )
        }
    }

    suspend fun getImageExercises(): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getImageExercises()
        }

    }

    suspend fun saveImageDatabase(resultApi: List<ResultInfo>?) {
        resultApi?.let { resultApi ->
            val imageDbList: MutableList<ImageDb> = mutableListOf()
            resultApi.forEach { result ->
                if(result.images.isNotEmpty()){
                    result.images.forEach { image ->
                        imageDbList.add(image.toImageDb(result.id))
                    }
                }
            }

            DigitalFitDataBase
                .getDatabase(application)
                .imageDao()
                .insertAllImages(
                    imageDbList
                )
        }
    }

    suspend fun getLanguageExercises(): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getLanguageExercises()
        }
    }

    suspend fun saveLanguageDatabase(languageApi: List<Language>?) {
        languageApi?.let { languageApi ->
            val languageDb: MutableList<LanguageDb> = mutableListOf()

            languageApi.forEach {
                languageDb.add(it.toLanguageDb())
            }

            DigitalFitDataBase
                .getDatabase(application)
                .languageDao()
                .insertAllLanguages(
                    languageDb
                )
        }
    }

    suspend fun getLicenseExercises(): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getLicenseExercises()
        }
    }

    suspend fun saveLicenseDatabase(licenseApi: List<License>?) {
        licenseApi?.let { licenseApi ->
            val licenseDb: MutableList<LicenseDb> = mutableListOf()

            licenseApi.forEach {
                licenseDb.add(it.toLicenseDb())
            }

            DigitalFitDataBase
                .getDatabase(application)
                .licenseDao()
                .insertAllLicenses(
                    licenseDb
                )
        }
    }

    suspend fun getMuscleExercises(): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getMuscleExercises()
        }
    }

    suspend fun saveMuscleDatabase(muscleApi: List<Muscle>?) {
        muscleApi?.let { muscleApi ->
            val muscleDb: MutableList<MuscleDb> = mutableListOf()

            muscleApi.forEach {
                muscleDb.add(it.toMuscleDb())
            }

            DigitalFitDataBase
                .getDatabase(application)
                .muscleDao()
                .insertAllMuscles(
                    muscleDb
                )
        }
    }


    suspend fun getExercisesWithImagesFromDb(page: Int): List<ExerciseWithImages> {
        val exerciseDao = DigitalFitDataBase.getDatabase(application).exerciseDao()
        return exerciseDao.getExerciseWithImages(page)
    }

    suspend fun searchExercisesByName(name: String?): List<ExerciseWithImages> {
        val exerciseDao = DigitalFitDataBase.getDatabase(application).exerciseDao()
        return exerciseDao.searchExercisesByName(name)
    }

    suspend fun getExerciseById(id: Int): ResponseApi {
        return safeApiCall {
            ApiService.wgerApi.getExerciseById(id)
        }
    }



}




