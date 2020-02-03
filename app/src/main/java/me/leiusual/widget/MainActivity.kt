package me.leiusual.widget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    for (index in 0 until tab_layout_0.tabCount) {
      tab_layout_0.getTabCustomTextView(index)?.let {
        it.text = "tab $index"
      }
    }

    for (index in 0 until tab_layout_1.tabCount) {
      tab_layout_1.getTabCustomTextView(index)?.let {
        it.text = "tab $index"
      }
    }
  }
}
