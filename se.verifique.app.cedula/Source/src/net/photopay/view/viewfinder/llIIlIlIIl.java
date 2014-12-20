package net.photopay.view.viewfinder;

import android.content.Context;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.util.Log;

public final class llIIlIlIIl extends ViewGroup
{
  private boolean IIllllIIlI = true;
  private int IIllllllll = 500;
  private Orientation IllIIIllII = Orientation.ORIENTATION_PORTRAIT;
  private Matrix llIIlIlIIl = new Matrix();

  public llIIlIlIIl(Context paramContext, Orientation paramOrientation, boolean paramBoolean, int paramInt)
  {
    super(paramContext);
    setClipChildren(false);
    this.IllIIIllII = llIIlIlIIl(paramOrientation);
    this.IIllllIIlI = paramBoolean;
    this.IIllllllll = paramInt;
  }

  private void IlIIIIIlll()
  {
    int i = getWidth();
    int j = getHeight();
    Matrix localMatrix = new Matrix();
    if (this.IllIIIllII == Orientation.ORIENTATION_LANDSCAPE_RIGHT)
    {
      localMatrix.preTranslate(i, 0.0F);
      localMatrix.preRotate(90.0F);
    }
    while (true)
    {
      localMatrix.invert(this.llIIlIlIIl);
      return;
      if (this.IllIIIllII == Orientation.ORIENTATION_LANDSCAPE_LEFT)
      {
        localMatrix.preTranslate(0.0F, j);
        localMatrix.preRotate(-90.0F);
        continue;
      }
      if ((this.IllIIIllII == Orientation.ORIENTATION_PORTRAIT) || (this.IllIIIllII != Orientation.ORIENTATION_PORTRAIT_UPSIDE))
        continue;
      localMatrix.preTranslate(i, j);
      localMatrix.preRotate(180.0F);
    }
  }

