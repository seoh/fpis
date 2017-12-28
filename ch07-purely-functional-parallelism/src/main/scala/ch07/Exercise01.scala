package ch07

object Exercise01 {

  class Par[A] {
    def unit[A](a: => A): Par[A] = ???
    def get[A](a: Par[A]): A = ???
  }

  object Par {
    def map2[A, B, C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] = ???
  }
}