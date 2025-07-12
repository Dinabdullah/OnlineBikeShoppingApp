package com.example.onlinebikeshoppingapp.firstScreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class DataTypes(){
    data class Image(@DrawableRes val image: Int) : DataTypes()
    data class Text(@StringRes val text: Int) : DataTypes()
}
