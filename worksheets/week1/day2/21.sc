
trait Day

object Day {
  case object Weekday extends Day
  case object Weekend extends Day
}

Day.Weekend
Day.Weekend

def m(day: Day) = day

m(Day.Weekend)
m(Day.Weekday)

// similarly define Regular and Reward customer

// reservationService.book(regular, List(weekday, weekday, weekday)) => best hotel option
// reservationService.book(regular, List(weekday, weekend, weekend)) => best hotel option
// reservationService.book(rewards, List(weekday, weekday, weekend)) => best hotel option

//what is the best option
// cheapest!
// if there is tie, higher the rating, better it is
