package de.sklaiber.archdemo

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import de.sklaiber.archdemo.di.AppModule
import de.sklaiber.archdemo.di.DaggerAppComponent
import javax.inject.Inject

open class App : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        setupGraph()
    }


    open fun setupGraph() {
        DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule("http://ip.jsontest.com/"))
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}