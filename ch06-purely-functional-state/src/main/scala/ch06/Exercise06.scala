package ch06

object Exercise06 extends App {

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    rng => {
      val (a, r1) = ra(rng)
      val (b, r2) = rb(r1)
      (f(a, b), r2)
    }

  // test //
  val rng: RNG = SimpleRNG(42)
  println(
    map2(_.nextInt, Exercise05.double) { (n, d) =>
      n.toDouble + d
    } (rng)
  )
}
