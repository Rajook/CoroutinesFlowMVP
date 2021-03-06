package com.app.coroutinesmvp.model

import com.app.coroutinesmvp.api.MovieApi
import com.app.coroutinesmvp.data.MovieListResponse
import com.app.coroutinesmvp.deps.MovieActivityScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@MovieActivityScope
class MovieModel @Inject constructor(
    private val movieApi: MovieApi
) {

    fun callMoviesApi(): Flow<MovieListResponse> {
//        return flow {
//            val carbonOffsetResponse = movieApi.getMoviesList("a427cfb730b4a73e67c646d8b44dd216")
//            emit(carbonOffsetResponse)
//        }.flowOn(Dispatchers.IO)

        return flow {
            movieApi.getMoviesList("a427cfb730b4a73e67c646d8b44dd216").also {
                this.emit(it)
            }
        }.flowOn(Dispatchers.IO)
    }
}
