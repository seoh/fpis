package ch03

object Exercise12 extends App {
  
  def reverse[A](list: List[A]): List[A] =
    List.foldLeft(list, Nil: List[A])((acc, a) => Cons(a, acc))
  

  // test //
  println(reverse(List(1,2,3)))
}
