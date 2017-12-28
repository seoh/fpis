package ch06

object Exercise07 extends App {

  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = rng => {
    fs.foldRight((List.empty[A], rng)) {
      case (f, (as, r)) =>
        val (a, r2) = f(r)
        (a :: as, r2)
    }
  }

  def ints(count: Int): Rand[List[Int]] =
    sequence(List.fill(count)(_.nextInt))


  // test //
  val rand: Rand[Int] = _.nextInt
  println(ints(10)(SimpleRNG(42): RNG)._1)
}
