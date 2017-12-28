package ch03

object Exercise16 extends App {

  def inc(is: List[Int]): List[Int] =
    List.foldRight(is, Nil: List[Int]) { (i, acc) =>
      Cons(i + 1, acc)
    }

  // test //
  println(inc(List(1,2,3)))
}
