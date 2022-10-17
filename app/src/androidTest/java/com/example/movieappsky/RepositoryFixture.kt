package com.example.movieappsky

import io.reactivex.internal.util.NotificationLite.disposable
import org.mockito.Mockito.mock
import retrofit2.adapter.rxjava2.Result.response

private const val SUCCESS_RESPONSE = "com/example/movieappsky/RepositoryJson"
private const val COUPONS_API_ENDPOINT = "/api/movies"

//val successResponse = disposable {
//    mock { COUPONS_API_ENDPOINT with response(SUCCESS_RESPONSE) }
//}
