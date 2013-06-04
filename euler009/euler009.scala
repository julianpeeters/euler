import scala.math._
object euler009 extends App {
/*
*There exists exactly one Pythagorean triplet for which a + b + c = 1000.
*Find the product abc.
*/
  val specialSum = 1000
  val naturals = (1 to specialSum).toStream

  val pythagoreanTriplets = for (a <- naturals;
                                 b <- (a to naturals.max);
                                 c <- (b to naturals.max);
                                 val p = a*b*c if(a+b+c == specialSum && (a*a + b*b) == c*c)
                                 ) yield p

  println(pythagoreanTriplets.max)                 
    
}
