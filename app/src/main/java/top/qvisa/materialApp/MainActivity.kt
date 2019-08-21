package top.qvisa.materialApp

import android.content.Context
import android.graphics.Color
import android.provider.CallLog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.gyf.immersionbar.ktx.immersionBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_header.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : BaseKotlinActivity(R.layout.activity_main) {

    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
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
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun initData() {
        super.initData()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.apiopen.top/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(WeatherApi::class.java)


        Bt_weather_query.setOnClickListener {

            val weatherCity = Et_weather_city.text.toString()
            Log.d("string", weatherCity)

            api.weatherFromCity(city = weatherCity)
                .enqueue(object : Callback<WeatherBean> {
                    override fun onFailure(call: Call<WeatherBean>, t: Throwable) {
                        toast("查询失败")
                    }

                    override fun onResponse(call: Call<WeatherBean>, response: Response<WeatherBean>) {
                        val bean = response.body()
                        bean?.let {
                            Log.d("WeatherBean", bean.msg)
                            Log.d("WeatherBean", "${bean.code}")
                            if (bean.code != 200) {
                                toast("查询失败")
                                Et_weather_city.text = null
                            } else {
                                val wendu: String = bean.data.wendu
                                Tv_weather_show.text = wendu
                            }

                        }

                    }
                })
        }


    }

    interface WeatherApi {
        @GET("weatherApi")
        fun weatherFromCity(
            @Query("city") city: String
        ): Call<WeatherBean>
    }
}


