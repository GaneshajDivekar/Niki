package ni.ki.ui.mainmodule.fragment.histroyFragmentModule.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ni.ki.R;
import ni.ki.ui.mainmodule.Coordinates;

public class HistroyFragmentAdapter extends RecyclerView.Adapter<HistroyFragmentAdapter.MyViewHolder> {

    private List<Coordinates> coordinatesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtX1, txtX2, txtY1, txtY2,txtX3,txtY3;

        public MyViewHolder(View view) {
            super(view);
            txtX1 =  view.findViewById(R.id.txtX1);
            txtX2 = view.findViewById(R.id.txtX2);
            txtX3 = view.findViewById(R.id.txtX3);
            txtY1 =  view.findViewById(R.id.txtY1);
            txtY2 =  view.findViewById(R.id.txtY2);
            txtY3= view.findViewById(R.id.txtY3);
        }
    }


    public HistroyFragmentAdapter(List<Coordinates> moviesList) {
        this.coordinatesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Coordinates coordinates = coordinatesList.get(position);
        holder.txtX1.setText("X1 : "+coordinates.getX1());
        holder.txtX2.setText("X2 : "+coordinates.getX2());
        holder.txtY1.setText("Y1 : "+coordinates.getY1());
        holder.txtY2.setText("Y2 : "+coordinates.getY2());
        holder.txtY3.setText("Y3 : "+coordinates.getY1());
        holder.txtX3.setText("x3 : "+coordinates.getY2());
    }

    @Override
    public int getItemCount() {
        if(coordinatesList.size()>0) {
            return coordinatesList.size();
        }else {
            return 0;
        }
    }
}