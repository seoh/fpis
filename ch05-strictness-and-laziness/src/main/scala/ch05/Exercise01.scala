package ch05

object Exercise01 extends App {
  
  implicit class StreamOps[T](stream: Stream[T]) {
    def toList: List[T] = stream match {
      case Cons(h, t) => h() :: t().toList
      case Empty => Nil
    }
  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.toList)
}
