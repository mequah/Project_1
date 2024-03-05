package com.example.project_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_move_activity -> {
            val  moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivities(arrayOf(moveIntent))
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Alfisah")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person (
                    "Alfisah",
                    5,
                    "alfisahdamayanti@gmail.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "08213153427"
                val dialPhoneIntent = Intent(Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber")))
                startActivity(dialPhoneIntent)
            }
        }

           }
    }