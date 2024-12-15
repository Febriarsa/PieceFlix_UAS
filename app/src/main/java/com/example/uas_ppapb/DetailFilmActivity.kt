package com.example.uas_ppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import androidx.navigation.findNavController
import com.example.uas_ppapb.HomeFragment
import com.example.uas_ppapb.databinding.ActivityDetailFilmBinding

// kelas `DetailFilmActivity` bertanggung jawab untuk menampilkan detail film ketika pengguna memilih suatu film
class DetailFilmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.juduluser.text = intent.getStringExtra("judul")
        binding.directoruser.text = intent.getStringExtra("director")
        binding.durasiuser.text = intent.getStringExtra("durasi")
        binding.ratinguser.text = intent.getStringExtra("rating")
        binding.detailfilm.text = intent.getStringExtra("deskripsi")

        binding.back.setOnClickListener {
            startActivity(Intent(this@DetailFilmActivity, HomeFragment::class.java))
            finishAffinity()
        }

        val imageUrl = intent.getStringExtra("imageUrl")
        if (imageUrl != null) {
            Glide.with(binding.imguser)
                .load(imageUrl)
                .centerCrop()
                .into(binding.imguser)
        }
    }
}