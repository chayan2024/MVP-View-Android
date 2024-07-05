package com.example.mvp_view_android.presenter

interface MainContract {
    interface View {
        fun switchLayout(layoutId: Int)
        fun setupButtons(layoutId: Int)
    }

    interface Presenter {
        fun onNextClicked(currentLayoutId: Int)
        fun onPreviousClicked(currentLayoutId: Int)
        fun attachView(view: View)
        fun detachView()
    }
}