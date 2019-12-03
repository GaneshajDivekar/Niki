package ni.ki.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import ni.ki.data.model.db.HistoryDaoEntity;
import ni.ki.utili.DbUtils;


@Dao
public interface DbInterfaceDao {
/*
    @Insert
    void insertCoordinates(HistoryDaoEntity historyDaoEntity);

    @Query("SELECT * FROM " + DbUtils.HISTORY_Master)
    ArrayList<HistoryDaoEntity> getAllCoordinteHistory();*/


    @Insert
    public void insertCoordinates(HistoryDaoEntity historyDaoEntity);

    @Query("SELECT * FROM " + DbUtils.HISTORY_Master)
    List<HistoryDaoEntity> getAllCoordinteHistory();


}
