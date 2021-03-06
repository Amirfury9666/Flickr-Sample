package com.fury.flickerapp.base.network

import android.content.Context
import android.net.ConnectivityManager
import com.fury.flickerapp.utility.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl(private val context: Context) : ConnectivityInterceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()){
            throw NoConnectivityException("")
        }
       return chain.proceed(chain.request())
    }

    private fun isOnline() : Boolean{
        val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}