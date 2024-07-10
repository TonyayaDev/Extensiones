package com.tonyayadev.myapplication

//
// Created by TonyayaDev on jue 27/jun/2024.
// Copyright (c) 2024 TonyayaDev. All rights reserved.
//



import android.os.Build
import android.text.Editable
import android.util.Log
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

enum class formatDate(){
    SMALL,
    NORMAL,
    MEDIUM,
    LONG,
    XLONG

}

val dateForm: List<String> = listOf(
    " ",
    "dd/MM/yy",             //  1
    "dd/MMM/yy",            //  2
    "dd/MMMM/yy",           //  3
    "dd/MM/yyyy",           //  4
    "dd/MMM/yyyy",          //  5
    "dd/MMMM/yyyy",         //  6

    "yyyy/MM/dd",           //  7
    "yyyy/MMM/dd",          //  8
    "yyyy/MMMM/dd",         //  9

    "E dd/MM/yy",          // 10
    "E dd/MMM/yy",         // 11
    "E dd/MMMM/yy",        // 12
    "E dd/MM/yyyy",        // 13
    "E dd/MMM/yyyy",       // 14
    "E dd/MMMM/yyyy",      // 15

    "E yyyy/MM/dd",        // 16
    "E yyyy/MMM/dd",       // 17
    "E yyyy/MMMM/dd",      // 18

    "EEEE dd/MM/yy",        // 19
    "EEEE dd/MMM/yy",       // 20
    "EEEE dd/MMMM/yy",      // 21
    "EEEE dd/MMM/yyyy",     // 22
    "EEEE dd/MMM/yyyy",     // 23
    "EEEE dd/MMMM/yyyy",    // 24

    "EEEE yyyy/MM/dd",      // 25
    "EEEE yyyy/MMM/dd",     // 26
    "EEEE yyyy/MMMM/dd"     // 27
)

val timeForm: List<String> = listOf(
    " ",
    "HH:mm",                //  1
    "HH:mm:ss",             //  2
    "HH:mm:ss-SSS",         //  3
    "hh:mm a",              //  4
    "hh:mm:ss a",           //  5
    "HH:mm:ss-SSS a"        //  6
)


////////////// DATE FORMATING  ////////////////

/**
 * Pasa un Date a un String con formato de fecha segun el formato seleccionado.
 *
 * @param d Selecciona el formato segun listado siguiente.
 *
 *     "dd/MM/yy"             //  1
 *     "dd/MMM/yy"            //  2
 *     "dd/MMMM/yy"           //  3
 *     "dd/MM/yyyy"           //  4
 *     "dd/MMM/yyyy"          //  5
 *     "dd/MMMM/yyyy"         //  6
 *
 *     "yyyy/MM/dd"           //  7
 *     "yyyy/MMM/dd"          //  8
 *     "yyyy/MMMM/dd"         //  9
 *
 *     "E dd/MM/yy"           // 10
 *     "E dd/MMM/yy"          // 11
 *     "E dd/MMMM/yy"         // 12
 *     "E dd/MM/yyyy"         // 13
 *     "E dd/MMM/yyyy"        // 14
 *     "E dd/MMMM/yyyy"       // 15
 *
 *     "E yyyy/MM/dd"         // 16
 *     "E yyyy/MMM/dd"        // 17
 *     "E yyyy/MMMM/dd"       // 18
 *
 *     "EEEE dd/MM/yy"        // 19
 *     "EEEE dd/MMM/yy"       // 20
 *     "EEEE dd/MMMM/yy"      // 21
 *     "EEEE dd/MMM/yyyy"     // 22
 *     "EEEE dd/MMM/yyyy"     // 23
 *     "EEEE dd/MMMM/yyyy"    // 24
 *
 *     "EEEE yyyy/MM/dd"      // 25
 *     "EEEE yyyy/MMM/dd"     // 26
 *     "EEEE yyyy/MMMM/dd"    // 27
 *
 */
fun Date.toDateFormat(d: Int): String {
    var formated = ""
    formated = if (d < 1 || d > dateForm.size - 1) {
        dateForm[2]
    } else {
        dateForm[d]
    }
    val temp = SimpleDateFormat(formated, Locale.getDefault())
    return temp.format(this)
}

/**
 * Pasa un Date a un String con formato de fecha segun el formato seleccionado.
 *
 * @param f Selecciona el formato segun listado siguiente
 *
 *
 *     SMALL   ->   "dd/MM/yy"
 *     NORMAL  ->   "dd/MM/yyyy"
 *     MEDIUM  ->   "dd/MMM/yyyy"
 *     LONG    ->   "EEEE dd/MM/yy"
 *     XLONG   ->   "EEEE dd/MMMM/yyyy"
 *
 */
fun Date.toDateFormat(f: formatDate): String{
  when(f){
      formatDate.SMALL -> return this.toDateFormat(1)
      formatDate.NORMAL -> return this.toDateFormat(4)
      formatDate.MEDIUM -> return this.toDateFormat(5)
      formatDate.LONG -> return this.toDateFormat(19)
      formatDate.XLONG -> return this.toDateFormat(24)
  }
}


