package com.example.weekmenu.feature.recipes.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecipesItemDecoration : RecyclerView.ItemDecoration() {
    private val verticalOffset = 12
    private val horizontalOffset = 12

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildViewHolder(view) is RecipesViewHolder) {
            outRect.set(verticalOffset, horizontalOffset, verticalOffset, horizontalOffset)
        }
    }
}