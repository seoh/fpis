package ch04

object Exercise04 extends App {

  def sequence[A](a: List[Option[A]]): Option[List[A]] =
    if(a.exists(_ == None)) None
    else Some(a.map(_.get))
  
  // test //
  println(
    sequence(List(Some(.1), Some(.2), Some(.3), Some(.4)))
  )
}
