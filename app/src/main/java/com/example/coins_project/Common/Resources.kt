package com.example.coins_project.Common

sealed class Resources<T>(val data : T? , val message : String? = null){
    class Sucess<T>(data : T?) : Resources<T>(data)
    class Error<T>(message: String?,data: T? = null) : Resources<T>(data,message)
    class Loading<T>(data: T? = null) : Resources<T>(data)
}
