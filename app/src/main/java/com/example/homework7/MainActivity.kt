package com.example.homework7

import android.os.Bundle
import android.text.InputType
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.homework7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            if (binding.inputNameEt.text.toString().isNotEmpty()) {
                val mainLayout = binding.mainLayout as LinearLayout
                val layoutSize = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val appCompatEt = AppCompatEditText(this)

                 if (binding.checkbox.isChecked) {
                     appCompatEt.hint = "Enter Field Numeric"
                     appCompatEt.inputType = InputType.TYPE_CLASS_NUMBER
                     mainLayout.addView(appCompatEt, layoutSize)
                 } else {
                     appCompatEt.hint = "Enter Field Name"
                     appCompatEt.inputType = InputType.TYPE_CLASS_TEXT
                     mainLayout.addView(appCompatEt, layoutSize)
                 }
            } else {
                Toast.makeText(this, "Empty!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}