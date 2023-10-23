package org.eu.noobshubham.remoteward.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.eu.noobshubham.remoteward.Resource
import org.eu.noobshubham.remoteward.api.NetworkInterface
import org.eu.noobshubham.remoteward.model.WeatherData

class WeatherRepo(private val networkInterface: NetworkInterface) {
    fun getWeather() = flow<Resource<WeatherData>> {
        emit(Resource.loading())
        val response = networkInterface.getCurrentWeather()
        emit(Resource.success(response.body()!!))
    }.catch {
        emit(Resource.failed(it.message!!))
    }.flowOn(Dispatchers.IO)
}