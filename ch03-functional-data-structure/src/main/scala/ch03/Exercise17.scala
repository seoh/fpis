package ch03

object Exercise17 extends App {

  def str(ds: List[Double]): List[String] =
    List.foldRight(ds, Nil: List[String]) { (d, acc) =>
      Cons(d.toString, acc)
    }


  // test //
  println(List(1.0, 2.0, 3.0))
}
