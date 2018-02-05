package de.sklaiber.archdemo

import de.sklaiber.archdemo.di.AppModule
import de.sklaiber.archdemo.di.DaggerAppComponent
import io.appflate.restmock.RESTMockServer

class TestApplication : App() {
    override fun setupGraph() {
        DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(RESTMockServer.getUrl()))
                .build()
                .inject(this)
    }
}