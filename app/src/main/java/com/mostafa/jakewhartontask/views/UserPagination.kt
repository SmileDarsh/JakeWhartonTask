package com.mostafa.jakewhartontask.views

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
abstract class UserPagination(private val mLinearLayoutManager: LinearLayoutManager) :
    RecyclerView.OnScrollListener() {

    private var mPreviousTotalItemCount = 0
    private var mCurrentPage = 0
    private var mLoading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition()
        val totalItemCount = mLinearLayoutManager.itemCount

        if (totalItemCount < mPreviousTotalItemCount) {
            mCurrentPage = 0
            mPreviousTotalItemCount = totalItemCount
            if (totalItemCount == 0)
                mLoading = true
        }

        if (mLoading && (totalItemCount > mPreviousTotalItemCount)) {
            mLoading = false
            mPreviousTotalItemCount = totalItemCount
        }

        if (!mLoading && (lastVisibleItemPosition + 2) > totalItemCount) {
            mCurrentPage++
            onLoadMore(mCurrentPage, totalItemCount, recyclerView)
            mLoading = true
        }

    }

    abstract fun onLoadMore(currentPage: Int, totalItemCount: Int, view: View)
}