package ch05

object Exercise06 extends App {
  
  implicit class StreamOps[T](stream: Stream[T]) {
    def headOption: Option[T] =
      stream.foldRight(None: Option[T]) { (a, acc) => Some(a) }
  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.headOption)
  println(Empty.headOption)
}
