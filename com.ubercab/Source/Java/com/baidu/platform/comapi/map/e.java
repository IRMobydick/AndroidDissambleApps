package com.baidu.platform.comapi.map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.util.FloatMath;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.platform.comjni.map.basemap.BaseMapCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class e extends GLSurfaceView
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a, com.baidu.platform.comjni.map.basemap.b
{
  private static final String c = e.class.getSimpleName();
  private boolean A;
  private int B;
  private int C;
  private int D;
  private int E;
  private a F = new a();
  private VelocityTracker G;
  private GestureDetector H;
  private long I;
  private long J;
  private long K;
  private long L;
  private int M;
  private float N;
  private float O;
  private boolean P;
  private long Q;
  private long R;
  private boolean S;
  private boolean T;
  private boolean U;
  public float a = 19.0F;
  public float b = 3.0F;
  private boolean d;
  private boolean e;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = true;
  private boolean j = true;
  private boolean k = true;
  private boolean l = true;
  private Context m;
  private MapRenderer n;
  private List<g> o;
  private com.baidu.platform.comjni.map.basemap.a p;
  private int q;
  private Handler r;
  private List<a> s;
  private t t;
  private c u;
  private h v;
  private A w;
  private i x;
  private j y;
  private y z;

  public e(Context paramContext, v paramv)
  {
    super(paramContext);
    this.m = paramContext;
    if (paramContext == null)
      throw new RuntimeException("when you create an mapview, the context can not be null");
    this.H = new GestureDetector(paramContext, this);
    com.baidu.mapapi.utils.b.a(paramContext);
    q();
    r();
    a();
    BaseMapCallback.addLayerDataInterface(this.q, this);
    a(paramv);
    this.o = new ArrayList();
    s();
    t();
    v();
  }

  private void A()
  {
    this.T = false;
    this.S = false;
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((g)localIterator.next()).c(m());
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return com.baidu.platform.comjni.map.basemap.a.b(this.q, paramInt1, paramInt2, paramInt3);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getPointerCount();
    if ((i1 == 2) && ((!b((int)paramMotionEvent.getX(0), (int)paramMotionEvent.getY(0))) || (!b((int)paramMotionEvent.getX(1), (int)paramMotionEvent.getY(1)))))
      i1 = 1;
    if (i1 == 2)
    {
      float f1 = this.C - paramMotionEvent.getY(0);
      float f2 = this.C - paramMotionEvent.getY(1);
      float f3 = paramMotionEvent.getX(0);
      float f4 = paramMotionEvent.getX(1);
      switch (paramMotionEvent.getAction())
      {
      default:
        if (this.G == null)
          this.G = VelocityTracker.obtain();
        this.G.addMovement(paramMotionEvent);
        int i2 = ViewConfiguration.getMinimumFlingVelocity();
        int i3 = ViewConfiguration.getMaximumFlingVelocity();
        this.G.computeCurrentVelocity(1000, i3);
        float f5 = this.G.getXVelocity(1);
        float f6 = this.G.getYVelocity(1);
        float f7 = this.G.getXVelocity(2);
        float f8 = this.G.getYVelocity(2);
        if ((Math.abs(f5) <= i2) && (Math.abs(f6) <= i2) && (Math.abs(f7) <= i2) && (Math.abs(f8) <= i2))
          break label1372;
        if (this.F.e != true)
          break label678;
        if (this.D != 0)
          break label620;
        if (((this.F.c - f1 > 0.0F) && (this.F.d - f2 > 0.0F)) || ((this.F.c - f1 < 0.0F) && (this.F.d - f2 < 0.0F)))
        {
          d6 = Math.atan2(f2 - f1, f4 - f3) - Math.atan2(this.F.d - this.F.c, this.F.b - this.F.a);
          d7 = FloatMath.sqrt((f4 - f3) * (f4 - f3) + (f2 - f1) * (f2 - f1)) / this.F.h;
          i6 = (int)(10000.0D * (Math.log(d7) / Math.log(2.0D)));
          i7 = (int)(d6 * 180.0D / 3.1416D);
          if (((d7 > 0.0D) && ((i6 > 3000) || (i6 < -3000))) || (Math.abs(i7) >= 10))
            this.D = 2;
        }
        break;
      case 5:
      case 261:
      case 6:
      case 262:
      }
      while (true)
      {
        if (this.D != 0)
          break label620;
        return true;
        this.J = paramMotionEvent.getEventTime();
        this.M = (-1 + this.M);
        break;
        this.I = paramMotionEvent.getEventTime();
        this.M = (-1 + this.M);
        break;
        this.L = paramMotionEvent.getEventTime();
        this.M = (1 + this.M);
        break;
        this.K = paramMotionEvent.getEventTime();
        this.M = (1 + this.M);
        break;
        this.D = 1;
        continue;
        this.D = 2;
      }
      label620: if ((this.D == 1) && (this.i))
        if ((this.F.c - f1 > 0.0F) && (this.F.d - f2 > 0.0F))
        {
          x();
          a(1, 83, 0);
        }
      label678: label1372: 
      while ((this.D != 0) || (this.M != 0))
      {
        do
          while (true)
          {
            double d6;
            double d7;
            int i6;
            int i7;
            if (2 != this.D)
            {
              this.F.c = f1;
              this.F.d = f2;
              this.F.a = f3;
              this.F.b = f4;
            }
            if (!this.F.e)
            {
              this.F.f = (this.B / 2);
              this.F.g = (this.C / 2);
              this.F.e = true;
              if (0.0D == this.F.h)
              {
                double d1 = FloatMath.sqrt((this.F.b - this.F.a) * (this.F.b - this.F.a) + (this.F.d - this.F.c) * (this.F.d - this.F.c));
                this.F.h = d1;
              }
            }
            return true;
            if ((this.F.c - f1 < 0.0F) && (this.F.d - f2 < 0.0F))
            {
              x();
              a(1, 87, 0);
            }
          }
        while ((this.D != 2) && (this.D != 4) && (this.D != 3));
        double d2 = Math.atan2(f2 - f1, f4 - f3) - Math.atan2(this.F.d - this.F.c, this.F.b - this.F.a);
        double d3 = FloatMath.sqrt((f4 - f3) * (f4 - f3) + (f2 - f1) * (f2 - f1)) / this.F.h;
        int i4 = (int)(10000.0D * (Math.log(d3) / Math.log(2.0D)));
        double d4 = Math.atan2(this.F.g - this.F.c, this.F.f - this.F.a);
        double d5 = FloatMath.sqrt((this.F.f - this.F.a) * (this.F.f - this.F.a) + (this.F.g - this.F.c) * (this.F.g - this.F.c));
        float f9 = (float)(d3 * (d5 * Math.cos(d4 + d2)) + f3);
        float f10 = (float)(d3 * (d5 * Math.sin(d4 + d2)) + f1);
        int i5 = (int)(d2 * 180.0D / 3.1416D);
        if ((d3 > 0.0D) && ((3 == this.D) || ((Math.abs(i4) > 2000) && (2 == this.D))))
        {
          this.D = 3;
          float f11 = m().a;
          if ((this.k) && (f11 <= this.a) && (f11 >= this.b))
          {
            x();
            a(8193, 3, i4);
          }
        }
        while (true)
        {
          this.F.f = f9;
          this.F.g = f10;
          break;
          if ((i5 != 0) && ((4 == this.D) || ((Math.abs(i5) > 10) && (2 == this.D))))
          {
            this.D = 4;
            if (this.l)
            {
              x();
              a(8193, 1, i5);
            }
          }
        }
      }
      long l1;
      if (this.K > this.L)
      {
        l1 = this.K;
        label1404: this.K = l1;
        if (this.I >= this.J)
          break label1496;
      }
      label1496: for (long l2 = this.J; ; l2 = this.I)
      {
        this.I = l2;
        if ((this.K - this.I >= 200L) || (!this.k))
          break;
        w localw = m();
        localw.a -= 1.0F;
        a(localw, 300);
        break;
        l1 = this.L;
        break label1404;
      }
    }
    switch (paramMotionEvent.getAction())
    {
    default:
      return false;
    case 0:
      b(paramMotionEvent);
      return true;
    case 1:
      return d(paramMotionEvent);
    case 2:
    }
    c(paramMotionEvent);
    return true;
  }

  private void b(MotionEvent paramMotionEvent)
  {
    if (this.F.e)
      return;
    this.R = paramMotionEvent.getDownTime();
    if (this.R - this.Q < 400L)
      if ((Math.abs(paramMotionEvent.getX() - this.N) < 120.0F) && (Math.abs(paramMotionEvent.getY() - this.O) < 120.0F))
        this.Q = 0L;
    while (true)
    {
      this.N = paramMotionEvent.getX();
      this.O = paramMotionEvent.getY();
      a(4, 0, (int)paramMotionEvent.getX() | (int)paramMotionEvent.getY() << 16);
      this.P = true;
      return;
      this.Q = this.R;
      continue;
      this.Q = this.R;
    }
  }

  private boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 <= 0 + getWidth()) && (paramInt2 >= 0) && (paramInt2 <= 0 + getHeight());
  }

  private static boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[100];
    int[] arrayOfInt = new int[1];
    return (localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, paramInt1, 12323, paramInt2, 12322, paramInt3, 12321, paramInt4, 12325, paramInt5, 12326, paramInt6, 12344 }, arrayOfEGLConfig, 100, arrayOfInt)) && (arrayOfInt[0] > 0);
  }

  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (this.F.e)
      bool2 = true;
    int i1;
    int i2;
    boolean bool1;
    do
    {
      return bool2;
      if (this.U)
      {
        com.baidu.platform.comapi.c.a.a(c, "handleTouchMove, if (mHasMapObjDraging)");
        Iterator localIterator = this.o.iterator();
        while (localIterator.hasNext())
          ((g)localIterator.next()).d(a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        return true;
      }
      float f1 = Math.abs(paramMotionEvent.getX() - this.N);
      float f2 = Math.abs(paramMotionEvent.getY() - this.O);
      if (com.baidu.platform.comapi.c.c.E > 1.5D);
      for (double d1 = 1.5D * com.baidu.platform.comapi.c.c.E; ; d1 = com.baidu.platform.comapi.c.c.E)
      {
        float f3 = (float)d1;
        if ((!this.P) || (f1 / f3 > 3.0F) || (f2 / f3 > 3.0F))
          break;
        return true;
      }
      this.P = false;
      i1 = (int)paramMotionEvent.getX();
      i2 = (int)paramMotionEvent.getY();
      if (i1 < 0)
        i1 = 0;
      if (i2 < 0)
        i2 = 0;
      bool1 = this.j;
      bool2 = false;
    }
    while (!bool1);
    x();
    a(3, 0, i1 | i2 << 16);
    return false;
  }

  private void d(Bundle paramBundle)
  {
    if (paramBundle.getInt("type") == d.d.ordinal())
    {
      paramBundle.putInt("layer_addr", this.v.a);
      return;
    }
    paramBundle.putInt("layer_addr", this.w.a);
  }

  private boolean d(MotionEvent paramMotionEvent)
  {
    if (this.U)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        ((g)localIterator.next()).e(a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        this.U = false;
      }
    }
    if ((!this.F.e) && (paramMotionEvent.getEventTime() - this.R < 400L) && (Math.abs(paramMotionEvent.getX() - this.N) < 10.0F) && (Math.abs(paramMotionEvent.getY() - this.O) < 10.0F));
    for (int i1 = 1; ; i1 = 0)
    {
      w();
      int i2 = (int)paramMotionEvent.getX();
      int i3 = (int)paramMotionEvent.getY();
      if (i1 == 0)
      {
        if (i2 < 0)
          i2 = 0;
        if (i3 < 0);
        for (int i4 = 0; ; i4 = i3)
        {
          a(5, 0, i2 | i4 << 16);
          return true;
        }
      }
      return false;
    }
  }

  private void q()
  {
    this.p = new com.baidu.platform.comjni.map.basemap.a();
    this.p.a();
    this.q = this.p.c();
    String str1;
    String str2;
    String str3;
    String str4;
    int i1;
    int i2;
    int i3;
    if (com.baidu.platform.comapi.c.c.n() < 180)
    {
      this.E = 18;
      str1 = com.baidu.platform.comapi.c.c.o();
      str2 = com.baidu.mapapi.utils.b.a();
      str3 = com.baidu.mapapi.utils.b.b();
      str4 = com.baidu.mapapi.utils.b.c();
      i1 = com.baidu.mapapi.utils.b.d();
      i2 = com.baidu.mapapi.utils.b.e();
      i3 = com.baidu.mapapi.utils.b.f();
      if (com.baidu.platform.comapi.c.c.n() < 180)
        break label389;
    }
    label389: for (String str5 = "/h/"; ; str5 = "/l/")
    {
      String str6 = str1 + "/cfg";
      String str7 = str2 + "/vmp";
      String str8 = str6 + str5;
      String str9 = str6 + "/a/";
      String str10 = str7 + str5;
      String str11 = str7 + str5;
      String str12 = str3 + "/tmp/";
      String str13 = str4 + "/tmp/";
      Display localDisplay = ((Activity)this.m).getWindowManager().getDefaultDisplay();
      int i4 = localDisplay.getWidth();
      int i5 = localDisplay.getHeight();
      this.p.a(str8, str10, str12, str13, str11, str9, i4, i5, com.baidu.platform.comapi.c.c.n(), i1, i2, i3, 0);
      this.p.e();
      return;
      if (com.baidu.platform.comapi.c.c.n() < 240)
      {
        this.E = 25;
        break;
      }
      if (com.baidu.platform.comapi.c.c.n() < 320)
      {
        this.E = 37;
        break;
      }
      this.E = 50;
      break;
    }
  }

  private void r()
  {
    try
    {
      if (b(5, 6, 5, 0, 24, 0))
        setEGLConfigChooser(5, 6, 5, 0, 24, 0);
      while (true)
      {
        this.n = new MapRenderer(new WeakReference(this), this);
        this.n.a(this.q);
        setRenderer(this.n);
        setRenderMode(1);
        return;
        setEGLConfigChooser(true);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        setEGLConfigChooser(true);
    }
  }

  private void s()
  {
    this.r = new f(this);
  }

  private void t()
  {
    com.baidu.platform.comjni.engine.a.a(4000, this.r);
    com.baidu.platform.comjni.engine.a.a(39, this.r);
    com.baidu.platform.comjni.engine.a.a(41, this.r);
    com.baidu.platform.comjni.engine.a.a(49, this.r);
    com.baidu.platform.comjni.engine.a.a(65289, this.r);
  }

  private void u()
  {
    com.baidu.platform.comjni.engine.a.b(4000, this.r);
    com.baidu.platform.comjni.engine.a.b(41, this.r);
    com.baidu.platform.comjni.engine.a.b(49, this.r);
    com.baidu.platform.comjni.engine.a.b(39, this.r);
    com.baidu.platform.comjni.engine.a.b(65289, this.r);
  }

  private void v()
  {
    this.z = new y(this.p);
  }

  private void w()
  {
    this.D = 0;
    this.F.e = false;
    this.F.h = 0.0D;
  }

  private void x()
  {
    if (!this.S)
    {
      this.S = true;
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
        ((g)localIterator.next()).a(m());
    }
  }

  private void y()
  {
    this.S = false;
    if (!this.T)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
        ((g)localIterator.next()).c(m());
    }
  }

  private void z()
  {
    if ((!this.S) && (!this.T))
    {
      this.T = true;
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
        ((g)localIterator.next()).a(m());
    }
  }

  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.A)
      return 12.0F;
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramInt1);
    localBundle.putInt("right", paramInt3);
    localBundle.putInt("bottom", paramInt4);
    localBundle.putInt("top", paramInt2);
    localBundle.putInt("hasHW", 0);
    return this.p.b(localBundle);
  }

  public float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (!this.A)
      return 12.0F;
    Bundle localBundle = new Bundle();
    localBundle.putInt("left", paramInt1);
    localBundle.putInt("right", paramInt3);
    localBundle.putInt("bottom", paramInt4);
    localBundle.putInt("top", paramInt2);
    localBundle.putInt("hasHW", 1);
    localBundle.putInt("width", paramInt5);
    localBundle.putInt("height", paramInt6);
    return this.p.b(localBundle);
  }

  public int a(Bundle paramBundle1, int paramInt1, int paramInt2, Bundle paramBundle2)
  {
    if (paramInt1 == this.u.a)
    {
      paramBundle1.putString("jsondata", this.u.a());
      paramBundle1.putBundle("param", this.u.b());
      return this.u.g;
    }
    if (paramInt1 == this.t.a)
    {
      paramBundle1.putString("jsondata", this.t.a());
      paramBundle1.putBundle("param", this.t.b());
      return this.t.g;
    }
    if (paramInt1 == this.x.a)
    {
      int i1 = paramBundle2.getInt("x");
      int i2 = paramBundle2.getInt("y");
      int i3 = paramBundle2.getInt("zoom");
      paramBundle1.putBundle("param", this.y.a(i1, i2, i3));
      return this.x.g;
    }
    return 0;
  }

  public Point a(com.baidu.platform.comapi.a.b paramb)
  {
    return this.z.a(paramb);
  }

  public com.baidu.platform.comapi.a.b a(int paramInt1, int paramInt2)
  {
    return this.z.a(paramInt1, paramInt2);
  }

  public void a()
  {
    this.s = new ArrayList();
    a(new b());
    this.v = new h();
    a(this.v);
    a(new l());
    this.x = new i();
    a(this.x);
    a(new x());
    a(new k());
    this.w = new A();
    a(this.w);
    this.u = new c();
    a(this.u);
    this.t = new t();
    a(this.t);
  }

  public void a(Bundle paramBundle)
  {
    d(paramBundle);
    this.p.c(paramBundle);
  }

  public void a(a parama)
  {
    parama.a = this.p.a(parama.c, parama.d, parama.b);
    this.s.add(parama);
  }

  public void a(g paramg)
  {
    this.o.add(paramg);
  }

  public void a(j paramj)
  {
    this.y = paramj;
  }

  protected void a(v paramv)
  {
    new w();
    if (paramv == null)
      paramv = new v();
    w localw = paramv.a;
    this.i = paramv.f;
    this.l = paramv.d;
    this.j = paramv.e;
    this.k = paramv.g;
    this.p.a(localw.a(this));
    this.p.a(u.a.ordinal());
    this.f = paramv.b;
    if (!paramv.b)
      this.p.a(this.u.a, false);
    while (true)
    {
      if (paramv.c == 2)
        b(true);
      return;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf((int)(40.0F * com.baidu.platform.comapi.c.c.E));
      arrayOfObject[1] = Integer.valueOf((int)(40.0F * com.baidu.platform.comapi.c.c.E));
      String str = String.format("{\"dataset\":[{\"x\":%d,\"y\":%d,\"hidetime\":1000}]}", arrayOfObject);
      this.u.a(str);
      this.p.a(this.u.a, true);
    }
  }

  public void a(w paramw)
  {
    Bundle localBundle = paramw.a(this);
    localBundle.putInt("animation", 0);
    localBundle.putInt("animatime", 0);
    this.p.a(localBundle);
  }

  public void a(w paramw, int paramInt)
  {
    Bundle localBundle = paramw.a(this);
    localBundle.putInt("animation", 1);
    localBundle.putInt("animatime", paramInt);
    z();
    this.p.a(localBundle);
  }

  public void a(String paramString)
  {
    this.p.a(paramString);
    requestRender();
  }

  public void a(String paramString, Bundle paramBundle)
  {
    this.t.a(paramString);
    this.t.a(paramBundle);
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.p.b(this.d);
  }

  public boolean a(int paramInt)
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
      if (((a)localIterator.next()).a == paramInt)
        return true;
    return false;
  }

  public void b(Bundle paramBundle)
  {
    d(paramBundle);
    this.p.d(paramBundle);
  }

  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.p.a(this.e);
  }

  public boolean b()
  {
    return this.d;
  }

  public void c(Bundle paramBundle)
  {
    d(paramBundle);
    this.p.e(paramBundle);
  }

  public void c(boolean paramBoolean)
  {
    this.p.d(paramBoolean);
  }

  public boolean c()
  {
    return this.e;
  }

  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.p.a(this.u.a, paramBoolean);
  }

  public boolean d()
  {
    return this.p.k();
  }

  public void e(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.p.a(this.t.a, paramBoolean);
  }

  public boolean e()
  {
    return this.f;
  }

  public void f(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.p.a(this.x.a, paramBoolean);
  }

  public boolean f()
  {
    return this.g;
  }

  public void g()
  {
    this.p.b(this.x.a);
  }

  public void g(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void h(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public boolean h()
  {
    return this.j;
  }

  public void i(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean i()
  {
    return this.k;
  }

  public void j(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public boolean j()
  {
    return this.l;
  }

  public boolean k()
  {
    return this.i;
  }

  public void l()
  {
    u();
    BaseMapCallback.removeLayerDataInterface(this.q);
    this.p.b();
    this.p = null;
  }

  public w m()
  {
    Bundle localBundle = this.p.g();
    w localw = new w();
    localw.a(localBundle);
    return localw;
  }

  public void n()
  {
    this.p.c(this.v.a);
    this.p.c(this.w.a);
  }

  public void o()
  {
    this.p.l();
    this.p.b(this.x.a);
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    com.baidu.platform.comapi.a.b localb = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((g)localIterator.next()).b(localb);
    if (this.k)
    {
      w localw = m();
      localw.a = (1.0F + localw.a);
      localw.d = localb.b();
      localw.e = localb.a();
      a(localw, 300);
      return true;
    }
    return false;
  }

  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1;
    if (this.j)
    {
      f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (f1 > 500.0F);
    }
    else
    {
      return false;
    }
    z();
    a(34, (int)(f1 * 0.6F), (int)paramMotionEvent2.getY() << 16 | (int)paramMotionEvent2.getX());
    w();
    return true;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    com.baidu.platform.comapi.c.a.a(c, "onLongPress");
    String str = this.p.a(-1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.E);
    com.baidu.platform.comapi.c.a.a(c, "onLongPress(), nearly objs: " + str);
    Iterator localIterator2;
    if ((str != null) && (!str.equals("")))
      localIterator2 = this.o.iterator();
    while (localIterator2.hasNext())
    {
      g localg = (g)localIterator2.next();
      if (localg.b(str))
      {
        this.U = true;
      }
      else
      {
        localg.c(a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        continue;
        Iterator localIterator1 = this.o.iterator();
        while (localIterator1.hasNext())
          ((g)localIterator1.next()).c(a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
      }
    }
  }

  public void onPause()
  {
    super.onPause();
    this.p.d();
  }

  public void onResume()
  {
    super.onResume();
    this.p.f();
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
      ((g)localIterator.next()).c();
    this.p.e();
    this.p.j();
    setRenderMode(1);
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    String str = this.p.a(-1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.E);
    Iterator localIterator2;
    if ((str != null) && (!str.equals("")))
      localIterator2 = this.o.iterator();
    while (localIterator2.hasNext())
    {
      ((g)localIterator2.next()).a(str);
      continue;
      Iterator localIterator1 = this.o.iterator();
      while (localIterator1.hasNext())
        ((g)localIterator1.next()).a(a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
    }
    return true;
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.p == null);
    do
    {
      return true;
      super.onTouchEvent(paramMotionEvent);
    }
    while (this.H.onTouchEvent(paramMotionEvent));
    return a(paramMotionEvent);
  }

  public void p()
  {
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    this.n.a = paramInt2;
    this.n.b = paramInt3;
    this.B = paramInt2;
    this.C = paramInt3;
    this.n.c = 0;
    w localw = m();
    localw.j.a = 0;
    localw.j.c = 0;
    localw.j.d = paramInt3;
    localw.j.b = paramInt2;
    localw.f = -1;
    localw.g = -1;
    a(localw);
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
    if ((paramSurfaceHolder != null) && (!paramSurfaceHolder.getSurface().isValid()))
      surfaceDestroyed(paramSurfaceHolder);
  }

  static class a
  {
    float a;
    float b;
    float c;
    float d;
    boolean e;
    float f;
    float g;
    double h;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.map.e
 * JD-Core Version:    0.6.2
 */