package net.photopay.secured;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera.Size;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import net.photopay.hardware.camera.CameraType;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.recognition.IlIllIlIIl;
import net.photopay.util.FakeR;
import net.photopay.util.Log;
import net.photopay.view.viewfinder.AbstractViewFinder;

public final class llIIlIIIll extends ViewGroup
  implements SurfaceHolder.Callback
{
  private int IIlIlIIlll;
  private Camera.Size jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size;
  private SurfaceHolder jdField_IlIllIlIIl_of_type_AndroidViewSurfaceHolder;
  private AbstractViewFinder jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
  private Orientation IllIIIllII = Orientation.ORIENTATION_UNKNOWN;
  private SurfaceView jdField_llIIlIlIIl_of_type_AndroidViewSurfaceView;
  private net.photopay.hardware.camera.llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl;
  private FakeR jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR;
  private net.photopay.view.viewfinder.llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl;

  public llIIlIIIll(Context paramContext, AbstractViewFinder paramAbstractViewFinder)
  {
    super(paramContext, null);
    this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = new FakeR(paramContext);
    this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder = paramAbstractViewFinder;
    this.IIlIlIIlll = paramContext.getResources().getConfiguration().orientation;
    this.jdField_llIIlIlIIl_of_type_AndroidViewSurfaceView = new SurfaceView(paramContext);
    addView(this.jdField_llIIlIlIIl_of_type_AndroidViewSurfaceView);
    if (this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null)
    {
      this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.setCameraPreview(this);
      if (this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getFixedView() == null)
        break label208;
      addView(this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getFixedView());
    }
    while (true)
    {
      if (this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getRotatableView() != null)
      {
        this.IllIIIllII = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getInitialOrientation();
        this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl = new net.photopay.view.viewfinder.llIIlIlIIl(paramContext, this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getInitialOrientation(), this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.shouldAnimateRotation(), this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getRotationAnimationDuration());
        this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl.setVisibility(0);
        this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl.addView(this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getRotatableView());
        addView(this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl);
      }
      this.jdField_IlIllIlIIl_of_type_AndroidViewSurfaceHolder = this.jdField_llIIlIlIIl_of_type_AndroidViewSurfaceView.getHolder();
      setOnClickListener(new llIIlIIIll.1(this));
      return;
      label208: addView(new View(paramContext));
    }
  }

  public final void IlIlIlIIlI()
  {
    this.jdField_IlIllIlIIl_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_IlIllIlIIl_of_type_AndroidViewSurfaceHolder.setType(3);
  }

  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.getFixedView();
    boolean bool;
    if (localView != null)
      if (localView.dispatchTouchEvent(paramMotionEvent))
        bool = true;
    while (true)
    {
      return bool;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      continue;
      if (this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl != null)
      {
        bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl.dispatchTouchEvent(paramMotionEvent);
        continue;
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
  }

  public final void focusCamera()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.lllIIIlIlI();
  }

  public final CameraType getCameraType()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null);
    for (CameraType localCameraType = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIlIlIIl(); ; localCameraType = null)
      return localCameraType;
  }

  public final boolean isCameraFocused()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null);
    for (boolean bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.IllIIIIllI(); ; bool = false)
      return bool;
  }

  public final boolean isCameraTorchSupported()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null);
    for (boolean bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.lIlIIIIlIl(); ; bool = false)
      return bool;
  }

  public final AbstractViewFinder llIIlIlIIl()
  {
    return this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
  }

  public final void llIIlIlIIl(net.photopay.hardware.camera.llIIlIlIIl paramllIIlIlIIl)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl = paramllIIlIlIIl;
  }

  public final boolean llIIlIlIIl(boolean paramBoolean)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null);
    for (boolean bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIlIlIIl(paramBoolean); ; bool = false)
      return bool;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject1 = new Object[6];
    arrayOfObject1[0] = Integer.valueOf(getChildCount());
    arrayOfObject1[1] = Integer.valueOf(paramInt2);
    arrayOfObject1[2] = Integer.valueOf(paramInt4);
    arrayOfObject1[3] = Integer.valueOf(paramInt1);
    arrayOfObject1[4] = Integer.valueOf(paramInt3);
    arrayOfObject1[5] = Boolean.valueOf(paramBoolean);
    Log.d(this, "Camera preview ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", arrayOfObject1);
    if (getChildCount() > 0)
    {
      View localView1 = getChildAt(0);
      int i = paramInt3 - paramInt1;
      int j = paramInt4 - paramInt2;
      int m;
      int k;
      label226: int i4;
      label350: int i7;
      label353: View localView3;
      if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null)
      {
        this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIlIlIIl();
        if (this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size != null)
        {
          Object[] arrayOfObject9 = new Object[2];
          arrayOfObject9[0] = Integer.valueOf(this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size.width);
          arrayOfObject9[1] = Integer.valueOf(this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size.height);
          Log.d(this, "Current preview size is {}x{}", arrayOfObject9);
        }
      }
      else
      {
        if (this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size == null)
          break label585;
        if (this.IIlIlIIlll != 2)
          break label488;
        m = this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size.width;
        k = this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size.height;
        Object[] arrayOfObject8 = new Object[2];
        arrayOfObject8[0] = Integer.valueOf(m);
        arrayOfObject8[1] = Integer.valueOf(k);
        Log.d(this, "Activity is in landscape mode, preview size used for layouting is {}x{}", arrayOfObject8);
        if (i * k <= j * m)
          break label634;
        Object[] arrayOfObject4 = new Object[4];
        arrayOfObject4[0] = Integer.valueOf(i);
        arrayOfObject4[1] = Integer.valueOf(k);
        arrayOfObject4[2] = Integer.valueOf(j);
        arrayOfObject4[3] = Integer.valueOf(m);
        Log.d(this, "width*previewHeight ({}*{}) > height*previewWidth ({}*{})", arrayOfObject4);
        i4 = m * j / k;
        int i5 = (i - i4) / 2;
        int i6 = (i + i4) / 2;
        localView1.layout(i5, 0, i6, j);
        if (!this.IllIIIllII.isHorizontal())
          break label606;
        this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.onSizeChanged(j, i4);
        i7 = 1;
        if (i7 >= getChildCount())
          return;
        localView3 = getChildAt(i7);
        if (!this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.shouldPutInsideCameraSurface())
          break label620;
        Object[] arrayOfObject5 = new Object[5];
        arrayOfObject5[0] = Integer.valueOf(i7);
        arrayOfObject5[1] = Integer.valueOf(i5);
        arrayOfObject5[2] = Integer.valueOf(0);
        arrayOfObject5[3] = Integer.valueOf(i6);
        arrayOfObject5[4] = Integer.valueOf(j);
        Log.i(this, "Layouting child {}: Left: {}, Top: {}, Right: {}, Bottom: {}", arrayOfObject5);
        localView3.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
        localView3.layout(i5, 0, i6, j);
      }
      while (true)
      {
        i7++;
        break label353;
        Log.d(this, "Current preview size is null!", new Object[0]);
        break;
        label488: if (this.IIlIlIIlll == 1)
        {
          m = this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size.height;
          k = this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$Size.width;
          Object[] arrayOfObject7 = new Object[2];
          arrayOfObject7[0] = Integer.valueOf(m);
          arrayOfObject7[1] = Integer.valueOf(k);
          Log.d(this, "Activity is in portrait mode, preview size used for layouting is {}x{}", arrayOfObject7);
          break label226;
        }
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = Integer.valueOf(this.IIlIlIIlll);
        Log.e(this, "Activity is in neither landscape nor portrait mode. (mode is {})", arrayOfObject6);
        k = j;
        m = i;
        break label226;
        label585: Log.i(this, "preview size is null", new Object[0]);
        k = j;
        m = i;
        break label226;
        label606: this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.onSizeChanged(i4, j);
        break label350;
        label620: localView3.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      label634: Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = Integer.valueOf(i);
      arrayOfObject2[1] = Integer.valueOf(k);
      arrayOfObject2[2] = Integer.valueOf(j);
      arrayOfObject2[3] = Integer.valueOf(m);
      Log.d(this, "width*previewHeight ({}*{}) <= height*previewWidth ({}*{})", arrayOfObject2);
      int n = k * i / m;
      int i1 = (j - n) / 2;
      int i2 = (j + n) / 2;
      localView1.layout(0, i1, i, i2);
      int i3;
      label749: View localView2;
      if (this.IllIIIllII.isHorizontal())
      {
        this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.onSizeChanged(n, i);
        i3 = 1;
        if (i3 >= getChildCount())
          return;
        localView2 = getChildAt(i3);
        if (!this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.shouldPutInsideCameraSurface())
          break label885;
        Object[] arrayOfObject3 = new Object[5];
        arrayOfObject3[0] = Integer.valueOf(i3);
        arrayOfObject3[1] = Integer.valueOf(0);
        arrayOfObject3[2] = Integer.valueOf(i1);
        arrayOfObject3[3] = Integer.valueOf(i);
        arrayOfObject3[4] = Integer.valueOf(i2);
        Log.i(this, "Layouting child {}: Left: {}, Top: {}, Right: {}, Bottom: {}", arrayOfObject3);
        localView2.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
        localView2.layout(0, i1, i, i2);
      }
      while (true)
      {
        i3++;
        break label749;
        this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.onSizeChanged(i, n);
        break;
        label885: localView2.layout(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = resolveSize(getSuggestedMinimumWidth(), paramInt1);
    int j = resolveSize(getSuggestedMinimumHeight(), paramInt2);
    if (this.IIlIlIIlll == 2)
    {
      i = Math.max(i, j);
      j = Math.min(i, j);
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Integer.valueOf(j);
      Log.d(this, "Measured dimension: {}x{}", arrayOfObject);
      setMeasuredDimension(i, j);
      for (int k = 1; k < getChildCount(); k++)
      {
        View localView = getChildAt(k);
        if (localView == null)
          continue;
        localView.measure(paramInt1, paramInt2);
      }
      if (this.IIlIlIIlll != 1)
        continue;
      i = Math.min(i, j);
      j = Math.max(i, j);
    }
  }

  public final void setOrientation(Orientation paramOrientation)
  {
    this.IllIIIllII = paramOrientation;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderLlIIlIlIIl.setOrientation(paramOrientation);
    if (this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null)
      this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.setOrientation(paramOrientation);
  }

  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl != null);
    try
    {
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Integer.valueOf(paramInt2);
      arrayOfObject3[1] = Integer.valueOf(paramInt3);
      Log.d(this, "Surface changed to size: {}x{}", arrayOfObject3);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.llIIlIlIIl(paramSurfaceHolder, paramInt2, paramInt3);
      requestLayout();
      return;
    }
    catch (IlIllIlIIl localIlIllIlIIl)
    {
      while (true)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localIlIllIlIIl.getMessage();
        Log.e(this, localIlIllIlIIl, "Exception caught: {}", arrayOfObject2);
        Context localContext2 = getContext();
        AlertDialog localAlertDialog2 = new AlertDialog.Builder(localContext2).create();
        localAlertDialog2.setTitle(localContext2.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayWarningTitle")));
        localAlertDialog2.setMessage(localContext2.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "FeatureUnsuportedDevice")));
        localAlertDialog2.setButton(localContext2.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayOK")), new llIIlIIIll.2(this, localContext2));
        localAlertDialog2.setCancelable(false);
        localAlertDialog2.show();
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localException.getMessage();
        Log.e(this, localException, "Exception caught: {}", arrayOfObject1);
        Context localContext1 = getContext();
        AlertDialog localAlertDialog1 = new AlertDialog.Builder(localContext1).create();
        localAlertDialog1.setTitle(localContext1.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayWarningTitle")));
        localAlertDialog1.setMessage(localContext1.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayCameraNotReady")));
        localAlertDialog1.setButton(localContext1.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayOK")), new llIIlIIIll.3(this, localContext1));
        localAlertDialog1.setCancelable(false);
        localAlertDialog1.show();
      }
    }
  }

  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
  }

  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIlIlIIl.IIlIIIllIl();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIIlIIIll
 * JD-Core Version:    0.6.0
 */