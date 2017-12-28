package ch06

object Exercise09 extends App {
  import Exercise08.{ flatMap, unit }

  def map[A, B](ra: Rand[A])(f: A => B): Rand[B] =
    flatMap(ra)(a => unit(f(a)))

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    flatMap(ra)(a => flatMap(rb)(b => unit(f(a, b))))

  // test //
  val r = SimpleRNG(42)
  val rand: Rand[Int] = _.nextInt
  println(map(rand)(_.toString)(r))
  println(map2(rand, rand)(_ + _)(r))
}
