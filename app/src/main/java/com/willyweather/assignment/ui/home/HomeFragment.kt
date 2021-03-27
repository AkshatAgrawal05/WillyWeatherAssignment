package com.willyweather.assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.willyweather.assignment.R
import com.willyweather.assignment.databinding.HomeFragmentBinding
import com.willyweather.assignment.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), TeamsListAdapter.ItemClickListener {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapter: TeamsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.teams.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.rvTeamList.visibility = View.VISIBLE
                    binding.tvError.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.INVISIBLE
                    if (it.data != null) {
                        binding.competition = it.data.competition
                        adapter.setItems(it.data.teams)
                    }
                }
                Resource.Status.LOADING -> {
                    binding.rvTeamList.visibility = View.INVISIBLE
                    binding.tvError.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    binding.rvTeamList.visibility = View.INVISIBLE
                    binding.tvError.visibility = View.VISIBLE
                    binding.tvError.text = it.message
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        adapter = TeamsListAdapter(this)
        binding.rvTeamList.adapter = adapter
    }

    override fun onItemClick(teamId: Int) {
        TODO("Not yet implemented")
    }


}