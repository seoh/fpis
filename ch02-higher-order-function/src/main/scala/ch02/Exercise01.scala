package ch02

import scala.annotation.tailrec

object Exercise01 extends App {

  def fib(n: Int): Int = {
    @tailrec def f(curr: Int, next: Int, index: Int): Int =
      if(index >= n) curr
      else f(next, curr+next, index+1)

    f(0, 1, 0)
  }

  // test //
  for(i <- 0 to 10) println(fib(i))

}
