package com.edaakyil.android_kotlin_intend

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edaakyil.android_kotlin_intend.constant.USERNAME

class UserProfileActivity : AppCompatActivity() {
    private lateinit var mTextViewUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initialize()
    }

    private fun initialize() {
        initViews()
        fetchUsername()
    }

    private fun initViews() {
        mTextViewUsername = findViewById(R.id.userProfileActivityUsername)
    }

    private fun fetchUsername() {
        mTextViewUsername.text = intent.getStringExtra(USERNAME)
    }

}