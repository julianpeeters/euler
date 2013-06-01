
object euler001 extends App {
/*Finds the sum of all the multiples of 3 or 5 below 1000.
1.  stream a range of numbers 0-1000 
2.  filter the stream to keep only the multiples
3.  sum the elements in the stream
*/

  val result = (0 until 1000).filter(n => n % 3==0 || n % 5==0).sum;  
    println(result)           
}
