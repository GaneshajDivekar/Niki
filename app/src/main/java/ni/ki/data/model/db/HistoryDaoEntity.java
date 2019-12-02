package ni.ki.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import ni.ki.utili.DbUtils;

@Entity(tableName = DbUtils.HISTORY_Master)
public class HistoryDaoEntity {
    @Expose
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbUtils.HISTORYConstants.history_uniqueId)
    public int history_uniqueId;
    @ColumnInfo(name = DbUtils.HISTORYConstants.history_desc)
    private String history_desc;

    public int getHistory_uniqueId() {
        return history_uniqueId;
    }

    public void setHistory_uniqueId(int history_uniqueId) {
        this.history_uniqueId = history_uniqueId;
    }

    public String getHistory_desc() {
        return history_desc;
    }

    public void setHistory_desc(String history_desc) {
        this.history_desc = history_desc;
    }

    public String getHistory_cordinates() {
        return history_cordinates;
    }

    public void setHistory_cordinates(String history_cordinates) {
        this.history_cordinates = history_cordinates;
    }

    @ColumnInfo(name = DbUtils.HISTORYConstants.history_cordinates)
    private String history_cordinates;
}
