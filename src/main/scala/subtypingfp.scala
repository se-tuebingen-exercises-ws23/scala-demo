package demo

// In Scala, we have multiple ways of modeling variants.
// 1) As an enumeration (e.g., enum ... { case A; case B })
// 2) By using type union (e.g., A | B)
// 3) By using subtyping.
object demoEnumerationAgain {

  // 1) Enumeration
  enum TrafficLight {
    case Red
    case Yellow
    case Green
  }

  def switchTrafficLight(t: TrafficLight): TrafficLight = t match {
    case TrafficLight.Red => TrafficLight.Green
    case TrafficLight.Yellow => TrafficLight.Red
    case TrafficLight.Green => TrafficLight.Yellow
  }

  println(switchTrafficLight(TrafficLight.Green)) // Yellow
}

object demoUnionTypes {

  // Let us assume:
  case class Red()
  case class Yellow()
  case class Green()

  // If we already have some types defined, we translate the BSL comment into a
  // Scala type declaration:
  type TrafficLight = Red | Yellow | Green

  def switchTrafficLight(t: TrafficLight): TrafficLight = t match {
    case Red() => Green()
    case Yellow() => Red()
    case Green() => Yellow()
  }

  println(switchTrafficLight(Green())) // Yellow()
}

object demoSubtypes {

  // Finally, we can use Scala's subtyping feature to express that "Red is a TrafficLight".
  sealed trait TrafficLight
  case class Red() extends TrafficLight
  case class Yellow() extends TrafficLight
  case class Green() extends TrafficLight

  def switchTrafficLight(t: TrafficLight): TrafficLight = t match {
    case Red() => Green()
    case Yellow() => Red()
    case Green() => Yellow()
  }

  println(switchTrafficLight(Green()))
}
