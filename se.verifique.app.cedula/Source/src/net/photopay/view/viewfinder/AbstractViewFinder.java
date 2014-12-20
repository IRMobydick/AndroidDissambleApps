package net.photopay.view.viewfinder;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import net.photopay.geometry.Point;
import net.photopay.hardware.camera.CameraType;
import net.photopay.hardware.camera.focus.AutofocusStatusView;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.ocr.OcrResult;
import net.photopay.secured.IlIlllllII;
import net.photopay.secured.llIIlIIIll;
import net.photopay.util.Log;

public abstract class AbstractViewFinder
  implements AutofocusStatusView
{
  private llIIlIIIll mCameraPreview = null;
  private Handler mHandler = new Handler();
  private boolean mOnlyBarcode = false;
  private IlIlllllII mProgressModifier = null;

  public AbstractViewFinder()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException("Viewfinder must be created on UI thread!");
  }

  public void displayAutofocusFailed()
  {
  }

  public void displayDebugStatus(CharSequence paramCharSequence)
  {
  }

  public void displayMessage(CharSequence paramCharSequence)
  {
    this.mHandler.post(new AbstractViewFinder.1(this, paramCharSequence));
  }

  public void displayMessageImmediately(CharSequence paramCharSequence)
  {
  }

  public void displayOcrResult(OcrResult paramOcrResult)
  {
  }

  public final void focusCamera()
  {
    if (this.mCameraPreview != null)
      this.mCameraPreview.focusCamera();
    while (true)
    {
      return;
      Log.w(this, "Camera still not loaded. Unable to perform autofocus!", new Object[0]);
    }
  }

  public final CameraType getCameraType()
  {
    if (this.mCameraPreview != null);
    for (CameraType localCameraType = this.mCameraPreview.getCameraType(); ; localCameraType = null)
      return localCameraType;
  }

  public View getFixedView()
  {
    return null;
  }

  public Orientation getInitialOrientation()
  {
    return Orientation.ORIENTATION_PORTRAIT;
  }

  public View getRotatableView()
  {
    return null;
  }

  public int getRotationAnimationDuration()
  {
    return 250;
  }

  public boolean isAnimationInProgress()
  {
    return false;
  }

  public final boolean isCameraFocused()
  {
    boolean bool = false;
    if (this.mCameraPreview != null)
      bool = this.mCameraPreview.isCameraFocused();
    while (true)
    {
      return bool;
      Log.w(this, "Camera still not loaded. Unable to provide information about focus support!", new Object[0]);
    }
  }

  public final boolean isCameraTorchSupported()
  {
    boolean bool = false;
    if (this.mCameraPreview != null)
      bool = this.mCameraPreview.isCameraTorchSupported();
    while (true)
    {
      return bool;
      Log.w(this, "Camera still not loaded. Unable to provide information about torch support!", new Object[0]);
    }
  }

  public final boolean isOnlyBarcode()
  {
    return this.mOnlyBarcode;
  }

  public void onSizeChanged(int paramInt1, int paramInt2)
  {
  }

  public final void setCameraPreview(llIIlIIIll paramllIIlIIIll)
  {
    this.mCameraPreview = paramllIIlIIIll;
  }

  public void setDefaultTarget(int paramInt, boolean paramBoolean)
  {
  }

  public void setNewTarget(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4, int paramInt1, int paramInt2, boolean paramBoolean)
  {
  }

  public void setOrientation(Orientation paramOrientation)
  {
  }

  public void setPointSet(float[] paramArrayOfFloat, boolean paramBoolean)
  {
  }

  public final void setProgressModifier(IlIlllllII paramIlIlllllII)
  {
    this.mProgressModifier = paramIlIlllllII;
  }

  public void setRecognizerMode(int paramInt)
  {
  }

  public final boolean setTorchEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.mCameraPreview != null)
      bool = this.mCameraPreview.llIIlIlIIl(paramBoolean);
    while (true)
    {
      return bool;
      Log.w(this, "Camera still not loaded. Unable to enable/disable torch!", new Object[0]);
    }
  }

  public final void setUsingOnlyBarcode(boolean paramBoolean)
  {
    this.mOnlyBarcode = paramBoolean;
  }

  public boolean shouldAnimateRotation()
  {
    return false;
  }

  public boolean shouldPutInsideCameraSurface()
  {
    return true;
  }

  protected void showProgress(int paramInt)
  {
  }

  public final void showRawProgress(int paramInt)
  {
    if (this.mProgressModifier != null)
      paramInt = Math.round(100.0F * (paramInt / 100.0F));
    showProgress(paramInt);
  }

  public void startProgressAnimation()
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.view.viewfinder.AbstractViewFinder
 * JD-Core Version:    0.6.0
 */