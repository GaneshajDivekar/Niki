package ni.ki.ui.mainmodule.fragment.drawfragmentModule;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

import ni.ki.R;
import ni.ki.ViewModelProviderFactory;
import ni.ki.data.local.db.AppDatabase;
import ni.ki.data.local.db.DbHelper;
import ni.ki.data.model.db.HistoryDaoEntity;
import ni.ki.databinding.FragmentDrawsquareBinding;
import ni.ki.ui.base.BaseFragment;
import ni.ki.BR;
import ni.ki.ui.mainmodule.Coordinates;


public class DrawSquareFragment extends BaseFragment<FragmentDrawsquareBinding, DrawFragmentViewModel> implements DrawFragmentNavigator, View.OnTouchListener {

    View view;
    @Inject
    ViewModelProviderFactory factory;
    private DrawFragmentViewModel drawFragmentViewModel;
    private FragmentDrawsquareBinding fragmentDrawsquareBinding;
    private Context mContext;

    final int RQS_IMAGE1 = 1;

    boolean isSelect = false;

    Uri source;
    Bitmap bitmapMaster;
    Canvas canvasMaster;
    Bitmap bitmapDrawingPane;
    Canvas canvasDrawingPane;
    projectPt startPt;
    private Region r;
    private int x1, x2, y1, y2;
    private int nx1, nx2, ny1, ny2;
    ArrayList<HistoryDaoEntity> historyDaoEntities = new ArrayList<>();

