package co.gerges.coffiecounter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gerges on 06/02/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ReportHolder> {

    private List<Transaction> listData;

    private LayoutInflater inflater;


    public Adapter(List<Transaction>listData, Context c){
        this.inflater= LayoutInflater.from(c);
        this.listData= listData;

    }
    @Override
    public ReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ReportHolder(view);
    }

    @Override
    public void onBindViewHolder(ReportHolder holder, int position) {
        holder.date.setText(listData.get(position).getDate());
        holder.quantity.setText(Integer.toString(listData.get(position).getQuantity()));
        holder.totalPrice.setText(Integer.toString(listData.get(position).getTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    class ReportHolder extends RecyclerView.ViewHolder{


        private TextView date;
        private TextView quantity;
        private TextView  totalPrice;
        private View container;


        public ReportHolder(View itemView){
            super(itemView);
            date = (TextView)itemView.findViewById(R.id.lbl_date);
            quantity = (TextView) itemView.findViewById(R.id.lbl_quantity);
            totalPrice = (TextView) itemView.findViewById(R.id.lbl_totalPrice);
            container= itemView.findViewById(R.id.cont_item_root);
        }

    }

}
