import scala.collection.mutable.Map

class Bank(rates: Map[Tuple2[String, String], Int] = Map.empty) {
  
	def reduce(expression: Expression, currency: String): Money = expression.reduceTo(currency)
	
	def addRate(fromCurr: String, toCurr: String, converFactor: Int) = rates.put((fromCurr, toCurr), converFactor)
}