package ch05

object Exercise03 extends App {
  
  implicit class StreamOps[T](stream: Stream[T]) {
    def takeWhile(p: T => Boolean): Stream[T] =
      stream match {
        case Cons(h, t) if(p(h())) => Stream.cons(h(), t().takeWhile(p))
        case _ => Empty
      }

  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.takeWhile(_ < 4))
}
