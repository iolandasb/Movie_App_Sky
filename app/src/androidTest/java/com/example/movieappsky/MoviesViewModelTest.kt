package com.example.movieappsky

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movieappsky.data.Service
import com.example.movieappsky.data.model.MoviesItemsResponse
import com.example.movieappsky.domain.model.Movies
import com.example.movieappsky.presentation.MoviesViewModel
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness
import retrofit2.Response.success
import kotlin.Result.Companion.success
import kotlin.time.ExperimentalTime

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

//    @get:Rule
//    var instantExecutorRule = InstantTaskExecutorRule()
//
//    private fun createViewModel() {
//        viewModel = MoviesViewModel()
//    }
//
//    @Before
//    fun setUp() {
//        val initialWords = listOf(
//            Word("Ricardo"),
//            Word("Junior")
//        )
//        // Aqui é onde mockamos os dados uando nosso repositório fake
//        val factory = WordViewModelFactory(MockWordRepository(initialWords))
//        wordViewModel = factory.create(WordViewModel::class.java)
//    }
//
//    @Test
//    fun insert_NewWord_IntoViewModel_DispatchesObserver_OnLiveData() {
//        viewModel.allWords.getOrAwaitValue()
//
//        // Inserir uma nova palavra no banco fake e esperar a conclusão para
//        // dar tempo ao liveData de atualizar e notificar o observer
//        runBlocking {
//            viewModel.insert(Word("Nova Palavra"))
//        }
//
//        // Ao inserir uma palavra nova, nosso evento é disparado
//        val value: List<Word>? = wordViewModel.allWords.value
//        assertNotNull(value?.last())
//        assertEquals(value?.last()?.word, "Nova Palavra")
//    }

//
//    @get:Rule
//    val coroutineTestRule = CoroutineTestRule()
//
//    @get:Rule
//    val rule: LocalTestRule = LocalTestRule()
//
//    @get:Rule
//    val viewModelTestRule = ViewModelTestRule(
//        actionObserver = mockk(relaxed = true),
//        stateObserver = mockk(relaxed = true)
//    )
//
//    private val couponUseCaseInteractor: CouponUseCaseInteractor = mockk(relaxed = true)
//    private val couponAdditionalInteractor: CouponAdditionalInteractor = CouponAdditionalInteractor(
//        analytics = mockk(relaxed = true),
//        couponListFeatureManager = mockk(relaxed = true),
//        resourceProvider = mockk(relaxed = true),
//        couponListMapperPresenter = CouponMapperPresenter()
//    )
//    private val couponArgs: CouponsArgs = mockk(relaxed = true)
//    private lateinit var viewModel: AddReferralCodeViewModel
//
//    private val actionObserver: Observer<AddReferralCodeAction> by lazy { viewModelTestRule.getActionObserver() }
//    private val stateObserver: Observer<AddReferralCodeViewState> by lazy { viewModelTestRule.getStateObserver() }
//
//    @Test
//    fun `fetchCouponsList When call this method should load data list of coupon and show success`() =
//            runBlocking {
//                // given
//                coEvery {
//                    couponUseCaseInteractor.fetchCouponsList()
//                } returns flowOf(couponsListDataMock())
//                givenInitViewModel()
//
//                val initialState = AddReferralCodeViewState().showShimmer()
//                val successState = initialState.setSuccessDataState(couponsAdapterListMock())
//                val finalState = successState.hideShimmer()
//
//                // when
//                createViewModel()
//
//                // then
//                verifyOrder {
//                    stateObserver.onChanged(initialState)
//                    stateObserver.onChanged(successState)
//                    stateObserver.onChanged(finalState)
//                }
//            }
}