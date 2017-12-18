package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lue.waterroofingmeasurement.R;

import java.util.ArrayList;
import java.util.List;

import SetterGetter.ItemRecyclerObject;

/**
 * Created by lue on 12-09-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private ArrayList<ItemRecyclerObject> customerList ;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);

            name=(TextView)view.findViewById(R.id.txtcustomerdetails);
          //  image=(ImageView)view.findViewById(R.id.imageView);
        }
    }


    public RecycleAdapter(ArrayList<ItemRecyclerObject> customerList) {
        this.customerList = customerList;

    }

    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardlist, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecycleAdapter.MyViewHolder holder, int position) {
        holder.name.setText((CharSequence) customerList.get(position));


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
