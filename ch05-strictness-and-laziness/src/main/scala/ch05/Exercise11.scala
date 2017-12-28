package ch05

object Exercise11 extends App {
  
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] =
    f(z) match {
      case None => Empty
      case Some((a, s)) =>
        def head() = a
        def tail() = unfold(s)(f)
        Cons(head, tail)
    }

  // test //
  val stream = unfold(0) { s => 
    if(s < 10) Some((s, s+1))
    else None
  }
  println(stream)
}
