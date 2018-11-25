package org.linuxalert.downstairs

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.inputmethod.InputMethodManager


class ScanWineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_wine)

        findViewById<EditText>(R.id.wineId).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    Toast.makeText(v.context, "Wine we looking for!", Toast.LENGTH_SHORT).show()
                    false
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }

    fun onInsertWine(view: View) {
        if (this.currentFocus != null) {
            val inputManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                    this.currentFocus!!.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS)
        }
        Toast.makeText(this, "More Wine!", Toast.LENGTH_SHORT).show()
        finish()
    }

    fun onTakeOutWine(view: View) {
        if (this.currentFocus != null) {
            val inputManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                    this.currentFocus!!.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS)
        }
        Toast.makeText(this, "Gone!", Toast.LENGTH_SHORT).show()
        finish()
    }

}
