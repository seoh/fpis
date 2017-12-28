package ch02

object Exercise03 extends App {
  
  def curry[A, B, C] (f: (A, B) => C): A => (B => C) = 
    a => b => f(a, b)

  // test //
  val add = curry[Int, Int, Int](_ + _)
  val inc = add(1)
  val dec = add(-1)

  println(inc(1) == 2)
  println(dec(1) == 0)
}
