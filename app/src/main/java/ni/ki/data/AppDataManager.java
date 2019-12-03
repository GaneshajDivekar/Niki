package ni.ki.data;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import ni.ki.data.local.db.AppDatabase;
import ni.ki.data.local.db.DbHelper;
import ni.ki.data.remote.ApiHelper;


/**
 * Created by Ganesh Divekar on 06/11/19.
 */
@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;


    private AppDatabase mAppDatabase;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
        mGson = gson;
        mAppDatabase = AppDatabase.getDatabase(mContext);
    }
}
