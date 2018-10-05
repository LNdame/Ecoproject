package inqb8.ansteph.ecobrick.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import inqb8.ansteph.ecobrick.R;
import inqb8.ansteph.ecobrick.model.Depot;
import inqb8.ansteph.ecobrick.view.depositor.DepotDetail;

/**
 * Created by loicstephan on 2018/07/21.
 */

public class DepotRecyclerAdapter extends RecyclerView.Adapter<DepotRecyclerAdapter.DepotViewHolder>{


    private final Context mContext;

    ArrayList<Depot> mDepots;

    public DepotRecyclerAdapter(Context mContext, ArrayList<Depot> mDepots) {
        this.mContext = mContext;
        this.mDepots = mDepots;
    }

    @Override
    public DepotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(mContext).inflate(R.layout.depot_item, parent, false);

        return  new DepotViewHolder(view);

       // return null;
    }

    @Override
    public void onBindViewHolder(DepotViewHolder holder,final int position) {
        final View itemView = holder.itemView ;

        holder.txtDepot.setText(mDepots.get(position).getName());
        holder.txtAddress.setText(mDepots.get(position).getAddress());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DepotDetail.class);
                i.putExtra("depot",mDepots.get(position));

                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDepots.size();
    }

    public static class DepotViewHolder extends RecyclerView.ViewHolder{


        public final TextView txtDepot;

        public final TextView txtAddress;

        public final ImageView estDetail;




        public DepotViewHolder(View itemView) {
            super(itemView);

            this.txtDepot = (TextView) itemView.findViewById(R.id.txtdepot);

            this.txtAddress = (TextView) itemView.findViewById(R.id.txtaddress);

            this.estDetail = (ImageView) itemView.findViewById(R.id.imgdepSelect);




        }
    }
}
