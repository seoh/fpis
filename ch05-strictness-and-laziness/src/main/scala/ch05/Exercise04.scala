package ch05

object Exercise04 extends App {
  
  implicit class StreamOps[T](stream: Stream[T]) {
    def forAll(p: T => Boolean): Boolean =
      stream match {
        case Cons(h, t) => p(h()) && t().forAll(p)
        case _ => true
      }

  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.forAll(_ % 2 == 0))
  println(s.forAll(_ < 5))
}
