package com.example.musicwik.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.musicwik.viewmodel.MainViewModelFactory
import com.example.musicwik.adapters.ViewPagerAdapter
import com.example.musicwik.databinding.ActivityGenreInfoBinding
import com.example.musicwik.models.TagX
import com.example.musicwik.repository.Repository
import com.example.musicwik.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayout

class GenreInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenreInfoBinding
    lateinit var viewPagerAdapter  : ViewPagerAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ints = intent
        val name = ints.getStringExtra("NAME")

        viewPagerAdapter =  ViewPagerAdapter(this, name.toString())
        binding.viewpager.adapter = viewPagerAdapter


        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tablayout.getTabAt(position)!!.select()
            }
        })

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagInfo(name.toString())
        viewModel.tagInfoResponse.observe(this) { info: TagX ->
            binding.genreTitle.text = info.name
            binding.genreDesc.text = info.wiki.summary
        }
    }
}