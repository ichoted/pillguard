package com.chocoding.pillguard

import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.chocoding.pillguard.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun setupView() {
        val navHostFragment = childFragmentManager
            .findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Connect BottomNavigationView with NavController
        binding.bottomNavigation.setupWithNavController(navController)

        // Connect Toolbar with NavController
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboardFragment, R.id.cameraFragment, R.id.profileFragment)
        )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        // Setup Toolbar Menu
        binding.toolbar.inflateMenu(R.menu.home_menu)
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_item -> {
                    navController.navigate(R.id.searchMedicineFragment)
                    true
                }
                R.id.notification_item -> {
                    Toast.makeText(requireContext(), "No Notifications", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // Add Destination Changed Listener to hide/show UI elements
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.medicineDetailFragment, R.id.searchMedicineFragment -> {
                    binding.bottomNavigation.visibility = View.GONE
                    binding.appBarLayout.visibility = View.VISIBLE
                }
                else -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                    binding.appBarLayout.visibility = View.VISIBLE
                }
            }
        }
    }
}
