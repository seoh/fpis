package ch02

object Exercise05 extends App {

  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  // test //
  val inc: Int => Int = _ + 1
  val inv: Int => Int = _ * -1

  println(compose(inc, inv)(1) == (-1 + 1))
  println(compose(inv, inc)(1) == (2 * -1))
}
