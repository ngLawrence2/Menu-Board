public class CreditCardFactory {
	public CreditCard getCard(String cardNumber) {
		if(new VisaCC(cardNumber).isCard()) {
			return new VisaCC(cardNumber);
		} else if(new AmericanExpressCC(cardNumber).isCard()) {
			return new AmericanExpressCC(cardNumber);
		} else if(new MasterCardCC(cardNumber).isCard()) {
			return new MasterCardCC(cardNumber);
		}else if(new DiscoverCC(cardNumber).isCard()) {
			return new DiscoverCC(cardNumber);
		}
		return null;
	}
}