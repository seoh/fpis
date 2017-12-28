package ch06

object Exercise03 extends App {
  import Exercise02.double

  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (i, next1) = rng.nextInt
    val (d, next2) = double(next1)
    ((i, d), next2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val ((i, d), next) = intDouble(rng)
    ((d, i), next)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, next1) = double(rng)
    val (d2, next2) = double(next1)
    val (d3, next3) = double(next2)
    ((d1, d2, d3), next3)
  }


  // test //
  val rng: RNG = SimpleRNG(42)
  println(intDouble(rng)._1)
  println(doubleInt(rng)._1)
  println(double3(rng)._1)
}
