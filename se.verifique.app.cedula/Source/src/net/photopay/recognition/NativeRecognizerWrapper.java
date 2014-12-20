package net.photopay.recognition;

import android.content.Context;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Timer;
import net.photopay.geometry.Rectangle;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.settings.NativeLibraryInfo;
import net.photopay.util.Log;

public class NativeRecognizerWrapper
{
  private static boolean IlIIIlIIIl;
  private static volatile NativeRecognizerWrapper jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper = null;
  private int IIIIIIIIII;
  private volatile boolean IIIIlIllIl = false;
  private Timer jdField_IlIllIlIIl_of_type_JavaUtilTimer = null;
  private NativeRecognizerWrapper.IlIllIlIIl jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$IlIllIlIIl;
  private NativeRecognizerWrapper.llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl = null;
  private RecognizerDelegate jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate = null;
  private volatile RecognizerState jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerState;
  private volatile NativeLibraryInfo jdField_llIIlIlIIl_of_type_NetPhotopaySettingsNativeLibraryInfo;
  private net.photopay.settings.llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl = null;

  static
  {
    IlIIIlIIIl = false;
    try
    {
      System.loadLibrary("PhotoPayBarcode");
      IlIIIlIIIl = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (true)
      {
        IlIIIlIIIl = false;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = "PhotoPayBarcode";
        Log.e(NativeRecognizerWrapper.class, localUnsatisfiedLinkError, "error loading lib {}.so", arrayOfObject);
      }
    }
  }

  public static boolean IlIIlllIIl()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "PhotoPayBarcode";
    arrayOfObject[1] = Boolean.valueOf(IlIIIlIIIl);
    Log.v(NativeRecognizerWrapper.class, "lib{} loaded: {}", arrayOfObject);
    return IlIIIlIIIl;
  }

  private native void addResource(String paramString, ByteBuffer paramByteBuffer);

  private native NativeLibraryInfo initPhotoPay(Bundle paramBundle);

  public static NativeRecognizerWrapper llIIlIlIIl(RecognizerDelegate paramRecognizerDelegate, net.photopay.settings.llIIlIlIIl paramllIIlIlIIl)
  {
    if (paramllIIlIlIIl == null);
    for (NativeRecognizerWrapper localNativeRecognizerWrapper = null; ; localNativeRecognizerWrapper = jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper)
    {
      return localNativeRecognizerWrapper;
      if (jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper == null)
      {
        jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper = new NativeRecognizerWrapper();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper;
        Log.i(NativeRecognizerWrapper.class, "Created new PhotoPayWrapper: {}", arrayOfObject);
      }
      jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerState = RecognizerState.IlIllIlIIl;
      jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerDelegate = paramRecognizerDelegate;
      jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl = paramllIIlIlIIl;
    }
  }

  public static RightsManager llIIlIlIIl()
  {
    if (IlIIIlIIIl);
    for (RightsManager localRightsManager = nativeObtainRights(); ; localRightsManager = new RightsManager(new HashSet(), false))
      return localRightsManager;
  }

  public static NativeLibraryInfo llIIlIlIIl()
  {
    if (IlIIIlIIIl);
    for (NativeLibraryInfo localNativeLibraryInfo = obtainDraftLibInfo(); ; localNativeLibraryInfo = null)
      return localNativeLibraryInfo;
  }

  public static boolean llIIlIlIIl(String paramString, Context paramContext)
  {
    if (IlIIIlIIIl)
      return nativeCheckLicenseKey(paramString, paramContext.getApplicationContext());
    throw new Exception("Unable to check license key; libPhotoPay.so not loaded!");
  }

  private static native boolean nativeCheckLicenseKey(String paramString, Context paramContext);

  private static native RightsManager nativeObtainRights();

  private static native NativeLibraryInfo obtainDraftLibInfo();

  private native RecognitionData recognize(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, RecognizerDelegate paramRecognizerDelegate);

  private native void resetRecognizers();

  private native void setOrientation(int paramInt);

  private native void setROI(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  private native void terminatePhotoPay();

  public final void IlIllIlIIl(int paramInt)
  {
    this.IIIIIIIIII = paramInt;
    if (this.jdField_IlIllIlIIl_of_type_JavaUtilTimer == null)
    {
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = new Timer();
      this.IIIIlIllIl = false;
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.schedule(new NativeRecognizerWrapper.1(this), 1000 * this.IIIIIIIIII);
    }
  }

  public final RecognizerState llIIlIlIIl()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRecognizerState;
  }

  public final void llIIlIlIIl(Context paramContext)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl == null)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl = new NativeRecognizerWrapper.llIIlIlIIl(this, 0);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.start();
      Log.d(this, "Starting worker thread", new Object[0]);
    }
    try
    {
      if (!this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.lIlllIlIlI())
        synchronized (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl)
        {
          Log.d(this, "Waiting for worker to start...", new Object[0]);
          this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.wait();
          Log.d(this, "Worker started. Posting init task...", new Object[0]);
          this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.IlIllIlIIl(paramContext);
          return;
        }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        Log.e(this, localInterruptedException, "Interrupted while waiting for workThread to start", new Object[0]);
        continue;
        Log.d(this, "Worker already started. No need to wait for it.", new Object[0]);
      }
    }
  }

  public final void llIIlIlIIl(Rectangle paramRectangle)
  {
    if (paramRectangle == null)
      paramRectangle = Rectangle.getDefaultROI();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramRectangle;
    Log.d(this, "Setting scanning ROI to {}", arrayOfObject);
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.IlIllIlIIl(paramRectangle);
    while (true)
    {
      return;
      Log.e(this, "Unable to set ROI to photopay recognizers: worker thread is null", new Object[0]);
    }
  }

  public final void llIIlIlIIl(Orientation paramOrientation)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.llIIlIlIIl(paramOrientation);
    while (true)
    {
      return;
      Log.e(this, "Unable to set orientation to photopay recognizers: worker thread is null", new Object[0]);
    }
  }

  public final void llIIlIlIIl(NativeRecognizerWrapper.IlIllIlIIl paramIlIllIlIIl)
  {
    this.jdField_IlIllIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$IlIllIlIIl = paramIlIllIlIIl;
  }

  public final void llIIlIlIIl(llIIlIlIIl paramllIIlIlIIl)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.IlIllIlIIl(paramllIIlIlIIl);
    while (true)
    {
      return;
      Log.e(this, "Work thread is null! Unable to perform recognition!", new Object[0]);
    }
  }

  public final void llIllIIlll()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.lllllIlIll();
    if (this.jdField_IlIllIlIIl_of_type_JavaUtilTimer != null)
    {
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.cancel();
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = null;
    }
  }

  public final void prepareForNextRecognition()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.prepareForNextRecognition();
    while (true)
    {
      return;
      Log.e(this, "Work thread is null! Unable to prepare for next recognition!", new Object[0]);
    }
  }

  public final void reset()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionNativeRecognizerWrapper$llIIlIlIIl.lIlllIlIlI();
    while (true)
    {
      return;
      Log.e(this, "Unable to reset photopay recognizers: worker thread is null", new Object[0]);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.NativeRecognizerWrapper
 * JD-Core Version:    0.6.0
 */