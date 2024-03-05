package com.marisma.gameover

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.NavDeepLinkRequest
import androidx.core.net.toUri
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marisma.gameover.databinding.ActivityMainBinding
import com.marisma.gameover.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController


    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View ?{
                    return  binding.root
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcwMain) as NavHostFragment
        navController = navHostFragment.navController

        //drawerLayout = findViewById(R.id.drawer_layout)
        //drawerLayout = binding.drawerNav
        drawerLayout = binding.drawerLayout
        //setupNavigationMenu()

        //eventos de escucha del menú de navegación...
        binding.drawerNav.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemListFragment -> {
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/ItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.favItemListFragment-> {
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/FavItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.userInfoFragmentFragment -> {
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/UserInfoFragmentFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }
        // Habilitar el botón de navegación hacia arriba (up button)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)


        /*_binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavegacion()*/

        //Codigo del bottom menu
        binding.bottomNav.setupWithNavController(navController)
        //setupBottomMenu()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.loginFragment) {
                binding.toolbar.visibility = View.GONE
                binding.bottomNav.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
                binding.bottomNav.visibility = View.VISIBLE
            }
        }


        setContentView(view)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


    /*private fun setupNavegacion(){
        val bottomNavigationView = binding.bottomNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcwMain) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )
    }*/

   /* private fun setupNavigationMenu() {
        val binding = com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemListFragment -> {
                    // Usar el URI del enlace profundo para itemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/ItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.favItemListFragment -> {
                    // Usar el URI del enlace profundo para favItemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/FavItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }R.id.userInfoFragmentFragment -> {
                    // Usar el URI del enlace profundo para favItemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/UserInfoFragmentFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }

        //val navigationView: com.google.android.material.navigation.NavigationView = binding.drawerLayout
        //navigationView.setNavigationItemSelectedListener(binding)
    }*/

    /**
    private fun setupBottomMenu() {
        val listener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemListFragment -> {
                    // Usar el URI del enlace profundo para itemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/ItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.favItemListFragment -> {
                    // Usar el URI del enlace profundo para favItemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/FavItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.UserInfo -> {
                    // Usar el URI del enlace profundo para favItemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/UserInfoFragmentFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnNavigationItemSelectedListener(listener)
    }*/

}
