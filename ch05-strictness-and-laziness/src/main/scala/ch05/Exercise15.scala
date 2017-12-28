package ch05

object Exercise15 extends App {
  import Exercise11.unfold
  import Exercise06.{StreamOps => Ops06}

  implicit class StreamOps[A](stream: Stream[A]) {
    // def tails: Stream[Stream[A]] = unfold(stream) {
    //   case self @ Cons(h, t) => Some((self, t()))
    //   case _ => None
    // } // append Stream(Empty)

    def tails: Stream[Stream[A]] =
      stream.foldRight(Stream.cons(Empty, Empty): Stream[Stream[A]]) { (a, acc) =>
        Stream.cons(Stream.cons(a, acc.headOption.getOrElse(Empty)), acc)
      }
  }

  // test //
  val s = Stream(1,2,3,4)
  println(s.tails)
}
