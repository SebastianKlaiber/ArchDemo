package de.sklaiber.archdemo.repository

import de.sklaiber.archdemo.api.ApiService
import de.sklaiber.archdemo.api.model.IpAddress
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {
    fun getDataFromApi(): Single<IpAddress> = apiService.getJsonResponse()
}