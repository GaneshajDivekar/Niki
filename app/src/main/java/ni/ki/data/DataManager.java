package ni.ki.data;


import ni.ki.data.local.db.DbHelper;
import ni.ki.data.local.prefs.PreferencesHelper;
import ni.ki.data.remote.ApiHelper;

/**
 * Created by Ganesh Divekar on 06/11/19.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {


}
