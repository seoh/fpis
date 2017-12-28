package ch02

object Exercise02 extends App {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean  =
    as.zip(as.tail).map(ordered.tupled).forall(b => b)


  // test //
  println(isSorted[Int](Array(1,2,3,4), (_ < _)))
  println(isSorted[String](Array("f", "ed", "cba"), (_.length < _.length)))
}
