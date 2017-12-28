package ch03

object Exercise06 extends App {

  def init[A](l: List[A]): List[A] = l match {
    case Cons(h, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
    case Nil => Nil
  }

  // test //
  println(init(List(1,2,3)))
  println(init(List(1)))
  println(init(Nil))
}
