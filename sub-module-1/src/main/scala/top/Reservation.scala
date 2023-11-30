package top

sealed trait Day

object Day {
  case object Weekday extends Day
  case object Weekend extends Day
}

sealed trait Customer

object Customer {
  case object Regular extends Customer
  case object Rewards extends Customer
}

case class Category(customer: Customer, day: Day)

case class BookingRequest(customer: Customer, days: List[Day]) {
  def categories: List[Category] = days.map(d => Category(customer, d))
}

case class Hotel(name: String, rating: Int, rates: Map[Category, Int]) {
  def priceOf(category: Category): Int = rates(category)
}

object Data {
  val hotels = List(
    Hotel(
      "Lakewood",
      3,
      Map(
        Category(Customer.Regular, Day.Weekday) -> 110,
        Category(Customer.Rewards, Day.Weekday) -> 80,
        Category(Customer.Regular, Day.Weekend) -> 90,
        Category(Customer.Rewards, Day.Weekend) -> 80
      )
    ),
    Hotel(
      "Bridgewood",
      4,
      Map(
        Category(Customer.Regular, Day.Weekday) -> 160,
        Category(Customer.Rewards, Day.Weekday) -> 110,
        Category(Customer.Regular, Day.Weekend) -> 60,
        Category(Customer.Rewards, Day.Weekend) -> 50
      )
    ),
    Hotel(
      "Ridgewood",
      5,
      Map(
        Category(Customer.Regular, Day.Weekday) -> 220,
        Category(Customer.Rewards, Day.Weekday) -> 100,
        Category(Customer.Regular, Day.Weekend) -> 150,
        Category(Customer.Rewards, Day.Weekend) -> 40
      )
    )
  )
}

class RatingService() {
  def currentRating(hotel: Hotel) = hotel.name match
    case "Lakewood"   => 10
    case "Bridgewood" => 20
    case "Ridgewood"  => 30
}

class ReservationService(hotels: List[Hotel], webService: RatingService) {
  def find(bookingRequest: BookingRequest): Hotel = {
    hotels.minBy { hotel =>
      (bookingRequest.categories.map(hotel.priceOf).sum, -hotel.rating)
    }
  }

  def currentRatingForBestHotel(bookingRequest: BookingRequest): Int = {
    val hotel = find(bookingRequest)
    webService.currentRating(hotel)
  }
}
