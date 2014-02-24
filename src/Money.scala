class Money(val amount: Int, val currency: String) {
  override def equals(o: Any) = {
    val isMoney = o.isInstanceOf[Money]
    if(isMoney)  {
      val money: Money = o.asInstanceOf[Money]
	  amount == o.asInstanceOf[Money].amount && money.currency.equals(currency)
    }
	else false
  } 
  
  def times(anothAmount: Int): Money = new Money(amount * anothAmount, currency)
}

object Money {
  def dollar(amt: Int) = new Money(amt, "Dollar")
  def franc(amt: Int) = new Money(amt, "Franc")
}