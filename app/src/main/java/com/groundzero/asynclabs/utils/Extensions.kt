package com.groundzero.asynclabs.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.go(resId: Int) {
    findNavController().navigate(resId)
}