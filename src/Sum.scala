class Sum(val augend: Money, val addend: Money) extends Expression {
   def reduceTo(toCurrency: String): Money = {
	  new Money(addend.amount + augend.amount, toCurrency)
  }
  
}