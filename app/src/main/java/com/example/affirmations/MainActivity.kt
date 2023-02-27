/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.graphics.Paint.Align
import android.os.Bundle
import android.text.Layout.Alignment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.example.affirmations.components.AffirmationCard
import com.example.affirmations.components.AffirmationList
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

private const val tag = "MainActivity"

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Log.d(tag, "onCreate called!")

    setContent {
      // TODO 5. Show screen
      AffirmationApp()
    }
  }

  override fun onStart() {
    super.onStart()
    Log.d(tag, "onStart called!")
  }

  override fun onResume() {
    super.onResume()
    Log.d(tag, "onResume called!")
  }

  override fun onRestart() {
    super.onRestart()
    Log.d(tag, "onRestart called!")
  }

  override fun onPause() {
    super.onPause()
    Log.d(tag, "onPause called!")
  }

  override fun onStop() {
    super.onStop()
    Log.d(tag, "onStop called!")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.d(tag, "onDestroy called!")
  }
}

@Composable
fun AffirmationApp() {
  // TODO 4. Apply Theme and affirmation list
  val affirmations = Datasource().loadAffirmations()
  AffirmationsTheme{
    val count = rememberSaveable { mutableStateOf(0) }
    Column() {
      TextButton(onClick = { count.value += 1 }) {
        Text(
          text = "Me han pulsado ${count.value} vez/veces"
        )
      }
      AffirmationList(
        affirmations,
      )
    }
  }
}
