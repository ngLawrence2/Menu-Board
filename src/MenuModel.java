class MenuModel {
    // Add your implementation for Menu Items here.
    // Determine what data you want to store for each item.
	double price;
	String item;
	public MenuModel(String x, double p) {
		item=x;
		price=p;
	}
	public String toString() {
		return item;
	}
	public double returnPrice() {
		return price;
	}
}