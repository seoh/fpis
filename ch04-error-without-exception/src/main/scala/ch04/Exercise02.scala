package ch04

object Exercise02 extends App {
  // `mean` is given.
  def mean(xs: Seq[Double]): Option[Double] =
    if(xs.isEmpty) None
    else Some(xs.sum / xs.length)

  def variance(xs: Seq[Double]): Option[Double] =
    mean(xs) flatMap (m => mean(xs.map(x => math.pow(x -m, 2))))

  // def variance(xs: Seq[Double]): Option[Double] =
  //   if(xs.isEmpty) None
  //   else {
  //     val m = xs.sum / xs.length
  //     Some(xs.map(x => math.pow(x - m, 2)).sum / xs.length)
  //   }

  
  // test //
  println(
    variance(List(.1, .2, .3, .4))
  )
}
