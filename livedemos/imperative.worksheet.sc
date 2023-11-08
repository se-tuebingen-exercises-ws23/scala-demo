"fsdfs"

true

false

1 < 4

def foo(n: Int) = println(n)

foo(if true then 1 else 2)

var x = 42

println(x)
x = 5

// (define (sayHello name) ...)
def sayHello(name: String) =
  println(s"hello ${name}!");
  println("Hello again")

sayHello("Info 3")
// Expressions vs. Statements


def add(n: Int, m: Int) = n + m

val result = if 10 > 14 then "hello" else "world"

var n = 10
while (n > 0) {
  println(n);
  n = n - 1
}

val numbersFromZeroToTen = 0 until 9

// for comprehension
for (
  n <- numbersFromZeroToTen;
  m <- numbersFromZeroToTen;
  if n + m == 15
) {
  println(s"${n}, ${m}")
}

val arr = Array.ofDim[String](10)

arr(0) = "hello"

println(arr(1))


for (el <- arr) {
  println(el)
}

import scala.collection.mutable.HashMap

val m = HashMap.empty[String, Int]

val z = 10

m.put("mykey", 12)

m.getOrElse("mykey", -1)