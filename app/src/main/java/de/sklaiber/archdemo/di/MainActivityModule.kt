package de.sklaiber.archdemo.di

import dagger.Module
import de.sklaiber.archdemo.ui.main.MainActivity
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    internal abstract fun contributeMainActivity(): MainActivity
}
