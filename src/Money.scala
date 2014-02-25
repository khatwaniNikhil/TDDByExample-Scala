class Money(val amount: Int, val currency: String) extends Expression {
  override def equals(o: Any) = {
    val isMoney = o.isInstanceOf[Money]
    if(isMoney)  {
      val money: Money = o.asInstanceOf[Money]
	  amount == money.amount && currency.equals(money.currency)
    }
	else false
  }
  
  def times(anothAmount: Int): Money = new Money(amount * anothAmount, currency)
  
  def plus(m1: Money): Expression = {
    new Sum(this, m1)    
  }
  
  def reduceTo(toCurrency: String): Money = {
    val rate = (currency, toCurrency) match {
      case ("Franc","Dollar") => 2
      case _ => 1 
    }
    new Money(amount/rate, toCurrency)
  }
}

// Factory for creating Dollars/Francs
object Money {
  
  def dollar(amt: Int) = new Money(amt, "Dollar")
  def franc(amt: Int) = new Money(amt, "Franc")
  
  
}