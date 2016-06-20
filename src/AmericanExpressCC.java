public class AmericanExpressCC implements CreditCard {
	String cardNum;
	String cardType;
	
	public AmericanExpressCC(String cardNumber) {
		cardNum=cardNumber;
		cardType="AmericanExpress";
	}
	
	@Override
	public String getCardNumber() {
		// TODO Auto-generated method stub
		return cardNum;
		
	}

	@Override
	public String cardType() {
		return cardType;
	}
	public boolean isCard() {
		if(cardNum.length()==15) {
			int firstNum=Integer.parseInt(cardNum.charAt(0)+"");
			if(firstNum==3) {
				int secondNum=Integer.parseInt(cardNum.charAt(1)+"");
				if(secondNum==4 || secondNum==7) {
					return true;
				}
			}
		}
		return false;
	}
}