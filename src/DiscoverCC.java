public class DiscoverCC implements CreditCard {
	String cardNum;
	String cardType;
	public DiscoverCC(String cardNumber) {
		cardNum=cardNumber;
		cardType="Discover";
	}
	
	@Override
	public String getCardNumber() {
		return cardNum;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String cardType() {
		// TODO Auto-generated method stub
		return cardType;
	}
	
	public boolean isCard() {
		if(cardNum.length()==16) {
		String firstFourDigits=cardNum.substring(0,4);
			if("6011".equals(firstFourDigits)) {
				return true;
			}
		} 
		return false;
	}
	
}