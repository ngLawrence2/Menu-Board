import java.io.*;
import java.net.URL;
import java.util.*;
class McPatternsPresenter {
    //This is the class that will handle the model <-> UI communication.
    MenuModel model;
    McPatternsGUI view;
    ArrayList<MenuModel> menuItems;
    int numItems;
    ArrayList<MenuModel> orders= new ArrayList<MenuModel>();
    File myMenu;
    public McPatternsPresenter(File menu) {
    	myMenu=menu;
    }
    
    void loadMenuItems()  {
        // TODO: Add code to read a file and load the menu items.
    	menuItems= new ArrayList<MenuModel>();
    	try {
    		Scanner readMenu= new Scanner(myMenu);
    		numItems=0;
    		for(numItems=0; readMenu.hasNextLine();numItems++) {
 
    			String productAndPrice=readMenu.nextLine();
    			String product=productAndPrice.substring(0, productAndPrice.indexOf('|'));
    			String price= productAndPrice.substring(productAndPrice.indexOf('|')+1);
    			model= new MenuModel(product, Double.parseDouble(price));
    			menuItems.add(model);
    		 
    		}
    	} catch( Exception e) {
    		System.out.println("no file found");
    		
    	}
    } 
    int getMenuItems() {
    	return numItems;
    }

    void attachView(McPatternsGUI view) {
        this.view = view;
    }
    // Add functions to return the menu items. 
    public ArrayList<MenuModel> returnItems() {
    	return menuItems;
    }
    public void addToOrder(MenuModel a) {
    	orders.add(a);    	
    }
    public void clearOrder() {
    	orders=new ArrayList<MenuModel>();
    }
    public ArrayList<MenuModel> getOrder() {
    	return orders;
    }
    
}