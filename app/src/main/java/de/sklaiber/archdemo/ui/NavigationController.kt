package de.sklaiber.archdemo.ui

import de.sklaiber.archdemo.R
import de.sklaiber.archdemo.ui.main.MainActivity
import de.sklaiber.archdemo.ui.main.MainFragment
import javax.inject.Inject

class NavigationController @Inject constructor(mainActivity: MainActivity) {
    val containerId = R.id.container
    val fragmentManager = mainActivity.supportFragmentManager

    fun navigateToSearch() {
        val mainFragment = MainFragment.newInstance()
        fragmentManager.beginTransaction()
                .replace(containerId, mainFragment)
                .commitAllowingStateLoss()
    }
}