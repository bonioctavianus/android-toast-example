package com.bonioctavianus.toastexample

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.custom_toast.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_default_toast.setOnClickListener {
            Toast.makeText(this, "Default Toast", Toast.LENGTH_SHORT).show()
        }

        btn_top_toast.setOnClickListener {
            Toast.makeText(this, "Top Toast", Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.TOP, 0, 256)
                show()
            }
        }

        btn_custom_toast.setOnClickListener {
            val layout = layoutInflater.inflate(
                R.layout.custom_toast,
                container_custom_toast
            ).apply { tv_toast.text = "Custom Toast" }

            Toast(this).apply {
                duration = Toast.LENGTH_SHORT
                view = layout
                show()
            }
        }
    }
}