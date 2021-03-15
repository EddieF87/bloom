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

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.MainActivity.Companion.MAIN_NAV_HOME
import com.example.androiddevchallenge.MainActivity.Companion.MAIN_NAV_WELCOME
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.defaultHorizontalPadding
import com.example.androiddevchallenge.ui.view.BloomClickableText
import com.example.androiddevchallenge.ui.view.PrimaryButton
import dev.chrisbanes.accompanist.insets.systemBarsPadding

@Composable
fun LoginScreen(navController: NavHostController) {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 184.dp, bottom = 24.dp)
                .systemBarsPadding()
        ) {
            Text(text = stringResource(R.string.login_header), style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                label = { Text(stringResource(R.string.login_email_label)) },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultHorizontalPadding()
            )
            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                label = { Text(stringResource(R.string.login_password_label)) },
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultHorizontalPadding()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TermsText()
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
                onClick = { onLoginClicked(emailText, passwordText, navController) },
                text = stringResource(R.string.login_primary),
            )
        }
    }
}

private const val TERMS_OF_USE_TAG = "termsOfUseURL"
private const val PRIVACY_POLICY_TAG = "privacyPolicyURL"

@Composable
fun TermsText() {
    fun AnnotatedString.Builder.addAnnotatedText(text: String, tag: String, url: String) {
        pushStringAnnotation(tag = tag, annotation = url)
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) { append(text) }
        pop()
    }

    val annotatedText = buildAnnotatedString {
        append(stringResource(R.string.login_terms_1))
        addAnnotatedText(
            text = stringResource(R.string.login_terms_2),
            tag = TERMS_OF_USE_TAG,
            url = "todo TERMS_OF_USE_TAG"
        )
        append(stringResource(R.string.login_terms_3))
        addAnnotatedText(
            text = stringResource(R.string.login_terms_4),
            tag = PRIVACY_POLICY_TAG,
            url = "todo PRIVACY_POLICY_TAG"
        )
        append(stringResource(R.string.login_terms_5))
    }

    BloomClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.apply {
                getStringAnnotations(tag = TERMS_OF_USE_TAG, start = offset, end = offset)
                    .firstOrNull()?.let { annotation -> Log.d("Clicked URL", annotation.item) }
                getStringAnnotations(tag = PRIVACY_POLICY_TAG, start = offset, end = offset)
                    .firstOrNull()?.let { annotation -> Log.d("Clicked URL", annotation.item) }
            }
        },
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body2,
        modifier = Modifier
            .defaultHorizontalPadding()
    )
}

fun onLoginClicked(email: String, password: String, navController: NavHostController) {
    if (validateEmailAndPassword(email, password)) {
        navController.navigate(MAIN_NAV_HOME) {
            popUpTo(MAIN_NAV_WELCOME) { inclusive = true }
        }
    }
}

fun validateEmailAndPassword(email: String, password: String): Boolean {
    Log.d("validateEmailAndPassword", "email: $email  password: $password")
    return true // TODO
}
