package ch05

object Exercise05 extends App {
  
  implicit class StreamOps[T](stream: Stream[T]) {
    def takeWhile(p: T => Boolean): Stream[T] =
      stream.foldRight(Empty: Stream[T]) { (a, acc) =>
        if(p(a)) Stream.cons(a, acc)
        else Empty
      }
  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.takeWhile(_ % 2 == 1))
  println(s.takeWhile(_ < 5))
}
