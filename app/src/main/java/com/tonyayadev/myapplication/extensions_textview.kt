package com.tonyayadev.myapplication

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import android.widget.EditText
import android.widget.TextView

//
// Created by TonyayaDev on lun 08/jul/2024.
// Copyright (c) 2024 TonyayaDev. All rights reserved.
//


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
fun TextView.ShadowText(
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
 * Tamaño del titulo en negritas y centrado con un tamaño de 40F
 */
fun TextView.T1() {
    this.also {
        textSize = 40F
        setTypeface(Typeface.DEFAULT_BOLD)
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * Tamaño del titulo en negritas y centrado con un tamaño de 37F
 */
fun TextView.T2() {
    this.also {
        textSize = 37F
        setTypeface(Typeface.DEFAULT_BOLD)
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * Tamaño del titulo en negritas y centrado con un tamaño de 34F
 */
fun TextView.T3() {
    this.also {
        textSize = 34F
        setTypeface(Typeface.DEFAULT_BOLD)
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * Tamaño del titulo en negritas y centrado con un tamaño de 31F
 */
fun TextView.T4() {
    this.also {
        textSize = 31F
        setTypeface(Typeface.DEFAULT_BOLD)
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * Tamaño del titulo en negritas y centrado con un tamaño de 28F
 */
fun TextView.T5() {
    this.also {
        textSize = 28F
        setTypeface(Typeface.DEFAULT_BOLD)
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * Tamaño del titulo en negritas y centrado con un tamaño de 25F
 */
fun TextView.T6() {
    this.also {
        textSize = 25F
        setTypeface(Typeface.DEFAULT_BOLD)
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 18F
 */
fun TextView.L1() {
    this.also {
        textSize = 18F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 16F
 */
fun TextView.L2() {
    this.also {
        textSize = 16F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 14F
 */
fun TextView.L3() {
    this.also {
        textSize = 14F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 12F
 */
fun TextView.L4() {
    this.also {
        textSize = 12F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 10F
 */
fun TextView.L5() {
    this.also {
        textSize = 10F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Tamaño de un label en italica con un tamaño de 8F
 */
fun TextView.L6() {
    this.also {
        textSize = 8F
        setTypeface(null, Typeface.ITALIC)
    }
}

/**
 * Pone el texto subrallado
 */
fun TextView.UnderLine() {
    this.paintFlags = Paint.UNDERLINE_TEXT_FLAG
}

/**
 * Pone el texto tachado
 */
fun TextView.StrikeText() {
    this.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
}

/**
 * Pone el texto en falsas negritas
 */
fun TextView.FakeBoldText() {
    this.paintFlags = Paint.FAKE_BOLD_TEXT_FLAG
}

/**
 * Cambia el color del texto del TextView
 *
 * @param s Es el color que tendra el texto en hexadecimal
 *
 *
 */
fun TextView.ColorText(s: String) {
    this.setTextColor(Color.parseColor(s))
}

/**
 * Cambia el color del fondo del TextView
 *
 * @param s Es el color que tendra el fondo en hexadecimal
 *
 *
 */

fun TextView.Backgroup(s: String) {
    this.setBackgroundColor(Color.parseColor(s))
}





