package co.gerges.coffiecounter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
public class OrderDetails extends AppCompatActivity {

    public void showToast(String msg){
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        int priceValue = getIntent().getIntExtra("price",0);
        int quantityValue = getIntent().getIntExtra("quantity",0);

        TextView vPrice = (TextView) findViewById(R.id.totalPrice);
        vPrice.setText(Integer.toString(priceValue));
        TextView vQuantity = (TextView) findViewById(R.id.totalQuantity);
        vQuantity.setText(Integer.toString(quantityValue));




    }




    public void saveTransaction(View view){

         // Creating new object from
        TransactionDbHelper transatctionTable = new TransactionDbHelper(this);
         // make the database writable to save into
        SQLiteDatabase db = transatctionTable.getWritableDatabase();

     // get system Date now
        Calendar c = Calendar.getInstance();
        String now = String.valueOf(c.getTime());

        int priceValue = getIntent().getIntExtra("price",0);
        int quantityValue = getIntent().getIntExtra("quantity",0);

        ContentValues values =  new ContentValues();
        values.put(TransactionContract.transaction.COLUMN_NAME_TOTAL_PRICE, priceValue );
        values.put(TransactionContract.transaction.COLUMN_NAME_QUANTITY, quantityValue);
        values.put(TransactionContract.transaction.COLUMN_NAME_DATE, now);
        //  saving in DB
        long newRowId = db.insert(TransactionContract.transaction.TABLE_NAME, null, values);
        showToast("Saved" + now + quantityValue + priceValue + " index: " + newRowId);


    }



}
