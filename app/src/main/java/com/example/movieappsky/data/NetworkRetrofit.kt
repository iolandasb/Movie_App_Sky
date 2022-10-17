package com.example.movieappsky.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.movieappsky.presentation.application.AppApplication
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkRetrofit {

    fun getMoviesRemoteSource(): Service {
        val api = createService()
        return api.create(Service::class.java)
    }

    private fun Context.isNetworkAvailable(): Boolean {
        (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
            return getNetworkCapabilities(activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } ?: false
        }
    }

    private const val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB
    private val appContext = AppApplication.appContext
    private val cache = Cache(appContext.cacheDir, cacheSize)

    private var onlineInterceptor = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        val maxAge = 0.00694444 // read from cache for 10 minutes even if there is internet connection
        response.newBuilder()
            .header("Cache-Control", "public, max-age=$maxAge")
            .removeHeader("Pragma")
            .build()
    }

    private var offlineInterceptor = Interceptor { chain ->
        var request = chain.request()
        if (!appContext.isNetworkAvailable())
        {
            val maxStale = 60 * 60 * 24 * 0.00694444 // Offline cache available for 10 minutes
            request = request.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .removeHeader("Pragma")
                .build()
        }
        chain.proceed(request)
    }

    private fun createService(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()

        okHttpClient.addInterceptor(offlineInterceptor)
        okHttpClient.addNetworkInterceptor(onlineInterceptor)
        okHttpClient.cache(cache)
        okHttpClient.build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL.value)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
    }
}