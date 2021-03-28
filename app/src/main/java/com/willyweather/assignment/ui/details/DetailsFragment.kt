package com.willyweather.assignment.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.willyweather.assignment.R
import com.willyweather.assignment.databinding.DetailsFragmentBinding
import com.willyweather.assignment.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.details_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews();
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.teamDetails.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.llDataView.visibility = View.VISIBLE
                    binding.tvError.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.INVISIBLE
                    if (it.data != null) {
                        binding.team = it.data
                    }
                }
                Resource.Status.LOADING -> {
                    binding.llDataView.visibility = View.INVISIBLE
                    binding.tvError.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    binding.llDataView.visibility = View.INVISIBLE
                    binding.tvError.visibility = View.VISIBLE
                    binding.tvError.text = it.message
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun setUpViews() {
        arguments?.getInt("teamId")?.let { viewModel.fetchDetails(it) }
    }

}