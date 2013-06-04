import scala.math._
object euler003 extends App {
/*
*Find the largest palindrome made from the product of two 3-digit numbers.
*Make a Stream of all X-digit numbers, then for-loop through them to get all the products of X-digit numbers
*Filter the list of products for palindromes, return the largest.
*/
  val digits = 3
  val xDigitNumbers = (pow(10,digits-1).toInt until pow(10, digits).toInt)
  val productsOfxDigitNumers = for (a <- xDigitNumbers;
                                    b <- (a to xDigitNumbers.max); 
                                    val p = a*b) yield p
  
  def isPalindrome(n: Int): Boolean = {
    val number = n.toString.toList
      number == number.reverse
  }                                   

  val largestPalindrome = productsOfxDigitNumers.filter(n => isPalindrome(n) == true).max
    println(largestPalindrome)

}
