package com.mostafa.jakewhartontask.helper

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.jakewhartontask.views.MainViewModel
import com.mostafa.jakewhartontask.views.UserPagination

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("recyclerView", "viewModel")
    fun getAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>, mainVm: MainViewModel) {
        val rvLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(view.context)
        val layoutManager = rvLayoutManager as LinearLayoutManager
        view.setHasFixedSize(true)
        view.layoutManager = rvLayoutManager
        view.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))
        view.addOnScrollListener(object : UserPagination(layoutManager) {
            override fun onLoadMore(currentPage: Int, totalItemCount: Int, view: View) {
                mainVm.addOnScrollListener(currentPage)
            }
        })
        view.adapter = adapter
    }
}