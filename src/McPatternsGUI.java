import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	
	public McPatternsGUI(McPatternsPresenter presenter) {
		
		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();

	}
	private void showGUI() {
		presenter.loadMenuItems();

		JFrame theFrame = new JFrame("Swing Example");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
		JPanel title = new JPanel(new FlowLayout());
		title.add(new JLabel("Welcome to McPatterns"));

		JPanel orderPane = new JPanel();
		orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
		JLabel orderDetails = new JLabel("Your order");
		orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
		orderPane.add(orderDetails);
		JTextField ccEntry = new JTextField("Enter CC #");

		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Add the function to handle confirmed order
				//Think about where you will store order and who should manipulate.
				//Handle the Payment validation before confirming order. Who should validate?
				
				CreditCardFactory cardFactory=new CreditCardFactory();
				CreditCard creditCard=cardFactory.getCard(ccEntry.getText());
				
				
				if(creditCard!=null) {
				double totalPrice=0;
				for(int i = 0 ;i< presenter.getOrder().size();i++) {
					double individualPrice=presenter.getOrder().get(i).returnPrice();
					totalPrice+=individualPrice;
				}
				DecimalFormat numberFormat=new DecimalFormat("#.00");
				System.out.println(creditCard.cardType() + " " + creditCard.getCardNumber()+ ":" +presenter.getOrder() + "Total: $" + numberFormat.format(totalPrice));
				
				presenter.clearOrder();
				orderDetails.setText("Order confrimed for " + ccEntry.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Card");
				}
			}

		});
		JButton cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Add the function to handle cancel order
				//Think about where you will store order and who should manipulate.
				presenter.clearOrder();
				orderDetails.setText("Order cancelled");
			}

		});

		
		orderPane.add(ccEntry);
		orderPane.add(confirm);
		orderPane.add(cancel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		// TODO: Ask the presenter for the buttons to create. Iterate over the buttons and create them
		for(int i = 0 ; i<presenter.getMenuItems();i++) {
		 ArrayList<MenuModel> myMenuItems=presenter.returnItems();
		 MenuModel myProduct=myMenuItems.get(i);
		 double myPrice=myProduct.returnPrice();
		 JButton menuButton= new JButton(myProduct + " $"+ myPrice);
		 buttonPanel.add(menuButton);
		 menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					 presenter.addToOrder(myProduct);
			}
		 
		 });
		}
		
		
		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.CENTER);
		theFrame.add(orderPane, BorderLayout.EAST);
		theFrame.setSize(800,600);
		

		
		theFrame.pack();
		theFrame.setVisible(true);
		
	}
}
