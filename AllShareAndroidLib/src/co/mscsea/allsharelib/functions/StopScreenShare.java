package co.mscsea.allsharelib.functions;

import android.util.Log;

import co.mscsea.allsharelib.AllShareLib;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sec.android.allshare.screen.ScreenCastManager;

public class StopScreenShare implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		Log.d(AllShareLib.TAG, "stopScreenShare");
		
		ScreenCastManager scm = AllShareLib.screenCastManager;
		if (scm != null) {
			scm.stop();
			scm.setScreenCastEventListener(null);
			AllShareLib.screenCastManager = null;
		}

		return null;
	}
}
