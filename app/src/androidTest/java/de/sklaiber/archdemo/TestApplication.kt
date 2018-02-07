package de.sklaiber.archdemo

import de.sklaiber.archdemo.di.AppInjector
import de.sklaiber.archdemo.di.AppModule
import de.sklaiber.archdemo.di.DaggerAppComponent
import io.appflate.restmock.RESTMockServer

class TestApplication : App() {
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this, RESTMockServer.getUrl())
    }
}