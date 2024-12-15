package com.example.uas_ppapb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.uas_ppapb.network.ApiClient
import com.example.uas_ppapb.databinding.ActivityAdminEditFilmBinding
import com.example.uas_ppapb.model.FilmUserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Mengedit data film oleh admin
class AdminEditFilmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminEditFilmBinding

    private var movieId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdminEditFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieId = intent.getStringExtra("id")
        movieId = intent.getStringExtra("_id")

        binding.txtTitleEdit.setText(intent.getStringExtra("title"))
        binding.txtDirectorEdit.setText(intent.getStringExtra("director"))
        binding.txtDurasiEdit.setText(intent.getStringExtra("durasi"))
        binding.txtRatingEdit.setText(intent.getStringExtra("rating"))
        binding.txtSinopsisEdit.setText(intent.getStringExtra("sinopsis"))

        binding.btnUpdate.setOnClickListener {
            updateFilmData()
        }

        binding.buttonBack.setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeAdminActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun updateFilmData() {
        lifecycleScope.launch {
            try {
                val updatedTitle = binding.txtTitleEdit.text.toString()
                val updatedDirector = binding.txtDirectorEdit.text.toString()
                val updatedDurasi = binding.txtDurasiEdit.text.toString()
                val updatedRating = binding.txtRatingEdit.text.toString()
                val updatedSinopsis = binding.txtSinopsisEdit.text.toString()
                val updatedImageUrl = binding.txtImageEdit.text.toString()

                val filmData = FilmUserData(
                    _id = movieId,
                    title = updatedTitle,
                    director = updatedDirector,
                    durasi = updatedDurasi,
                    rating = updatedRating,
                    sinopsis = updatedSinopsis,
                    imageUrl = updatedImageUrl
                )

                val response = withContext(Dispatchers.IO) {
                    ApiClient.api.updateMovie(movieId!!, filmData)
                }

                if (response.isSuccessful) {
                    Toast.makeText(this@AdminEditFilmActivity, "Film berhasil diperbarui!", Toast.LENGTH_SHORT).show()
                    navigateToHome()
                } else {
                    Toast.makeText(this@AdminEditFilmActivity, "Gagal memperbarui film", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("Update Error", "Gagal memperbarui data", e)
                Toast.makeText(this@AdminEditFilmActivity, "Terjadi kesalahan!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
