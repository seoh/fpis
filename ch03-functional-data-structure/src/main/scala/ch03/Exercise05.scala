package ch03

object Exercise05 extends App {

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
  }

  // test //
  val as = List(1,2,3)
  
  println(dropWhile[Int](as, _ < 2))
  println(dropWhile[Int](as, _ % 2 == 1))
}
