package com.example.weather.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.core.ViewState
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject

class RecyclerViewFragment : Fragment() {

    private val adapter = RecyclerAdapter()
    private val vm: MainViewModel by inject()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.viewState.observe(viewLifecycleOwner,{render(it)})
        vm.getWeekTemp().observe(viewLifecycleOwner, { temp ->
            adapter.setTemp(temp)
        })
        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)
        val topPaddingDecoration = RecyclerItemDecorator(30)
        recyclerview.addItemDecoration(topPaddingDecoration)
        recyclerview.adapter = this.adapter
    }

    private fun render(state: ViewState){
        val progressBar = view?.findViewById<ProgressBar>(R.id.circularProgressBar)
        when(state){
            is ViewState.Success -> {
                progressBar?.isVisible = false
            }
            is ViewState.Loading -> {
                progressBar?.isVisible = true
            }
            is ViewState.Error -> {
                view?.let { Snackbar.make(it, state.message.toString(), Snackbar.LENGTH_LONG).show() }
            }
        }
    }
}