package com.example.affirmations.navigation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

class DetailNavigator {
    fun sendEmail(context: Context, to: String, subject: String) {
        try {
            val patata = Intent(Intent.ACTION_SEND)
            patata.type = "message/rfc822"
            patata.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            patata.putExtra(Intent.EXTRA_SUBJECT, subject)
            context.startActivity(patata)
        } catch (e: ActivityNotFoundException) {
            Log.e("ERROR", e.message!!)
        } catch (t: Throwable) {
            // TODO: Handle
        }
    }

    fun dial(context: Context, phone: String) {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            context.startActivity(intent)
        } catch (t: Throwable) {
            // TODO: Handle
        }
    }
}
