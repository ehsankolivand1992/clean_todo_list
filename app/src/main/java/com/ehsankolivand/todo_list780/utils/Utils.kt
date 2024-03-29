package com.ehsankolivand.todo_list780.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun hideKeyboard(activity: Activity) {
    val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentFocusedView = activity.currentFocus
    currentFocusedView?.let {
        inputMethodManager.hideSoftInputFromWindow(
            currentFocusedView.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}


fun LocalDateTime.toShow(): String {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    return this.format(formatter)
}
