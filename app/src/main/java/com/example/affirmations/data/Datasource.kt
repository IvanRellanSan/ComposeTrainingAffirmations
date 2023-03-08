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
package com.example.affirmations.data
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
import java.util.UUID

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation("qwer", R.string.affirmation1, R.string.description1, R.drawable.image1, "affirmation1@gmail.com", "111111111"),
            Affirmation("tyui", R.string.affirmation2, R.string.description2, R.drawable.image2, "affirmation2@gmail.com", "222222222"),
            Affirmation("opas", R.string.affirmation3, R.string.description3, R.drawable.image3, "affirmation3@gmail.com", "333333333"),
            Affirmation("dfgh", R.string.affirmation4, R.string.description4, R.drawable.image4, "affirmation4@gmail.com", "444444444"),
            Affirmation("jklñ", R.string.affirmation5, R.string.description5, R.drawable.image5, "affirmation5@gmail.com", "555555555"),
            Affirmation("zxcv", R.string.affirmation6, R.string.description6, R.drawable.image6, "affirmation6@gmail.com", "666666666"),
            Affirmation("bnmq", R.string.affirmation7, R.string.description7, R.drawable.image7, "affirmation7@gmail.com", "777777777"),
            Affirmation("wert", R.string.affirmation8, R.string.description8, R.drawable.image8, "affirmation8@gmail.com", "888888888"),
            Affirmation("yuio", R.string.affirmation9, R.string.description9, R.drawable.image9, "affirmation9@gmail.com", "999999999"),
            Affirmation("pasd", R.string.affirmation10, R.string.description10, R.drawable.image10, "affirmation10@gmail.com", "101010"))
    }
}
