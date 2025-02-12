package com.example.uas_ppapb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// implementasi dari BroadcastReceiver yang digunakan untuk menerima dan menanggapi pesan dari suatu Intent
class NotifReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val msg = intent?.getStringExtra("MESSAGE")
        if (msg != null) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}