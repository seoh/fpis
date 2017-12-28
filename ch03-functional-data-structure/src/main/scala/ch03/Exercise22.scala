package ch03

object Exercise22 extends App {

  def add(is1: List[Int], is2: List[Int]): List[Int] = (is1, is2) match {
    case (Cons(i1, is1), Cons(i2, is2)) => Cons(i1+i2, add(is1, is2))
    case (_, _) => Nil
  }

  // test //
  println(add(List(1,2,3), List(4,5,6)))
}
