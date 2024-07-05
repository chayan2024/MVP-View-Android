package com.example.mvp_view_android.presenter

import com.example.mvp_view_android.R

class MainPresenter : MainContract.Presenter {

    private var view: MainContract.View? = null
    private val layoutStack = mutableListOf<Int>()

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun onNextClicked(currentLayoutId: Int) {
        val nextLayoutId = when (currentLayoutId) {
            R.id.layout1 -> R.id.layout2
            R.id.layout2 -> R.id.layout3
            R.id.layout3 -> R.id.layout4
            R.id.layout4 -> R.id.layout5
            else -> return
        }
        layoutStack.add(currentLayoutId)
        view?.switchLayout(nextLayoutId)
        view?.setupButtons(nextLayoutId)
    }

    override fun onPreviousClicked(currentLayoutId: Int) {
        if (layoutStack.isNotEmpty()) {
            val previousLayoutId = layoutStack.removeAt(layoutStack.size - 1)
            view?.switchLayout(previousLayoutId)
            view?.setupButtons(previousLayoutId)
        }
    }
}