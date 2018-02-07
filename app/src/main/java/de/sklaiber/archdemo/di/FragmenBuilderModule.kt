package de.sklaiber.archdemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.sklaiber.archdemo.ui.main.MainFragment

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}