package com.example.happyshopper.presentation.ui.components

enum class CratePos(val value: Int) {
    POSITION_ONE(randomNumber()),
    POSITION_TWO(randomNumber()),
    POSITION_THREE(randomNumber()),
    POSITION_FOUR(randomNumber()),
    POSITION_FIVE(randomNumber()),
    POSITION_SIX(randomNumber()),
    POSITION_SEVEN(randomNumber()),
    POSITION_EIGHT(randomNumber())
}

fun randomNumber(): Int {
    return (530000..530999).shuffled().first()
}

