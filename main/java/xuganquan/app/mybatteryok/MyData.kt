package xuganquan.app.mybatteryok

import androidx.appcompat.app.AppCompatActivity


object MyConst {
    const val C_app_name="xuganquan.app.mybatteryok"
    const val C_preference_name="xuganquan_app_mybatteryok"

}


object MyConfig{
    var first_run=false

    var locate_language="en"    //sys  zh

    var check_interval=5000  //ms

    var battery_capacity_design=5000  ///mAh
    var battery_capacity_now=5000

    var battery_percent=1.0f
    var battery_percent_warn_enable=false
    var battery_percent_warn_low=0.20f
    var battery_percent_warn_high=0.95f

    var battery_temperature=30.0f
    var battery_temperature_warn_enable=false
    var battery_temperature_warn_low=-5.0f
    var battery_temperature_warn_high=42.0f

    var battery_current=-200.0f   //mA
    var battery_current_warn_enable=false
    var battery_current_warn_low=-1000.0f
    var battery_current_warn_high=1000.0f


    var alert_loop=false
    var alert_interval=300000  ///ms 5 minitue



    private val mySharedPreference = MyApplication.appContext.getSharedPreferences(
        MyConst.C_preference_name,
        AppCompatActivity.MODE_PRIVATE
    )


    fun saveAllConfig() {
        with(mySharedPreference.edit()) {
            putBoolean("first_run", first_run)
            putString("locate_language", locate_language)
            putInt("check_interval", check_interval)

            putInt("battery_capacity_design", battery_capacity_design)
            putInt("battery_capacity_now", battery_capacity_now)

            putBoolean("battery_percent_warn_enable", battery_percent_warn_enable)
            putFloat("battery_percent_warn_low", battery_percent_warn_low)
            putFloat("battery_percent_warn_high", battery_percent_warn_high)


            putBoolean("battery_temperature_warn_enable", battery_temperature_warn_enable)
            putFloat("battery_temperature_warn_low", battery_temperature_warn_low)
            putFloat("battery_temperature_warn_high", battery_temperature_warn_high)

            putBoolean("battery_current_warn_enable", battery_current_warn_enable)
            putFloat("battery_current_warn_low", battery_current_warn_low)
            putFloat("battery_current_warn_high", battery_current_warn_high)

            putBoolean("alert_loop", alert_loop)
            putInt("alert_interval", alert_interval)

            }
        }


    fun loadAllConfig() {
        //加载配置
        first_run = mySharedPreference.getBoolean("first_run", false)
        locate_language = mySharedPreference.getString("locate_language", "en").toString()
        check_interval  = mySharedPreference.getInt("check_interval", 5000)

        battery_capacity_design = mySharedPreference.getInt("battery_capacity_design", 5000)
        battery_capacity_now    = mySharedPreference.getInt("battery_capacity_now", 5000)

        battery_percent_warn_enable = mySharedPreference.getBoolean("battery_percent_warn_enable", false)
        battery_percent_warn_low    = mySharedPreference.getFloat("battery_percent_warn_low", 0.20f)
        battery_percent_warn_high   = mySharedPreference.getFloat("battery_percent_warn_high", 0.95f)

        battery_temperature_warn_enable = mySharedPreference.getBoolean("battery_temperature_warn_enable", false)
        battery_temperature_warn_low    = mySharedPreference.getFloat("battery_temperature_warn_low", -5.0f)
        battery_temperature_warn_high   = mySharedPreference.getFloat("battery_temperature_warn_high", 40.0f)

        battery_current_warn_enable= mySharedPreference.getBoolean("battery_current_warn_enable", false)
        battery_current_warn_low   = mySharedPreference.getFloat("battery_current_warn_low", -1000.0f)
        battery_current_warn_high  = mySharedPreference.getFloat("battery_current_warn_high",-1000.0f)

        alert_loop= mySharedPreference.getBoolean("alert_loop", false)
        alert_interval= mySharedPreference.getInt("alert_interval", 300000)

    }

    operator fun <T: Comparable<T>> set(str: String, value: T )=with(mySharedPreference.edit()){
        //利用with函数定义临时的命名空间
        when (value) {
            is Int -> putInt(str, value)
            is String-> putString(str, value)
            is Long-> putLong(str, value)
            is Boolean -> putBoolean(str, value)
            else-> putString(str, value.toString())
        }.apply()
    }

}