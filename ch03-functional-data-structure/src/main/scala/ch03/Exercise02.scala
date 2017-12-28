package ch03

object Exercise02 extends App {

  def tail[T](list: List[T]): List[T] = list match {
    case Cons(h, t) => t
    case Nil => throw new NullPointerException
  }

  // test //
  println(tail(List(1,2,3)))
  try {
    println(tail(tail(List(1))))
  } catch {
    case e: Exception => println(e)
  }
}
