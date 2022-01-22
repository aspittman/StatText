package com.affinityapps.stattext.main

import android.Manifest
import android.Manifest.permission
import android.Manifest.permission.READ_CONTACTS
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.affinityapps.stattext.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.Manifest.permission.ACCESS_FINE_LOCATION
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableNavigation()
        requestPermission()
    }

    private fun enableNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.nav_view)
            .setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.add_permissions -> {
                ActivityCompat.requestPermissions(this, arrayOf(READ_CONTACTS), 10)
                true
            }
            R.id.light_dark -> {
                darkLightMode()
                true
            }
            R.id.refresh_home -> {
                recreate()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun testMenuThree() {
        Toast.makeText(this, "Bar Three", Toast.LENGTH_SHORT).show()
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "xxxxxxxxxxxxx", Toast.LENGTH_LONG).show()
             //   Log.i("Permission", "Granted")
            } else {
                Log.i("Permission", "Denied")
            }
        }

    private fun darkLightMode() {
        val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(this, READ_CONTACTS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "permission has been granted", Toast.LENGTH_LONG).show()
                }
                shouldShowRequestPermissionRationale (READ_CONTACTS) -> {
                    //educated user about why necessary
            }
                else -> {
                    requestPermissionLauncher.launch(READ_CONTACTS)
                }
            }
        }
    }
}