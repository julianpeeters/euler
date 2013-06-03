object euler005 extends App {

val naturals = Iterator.from(1)
def factors = Iterator.from(1).take(20)

/*
*Starting at 1, use each natural number as a test number 
*go through the list of factors, test whether the test number is divided by each factor
*the LCM is the first test number that can be divided by all the factors.
*Note that find might find `None`, or Some(naturalNumber), so we unbox it with `.get`
*/
val LCM = naturals.find(n => factors.forall(f => n%f == 0)).get
  println(LCM)

}
