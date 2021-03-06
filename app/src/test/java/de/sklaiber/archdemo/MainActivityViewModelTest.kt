package de.sklaiber.archdemo

import de.sklaiber.archdemo.api.model.IpAddress
import de.sklaiber.archdemo.repository.Repository
import de.sklaiber.archdemo.ui.main.MainActivityViewModel
import de.sklaiber.archdemo.util.SchedulerProvider
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainActivityViewModelTest {

    @Mock
    private lateinit var mockRepository: Repository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivityViewModel = MainActivityViewModel(mockRepository, schedulerProvider)
    }

    @Test
    fun showDataFromApi() {
        Mockito.`when`(mockRepository.getDataFromApi()).thenReturn(Single.just(IpAddress("20.0.0.0")))

        val testObserver = TestObserver<IpAddress>()

        mainActivityViewModel.showDataFromApi()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { ipAddress -> ipAddress.ip == "20.0.0.0" }
    }
}