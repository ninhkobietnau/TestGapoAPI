package com.aibles.testgapoapi.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders.*
import com.aibles.testgapoapi.R
import com.aibles.testgapoapi.databinding.FragmentDetailBinding
import com.aibles.testgapoapi.databinding.FragmentNewsFeedBinding
import com.aibles.testgapoapi.domain.entity.DetailNews
import com.aibles.testgapoapi.presentation.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var detaiBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detaiBinding = FragmentDetailBinding.inflate(inflater, container, false).apply {
            viewmodel = of(this@DetailFragment).get(DetailViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        return detaiBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detaiBinding.viewmodel?.fechDetailNews()
    }
}