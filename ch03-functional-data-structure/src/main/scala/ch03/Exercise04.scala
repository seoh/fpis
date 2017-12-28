package ch03

object Exercise04 extends App {

  def drop[A](l: List[A], n: Int): List[A] =
    if(n < 1) l
    else l match {
      case Cons(_, t) => drop(t, n-1)
      case Nil => Nil
    }

  // test //
  val as = List(1,2,3)
  
  println(drop(as, 1))
  println(drop(as, 4))

}
