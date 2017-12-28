package ch06

object Exercise11 extends App {

  sealed trait Input
  case object Coin extends Input
  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  /**
    Rules

    1. locked and input coins then get unlocked
    2. unlocked and turn machine then put candy and get locked
    3. turn locked machine or input coins to unlocked machine then do nothing
    4. empty machine ignores all inputs

    (true, 5, 10) =coin=> (false, 5, 11) =turn=> (true, 4, 11)
  */

  import Exercise10.State

  def move(input: Input): State[Machine, (Int, Int)] = State { m =>
    val next = input match {
      case Coin if m.locked => m.copy(locked = false)
      case Turn if !m.locked && m.candies > 0 => 
        m.copy(
          locked = true,
          candies = m.candies - 1,
          coins = m.coins + 1
        )
      case _ => m
    }
    ((next.coins, next.candies), next)
  }

  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] =
    State { machine =>
      inputs.foldLeft(((0, 0), machine))((acc, i) => {
        val (_, m) = acc
        move(i).run(m)
      })
    }

  // test //
  val machine = Machine(true, 5, 10)
  val sim = simulateMachine(List(Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn))
  println(sim.run(machine)._1)
}
