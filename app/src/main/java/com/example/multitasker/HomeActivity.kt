package com.example.multitasker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Map Intent
        val map = findViewById<Button>(R.id.mapBtn)
        map.setOnClickListener{
            displayMap("geo:16.4023,120.5960?z=12")
        }

        // Email Intent
        val emailBtn = findViewById<Button>(R.id.emailBtn)
        emailBtn.setOnClickListener{
            composeEmail(arrayOf("peralta.giantroi@gmail.com"), "Hello")
        }

        // Web Browser Intent
        val search = findViewById<Button>(R.id.searchBtn)
        search.setOnClickListener{
            openWebPage("https://www.google.com/")
        }

        //The intent failed because the file opened was not specified as an audio file in the intent filter
        val audio = findViewById<Button>(R.id.audioBtn)
        audio.setOnClickListener{
            val audioUri = Uri.parse("file:///Internal Storage/Download/song.mp3")
            playMusic(audioUri)
        }

        //The intent failed because the file could not be located
        val pdfBtn = findViewById<Button>(R.id.pdfBtn)
        pdfBtn.setOnClickListener{
            val pdfUri = Uri.parse("file:///Internal Storage/Download/test.pdf")
            viewFile(pdfUri)
        }


    }

    private fun displayMap(geoLocation: String) {
        val baguioUri = Uri.parse(geoLocation)
        val intent = Intent(Intent.ACTION_VIEW, baguioUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openWebPage(url: String) {
        val google: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, google)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun playMusic(file: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, file)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun viewFile(file: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, file)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


}