/////////////// TIME FORMATING //////////////

/**
 * Pasa un Date a un String con formato de hora segun el formato seleccionado
 *
 * @param d Selecciona el formato segun el siguiente listado
 *
 *     "HH:mm"                //  1
 *     "HH:mm:ss"             //  2
 *     "HH:mm:ss-SSS"         //  3
 *     "hh:mm a"              //  4
 *     "hh:mm:ss a"           //  5
 *     "HH:mm:ss-SSS a"       //  6
 */
fun Date.toTimeFormat(d: Int): String {

    var formated = ""
    formated = if (d < 1 || d > timeForm.size - 1) {
        timeForm[1]
    } else {
        timeForm[d]
    }
    val temp = SimpleDateFormat(formated, Locale.getDefault())
    return temp.format(this)
}


/////////////  INCREASE AND DESCREASE DATE  //////////////////

/**
 * Resta las horas que se le indiquen por el parametro
 *
 * @param des Restara las horas que se le pasen
 */
fun Date.descreaseHour(des: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.HOUR_OF_DAY, -des)
    return cal.time
}

/**
 * Suma las horas que se le indiquen por el parametro
 *
 * @param inc Sumara las horas que se le pasen
 */
fun Date.increaseHour(inc: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.HOUR_OF_DAY, inc)
    return cal.time
}

/**
 * Resta los minutos que se le indiquen por el parametro
 *
 * @param des Restara los minutos que se le pasen
 */
fun Date.descreaseMinute(des: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.MINUTE, -des)
    return cal.time
}

/**
 * Suma los minutos que se le indiquen por el parametro
 *
 * @param inc Sumara los minutos que se le pasen
 */
fun Date.increaseMinute(inc: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.MINUTE, inc)
    return cal.time
}

/**
 * Resta los dias que se le indiquen por el parametro
 *
 * @param des Restara los dias que se le pasen
 */
fun Date.descreaseDay(des: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.DAY_OF_MONTH, -des)
    return cal.time
}

/**
 * Suma los dias que se le indiquen por el parametro
 *
 * @param inc Sumara los dias que se le pasen
 */
fun Date.increaseDay(inc: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.DAY_OF_MONTH, inc)
    return cal.time
}

/**
 * Resta los meses que se le indiquen por el parametro
 *
 * @param des Restara los meses que se le pasen
 */
fun Date.descreaseMonth(des: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.MONTH, -des)
    return cal.time
}

/**
 * Suma los meses que se le indiquen por el parametro
 *
 * @param inc Sumara los meses que se le pasen
 */
fun Date.increaseMonth(inc: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.MONTH, inc)
    return cal.time
}

/**
 * Resta los años que se le indiquen por el parametro
 *
 * @param des Restara laños que se le pasen
 */
fun Date.descreaseYear(des: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.YEAR, -des)
    return cal.time
}

/**
 * Suma los años que se le indiquen por el parametro
 *
 * @param inc Sumara los años que se le pasen
 */
fun Date.increaseYear(inc: Int): Date {
    val cal = Calendar.getInstance()
    cal.setTime(this)
    cal.add(Calendar.YEAR, inc)
    return cal.time
}

/**
 * Pasa un Long (millisegundo) a un String con formato de fecha segun el formato seleccionado.
 *
 * @param d Selecciona el formato segun listado siguiente.
 *
 *     "dd/MM/yy"             //  1
 *     "dd/MMM/yy"            //  2
 *     "dd/MMMM/yy"           //  3
 *     "dd/MM/yyyy"           //  4
 *     "dd/MMM/yyyy"          //  5
 *     "dd/MMMM/yyyy"         //  6
 *
 *     "yyyy/MM/dd"           //  7
 *     "yyyy/MMM/dd"          //  8
 *     "yyyy/MMMM/dd"         //  9
 *
 *     "E dd/MM/yy"           // 10
 *     "E dd/MMM/yy"          // 11
 *     "E dd/MMMM/yy"         // 12
 *     "E dd/MM/yyyy"         // 13
 *     "E dd/MMM/yyyy"        // 14
 *     "E dd/MMMM/yyyy"       // 15
 *
 *     "E yyyy/MM/dd"         // 16
 *     "E yyyy/MMM/dd"        // 17
 *     "E yyyy/MMMM/dd"       // 18
 *
 *     "EEEE dd/MM/yy"        // 19
 *     "EEEE dd/MMM/yy"       // 20
 *     "EEEE dd/MMMM/yy"      // 21
 *     "EEEE dd/MMM/yyyy"     // 22
 *     "EEEE dd/MMM/yyyy"     // 23
 *     "EEEE dd/MMMM/yyyy"    // 24
 *
 *     "EEEE yyyy/MM/dd"      // 25
 *     "EEEE yyyy/MMM/dd"     // 26
 *     "EEEE yyyy/MMMM/dd"    // 27
 *
 */
fun Long.dateDate(d: Int): String {
    val temp = Date(this)
    return temp.toDateFormat(d)
}

