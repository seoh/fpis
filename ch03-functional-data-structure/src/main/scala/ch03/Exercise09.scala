package ch03

object Exercise09 extends App {

  def length[A](as: List[A]): Int =
    List.foldRight(as, 0)((_, acc) => acc + 1)
  
  // test //
  println(length(List(1,2,3,4)))
  println(length(Nil))
}
