package com.affinityapps.stattext.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.affinityapps.stattext.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableNavigation()
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
                testMenuOne()
                true
            }
            R.id.refresh_home -> {
                testMenuTwo()
                true
            }
            R.id.light_dark -> {
                testMenuThree()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun testMenuOne() {
        Toast.makeText(this, "Bar One", Toast.LENGTH_SHORT).show()
    }

    private fun testMenuTwo() {
        Toast.makeText(this, "Bar Two", Toast.LENGTH_SHORT).show()
    }

    private fun testMenuThree() {
        Toast.makeText(this, "Bar Three", Toast.LENGTH_SHORT).show()
    }
}