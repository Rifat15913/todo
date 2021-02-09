package com.todo.app.main.ui.base.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class BaseRecyclerView(context: Context, attributeSet: AttributeSet?) :
    RecyclerView(context, attributeSet) {

    private var mEmptyPlaceholderView: View? = null

    private val mAdapterSizeObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            val adapter = adapter
            if (adapter != null && mEmptyPlaceholderView != null) {
                if (adapter.itemCount == 0) {
                    mEmptyPlaceholderView?.visibility = View.VISIBLE
                    this@BaseRecyclerView.visibility = View.INVISIBLE
                } else {
                    mEmptyPlaceholderView?.visibility = View.GONE
                    this@BaseRecyclerView.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
        adapter?.registerAdapterDataObserver(mAdapterSizeObserver)
        mAdapterSizeObserver.onChanged()
    }

    fun setEmptyPlaceholder(view: View) {
        this.mEmptyPlaceholderView = view
    }
}