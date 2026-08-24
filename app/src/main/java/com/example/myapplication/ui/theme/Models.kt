package com.example.myapplication.ui.theme

data class Recipe(
    val id: Int,
    val text: String
)

data class Dish(
    val id: Int,
    val name: String,
    val recipes: List<Recipe> = emptyList()
)
