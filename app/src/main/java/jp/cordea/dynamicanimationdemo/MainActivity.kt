package jp.cordea.dynamicanimationdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import jp.cordea.dynamicanimationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        setSupportActionBar(binding.toolbar)
        binding.content.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(
                listOf(
                    MainListItemViewModel(
                        SpringForce.STIFFNESS_VERY_LOW,
                        SpringForce.DAMPING_RATIO_NO_BOUNCY
                    ),
                    MainListItemViewModel(
                        SpringForce.STIFFNESS_LOW,
                        SpringForce.DAMPING_RATIO_LOW_BOUNCY
                    ),
                    MainListItemViewModel(
                        SpringForce.STIFFNESS_MEDIUM,
                        SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
                    ),
                    MainListItemViewModel(
                        SpringForce.STIFFNESS_HIGH,
                        SpringForce.DAMPING_RATIO_HIGH_BOUNCY
                    )
                ).map { MainListItem(it) }
            )
        }
        binding.content.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            (0 until adapter.itemCount)
                .map { adapter.getItem(it) }
                .filterIsInstance<MainListItem>()
                .forEach { it.startAnimation() }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
