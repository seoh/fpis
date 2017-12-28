package ch03

object Exercise11 extends App {

  def sum(as: List[Int]): Int =
    List.foldLeft(as, 0)(_ + _)
  
  def product(as: List[Double]): Double =
    List.foldLeft(as, 1.0)(_ * _)

  def length[A](as: List[A]): Int =
    List.foldLeft(as, 0)((acc, _) => acc + 1)

  
  // test //
  val xs = List(1,2,3,4)
  println(sum(xs))
  println(product(List(1.0, 2.0, 3.0)))
  println(length(xs))
}
