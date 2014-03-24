/**
 * 
 */
package com.acktie.mobile.android.passbook.scanner;

import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiUIView;

import com.acktie.mobile.android.camera.CameraManager;

import android.app.Activity;
import android.hardware.Camera;

/**
 * @author TNuzzi
 *
 */
@Kroll.proxy(creatableInModule = AcktiemobileandroidpassbookscannerModule.class)
public class ScannerViewProxy extends TiViewProxy {
	private static final String LCAT = "ScannerViewProxy";
	private CameraManager cameraManager = null;
	private ScannerInputArgs args = null;
	
	/**
	 * 
	 */
	public ScannerViewProxy() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.appcelerator.titanium.proxy.TiViewProxy#createView(android.app.Activity)
	 */
	@Override
	public TiUIView createView(Activity arg0) {
		Log.d(LCAT, "Creating ScannerView");
		cameraManager = new CameraManager(args.getCameraDevice());
		TiUIView view = new ScannerView(this, cameraManager, args);
		// view.getLayoutParams().autoFillsHeight = true;
		// view.getLayoutParams().autoFillsWidth = true;
		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) 
	{
		super.handleCreationDict(options);
		
		args = new ScannerInputArgs();
		
		if (hasProperty(ScannerInputArgs.SUCCESS_CALLBACK)) {
			args.setSuccessCallback((KrollFunction) getProperty(ScannerInputArgs.SUCCESS_CALLBACK));
		}
		if (hasProperty(ScannerInputArgs.CANCEL_CALLBACK)) {
			args.setCancelCallback((KrollFunction) getProperty(ScannerInputArgs.CANCEL_CALLBACK));
		}
		if (hasProperty(ScannerInputArgs.ERROR_CALLBACK)) {
			args.setErrorCallback((KrollFunction) getProperty(ScannerInputArgs.ERROR_CALLBACK));
		}
		if (hasProperty(ScannerInputArgs.CONTINUOUS)) {
			args.setContinuous(TiConvert.toBoolean(getProperty(ScannerInputArgs.CONTINUOUS)));
		}
		if (hasProperty(ScannerInputArgs.USE_JIS_ENCODING)) {
			args.setUseJISEncoding(TiConvert.toBoolean(getProperty(ScannerInputArgs.USE_JIS_ENCODING)));
		}
		if (hasProperty(ScannerInputArgs.SCAN_FROM_IMAGE_CAPTURE)) {
			args.setScanFromImageCapture(TiConvert.toBoolean(getProperty(ScannerInputArgs.SCAN_FROM_IMAGE_CAPTURE)));
		}
		if (hasProperty(ScannerInputArgs.USE_FRONT_CAMERA)) {
			if(TiConvert.toBoolean(getProperty(ScannerInputArgs.USE_FRONT_CAMERA)))
			{
				args.setCameraDevice(Camera.CameraInfo.CAMERA_FACING_FRONT);
			}
			else
			{
				args.setCameraDevice(Camera.CameraInfo.CAMERA_FACING_BACK);
			}
		}
		if (hasProperty(ScannerInputArgs.OVERLAY)) {
			@SuppressWarnings("rawtypes")
			HashMap overlay = (HashMap) getProperty(ScannerInputArgs.OVERLAY);
			
			if(overlay.containsKey(ScannerInputArgs.OVERLAY_COLOR))
			{
				args.setColor((String) overlay.get(ScannerInputArgs.OVERLAY_COLOR));
			}
			if(overlay.containsKey(ScannerInputArgs.OVERLAY_LAYOUT))
			{
				args.setLayout((String) overlay.get(ScannerInputArgs.OVERLAY_LAYOUT));
			}
			if(overlay.containsKey(ScannerInputArgs.OVERLAY_IMAGE_NAME))
			{
				args.setImageName((String) overlay.get(ScannerInputArgs.OVERLAY_IMAGE_NAME));
			}
			if(overlay.containsKey(ScannerInputArgs.OVERLAY_ALPHA))
			{
				args.setAlpha(TiConvert.toFloat(overlay.get(ScannerInputArgs.OVERLAY_ALPHA)));
			}
		}
		
		if (hasProperty(ScannerInputArgs.ENABLE_QR)) {
			args.setEnableQR(TiConvert.toBoolean(getProperty(ScannerInputArgs.ENABLE_QR)));
		}
		if (hasProperty(ScannerInputArgs.ENABLE_AZTEC)) {
			args.setEnableAztec(TiConvert.toBoolean(getProperty(ScannerInputArgs.ENABLE_AZTEC)));
		}
		if (hasProperty(ScannerInputArgs.ENABLE_PDF417)) {
			args.setEnablePDF417(TiConvert.toBoolean(getProperty(ScannerInputArgs.ENABLE_PDF417)));
		}
		if (hasProperty(ScannerInputArgs.SCAN_PORTRAIT)) {
			args.setScanPortrait(TiConvert.toBoolean(getProperty(ScannerInputArgs.SCAN_PORTRAIT)));
		}
	}
	
	@Kroll.method
	public void toggleLight()
	{
		cameraManager.toggleTorch();
	}
	
	@Kroll.method
	public void turnLightOn()
	{
		cameraManager.turnOnTorch();
	}
	
	@Kroll.method
	public void turnLightOff()
	{
		cameraManager.turnOffTorch();
	}
	
	@SuppressWarnings("rawtypes")
	public void successCallback(HashMap results)
	{
		if(args.getSuccessCallback() != null)
		{
			args.getSuccessCallback().callAsync(getKrollObject(), results);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void cancelCallback()
	{
		cameraManager.stop();
		
		if(args.getCancelCallback() != null)
		{
			args.getCancelCallback().callAsync(getKrollObject(), new HashMap());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void errorCallback()
	{
		if(args.getErrorCallback() != null)
		{
			args.getErrorCallback().callAsync(getKrollObject(), new HashMap());
		}
	}
	
	@Kroll.method
	public void stop()
	{
		cancelCallback();
		cameraManager.stop();
	}
}
