package net.photopay.hardware.camera.focus;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import java.util.Timer;
import net.photopay.util.Log;

public class llIIlIlIIl
  implements IlIllIlIIl
{
  protected volatile boolean IIIIIIIIII;
  private volatile boolean IIlIlllIIl = false;
  protected Timer IlIllIlIIl;
  private AutofocusStatusView IlIllIlIIl;
  private int IllIIlIIII = 0;
  private volatile int lIIIIIlIlI = 0;
  private final Camera.AutoFocusCallback llIIlIlIIl;
  protected Camera llIIlIlIIl;
  protected volatile boolean mFocused = false;

  public llIIlIlIIl(AutofocusStatusView paramAutofocusStatusView)
  {
    this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = null;
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$AutoFocusCallback = new llIIlIlIIl.2(this);
    this.jdField_IlIllIlIIl_of_type_NetPhotopayHardwareCameraFocusAutofocusStatusView = paramAutofocusStatusView;
  }

  public final boolean IIlIIIllIl()
  {
    monitorenter;
    try
    {
      boolean bool = this.IIIIIIIIII;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void IllIIlIIII()
  {
    monitorenter;
    try
    {
      this.IIlIlllIIl = false;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final boolean isCameraFocused()
  {
    monitorenter;
    try
    {
      boolean bool = this.mFocused;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void lIIIIIlIlI()
  {
    monitorenter;
    try
    {
      this.IIlIlllIIl = true;
      this.mFocused = false;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void llIIlIlIIl(boolean paramBoolean)
  {
    Camera.AutoFocusCallback localAutoFocusCallback = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$AutoFocusCallback;
    monitorenter;
    while (true)
    {
      try
      {
        if ((this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera == null) || (localAutoFocusCallback == null) || (this.IIlIlllIIl))
          continue;
        if ((!paramBoolean) && (this.mFocused))
          break label194;
        boolean bool = this.IIIIIIIIII;
        if (!bool)
          try
          {
            this.IIIIIIIIII = true;
            if (this.jdField_IlIllIlIIl_of_type_JavaUtilTimer == null)
              continue;
            this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.cancel();
            this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = null;
            Log.d(this, "requesting autofocus...", new Object[0]);
            this.lIIIIIlIlI = (1 + this.lIIIIIlIlI);
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(this.lIIIIIlIlI);
            Log.i(this, "Requests count: {}", arrayOfObject);
            this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.autoFocus(localAutoFocusCallback);
            Log.d(this, "request issued", new Object[0]);
            monitorexit;
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            this.lIIIIIlIlI = (-1 + this.lIIIIIlIlI);
            this.IIIIIIIIII = false;
            Log.e(this, "autoFocus call failed", new Object[0]);
            this.mFocused = false;
            continue;
          }
      }
      finally
      {
        monitorexit;
      }
      Log.v(this, "Autofocus is in progress...", new Object[0]);
      continue;
      label194: if ((!this.mFocused) || (localAutoFocusCallback == this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$AutoFocusCallback))
        continue;
      Log.v(this, "Frame should be focused...", new Object[0]);
      this.lIIIIIlIlI = (1 + this.lIIIIIlIlI);
      localAutoFocusCallback.onAutoFocus(true, this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera);
    }
  }

  public final void lllIlIlIIl()
  {
    monitorenter;
    try
    {
      if ((this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null) && (this.IIIIIIIIII))
      {
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.cancelAutoFocus();
        this.IIIIIIIIII = false;
        this.lIIIIIlIlI = (-1 + this.lIIIIIlIlI);
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void setCamera(Camera paramCamera)
  {
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera = paramCamera;
    this.IIIIIIIIII = false;
    if (this.jdField_IlIllIlIIl_of_type_JavaUtilTimer != null)
    {
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.cancel();
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = null;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.focus.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */