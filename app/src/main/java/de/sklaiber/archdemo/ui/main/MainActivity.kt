package de.sklaiber.archdemo.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import de.sklaiber.archdemo.R
import dagger.android.DispatchingAndroidInjector
import de.sklaiber.archdemo.ui.NavigationController
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigationController.navigateToSearch()
        }
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }
}
