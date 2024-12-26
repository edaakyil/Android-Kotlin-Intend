package com.edaakyil.android_kotlin_intend

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edaakyil.android_kotlin_intend.constant.USERNAME

class MainActivity : AppCompatActivity() {
    private lateinit var mButtonCall: Button
    private lateinit var mButtonGoWebsite1: Button
    private lateinit var mButtonGoWebsite2: Button
    private lateinit var mButtonGoActivity: Button
    private lateinit var mEditTextUsername: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initialize()
    }

    private fun initialize() = initViews()

    private fun initViews() {
        mEditTextUsername = findViewById(R.id.mainActivityEditTextUsername)
        initGoWebsite1Button()
        initGoWebsite2Button()
        initCallSomeoneButton()
        initGoUserProfileActivityButton()
    }

    private fun goUserProfileActivityButtonClickCallback() {
        val intent = Intent(this, UserProfileActivity::class.java)
        intent.putExtra(USERNAME, mEditTextUsername.text.toString())
        startActivity(intent)
    }

    private fun initGoUserProfileActivityButton() {
        mButtonGoActivity = findViewById(R.id.mainActivityButtonOpenActivity)
        mButtonGoActivity.setOnClickListener { goUserProfileActivityButtonClickCallback() }
    }

    private fun goWebsite1ButtonClickCallback() {
            val website = Uri.parse("https://hyperskill.org")
            val intent = Intent(Intent.ACTION_VIEW, website)
            startActivity(intent)
    }

    private fun initGoWebsite1Button() {
        mButtonGoWebsite1 = findViewById(R.id.mainActivityButtonOpenWebsite1)
        mButtonGoWebsite1.setOnClickListener { goWebsite1ButtonClickCallback() }
    }

    private fun goWebsite2ButtonClickCallback() {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("https://hyperskill.org")
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        startActivity(intent)
    }

    private fun initGoWebsite2Button() {
        mButtonGoWebsite2 = findViewById(R.id.mainActivityButtonOpenWebsite2)
        mButtonGoWebsite2.setOnClickListener { goWebsite2ButtonClickCallback() }
    }

    private fun callSomeoneButtonClickCallback() {
        val phoneNumber = Uri.parse("tel:(650)555-1212")
        val intent = Intent(Intent.ACTION_DIAL,phoneNumber)
        startActivity(intent)
    }

    private fun initCallSomeoneButton()
    {
        mButtonCall = findViewById(R.id.mainActivityButtonCall)
        mButtonCall.setOnClickListener { callSomeoneButtonClickCallback() }
    }
}