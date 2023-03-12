package com.example.musicwik

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwik.adapters.TopGenreAdapter
import com.example.musicwik.databinding.ActivityMainBinding
import com.example.musicwik.repository.Repository
import com.example.musicwik.viewmodel.MainViewModel
import com.example.musicwik.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var genreAdapter: TopGenreAdapter
    private lateinit var viewModel: MainViewModel

    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.topTagResponse.observe(this) { tags ->
                setUpRecyclerView()
                genreAdapter.genres = tags
        }
    }

    private fun setUpRecyclerView()  = binding.genreRv.apply {
        genreAdapter = TopGenreAdapter(context)
        adapter = genreAdapter
        layoutManager = GridLayoutManager(this@MainActivity, 3)
    }
}