package com.example.marketapplication.utils

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

object ValidationUtils {

    fun validation(editText: EditText, textInputLayout: TextInputLayout) : Boolean {
        if (editText.text.toString().trim().isEmpty()) {
            textInputLayout.error = "Поле не повинно бути порожнім"
            editText.requestFocus()
            return false

        }else{
            textInputLayout.isErrorEnabled = false
        }
        return true

    }
}