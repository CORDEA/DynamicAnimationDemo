package jp.cordea.dynamicanimationdemo

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.dynamicanimationdemo.databinding.MainListItemBinding

class MainListItemViewModel(
    private val stiffness: Float,
    private val dampingRatio: Float
)

class MainListItem(
    private val viewModel: MainListItemViewModel
) : BindableItem<MainListItemBinding>() {
    override fun getLayout(): Int = R.layout.main_list_item

    override fun bind(viewBinding: MainListItemBinding, position: Int) {
        viewBinding.viewModel = viewModel
    }
}
