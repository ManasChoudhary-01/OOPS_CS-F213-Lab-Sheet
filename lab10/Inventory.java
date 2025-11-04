package lab10;
import java.util.logging.Logger;

public class Inventory {
	private static final Logger logger = Logger.getLogger(Inventory.class.getName());
	private int stock;

	public Inventory(int initialStock) {
		this.stock = initialStock;
	}
	
	public void addStock(int quantity) {
		assert quantity > 0 : "Enter a positive number";
		try {
			if(quantity > 0) {
				stock += quantity;
				logger.info("New stock has been added and now current stock is " + stock);
			} else {
				throw new Exception("Invalid quantity");
			}
		} catch(Exception e) {
			logger.severe("Error occured" + e.getMessage());
		}
	}

	public void removeStock(int quantity) {
		assert quantity > 0 && quantity <= stock : "Enter a positive number";
		try {
			if(quantity > 0 && quantity <= stock) {
				stock -= quantity;
				logger.info("Stock has been removed and now current stock is " + stock);
			} else {
				throw new Exception("Invalid quantity");
			}
		} catch(Exception e) {
			logger.severe("Error occured" + e.getMessage());
		}
	}

	public int getStock() {
		return stock;
	}
	
	public static void main(String arg[]) {
		
		Inventory pen = new Inventory(20);
		pen.addStock(-10);
		pen.removeStock(5);
	}
}
