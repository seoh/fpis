package ch05

object Exercise08 extends App {
  
  def constant[A](a: A): Stream[A] =
    Stream.cons(a, constant(a))


  // test //
  import Exercise02.StreamOps

  println(constant("a").take(3))
}
