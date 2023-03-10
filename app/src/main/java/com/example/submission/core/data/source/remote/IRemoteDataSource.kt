package com.example.submission.core.data.source.remote

import com.example.submission.core.data.source.remote.network.ApiResponse
import com.example.submission.core.data.source.remote.response.VanguardResponse
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {

    suspend fun getAllVanguards(): Flow<ApiResponse<List<VanguardResponse>>>

}