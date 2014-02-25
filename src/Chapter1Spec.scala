import org.scalatest.Matchers
import org.scalatest.FlatSpec

class Chapter1Spec extends FlatSpec with Matchers {
  
	"Mutiply functionality" should "mutiply correctly without sideeffects" in {
	  val fiveDollar = Money.dollar(5)
	  val tenDollar = fiveDollar.times(2)
	  tenDollar.equals(Money.dollar(10)) shouldBe(true)
	  fiveDollar.amount shouldBe(5)
	}
	
	"Currency" should "have correct equals logic" in {
	  val fiveDollar = Money.dollar(5)
	  val anotherFiveDollar = Money.dollar(5)
	  val sevenFranc = Money.franc(7)
	  fiveDollar.equals(anotherFiveDollar) shouldBe(true)
	  fiveDollar.equals(sevenFranc) shouldBe(false)
	  Money.franc(7).equals(sevenFranc) shouldBe(true)
	  Money.franc(5).equals(fiveDollar) shouldBe(false)
	}
	
	"Currency Impl" should "return correct currency name" in {
	  val dollar = Money.dollar(3)
	  val franc = Money.franc(3)
	  dollar.currency.equals("Dollar") shouldBe(true)
	  dollar.currency.equals("Franc") shouldBe(false)
	  franc.currency.equals("Franc") shouldBe(true)
	}
	
//	"Addition of Currency" should "return correct sum" in {
//		val threeDollar = Money.dollar(3)
//		val twelveDollar = Money.dollar(12)
//		threeDollar.plus(twelveDollar).equals(Money.dollar(15)) shouldBe(true)
//		
//		// bank to apply exchange rates to reduce an expression of "dollars and francs" into common currency let say dollar
//		val sumExpression = threeDollar.plus(twelveDollar)
//		val reduced: Money = new Bank().reduce(sumExpression, "USD")
//		reduced.equals(Money.dollar(15)) shouldBe(true)
//		
//		
//	}
	
	"plus method" should "return correct expression" in {
	  val threeDollar = Money.dollar(3)
	  val sevenDollar = Money.dollar(7)
	  val sumExpression = threeDollar.plus(sevenDollar).asInstanceOf[Sum]
	  sumExpression.augend.amount.equals(3) shouldBe(true)
	  sumExpression.addend.amount.equals(7) shouldBe(true)
	}
	  
	"reduce Money" should "work correctly" in {
	  val threeDollar = Money.dollar(3)
	  new Bank().reduce(threeDollar, "Dollar").equals(Money.dollar(3)) shouldBe(true)
	}
	
	"reduce Money to diff. currency" should "work correctly" in {
	  val tenFranc = Money.franc(10)
      val bank = new Bank()
	  bank.addRate("Franc", "Dollar", 2)
	  bank.reduce(tenFranc, "Dollar").equals(Money.dollar(5)) shouldBe(true)

	}
}
