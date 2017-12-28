package ch05

object Exercise16 extends App {

  implicit class StreamOps[A](stream: Stream[A]) {
    def head: A = stream match {
      case Cons(h, t) => h()
      case Empty => throw new NullPointerException
    }

    def scanRight[B](z: B)(f: (A, B) => B): Stream[B] =
      stream.foldRight(Stream(z)) { (a, acc) =>
        Stream.cons(f(a, acc.head), acc)
      }
  }

  // test //
  val s = Stream(1,2,3,4)
  println(s.scanRight(0)(_ + _)) // (10, 9, 7, 4, 0)
}
