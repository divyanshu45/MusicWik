package com.example.musicwik.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwik.adapters.GenreAlbumsAdapter
import com.example.musicwik.databinding.FragmentGenreAlbumsBinding
import com.example.musicwik.repository.Repository
import com.example.musicwik.viewmodel.MainViewModel
import com.example.musicwik.viewmodel.MainViewModelFactory


class GenreAlbumsFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreAlbumsBinding
    private lateinit var genreAlbumsAdapter: GenreAlbumsAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentGenreAlbumsBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopAlbums(genreName.toString())
        viewModel.tagTopAlbumsResponse.observe(viewLifecycleOwner) { topAlbums ->
            setupRecyclerView()
            genreAlbumsAdapter.genreAlbums = topAlbums
        }
    }

    private fun setupRecyclerView() =binding.albumsRv.apply {
        genreAlbumsAdapter = GenreAlbumsAdapter(context)
        adapter = genreAlbumsAdapter
        layoutManager = GridLayoutManager(context, 2)
    }
}