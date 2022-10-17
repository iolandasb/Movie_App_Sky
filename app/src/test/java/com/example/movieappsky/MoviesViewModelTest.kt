package com.example.movieappsky

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.movieappsky.data.repository.MoviesRepository
import com.example.movieappsky.domain.model.Movies
import com.example.movieappsky.domain.usecase.GetMoviesUseCase
import com.example.movieappsky.presentation.MoviesViewModel
import io.reactivex.Single.just
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.quality.Strictness

class MoviesViewModelTest {

    @get:Rule
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @get:Rule
    val rxRule: RxSchedulerRule = RxSchedulerRule()

    private val moviesRepository: MoviesRepository = mock()

    private val getMoviesUseCase: GetMoviesUseCase = mock()

    private val movieListObservable: Observer<List<Movies>> = mock()

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup()
    {
        viewModel = MoviesViewModel()
        viewModel.movieListLiveData.observeForever(movieListObservable)
    }

    //Not working
    @Test
    fun `movieListObservable_should_return_movie_list_when_getMoviesUseCase_success`() {
        // given
        whenever(getMoviesUseCase.execute()).thenReturn(just(MoviesStub.listMoviesMock))

        // When
        setup()

        // then
        verify(
            movieListObservable,
            org.mockito.kotlin.calls(1)
        ).onChanged(MoviesStub.listMoviesMock)
    }

    //Not working
    @Test
    fun `movieListObservable_should_return_movie_list`() {
        viewModel.movieListLiveData.getOrAwaitValue()

        setup()

        val value: List<Movies>? = viewModel.movieListLiveData.value
        assertNotNull(value?.last())
        assertEquals(value?.last()?.equals(MoviesStub.listMoviesMock), "test")
    }

}