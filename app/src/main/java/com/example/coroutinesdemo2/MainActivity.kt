package com.example.coroutinesdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count_button.setOnClickListener {
            textView.text = count++.toString()
        }
        download_button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
//                textView.text = UserDataManager().getTotalUserCount().toString()
                textView.text = UserDataManager2().getTotalUserCount().toString()
            }
        }
    }

}
