package ch03

object Exercise10 extends App {

  /**
    `foldLeft` is implemented in `List.scala`. coz it will be used commonly.
   */

  // test //
  val as = (0 to 10000).foldRight(Nil: List[Int])((i, acc) => Cons(i, acc))

// [error] java.lang.StackOverflowError
// [error] 	at ch03.Cons.tail(List.scala:5)
// [error] 	at ch03.List$.foldRight(List.scala:28)
// [error] 	at ch03.List$.foldRight(List.scala:28)
// [error] 	at ch03.List$.foldRight(List.scala:28)
  // println(List.foldRight(as, 0)(_ + _))

  println(List.foldLeft(as, 0)(_ + _))
  
}
