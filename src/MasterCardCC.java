public class MasterCardCC implements CreditCard {
	String cardNum;
	String cardType;
	public MasterCardCC(String cardNumber) {
		cardNum=cardNumber;
		cardType="MasterCard";
	}
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
		if(cardNum.length()==16) {
			int firstDigit=Integer.parseInt(cardNum.charAt(0)+"");
			if(firstDigit==5) {
				int secondDigit=Integer.parseInt(cardNum.charAt(1)+"");
				if(secondDigit>=1 || secondDigit <=5) {
					return true;
				}
			}
		}
		return false;
	}
	
}