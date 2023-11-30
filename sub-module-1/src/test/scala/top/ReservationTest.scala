package top

import org.mockito.ArgumentMatchers.any
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.*

class ReservationTest extends AnyFreeSpec with Matchers with MockitoSugar {

  "reservation service" - {
    "group1" - {
      val reservationService = new ReservationService(Data.hotels, null)

      "should select Lakewood as the best hotel" in {
        val hotel =
          reservationService.find(BookingRequest(Customer.Regular, List(Day.Weekday, Day.Weekday, Day.Weekday)))
        hotel shouldBe (Data.hotels(0))
      }

      "should select Bridgewood as the best hotel" in {
        val hotel =
          reservationService.find(BookingRequest(Customer.Regular, List(Day.Weekday, Day.Weekend, Day.Weekend)))
        hotel shouldBe (Data.hotels(1))
      }

      "should select Ridgewood as the best hotel" in {
        val hotel =
          reservationService.find(BookingRequest(Customer.Rewards, List(Day.Weekday, Day.Weekday, Day.Weekend)))
        hotel shouldBe (Data.hotels(2))
      }
    }

    "group2" - {
      "find current rating" in {
        val ratingService = mock[RatingService]
        val reservationService = new ReservationService(Data.hotels, ratingService)

        when(ratingService.currentRating(any[Hotel])).thenReturn(100)

        val rating = reservationService.currentRatingForBestHotel(
          BookingRequest(Customer.Rewards, List(Day.Weekday, Day.Weekday, Day.Weekend))
        )

        rating shouldBe(100)
      }
    }
  }

}
