package com.example.pixabaysearchapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import dagger.hilt.android.qualifiers.ApplicationContext

class NetworkConnection(
    @ApplicationContext
    private val context: Context
) {
    private val connectivityService = Context.CONNECTIVITY_SERVICE
    private val connectivityManager =
        context.getSystemService(connectivityService) as ConnectivityManager

    companion object {
        private var isConnected: Boolean = false

        fun isConnected(): Boolean {
            return isConnected
        }
    }

    private val callback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            isConnected = true
        }

        override fun onLosing(network: Network, maxMsToLive: Int) {
            super.onLosing(network, maxMsToLive)
            isConnected = false
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            isConnected = false
        }

        override fun onUnavailable() {
            super.onUnavailable()
            isConnected = false
        }
    }

    fun registerConnection() {
        connectivityManager.registerDefaultNetworkCallback(callback)
    }

    fun unregisterConnection() {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}
