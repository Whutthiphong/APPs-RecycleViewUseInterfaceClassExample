package th.co.dohome.interfaceclassexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<String> mArrayList;
    ItemListener mItemListener;
    View view;

    public void setListItem(ArrayList<String> arrayList) {
        this.mArrayList = arrayList;
    }

    public MainAdapter() {
    }

    public void setOnItemClickListener(ItemListener itemClickListener) {
        mItemListener = itemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txt1.setText(mArrayList.get(i));
    }

    @Override
    public int getItemCount() {
        if (mArrayList != null)
            return mArrayList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt1;
        public Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt1);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mItemListener.OnItemClickListener(position);
                        }
                    }
                }
            });
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mItemListener.OnItemClickDeleteListener(position);
                        }
                    }
                }
            });
        }
    }
}
