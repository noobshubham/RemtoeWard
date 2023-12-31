package org.eu.noobshubham.remoteward.api

import org.eu.noobshubham.remoteward.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET

interface NetworkInterface {

    @GET("v1/current.json?key=7bbfe483075a40c393571733232210&q=Bengaluru&aqi=no")
    suspend fun getCurrentWeather(): Response<WeatherData>
}