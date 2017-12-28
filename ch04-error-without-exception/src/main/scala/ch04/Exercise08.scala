package ch04

object Exercise08 extends App {

  case class Person(name: Name, age: Age)
  sealed class Name(val value: String)
  sealed class Age(val value: Int)

  def mkName(name: String): Either[String, Name] =
    if(name.isEmpty) Left("Name is empty.")
    else Right(new Name(name))
  
  def mkAge(age: Int): Either[String, Age] =
    if(age < 0) Left("Age is out of range.")
    else Right(new Age(age))

  def mkPerson(name: String, age: Int): Either[String, Person] =
    for {
      n <- mkName(name)
      a <- mkAge(age)
    } yield Person(n, a)
}
