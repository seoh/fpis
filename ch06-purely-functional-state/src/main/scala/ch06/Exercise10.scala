package ch06

object Exercise10 extends App {
  case class State[S, +A](run: S => (A, S)) {
    def map[B](f: A => B): State[S, B] = State(s => {
      val (a, next) = this.run(s)
      (f(a), next)
    })

    def map2[B, C](sb: State[S, B])(f: (A, B) => C): State[S, C] =
      State(s => {
        val (a, next1) = this.run(s)
        val (b, next2) = sb.run(next1)
        (f(a, b), next2)
      })
    
    def flatMap[B](f: A => State[S, B]): State[S, B] =
      State(s => {
        val (a, next) = this.run(s)
        f(a).run(next)
      })
  }

  object State {
    def unit[S, A](a: A): State[S, A] = State(s => (a, s))

    def sequence[S, A](ss: List[State[S, A]]): State[S, List[A]] = State(z => {
      ss.foldRight((List.empty[A], z)) {
        case (s, (as, prev)) =>
          val (a, next) = s.run(prev)
          (a :: as, next)
      }
    })
  }

  type Rand[A] = State[RNG, A]
}
