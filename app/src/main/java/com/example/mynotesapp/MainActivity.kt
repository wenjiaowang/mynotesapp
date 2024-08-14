package com.example.mynotesapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynotesapp.ui.theme.MainActivityTheme

class MainActivity : AppCompatActivity() {


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                // Handle settings action
                true
            }
            R.id.menu_help -> {
                // Handle help action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lateinit var btnSendNote: Button
        lateinit var etNote: EditText

        btnSendNote = findViewById(R.id.btnSendNote)
        etNote = findViewById(R.id.etNote)

        btnSendNote.setOnClickListener {
            val note = etNote.text.toString()
            val intent = Intent(this, DisplayActivity::class.java).apply{
                putExtra("EXTRA_NOTE", note)
            }
            startActivity(intent)
        }
    }
}

