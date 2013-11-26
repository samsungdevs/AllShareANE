package co.mscsea.allsharelib;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.sec.android.allshare.ServiceProvider;
import com.sec.android.allshare.screen.ScreenCastManager;

public class AllShareLib implements FREExtension {
	
	public static final String TAG = "AllShareLib";
	public static ServiceProvider serviceProvider = null;
	public static ScreenCastManager screenCastManager = null;

	@Override
	public FREContext createContext(String arg0) {
		Log.d(TAG, "createContext");
		return new AllShareLibContext();
	}

	@Override
	public void dispose() {
		Log.d(TAG, "dispose");
	}

	@Override
	public void initialize() {
		Log.d(TAG, "initialize");
	}
}
