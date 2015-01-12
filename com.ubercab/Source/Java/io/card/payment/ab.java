package io.card.payment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

final class ab extends View
{
  private static final GradientDrawable.Orientation[] a = arrayOfOrientation;
  private final WeakReference b;
  private DetectionInfo c;
  private Bitmap d;
  private Rect e;
  private CreditCard f;
  private int g;
  private int h;
  private boolean i = false;
  private String j;
  private GradientDrawable k;
  private final Paint l;
  private final Paint m;
  private Path n;
  private Rect o;
  private final ae p;
  private final Y q;
  private Rect r;
  private Rect s;
  private final boolean t;
  private int u;
  private float v = 1.0F;

  static
  {
    GradientDrawable.Orientation[] arrayOfOrientation = new GradientDrawable.Orientation[4];
    arrayOfOrientation[0] = GradientDrawable.Orientation.TOP_BOTTOM;
    arrayOfOrientation[1] = GradientDrawable.Orientation.LEFT_RIGHT;
    arrayOfOrientation[2] = GradientDrawable.Orientation.BOTTOM_TOP;
    arrayOfOrientation[3] = GradientDrawable.Orientation.RIGHT_LEFT;
  }

  public ab(CardIOActivity paramCardIOActivity, boolean paramBoolean)
  {
    super(paramCardIOActivity, null);
    this.t = paramBoolean;
    this.b = new WeakReference(paramCardIOActivity);
    this.u = 1;
    this.v = (getResources().getDisplayMetrics().density / 1.5F);
    this.p = new ae(70.0F * this.v, 50.0F * this.v);
    this.q = new Y(paramCardIOActivity);
    this.l = new Paint(1);
    this.m = new Paint(1);
    this.m.clearShadowLayer();
    this.m.setStyle(Paint.Style.FILL);
    this.m.setColor(-1157627904);
    this.j = an.a(ao.p);
  }

  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = (int)(8.0F * this.v);
    Rect localRect = new Rect();
    localRect.left = (Math.min(paramInt1, paramInt3) - i1);
    localRect.right = (i1 + Math.max(paramInt1, paramInt3));
    localRect.top = (Math.min(paramInt2, paramInt4) - i1);
    localRect.bottom = (i1 + Math.max(paramInt2, paramInt4));
    return localRect;
  }

  public static boolean c()
  {
    return false;
  }

  public final Bitmap a()
  {
    if ((this.d != null) && (!this.d.isRecycled()))
      return Bitmap.createBitmap(this.d, 0, 0, this.d.getWidth(), this.d.getHeight());
    return null;
  }

  public final void a(int paramInt)
  {
    this.h = paramInt;
  }

  public final void a(Bitmap paramBitmap)
  {
    if (this.d != null)
      this.d.recycle();
    this.d = paramBitmap;
    if (this.d != null)
    {
      RectF localRectF = new RectF(2.0F, 2.0F, -2 + this.d.getWidth(), -2 + this.d.getHeight());
      float f1 = 0.0666667F * this.d.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas1 = new Canvas(localBitmap);
      localCanvas1.drawColor(0);
      Paint localPaint1 = new Paint(1);
      localPaint1.setColor(-16777216);
      localPaint1.setStyle(Paint.Style.FILL);
      localCanvas1.drawRoundRect(localRectF, f1, f1, localPaint1);
      Paint localPaint2 = new Paint();
      localPaint2.setFilterBitmap(false);
      Canvas localCanvas2 = new Canvas(this.d);
      localPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      localCanvas2.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint2);
      localPaint2.setXfermode(null);
      localBitmap.recycle();
    }
  }

  public final void a(Rect paramRect)
  {
    this.o = paramRect;
  }

  public final void a(Rect paramRect, int paramInt)
  {
    new StringBuilder("setGuideAndRotation: ").append(paramRect).append(", ").append(paramInt).toString();
    this.g = paramInt;
    this.e = paramRect;
    invalidate();
    Point localPoint;
    if (this.g % 180 != 0)
      localPoint = new Point((int)(40.0F * this.v), (int)(60.0F * this.v));
    for (this.u = -1; ; this.u = 1)
    {
      if (this.o != null)
      {
        new StringBuilder().append(this.o).append(", ").append(localPoint).append(", ").append(this.o).append(", ").append(localPoint).toString();
        this.r = af.a(new Point(this.o.left + localPoint.x, this.o.top + localPoint.y), (int)(70.0F * this.v), (int)(50.0F * this.v));
        this.s = af.a(new Point(this.o.right - localPoint.x, this.o.top + localPoint.y), (int)(100.0F * this.v), (int)(50.0F * this.v));
        int[] arrayOfInt = { -1, -16777216 };
        this.k = new GradientDrawable(a[(this.g / 90 % 4)], arrayOfInt);
        this.k.setGradientType(0);
        this.k.setBounds(this.e);
        this.k.setAlpha(50);
        this.n = new Path();
        this.n.addRect(new RectF(this.o), Path.Direction.CW);
        this.n.addRect(new RectF(this.e), Path.Direction.CCW);
      }
      return;
      localPoint = new Point((int)(60.0F * this.v), (int)(40.0F * this.v));
    }
  }

  public final void a(CreditCard paramCreditCard)
  {
    this.f = paramCreditCard;
  }

  public final void a(DetectionInfo paramDetectionInfo)
  {
    if ((this.c != null) && (!this.c.a(paramDetectionInfo)))
      invalidate();
    this.c = paramDetectionInfo;
  }

  public final void a(boolean paramBoolean)
  {
    this.p.a(paramBoolean);
    invalidate();
  }

  public final void b()
  {
    int i1 = 0;
    if (this.d == null);
    while (true)
    {
      return;
      if (this.f.flipped)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setRotate(180.0F, this.d.getWidth() / 2, this.d.getHeight() / 2);
        this.d = Bitmap.createBitmap(this.d, 0, 0, this.d.getWidth(), this.d.getHeight(), localMatrix, false);
      }
      Canvas localCanvas = new Canvas(this.d);
      Paint localPaint = new Paint();
      af.a(localPaint);
      localPaint.setTextSize(28.0F * this.v);
      int i2 = this.f.cardNumber.length();
      float f1 = this.d.getWidth() / 428.0F;
      int i3 = (int)(f1 * this.f.yoff - 6.0F);
      while (i1 < i2)
      {
        int i4 = (int)(f1 * this.f.xoff[i1]);
        localCanvas.drawText(this.f.cardNumber.charAt(i1), i4, i3, localPaint);
        i1++;
      }
    }
  }

  public final void b(boolean paramBoolean)
  {
    this.q.a(paramBoolean);
  }

  public final Rect d()
  {
    return this.r;
  }

  public final void onDraw(Canvas paramCanvas)
  {
    if ((this.e == null) || (this.o == null));
    do
    {
      return;
      paramCanvas.save();
      this.k.draw(paramCanvas);
      if ((this.g == 0) || (this.g == 180));
      for (int i1 = (this.e.bottom - this.e.top) / 4; ; i1 = (this.e.right - this.e.left) / 4)
      {
        if ((this.c != null) && (this.c.c() == 4))
          paramCanvas.drawPath(this.n, this.m);
        this.l.clearShadowLayer();
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(this.h);
        paramCanvas.drawRect(a(this.e.left, this.e.top, i1 + this.e.left, this.e.top), this.l);
        paramCanvas.drawRect(a(this.e.left, this.e.top, this.e.left, i1 + this.e.top), this.l);
        paramCanvas.drawRect(a(this.e.right, this.e.top, this.e.right - i1, this.e.top), this.l);
        paramCanvas.drawRect(a(this.e.right, this.e.top, this.e.right, i1 + this.e.top), this.l);
        paramCanvas.drawRect(a(this.e.left, this.e.bottom, i1 + this.e.left, this.e.bottom), this.l);
        paramCanvas.drawRect(a(this.e.left, this.e.bottom, this.e.left, this.e.bottom - i1), this.l);
        paramCanvas.drawRect(a(this.e.right, this.e.bottom, this.e.right - i1, this.e.bottom), this.l);
        paramCanvas.drawRect(a(this.e.right, this.e.bottom, this.e.right, this.e.bottom - i1), this.l);
        if (this.c == null)
          break;
        if (this.c.topEdge)
          paramCanvas.drawRect(a(this.e.left, this.e.top, this.e.right, this.e.top), this.l);
        if (this.c.bottomEdge)
          paramCanvas.drawRect(a(this.e.left, this.e.bottom, this.e.right, this.e.bottom), this.l);
        if (this.c.leftEdge)
          paramCanvas.drawRect(a(this.e.left, this.e.top, this.e.left, this.e.bottom), this.l);
        if (this.c.rightEdge)
          paramCanvas.drawRect(a(this.e.right, this.e.top, this.e.right, this.e.bottom), this.l);
        if (this.c.c() >= 3)
          break;
        float f1 = 34.0F * this.v;
        float f2 = 26.0F * this.v;
        af.a(this.l);
        this.l.setTextAlign(Paint.Align.CENTER);
        this.l.setTextSize(f2);
        paramCanvas.translate(this.e.left + this.e.width() / 2, this.e.top + this.e.height() / 2);
        paramCanvas.rotate(this.u * this.g);
        if ((this.j == null) || (this.j == ""))
          break;
        String[] arrayOfString = this.j.split("\n");
        float f3 = -((f1 * (-1 + arrayOfString.length) - f2) / 2.0F) - 3.0F;
        for (int i2 = 0; i2 < arrayOfString.length; i2++)
        {
          paramCanvas.drawText(arrayOfString[i2], 0.0F, f3, this.l);
          f3 += f1;
        }
      }
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(this.s.exactCenterX(), this.s.exactCenterY());
      paramCanvas.rotate(this.u * this.g);
      this.q.a(paramCanvas, 100.0F * this.v, 50.0F * this.v);
      paramCanvas.restore();
    }
    while (!this.t);
    paramCanvas.save();
    paramCanvas.translate(this.r.exactCenterX(), this.r.exactCenterY());
    paramCanvas.rotate(this.u * this.g);
    this.p.a(paramCanvas);
    paramCanvas.restore();
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if ((0xFF & paramMotionEvent.getAction()) == 0)
      {
        Point localPoint = new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        Rect localRect = af.a(localPoint, 20, 20);
        new StringBuilder("onTouchEvent: ").append(localPoint).toString();
        if ((this.t) && (this.r != null) && (Rect.intersects(this.r, localRect)))
          ((CardIOActivity)this.b.get()).b();
        else if ((this.s == null) || (!Rect.intersects(this.s, localRect)))
          ((CardIOActivity)this.b.get()).c();
      }
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ab
 * JD-Core Version:    0.6.2
 */