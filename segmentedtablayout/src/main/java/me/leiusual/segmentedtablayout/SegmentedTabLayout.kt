package me.leiusual.segmentedtablayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.layout_segmented_tab_item.view.*

/**
 * author: leiusual
 * create on: 2020-02-03
 * description: 仿iOS控件 SegmentedControl 样式的TabLayout
 */
class SegmentedTabLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

  override fun onFinishInflate() {
    super.onFinishInflate()
    val inflater = LayoutInflater.from(context)

    // 添加TabItem效果
    for (index in 0 until tabCount) {
      val tab = getTabAt(index) ?: continue
      val customView = inflater.inflate(R.layout.layout_segmented_tab_item, this, false).apply {
        when (index) {
          0 -> setBackgroundResource(R.drawable.tab_item_left_background)
          tabCount - 1 -> setBackgroundResource(R.drawable.tab_item_right_background)
          else -> setBackgroundResource(R.drawable.tab_item_center_background)
        }
      }
      customView.text_view.text = tab.text
      tab.customView = customView
    }
  }

  /**
   * 获取Tab自定义View中显示Text的TextView
   * @param index tab
   */
  fun getTabCustomTextView(index: Int): TextView? {
    return getTabAt(index)?.customView?.text_view
  }
}