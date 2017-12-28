package ch05

object Exercise12 extends App {  
  import Exercise11.unfold

  def constants[A](a: A): Stream[A] = unfold(a) { s => Some((s, s)) }

  def ones: Stream[Int] = constants(1)

  def from(n: Int): Stream[Int] = unfold(n) { s => Some((s, s+1))}

  def fibs: Stream[Int] = unfold((0, 1)) {
    case (prev, curr) => Some(prev, (curr, prev+curr))
  }

  // fibs, from ,constant, ones


  // test //
  import Exercise02.StreamOps

  println(constants("1").take(5))
  println(ones.take(5))
  println(from(5).take(5))
  println(fibs.take(10))

}
