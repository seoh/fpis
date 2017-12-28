package ch03

object Exercise20 extends App {

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    List.foldRight(as, Nil: List[B]) { (a, acc) =>
      Exercise14.append(f(a), acc)
    }

  
  // test //
  println(flatMap(List(1,2,3))(i => List(i, i)))
}
