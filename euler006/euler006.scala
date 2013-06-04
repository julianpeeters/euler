import scala.math._
object euler003 extends App {
/*
*Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

  val numbers = (1 to 100).toStream

  def sumOfSquares(s : Stream[Int]): Int = s.map(n=> pow(n, 2).toInt ).sum
  def squareOfSum(s: Stream[Int]): Int = pow(s.sum, 2).toInt

  val difference = squareOfSum(numbers) - sumOfSquares(numbers) 

  println(difference)
}
