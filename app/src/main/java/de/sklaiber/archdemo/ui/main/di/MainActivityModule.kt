package de.sklaiber.archdemo.ui.main.di

import dagger.Module
import dagger.Provides
import de.sklaiber.archdemo.repository.Repository
import de.sklaiber.archdemo.ui.main.MainActivityViewModel
import de.sklaiber.archdemo.util.SchedulerProvider

@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository, schedulerProvider: SchedulerProvider) = MainActivityViewModel(repository, schedulerProvider)
}