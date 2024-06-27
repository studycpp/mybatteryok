package xuganquan.app.mybatteryok

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import xuganquan.app.mybatteryok.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_client)

        /*
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_main, R.id.nav_option, R.id.nav_about
            )
        )
       setupActionBarWithNavController(navController, appBarConfiguration)*/

        navView.setupWithNavController(navController)
    }
}