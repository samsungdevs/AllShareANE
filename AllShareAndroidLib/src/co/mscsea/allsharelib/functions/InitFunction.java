package co.mscsea.allsharelib.functions;

import android.util.Log;

import co.mscsea.allsharelib.AllShareLib;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class InitFunction implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		Log.d(AllShareLib.TAG, "AllShareLib initialized");
		
		return null;
	}
}
