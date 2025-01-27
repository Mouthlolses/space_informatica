package com.example.space_informatica.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


object NetworkUtils {
    //Configurando a notificação do estado da internet no dispositivo
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}