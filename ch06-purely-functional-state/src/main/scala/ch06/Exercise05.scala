package ch06

object Exercise05 extends App {
  
  def double: Rand[Double] = map(_.nextInt) { i =>
    (i.toDouble - Int.MinValue) / (Int.MaxValue.toDouble - Int.MinValue)
  }

  // test //
  val rng: RNG = SimpleRNG(42)
  println(double(rng))
}
