package ch03

object Exercise14 extends App {

  def append[A](prev: List[A], next: List[A]): List[A] =
    List.foldRight(prev, next)((i, acc) => Cons(i, acc))


  // test //  
  val as1 = List(1,2,3)
  val as2 = List(4,5,6)

  println(append(as1, as2))
}
