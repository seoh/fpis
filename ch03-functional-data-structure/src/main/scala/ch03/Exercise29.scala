package ch03

object Exercise29 extends App {

  // from https://github.com/fpinscala/fpinscala/blob/master/answerkey/datastructures/29.hint.txt
  // The signature is `def fold[A,B](t: Tree[A])(l: A => B)(b: (B,B) => B): B`. See if you can define this function, then reimplement the functions you've already written for `Tree`.
  def fold[A,B](tree: Tree[A])(f: A => B)(g: (B,B) => B): B = tree match {
    case Leaf(v) => f(v)
    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  
  // test //
  val t = Branch(
    Branch(
      Leaf(1),
      Leaf(2)
    ),
    Branch(
      Leaf(3),
      Leaf(5)
    )
  )

  def size[A](tree: Tree[A]): Int = fold(tree)(_ => 1)(_ + _)
  println(size(t) == 4)

  def maximum(tree: Tree[Int]): Int = fold(tree)(i => i)(_ max _)
  println(maximum(t) == 5)

  def depth[A](tree: Tree[A]): Int = fold(tree)(_ => 1)((a, b) => 1 + (a max b))
  println(depth(t) == 3)
}
