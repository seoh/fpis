package ch04

object Exercise06 extends App {

  sealed trait Either[+E, +A] {
    def map[B](f: A => B): Either[E, B] = this match {
      case Left(e) => Left(e)
      case Right(a) => Right(f(a))
    }

    def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
      case Left(e) => Left(e)
      case Right(a) => f(a)
    }

    def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] =
      this match {
        case Right(v) => Right(v)
        case Left(e) => b
      }

    def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
      for {
        x <- this
        y <- b
      } yield f(x, y)
  }
  case class Left [+E](value: E) extends Either[E, Nothing]
  case class Right[+A](value: A) extends Either[Nothing, A]


  // test //
  val r: Either[String, Int] = Right(1)
  val l: Either[String, Int] = Left("err")

  println(
    r.map(_ + 1) == Right(2)
  )

  println(
    r.flatMap(v => if(v % 2 == 1) Left("odd") else Right(0)) == Left("odd")
  )

  println(
    l.orElse(r) == Right(1)
  )

  println(
    r.map2(r)(_ + _) == Right(2)
  )
}
