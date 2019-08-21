package top.qvisa.materialApp

import android.graphics.Color
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.gyf.immersionbar.ktx.immersionBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_header.*
import org.jetbrains.anko.toast

class MainActivity : BaseKotlinActivity(R.layout.activity_main) {

    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar{
            transparentBar()
            statusBarView(view)
            navigationBarDarkIcon(true)
        }
    }
    override fun initView() {
        super.initView()
        initToolbar()
        /*设置Drawerlayout的开关,并且和Home图标联动*/
        val mToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0)
        drawer_layout.addDrawerListener(mToggle)
        /*同步drawerlayout的状态*/
        mToggle.syncState()
    }

    private fun initToolbar() {

        toolbar.setBackgroundResource(R.color.colorPrimary)
        toolbar.setTitleTextColor(Color.WHITE)

        toolbar.inflateMenu(R.menu.toolbar_menu)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.tb_menu_item1 -> {
                    toast("You press item1")
                }
                R.id.tb_menu_item2 -> {
                    toast("You press item2")
                }
                R.id.tb_menu_item3 -> {
                    toast("You press item3")
                }
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

}


