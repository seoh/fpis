package ch04

object Exercise07 extends App {
  import scala.util.Try

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] =
    es.foldRight(Right(List.empty[A]): Either[E, List[A]]) { (e, acc) =>
      for {
        a <- e
        as <- acc
      } yield a :: as
    }

  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
    as.foldRight(Right(List.empty[B]): Either[E, List[B]]) { (a, acc) =>
      for {
        bs <- acc
        b <- f(a)
      } yield b :: bs
    }


  // test //
  println(
    sequence(List(Right(2), Right(1), Left("a"))) == Left("a") &&
    sequence(List(Right(2), Right(1))) == Right(List(2,1))
  )

  println(
    traverse(List("1", "2", "3"))(s => Try(s.toInt).toEither)
  )

  println(
    traverse(List("1", "2", "a"))(s => Try(s.toInt).toEither)
  )
}
