package com.example.musicwik.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwik.adapters.GenreTracksAdapter
import com.example.musicwik.databinding.FragmentGenreTracksBinding
import com.example.musicwik.repository.Repository
import com.example.musicwik.viewmodel.MainViewModel
import com.example.musicwik.viewmodel.MainViewModelFactory


class GenreTracksFragment (var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreTracksBinding
    private lateinit var genreTracksAdapter: GenreTracksAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenreTracksBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopTracks(genreName.toString())
        viewModel.tagTopTracksResponse.observe(viewLifecycleOwner) { topTracks ->
            setupRecyclerView()
            genreTracksAdapter.genreTracks = topTracks
        }
    }

    private fun setupRecyclerView() = binding.tracksRv.apply {
        genreTracksAdapter = GenreTracksAdapter()
        adapter = genreTracksAdapter
        layoutManager = GridLayoutManager(context, 2)
    }
}