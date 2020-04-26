package com.example.coroutinesdemo2

import android.util.Log
import kotlinx.coroutines.*

class UserDataManager {
    suspend fun getTotalUserCount():Int{
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {

            delay(1000)
            count = 5
        }

        val deferred =CoroutineScope(Dispatchers.IO).async {

            delay(3000)
            return@async 70
        }
        return count + deferred.await()
    }
}