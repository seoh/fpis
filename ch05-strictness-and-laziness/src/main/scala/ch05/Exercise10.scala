package ch05

object Exercise10 extends App {
  
  // // stackoverflow
  // def fibs: Stream[Int] =
  //   Stream(0, 1).append(fibs.zip(fibs.tail).map{case (a, b) => a+b})
  val fibs = {
    def go(f0: Int, f1: Int): Stream[Int] = 
      Stream.cons(f0, go(f1, f0+f1))
    go(0, 1)
  }


  // test //
  import Exercise02.{StreamOps => Ops2}

  println(fibs.take(1))
}
