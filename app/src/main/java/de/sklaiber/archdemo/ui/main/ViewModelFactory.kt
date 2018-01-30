package de.sklaiber.archdemo.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import de.sklaiber.archdemo.repository.Repository
import de.sklaiber.archdemo.util.SchedulerProvider


class ViewModelFactory(private val repository: Repository, private val scheduler: SchedulerProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(repository, scheduler) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}