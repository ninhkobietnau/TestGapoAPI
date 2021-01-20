package com.aibles.testgapoapi.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.aibles.testgapoapi.databinding.FragmentNewsFeedBinding
import com.aibles.testgapoapi.presentation.adapter.NewsfeedAdapter
import com.aibles.testgapoapi.presentation.viewmodel.NewsfeedViewModel
import kotlinx.android.synthetic.main.fragment_news_feed.*

class NewsfeedFragment : Fragment() {

    private lateinit var binding: FragmentNewsFeedBinding
    private lateinit var adapter: NewsfeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsFeedBinding.inflate(inflater, container, false).apply {
            viewModel = of(this@NewsfeedFragment).get(NewsfeedViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel?.fetchNewsfeedList()
        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        binding.viewModel?.newsfeed?.observe(viewLifecycleOwner, Observer {
            adapter.updateListNewsfeed(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = binding.viewModel
        if (viewModel != null) {
            adapter = NewsfeedAdapter(viewModel)
            newsfeed_recycler.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
            }

            newsfeed_recycler.adapter = adapter
        }
    }
}