/**
 * Pasa un Long (millisegundo) a un String con formato de hora segun el formato seleccionado
 *
 * @param d Selecciona el formato segun el siguiente listado
 *
 *     "HH:mm"                //  1
 *     "HH:mm:ss"             //  2
 *     "HH:mm:ss-SSS"         //  3
 *     "hh:mm a"              //  4
 *     "hh:mm:ss a"           //  5
 *     "HH:mm:ss-SSS a"       //  6
 */
fun Long.dateTime(d: Int): String {
    val temp = Date(this)
    return temp.toTimeFormat(d)
}

////////////////////////  DAY AND MONTH IN TWO DIGITS //////////////////////

/**
 * Pasa un entero de una cifra a String de dos cifras para fechas y horas
 */
fun Int.twoDigDate(): String {
    val temp = if (this < 10) {
        "0$this"
    } else {
        this.toString()
    }
    return temp
}

////////////////////////  STRING TO DATE FIREBASE //////////////////////

/**
 * Pasa un String con una fecha a un Long (millisegundo) para usar en FireBase
 */

fun String.toDateFire(): Long {
    val temp = this.toDateDate()
    return temp.time
}

////////////////////////  STRING TO TIME FIREBASE //////////////////////

/**
 * Pasa un String con una hora a un Long (millisegundo) para usar en FireBase
 */
fun String.toTimeFire(): Long {
    var temp: Int = 0
    var ind = this.checkTimeFormat()
    var str = this
    if(ind < 3){
        str = correctionAmPm(this, ind)
        ind -= 3
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val temp1 = LocalTime.parse(str, DateTimeFormatter.ofPattern(timeForm[ind]))
        temp = temp1.toSecondOfDay() * 1000
    }
    return temp.toLong()
}

////////////////////////  STRING TO DATE DATE //////////////////////

/**
 * Pasa un String de fecha a un Date comprobando el formato que usa el String
 */
fun String.toDateDate(): Date {
    return SimpleDateFormat(dateForm[this.checkDateFormat()], Locale.getDefault()).parse(this)!!
}

////////////////////////  STRING TO TIME DATE //////////////////////

/**
 * Pasa un String de hora a un Date comprobando el formato que usa el String
 */
fun String.toTimeDate(): Date {
    var ind = this.checkTimeFormat()
    var str = this
    if(ind > 3){
        str = correctionAmPm(this, ind)
        ind -= 3
    }
    return SimpleDateFormat(timeForm[ind], Locale.getDefault()).parse(str)!!
}

////////////////////////  CHECKING //////////////////////

/**
 * Chequea el formato de fecha que usa un String
 */
fun String.checkDateFormat(): Int {
    var tempNum: String = ""
    var tempLet: String = ""
    var contNum: Int = 0
    var contLet: Int = 0
    var pos: Int = 0
    var res = 0
    var numFor = Array(4) { 0 }
    for (i in this) {
        if (i.isDigit()) {
            tempNum += i
            contNum++
            if (pos == 0) {
                pos = 1
            }
        }// End number check
        else if (i.isLetter()) {
            tempLet += i
            contLet++
        } // End letter check
        else if (i == ' ') {
            if (contLet == 3) {
                numFor[0] = 9
            } else if (contLet > 3) {
                numFor[0] = 18
            }
            contLet = 0
            tempLet = ""
            pos = 1
        }// End blank space check
        else if (i == '/') {
            if (pos == 0) numFor[0] = 0
            if (contNum == 2) {
                if (pos == 1) {
                    numFor[1] = 1
                } else if (pos == 2) {
                    numFor[2] = 0
                }
            } else if (contNum > 2) {
                if (pos == 1) {
                    numFor[1] = 7
                }
            } else if (contLet == 3) {
                numFor[2] = 1
            } else if (contLet > 3) {
                numFor[2] = 2
            }
            tempNum = ""
            tempLet = ""
            contNum = 0
            contLet = 0
            if (pos < 3) pos++
        }// End slash check
    }
    if (contNum == 2) {
        numFor[3] = 0
    } else if (contNum > 2) {
        numFor[3] = 3
    }
    for (i in numFor) {
        res += i
    }
    return res
}

/**
 * Checkea el formato de hora que usa un String
 */
fun String.checkTimeFormat(): Int {
    var res = 0
    var cont = 0
    for (i in this) {
        if (i == ':' || i == '-') {
            cont++
        } else if (i == ' ') {
            res += 3
        }
    }

    if (cont == 1) {
        res += 1
    } else if (cont == 2) {
        res += 2
    }else if (cont == 3){
        res += 3
    }

    return res

}

/**
 * Corrige el uso del formato con AM - PM
 */
fun correctionAmPm(st: String, end: Int): String {
    var temp = ""
    var en = 0
    var co = 0
    if(end == 4){
        en = 5
        co = 6
    }else if(end == 5){
        en = 8
        co = 9
    }else if(end == 6){
        en = 12
        co = 13
    }

    if (st[co] == 'p' || st[co] == 'P') {
        var temT = st.substring(0, 2)
        temT = (temT.toInt() + 12).toString()
        temp = temT + st.substring(2)
        temp = temp.substring(0, en)

    } else if (st[co] == 'a' || st[co] == 'A') {
        temp = st.substring(0, en)
    }
return temp
}



