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
package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PlantImage
import com.example.androiddevchallenge.model.dummyDesignGardenImages
import com.example.androiddevchallenge.model.dummyThemeImages
import com.example.androiddevchallenge.ui.theme.defaultHorizontalPadding
import com.example.androiddevchallenge.ui.theme.gray150
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeTab(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.defaultHorizontalPadding()
            ) {
                var searchText by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = {
                        Text(
                            stringResource(R.string.home_search_label),
                            color = MaterialTheme.colors.onPrimary,
                            style = MaterialTheme.typography.body1
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            tint = MaterialTheme.colors.onPrimary,
                            contentDescription = ""
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.home_browse_themes_label),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.defaultHorizontalPadding()
            )
            Spacer(modifier = Modifier.height(16.dp))
            BrowseThemesList(plantImages = dummyThemeImages)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.home_design_your_home_garden_label),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_filter_list),
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = ""
                )
            }
            DesignGardenList(plantImages = dummyDesignGardenImages)
        }
    }
}

@Composable
fun BrowseThemesList(plantImages: List<PlantImage>) = LazyRow(
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
    modifier = Modifier
        .height(136.dp)
        .fillMaxWidth()
) { items(plantImages) { plantImage -> BrowseThemesItem(plantImage) } }

@Composable
fun BrowseThemesItem(plantImage: PlantImage) = Card(
    shape = MaterialTheme.shapes.small,
    elevation = 1.dp,
    border = BorderStroke(1.dp, gray150),
    modifier = Modifier
        .fillMaxHeight()
        .padding(end = 8.dp)
) {
    Column {
        CoilImage(
            data = plantImage.url,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(136.dp)
                .height(100.dp)
        )
        Text(
            text = plantImage.descriptor,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun DesignGardenList(plantImages: List<PlantImage>) =
    LazyColumn(contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp)) {
        items(plantImages) { plantImage -> DesignGardenItem(plantImage) }
    }

@Composable
fun DesignGardenItem(plantImage: PlantImage) {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .defaultHorizontalPadding()
    ) {
        Card(
            shape = MaterialTheme.shapes.small,
            elevation = 1.dp,
            modifier = Modifier.size(64.dp)
        ) {
            CoilImage(
                data = plantImage.url,
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .defaultHorizontalPadding()
                .align(Alignment.CenterVertically)
        ) {
            Text(text = plantImage.descriptor, style = MaterialTheme.typography.h2)
            Text(text = "This is a description", style = MaterialTheme.typography.body1)
        }
        Checkbox(
            checked = checked, onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.onSecondary),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
    Divider(startIndent = 80.dp, modifier = Modifier.defaultHorizontalPadding())
}
