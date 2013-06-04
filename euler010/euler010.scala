import scala.math._
object euler010 extends App {
/*
*Find the sum of all the primes below two million.
*/
  val max = 2000000
 
  val primes: Stream[Long] = 2L #:: sieve(3)

  def sieve(n: Int) : Stream[Long] = {
          if (primes.takeWhile(p => p*p <= n).exists(n % _ == 0)) sieve(n + 2)
          else n #:: sieve(n + 2)
  }
  val sumOfPrimes = primes.takeWhile(_ <= max).sum
    println(sumOfPrimes) 
}
