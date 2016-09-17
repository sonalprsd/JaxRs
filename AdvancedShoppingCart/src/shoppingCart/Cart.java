package shoppingCart;


import java.util.HashMap;
import java.util.Vector;

public class Cart {
   /* HashMap<String, Integer> cartItems;
    public Cart(){
     cartItems = new HashMap<>();
      
    }*/

	Vector<Cart> allItems=new Vector<Cart>();
    int id;
	

	Integer price;
	String itemId;
	Integer quantity;
	Integer totalPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getItemId() {
		return this.itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Vector<Cart> getCartItems(){
        return allItems;
    }
    public void addToCart(String itemId, int price, int quantity, int totalprice){
    	Cart cartItems=new Cart();
    	
        cartItems.itemId = itemId;
        cartItems.quantity = quantity;
        cartItems.price = price;
        cartItems.totalPrice = totalprice;
        allItems.add(cartItems);
    }
    
    public void editCart(String itemId, int price, int quantity, int totalprice,int index){
    	Cart cartItems=new Cart();
    	
        cartItems.itemId = itemId;
        cartItems.quantity = quantity;
        cartItems.price = price;
        cartItems.totalPrice = totalprice;
        allItems.set(index,cartItems);
    }
     
}
