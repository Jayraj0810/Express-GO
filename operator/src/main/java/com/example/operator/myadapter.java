package com.example.operator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{
    Context context;
    ArrayList<dataholder> fetchdata;

    public myadapter(Context context, ArrayList<dataholder> fetchdata) {
        this.context = context;
        this.fetchdata = fetchdata;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        dataholder data = fetchdata.get(position);
        holder.jobno.setText(data.getJobno());
        holder.cname.setText(data.getCname());
        holder.mobileno.setText(data.getMobileno());

//        myviewholder .itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), Show_Jobcard.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("key", (Serializable) datah);
//                intent.putExtras(bundle);
//                v.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return fetchdata.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView jobno, cname, mobileno;
        View view;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            jobno = itemView.findViewById(R.id.jobcardnno);
            cname = itemView.findViewById(R.id.jobcname);
            mobileno = itemView.findViewById(R.id.jobmobileno);

            view=itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int postion = getAbsoluteAdapterPosition();
            Toast.makeText(itemView.getContext(), "postion"+postion, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(itemView.getContext(), show_jobcard.class);
            itemView.getContext().startActivity(intent);
        }
    }
}
