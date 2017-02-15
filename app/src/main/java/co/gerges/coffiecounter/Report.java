package co.gerges.coffiecounter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Report extends  AppCompatActivity {
     private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        readDb();
    }

    public void readDb(){
        TransactionDbHelper transatctionTable = new TransactionDbHelper(this);

        SQLiteDatabase db = transatctionTable.getReadableDatabase();

        String[] projection = {
                TransactionContract.transaction._ID,
                TransactionContract.transaction.COLUMN_NAME_QUANTITY,
                TransactionContract.transaction.COLUMN_NAME_TOTAL_PRICE,
                TransactionContract.transaction.COLUMN_NAME_DATE
        };

        Cursor cursor = db.query(
                TransactionContract.transaction.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );





        // loop unless we still have something in the DB ... (cursor.moveToNext)
        cursor.moveToFirst();



            ArrayList<Transaction> transactions= new ArrayList<>();

            do {
                Transaction transaction = new Transaction();

                transaction.setId(cursor.getLong(cursor.getColumnIndexOrThrow(TransactionContract.transaction._ID)));
                transaction.setQuantity(cursor.getInt(cursor.getColumnIndexOrThrow(TransactionContract.transaction.COLUMN_NAME_QUANTITY)));
                transaction.setTotalPrice(cursor.getInt(cursor.getColumnIndexOrThrow(TransactionContract.transaction.COLUMN_NAME_TOTAL_PRICE)));
                transaction.setDate(cursor.getString(cursor.getColumnIndexOrThrow(TransactionContract.transaction.COLUMN_NAME_DATE)));

                transactions.add(transaction);

            } while (cursor.moveToNext());

            cursor.close();



        // recyclerView element declare
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



         adapter  = new Adapter(transactions,this);

        recyclerView.setAdapter(adapter);





    }





}
