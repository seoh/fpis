package ch05

object Exercise07 extends App {
  
  implicit class StreamOps[A](stream: Stream[A]) {
    // map, filter, append, flatMap

    def map[B, C](f: A => B): Stream[B] =
      stream.foldRight(Empty: Stream[B]) { (a, acc) =>
        Stream.cons(f(a), acc)
      }
    
    def filter(p: A => Boolean): Stream[A] =
      stream.foldRight(Empty: Stream[A]) { (a, acc) =>
        if(p(a)) Stream.cons(a, acc)
        else acc
      }

    def append[B >: A](that: Stream[B]): Stream[B] =
      stream.foldRight(that) { (a, acc) => Stream.cons(a, acc) }

    def flatMap[B](f: A => Stream[B]): Stream[B] =
      stream.foldRight(Empty: Stream[B]) { (a, acc) =>
        f(a).append(acc)
      }
  }


  // test //
  val s = Stream(1,2,3,4)
  println(s.map(_ + 1))
  println(s.filter(_ % 2 == 1))
  println(s.append(Stream(3,2,1)))
  println(s.flatMap(a => Stream(a.toString, a.toString)))
}
