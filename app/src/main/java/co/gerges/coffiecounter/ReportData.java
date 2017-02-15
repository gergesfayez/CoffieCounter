package co.gerges.coffiecounter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerges on 08/02/2017.
 */

public class ReportData {

    public  static List<ListItem> getListData(int itemsSize, int singleItemSize ){
        List<ListItem> data = new ArrayList<>();
        // first loop according to items length
        for(int x= 0; x< itemsSize; x++){

            //2ndLoop to set data  per single item

            for(int i=0; i< singleItemSize; i++) {
                //create an object of list item to store data
                ListItem item = new ListItem();
                item.setDate("text");
                item.setQuantity("text");
                item.setTotalPrice("text");

                data.add(item);


            }

        }

        return data;

    }
}
