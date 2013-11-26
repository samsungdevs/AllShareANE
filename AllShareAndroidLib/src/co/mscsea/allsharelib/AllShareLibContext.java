package co.mscsea.allsharelib;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import co.mscsea.allsharelib.functions.InitFunction;
import co.mscsea.allsharelib.functions.StartScreenShare;
import co.mscsea.allsharelib.functions.StopScreenShare;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class AllShareLibContext extends FREContext {

	@Override
	public void dispose() {
		Log.d(AllShareLib.TAG, "AllShareLibContext dispose()");
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put("init", new InitFunction());
		functions.put("startScreenShare", new StartScreenShare());
		functions.put("stopScreenShare", new StopScreenShare());
		return functions;
	}
}
