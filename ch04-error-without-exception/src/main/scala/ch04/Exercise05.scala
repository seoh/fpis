package ch04

object Exercise05 extends App {
  import scala.util.Try

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
    a.foldRight(Some(List.empty[B]): Option[List[B]]) { (a, acc) =>
      for {
        bs <- acc
        b <- f(a)
      } yield b :: bs
    }
  
  
  // test //
  println(
    traverse(List("1", "2", "3"))(s => Try(s.toInt).toOption)
  )

  println(
    traverse(List("1", "2", "a"))(s => Try(s.toInt).toOption)
  )
}
