package ch03

object Exercise13 extends App {

  // from https://github.com/fpinscala/fpinscala/blob/master/answerkey/datastructures/13.answer.scala#L16-L52
  def foldLeft[A, B](list: List[A], z: B)(f: (B, A) => B): B = {
    def identity[T]: T => T =
      t => t

    def combinerDelayer:(A, B => B) => B => B =
      (a: A, delayFunc: B => B) => (b: B) => delayFunc(f(b, a))
    
    def go:B => B =
      List.foldRight(list, identity[B])(combinerDelayer)

    go(z)
  }


  // test //
  val xs = List(1,2,3,4,5)
  foldLeft(xs, 0) { (i, acc) =>
    println(i, acc)
    i + acc
  }
}
