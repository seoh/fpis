package ch03

object Exercise03 extends App {

  def setHead[T](list: List[T], head: T): List[T] = list match {
    case Cons(h, t) => Cons(head, t)
    case Nil => Cons(head, Nil)
  }

  // test //
  println(setHead(List(1,2,3), 10))
  println(setHead(Nil, 2))
}
