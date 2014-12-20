package net.photopay.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation
{
  public static final boolean NEEDS_PROXY;
  private static final WeakHashMap PROXIES;
  private final RectF mAfter = new RectF();
  private float mAlpha = 1.0F;
  private final RectF mBefore = new RectF();
  private final Camera mCamera = new Camera();
  private boolean mHasPivot;
  private float mPivotX;
  private float mPivotY;
  private float mRotationX;
  private float mRotationY;
  private float mRotationZ;
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private final Matrix mTempMatrix = new Matrix();
  private float mTranslationX;
  private float mTranslationY;
  private final WeakReference mView;

  static
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);
    for (boolean bool = true; ; bool = false)
    {
      NEEDS_PROXY = bool;
      PROXIES = new WeakHashMap();
      return;
    }
  }

  private AnimatorProxy(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.mView = new WeakReference(paramView);
  }

  private void computeRect(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.mTempMatrix;
    localMatrix.reset();
    transformMatrix(localMatrix, paramView);
    this.mTempMatrix.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    if (paramRectF.right < paramRectF.left)
    {
      float f2 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f2;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      float f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }

  private void invalidateAfterUpdate()
  {
    View localView = (View)this.mView.get();
    if ((localView == null) || (localView.getParent() == null));
    while (true)
    {
      return;
      RectF localRectF = this.mAfter;
      computeRect(localRectF, localView);
      localRectF.union(this.mBefore);
      ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
    }
  }

  private void prepareForUpdate()
  {
    View localView = (View)this.mView.get();
    if (localView != null)
      computeRect(this.mBefore, localView);
  }

  private void transformMatrix(Matrix paramMatrix, View paramView)
  {
    float f1 = paramView.getWidth();
    float f2 = paramView.getHeight();
    boolean bool = this.mHasPivot;
    float f3;
    float f4;
    if (bool)
    {
      f3 = this.mPivotX;
      if (!bool)
        break label233;
      f4 = this.mPivotY;
    }
    while (true)
    {
      float f5 = this.mRotationX;
      float f6 = this.mRotationY;
      float f7 = this.mRotationZ;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        Camera localCamera = this.mCamera;
        localCamera.save();
        localCamera.rotateX(f5);
        localCamera.rotateY(f6);
        localCamera.rotateZ(-f7);
        localCamera.getMatrix(paramMatrix);
        localCamera.restore();
        paramMatrix.preTranslate(-f3, -f4);
        paramMatrix.postTranslate(f3, f4);
      }
      float f8 = this.mScaleX;
      float f9 = this.mScaleY;
      if ((f8 != 1.0F) || (f9 != 1.0F))
      {
        paramMatrix.postScale(f8, f9);
        paramMatrix.postTranslate(-(f3 / f1) * (f8 * f1 - f1), -(f4 / f2) * (f9 * f2 - f2));
      }
      paramMatrix.postTranslate(this.mTranslationX, this.mTranslationY);
      return;
      f3 = f1 / 2.0F;
      break;
      label233: f4 = f2 / 2.0F;
    }
  }

  public static AnimatorProxy wrap(View paramView)
  {
    AnimatorProxy localAnimatorProxy = (AnimatorProxy)PROXIES.get(paramView);
    if ((localAnimatorProxy == null) || (localAnimatorProxy != paramView.getAnimation()))
    {
      localAnimatorProxy = new AnimatorProxy(paramView);
      PROXIES.put(paramView, localAnimatorProxy);
    }
    return localAnimatorProxy;
  }

  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.mAlpha);
      transformMatrix(paramTransformation.getMatrix(), localView);
    }
  }

  public final float getAlpha()
  {
    return this.mAlpha;
  }

  public final float getPivotX()
  {
    return this.mPivotX;
  }

  public final float getPivotY()
  {
    return this.mPivotY;
  }

  public final float getRotation()
  {
    return this.mRotationZ;
  }

  public final float getRotationX()
  {
    return this.mRotationX;
  }

  public final float getRotationY()
  {
    return this.mRotationY;
  }

  public final float getScaleX()
  {
    return this.mScaleX;
  }

  public final float getScaleY()
  {
    return this.mScaleY;
  }

  public final int getScrollX()
  {
    View localView = (View)this.mView.get();
    if (localView == null);
    for (int i = 0; ; i = localView.getScrollX())
      return i;
  }

  public final int getScrollY()
  {
    View localView = (View)this.mView.get();
    if (localView == null);
    for (int i = 0; ; i = localView.getScrollY())
      return i;
  }

  public final float getTranslationX()
  {
    return this.mTranslationX;
  }

  public final float getTranslationY()
  {
    return this.mTranslationY;
  }

  public final float getX()
  {
    View localView = (View)this.mView.get();
    float f;
    if (localView == null)
      f = 0.0F;
    while (true)
    {
      return f;
      f = localView.getLeft() + this.mTranslationX;
    }
  }

  public final float getY()
  {
    View localView = (View)this.mView.get();
    float f;
    if (localView == null)
      f = 0.0F;
    while (true)
    {
      return f;
      f = localView.getTop() + this.mTranslationY;
    }
  }

  public final void setAlpha(float paramFloat)
  {
    if (this.mAlpha != paramFloat)
    {
      this.mAlpha = paramFloat;
      View localView = (View)this.mView.get();
      if (localView != null)
        localView.invalidate();
    }
  }

  public final void setPivotX(float paramFloat)
  {
    if ((!this.mHasPivot) || (this.mPivotX != paramFloat))
    {
      prepareForUpdate();
      this.mHasPivot = true;
      this.mPivotX = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setPivotY(float paramFloat)
  {
    if ((!this.mHasPivot) || (this.mPivotY != paramFloat))
    {
      prepareForUpdate();
      this.mHasPivot = true;
      this.mPivotY = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setRotation(float paramFloat)
  {
    if (this.mRotationZ != paramFloat)
    {
      prepareForUpdate();
      this.mRotationZ = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setRotationX(float paramFloat)
  {
    if (this.mRotationX != paramFloat)
    {
      prepareForUpdate();
      this.mRotationX = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setRotationY(float paramFloat)
  {
    if (this.mRotationY != paramFloat)
    {
      prepareForUpdate();
      this.mRotationY = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setScaleX(float paramFloat)
  {
    if (this.mScaleX != paramFloat)
    {
      prepareForUpdate();
      this.mScaleX = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setScaleY(float paramFloat)
  {
    if (this.mScaleY != paramFloat)
    {
      prepareForUpdate();
      this.mScaleY = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setScrollX(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
      localView.scrollTo(paramInt, localView.getScrollY());
  }

  public final void setScrollY(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
      localView.scrollTo(localView.getScrollX(), paramInt);
  }

  public final void setTranslationX(float paramFloat)
  {
    if (this.mTranslationX != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationX = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setTranslationY(float paramFloat)
  {
    if (this.mTranslationY != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationY = paramFloat;
      invalidateAfterUpdate();
    }
  }

  public final void setX(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
      setTranslationX(paramFloat - localView.getLeft());
  }

  public final void setY(float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
      setTranslationY(paramFloat - localView.getTop());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.view.animation.AnimatorProxy
 * JD-Core Version:    0.6.0
 */