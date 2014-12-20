package net.photopay.secured;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import net.photopay.geometry.IllIIIllII;
import net.photopay.geometry.Point;
import net.photopay.geometry.llIIlIlIIl;
import net.photopay.hardware.camera.CameraType;
import net.photopay.nineoldandroids.animation.ValueAnimator;
import net.photopay.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import net.photopay.util.FakeR;
import net.photopay.util.Log;
import net.photopay.view.viewfinder.AbstractViewFinder;

public final class llIllIIlll extends View
  implements ValueAnimator.AnimatorUpdateListener
{
  private static int IIIIlIllIl;
  private static int IlIIIlIIIl = 3;
  private int IIlIIlIllI = -1;
  private boolean IIllIIllll = false;
  private int IlIIlllIll = 0;
  private Paint jdField_IlIllIlIIl_of_type_AndroidGraphicsPaint;
  private IllIIIllII jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII = null;
  private Paint IllIIIllII;
  private int IllIllIllI = -1;
  private int lIlIIIlIll = -1;
  private boolean lIlIllIIlI = true;
  private float lIllIIlIIl = -1.0F;
  private float lIlllIlIlI = -1.0F;
  private AbstractViewFinder llIIIlllll = null;
  private Resources jdField_llIIlIlIIl_of_type_AndroidContentResResources = null;
  private Paint jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint;
  private IllIIIllII jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII = null;
  private llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl = null;
  private ValueAnimator jdField_llIIlIlIIl_of_type_NetPhotopayNineoldandroidsAnimationValueAnimator = null;
  private FakeR jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = null;
  private int llIIllIlII = -1;
  private int lllIIIllII = -1;
  private float lllIIlIIlI;
  private int llllIllllI = -1;
  private int lllllIlIll = -1;
  private final Handler mHandler = new Handler();
  private int mHeight = -1;

  static
  {
    IIIIlIllIl = 15;
  }

  public llIllIIlll(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = new FakeR(paramContext);
    this.jdField_llIIlIlIIl_of_type_AndroidContentResResources = getResources();
    this.lllIIlIIlI = this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getDisplayMetrics().density;
    this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint = new Paint(1);
    int i = (49 + paramContext.getResources().getDisplayMetrics().densityDpi) / 50;
    IlIIIlIIIl = i;
    IIIIlIllIl = i * 2;
    this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setStrokeWidth(IlIIIlIIIl);
    this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.jdField_IlIllIlIIl_of_type_AndroidGraphicsPaint = new Paint(this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint);
    IllIIIllII.IlIllIlIIl = this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("color", "default_frame"));
    this.jdField_IlIllIlIIl_of_type_AndroidGraphicsPaint.setColor(this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("color", "formDetect_frame")));
    this.IllIIIllII = new Paint(1);
    this.IllIIIllII.setColor(Color.argb(119, 255, 255, 255));
    setOnTouchListener(new llIllIIlll.1(this));
  }

  private void startAnimation()
  {
    this.mHandler.post(new llIllIIlll.2(this));
  }

  public final void IIlIlllIIl()
  {
    monitorenter;
    int i = 0;
    try
    {
      if (this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII != null)
        i = this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.llIIlIlIIl();
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII = new IllIIIllII(this.IllIllIllI, this.lllIIIllII, this.IIlIIlIllI, this.llIIllIlII);
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.IllIIIllII();
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.llIIlIlIIl(i);
      if (this.IllIllIllI != this.lllIIIllII)
        startAnimation();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl = null;
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

  protected final void IlIlllllII(boolean paramBoolean)
  {
    this.lIlIllIIlI = paramBoolean;
  }

  public final void IllIIIIllI(int paramInt)
  {
    this.IlIIlllIll = paramInt;
  }

  public final void displayAutofocusFailed()
  {
    this.mHandler.post(new llIllIIlll.3(this));
  }

  public final boolean isAnimationInProgress()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayNineoldandroidsAnimationValueAnimator != null);
    for (boolean bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayNineoldandroidsAnimationValueAnimator.isRunning(); ; bool = false)
      return bool;
  }

  public final void lIlIIIIlIl(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 8) || (paramInt == 32))
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.setColor(this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("color", "recognized_frame")));
    while (true)
    {
      if (this.IllIllIllI != this.lllIIIllII)
        startAnimation();
      return;
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.setColor(this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("color", "default_frame")));
    }
  }

  public final void llIIlIlIIl(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4, int paramInt)
  {
    monitorenter;
    try
    {
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII = IllIIIllII.llIIlIlIIl(paramPoint1, paramPoint2, paramPoint3, paramPoint4, this.lllllIlIll, this.mHeight);
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.llIIlIlIIl(paramInt);
      if ((this.llIIIlllll != null) && (this.llIIIlllll.getCameraType() == CameraType.CAMERA_FRONTFACE))
        this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.llIIlIlIIl(this.lllllIlIll, this.mHeight);
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl = null;
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

  public final void llIIlIlIIl(AbstractViewFinder paramAbstractViewFinder)
  {
    this.llIIIlllll = paramAbstractViewFinder;
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator == this.jdField_llIIlIlIIl_of_type_NetPhotopayNineoldandroidsAnimationValueAnimator)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII = ((IllIIIllII)paramValueAnimator.getAnimatedValue());
    invalidate();
  }

  protected final void onDraw(Canvas paramCanvas)
  {
    int i;
    if (this.lllIIIllII <= 0)
      i = 1;
    while (true)
    {
      if (this.lllllIlIll == -1)
        this.lllllIlIll = paramCanvas.getWidth();
      if (this.llllIllllI <= 0)
        this.llllIllllI = paramCanvas.getWidth();
      if (this.lIlIIIlIll <= 0)
        this.lIlIIIlIll = paramCanvas.getHeight();
      if (this.mHeight == -1)
        this.mHeight = paramCanvas.getHeight();
      int j = (int)(0.89D * this.lllllIlIll);
      int k = (int)(0.89D * this.mHeight);
      this.IllIllIllI = ((this.mHeight - k) / 2);
      this.IIlIIlIllI = ((this.lllllIlIll - j) / 2);
      this.llIIllIlII = (this.lllllIlIll - this.IIlIIlIllI);
      this.lllIIIllII = (this.mHeight - this.IllIllIllI);
      if (i != 0)
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII = new IllIIIllII(this.IllIllIllI, this.lllIIIllII, this.IIlIIlIllI, this.llIIllIlII);
        this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII.setColor(this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("color", "default_frame")));
        this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII.IllIIIllII();
        this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII.llIIlIlIIl();
      }
      monitorenter;
      try
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryIllIIIllII.draw(paramCanvas, this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint);
        llIIlIlIIl localllIIlIlIIl;
        Paint localPaint1;
        if (this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl != null)
        {
          this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setColor(this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryIllIIIllII.getColor());
          localllIIlIlIIl = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl;
          localPaint1 = this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint;
          if (!this.IIllIIllll)
            break label1029;
        }
        label1029: for (Paint localPaint2 = this.jdField_IlIllIlIIl_of_type_AndroidGraphicsPaint; ; localPaint2 = this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint)
        {
          localllIIlIlIIl.llIIlIlIIl(paramCanvas, localPaint1, localPaint2, IIIIlIllIl);
          monitorexit;
          this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setAlpha(32);
          this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setStrokeWidth(1.5F * IlIIIlIIIl);
          paramCanvas.drawLine(0.0F, this.mHeight / 2, this.lllllIlIll, this.mHeight / 2, this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint);
          paramCanvas.drawLine(this.lllllIlIll / 2, 0.0F, this.lllllIlIll / 2, this.mHeight, this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint);
          this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setAlpha(255);
          this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setStrokeWidth(IlIIIlIIIl / 2);
          paramCanvas.drawLine(0.0F, this.mHeight / 2, this.lllllIlIll, this.mHeight / 2, this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint);
          paramCanvas.drawLine(this.lllllIlIll / 2, 0.0F, this.lllllIlIll / 2, this.mHeight, this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint);
          this.jdField_llIIlIlIIl_of_type_AndroidGraphicsPaint.setStrokeWidth(IlIIIlIIIl);
          if (this.lIlIllIIlI)
          {
            this.IllIIIllII.setShadowLayer(1.0F * this.lllIIlIIlI, 0.5F * this.lllIIlIIlI, 0.5F * this.lllIIlIIlI, Color.argb(110, 0, 0, 0));
            this.IllIIIllII.setTextSize(0.06F * (this.lllIIIllII - this.IllIllIllI));
            this.IllIIIllII.setColor(Color.argb(220, 43, 43, 43));
            float f1 = this.IllIIIllII.measureText("pdf417.mobi");
            float f2 = this.IllIIIllII.measureText("pdf417");
            float f3 = this.lllIIIllII - 3.0F * this.IllIIIllII.getTextSize();
            this.lIlllIlIlI = (f3 - this.IllIIIllII.getTextSize());
            paramCanvas.drawText("pdf417", (this.IIlIIlIllI + this.llIIllIlII) / 2.0F - f1 / 2.0F, f3, this.IllIIIllII);
            this.IllIIIllII.setColor(Color.argb(220, 144, 144, 144));
            paramCanvas.drawText(".mobi", f2 + ((this.IIlIIlIllI + this.llIIllIlII) / 2.0F - f1 / 2.0F), f3, this.IllIIIllII);
            this.IllIIIllII.setColor(Color.argb(220, 0, 0, 0));
            float f4 = (float)(f3 + 1.2D * this.IllIIIllII.getTextSize());
            this.IllIIIllII.setTextSize(0.9F * this.IllIIIllII.getTextSize());
            float f5 = this.IllIIIllII.measureText("by PhotoPay");
            float f6 = this.IllIIIllII.measureText("by ");
            float f7 = this.IllIIIllII.measureText("Photo");
            paramCanvas.drawText("by ", (this.IIlIIlIllI + this.llIIllIlII) / 2.0F - f5 / 2.0F, f4, this.IllIIIllII);
            this.IllIIIllII.setColor(Color.argb(255, 205, 45, 61));
            paramCanvas.drawText("Photo", f6 + ((this.IIlIIlIllI + this.llIIllIlII) / 2.0F - f5 / 2.0F), f4, this.IllIIIllII);
            this.IllIIIllII.setColor(Color.argb(255, 52, 47, 49));
            paramCanvas.drawText("Pay", f7 + (f6 + ((this.IIlIIlIllI + this.llIIllIlII) / 2.0F - f5 / 2.0F)), f4, this.IllIIIllII);
            this.IllIIIllII.setColor(Color.argb(220, 144, 144, 144));
            float f8 = f4 + 1.3F * this.IllIIIllII.getTextSize();
            this.IllIIIllII.setTextSize(0.7F * this.IllIIIllII.getTextSize());
            float f9 = this.IllIIIllII.measureText("free for non-commercial use");
            paramCanvas.drawText("free for non-commercial use", (this.IIlIIlIllI + this.llIIllIlII) / 2.0F - f9 / 2.0F, f8, this.IllIIIllII);
            this.lIllIIlIIl = f8;
          }
          return;
          i = 0;
          break;
        }
      }
      finally
      {
        monitorexit;
      }
    }
    throw localObject;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.lllllIlIll = getWidth();
    this.mHeight = getHeight();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.lllllIlIll);
    arrayOfObject[1] = Integer.valueOf(this.mHeight);
    Log.i(this, "DefaultBarcodeViewfinder layouting to size: {}x{}", arrayOfObject);
  }

  public final void setPointSet(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl = new llIIlIlIIl(paramArrayOfFloat, this.lllllIlIll, this.mHeight);
      if ((this.llIIIlllll != null) && (this.llIIIlllll.getCameraType() == CameraType.CAMERA_FRONTFACE))
        this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryLlIIlIlIIl.llIIlIlIIl(this.lllllIlIll, this.mHeight);
      this.IIllIIllll = paramBoolean;
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
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIllIIlll
 * JD-Core Version:    0.6.0
 */