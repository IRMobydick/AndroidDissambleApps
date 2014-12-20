package net.photopay.base;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.hardware.Camera.Size;
import android.media.MediaPlayer;
import android.os.Bundle;
import java.util.Timer;
import net.photopay.geometry.Rectangle;
import net.photopay.hardware.DeviceManager;
import net.photopay.hardware.camera.CameraDataFormat;
import net.photopay.hardware.camera.ResumeGrabberCaller;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.recognition.IllIIIllII;
import net.photopay.recognition.NativeRecognizerWrapper;
import net.photopay.recognition.NativeRecognizerWrapper.IlIllIlIIl;
import net.photopay.recognition.RecognizerDelegate;
import net.photopay.recognition.RecognizerState;
import net.photopay.recognition.RightsManager;
import net.photopay.settings.NativeLibraryInfo;
import net.photopay.util.FakeR;
import net.photopay.util.Log;
import net.photopay.view.viewfinder.AbstractViewFinder;

public abstract class BaseRecognitionActivity extends BaseCameraActivity
{
  public static final String EXTRAS_BEEP_RESOURCE = "EXTRAS_BEEP_RESOURCE";
  public static final String EXTRAS_LICENSE_KEY = "EXTRAS_LICENSE_KEY";
  public static final String EXTRAS_ROI = "EXTRAS_ROI";
  public static final String EXTRAS_ROTATE_ROI = "EXTRAS_ROTATE_ROI";
  public static final String EXTRAS_SETTINGS = "EXTRAS_SETTINGS";
  private String llIIIlllll = null;
  private int jdField_llIIlIlIIl_of_type_Int = -1;
  private MediaPlayer jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer = null;
  private Rectangle jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle = null;
  private CameraDataFormat jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraDataFormat;
  private final NativeRecognizerWrapper.IlIllIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$IlIllIlIIl = createRecognitionCallback();
  private NativeRecognizerWrapper jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper;
  private RecognizerDelegate jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate;
  private RightsManager jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRightsManager = null;
  protected net.photopay.settings.llIIlIlIIl llIIlIlIIl;
  private boolean lllllIlIll = false;

  public static String getNativeLibraryVersionString()
  {
    NativeLibraryInfo localNativeLibraryInfo = NativeRecognizerWrapper.llIIlIlIIl();
    String str = "native library not loaded";
    if (localNativeLibraryInfo != null)
      str = localNativeLibraryInfo.getBuildVersion();
    return str;
  }

  private final Rectangle llIIlIlIIl(Orientation paramOrientation)
  {
    float f1 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getX();
    float f2 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getY();
    float f3 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getWidth();
    float f4 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getHeight();
    if (paramOrientation == Orientation.ORIENTATION_LANDSCAPE_LEFT)
    {
      f1 = 1.0F - (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getX() + this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getWidth());
      f2 = 1.0F - (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getY() + this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getHeight());
    }
    while (true)
    {
      return new Rectangle(f1, f2, f3, f4);
      if (paramOrientation == Orientation.ORIENTATION_PORTRAIT)
      {
        f3 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getHeight();
        f4 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getWidth();
        f1 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getY();
        f2 = 1.0F - (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getX() + this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getWidth());
        continue;
      }
      if (paramOrientation != Orientation.ORIENTATION_PORTRAIT_UPSIDE)
        continue;
      f3 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getHeight();
      f4 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getWidth();
      f1 = 1.0F - (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getY() + this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getHeight());
      f2 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle.getX();
    }
  }

  protected abstract NativeRecognizerWrapper.IlIllIlIIl createRecognitionCallback();

  protected void finishAndWaitForAnimation()
  {
    AbstractViewFinder localAbstractViewFinder = getViewFinder();
    if (localAbstractViewFinder == null)
      super.finish();
    while (true)
    {
      return;
      Timer localTimer = new Timer();
      localTimer.scheduleAtFixedRate(new BaseRecognitionActivity.1(this, localAbstractViewFinder, localTimer), 0L, 100L);
    }
  }

