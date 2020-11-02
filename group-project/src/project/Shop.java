package project;
import java.util.Objects;

public class Shop {
	private int buycards;
	private int sellcards;
	private Integer pid;
	  private String name;
	  private Double price;
	
	public Shop( int buycards, int sellcards, Integer pid, String name, Double price) {
		this.buycards = buycards;
		this.sellcards = sellcards;
		this.pid = pid;
        this.name = name;
        this.price = price;
	}
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
	
	public Double getPrice() {
        return price;
    }
	
	public void setPrice(Double price) {
        this.price = price;
    }
	
	 public Integer getPid() {
	        return pid;
	    }
	
	public int getbuycards() {
		return buycards;
	}
	
public int getsellcards() {
	return sellcards;
}

public int hashCode() {
    int hash = 7;
    hash = 29 * hash + Objects.hashCode(this.pid);
    hash = 29 * hash + Objects.hashCode(this.name);
    hash = 29 * hash + Objects.hashCode(this.price);
    return hash;
}
}
