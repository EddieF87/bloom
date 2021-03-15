/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.MainActivity.Companion.MAIN_NAV_LOGIN
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.isDarkTheme
import com.example.androiddevchallenge.ui.view.PrimaryButton
import com.example.androiddevchallenge.ui.view.SecondaryButton
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Composable
fun WelcomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    val isDark = isDarkTheme()
    Surface(color = MaterialTheme.colors.primary) {
        Image(
            painter = painterResource(id = if (isDark) R.drawable.dark_welcome_bg else R.drawable.light_welcome_bg),
            contentScale = ContentScale.FillBounds,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp, bottom = 24.dp)
                .systemBarsPadding()
        ) {
            Image(
                painter = painterResource(id = if (isDark) R.drawable.dark_welcome_illos else R.drawable.light_welcome_illos),
                contentScale = ContentScale.Fit,
                modifier = Modifier.offset(88.dp),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = if (isDark) R.drawable.dark_logo else R.drawable.light_logo),
                contentDescription = ""
            )
            Text(
                text = stringResource(R.string.welcome_subtitle),
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(40.dp))
            PrimaryButton(
                onClick = {
                    Toast.makeText(context, "TODO: Create Account", Toast.LENGTH_SHORT).show()
                },
                text = stringResource(R.string.welcome_primary)
            )
            SecondaryButton(
                onClick = { navController.navigate(MAIN_NAV_LOGIN) },
                text = stringResource(R.string.welcome_secondary),
                yOffsetDp = 8.dp
            )
        }
    }
}
