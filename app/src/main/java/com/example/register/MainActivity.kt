package com.example.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        val firstName: EditText = findViewById(R.id.firstName)
        val lastName: EditText = findViewById(R.id.lastName)
        val genderGroup: RadioGroup = findViewById(R.id.genderGroup)
        val address: EditText = findViewById(R.id.address)
        val email: EditText = findViewById(R.id.email)
        val agreeToTerms: CheckBox = findViewById(R.id.agreeToTerms)
        val registerButton: Button = findViewById(R.id.registerButton)

        val datePickerButton: Button = findViewById(R.id.datePickerButton)
        val birthday: EditText = findViewById(R.id.birthday)

        datePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val dateString = getString(R.string.date_format, selectedDay, selectedMonth + 1, selectedYear)
                birthday.setText(dateString)
            }, year, month, day).show()

        }

        registerButton.setOnClickListener {
            if (firstName.text.isNotEmpty() && lastName.text.isNotEmpty() &&
                genderGroup.checkedRadioButtonId != -1 && address.text.isNotEmpty() &&
                email.text.isNotEmpty() && agreeToTerms.isChecked) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in all fields and agree to the terms.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}