    ArrayList<Coordinates> arrayList = new ArrayList<Coordinates>();
    private Coordinates coordinates;
    private int selectedPosition;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_drawsquare;
    }

    @Override
    public DrawFragmentViewModel getViewModel() {

        drawFragmentViewModel = ViewModelProviders.of(this, factory).get(DrawFragmentViewModel.class);
        return drawFragmentViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentDrawsquareBinding = getViewDataBinding();
        drawFragmentViewModel.setNavigator(this);
        initView();

    }


    public void initView() {
        mContext = getActivity();
        initData();
    }

    private void initData() {

        fragmentDrawsquareBinding.imageResult.setOnTouchListener(this);
        imageViewData();


        fragmentDrawsquareBinding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("wuwang", "process:" + progress);
                //mLookupFilter.setIntensity(progress/100f);
                projectPt end = projectXY(fragmentDrawsquareBinding.imageResult, bitmapMaster, x2, y2);
                canvasDrawingPane.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                Paint p = new Paint();
                p.setColor(Color.YELLOW);
                p.setStyle(Paint.Style.STROKE);
                p.setStrokeWidth(1);
                canvasDrawingPane.drawRect(x1, y1, (progress * end.x) / 10, (progress * end.y) / 10, p);
                fragmentDrawsquareBinding.drawingpane.invalidate();
                nx1 = x1;
                ny1 = y1;

                projectPt newend = revertProjectXY(fragmentDrawsquareBinding.imageResult, bitmapMaster, (progress * end.x) / 10, (progress * end.y) / 10);
                nx2 = newend.x;
                ny2 = newend.y;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                projectPt end = projectXY(fragmentDrawsquareBinding.imageResult, bitmapMaster, x2, y2);
                canvasDrawingPane.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                Paint p = new Paint();
                p.setColor(Color.BLACK);
                p.setStyle(Paint.Style.STROKE);
                p.setStrokeWidth(1);
                canvasDrawingPane.drawRect(x1, y1, end.x, end.y, p);
                fragmentDrawsquareBinding.drawingpane.invalidate();
                finalizeDrawing();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // finalizeDrawing();
            }
        });

    }


    @Override
    public void clickOnDraw() {
        Toast.makeText(mContext, "Please Draw Square...", Toast.LENGTH_SHORT).show();
        isSelect = false;
    }

    @Override
    public void clickOnPrint() {
        if (x1 >= 0 && y1 >= 0) {

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                Coordinates coordinates = arrayList.get(i);
                stringBuilder.append("\n" + "Square " + (i + 1));
                stringBuilder.append("(" + coordinates.getX1());
                stringBuilder.append("," + coordinates.getY2() + ")");
                stringBuilder.append("(" + coordinates.getX2());
                stringBuilder.append("," + coordinates.getY2() + ")");
                stringBuilder.append("(" + coordinates.getX3());
                stringBuilder.append("," + coordinates.getY3() + ")");
                stringBuilder.append("(" + coordinates.getX4());
                stringBuilder.append("," + coordinates.getY4() + ")");
                stringBuilder.append("\n");

            }

            AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
            builder1.setMessage(stringBuilder);
            builder1.setTitle("Coordinates Of All Square");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();


        }
    }

    @Override
    public void clickOnSelect() {
        Toast.makeText(mContext, "Please Select Square Which you want to Resizing...", Toast.LENGTH_SHORT).show();
        isSelect = true;
    }

    @Override
    public void clickOnSave() {
        if(coordinates!=null)
        {
            coordinates.setX1(nx1);
            coordinates.setX2(nx2 + 1);
            coordinates.setY1(ny1);
            coordinates.setY2(ny2 + 1);
            arrayList.add(selectedPosition, coordinates);
            x2 = nx2;
            y2 = ny2;
            finalizeDrawing();
            saveJsonofCoordinates(arrayList);
        }else{

        }


    }

    private void saveJsonofCoordinates(ArrayList<Coordinates> arrayList) {

            HistoryDaoEntity historyDaoEntity = new HistoryDaoEntity();
            Gson gson = new Gson();
            String json = gson.toJson(arrayList);
            historyDaoEntity.setHistory_cordinates(json);
            AppDatabase.getDatabase(mContext).interfaceDao().insertCoordinates(historyDaoEntity);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isSelect == false) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            switch (action) {
                case MotionEvent.ACTION_DOWN:

                    startPt = projectXY((ImageView) v, bitmapMaster, x, y);
                    break;
                case MotionEvent.ACTION_MOVE:

                    drawOnRectProjectedBitMap((ImageView) v, bitmapMaster, x, y);
                    break;
                case MotionEvent.ACTION_UP:

                    drawOnRectProjectedBitMap((ImageView) v, bitmapMaster, x, y);
                    finalizeDrawing();
                    Log.d("Release", x + "," + y);
                    Coordinates coordinates = new Coordinates();
                    coordinates.setX1(x1);
                    coordinates.setX2(x2);
                    coordinates.setY1(y1);
                    coordinates.setY2(y2);

                  /*  coordinates.setX3(x1);
                    coordinates.setX4(x2);
                    coordinates.setY3(y2);
                    coordinates.setY4(y1);*/
                    // String cordinates = x1 + "," + x2 + "," + y1 + "," + y2;
                    arrayList.add(coordinates);
                    saveJsonofCoordinates(arrayList);
                    break;

            }
            /*
             * Return 'true' to indicate that the event have been consumed.
             * If auto-generated 'false', your code can detect ACTION_DOWN only,
             * cannot detect ACTION_MOVE and ACTION_UP.
             */

        } else {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();

            for (int i = 0; i < arrayList.size(); i++) {
                coordinates = arrayList.get(i);
                if (FindPoint(coordinates.getX1(), coordinates.getY1(), coordinates.getX2(), coordinates.getY2(), x, y)) {
                    System.out.println("Yes");
                    x1 = coordinates.getX1();
                    x2 = coordinates.getX2();
                    y1 = coordinates.getY1();
                    y2 = coordinates.getY2();

                    projectPt end = projectXY((ImageView) v, bitmapMaster, coordinates.getX2(), coordinates.getY2());
                    canvasDrawingPane.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    Paint p = new Paint();
                    p.setColor(Color.RED);
                    p.setStyle(Paint.Style.STROKE);
                    p.setStrokeWidth(1);
                    canvasDrawingPane.drawRect(coordinates.getX1(), coordinates.getY1(), end.x, end.y, p);
                    fragmentDrawsquareBinding.drawingpane.invalidate();

                    selectedPosition = i;

                    break;
                } else {
                    System.out.println("No");
                }

            }
        }
        return true;
    }


    class projectPt {
        int x;
        int y;

        projectPt(int tx, int ty) {
            x = tx;
            y = ty;
        }
    }

    private projectPt projectXY(ImageView iv, Bitmap bm, int x, int y) {
        if (x < 0 || y < 0 || x > iv.getWidth() || y > iv.getHeight()) {
            //outside ImageView
            return null;
        } else {
            int projectedX = (int) ((double) x * ((double) bm.getWidth() / (double) iv.getWidth()));
            int projectedY = (int) ((double) y * ((double) bm.getHeight() / (double) iv.getHeight()));
            return new projectPt(projectedX, projectedY);
        }
    }

    private void drawOnRectProjectedBitMap(ImageView iv, Bitmap bm, int x, int y) {
        if (x < 0 || y < 0 || x > iv.getWidth() || y > iv.getHeight()) {
            //outside ImageView
            return;
        } else {
            int projectedX = (int) ((double) x * ((double) bm.getWidth() / (double) iv.getWidth()));
            int projectedY = (int) ((double) y * ((double) bm.getHeight() / (double) iv.getHeight()));

            //clear canvasDrawingPane
            canvasDrawingPane.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            //paint.setAntiAlias(true);
            paint.setColor(Color.YELLOW);
            paint.setStrokeWidth(1);
            canvasDrawingPane.drawRect(startPt.x, startPt.y, projectedX, projectedY, paint);
            fragmentDrawsquareBinding.drawingpane.invalidate();

            x1 = startPt.x;
            y1 = startPt.y;

            x2 = x;
            y2 = y;



            /*x3 = startPt.x;
            y3 = startPt.y;

            x4 = x;
            y4 = y;*/


        }
    }

    static boolean FindPoint(int x1, int y1, int x2, int y2, int x, int y) {
        if (x > x1 && x < x2 && y > y1 && y < y2) {
            return true;
        }
        return false;
    }

    private void finalizeDrawing() {
        canvasMaster.drawBitmap(bitmapDrawingPane, 0, 0, null);
    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public void imageViewData() {
        Bitmap tempBitmap;
        tempBitmap = getBitmapFromVectorDrawable(mContext, R.drawable.ic_android_black_24dp);

        Bitmap.Config config;
        if (tempBitmap.getConfig() != null) {
            config = tempBitmap.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }

        //bitmapMaster is Mutable bitmap
        bitmapMaster = Bitmap.createBitmap(
                tempBitmap.getWidth(),
                tempBitmap.getHeight(),
                config);

        canvasMaster = new Canvas(bitmapMaster);
        canvasMaster.drawBitmap(tempBitmap, 0, 0, null);

        fragmentDrawsquareBinding.imageResult.setImageBitmap(bitmapMaster);

        //Create bitmap of same size for drawing
        bitmapDrawingPane = Bitmap.createBitmap(
                tempBitmap.getWidth(),
                tempBitmap.getHeight(),
                config);
        canvasDrawingPane = new Canvas(bitmapDrawingPane);
        fragmentDrawsquareBinding.drawingpane.setImageBitmap(bitmapDrawingPane);
    }

    private projectPt revertProjectXY(ImageView iv, Bitmap bm, int projectedX, int projectedY) {
        int nx = (int) (projectedX / ((double) bm.getWidth() / (double) iv.getWidth()));
        int ny = (int) (projectedY / ((double) bm.getHeight() / (double) iv.getHeight()));
        return new projectPt(nx, ny);
    }
}
