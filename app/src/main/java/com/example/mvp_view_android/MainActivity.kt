package com.example.mvp_view_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvp_view_android.databinding.ActivityMainBinding
import com.example.mvp_view_android.presenter.MainContract
import com.example.mvp_view_android.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private val presenter: MainContract.Presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter.attachView(this)

        val initialLayout = R.id.layout1
        switchLayout(initialLayout)
        setupButtons(initialLayout)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun setupButtons(layoutId: Int) {
        val layout = findViewById<View>(layoutId) ?: return

        val buttonNext = layout.findViewById<Button>(R.id.buttonNext)
        val buttonPrevious = layout.findViewById<Button>(R.id.buttonPrevious)
        val buttonConfirm = layout.findViewById<Button>(R.id.buttonConfirm)

        buttonNext?.setOnClickListener { presenter.onNextClicked(layoutId) }
        buttonPrevious?.setOnClickListener { presenter.onPreviousClicked(layoutId) }
    }

    override fun switchLayout(layoutId: Int) {
        findViewById<View>(R.id.layout1).visibility = View.GONE
        findViewById<View>(R.id.layout2).visibility = View.GONE
        findViewById<View>(R.id.layout3).visibility = View.GONE
        findViewById<View>(R.id.layout4).visibility = View.GONE
        findViewById<View>(R.id.layout5).visibility = View.GONE

        findViewById<View>(layoutId).visibility = View.VISIBLE
    }
}
