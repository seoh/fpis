package ch06

object Exercise01 extends App {

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n, next) = rng.nextInt
    (math.abs(n/2), next)
  }


  // test //
  (0 until 10).foldLeft(SimpleRNG(42): RNG) {
    case (rng, _) =>
      val (n, next) = nonNegativeInt(rng)
      println(n)
      next
  }
}
