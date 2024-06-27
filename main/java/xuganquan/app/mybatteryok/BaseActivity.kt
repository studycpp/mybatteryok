package xuganquan.app.mybatteryok

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import xuganquan.app.mybatteryok.MyConfig

open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {

        //MyConfig.loadAllConfig()
        var lang="en" //MyConfig.locate_language
        val locate=Locale(lang)

        val config= Configuration()
        config.setLocale(locate)
        val updatedContext=newBase.createConfigurationContext(config)

        super.attachBaseContext(updatedContext)
    }

}