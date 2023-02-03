package uz.digital.retrofit103.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import uz.digital.retrofit103.model.Data
import uz.digital.retrofit103.model.FoodResponse
import uz.digital.retrofit103.model.OneUserResponse
import uz.digital.retrofit103.model.UserResponse

interface ApiService {
    @GET("/api/users")
    fun getUsers(): Call<UserResponse>

    @GET("/api/users/{id}")
    fun getUserById(@Path("id") id: Int): Call<OneUserResponse>

    @POST("/api/users")
    fun postUser(@Body data: Data): Call<OneUserResponse>

    @PUT("/api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body data: Data): Call<OneUserResponse>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Any>

    @FormUrlEncoded
    @PATCH("api/users/{id}")
    fun postWithFields(
        @Path("id") id: Int,
        @Field("avatar") avatar: String
    )

    @GET("/recipes/complexSearch")
    fun getFoods(
        @Query("apiKey") apiKey: String = "754b79e5a34b441a81e0e83a0e5286c3",
    ): Call<FoodResponse>

    @GET("/recipes/complexSearch")
    fun searchFood(
        @Query("apiKey") apiKey: String = "754b79e5a34b441a81e0e83a0e5286c3",
        @Query("query") query: String
    ): Call<FoodResponse>
}