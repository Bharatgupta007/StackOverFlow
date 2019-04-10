package bharat.com.stackoverflow;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robertlevonyan.views.chip.Chip;

import java.util.List;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.MyViewHolder> {



    private List<String> chiplist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Chip chip;

        public MyViewHolder(View view) {
            super(view);
            chip = view.findViewById(R.id.chip);
        }
    }


    public ChipAdapter(List<String> moviesList) {
        this.chiplist = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chips, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String chip = chiplist.get(position);
        holder.chip.setChipText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return chiplist.size();
    }
}