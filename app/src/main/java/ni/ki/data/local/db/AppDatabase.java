package ni.ki.data.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ni.ki.data.local.db.dao.DbInterfaceDao;
import ni.ki.data.model.db.HistoryDaoEntity;
import ni.ki.utili.DbUtils;

@Database(entities = {HistoryDaoEntity.class}
        , version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DbUtils.DATABASE_NAME)


                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()

                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DbInterfaceDao interfaceDao();


}
