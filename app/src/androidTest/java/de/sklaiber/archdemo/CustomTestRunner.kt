package de.sklaiber.archdemo

import android.app.Application
import android.content.Context
import io.appflate.restmock.android.RESTMockTestRunner


class CustomTestRunner : RESTMockTestRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader,
                       className: String,
                       context: Context): Application {

        //I'm changing the application class only for test purposes. there I'll instantiate AppModule with RESTMock's url.
        val testApplicationClassName = TestApplication::class.java.canonicalName
        return super.newApplication(cl, testApplicationClassName, context)
    }
}