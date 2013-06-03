import scala.math._
object euler005 extends App {
/*
/*Concise, 38sec from 1-20:
*Starting at 1, use each natural number as a test number 
*go through the list of factors, test whether the test number is divided by each factor
*the LCM is the first test number that can be divided by all the factors.
*Note that find might find `None`, or Some(naturalNumber), so we unbox it with `.get`
*/

val naturals = Iterator.from(1)
def factors = (1 to 20)

val LCM = naturals.find(n => factors.forall(f => n%f == 0)).get
  println(LCM)

*/
//=====================================================================================================================
/*Faster, 0 sec from 1-20
*This method works by looking only at the factors, and realizing that the smallest multiple will be 
*the product of primes factors of each factor, with multiples accounted for.
*/
val factors = (1 to 20)
def primes = Iterator[Int](2,3,5,7,11,13,17,19,21,23,29)//OK to replace this with an infinite iterator

val factorsTable = for (f <- factors; //nested loop taking all needed primes against all factors
                        p <- primes.takeWhile(p => p <= factors.length); //take as many primes as we need
                        val result = (f, p, f/p)
                        ) yield result //returns an Iterator of tuples: Iterator((factor,prime,quotient), ...)

val LCM = factorsTable.filter(n => n._1%n._2 == 0)//if a factor isn't evenly divided by a prime, throw out the element
                      .filter(n => n._3 == 1 || n._3%n._2 == 0)//keep the elements w/ prime factors and their multiples
                      .groupBy(n => n._2)//group by their prime factor like (3, Stream((3,3,1),(9,3,3))
                      .map(n => pow(n._1, n._2.length))// the first element is the prime factor, hits is its exponent
                      .product//mulitplies all elements with each other, e.g. 16*9*5*7 = 2520
                      .toLong//format the number to remove the decimal that `pow` gave it.

println(LCM)


}
