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
package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.isDarkTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.transparent
import com.example.androiddevchallenge.ui.theme.white

val ButtonModifier = Modifier
    .height(48.dp)
    .fillMaxWidth()
    .padding(horizontal = 16.dp)

@Preview("PrimaryButton", widthDp = 360, heightDp = 48)
@Composable
fun PrimaryButton(
    @PreviewParameter(OnClickProvider::class) onClick: () -> Unit,
    text: String = ""
) = Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = if (isDarkTheme()) gray else white
    ),
    shape = MaterialTheme.shapes.medium,
    modifier = ButtonModifier
) {
    Text(text)
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun SecondaryButton(
    @PreviewParameter(OnClickProvider::class) onClick: () -> Unit,
    text: String = "",
    yOffsetDp: Dp = 0.dp
) = Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
        backgroundColor = transparent,
        contentColor = if (isDarkTheme()) white else pink900
    ),
    shape = MaterialTheme.shapes.medium,
    elevation = ButtonDefaults.elevation(0.dp),
    modifier = ButtonModifier.offset(y = yOffsetDp)
) {
    Text(text)
}

class OnClickProvider(override val values: Sequence<() -> Unit> = sequenceOf({})) :
    PreviewParameterProvider<() -> Unit>
