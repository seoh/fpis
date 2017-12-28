package ch06

object Exercise02 extends App {

  def double(rng: RNG): (Double, RNG) = {
    val base: Double = Int.MaxValue.toDouble - Int.MinValue
    val (n, next) = rng.nextInt
    ((n.toDouble - Int.MinValue) / base, next)
  }


  // test //
  (0 until 10).foldLeft(SimpleRNG(42): RNG) {
    case (rng, _) =>
      val (n, next) = double(rng)
      println(n)
      next
  }
}
