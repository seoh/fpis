package ch03

object Exercise23 extends App {

  def zipWith[A, B, C](as: List[A], bs: List[B])(fn: (A, B) => C): List[C] = 
    (as, bs) match {
      case (Cons(a, as), Cons(b, bs)) => Cons(fn(a, b), zipWith(as, bs)(fn))
      case (_, _) => Nil
    }


  // test //
  println(zipWith(List(1,2,3), List(4,5,6))(_ + _))
}
