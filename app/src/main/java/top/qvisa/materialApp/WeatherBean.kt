package top.qvisa.materialApp

import com.google.gson.annotations.SerializedName


data class WeatherBean(
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("code")
    val code: Int = 0, // 200
    @SerializedName("msg")
    val msg: String = "" // 成功!
) {
    data class Data(
        @SerializedName("aqi")
        val aqi: Any = Any(), // null
        @SerializedName("city")
        val city: String = "", // 北京
        @SerializedName("forecast")
        val forecast: List<Forecast> = listOf(),
        @SerializedName("ganmao")
        val ganmao: String = "", // 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
        @SerializedName("wendu")
        val wendu: String = "", // 30
        @SerializedName("yesterday")
        val yesterday: Yesterday = Yesterday()
    ) {
        data class Forecast(
            @SerializedName("date")
            val date: String = "", // 25日星期天
            @SerializedName("fengli")
            val fengli: String = "", // <![CDATA[<3级]]>
            @SerializedName("fengxiang")
            val fengxiang: String = "", // 南风
            @SerializedName("high")
            val high: String = "", // 高温 30℃
            @SerializedName("low")
            val low: String = "", // 低温 21℃
            @SerializedName("type")
            val type: String = "" // 晴
        )

        data class Yesterday(
            @SerializedName("date")
            val date: String = "", // 20日星期二
            @SerializedName("fl")
            val fl: String = "", // <![CDATA[3-4级]]>
            @SerializedName("fx")
            val fx: String = "", // 南风
            @SerializedName("high")
            val high: String = "", // 高温 26℃
            @SerializedName("low")
            val low: String = "", // 低温 19℃
            @SerializedName("type")
            val type: String = "" // 小雨
        )
    }
}
