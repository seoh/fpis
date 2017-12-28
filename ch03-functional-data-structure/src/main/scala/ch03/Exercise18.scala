package ch03

object Exercise18 extends App {
  
  def map[A, B](as: List[A])(fn: A => B): List[B] =
    List.foldRight(as, Nil: List[B]) { (a, acc) =>
      Cons(fn(a), acc)
    }


  // test //
  def inc(is: List[Int]) = map(is)(_ + 1)

  println(inc(List(1,2,3)))
}
