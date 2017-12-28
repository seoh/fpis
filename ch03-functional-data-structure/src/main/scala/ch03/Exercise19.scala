package ch03

object Exercise19 extends App {

  def filter[A](as: List[A])(p: A => Boolean): List[A] =
    List.foldRight(as, Nil: List[A]) { (a, acc) =>
      if(p(a)) Cons(a, acc)
      else acc
    }

  
  println(filter(List(1,2,3,4))(_ % 2 == 0))

}
