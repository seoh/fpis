package ch03

object Exercise27 extends App {

  def depth[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }
  
  // test //
  println(depth(
    Branch(
      Leaf(1),
      Branch(
        Leaf(2),
        Leaf(3)
      )
    )
  ))
  println(depth(
    Leaf(3)
  ))
}
