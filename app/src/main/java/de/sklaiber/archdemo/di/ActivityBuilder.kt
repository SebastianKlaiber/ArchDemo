package de.sklaiber.archdemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.sklaiber.archdemo.ui.main.MainActivity
import de.sklaiber.archdemo.ui.main.di.MainActivityModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity
}