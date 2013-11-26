package co.mscsea.allsharelib.functions;

import android.content.Context;
import android.util.Log;

import co.mscsea.allsharelib.AllShareLib;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sec.android.allshare.ERROR;
import com.sec.android.allshare.ServiceConnector;
import com.sec.android.allshare.ServiceConnector.IServiceConnectEventListener;
import com.sec.android.allshare.ServiceConnector.ServiceState;
import com.sec.android.allshare.ServiceProvider;
import com.sec.android.allshare.screen.ScreenCastManager;

public class StartScreenShare implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		Log.d(AllShareLib.TAG, "startScreenShare");
		
		if (AllShareLib.screenCastManager != null) {
			AllShareLib.screenCastManager.activateManagerUI();
			return null;
		}
		
		final Context appContext = context.getActivity();
		
		try {
			ERROR error = ServiceConnector.createServiceProvider(appContext, new IServiceConnectEventListener() {
				
				@Override
				public void onDeleted(ServiceProvider serviceProvider) {
					AllShareLib.serviceProvider = null;
					AllShareLib.screenCastManager = null;
				}
				
				@Override
				public void onCreated(ServiceProvider serviceProvider, ServiceState state) {
					AllShareLib.serviceProvider = serviceProvider;
					
					ScreenCastManager scm = serviceProvider.getScreenCastManager();
					AllShareLib.screenCastManager = scm;
					scm.activateManagerUI();
				}
			});
		
			if (error != null && error != ERROR.SUCCESS) {
				Log.e(AllShareLib.TAG, error.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
