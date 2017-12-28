package ch05

object Exercise02 extends App {
  
  implicit class StreamOps[T](stream: Stream[T]) {
    def take(n: Int): Stream[T] =
      if(n <= 0) Empty
      else stream match {
        case Empty => Empty
        case Cons(h, t) => Stream.cons(h(), t().take(n-1))
      }

    def drop(n: Int): Stream[T] =
      if(n <= 0) stream
      else stream match {
        case Empty => Empty
        case Cons(h, t) => t().drop(n-1)
      }

  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.take(2))
  println(s.drop(2))
}
