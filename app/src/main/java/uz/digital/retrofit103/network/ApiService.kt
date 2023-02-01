package uz.digital.retrofit103.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import uz.digital.retrofit103.model.Data
import uz.digital.retrofit103.model.OneUserResponse
import uz.digital.retrofit103.model.UserResponse

interface ApiService {
    @GET("/api/users")
    fun getUsers(): Call<UserResponse>

    @GET("/api/users/{id}")
    fun getUserById(@Path("id") id: Int): Call<OneUserResponse>

    @POST("/api/users")
    fun postUser(@Body data: Data): Call<OneUserResponse>
}