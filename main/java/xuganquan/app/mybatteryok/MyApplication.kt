package xuganquan.app.mybatteryok
import android.app.Application
import android.content.Context


class MyApplication: Application() {
    companion object{
        lateinit var appContext:Context
        lateinit var appFilesPath:String
        lateinit var appCachePath:String
    }
    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
        appFilesPath=appContext.getExternalFilesDir("")!!.absolutePath + "/"
        appCachePath = appContext.externalCacheDir.toString() + "/"

        //MyConfig.loadAllConfig()

    }

}