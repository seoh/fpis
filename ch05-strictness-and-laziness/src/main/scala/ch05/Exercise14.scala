package ch05

object Exercise14 extends App {

  implicit class StreamOps[A](stream: Stream[A]) {
    def startsWith(s2: Stream[A]): Boolean = (stream, s2) match {
      case (Cons(h1, t1), Cons(h2, t2)) => h1() == h2() && t1().startsWith(t2())
      case (_, Empty) => true
      case _ => false
    }
  }

  // test //
  val s = Stream(1,2,3,4)
  println(s.startsWith(Stream(1,2)))
  println(s.startsWith(Stream(1,3)))
}
