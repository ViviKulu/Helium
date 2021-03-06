package com.jv.news.view

import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author: joaquim
 */
class SpacesItemDecoration(private val space: Int, orientation: Int) : RecyclerView.ItemDecoration() {

    private val isHorizontal = orientation == LinearLayoutManager.HORIZONTAL

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {

        val position = parent.getChildLayoutPosition(view)
        val manager = parent.layoutManager as GridLayoutManager
        val span = manager.spanSizeLookup.getSpanSize(position)

        outRect.top = space
        outRect.bottom = space
        outRect.left = space
        outRect.right = space

        if (position == 0) {
            if(isHorizontal) { outRect.left = space } else { outRect.top = space }
        } else {
            if(isHorizontal) { outRect.left = 0 } else { outRect.top = 0}
        }

        // Add side margin only for the first item to avoid double space between items
        if (span == 1 && (position % 5 == 1 || position % 5 == 3)) {
            if(isHorizontal) { outRect.bottom = 0 } else { outRect.right = 0 }
        }
    }
}
