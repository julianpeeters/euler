object euler005 extends App {

val naturals = Iterator.from(1)
def factors = Iterator.from(1).take(20)

val LCM = naturals.find(n => factors.forall(f => n%f == 0)).get
  println(LCM)

}
