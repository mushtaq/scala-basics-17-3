package top

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class ReservationTest2 extends AnyFreeSpec with Matchers {

  val reservationService = new ReservationService(Data.hotels, null)

  "reservation service" - {
    "group1" - {
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
  }

}
