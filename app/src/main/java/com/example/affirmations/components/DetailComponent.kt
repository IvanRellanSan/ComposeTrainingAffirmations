package com.example.affirmations.components

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.Typography


@Composable
fun DetailComponent(modifier: Modifier = Modifier, affirmation: Affirmation) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = affirmation.imageResourceId),
            contentDescription = stringResource(id = affirmation.stringResourceId),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 22.dp)
        )
        Text(text = stringResource(id = affirmation.stringResourceId),
            style= Typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
//                .weight(1f)
        )
        Text(text = stringResource(id = affirmation.descriptionResourceId),
            style= Typography.body2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 32.dp, end = 32.dp, bottom = 10.dp)
//                .weight(1f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp, start = 32.dp),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(onClick = { context.sendEmail(affirmation.email, "Hola camarón con cola") }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email button"
                )
            }

            IconButton(onClick = { context.dial(affirmation.phone) }) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Email button"
                )
            }
        }
    }
}

fun Context.sendEmail(to: String, subject: String){
    try{
        val patata = Intent(Intent.ACTION_SEND)
        patata.type = "message/rfc822"
        patata.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        patata.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(patata)
    } catch (e: ActivityNotFoundException){
        Log.e("ERROR", e.message!!)
    } catch (t: Throwable){
        // TODO: Handle
    }
}

fun Context.dial(phone: String){
    try{
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    } catch (t: Throwable){
        // TODO: Handle
    }
}

@Preview
@Composable
fun DetailComponentPreview() {
    val affirmations = Datasource().loadAffirmations()
    DetailComponent(affirmation = affirmations[0])
}