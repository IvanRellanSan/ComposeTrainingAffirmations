package com.example.affirmations.navigation

import android.content.Context
import android.content.Intent
import com.example.affirmations.DetailActivity

class MainNavigator {
    fun goToDetailActivity(id: String, context: Context){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }
}