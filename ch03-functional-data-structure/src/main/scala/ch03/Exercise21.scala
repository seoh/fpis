package ch03

object Exercise21 extends App {

  def filter[A](as: List[A])(p: A => Boolean): List[A] =
    Exercise20.flatMap(as) { a =>
      if(p(a)) List(a)
      else Nil
    }
  
  // test //
  println(filter(List(1,2,3,4))(_ % 2 == 0))
}
