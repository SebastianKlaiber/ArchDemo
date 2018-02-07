package de.sklaiber.archdemo

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import de.sklaiber.archdemo.di.AppInjector
import javax.inject.Inject

open class App : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this, "http://ip.jsontest.com/")
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}