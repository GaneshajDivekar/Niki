package ni.ki.ui.mainmodule.fragment.histroyFragmentModule.adapter;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ni.ki.R;
import ni.ki.ui.mainmodule.Coordinates;

public class HistroyFragmentAdapter extends RecyclerView.Adapter<HistroyFragmentAdapter.MyViewHolder> {

    private List<Coordinates> coordinatesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);

            img =view.findViewById(R.id.img);
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
        drawSquare(holder,position,coordinates);
    }

    private void drawSquare(MyViewHolder holder, int position, Coordinates coordinates) {
        Bitmap bitmap = Bitmap.createBitmap(
                (int) coordinates.getWidth(), // Width
                (int) coordinates.getHeight(), // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);

        // Draw a solid color to the canvas background
        canvas.drawColor(Color.WHITE);

        // Initialize a new Paint instance to draw the Rectangle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        // Set a pixels value to padding around the rectangle
        int padding = 50;


        // Initialize a new Rect object
        Rect rectangle = new Rect(
                padding, // Left
                padding, // Top
                canvas.getWidth() - padding, // Right
                canvas.getHeight() - padding // Bottom
        );


        // Finally, draw the rectangle on the canvas
        canvas.drawRect(rectangle,paint);

        // Display the newly created bitmap on app interface
        holder.img.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        if (coordinatesList == null) {
            return 0;
        } else
            return coordinatesList.size();


    }
}