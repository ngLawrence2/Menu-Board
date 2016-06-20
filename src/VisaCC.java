public class VisaCC implements CreditCard {
	String cardNum;
	String cardType;
	public VisaCC(String cardNumber) {
		cardNum=cardNumber;
		cardType="Visa";
	}
	@Override
	public String getCardNumber() {
		// TODO Auto-generated method stub
		return cardNum;
	}

	@Override
	public String cardType() {
		// TODO Auto-generated method stub
		return cardType;
	}
	public boolean isCard() {
		int length= cardNum.length();
		if(length==13 || length==16) {
			int firstDigit=Integer.parseInt(cardNum.charAt(0)+"");
			if(firstDigit==4) {
				return true;
			}
		}
		return false;
	}
	
}