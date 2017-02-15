package co.gerges.coffiecounter;

/**
 * Created by gerges on 06/02/2017.
 */

public class ListItem {

    /**
     * java representaion of our data to be displayed in recyclerView
     * Created by gerges on 06/02/2017.
     */
        private String date ;
        private  String quantity;
         private String totalPrice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }


}
