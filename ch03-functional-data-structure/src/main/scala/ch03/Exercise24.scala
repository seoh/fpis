package ch03

object Exercise24 extends App {

  def contains[A](as: List[A], a: A): Boolean =
    List.foldLeft(as, false) { (acc, i) =>
      if(acc) acc
      else i == a
    }

  def hasSequence[A](sup: List[A], sub: List[A]): Boolean =
    List.foldLeft(sub, true) { (acc, i) =>
      if(acc) contains(sup, i)
      else false
    }    
  
  // test //
  println(hasSequence(List(1,2,3,4), List(2,4)))
  println(hasSequence(List(1,2,3,4), List(1)))
  println(hasSequence(List(1,2,3,4), Nil))
}
