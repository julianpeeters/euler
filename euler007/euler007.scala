import scala.math._
object euler003 extends App {
/*
*What is the 10,001st prime number?
*/
  val nth = 10001
 
  val primes: Stream[Long] = 2L #:: sieve(3)

  def sieve(n: Int) : Stream[Long] = {
          if (primes.takeWhile(p => p*p <= n).exists(n % _ == 0)) sieve(n + 2)
          else n #:: sieve(n + 2)
  }

  println(primes(nth-1))

}
