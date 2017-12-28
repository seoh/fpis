package ch05

object Exercise13 extends App {
  import Exercise11.unfold

  implicit class StreamOps[A](stream: Stream[A]) {
    def map[B](f: A => B): Stream[B] = unfold(stream) {
      case Empty => None
      case Cons(h, t) => Some((f(h()), t()))
    }

    def take(n: Int): Stream[A] = unfold((stream, n)) {
      case (Cons(h, t), n) if n > 0 => Some((h(), (t(), n-1)))
      case _ => None
    }

    def takeWhile(p: A => Boolean): Stream[A] = unfold(stream) {
      case Cons(h, t) if(p(h())) => Some((h(), t()))
      case _ => None
    }

    def zipWith[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] =
      unfold((stream, s2)) {
        case (Cons(h1, t1), Cons(h2, t2)) => Some((f(h1(), h2())), (t1(), t2()))
        case _ => None
      }

    def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] =
      unfold((stream, s2)) {
        case (Cons(h1, t1), Cons(h2, t2)) => Some((Some(h1()), Some(h2())), (t1(), t2()))
        case (Cons(h1, t1), _) => Some((Some(h1()), None), (t1(), Empty))
        case (_, Cons(h2, t2)) => Some(((None, Some(h2())), (Empty, t2())))
        case _ => None
      }
  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.map(_ + 1))
  println(s.take(2))
  println(s.takeWhile(_ < 2))
  println(s.zipWith(Stream("a", "b", "c"))(_.toString + _))
  println(s.zipAll(Stream("a", "b", "c")))
}
