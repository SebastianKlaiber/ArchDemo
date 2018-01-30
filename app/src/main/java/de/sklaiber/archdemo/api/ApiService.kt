package de.sklaiber.archdemo.api

import de.sklaiber.archdemo.api.model.IpAddress
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    fun getJsonResponse(): Single<IpAddress>
}