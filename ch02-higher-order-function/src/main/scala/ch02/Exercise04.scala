package ch02

object Exercise04 extends App {

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = 
    (a, b) => f(a)(b)

  // test //
  val curriedAdd: Int => Int => Int = a => b => a + b
  val add = uncurry(curriedAdd)
  println(add(1,2) == 3)
}
