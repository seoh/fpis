package ch04

object Exercise01 extends App {
  // trait Option[+A] {
  //   def map[B](f: A => B): Option[B]
  //   def flatMap[B](f: A => Option[B]): Option[B]
  //   def getOrElse[B >: A](default: => B): B
  //   def orElse[B >: A](ob: => Option[B]): Option[B]
  //   def filter(f: A => Boolean): Option[A]
  // }
  // case class Some[+A](get: A) extends Option[A] {
  //   def map[B](f: A => B): Option[B] = Some(f(get))
  //   def flatMap[B](f: A => Option[B]): Option[B] = f(get)
  //   def getOrElse[B >: A](default: => B): B = get
  //   def orElse[B >: A](ob: => Option[B]): Option[B] = this
  //   def filter(f: A => Boolean): Option[A] =
  //     if(f(get)) this
  //     else None
  // }
  // case object None extends Option[Nothing] {
  //   def map[B](f: Nothing => B): Option[B] = None
  //   def flatMap[B](f: Nothing => Option[B]): Option[B] = None
  //   def getOrElse[B](default: => B): B = default
  //   def orElse[B](ob: => Option[B]): Option[B] = ob
  //   def filter(f: Nothing => Boolean): Option[Nothing] = None
  // }

  trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case Some(a) => Some(f(a))
      case None => None
    }
    def getOrElse[B >: A](default: => B): B = this match {
      case Some(a) => a
      case _ => default
    }

    def flatMap[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)
    def orElse[B >: A](ob: => Option[B]): Option[B] = map(Some.apply).getOrElse(ob)
    def filter(f: A => Boolean): Option[A] = flatMap(a => if(f(a)) Some(a) else None)
  }
  
  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]

  // test //
  val some: Option[Int] = Some(1)
  val none: Option[Int] = None
  
  println(
    some.map(_ + 1) == Some(2) &&
    none.map(_ + 1) == none
  )

  println(
    some.flatMap(_ => some) == some &&
    none.flatMap(_ => some) == none
  )

  println(
    some.getOrElse(0) == 1 &&
    none.getOrElse(0) == 0
  )

  println(
    some.orElse(none) == some &&
    none.orElse(some) == some
  )

  println(
    some.filter(_ % 2 == 1) == some &&
    some.filter(_ % 2 == 0) == none &&
    none.filter(_ % 2 == 1) == none &&
    none.filter(_ % 2 == 0) == none
  )
}
