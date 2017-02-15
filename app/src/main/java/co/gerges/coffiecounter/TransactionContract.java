package co.gerges.coffiecounter;

import android.provider.BaseColumns;

/**
 * Created by gerges on 30/01/2017.
 * here we create the schema of DB layout ...
 */

public final  class TransactionContract {
     // we make the contractor private
    private TransactionContract(){}

    //class that define table contents
    //implementing baseColumns adds auto generated Column ID
    public static class transaction implements BaseColumns {
        public static final String TABLE_NAME = "transactions";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
        public static final String COLUMN_NAME_TOTAL_PRICE = "totalPrice";
        public static final String COLUMN_NAME_DATE = "date";



    }
}
