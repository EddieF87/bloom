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
package com.example.androiddevchallenge.model

data class PlantImage(val url: String, val descriptor: String, val credits: String)

val dummyThemeImages = listOf(
    PlantImage(
        url = "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Desert chic",
        credits = "Photo by Quang Nguyen Vinh from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        descriptor = "Tiny terrariums",
        credits = "Photo by Katarazyna Modrzejewska from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
        descriptor = "Jungle vibes",
        credits = "Photo by Volkan Vardar from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Easy care",
        credits = "Photo by Владимир Гладков from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Statements",
        credits = "Photo by Sidnei Maia from Pexels"
    ),
)

val dummyDesignGardenImages = listOf(
    PlantImage(
        url = "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Monstera",
        credits = "Photo by Huy Phan from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Aglaonema",
        credits = "Photo by Karolina Grabowska from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
        descriptor = "Peace lily",
        credits = "Photo by Melvin Vito from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Fiddle leaf",
        credits = "Photo by Владимир Гладков from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Snake plant",
        credits = "Photo by Fabian Stroobants from Pexels"
    ),
    PlantImage(
        url = "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
        descriptor = "Pothos",
        credits = "Photo by Faraz Ahmad from Pexels"
    ),
)
