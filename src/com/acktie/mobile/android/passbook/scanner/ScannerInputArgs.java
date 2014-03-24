package com.acktie.mobile.android.passbook.scanner;

import org.appcelerator.kroll.KrollFunction;

import com.acktie.mobile.android.InputArgs;
import com.acktie.mobile.android.camera.CameraManager;

public class ScannerInputArgs implements InputArgs{

	public static final String CONTINUOUS = "continuous";
	private boolean continuous = true;
	
	public static final String SCAN_FROM_IMAGE_CAPTURE = "scanQRFromImageCapture";
	private boolean scanQRFromImageCapture = false;
	
	public static final String USE_JIS_ENCODING = "useJISEncoding";
	private boolean useJISEncoding = false;
	
	public static final String SUCCESS_CALLBACK = "success";
	private KrollFunction successCallback = null;
	
	public static final String CANCEL_CALLBACK = "cancel";
	private KrollFunction cancelCallback = null;
	
	public static final String ERROR_CALLBACK = "error";
	private KrollFunction errorCallback = null;
	
	public static final String OVERLAY_COLOR = "color";
	private String color = null;
	
	public static final String OVERLAY_LAYOUT = "layout";
	private String layout = null;
	
	public static final String OVERLAY_IMAGE_NAME = "imageName";
	private String imageName = null;
	
	public static final String OVERLAY_ALPHA = "alpha";
	private float alpha = 1.0f;
	
	public static final String OVERLAY = "overlay";
	
	public static final String USE_FRONT_CAMERA = "useFrontCamera";
	private int cameraDevice = CameraManager.AUTO_DETACT_CAMERA_FACING;
	
	public static final String ENABLE_QR = "enableQR";
	private boolean enableQR = true;
	
	public static final String ENABLE_AZTEC = "enableAztec";
	private boolean enableAztec = true;
	
	public static final String ENABLE_PDF417 = "enablePDF417";
	private boolean enablePDF417 = true;
	
	public static final String SCAN_PORTRAIT = "scanPortrait";
	private boolean scanPortrait = false;

	public boolean isContinuous() {
		return continuous;
	}

	public void setContinuous(boolean continuous) {
		this.continuous = continuous;
	}

	public boolean isScanFromImageCapture() {
		return scanQRFromImageCapture;
	}

	public void setScanFromImageCapture(boolean scanQRFromImageCapture) {
		this.scanQRFromImageCapture = scanQRFromImageCapture;
	}

	public boolean isUseJISEncoding() {
		return useJISEncoding;
	}

	public void setUseJISEncoding(boolean useJISEncoding) {
		this.useJISEncoding = useJISEncoding;
	}

	public KrollFunction getSuccessCallback() {
		return successCallback;
	}

	public void setSuccessCallback(KrollFunction successCallback) {
		this.successCallback = successCallback;
	}

	public KrollFunction getCancelCallback() {
		return cancelCallback;
	}

	public void setCancelCallback(KrollFunction cancelCallback) {
		this.cancelCallback = cancelCallback;
	}

	public KrollFunction getErrorCallback() {
		return errorCallback;
	}

	public void setErrorCallback(KrollFunction errorCallback) {
		this.errorCallback = errorCallback;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color.equalsIgnoreCase("blue"))
		{
			this.color = "Blue";
		}
		else if(color.equalsIgnoreCase("purple"))
		{
			this.color = "Purple";
		}
		else if(color.equalsIgnoreCase("red"))
		{
			this.color = "Red";
		}
		else if(color.equalsIgnoreCase("yellow"))
		{
			this.color = "Yellow";
		}
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		if(layout.equalsIgnoreCase("center"))
		{
			this.layout = "Center";
		}
		else if(layout.equalsIgnoreCase("full"))
		{
			this.layout = "FullScreen";
		}
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public int getCameraDevice() {
		return cameraDevice;
	}

	public void setCameraDevice(int cameraDevice) {
		this.cameraDevice = cameraDevice;
	}

	@Override
	public boolean scanUsingZBar() {
		return false;
	}

	public boolean isEnableQR() {
		return enableQR;
	}

	public void setEnableQR(boolean enableQR) {
		this.enableQR = enableQR;
	}

	public boolean isEnableAztec() {
		return enableAztec;
	}

	public void setEnableAztec(boolean enableAztec) {
		this.enableAztec = enableAztec;
	}

	public boolean isEnablePDF417() {
		return enablePDF417;
	}

	public void setEnablePDF417(boolean enablePDF417) {
		this.enablePDF417 = enablePDF417;
	}

	@Override
	public boolean getScanPortrait() {
		return scanPortrait;
	}

	@Override
	public void setScanPortrait(boolean scanPortrait) {
		this.scanPortrait = scanPortrait;		
	}
}
