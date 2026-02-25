package com.fadymarty.ui_kit.common

import java.text.DecimalFormat

fun Int.format(): String {
    return DecimalFormat("#,###")
        .format(this)
        .replace(",", " ")
}