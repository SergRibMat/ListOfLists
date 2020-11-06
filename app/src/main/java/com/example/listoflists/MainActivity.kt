package com.example.listoflists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.listoflists.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel

        binding.carRecyclerView.adapter = CarAdapter(CarOnClickListener { car->
            showToast("${car.name}")
        }, PieceAdapter(PieceOnClickListener { piece ->
            showToast("${piece.name}")
        })
        )

    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun showToast(text: Int) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }



}