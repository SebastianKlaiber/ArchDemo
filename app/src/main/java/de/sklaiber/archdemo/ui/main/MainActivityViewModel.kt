package de.sklaiber.archdemo.ui.main

import android.arch.lifecycle.ViewModel
import de.sklaiber.archdemo.api.model.IpAddress
import de.sklaiber.archdemo.repository.Repository
import de.sklaiber.archdemo.util.SchedulerProvider
import io.reactivex.Single


class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider): ViewModel(){

    fun showDataFromApi(): Single<IpAddress> = repository.getDataFromApi()
            .compose(schedulerProvider.getSchedulersForSingle())
}