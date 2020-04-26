package com.example.coroutinesdemo2

import android.util.Log
import kotlinx.coroutines.*

class UserDataManager2 {
    var count = 0
    lateinit var deferred:Deferred<Int>
    suspend fun getTotalUserCount():Int{
        //coroutineScope
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                Log.i("MyTag","launch")
                count = 50
            }
            deferred = async(Dispatchers.IO) {
                delay(3000)
                Log.i("MyTag","async")
                return@async 70
            }
        }
        return count+deferred.await()
    }

}
