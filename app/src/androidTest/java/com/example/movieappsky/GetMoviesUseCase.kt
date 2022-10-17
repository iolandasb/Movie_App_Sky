package com.example.movieappsky

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class GetMoviesUseCase {
//    @get:Rule
//    val coroutineTestRule = CoroutineTestRule()
//
//    private val couponRepository: CouponRepository = mock()
//    private val requestPromotionsDataUseCase = GetMoviesUseCase(moviesRepository)
//
//    @Test
//    fun `invoke from useCase should return a promotions list when response is a success`() =
//            runBlocking {
//                // Given
//                whenever(couponRepository.fetchCouponData())
//                    .thenReturn(flowOf(couponsListDataMock()))
//
//                // When
//                val result = requestPromotionsDataUseCase()
//
//                // Then
//                verify(couponRepository).fetchCouponData()
//                verifyNoMoreInteractions(couponRepository)
//                result.test {
//                    val couponsListMock = couponsListDataMock()
//                    assertEquals(couponsListMock, expectItem())
//                    expectComplete()
//                }
//            }
}