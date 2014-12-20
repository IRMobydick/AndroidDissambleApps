package net.photopay.base;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import mobi.pdf417.Pdf417MobiScanData;
import mobi.pdf417.Pdf417MobiSettings;
import net.photopay.hardware.DeviceManager;
import net.photopay.hardware.camera.CameraType;
import net.photopay.hardware.camera.ResumeGrabberCaller;
import net.photopay.hardware.camera.focus.AutofocusStatusView;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.recognition.NativeRecognizerWrapper.IlIllIlIIl;
import net.photopay.secured.IllIIIIllI;
import net.photopay.secured.lIlIIIIlIl;
import net.photopay.util.FakeR;
import net.photopay.view.viewfinder.AbstractViewFinder;

public abstract class BaseBarcodeActivity extends BaseRecognitionActivity
{
  public static final String EXTRAS_ALWAYS_USE_HIGH_RES = "EXTRAS_ALWAYS_USE_HIGH_RES";
  public static final String EXTRAS_RECOGNITION_MODE = "EXTRAS_RECOGNITION_MODE";
  public static final String EXTRAS_RESULT = "EXTRAS_RESULT";
  public static final String PREFS_PHOTOPAY_FILENAME = "PhotoPayBarcode.prefs";
  public static final int RESULT_OK = 1;
  public static final int RESULT_OK_DATA_COPIED = 2;
  private Pdf417MobiSettings jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings = null;
  lIlIIIIlIl jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl = new lIlIIIIlIl();
  protected Handler mHandler = new Handler();

  private static Intent llIIlIlIIl(Pdf417MobiScanData paramPdf417MobiScanData)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("EXTRAS_RESULT", paramPdf417MobiScanData);
    return localIntent;
  }

  private void llIIlIlIIl(Pdf417MobiScanData paramPdf417MobiScanData)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setCancelable(true);
    StringBuilder localStringBuilder = new StringBuilder().append(paramPdf417MobiScanData.getBarcodeType());
    if (paramPdf417MobiScanData.isResultUncertain());
    for (String str = " [uncertain]"; ; str = "")
    {
      AlertDialog localAlertDialog = localBuilder.setTitle(str).setMessage(paramPdf417MobiScanData.getBarcodeData()).setPositiveButton(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "PPUse"), new BaseBarcodeActivity.4(this, paramPdf417MobiScanData)).setNegativeButton(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "PPCancel"), new BaseBarcodeActivity.3(this)).setNeutralButton(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "Copy"), new BaseBarcodeActivity.2(this, paramPdf417MobiScanData)).create();
      localAlertDialog.setCancelable(false);
      setAlertIsBeingShown(true);
      localAlertDialog.setCancelable(false);
      localAlertDialog.show();
      return;
    }
  }

  protected final NativeRecognizerWrapper.IlIllIlIIl createRecognitionCallback()
  {
    return new BaseBarcodeActivity.5(this);
  }

  protected final Pdf417MobiSettings getScanningSettings()
  {
    return this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings;
  }

  protected boolean isOrientationAllowed(Orientation paramOrientation)
  {
    return true;
  }

  protected final boolean isProgressBarEnabled()
  {
    return false;
  }

  protected void onAfterPause()
  {
  }

  protected boolean onBeforeLoadingCamera()
  {
    return true;
  }

  protected final net.photopay.hardware.camera.llIIlIlIIl onCreateCameraManager(lIlIIIIlIl paramlIlIIIIlIl, AutofocusStatusView paramAutofocusStatusView)
  {
    return new IllIIIIllI(new DeviceManager(this)).llIIlIlIIl(this, paramAutofocusStatusView, paramlIlIIIIlIl);
  }

  protected final lIlIIIIlIl onCreateCameraSettings()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl;
  }

  protected final void onDecodeExtras(Bundle paramBundle)
  {
    int i = 0;
    super.onDecodeExtras(paramBundle);
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.IllIIIllII(false);
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.llIIlIIIll();
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.IlIllIlIIl(requireAutofocusFeature());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.IlIlllllII();
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.IlIllIlIIl(new BaseBarcodeActivity.1(this));
    CameraType localCameraType = CameraType.CAMERA_DEFAULT;
    if (paramBundle != null)
    {
      this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings = ((Pdf417MobiSettings)paramBundle.getParcelable("EXTRAS_SETTINGS"));
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.IllIIIllII(paramBundle.getBoolean("EXTRAS_ALWAYS_USE_HIGH_RES", false));
      i = paramBundle.getInt("EXTRAS_RECOGNITION_MODE", 0);
      localCameraType = (CameraType)paramBundle.getParcelable("EXTRAS_CAMERA_TYPE");
    }
    if (localCameraType == null)
      localCameraType = CameraType.CAMERA_DEFAULT;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.llIIlIlIIl(localCameraType);
    if (this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings == null)
    {
      this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings = new Pdf417MobiSettings();
      this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.setPdf417Enabled(true);
      this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.setQrCodeEnabled(true);
    }
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl = new net.photopay.settings.llIIlIlIIl();
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.setUncertainScanning(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isUncertainScanMode());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.setNullQuietZoneAllowed(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isNullQuietZoneAllowed());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.setInverseScanning(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isInverseScanMode());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IllIIIIllI(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isAztecCodeEnabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.lIlIIIIlIl(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isCode128Enabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.llIIlIIlll(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isCode39Enabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IIlIIIllIl(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isDataMatrixEnabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.lIIIIIllll(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isEAN13Enabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.lllIIIlIlI(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isEAN8Enabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IlIllIlllI(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isITFEnabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.llIIIlllll(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isPdf417Enabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.lllIlIlIIl(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isQrCodeEnabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IllIIlIIII(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isUPCEEnabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.lIIIIIlIlI(this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isUPCEEnabled());
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IllIIIllII(i);
  }

  protected void onScanningDone(Pdf417MobiScanData paramPdf417MobiScanData)
  {
    if (!this.jdField_llIIlIlIIl_of_type_MobiPdf417Pdf417MobiSettings.isDontShowDialog())
      llIIlIlIIl(paramPdf417MobiScanData);
    while (true)
    {
      return;
      setResult(1, llIIlIlIIl(paramPdf417MobiScanData));
      finishAndWaitForAnimation();
    }
  }

  protected void onSetupViewFinder(AbstractViewFinder paramAbstractViewFinder)
  {
    if (paramAbstractViewFinder != null)
    {
      paramAbstractViewFinder.setDefaultTarget(2, false);
      paramAbstractViewFinder.setRecognizerMode(this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IIlIIIllIl());
    }
  }

  protected final boolean onShouldLoadNativeRecognizer()
  {
    return true;
  }

  protected final void pauseScanning()
  {
    pauseFrameGrabbing();
    AbstractViewFinder localAbstractViewFinder = getViewFinder();
    if (localAbstractViewFinder != null)
      localAbstractViewFinder.setDefaultTarget(2, false);
  }

  protected final boolean requireAutofocusFeature()
  {
    return false;
  }

  protected final void resumeScanning()
  {
    resetRecognitionState();
    AbstractViewFinder localAbstractViewFinder = getViewFinder();
    if (localAbstractViewFinder != null)
      localAbstractViewFinder.setDefaultTarget(2, false);
    resumeFrameGrabbing(ResumeGrabberCaller.IlIllIlIIl);
    prepareForNextRecognition();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity
 * JD-Core Version:    0.6.0
 */