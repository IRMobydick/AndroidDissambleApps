package android.support.v4.widget;

import android.support.v4.view.m;
import android.support.v4.view.s;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class y
{
  private static final Interpolator v = new z();
  private int a;
  private int b;
  private int c;
  private float[] d;
  private float[] e;
  private float[] f;
  private float[] g;
  private int[] h;
  private int[] i;
  private int[] j;
  private int k;
  private VelocityTracker l;
  private float m;
  private float n;
  private int o;
  private int p;
  private j q;
  private final aa r;
  private View s;
  private boolean t;
  private final ViewGroup u;
  private final Runnable w;

  private float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2)
      paramFloat3 = 0.0F;
    while (true)
    {
      return paramFloat3;
      if (f1 > paramFloat3)
      {
        if (paramFloat1 > 0.0F)
          continue;
        paramFloat3 = -paramFloat3;
        continue;
      }
      paramFloat3 = paramFloat1;
    }
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i5;
    if (paramInt1 == 0)
    {
      i5 = 0;
      return i5;
    }
    int i1 = this.u.getWidth();
    int i2 = i1 / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f2 = i2 + i2 * a(f1);
    int i3 = Math.abs(paramInt2);
    if (i3 > 0);
    for (int i4 = 4 * Math.round(1000.0F * Math.abs(f2 / i3)); ; i4 = (int)(256.0F * (1.0F + Math.abs(paramInt1) / paramInt3)))
    {
      i5 = Math.min(i4, 600);
      break;
    }
  }

  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = b(paramInt3, (int)this.n, (int)this.m);
    int i2 = b(paramInt4, (int)this.n, (int)this.m);
    int i3 = Math.abs(paramInt1);
    int i4 = Math.abs(paramInt2);
    int i5 = Math.abs(i1);
    int i6 = Math.abs(i2);
    int i7 = i5 + i6;
    int i8 = i3 + i4;
    float f1;
    float f2;
    if (i1 != 0)
    {
      f1 = i5 / i7;
      if (i2 == 0)
        break label165;
      f2 = i6 / i7;
    }
    while (true)
    {
      int i9 = a(paramInt1, i1, this.r.a(paramView));
      int i10 = a(paramInt2, i2, this.r.b(paramView));
      return (int)(f1 * i9 + f2 * i10);
      f1 = i3 / i8;
      break;
      label165: f2 = i4 / i8;
    }
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    this.t = true;
    this.r.a(this.s, paramFloat1, paramFloat2);
    this.t = false;
    if (this.a == 1)
      b(0);
  }

  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    e(paramInt);
    float[] arrayOfFloat1 = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat1[paramInt] = paramFloat1;
    float[] arrayOfFloat2 = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat2[paramInt] = paramFloat2;
    this.h[paramInt] = e((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }

  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    float f1 = Math.abs(paramFloat1);
    float f2 = Math.abs(paramFloat2);
    if (((paramInt2 & this.h[paramInt1]) != paramInt2) || ((paramInt2 & this.p) == 0) || ((paramInt2 & this.j[paramInt1]) == paramInt2) || ((paramInt2 & this.i[paramInt1]) == paramInt2) || ((f1 <= this.b) && (f2 <= this.b)));
    while (true)
    {
      return i1;
      if ((f1 < f2 * 0.5F) && (this.r.b(paramInt2)))
      {
        int[] arrayOfInt = this.j;
        arrayOfInt[paramInt1] = (paramInt2 | arrayOfInt[paramInt1]);
        continue;
      }
      if (((paramInt2 & this.i[paramInt1]) != 0) || (f1 <= this.b))
        continue;
      i1 = 1;
    }
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    int i2 = this.s.getLeft();
    int i3 = this.s.getTop();
    int i4 = paramInt1 - i2;
    int i5 = paramInt2 - i3;
    if ((i4 == 0) && (i5 == 0))
    {
      this.q.g();
      b(0);
    }
    while (true)
    {
      return i1;
      int i6 = a(this.s, i4, i5, paramInt3, paramInt4);
      this.q.a(i2, i3, i4, i5, i6);
      b(2);
      i1 = 1;
    }
  }

  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int i1 = 1;
    if (paramView == null)
      i1 = 0;
    while (true)
    {
      return i1;
      int i2;
      if (this.r.a(paramView) > 0)
      {
        i2 = i1;
        label28: if (this.r.b(paramView) <= 0)
          break label86;
      }
      label86: for (int i3 = i1; ; i3 = 0)
      {
        if ((i2 == 0) || (i3 == 0))
          break label92;
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.b * this.b)
          break;
        i1 = 0;
        break;
        i2 = 0;
        break label28;
      }
      label92: if (i2 != 0)
      {
        if (Math.abs(paramFloat1) > this.b)
          continue;
        i1 = 0;
        continue;
      }
      if (i3 != 0)
      {
        if (Math.abs(paramFloat2) > this.b)
          continue;
        i1 = 0;
        continue;
      }
      i1 = 0;
    }
  }

  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2)
      paramInt3 = 0;
    while (true)
    {
      return paramInt3;
      if (i1 > paramInt3)
      {
        if (paramInt1 > 0)
          continue;
        paramInt3 = -paramInt3;
        continue;
      }
      paramInt3 = paramInt1;
    }
  }

  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i1 = 1;
    if (a(paramFloat1, paramFloat2, paramInt, i1));
    while (true)
    {
      if (a(paramFloat2, paramFloat1, paramInt, 4))
        i1 |= 4;
      if (a(paramFloat1, paramFloat2, paramInt, 2))
        i1 |= 2;
      if (a(paramFloat2, paramFloat1, paramInt, 8))
        i1 |= 8;
      if (i1 != 0)
      {
        int[] arrayOfInt = this.i;
        arrayOfInt[paramInt] = (i1 | arrayOfInt[paramInt]);
        this.r.b(i1, paramInt);
      }
      return;
      i1 = 0;
    }
  }

  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.s.getLeft();
    int i2 = this.s.getTop();
    int i3;
    if (paramInt3 != 0)
    {
      i3 = this.r.a(this.s, paramInt1, paramInt3);
      this.s.offsetLeftAndRight(i3 - i1);
    }
    while (true)
    {
      int i4;
      if (paramInt4 != 0)
      {
        i4 = this.r.b(this.s, paramInt2, paramInt4);
        this.s.offsetTopAndBottom(i4 - i2);
      }
      while (true)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0))
        {
          int i5 = i3 - i1;
          int i6 = i4 - i2;
          this.r.a(this.s, i3, i4, i5, i6);
        }
        return;
        i4 = paramInt2;
      }
      i3 = paramInt1;
    }
  }

  private void c(MotionEvent paramMotionEvent)
  {
    int i1 = m.c(paramMotionEvent);
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = m.b(paramMotionEvent, i2);
      float f1 = m.c(paramMotionEvent, i2);
      float f2 = m.d(paramMotionEvent, i2);
      this.f[i3] = f1;
      this.g[i3] = f2;
    }
  }

  private void d(int paramInt)
  {
    if (this.d == null);
    while (true)
    {
      return;
      this.d[paramInt] = 0.0F;
      this.e[paramInt] = 0.0F;
      this.f[paramInt] = 0.0F;
      this.g[paramInt] = 0.0F;
      this.h[paramInt] = 0;
      this.i[paramInt] = 0;
      this.j[paramInt] = 0;
      this.k &= (0xFFFFFFFF ^ 1 << paramInt);
    }
  }

  private int e(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (paramInt1 < this.u.getLeft() + this.o)
      i1 = 1;
    if (paramInt2 < this.u.getTop() + this.o)
      i1 |= 4;
    if (paramInt1 > this.u.getRight() - this.o)
      i1 |= 2;
    if (paramInt2 > this.u.getBottom() - this.o)
      i1 |= 8;
    return i1;
  }

  private void e(int paramInt)
  {
    if ((this.d == null) || (this.d.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.d != null)
      {
        System.arraycopy(this.d, 0, arrayOfFloat1, 0, this.d.length);
        System.arraycopy(this.e, 0, arrayOfFloat2, 0, this.e.length);
        System.arraycopy(this.f, 0, arrayOfFloat3, 0, this.f.length);
        System.arraycopy(this.g, 0, arrayOfFloat4, 0, this.g.length);
        System.arraycopy(this.h, 0, arrayOfInt1, 0, this.h.length);
        System.arraycopy(this.i, 0, arrayOfInt2, 0, this.i.length);
        System.arraycopy(this.j, 0, arrayOfInt3, 0, this.j.length);
      }
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.g = arrayOfFloat4;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    }
  }

  private void g()
  {
    if (this.d == null);
    while (true)
    {
      return;
      Arrays.fill(this.d, 0.0F);
      Arrays.fill(this.e, 0.0F);
      Arrays.fill(this.f, 0.0F);
      Arrays.fill(this.g, 0.0F);
      Arrays.fill(this.h, 0);
      Arrays.fill(this.i, 0);
      Arrays.fill(this.j, 0);
      this.k = 0;
    }
  }

  private void h()
  {
    this.l.computeCurrentVelocity(1000, this.m);
    a(a(s.a(this.l, this.c), this.n, this.m), a(s.b(this.l, this.c), this.n, this.m));
  }

  public int a()
  {
    return this.a;
  }

  public void a(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.u)
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    this.s = paramView;
    this.c = paramInt;
    this.r.b(paramView, paramInt);
    b(1);
  }

  public boolean a(int paramInt)
  {
    int i1 = 1;
    if ((this.k & i1 << paramInt) != 0);
    while (true)
    {
      return i1;
      i1 = 0;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    if (!this.t)
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    return a(paramInt1, paramInt2, (int)s.a(this.l, this.c), (int)s.b(this.l, this.c));
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    int i2 = m.a(paramMotionEvent);
    int i3 = m.b(paramMotionEvent);
    if (i2 == 0)
      e();
    if (this.l == null)
      this.l = VelocityTracker.obtain();
    this.l.addMovement(paramMotionEvent);
    switch (i2)
    {
    case 4:
    default:
      if (this.a != i1)
        break;
    case 0:
    case 5:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    while (true)
    {
      return i1;
      float f7 = paramMotionEvent.getX();
      float f8 = paramMotionEvent.getY();
      int i9 = m.b(paramMotionEvent, 0);
      a(f7, f8, i9);
      View localView3 = d((int)f7, (int)f8);
      if ((localView3 == this.s) && (this.a == 2))
        b(localView3, i9);
      int i10 = this.h[i9];
      if ((i10 & this.p) == 0)
        break;
      this.r.a(i10 & this.p, i9);
      break;
      int i7 = m.b(paramMotionEvent, i3);
      float f5 = m.c(paramMotionEvent, i3);
      float f6 = m.d(paramMotionEvent, i3);
      a(f5, f6, i7);
      if (this.a == 0)
      {
        int i8 = this.h[i7];
        if ((i8 & this.p) == 0)
          break;
        this.r.a(i8 & this.p, i7);
        break;
      }
      if (this.a != 2)
        break;
      View localView2 = d((int)f5, (int)f6);
      if (localView2 != this.s)
        break;
      b(localView2, i7);
      break;
      int i4 = m.c(paramMotionEvent);
      for (int i5 = 0; ; i5++)
      {
        int i6;
        float f1;
        float f2;
        float f3;
        float f4;
        if (i5 < i4)
        {
          i6 = m.b(paramMotionEvent, i5);
          f1 = m.c(paramMotionEvent, i5);
          f2 = m.d(paramMotionEvent, i5);
          f3 = f1 - this.d[i6];
          f4 = f2 - this.e[i6];
          b(f3, f4, i6);
          if (this.a != i1)
            break label413;
        }
        label413: View localView1;
        do
        {
          c(paramMotionEvent);
          break;
          localView1 = d((int)f1, (int)f2);
        }
        while ((localView1 != null) && (a(localView1, f3, f4)) && (b(localView1, i6)));
      }
      d(m.b(paramMotionEvent, i3));
      break;
      e();
      break;
      i1 = 0;
    }
  }

  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    this.s = paramView;
    this.c = -1;
    return a(paramInt1, paramInt2, 0, 0);
  }

  public boolean a(boolean paramBoolean)
  {
    boolean bool1;
    if (this.a == 2)
    {
      bool1 = this.q.f();
      int i2 = this.q.b();
      int i3 = this.q.c();
      int i4 = i2 - this.s.getLeft();
      int i5 = i3 - this.s.getTop();
      if (i4 != 0)
        this.s.offsetLeftAndRight(i4);
      if (i5 != 0)
        this.s.offsetTopAndBottom(i5);
      if ((i4 != 0) || (i5 != 0))
        this.r.a(this.s, i2, i3, i4, i5);
      if ((!bool1) || (i2 != this.q.d()) || (i3 != this.q.e()))
        break label205;
      this.q.g();
    }
    label200: label205: for (boolean bool2 = this.q.a(); ; bool2 = bool1)
    {
      if (!bool2)
      {
        if (paramBoolean)
          this.u.post(this.w);
      }
      else
        if (this.a != 2)
          break label200;
      for (int i1 = 1; ; i1 = 0)
      {
        return i1;
        b(0);
        break;
      }
    }
  }

  public int b()
  {
    return this.o;
  }

  void b(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      this.r.a(paramInt);
      if (paramInt == 0)
        this.s = null;
    }
  }

  public void b(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    int i2 = m.a(paramMotionEvent);
    int i3 = m.b(paramMotionEvent);
    if (i2 == 0)
      e();
    if (this.l == null)
      this.l = VelocityTracker.obtain();
    this.l.addMovement(paramMotionEvent);
    label483: int i4;
    switch (i2)
    {
    case 4:
    default:
    case 0:
    case 5:
    case 2:
      while (true)
      {
        return;
        float f11 = paramMotionEvent.getX();
        float f12 = paramMotionEvent.getY();
        int i15 = m.b(paramMotionEvent, 0);
        View localView2 = d((int)f11, (int)f12);
        a(f11, f12, i15);
        b(localView2, i15);
        int i16 = this.h[i15];
        if ((i16 & this.p) == 0)
          continue;
        this.r.a(i16 & this.p, i15);
        continue;
        int i13 = m.b(paramMotionEvent, i3);
        float f9 = m.c(paramMotionEvent, i3);
        float f10 = m.d(paramMotionEvent, i3);
        a(f9, f10, i13);
        if (this.a == 0)
        {
          b(d((int)f9, (int)f10), i13);
          int i14 = this.h[i13];
          if ((i14 & this.p) == 0)
            continue;
          this.r.a(i14 & this.p, i13);
          continue;
        }
        if (!c((int)f9, (int)f10))
          continue;
        b(this.s, i13);
        continue;
        if (this.a != 1)
          break;
        int i10 = m.a(paramMotionEvent, this.c);
        float f7 = m.c(paramMotionEvent, i10);
        float f8 = m.d(paramMotionEvent, i10);
        int i11 = (int)(f7 - this.f[this.c]);
        int i12 = (int)(f8 - this.g[this.c]);
        b(i11 + this.s.getLeft(), i12 + this.s.getTop(), i11, i12);
        c(paramMotionEvent);
      }
      int i8 = m.c(paramMotionEvent);
      while (true)
      {
        int i9;
        float f3;
        float f4;
        float f5;
        float f6;
        if (i1 < i8)
        {
          i9 = m.b(paramMotionEvent, i1);
          f3 = m.c(paramMotionEvent, i1);
          f4 = m.d(paramMotionEvent, i1);
          f5 = f3 - this.d[i9];
          f6 = f4 - this.e[i9];
          b(f5, f6, i9);
          if (this.a != 1)
            break label483;
        }
        View localView1;
        do
        {
          c(paramMotionEvent);
          break;
          localView1 = d((int)f3, (int)f4);
        }
        while ((a(localView1, f5, f6)) && (b(localView1, i9)));
        i1++;
      }
    case 6:
      i4 = m.b(paramMotionEvent, i3);
      if ((this.a != 1) || (i4 != this.c))
        break;
      int i5 = m.c(paramMotionEvent);
      if (i1 < i5)
      {
        int i7 = m.b(paramMotionEvent, i1);
        if (i7 == this.c);
        float f1;
        float f2;
        do
        {
          i1++;
          break;
          f1 = m.c(paramMotionEvent, i1);
          f2 = m.d(paramMotionEvent, i1);
        }
        while ((d((int)f1, (int)f2) != this.s) || (!b(this.s, i7)));
      }
    case 1:
    case 3:
    }
    for (int i6 = this.c; ; i6 = -1)
    {
      if (i6 == -1)
        h();
      d(i4);
      break;
      if (this.a == 1)
        h();
      e();
      break;
      if (this.a == 1)
        a(0.0F, 0.0F);
      e();
      break;
    }
  }

  public boolean b(int paramInt1, int paramInt2)
  {
    int i1 = 1;
    if (!a(paramInt2))
      i1 = 0;
    while (true)
    {
      return i1;
      int i2;
      if ((paramInt1 & 0x1) == i1)
      {
        i2 = i1;
        label24: if ((paramInt1 & 0x2) != 2)
          break label110;
      }
      float f1;
      float f2;
      label110: for (int i3 = i1; ; i3 = 0)
      {
        f1 = this.f[paramInt2] - this.d[paramInt2];
        f2 = this.g[paramInt2] - this.e[paramInt2];
        if ((i2 == 0) || (i3 == 0))
          break label116;
        if (f1 * f1 + f2 * f2 > this.b * this.b)
          break;
        i1 = 0;
        break;
        i2 = 0;
        break label24;
      }
      label116: if (i2 != 0)
      {
        if (Math.abs(f1) > this.b)
          continue;
        i1 = 0;
        continue;
      }
      if (i3 != 0)
      {
        if (Math.abs(f2) > this.b)
          continue;
        i1 = 0;
        continue;
      }
      i1 = 0;
    }
  }

  boolean b(View paramView, int paramInt)
  {
    int i1 = 1;
    if ((paramView == this.s) && (this.c == paramInt));
    while (true)
    {
      return i1;
      if ((paramView != null) && (this.r.a(paramView, paramInt)))
      {
        this.c = paramInt;
        a(paramView, paramInt);
        continue;
      }
      i1 = 0;
    }
  }

  public boolean b(View paramView, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (paramView == null);
    while (true)
    {
      return i1;
      if ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom()))
        continue;
      i1 = 1;
    }
  }

  public View c()
  {
    return this.s;
  }

  public boolean c(int paramInt)
  {
    int i1 = 0;
    int i2 = this.d.length;
    for (int i3 = 0; ; i3++)
    {
      if (i3 < i2)
      {
        if (!b(paramInt, i3))
          continue;
        i1 = 1;
      }
      return i1;
    }
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return b(this.s, paramInt1, paramInt2);
  }

  public int d()
  {
    return this.b;
  }

  public View d(int paramInt1, int paramInt2)
  {
    int i1 = -1 + this.u.getChildCount();
    View localView;
    if (i1 >= 0)
    {
      localView = this.u.getChildAt(this.r.c(i1));
      if ((paramInt1 < localView.getLeft()) || (paramInt1 >= localView.getRight()) || (paramInt2 < localView.getTop()) || (paramInt2 >= localView.getBottom()));
    }
    while (true)
    {
      return localView;
      i1--;
      break;
      localView = null;
    }
  }

  public void e()
  {
    this.c = -1;
    g();
    if (this.l != null)
    {
      this.l.recycle();
      this.l = null;
    }
  }

  public void f()
  {
    e();
    if (this.a == 2)
    {
      int i1 = this.q.b();
      int i2 = this.q.c();
      this.q.g();
      int i3 = this.q.b();
      int i4 = this.q.c();
      this.r.a(this.s, i3, i4, i3 - i1, i4 - i2);
    }
    b(0);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.y
 * JD-Core Version:    0.6.0
 */