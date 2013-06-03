import scala.math._
object euler003 extends App {
/*What is the largest prime factor of the number 600851475143 ?
*Make seive to get a Stream of prime numbers.
*Filter the list of primes to keep only the primes that are factors.
*Form the list of prime factors, choose the largest.
*Takes 1 sec to run.
*/
  val theNumber = 600851475143L

  val primes: Stream[Long] = 2L #:: sieve(3)

  def sieve(n: Int) : Stream[Long] = {
          if (primes.takeWhile(p => p*p <= n).exists(n % _ == 0)) sieve(n + 2)
          else n #:: sieve(n + 2)
  }

  def primeFactors(n: Long): Stream[Long] = {
    primes.takeWhile(_ <= sqrt(theNumber)).filter(n%_ == 0)
  }

  val largestPrimeFactor = primeFactors(theNumber).max
    println(largestPrimeFactor)

}
