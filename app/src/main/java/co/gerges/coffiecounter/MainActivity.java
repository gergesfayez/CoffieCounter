package co.gerges.coffiecounter;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.provider.BaseColumns;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int pricePerUnit = 0;
    int totalPrice = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button  btn = (Button) findViewById(R.id.btn);
        btn.animate().alpha(0.7f).setDuration(600);





    }




    public void incrementValue(View view){
        quantity++;
        dispalyQuantity(quantity);
        updatePrice();
        displayPrice(quantity*pricePerUnit);
    }

    public void deceremntValue(View view){
        if(quantity>0){
            quantity--;
            dispalyQuantity(quantity);
            updatePrice();
            displayPrice(quantity*pricePerUnit);
        }
    }

    private void dispalyQuantity(int quantity){
        TextView text = (TextView) findViewById(R.id.quantity_text_view);
        text.setText(Integer.toString(quantity));

    }

    private void displayPrice(int price){
        TextView textView = (TextView) findViewById(R.id.price_per_unit);
        textView.setText(Integer.toString(price));
        totalPrice= price;

    }
    public void showToast(String msg){
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void updatePrice(){
        EditText editText = (EditText) findViewById(R.id.price_edit_text);
        if(!editText.getText().equals("")){
            String stringPrice = editText.getText().toString();
            try {
                pricePerUnit = Integer.parseInt(stringPrice);


            }catch (NumberFormatException e){
                showToast("Try Again ! Enter A Valid Number , Price Per Unit");


            }

        }
    }

    public void navigate(View view){
        // intent to navigate (where iam get Application Context , to  Target Activity Class)

        Intent intent = new Intent(this,OrderDetails.class);
        intent.putExtra("price", totalPrice);
        intent.putExtra("quantity", quantity);

        startActivity(intent);


    }

    public void showReport(View view){
        // intent to navigate (where iam get Application Context , to  Target Activity Class)


        Intent intent2 = new Intent(this ,Report.class);

        startActivity(intent2);


    }

}
