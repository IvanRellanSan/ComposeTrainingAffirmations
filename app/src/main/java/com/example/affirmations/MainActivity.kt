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

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.affirmations.ui.components.AffirmationList
import com.example.affirmations.ui.components.TopBar
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.example.affirmations.ui.viewmodel.MainViewModel

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
fun AffirmationApp(
  mainViewModel: MainViewModel = MainViewModel()
) {
  // TODO 4. Apply Theme and affirmation list
  mainViewModel.loadData()
  val affirmations by mainViewModel.listState.collectAsState()
  AffirmationsTheme{
    val scaffoldState = rememberScaffoldState()
    Scaffold(
      scaffoldState = scaffoldState,
      topBar = {
        TopBar()
      }
    ) {
      Column {
//      TextButtonComponent()
        AffirmationList(
          affirmations,
          modifier = Modifier
            .background(
              color = MaterialTheme.colors.background
            )
        )
      }
    }
  }
}
