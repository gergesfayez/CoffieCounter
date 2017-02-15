package co.gerges.coffiecounter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gerges on 30/01/2017.
 */

public class TransactionDbHelper extends SQLiteOpenHelper  {

    // sql query STRING statement creates a table based on predefined DB Schema on class Transaction Contract
    public static final String SQL_CREATE_ENTRIES =
            //for example "CREATE TABLE TABLE_NAME (ID , COLUMN_NAME1, COLUMN_NAME2, COLUMN_NAME3)"
            "CREATE TABLE " + TransactionContract.transaction.TABLE_NAME + " (" +
                    TransactionContract.transaction._ID + " INTEGER PRIMARY KEY," +
                    TransactionContract.transaction.COLUMN_NAME_QUANTITY + " INTEGER," +
                    TransactionContract.transaction.COLUMN_NAME_TOTAL_PRICE + " INTEGER,"+
                    TransactionContract.transaction.COLUMN_NAME_DATE + " TEXT )";

    private static final String SQL_DELETE_ENTRIES =
            //SQL String STATMENT for DELETING ENTERIES
            "DROP TABLE IF EXISTS " + TransactionContract.transaction.TABLE_NAME;
         //SQL DATABASE VERSION should be incremented when it's changed to be used to check updates ...
     public static  final int DATABASE_VERSION= 1;
    //Sql database FILE NAME "final String"
    public static final String DATABASE_NAME = "transactionHistoryDatabase.db";


     // extend openHelper constractor to run on create new object from DBhelper the database file ...
    public TransactionDbHelper(Context context){

      super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // enter SQL query  execute sql query string that's creat table and its columns "SQL_CREATE_ENTRIES"
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
