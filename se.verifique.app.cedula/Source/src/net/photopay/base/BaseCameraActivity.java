package net.photopay.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import net.photopay.hardware.DeviceManager;
import net.photopay.hardware.camera.ResumeGrabberCaller;
import net.photopay.hardware.camera.focus.AutofocusStatusView;
import net.photopay.hardware.camera.llIIIlllll;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.locale.LanguageUtils;
import net.photopay.secured.lIlIIIIlIl;
import net.photopay.secured.llIIlIIIll;
import net.photopay.util.FakeR;
import net.photopay.util.Log;
import net.photopay.util.Log.LogLevel;
import net.photopay.view.viewfinder.AbstractViewFinder;

public abstract class BaseCameraActivity extends Activity
  implements llIIIlllll, net.photopay.hardware.orientation.llIIlIlIIl
{
  public static final String EXTRAS_CAMERA_TYPE = "EXTRAS_CAMERA_TYPE";
  static BaseCameraActivity jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseCameraActivity;
  private boolean IlIIlllIIl = false;
  private String IllIIIllII = null;
  private net.photopay.hardware.camera.llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl;
  private net.photopay.hardware.orientation.IlIllIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationIlIllIlIIl = null;
  private lIlIIIIlIl jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl = null;
  protected FakeR llIIlIlIIl;
  private boolean llIllIIlll = false;
  private llIIlIIIll mCameraPreview;

  public BaseCameraActivity()
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = null;
  }

  protected final AbstractViewFinder getViewFinder()
  {
    return this.mCameraPreview.llIIlIlIIl();
  }

  protected final boolean isActivityOrientationOK()
  {
    return this.llIllIIlll;
  }

  protected final boolean isAlertIsBeingShown()
  {
    return this.IlIIlllIIl;
  }

  protected final boolean isDeviceShaking()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null);
    for (boolean bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.isDeviceShaking(); ; bool = true)
    {
      return bool;
      Log.e(this, "Camera manager is null! Defining that device is shaking!", new Object[0]);
    }
  }

  protected abstract boolean isOrientationAllowed(Orientation paramOrientation);

  protected abstract void onAfterCreate();

  protected abstract void onAfterPause();

  protected abstract void onAfterStop();

  protected abstract boolean onBeforeLoadingCamera();

  protected abstract void onBeforePause();

  protected abstract void onCameraPreviewStarted();

  protected abstract boolean onCameraSurfaceReady();

  protected abstract String onCheckForSupport();

  protected void onConfigureWindow()
  {
    if (Build.VERSION.SDK_INT >= 11)
      getWindow().setFlags(8192, 8192);
  }

  protected final void onCreate(Bundle paramBundle)
  {
    LanguageUtils.setLanguageConfiguration(getResources());
    super.onCreate(paramBundle);
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this;
    Log.i(this, "onCreate: {}", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = getClass().getName();
    Log.d(this, "My instance is: {}", arrayOfObject2);
    Log.setApplicationContext(getApplicationContext());
    this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = new FakeR(this);
    onDecodeExtras(getIntent().getExtras());
    onConfigureWindow();
    int i = getRequestedOrientation();
    if ((i != 0) && (i != 1))
    {
      Object[] arrayOfObject6 = new Object[3];
      arrayOfObject6[0] = Integer.valueOf(i);
      arrayOfObject6[1] = Integer.valueOf(0);
      arrayOfObject6[2] = Integer.valueOf(1);
      Log.e(this, "Requested orientation is {}, and supported are only landscape ({}) and portrait ({}). Please check your AndroidManifest.xml!", arrayOfObject6);
      i = net.photopay.util.llIIlIlIIl.lIIIIIllll();
      setRequestedOrientation(i);
      this.llIllIIlll = false;
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[0] = Integer.valueOf(i);
      Log.i(this, "Setting activity orientation to {}", arrayOfObject7);
    }
    if (Log.getCurrentLogLevel().ordinal() >= Log.LogLevel.LOG_INFORMATION.ordinal())
    {
      if (i != 1)
        break label320;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = Integer.valueOf(i);
      Log.i(this, "Display orientation is portrait ({})!", arrayOfObject5);
    }
    while (true)
    {
      net.photopay.util.llIIlIlIIl.llIIIlllll(i);
      this.llIllIIlll = net.photopay.util.llIIlIlIIl.llIIlIlIIl(this);
      net.photopay.util.llIIlIlIIl.llIIlIlIIl(this);
      this.mCameraPreview = new llIIlIIIll(this, onCreateViewFinder());
      setContentView(this.mCameraPreview);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationIlIllIlIIl = new net.photopay.hardware.orientation.IlIllIlIIl(this, this);
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl = onCreateCameraSettings();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl = onCreateCameraManager(this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl, this.mCameraPreview.llIIlIlIIl());
      this.mCameraPreview.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl);
      onAfterCreate();
      return;
      label320: if (i == 0)
      {
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Integer.valueOf(i);
        Log.i(this, "Display orientation is landscape ({})!", arrayOfObject4);
        continue;
      }
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(i);
      Log.i(this, "Display orientation is wtf!?! ({})!", arrayOfObject3);
    }
  }

  protected abstract net.photopay.hardware.camera.llIIlIlIIl onCreateCameraManager(lIlIIIIlIl paramlIlIIIIlIl, AutofocusStatusView paramAutofocusStatusView);

  protected abstract lIlIIIIlIl onCreateCameraSettings();

  protected abstract AbstractViewFinder onCreateViewFinder();

  protected abstract void onDecodeExtras(Bundle paramBundle);

  public void onOrientationChange(Orientation paramOrientation)
  {
    if ((this.mCameraPreview != null) && (isOrientationAllowed(paramOrientation)))
      this.mCameraPreview.setOrientation(paramOrientation);
  }

  protected final void onPause()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this;
    Log.i(this, "onPause: {}", arrayOfObject);
    onBeforePause();
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationIlIllIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationIlIllIlIIl.disable();
    super.onPause();
    jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseCameraActivity = null;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIlIIlll();
    onAfterPause();
  }

  protected final void onResume()
  {
    super.onResume();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this;
    Log.i(this, "onResume: {}", arrayOfObject1);
    if (!this.llIllIIlll);
    while (true)
    {
      return;
      jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseCameraActivity = this;
      LanguageUtils.setLanguageConfiguration(getResources());
      if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationIlIllIlIIl != null)
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationIlIllIlIIl.enable();
      if (this.IllIIIllII != null)
      {
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = this.IllIIIllII;
        Log.e(this, "Not supported reason: {}", arrayOfObject4);
        AlertDialog localAlertDialog3 = new AlertDialog.Builder(this).create();
        localAlertDialog3.setTitle(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayWarningTitle")));
        localAlertDialog3.setMessage(this.IllIIIllII);
        localAlertDialog3.setButton(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayOK")), new BaseCameraActivity.3(this));
        this.IlIIlllIIl = true;
        localAlertDialog3.setCancelable(false);
        localAlertDialog3.show();
        continue;
      }
      if (!onBeforeLoadingCamera())
        continue;
      if (!this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIIlllll())
        this.mCameraPreview.IlIlIlIIlI();
      if (!onCameraSurfaceReady())
        continue;
      try
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIlIlIIl(new DeviceManager(this), this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl);
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.lIIIIIllll();
        onCameraPreviewStarted();
        onSetupViewFinder(this.mCameraPreview.llIIlIlIIl());
      }
      catch (net.photopay.hardware.camera.IlIllIlIIl localIlIllIlIIl)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = localIlIllIlIIl.getMessage();
        Log.e(this, localIlIllIlIIl, "Exception caught: {}", arrayOfObject3);
        Log.e(this, "Camera resolution too low!", new Object[0]);
        AlertDialog localAlertDialog2 = new AlertDialog.Builder(this).create();
        localAlertDialog2.setTitle(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayWarningTitle")));
        localAlertDialog2.setMessage(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "FeatureUnsuportedDevice")));
        localAlertDialog2.setButton(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayOK")), new BaseCameraActivity.1(this));
        localAlertDialog2.setCancelable(false);
        localAlertDialog2.show();
        setAlertIsBeingShown(true);
      }
      catch (Exception localException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localException.getMessage();
        Log.e(this, localException, "Exception caught: {}", arrayOfObject2);
        Log.e(this, "Camera is not ready!", new Object[0]);
        AlertDialog localAlertDialog1 = new AlertDialog.Builder(this).create();
        localAlertDialog1.setTitle(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayWarningTitle")));
        localAlertDialog1.setMessage(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayCameraNotReady")));
        localAlertDialog1.setButton(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayOK")), new BaseCameraActivity.2(this));
        localAlertDialog1.setCancelable(false);
        localAlertDialog1.show();
        this.IlIIlllIIl = true;
      }
    }
  }

  protected abstract void onSetupViewFinder(AbstractViewFinder paramAbstractViewFinder);

  protected final void onStart()
  {
    super.onStart();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this;
    Log.i(this, "onStart: {}", arrayOfObject1);
    if ((this.IllIIIllII == null) && (this.llIllIIlll))
      this.IllIIIllII = onCheckForSupport();
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = this.IllIIIllII;
    Log.i(this, "Not support reason: {}", arrayOfObject2);
  }

  protected final void onStop()
  {
    super.onStop();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this;
    Log.i(this, "onStop: {}", arrayOfObject);
    onAfterStop();
  }

  protected final void pauseFrameGrabbing()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.pauseFrameGrabbing();
  }

  protected abstract boolean requireAutofocusFeature();

  protected final void resumeFrameGrabbing(ResumeGrabberCaller paramResumeGrabberCaller)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.resumeFrameGrabbing(paramResumeGrabberCaller);
  }

  protected final void setAlertIsBeingShown(boolean paramBoolean)
  {
    this.IlIIlllIIl = paramBoolean;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseCameraActivity
 * JD-Core Version:    0.6.0
 */