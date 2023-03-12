package com.example.musicwik.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwik.adapters.GenreArtistsAdapter
import com.example.musicwik.databinding.FragmentGenreArtistsBinding
import com.example.musicwik.repository.Repository
import com.example.musicwik.viewmodel.MainViewModel
import com.example.musicwik.viewmodel.MainViewModelFactory


class GenreArtistsFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreArtistsBinding
    private lateinit var genreArtistsAdapter: GenreArtistsAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentGenreArtistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopArtists(genreName.toString())
        viewModel.tagTopArtistsResposne.observe(viewLifecycleOwner) { topArtists ->
            setupRecyclerView()
            genreArtistsAdapter.genreArtists = topArtists
        }
    }

    private fun setupRecyclerView() =binding.artistsRv.apply {
        genreArtistsAdapter = GenreArtistsAdapter(context)
        adapter = genreArtistsAdapter
        layoutManager = GridLayoutManager(context, 2)
    }
}