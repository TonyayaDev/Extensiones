package com.tonyayadev.myapplication


import android.icu.text.TimeZoneFormat
import android.os.Build
import android.text.Editable
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.font.Typeface


//
// Created by TonyayaDev on mié 03/jul/2024.
// Copyright (c) 2024 TonyayaDev. All rights reserved.
//


/////////////// TEXT TO EDITABLE  //////////////

/**
 * Pasa un String a editable para usarlo en un EditText
 */
fun String.stringToEdit(): Editable {
    val temp = Editable.Factory.getInstance().newEditable(this)
    return temp
}









