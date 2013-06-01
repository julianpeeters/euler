
object euler005 extends App {

  val factorMax = 4
  val factors = Stream.range(2, factorMax+1)      // Use a Stream object to create a stream of natural numbers
               
  val composites = factors.map(n => Stream.range(n, Integer.MAX_VALUE, n))//a stream of streams

  val LCM = composites.toStream.last.filter(factor => composites.forall(n => n.contains(factor)==true)).toList//.min

//  val LCM = composites.toStream.last.filter(factor => composites.forall(n => n.contains(factor)==true)).toList.min
   // println(LCM)
}
