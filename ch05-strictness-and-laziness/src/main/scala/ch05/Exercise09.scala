package ch05

object Exercise09 extends App {
  
  def from(n: Int): Stream[Int] =
    Stream.cons(n, from(n + 1))


  // test //
  import Exercise02.StreamOps

  println(from(0).take(3))
}
