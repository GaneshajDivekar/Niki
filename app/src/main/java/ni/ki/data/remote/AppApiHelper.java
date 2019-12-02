package ni.ki.data.remote;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by Ganesh Divekar on 06/11/19.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }



}
