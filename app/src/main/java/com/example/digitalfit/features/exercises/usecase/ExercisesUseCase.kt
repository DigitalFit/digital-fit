package com.example.digitalfit.features.exercises.usecase


import android.app.Application
import com.example.digitalfit.features.exercises.repository.ExercisesRepository
import com.example.digitalfit.modelApi.*
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ExerciseWorkoutCrossRef
import com.example.digitalfit.utils.ConstantsApp.Exercise.FIRST_PAGE
import com.example.digitalfit.utils.ResponseApi


class ExercisesUseCase(
    private val application: Application
) {

    private val exercisesRepository = ExercisesRepository(application)


//    suspend fun getListExercises(): ResponseApi {
//        return when (val responseApi = exercisesRepository.getListExercises()) {
//            is ResponseApi.Success -> {
//                val data = responseApi.data as? ListExercises
//                val result = data?.results
//                ResponseApi.Success(result)
//            }
//            is ResponseApi.Error -> {
//                responseApi
//            }
//        }
//    }


    suspend fun getExercisesWithImagesFromDb(page: Int): List<ExerciseWithImages> {
        return exercisesRepository.getExercisesWithImagesFromDb(page)
    }

    suspend fun searchExercisesByName(name: String?): List<ExerciseWithImages> {
        return exercisesRepository.searchExercisesByName(name)
    }

    suspend fun getInfoExercises(): ResponseApi {
        return when (val responseApi = exercisesRepository.getInfoExercises(FIRST_PAGE)) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? InfoExercises
                val result = data?.results
                result?.let {resultList ->
                    resultList.forEach {
                        with(it){
                            description = description.replace("<p>","")
                            description = description.replace("</p>","")
                            description = description.replace("\\n+".toRegex(),"\n\n")
                        }
                    }
                }
                exercisesRepository.saveExerciseDatabase(result)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }

    suspend fun getCategoryExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getCategoryExercises()){
            is ResponseApi.Success -> {
                val categoryExercises = responseApi.data as? CategoryExercises
                exercisesRepository.saveCategoryDatabase(categoryExercises?.results)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }

    suspend fun getCommentExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getCommentExercises()){
            is ResponseApi.Success -> {
                val commentExercises = responseApi.data as? CommentExercises
                exercisesRepository.saveCommentDatabase(commentExercises?.results)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }

    suspend fun getEquipmentExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getEquipmentExercises()){
            is ResponseApi.Success -> {
                val equipmentExercises = responseApi.data as? EquipmentExercises
                exercisesRepository.saveEquipmentDatabase(equipmentExercises?.results)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }
    }

    suspend fun getImageExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getImageExercises()){
            is ResponseApi.Success -> {
                val data = responseApi.data as? InfoExercises
                val result = data?.results
                exercisesRepository.saveImageDatabase(result)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }

    }

    suspend fun getLanguageExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getLanguageExercises()){
            is ResponseApi.Success -> {
                val languageExercises = responseApi.data as? LanguageExercises
                exercisesRepository.saveLanguageDatabase(languageExercises?.results)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }

    }

    suspend fun getLicenseExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getLicenseExercises()){
            is ResponseApi.Success -> {
                val licenseExercises = responseApi.data as? LicenseExercises
                exercisesRepository.saveLicenseDatabase(licenseExercises?.results)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }

    }

    suspend fun getMuscleExercises(): ResponseApi {
        return when(val responseApi = exercisesRepository.getMuscleExercises()){
            is ResponseApi.Success -> {
                val muscleExercises = responseApi.data as? MuscleExercises
                exercisesRepository.saveMuscleDatabase(muscleExercises?.results)
                responseApi
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }

    }

    suspend fun getExerciseById(id: Int) = exercisesRepository.getExerciseById(id)


    fun setupExercisesList(list: InfoExercises?): List<ResultInfo> {
        return list?.results ?: listOf()
    }

    suspend fun addExerciseToWorkoutList(exerciseWorkoutCrossRef: ExerciseWorkoutCrossRef): Long {
       return exercisesRepository.addExerciseToWorkoutList(exerciseWorkoutCrossRef)
    }


}









