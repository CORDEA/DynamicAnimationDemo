package jp.cordea.dynamicanimationdemo

import com.xwray.groupie.databinding.BindableItem
import com.xwray.groupie.databinding.GroupieViewHolder
import jp.cordea.dynamicanimationdemo.databinding.MainListItemBinding

class MainListItemViewModel(
    val stiffness: Float,
    val dampingRatio: Float
)

class MainListItem(
    private val viewModel: MainListItemViewModel
) : BindableItem<MainListItemBinding>() {
    private var binding: MainListItemBinding? = null

    override fun getLayout(): Int = R.layout.main_list_item

    override fun bind(viewBinding: MainListItemBinding, position: Int) {
        binding = viewBinding
        viewBinding.viewModel = viewModel
    }

    override fun unbind(viewHolder: GroupieViewHolder<MainListItemBinding>) {
        super.unbind(viewHolder)
        binding = null
    }

    fun startAnimation() {
        binding?.circularView?.startAnimation(viewModel.stiffness, viewModel.dampingRatio)
    }
}
