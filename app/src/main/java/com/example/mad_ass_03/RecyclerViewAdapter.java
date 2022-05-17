package com.example.mad_ass_03;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class OptionsViewHolder extends RecyclerView.ViewHolder {

    private AppCompatButton opsTV;

    public OptionsViewHolder(@NonNull View itemView) {
        super(itemView);

        opsTV = itemView.findViewById(R.id.opsTV);

    }

    public AppCompatButton getOpsTV() {
        return opsTV;
    }

    public void setData(String opsText) {
        opsTV.setText(opsText);
    }
}

class OptionsAdapter extends RecyclerView.Adapter<OptionsViewHolder> {
    RecyclerView mRecyclerView;
    TextView scoreTV;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecyclerView = recyclerView;
    }

    Context context;
    private List<OptionsDataModel> optionsList;
    String correctOps;
    int index;

    public OptionsAdapter(Context context, List<OptionsDataModel> optionsList, String correctOps, TextView scoreTV, int index) {
        this.context = context;
        this.optionsList = optionsList;
        this.correctOps = correctOps;
        this.scoreTV = scoreTV;
        this.index = index;
    }

    @NonNull
    @Override
    public OptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new OptionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionsViewHolder holder, int position) {
        // Get the Views from inside the 'item_design' file using the 'position' variable
        String opsText = optionsList.get(position).getOps();

        holder.setData(opsText);
        holder.getOpsTV().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.getOpsTV().getText().toString().equals(correctOps)){
                    holder.getOpsTV().setBackgroundColor(holder.getOpsTV().getContext().getResources().getColor(R.color.green));
                    scoreTV.setText( String.valueOf( Integer.parseInt(scoreTV.getText().toString())+1 ) );

                    Intent i = new Intent(context, PromtQuestionActivity.class).putExtra("index", index+1).putExtra("score", Integer.parseInt(scoreTV.getText().toString()));
                    context.startActivity(i);
                }
                else {
                    holder.getOpsTV().setBackgroundColor(holder.getOpsTV().getContext().getResources().getColor(R.color.red));
                    scoreTV.setText( String.valueOf( Integer.parseInt(scoreTV.getText().toString())-1 ) );
                    Intent i = new Intent(context, PromtQuestionActivity.class).putExtra("index", index+1).putExtra("score", Integer.parseInt(scoreTV.getText().toString()));
                    context.startActivity(i);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return optionsList.size();
    }

}
