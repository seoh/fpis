package ch06

object Exercise04 extends App {

  def ints(count: Int)(rng: RNG): (List[Int], RNG) =
    (0 until count).foldRight((List.empty[Int], rng)) {
      case (_, (is, r)) =>
        val (i, next) = r.nextInt
        (i :: is, next)
    }

  // test //
  val rng: RNG = SimpleRNG(42)
  println(ints(10)(rng)._1)
}