  private Animation llIIlIlIIl(Orientation paramOrientation1, Orientation paramOrientation2)
  {
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = paramOrientation1;
    arrayOfObject1[1] = paramOrientation2;
    Log.d(this, "Creating animation from {} to {}", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(getWidth());
    arrayOfObject2[1] = Integer.valueOf(getHeight());
    Log.d(this, "Width: {},  heigth: {}", arrayOfObject2);
    llIIlIlIIl.llIIlIlIIl localllIIlIlIIl;
    if (paramOrientation1 == Orientation.ORIENTATION_PORTRAIT)
      if (paramOrientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT)
        localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 0.0F, 90.0F, getWidth(), getHeight(), true);
    while (true)
    {
      return localllIIlIlIIl;
      if (paramOrientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT)
      {
        localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 0.0F, -90.0F, getWidth(), getHeight(), true);
        continue;
      }
      if (paramOrientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE)
      {
        localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 0.0F, 180.0F, getWidth(), getHeight(), false);
        continue;
      }
      localllIIlIlIIl = null;
      continue;
      if (paramOrientation1 == Orientation.ORIENTATION_LANDSCAPE_RIGHT)
      {
        if (paramOrientation2 == Orientation.ORIENTATION_PORTRAIT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 90.0F, 0.0F, getWidth(), getHeight(), false);
          continue;
        }
        if (paramOrientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 90.0F, 180.0F, getWidth(), getHeight(), false);
          continue;
        }
        if (paramOrientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 90.0F, -90.0F, getWidth(), getHeight(), true);
          continue;
        }
        localllIIlIlIIl = null;
        continue;
      }
      if (paramOrientation1 == Orientation.ORIENTATION_PORTRAIT_UPSIDE)
      {
        if (paramOrientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 180.0F, 90.0F, getWidth(), getHeight(), true);
          continue;
        }
        if (paramOrientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 180.0F, 270.0F, getWidth(), getHeight(), true);
          continue;
        }
        if (paramOrientation2 == Orientation.ORIENTATION_PORTRAIT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 180.0F, 0.0F, getWidth(), getHeight(), false);
          continue;
        }
        localllIIlIlIIl = null;
        continue;
      }
      if (paramOrientation1 == Orientation.ORIENTATION_LANDSCAPE_LEFT)
      {
        if (paramOrientation2 == Orientation.ORIENTATION_PORTRAIT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, -90.0F, 0.0F, getWidth(), getHeight(), false);
          continue;
        }
        if (paramOrientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, 270.0F, 180.0F, getWidth(), getHeight(), false);
          continue;
        }
        if (paramOrientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT)
        {
          localllIIlIlIIl = new llIIlIlIIl.llIIlIlIIl(this, -90.0F, 90.0F, getWidth(), getHeight(), true);
          continue;
        }
        localllIIlIlIIl = null;
        continue;
      }
      localllIIlIlIIl = null;
    }
  }

  private static Orientation llIIlIlIIl(Orientation paramOrientation)
  {
    if (net.photopay.util.llIIlIlIIl.isPortrait());
    while (true)
    {
      return paramOrientation;
      if (paramOrientation == Orientation.ORIENTATION_UNKNOWN)
        continue;
      int i = -1 + paramOrientation.intValue();
      if (i < 0)
        i = 3;
      paramOrientation = Orientation.fromInt(i);
    }
  }

  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramMotionEvent.getRawX();
    arrayOfFloat[1] = paramMotionEvent.getRawY();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Float.valueOf(arrayOfFloat[0]);
    arrayOfObject1[1] = Float.valueOf(arrayOfFloat[1]);
    Log.d(this, "Tap coordinate: ({}, {})", arrayOfObject1);
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(arrayOfInt[0]);
    arrayOfObject2[1] = Integer.valueOf(arrayOfInt[1]);
    Log.d(this, "Location on screen: ({}, {})", arrayOfObject2);
    arrayOfFloat[0] -= arrayOfInt[0];
    arrayOfFloat[1] -= arrayOfInt[1];
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Float.valueOf(arrayOfFloat[0]);
    arrayOfObject3[1] = Float.valueOf(arrayOfFloat[1]);
    Log.d(this, "View-normalized tap coordinate: ({}, {})", arrayOfObject3);
    this.llIIlIlIIl.mapPoints(arrayOfFloat);
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Float.valueOf(arrayOfFloat[0]);
    arrayOfObject4[1] = Float.valueOf(arrayOfFloat[1]);
    Log.d(this, "Mapped tap coordinate: ({} {})", arrayOfObject4);
    paramMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    Object[] arrayOfObject1 = new Object[6];
    arrayOfObject1[0] = Integer.valueOf(i);
    arrayOfObject1[1] = Integer.valueOf(paramInt2);
    arrayOfObject1[2] = Integer.valueOf(paramInt4);
    arrayOfObject1[3] = Integer.valueOf(paramInt1);
    arrayOfObject1[4] = Integer.valueOf(paramInt3);
    arrayOfObject1[5] = Boolean.valueOf(paramBoolean);
    Log.d(this, "Rotatable view group ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", arrayOfObject1);
    int j = getWidth();
    int k = getHeight();
    int m = 0;
    if (m < i)
    {
      View localView = getChildAt(getChildDrawingOrder(i, m));
      if (this.IllIIIllII.isHorizontal())
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
        Object[] arrayOfObject3 = new Object[5];
        arrayOfObject3[0] = Integer.valueOf(m);
        arrayOfObject3[1] = Integer.valueOf(0);
        arrayOfObject3[2] = Integer.valueOf(j);
        arrayOfObject3[3] = Integer.valueOf(0);
        arrayOfObject3[4] = Integer.valueOf(k);
        Log.i(this, "Horizontal layouting child {} to: top: {} bottom: {}, left: {}, right: {}", arrayOfObject3);
        localView.layout(0, 0, k, j);
      }
      while (true)
      {
        m++;
        break;
        localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(k, 1073741824));
        Object[] arrayOfObject2 = new Object[5];
        arrayOfObject2[0] = Integer.valueOf(m);
        arrayOfObject2[1] = Integer.valueOf(0);
        arrayOfObject2[2] = Integer.valueOf(k);
        arrayOfObject2[3] = Integer.valueOf(0);
        arrayOfObject2[4] = Integer.valueOf(j);
        Log.i(this, "Vertical layouting child {} to: top: {} bottom: {}, left: {}, right: {}", arrayOfObject2);
        localView.layout(0, 0, j, k);
      }
    }
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = resolveSize(getSuggestedMinimumWidth(), paramInt1);
    int j = resolveSize(getSuggestedMinimumHeight(), paramInt2);
    if (this.IllIIIllII.isHorizontal());
    while (true)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(j);
      arrayOfObject[1] = Integer.valueOf(i);
      Log.d(this, "Measured dimension: {}x{}", arrayOfObject);
      setMeasuredDimension(j, i);
      return;
      int k = j;
      j = i;
      i = k;
    }
  }

  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramInt3);
    arrayOfObject[1] = Integer.valueOf(paramInt4);
    arrayOfObject[2] = Integer.valueOf(paramInt1);
    arrayOfObject[3] = Integer.valueOf(paramInt2);
    Log.d(this, "[RotatableViewGroup] size changed from {}x{} to {}x{}", arrayOfObject);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      Animation localAnimation = llIIlIlIIl(Orientation.ORIENTATION_PORTRAIT, this.IllIIIllII);
      if (localAnimation != null)
      {
        localAnimation.setFillEnabled(true);
        localAnimation.setDuration(0L);
        localAnimation.setFillAfter(true);
        localAnimation.setFillBefore(true);
        setLayoutAnimation(new LayoutAnimationController(localAnimation));
        startLayoutAnimation();
      }
      IlIIIIIlll();
    }
  }

  public final void setOrientation(Orientation paramOrientation)
  {
    invalidate();
    Orientation localOrientation = llIIlIlIIl(paramOrientation);
    Animation localAnimation = llIIlIlIIl(this.IllIIIllII, localOrientation);
    if (localAnimation != null)
    {
      localAnimation.setFillAfter(true);
      if (this.IIllllIIlI)
      {
        localAnimation.setDuration(this.IIllllllll);
        setLayoutAnimation(new LayoutAnimationController(localAnimation));
        startLayoutAnimation();
      }
    }
    while (true)
    {
      this.IllIIIllII = localOrientation;
      IlIIIIIlll();
      Log.d(this, "Set orientation: " + this.IllIIIllII, new Object[0]);
      return;
      localAnimation.setDuration(0L);
      break;
      requestLayout();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.view.viewfinder.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */