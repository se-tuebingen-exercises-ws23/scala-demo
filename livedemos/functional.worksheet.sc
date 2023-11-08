
// higher order function
//Int => (Int => Int)
//(Int => Int) => Int
def compose[A, B, C](f: A => B, g: B => C)(n: A): C = g(f(n))


val add = (x: Int) => x + 1

val h = compose[Int, Int, Int](add, y => y * 2)

h(10)

val l = List(1, 2, 3)

val l2 = 1 :: 2 :: 3 :: Nil

l.updated(2, 0)

def sum(l: List[Int]): Int = l match {
  case Nil => 0
  case head :: tail => head + sum(tail)
}

sum(l2)

l.map { x => x * 2 }
l.filter { x => x > 2 }.map { x => x * 2 }
l.collect { case x if x > 2 => x * 2 }

l.map { x => List(x, x) }.flatten

// bind, >>=
l.flatMap { x => List(x, x) }

println(for (el <- l; el <- l) yield el + el)


case class Person(name: String, favoriteFood: String)

val p = Person("Jonathan", "Pastels de Nata")
println(s"Hello ${p.name}. I see you like: ${p.favoriteFood}")

enum TrafficLight {
  case Red
  case Yellow()
  case Green()
}

import TrafficLight.*

val color = Red

def nextLight(color: TrafficLight) =
  color match {
    case Red => Green()
    case Yellow() => Red
    case Green() => Yellow()
  }

nextLight(color)

case class Crossing(horizontal: TrafficLight, vertical: TrafficLight)

def isAllowed(c: Crossing) = c match {
  case Crossing(Green(), Green()) => false
  case _ => true
}
