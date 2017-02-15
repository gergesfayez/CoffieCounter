package co.gerges.coffiecounter;

/**
 * Created by gerges on 30/01/2017.
 */

public class Transaction {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalprice) {
        this.totalPrice = totalprice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    long id ;
     int quantity, totalPrice;
    String date;


}
