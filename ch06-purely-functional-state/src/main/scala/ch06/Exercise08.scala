package ch06

object Exercise08 extends App {

  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = rng => {
    val (a, r) = f(rng)
    g(a)(r)
  }

  def unit[A](a: A): Rand[A] = rng => (a, rng)

  def nonNegativeLessThan(n: Int): Rand[Int] =
    flatMap(Exercise01.nonNegativeInt) { i =>
      val mod = i % n
      if (i + (n-1) - mod >= 0) unit(mod) else nonNegativeLessThan(n)
    }


  // test //
  println(nonNegativeLessThan(10)(SimpleRNG(42)))
}
