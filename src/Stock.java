import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stock implements Serializable{

	
	private static final long serialVersionUID = 1L;
	String Name;
	static Integer ID = 1;
	Double Price;
	String dateImported ;
	Integer qty;
	
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public String getDateImported() {
		return dateImported;
	}
	public void setDateImported(String dateImported) {
		this.dateImported = dateImported;
	}
	public Stock(){
		
	}
	public Stock(Integer ID, String Name, Double Price, Integer qty, String dateImported){
		this.Name = Name;
		Stock.ID = ID;
		this.Price = Price;
		this.dateImported = dateImported;
		this.qty = qty;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		Stock.ID = ID;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}
	

}