  protected final CameraDataFormat getLastRecognitionDataFormat()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraDataFormat;
  }

  protected final RightsManager getRightsManager()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRightsManager;
  }

  protected abstract boolean isProgressBarEnabled();

  protected final void onAfterCreate()
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate = new IllIIIllII(getViewFinder(), isProgressBarEnabled(), this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl);
  }

  protected final void onAfterStop()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIllIIlll();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper = null;
    }
  }

  protected abstract boolean onBeforeLoadingCamera();

  protected final void onBeforePause()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate.setPaused(true);
    if (this.jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer != null)
      this.jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer = null;
  }

  public final void onCameraImage(byte[] paramArrayOfByte, CameraDataFormat paramCameraDataFormat, Camera.Size paramSize, boolean paramBoolean)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null)
    {
      Object[] arrayOfObject8 = new Object[1];
      arrayOfObject8[0] = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl();
      Log.v(this, "on camera image event: photopay state: {}", arrayOfObject8);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraDataFormat = paramCameraDataFormat;
      if ((paramArrayOfByte != null) && (jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseCameraActivity != null) && (!isAlertIsBeingShown()))
      {
        if (((paramCameraDataFormat != CameraDataFormat.IlIllIlIIl) || (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper == null) || (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl() != RecognizerState.llIIIlllll)) && (paramCameraDataFormat != CameraDataFormat.IllIIIllII))
          break label155;
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = Boolean.valueOf(paramBoolean);
        Log.v(this, "sending new frame to recognition, sharp: {}", arrayOfObject7);
        this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl(new net.photopay.recognition.llIIlIlIIl(paramArrayOfByte, paramCameraDataFormat, paramSize.width, paramSize.height, paramBoolean, isDeviceShaking()));
      }
    }
    while (true)
    {
      return;
      Log.v(paramSize, "Payment recognizer is null", new Object[0]);
      break;
      label155: Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Boolean.valueOf(paramBoolean);
      Log.v(this, "not sending frame! is sharp: {}", arrayOfObject1);
      Object[] arrayOfObject2 = new Object[1];
      boolean bool1;
      label191: Object[] arrayOfObject3;
      if (paramArrayOfByte == null)
      {
        bool1 = true;
        arrayOfObject2[0] = Boolean.valueOf(bool1);
        Log.v(this, "Is image null: {}", arrayOfObject2);
        arrayOfObject3 = new Object[1];
        if (jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseCameraActivity != null)
          break label411;
      }
      label411: for (boolean bool2 = true; ; bool2 = false)
      {
        arrayOfObject3[0] = Boolean.valueOf(bool2);
        Log.v(this, "Is active instance null: {}", arrayOfObject3);
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Boolean.valueOf(isAlertIsBeingShown());
        Log.v(this, "Is alert being shown: {}", arrayOfObject4);
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[0] = paramCameraDataFormat;
        Log.v(this, "Camera data format: {}", arrayOfObject5);
        if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper == null)
          break label417;
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl();
        Log.v(this, "Recognizer state: {}", arrayOfObject6);
        if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl() == RecognizerState.IllIIIllII) || (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl() == RecognizerState.IlIllIlIIl))
        {
          Log.v(this, "Native library is still initializing...", new Object[0]);
          resumeFrameGrabbing(ResumeGrabberCaller.llIIlIlIIl);
        }
        if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl() != RecognizerState.lIlIIIIlIl) && (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl() != RecognizerState.llIIIlllll))
          break;
        Log.v(this, "Recognizer still not prepared for next recognition", new Object[0]);
        resumeFrameGrabbing(ResumeGrabberCaller.llIIlIlIIl);
        break;
        bool1 = false;
        break label191;
      }
      label417: Log.e(this, "Payment recognizer is null!", new Object[0]);
      resumeFrameGrabbing(ResumeGrabberCaller.llIIlIlIIl);
    }
  }

  protected final void onCameraPreviewStarted()
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate.setPaused(false);
  }

  protected final boolean onCameraSurfaceReady()
  {
    boolean bool = false;
    if (this.jdField_llIIlIlIIl_of_type_Int > 0)
      this.jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(this, this.jdField_llIIlIlIIl_of_type_Int);
    try
    {
      if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null)
        this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.reset();
      bool = NativeRecognizerWrapper.IlIIlllIIl();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (true)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[bool] = "PhotoPayBarcode";
        Log.e(this, localUnsatisfiedLinkError, "Unable to load lib{}.so", arrayOfObject);
        AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
        localAlertDialog.setTitle(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayWarningTitle")));
        localAlertDialog.setMessage(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayErrorInitializing")));
        localAlertDialog.setButton(getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayOK")), new BaseRecognitionActivity.3(this));
        setAlertIsBeingShown(true);
        localAlertDialog.setCancelable(false);
        localAlertDialog.show();
      }
    }
  }

  protected final String onCheckForSupport()
  {
    Object localObject = null;
    boolean bool1 = onShouldLoadNativeRecognizer();
    boolean bool2 = isActivityOrientationOK();
    if ((bool1) && (bool2))
    {
      Log.i(this, "Everything is OK, Loading PhotoPay Native!", new Object[0]);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper = NativeRecognizerWrapper.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate, this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl);
    }
    while (true)
    {
      String str1;
      try
      {
        boolean bool3 = NativeRecognizerWrapper.llIIlIlIIl(this.llIIIlllll, this);
        String str3 = new DeviceManager(this).getReasonForLackOfSupport(bool3, requireAutofocusFeature());
        str1 = str3;
        this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRightsManager = NativeRecognizerWrapper.llIIlIlIIl();
        if ((llIIlIlIIl.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRightsManager, this)) || (str1 != null))
          break label261;
        str2 = getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "CustomUIForbidden"));
        if (str2 != null)
          continue;
        this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl(this);
        this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$IlIllIlIIl);
        if (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle == null)
          continue;
        NativeRecognizerWrapper localNativeRecognizerWrapper = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper;
        if (!net.photopay.util.llIIlIlIIl.isPortrait())
          continue;
        localOrientation = Orientation.ORIENTATION_PORTRAIT;
        localNativeRecognizerWrapper.llIIlIlIIl(llIIlIlIIl(localOrientation));
        localObject = str2;
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str1 = getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayErrorInitializing"));
        continue;
        Orientation localOrientation = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
        continue;
      }
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Boolean.valueOf(bool1);
      arrayOfObject[1] = Boolean.valueOf(bool2);
      arrayOfObject[2] = null;
      Log.i(this, "Not loading PhotoPay Native! Should load native recognizer:{}, Activity orientation is OK: {}, Not supported reason: {}", arrayOfObject);
      continue;
      label261: String str2 = str1;
    }
  }

  protected void onDecodeExtras(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.llIIIlllll = paramBundle.getString("EXTRAS_LICENSE_KEY");
      this.jdField_llIIlIlIIl_of_type_Int = paramBundle.getInt("EXTRAS_BEEP_RESOURCE", 0);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle = ((Rectangle)paramBundle.getParcelable("EXTRAS_ROI"));
      this.lllllIlIll = paramBundle.getBoolean("EXTRAS_ROTATE_ROI");
    }
    try
    {
      NativeRecognizerWrapper.llIIlIlIIl(this.llIIIlllll, this);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRightsManager = NativeRecognizerWrapper.llIIlIlIIl();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public final void onOrientationChange(Orientation paramOrientation)
  {
    super.onOrientationChange(paramOrientation);
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl(paramOrientation);
      if ((this.lllllIlIll) && (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryRectangle != null) && (paramOrientation != Orientation.ORIENTATION_UNKNOWN))
        this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl(llIIlIlIIl(paramOrientation));
    }
  }

  protected abstract boolean onShouldLoadNativeRecognizer();

  public final void onTakePictureFail()
  {
  }

  protected final void prepareForNextRecognition()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl();
      Log.v(this, "Before preparing for next recognition, recognizer state is: {}", arrayOfObject);
    }
    if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null) && (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.llIIlIlIIl() == RecognizerState.lIlIIIIlIl))
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.prepareForNextRecognition();
  }

  protected final void resetRecognitionState()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper != null)
    {
      Log.d(this, "Resetting recognizer state!", new Object[0]);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.reset();
    }
  }

  protected final void setRecognitionTimeout(int paramInt)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.IlIllIlIIl(paramInt);
  }

  protected void soundNotification()
  {
    if (this.jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer != null)
    {
      Log.d(this, "Playing beep sound", new Object[0]);
      this.jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_llIIlIlIIl_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new BaseRecognitionActivity.2(this));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseRecognitionActivity
 * JD-Core Version:    0.6.0
 */