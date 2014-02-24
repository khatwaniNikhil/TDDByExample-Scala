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
}
