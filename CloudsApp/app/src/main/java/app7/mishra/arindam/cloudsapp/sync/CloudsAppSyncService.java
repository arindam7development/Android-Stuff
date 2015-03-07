package app7.mishra.arindam.cloudsapp.sync;

/**
 * Created by ARINDAM on 28-02-2015.
 */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CloudsAppSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static CloudsAppSyncAdapter CloudSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("SunshineSyncService", "onCreate - SunshineSyncService");
        synchronized (sSyncAdapterLock) {
            if (CloudSyncAdapter == null) {
                CloudSyncAdapter = new CloudsAppSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return CloudSyncAdapter.getSyncAdapterBinder();
    }
}
