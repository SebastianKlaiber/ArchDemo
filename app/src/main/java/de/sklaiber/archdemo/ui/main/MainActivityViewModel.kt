package de.sklaiber.archdemo.ui.main

import android.arch.lifecycle.ViewModel
import android.util.Log
import de.sklaiber.archdemo.api.model.IpAddress
import de.sklaiber.archdemo.repository.Repository
import de.sklaiber.archdemo.util.SchedulerProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(private val repository: Repository, private val schedulerProvider: SchedulerProvider): ViewModel(){
    private val compositeDisposable by lazy { CompositeDisposable() }

    fun fetchApi(success: (IpAddress) -> (Unit)) {
        compositeDisposable.add(
                repository.getDataFromApi()
                        .compose(schedulerProvider.getSchedulersForSingle())
                        .subscribeBy(onSuccess = {
                            success(it)
                        }, onError = {
                            Log.d("MainActivity", it.message)
                        }))
    }

//    fun showDataFromApi(): Single<IpAddress>  {
//        return repository.getDataFromApi()
//                .compose(schedulerProvider.getSchedulersForSingle())
//    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()

    }
}