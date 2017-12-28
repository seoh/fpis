package ch03

object Exercise15 extends App {

  def flatten[A](aas: List[List[A]]): List[A] = Exercise12.reverse(aas) match {
    case Nil => Nil
    case Cons(a, as) =>
      List.foldLeft(as, a) { (acc, i) =>
        Exercise14.append(i, acc)
      }
  }

  // test //
  println(flatten(List(
    List(1,2,3),
    List(7,8,9),
    List(4,5,6)
  )))
}
