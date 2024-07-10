package com.tonyayadev.myapplication

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import android.widget.EditText
import android.widget.TextView

//
// Created by TonyayaDev on mié 10/jul/2024.
// Copyright (c) 2024 TonyayaDev All rights reserved.
//

/**
 * Se añade un hint con el texto que se ponga
 *
 * @param s Es el texto que se pondra como hint
 */

fun EditText.AddHint(s: String) {
    this.hint = s
    this.setTextColor(Color.parseColor("#888888"))
}

/**
 * Cambia el color del texto del Hint
 *
 * @param s Es el color que tendra el texto en hexadecimal
 *
 */

fun EditText.HintColor(s: String){
    this.setHintTextColor(Color.parseColor(s))
}


/**
 * Configuracion de la sombra en el texto los parametros
 * se pueden omitir ya que tienen valores por defecto
 *
 *
 * @param radius Es la resolucion de la sombra
 * @param dx Es la posicion de la sombra, positivo hacia la derecha, negativo hacia
 * la izquierda
 * @param dy Es la posicion en la sombra, positivo hacia abajo, negativo hacia
 * arriba
 * @param colorText Es el color del texto en hexadecimal
 * @param colorShade Es el color de la sombra en hexadecimal
 *
 */
fun EditText.Shadow(
    radius: Float = 4F,
    dx: Float = 10F,
    dy: Float = 1F,
    colorText: String = "#020202",
    colorShade: String = "#A09EA3"
) {
    this.also {
        setShadowLayer(radius, dx, dy, Color.parseColor(colorShade))
        setTextColor(Color.parseColor(colorText))
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 20F
 */
fun EditText.E1() {
    this.also {
        textSize = 20F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 18F
 */
fun EditText.E2() {
    this.also {
        textSize = 18F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 16F
 */
fun EditText.E3() {
    this.also {
        textSize = 16F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 14F
 */
fun EditText.E4() {
    this.also {
        textSize = 14F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 12F
 */
fun EditText.E5() {
    this.also {
        textSize = 12F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 10F
 */
fun EditText.E6() {
    this.also {
        textSize = 10F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Pone el texto en falsas negritas
 */
fun EditText.FakeBoldText() {
    this.paintFlags = Paint.FAKE_BOLD_TEXT_FLAG
}

/**
 * Cambia el color del texto del EditText
 *
 * @param s Es el color que tendra el texto en hexadecimal
 *
 *
 */
fun EditText.ColorText(s: String) {
    this.setTextColor(Color.parseColor(s))
}

/**
 * Cambia el color del fondo del EditText
 *
 * @param s Es el color que tendra el fondo en hexadecimal
 *
 *
 */

fun EditText.Backgroup(s: String) {
    this.setBackgroundColor(Color.parseColor(s))
}

/**
 * Situa el texto centrado
 */

fun EditText.Center() {
    this.textAlignment = View.TEXT_ALIGNMENT_CENTER
}

/**
 * Situa el texto a la derecha
 */


fun EditText.Right() {
    this.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
}