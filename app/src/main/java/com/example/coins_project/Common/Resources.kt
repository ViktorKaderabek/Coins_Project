package com.example.coins_project.Common

sealed class Resources<T>(val data: T?) {
    class Sucess<T>(data: T?) : Resources<T>(data)
}
