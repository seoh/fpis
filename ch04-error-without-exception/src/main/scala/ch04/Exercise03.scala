package ch04

object Exercise03 extends App {

  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    (a, b) match {
      case (Some(a), Some(b)) => Some(f(a, b))
      case _ => None
    }
  
  // test //
  println(
    map2(Some(1), Some(2))(_ + _).get == 3
  )
}
