package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.c.a;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

final class p extends n
{
  static final Interpolator A;
  static final Interpolator B;
  static final Interpolator C;
  static boolean a;
  static final boolean b;
  static final Interpolator z;
  ArrayList c;
  Runnable[] d;
  boolean e;
  ArrayList f;
  ArrayList g;
  ArrayList h;
  ArrayList i;
  ArrayList j;
  ArrayList k;
  ArrayList l;
  ArrayList m;
  int n = 0;
  h o;
  m p;
  Fragment q;
  boolean r;
  boolean s;
  boolean t;
  String u;
  boolean v;
  Bundle w = null;
  SparseArray x = null;
  Runnable y = new q(this);

  static
  {
    boolean bool = false;
    a = false;
    if (Build.VERSION.SDK_INT >= 11)
      bool = true;
    b = bool;
    z = new DecelerateInterpolator(2.5F);
    A = new DecelerateInterpolator(1.5F);
    B = new AccelerateInterpolator(2.5F);
    C = new AccelerateInterpolator(1.5F);
  }

  static Animation a(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(A);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }

  static Animation a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(z);
    localScaleAnimation.setDuration(220L);
    localAnimationSet.addAnimation(localScaleAnimation);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat3, paramFloat4);
    localAlphaAnimation.setInterpolator(A);
    localAlphaAnimation.setDuration(220L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }

  private void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.c.b("FragmentManager"));
    if (this.o != null);
    while (true)
    {
      try
      {
        this.o.dump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
        continue;
      }
      try
      {
        a("  ", null, localPrintWriter, new String[0]);
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
      }
    }
  }

  public static int b(int paramInt, boolean paramBoolean)
  {
    int i1 = -1;
    switch (paramInt)
    {
    default:
    case 4097:
    case 8194:
    case 4099:
    }
    while (true)
    {
      return i1;
      if (paramBoolean)
      {
        i1 = 1;
        continue;
      }
      i1 = 2;
      continue;
      if (paramBoolean)
      {
        i1 = 3;
        continue;
      }
      i1 = 4;
      continue;
      if (paramBoolean)
      {
        i1 = 5;
        continue;
      }
      i1 = 6;
    }
  }

  public static int c(int paramInt)
  {
    int i1 = 0;
    switch (paramInt)
    {
    default:
    case 4097:
    case 8194:
    case 4099:
    }
    while (true)
    {
      return i1;
      i1 = 8194;
      continue;
      i1 = 4097;
      continue;
      i1 = 4099;
    }
  }

  private void t()
  {
    if (this.s)
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    if (this.u != null)
      throw new IllegalStateException("Can not perform this action inside of " + this.u);
  }

  public int a(b paramb)
  {
    monitorenter;
    int i1;
    try
    {
      if ((this.l == null) || (this.l.size() <= 0))
      {
        if (this.k == null)
          this.k = new ArrayList();
        i1 = this.k.size();
        if (a)
          Log.v("FragmentManager", "Setting back stack index " + i1 + " to " + paramb);
        this.k.add(paramb);
        monitorexit;
      }
      else
      {
        i1 = ((Integer)this.l.remove(-1 + this.l.size())).intValue();
        if (a)
          Log.v("FragmentManager", "Adding back stack index " + i1 + " with " + paramb);
        this.k.set(i1, paramb);
        monitorexit;
      }
    }
    finally
    {
      localObject = finally;
      monitorexit;
      throw localObject;
    }
    return i1;
  }

  public Fragment a(int paramInt)
  {
    int i2;
    Fragment localFragment;
    if (this.g != null)
    {
      i2 = -1 + this.g.size();
      if (i2 >= 0)
      {
        localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (localFragment.w != paramInt));
      }
    }
    while (true)
    {
      return localFragment;
      i2--;
      break;
      if (this.f != null)
        for (int i1 = -1 + this.f.size(); ; i1--)
        {
          if (i1 < 0)
            break label109;
          localFragment = (Fragment)this.f.get(i1);
          if ((localFragment != null) && (localFragment.w == paramInt))
            break;
        }
      label109: localFragment = null;
    }
  }

  public Fragment a(Bundle paramBundle, String paramString)
  {
    int i1 = paramBundle.getInt(paramString, -1);
    Fragment localFragment;
    if (i1 == -1)
      localFragment = null;
    while (true)
    {
      return localFragment;
      if (i1 >= this.f.size())
        a(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i1));
      localFragment = (Fragment)this.f.get(i1);
      if (localFragment != null)
        continue;
      a(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i1));
    }
  }

  public Fragment a(String paramString)
  {
    int i2;
    Fragment localFragment;
    if ((this.g != null) && (paramString != null))
    {
      i2 = -1 + this.g.size();
      if (i2 >= 0)
      {
        localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (!paramString.equals(localFragment.y)));
      }
    }
    while (true)
    {
      return localFragment;
      i2--;
      break;
      if ((this.f != null) && (paramString != null))
        for (int i1 = -1 + this.f.size(); ; i1--)
        {
          if (i1 < 0)
            break label123;
          localFragment = (Fragment)this.f.get(i1);
          if ((localFragment != null) && (paramString.equals(localFragment.y)))
            break;
        }
      label123: localFragment = null;
    }
  }

  public x a()
  {
    return new b(this);
  }

  Animation a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.a(paramInt1, paramBoolean, paramFragment.G);
    if (localAnimation != null);
    while (true)
    {
      return localAnimation;
      if (paramFragment.G != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.o, paramFragment.G);
        if (localAnimation != null)
          continue;
      }
      if (paramInt1 == 0)
      {
        localAnimation = null;
        continue;
      }
      int i1 = b(paramInt1, paramBoolean);
      if (i1 < 0)
      {
        localAnimation = null;
        continue;
      }
      switch (i1)
      {
      default:
        if ((paramInt2 == 0) && (this.o.getWindow() != null))
          paramInt2 = this.o.getWindow().getAttributes().windowAnimations;
        if (paramInt2 == 0)
          localAnimation = null;
        break;
      case 1:
        localAnimation = a(this.o, 1.125F, 1.0F, 0.0F, 1.0F);
        break;
      case 2:
        localAnimation = a(this.o, 1.0F, 0.975F, 1.0F, 0.0F);
        break;
      case 3:
        localAnimation = a(this.o, 0.975F, 1.0F, 0.0F, 1.0F);
        break;
      case 4:
        localAnimation = a(this.o, 1.0F, 1.075F, 1.0F, 0.0F);
        break;
      case 5:
        localAnimation = a(this.o, 0.0F, 1.0F);
        break;
      case 6:
        localAnimation = a(this.o, 1.0F, 0.0F);
        continue;
        localAnimation = null;
      }
    }
  }

  void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.o == null) && (paramInt1 != 0))
      throw new IllegalStateException("No activity");
    if ((!paramBoolean) && (this.n == paramInt1));
    do
    {
      return;
      this.n = paramInt1;
    }
    while (this.f == null);
    int i1 = 0;
    boolean bool1 = false;
    label54: Fragment localFragment;
    if (i1 < this.f.size())
    {
      localFragment = (Fragment)this.f.get(i1);
      if (localFragment == null)
        break label172;
      a(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.M == null)
        break label172;
    }
    label172: for (boolean bool2 = bool1 | localFragment.M.a(); ; bool2 = bool1)
    {
      i1++;
      bool1 = bool2;
      break label54;
      if (!bool1)
        d();
      if ((!this.r) || (this.o == null) || (this.n != 5))
        break;
      this.o.c();
      this.r = false;
      break;
    }
  }

  public void a(int paramInt, b paramb)
  {
    monitorenter;
    try
    {
      if (this.k == null)
        this.k = new ArrayList();
      int i1 = this.k.size();
      if (paramInt < i1)
      {
        if (a)
          Log.v("FragmentManager", "Setting back stack index " + paramInt + " to " + paramb);
        this.k.set(paramInt, paramb);
        return;
      }
      while (i1 < paramInt)
      {
        this.k.add(null);
        if (this.l == null)
          this.l = new ArrayList();
        if (a)
          Log.v("FragmentManager", "Adding available back stack index " + i1);
        this.l.add(Integer.valueOf(i1));
        i1++;
      }
      if (a)
        Log.v("FragmentManager", "Adding back stack index " + paramInt + " with " + paramb);
      this.k.add(paramb);
    }
    finally
    {
      monitorexit;
    }
  }

  void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, 0, paramBoolean);
  }

  public void a(Configuration paramConfiguration)
  {
    if (this.g != null)
      for (int i1 = 0; i1 < this.g.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment == null)
          continue;
        localFragment.a(paramConfiguration);
      }
  }

  public void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.f < 0)
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    paramBundle.putInt(paramString, paramFragment.f);
  }

  void a(Parcelable paramParcelable, ArrayList paramArrayList)
  {
    if (paramParcelable == null);
    while (true)
    {
      return;
      FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (localFragmentManagerState.a == null)
        continue;
      if (paramArrayList != null)
        for (int i5 = 0; i5 < paramArrayList.size(); i5++)
        {
          Fragment localFragment4 = (Fragment)paramArrayList.get(i5);
          if (a)
            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localFragment4);
          FragmentState localFragmentState2 = localFragmentManagerState.a[localFragment4.f];
          localFragmentState2.k = localFragment4;
          localFragment4.e = null;
          localFragment4.r = 0;
          localFragment4.p = false;
          localFragment4.l = false;
          localFragment4.i = null;
          if (localFragmentState2.j == null)
            continue;
          localFragmentState2.j.setClassLoader(this.o.getClassLoader());
          localFragment4.e = localFragmentState2.j.getSparseParcelableArray("android:view_state");
        }
      this.f = new ArrayList(localFragmentManagerState.a.length);
      if (this.h != null)
        this.h.clear();
      int i1 = 0;
      if (i1 < localFragmentManagerState.a.length)
      {
        FragmentState localFragmentState1 = localFragmentManagerState.a[i1];
        if (localFragmentState1 != null)
        {
          Fragment localFragment3 = localFragmentState1.a(this.o, this.q);
          if (a)
            Log.v("FragmentManager", "restoreAllState: active #" + i1 + ": " + localFragment3);
          this.f.add(localFragment3);
          localFragmentState1.k = null;
        }
        while (true)
        {
          i1++;
          break;
          this.f.add(null);
          if (this.h == null)
            this.h = new ArrayList();
          if (a)
            Log.v("FragmentManager", "restoreAllState: avail #" + i1);
          this.h.add(Integer.valueOf(i1));
        }
      }
      if (paramArrayList != null)
      {
        int i4 = 0;
        if (i4 < paramArrayList.size())
        {
          Fragment localFragment2 = (Fragment)paramArrayList.get(i4);
          if (localFragment2.j >= 0)
            if (localFragment2.j >= this.f.size())
              break label461;
          for (localFragment2.i = ((Fragment)this.f.get(localFragment2.j)); ; localFragment2.i = null)
          {
            i4++;
            break;
            label461: Log.w("FragmentManager", "Re-attaching retained fragment " + localFragment2 + " target no longer exists: " + localFragment2.j);
          }
        }
      }
      if (localFragmentManagerState.b != null)
      {
        this.g = new ArrayList(localFragmentManagerState.b.length);
        for (int i3 = 0; i3 < localFragmentManagerState.b.length; i3++)
        {
          Fragment localFragment1 = (Fragment)this.f.get(localFragmentManagerState.b[i3]);
          if (localFragment1 == null)
            a(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.b[i3]));
          localFragment1.l = true;
          if (a)
            Log.v("FragmentManager", "restoreAllState: added #" + i3 + ": " + localFragment1);
          if (this.g.contains(localFragment1))
            throw new IllegalStateException("Already added!");
          this.g.add(localFragment1);
        }
      }
      this.g = null;
      if (localFragmentManagerState.c != null)
      {
        this.i = new ArrayList(localFragmentManagerState.c.length);
        for (int i2 = 0; i2 < localFragmentManagerState.c.length; i2++)
        {
          b localb = localFragmentManagerState.c[i2].a(this);
          if (a)
          {
            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + localb.o + "): " + localb);
            localb.a("  ", new PrintWriter(new android.support.v4.c.b("FragmentManager")), false);
          }
          this.i.add(localb);
          if (localb.o < 0)
            continue;
          a(localb.o, localb);
        }
        continue;
      }
      this.i = null;
    }
  }

  public void a(Fragment paramFragment)
  {
    if (paramFragment.K)
    {
      if (!this.e)
        break label20;
      this.v = true;
    }
    while (true)
    {
      return;
      label20: paramFragment.K = false;
      a(paramFragment, this.n, 0, 0, false);
    }
  }

  public void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.r);
    int i1;
    if (!paramFragment.a())
    {
      i1 = 1;
      if ((!paramFragment.A) || (i1 != 0))
      {
        if (this.g != null)
          this.g.remove(paramFragment);
        if ((paramFragment.D) && (paramFragment.E))
          this.r = true;
        paramFragment.l = false;
        paramFragment.m = true;
        if (i1 == 0)
          break label137;
      }
    }
    label137: for (int i2 = 0; ; i2 = 1)
    {
      a(paramFragment, i2, paramInt1, paramInt2, false);
      return;
      i1 = 0;
      break;
    }
  }

  void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (((!paramFragment.l) || (paramFragment.A)) && (paramInt1 > 1))
      paramInt1 = 1;
    if ((paramFragment.m) && (paramInt1 > paramFragment.a))
      paramInt1 = paramFragment.a;
    if ((paramFragment.K) && (paramFragment.a < 4) && (paramInt1 > 3))
      paramInt1 = 3;
    label501: ViewGroup localViewGroup;
    if (paramFragment.a < paramInt1)
    {
      if ((paramFragment.o) && (!paramFragment.p));
      while (true)
      {
        return;
        if (paramFragment.b != null)
        {
          paramFragment.b = null;
          a(paramFragment, paramFragment.c, 0, 0, true);
        }
        switch (paramFragment.a)
        {
        default:
          paramFragment.a = paramInt1;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        }
      }
      if (a)
        Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
      if (paramFragment.d != null)
      {
        paramFragment.e = paramFragment.d.getSparseParcelableArray("android:view_state");
        paramFragment.i = a(paramFragment.d, "android:target_state");
        if (paramFragment.i != null)
          paramFragment.k = paramFragment.d.getInt("android:target_req_state", 0);
        paramFragment.L = paramFragment.d.getBoolean("android:user_visible_hint", true);
        if (!paramFragment.L)
        {
          paramFragment.K = true;
          if (paramInt1 > 3)
            paramInt1 = 3;
        }
      }
      paramFragment.t = this.o;
      paramFragment.v = this.q;
      if (this.q != null);
      for (p localp = this.q.u; ; localp = this.o.b)
      {
        paramFragment.s = localp;
        paramFragment.F = false;
        paramFragment.a(this.o);
        if (paramFragment.F)
          break;
        throw new al("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      if (paramFragment.v == null)
        this.o.a(paramFragment);
      if (!paramFragment.C)
        paramFragment.h(paramFragment.d);
      paramFragment.C = false;
      if (paramFragment.o)
      {
        paramFragment.I = paramFragment.b(paramFragment.c(paramFragment.d), null, paramFragment.d);
        if (paramFragment.I != null)
        {
          paramFragment.J = paramFragment.I;
          paramFragment.I = ak.a(paramFragment.I);
          if (paramFragment.z)
            paramFragment.I.setVisibility(8);
          paramFragment.a(paramFragment.I, paramFragment.d);
        }
      }
      else if (paramInt1 > 1)
      {
        if (a)
          Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
        if (!paramFragment.o)
        {
          if (paramFragment.x == 0)
            break label1454;
          localViewGroup = (ViewGroup)this.p.a(paramFragment.x);
          if ((localViewGroup == null) && (!paramFragment.q))
            a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.x) + " (" + paramFragment.d().getResourceName(paramFragment.x) + ") for fragment " + paramFragment));
        }
      }
    }
    while (true)
    {
      paramFragment.H = localViewGroup;
      paramFragment.I = paramFragment.b(paramFragment.c(paramFragment.d), localViewGroup, paramFragment.d);
      if (paramFragment.I != null)
      {
        paramFragment.J = paramFragment.I;
        paramFragment.I = ak.a(paramFragment.I);
        if (localViewGroup != null)
        {
          Animation localAnimation2 = a(paramFragment, paramInt2, true, paramInt3);
          if (localAnimation2 != null)
            paramFragment.I.startAnimation(localAnimation2);
          localViewGroup.addView(paramFragment.I);
        }
        if (paramFragment.z)
          paramFragment.I.setVisibility(8);
        paramFragment.a(paramFragment.I, paramFragment.d);
      }
      while (true)
      {
        paramFragment.i(paramFragment.d);
        if (paramFragment.I != null)
          paramFragment.a(paramFragment.d);
        paramFragment.d = null;
        if (paramInt1 > 3)
        {
          if (a)
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          paramFragment.q();
        }
        if (paramInt1 <= 4)
          break;
        if (a)
          Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
        paramFragment.n = true;
        paramFragment.r();
        paramFragment.d = null;
        paramFragment.e = null;
        break;
        paramFragment.J = null;
        break label501;
        paramFragment.J = null;
      }
      if (paramFragment.a <= paramInt1)
        break;
      switch (paramFragment.a)
      {
      default:
        break;
      case 1:
      case 5:
      case 4:
      case 3:
      case 2:
        label963: 
        do
        {
          if (paramInt1 >= 1)
            break;
          if ((this.t) && (paramFragment.b != null))
          {
            View localView = paramFragment.b;
            paramFragment.b = null;
            localView.clearAnimation();
          }
          if (paramFragment.b == null)
            break label1322;
          paramFragment.c = paramInt1;
          paramInt1 = 1;
          break;
          if (paramInt1 < 5)
          {
            if (a)
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            paramFragment.t();
            paramFragment.n = false;
          }
          if (paramInt1 < 4)
          {
            if (a)
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            paramFragment.u();
          }
          if (paramInt1 >= 3)
            continue;
          if (a)
            Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
          paramFragment.v();
        }
        while (paramInt1 >= 2);
        if (a)
          Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
        if ((paramFragment.I != null) && (!this.o.isFinishing()) && (paramFragment.e == null))
          e(paramFragment);
        paramFragment.w();
        if ((paramFragment.I != null) && (paramFragment.H != null))
          if ((this.n <= 0) || (this.t))
            break label1448;
        label1448: for (Animation localAnimation1 = a(paramFragment, paramInt2, false, paramInt3); ; localAnimation1 = null)
        {
          if (localAnimation1 != null)
          {
            paramFragment.b = paramFragment.I;
            paramFragment.c = paramInt1;
            localAnimation1.setAnimationListener(new r(this, paramFragment));
            paramFragment.I.startAnimation(localAnimation1);
          }
          paramFragment.H.removeView(paramFragment.I);
          paramFragment.H = null;
          paramFragment.I = null;
          paramFragment.J = null;
          break label963;
          label1322: if (a)
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          if (!paramFragment.C)
            paramFragment.x();
          paramFragment.F = false;
          paramFragment.n();
          if (!paramFragment.F)
            throw new al("Fragment " + paramFragment + " did not call through to super.onDetach()");
          if (paramBoolean)
            break;
          if (!paramFragment.C)
          {
            d(paramFragment);
            break;
          }
          paramFragment.t = null;
          paramFragment.s = null;
          break;
        }
        label1454: localViewGroup = null;
      }
    }
  }

  public void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.g == null)
      this.g = new ArrayList();
    if (a)
      Log.v("FragmentManager", "add: " + paramFragment);
    c(paramFragment);
    if (!paramFragment.A)
    {
      if (this.g.contains(paramFragment))
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      this.g.add(paramFragment);
      paramFragment.l = true;
      paramFragment.m = false;
      if ((paramFragment.D) && (paramFragment.E))
        this.r = true;
      if (paramBoolean)
        b(paramFragment);
    }
  }

  public void a(h paramh, m paramm, Fragment paramFragment)
  {
    if (this.o != null)
      throw new IllegalStateException("Already attached");
    this.o = paramh;
    this.p = paramm;
    this.q = paramFragment;
  }

  // ERROR //
  public void a(Runnable paramRunnable, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +7 -> 8
    //   4: aload_0
    //   5: invokespecial 694	android/support/v4/app/p:t	()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 154	android/support/v4/app/p:o	Landroid/support/v4/app/h;
    //   14: ifnonnull +19 -> 33
    //   17: new 177	java/lang/IllegalStateException
    //   20: dup
    //   21: ldc_w 696
    //   24: invokespecial 180	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    //   33: aload_0
    //   34: getfield 698	android/support/v4/app/p:c	Ljava/util/ArrayList;
    //   37: ifnonnull +14 -> 51
    //   40: aload_0
    //   41: new 199	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 206	java/util/ArrayList:<init>	()V
    //   48: putfield 698	android/support/v4/app/p:c	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 698	android/support/v4/app/p:c	Ljava/util/ArrayList;
    //   55: aload_1
    //   56: invokevirtual 222	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 698	android/support/v4/app/p:c	Ljava/util/ArrayList;
    //   64: invokevirtual 203	java/util/ArrayList:size	()I
    //   67: iconst_1
    //   68: if_icmpne +32 -> 100
    //   71: aload_0
    //   72: getfield 154	android/support/v4/app/p:o	Landroid/support/v4/app/h;
    //   75: getfield 701	android/support/v4/app/h:a	Landroid/os/Handler;
    //   78: aload_0
    //   79: getfield 90	android/support/v4/app/p:y	Ljava/lang/Runnable;
    //   82: invokevirtual 707	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   85: aload_0
    //   86: getfield 154	android/support/v4/app/p:o	Landroid/support/v4/app/h;
    //   89: getfield 701	android/support/v4/app/h:a	Landroid/os/Handler;
    //   92: aload_0
    //   93: getfield 90	android/support/v4/app/p:y	Ljava/lang/Runnable;
    //   96: invokevirtual 711	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   99: pop
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //
    // Exception table:
    //   from	to	target	type
    //   10	31	28	finally
    //   33	102	28	finally
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i1 = 0;
    String str = paramString + "    ";
    if (this.f != null)
    {
      int i11 = this.f.size();
      if (i11 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        for (int i12 = 0; i12 < i11; i12++)
        {
          Fragment localFragment3 = (Fragment)this.f.get(i12);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i12);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment3);
          if (localFragment3 == null)
            continue;
          localFragment3.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    if (this.g != null)
    {
      int i9 = this.g.size();
      if (i9 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        for (int i10 = 0; i10 < i9; i10++)
        {
          Fragment localFragment2 = (Fragment)this.g.get(i10);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i10);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment2.toString());
        }
      }
    }
    if (this.j != null)
    {
      int i7 = this.j.size();
      if (i7 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        for (int i8 = 0; i8 < i7; i8++)
        {
          Fragment localFragment1 = (Fragment)this.j.get(i8);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i8);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment1.toString());
        }
      }
    }
    if (this.i != null)
    {
      int i5 = this.i.size();
      if (i5 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        for (int i6 = 0; i6 < i5; i6++)
        {
          b localb2 = (b)this.i.get(i6);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i6);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localb2.toString());
          localb2.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    monitorenter;
    try
    {
      if (this.k != null)
      {
        int i3 = this.k.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          for (int i4 = 0; i4 < i3; i4++)
          {
            b localb1 = (b)this.k.get(i4);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i4);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localb1);
          }
        }
      }
      if ((this.l != null) && (this.l.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.l.toArray()));
      }
      monitorexit;
      if (this.c != null)
      {
        int i2 = this.c.size();
        if (i2 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          while (i1 < i2)
          {
            Runnable localRunnable = (Runnable)this.c.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localRunnable);
            i1++;
          }
        }
      }
    }
    finally
    {
      monitorexit;
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mActivity=");
    paramPrintWriter.println(this.o);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.p);
    if (this.q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.q);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.s);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.t);
    if (this.r)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.r);
    }
    if (this.u != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.u);
    }
    if ((this.h != null) && (this.h.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.h.toArray()));
    }
  }

  boolean a(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.i == null)
      break label130;
    while (true)
    {
      label10: return i1;
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0))
        break;
      int i7 = -1 + this.i.size();
      if (i7 < 0)
        continue;
      ((b)this.i.remove(i7)).b(true);
      f();
    }
    while (true)
    {
      i1 = 1;
      break label10;
      int i2 = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        for (int i3 = -1 + this.i.size(); ; i3--)
        {
          b localb3;
          if (i3 >= 0)
          {
            localb3 = (b)this.i.get(i3);
            if ((paramString == null) || (!paramString.equals(localb3.b())));
          }
          else
          {
            label130: if (i3 < 0)
              break label10;
            if ((paramInt2 & 0x1) == 0)
              break label218;
            i3--;
            while (i3 >= 0)
            {
              b localb2 = (b)this.i.get(i3);
              if (((paramString == null) || (!paramString.equals(localb2.b()))) && ((paramInt1 < 0) || (paramInt1 != localb2.o)))
                break;
              i3--;
            }
          }
          if ((paramInt1 >= 0) && (paramInt1 == localb3.o))
            break;
        }
        label218: i2 = i3;
      }
      if (i2 == -1 + this.i.size())
        break label10;
      ArrayList localArrayList = new ArrayList();
      for (int i4 = -1 + this.i.size(); i4 > i2; i4--)
        localArrayList.add(this.i.remove(i4));
      int i5 = -1 + localArrayList.size();
      int i6 = 0;
      if (i6 <= i5)
      {
        if (a)
          Log.v("FragmentManager", "Popping back stack state: " + localArrayList.get(i6));
        b localb1 = (b)localArrayList.get(i6);
        if (i6 == i5);
        for (boolean bool = true; ; bool = false)
        {
          localb1.b(bool);
          i6++;
          break;
        }
      }
      f();
    }
  }

  public boolean a(Menu paramMenu)
  {
    if (this.g != null)
    {
      int i2 = 0;
      i1 = 0;
      while (i2 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i2);
        if ((localFragment != null) && (localFragment.c(paramMenu)))
          i1 = 1;
        i2++;
      }
    }
    int i1 = 0;
    return i1;
  }

  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i1 = 0;
    ArrayList localArrayList = null;
    if (this.g != null)
    {
      int i3 = 0;
      int i4;
      for (i2 = 0; i3 < this.g.size(); i2 = i4)
      {
        Fragment localFragment2 = (Fragment)this.g.get(i3);
        if ((localFragment2 != null) && (localFragment2.b(paramMenu, paramMenuInflater)))
        {
          i2 = 1;
          if (localArrayList == null)
            localArrayList = new ArrayList();
          localArrayList.add(localFragment2);
        }
        i4 = i2;
        i3++;
      }
    }
    int i2 = 0;
    if (this.j != null)
      while (i1 < this.j.size())
      {
        Fragment localFragment1 = (Fragment)this.j.get(i1);
        if ((localArrayList == null) || (!localArrayList.contains(localFragment1)))
          localFragment1.o();
        i1++;
      }
    this.j = localArrayList;
    return i2;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    int i1 = 0;
    if (this.g != null);
    for (int i2 = 0; ; i2++)
    {
      if (i2 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (!localFragment.c(paramMenuItem)))
          continue;
        i1 = 1;
      }
      return i1;
    }
  }

  public void b(int paramInt)
  {
    monitorenter;
    try
    {
      this.k.set(paramInt, null);
      if (this.l == null)
        this.l = new ArrayList();
      if (a)
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      this.l.add(Integer.valueOf(paramInt));
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

  void b(Fragment paramFragment)
  {
    a(paramFragment, this.n, 0, 0, false);
  }

  public void b(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "hide: " + paramFragment);
    if (!paramFragment.z)
    {
      paramFragment.z = true;
      if (paramFragment.I != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
          paramFragment.I.startAnimation(localAnimation);
        paramFragment.I.setVisibility(8);
      }
      if ((paramFragment.l) && (paramFragment.D) && (paramFragment.E))
        this.r = true;
      paramFragment.a(true);
    }
  }

  void b(b paramb)
  {
    if (this.i == null)
      this.i = new ArrayList();
    this.i.add(paramb);
    f();
  }

  public void b(Menu paramMenu)
  {
    if (this.g != null)
      for (int i1 = 0; i1 < this.g.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment == null)
          continue;
        localFragment.d(paramMenu);
      }
  }

  public boolean b()
  {
    return e();
  }

  public boolean b(MenuItem paramMenuItem)
  {
    int i1 = 0;
    if (this.g != null);
    for (int i2 = 0; ; i2++)
    {
      if (i2 < this.g.size())
      {
        Fragment localFragment = (Fragment)this.g.get(i2);
        if ((localFragment == null) || (!localFragment.d(paramMenuItem)))
          continue;
        i1 = 1;
      }
      return i1;
    }
  }

  void c(Fragment paramFragment)
  {
    if (paramFragment.f >= 0);
    label147: 
    while (true)
    {
      return;
      if ((this.h == null) || (this.h.size() <= 0))
      {
        if (this.f == null)
          this.f = new ArrayList();
        paramFragment.a(this.f.size(), this.q);
        this.f.add(paramFragment);
      }
      while (true)
      {
        if (!a)
          break label147;
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        break;
        paramFragment.a(((Integer)this.h.remove(-1 + this.h.size())).intValue(), this.q);
        this.f.set(paramFragment.f, paramFragment);
      }
    }
  }

  public void c(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "show: " + paramFragment);
    if (paramFragment.z)
    {
      paramFragment.z = false;
      if (paramFragment.I != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
          paramFragment.I.startAnimation(localAnimation);
        paramFragment.I.setVisibility(0);
      }
      if ((paramFragment.l) && (paramFragment.D) && (paramFragment.E))
        this.r = true;
      paramFragment.a(false);
    }
  }

  public boolean c()
  {
    t();
    b();
    return a(this.o.a, null, -1, 0);
  }

  void d()
  {
    if (this.f == null);
    while (true)
    {
      return;
      for (int i1 = 0; i1 < this.f.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        if (localFragment == null)
          continue;
        a(localFragment);
      }
    }
  }

  void d(Fragment paramFragment)
  {
    if (paramFragment.f < 0);
    while (true)
    {
      return;
      if (a)
        Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
      this.f.set(paramFragment.f, null);
      if (this.h == null)
        this.h = new ArrayList();
      this.h.add(Integer.valueOf(paramFragment.f));
      this.o.a(paramFragment.g);
      paramFragment.m();
    }
  }

  public void d(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "detach: " + paramFragment);
    if (!paramFragment.A)
    {
      paramFragment.A = true;
      if (paramFragment.l)
      {
        if (this.g != null)
        {
          if (a)
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          this.g.remove(paramFragment);
        }
        if ((paramFragment.D) && (paramFragment.E))
          this.r = true;
        paramFragment.l = false;
        a(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }

  void e(Fragment paramFragment)
  {
    if (paramFragment.J == null)
      return;
    if (this.x == null)
      this.x = new SparseArray();
    while (true)
    {
      paramFragment.J.saveHierarchyState(this.x);
      if (this.x.size() <= 0)
        break;
      paramFragment.e = this.x;
      this.x = null;
      break;
      this.x.clear();
    }
  }

  public void e(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a)
      Log.v("FragmentManager", "attach: " + paramFragment);
    if (paramFragment.A)
    {
      paramFragment.A = false;
      if (!paramFragment.l)
      {
        if (this.g == null)
          this.g = new ArrayList();
        if (this.g.contains(paramFragment))
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        if (a)
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        this.g.add(paramFragment);
        paramFragment.l = true;
        if ((paramFragment.D) && (paramFragment.E))
          this.r = true;
        a(paramFragment, this.n, paramInt1, paramInt2, false);
      }
    }
  }

  public boolean e()
  {
    if (this.e)
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    if (Looper.myLooper() != this.o.a.getLooper())
      throw new IllegalStateException("Must be called from main thread of process");
    int i1 = 0;
    while (true)
    {
      monitorenter;
      boolean bool;
      try
      {
        if ((this.c == null) || (this.c.size() == 0))
        {
          monitorexit;
          if (!this.v)
            break;
          int i2 = 0;
          bool = false;
          while (i2 < this.f.size())
          {
            Fragment localFragment = (Fragment)this.f.get(i2);
            if ((localFragment != null) && (localFragment.M != null))
              bool |= localFragment.M.a();
            i2++;
          }
        }
        int i3 = this.c.size();
        if ((this.d == null) || (this.d.length < i3))
          this.d = new Runnable[i3];
        this.c.toArray(this.d);
        this.c.clear();
        this.o.a.removeCallbacks(this.y);
        monitorexit;
        this.e = true;
        for (int i4 = 0; i4 < i3; i4++)
        {
          this.d[i4].run();
          this.d[i4] = null;
        }
      }
      finally
      {
        monitorexit;
      }
      this.e = false;
      i1 = 1;
      continue;
      if (bool)
        break;
      this.v = false;
      d();
    }
    return i1;
  }

  Bundle f(Fragment paramFragment)
  {
    if (this.w == null)
      this.w = new Bundle();
    paramFragment.j(this.w);
    Bundle localBundle;
    if (!this.w.isEmpty())
    {
      localBundle = this.w;
      this.w = null;
    }
    while (true)
    {
      if (paramFragment.I != null)
        e(paramFragment);
      if (paramFragment.e != null)
      {
        if (localBundle == null)
          localBundle = new Bundle();
        localBundle.putSparseParcelableArray("android:view_state", paramFragment.e);
      }
      if (!paramFragment.L)
      {
        if (localBundle == null)
          localBundle = new Bundle();
        localBundle.putBoolean("android:user_visible_hint", paramFragment.L);
      }
      return localBundle;
      localBundle = null;
    }
  }

  void f()
  {
    if (this.m != null)
      for (int i1 = 0; i1 < this.m.size(); i1++)
        ((o)this.m.get(i1)).a();
  }

  ArrayList g()
  {
    ArrayList localArrayList = null;
    if (this.f != null)
    {
      int i1 = 0;
      if (i1 < this.f.size())
      {
        Fragment localFragment = (Fragment)this.f.get(i1);
        if ((localFragment != null) && (localFragment.B))
        {
          if (localArrayList == null)
            localArrayList = new ArrayList();
          localArrayList.add(localFragment);
          localFragment.C = true;
          if (localFragment.i == null)
            break label128;
        }
        label128: for (int i2 = localFragment.i.f; ; i2 = -1)
        {
          localFragment.j = i2;
          if (a)
            Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
          i1++;
          break;
        }
      }
    }
    return localArrayList;
  }

  Parcelable h()
  {
    Object localObject = null;
    e();
    if (b)
      this.s = true;
    if ((this.f == null) || (this.f.size() <= 0))
      return localObject;
    int i1 = this.f.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[i1];
    int i2 = 0;
    int i3 = 0;
    label57: Fragment localFragment;
    FragmentState localFragmentState;
    if (i2 < i1)
    {
      localFragment = (Fragment)this.f.get(i2);
      if (localFragment == null)
        break label734;
      if (localFragment.f < 0)
        a(new IllegalStateException("Failure saving state: active " + localFragment + " has cleared index: " + localFragment.f));
      localFragmentState = new FragmentState(localFragment);
      arrayOfFragmentState[i2] = localFragmentState;
      if ((localFragment.a > 0) && (localFragmentState.j == null))
      {
        localFragmentState.j = f(localFragment);
        if (localFragment.i != null)
        {
          if (localFragment.i.f < 0)
            a(new IllegalStateException("Failure saving state: " + localFragment + " has target not in fragment manager: " + localFragment.i));
          if (localFragmentState.j == null)
            localFragmentState.j = new Bundle();
          a(localFragmentState.j, "android:target_state", localFragment.i);
          if (localFragment.k != 0)
            localFragmentState.j.putInt("android:target_req_state", localFragment.k);
        }
        label307: if (a)
          Log.v("FragmentManager", "Saved state of " + localFragment + ": " + localFragmentState.j);
      }
    }
    label734: for (int i8 = 1; ; i8 = i3)
    {
      i2++;
      i3 = i8;
      break label57;
      localFragmentState.j = localFragment.d;
      break label307;
      if (i3 == 0)
      {
        if (!a)
          break;
        Log.v("FragmentManager", "saveAllState: no fragments!");
        break;
      }
      if (this.g != null)
      {
        int i6 = this.g.size();
        if (i6 > 0)
        {
          arrayOfInt = new int[i6];
          for (int i7 = 0; i7 < i6; i7++)
          {
            arrayOfInt[i7] = ((Fragment)this.g.get(i7)).f;
            if (arrayOfInt[i7] < 0)
              a(new IllegalStateException("Failure saving state: active " + this.g.get(i7) + " has cleared index: " + arrayOfInt[i7]));
            if (!a)
              continue;
            Log.v("FragmentManager", "saveAllState: adding fragment #" + i7 + ": " + this.g.get(i7));
          }
        }
      }
      int[] arrayOfInt = null;
      if (this.i != null)
      {
        int i4 = this.i.size();
        if (i4 > 0)
        {
          localObject = new BackStackState[i4];
          for (int i5 = 0; i5 < i4; i5++)
          {
            localObject[i5] = new BackStackState(this, (b)this.i.get(i5));
            if (!a)
              continue;
            Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.i.get(i5));
          }
        }
      }
      FragmentManagerState localFragmentManagerState = new FragmentManagerState();
      localFragmentManagerState.a = arrayOfFragmentState;
      localFragmentManagerState.b = arrayOfInt;
      localFragmentManagerState.c = ((BackStackState)localObject);
      localObject = localFragmentManagerState;
      break;
    }
  }

  public void i()
  {
    this.s = false;
  }

  public void j()
  {
    this.s = false;
    a(1, false);
  }

  public void k()
  {
    this.s = false;
    a(2, false);
  }

  public void l()
  {
    this.s = false;
    a(4, false);
  }

  public void m()
  {
    this.s = false;
    a(5, false);
  }

  public void n()
  {
    a(4, false);
  }

  public void o()
  {
    this.s = true;
    a(3, false);
  }

  public void p()
  {
    a(2, false);
  }

  public void q()
  {
    a(1, false);
  }

  public void r()
  {
    this.t = true;
    e();
    a(0, false);
    this.o = null;
    this.p = null;
    this.q = null;
  }

  public void s()
  {
    if (this.g != null)
      for (int i1 = 0; i1 < this.g.size(); i1++)
      {
        Fragment localFragment = (Fragment)this.g.get(i1);
        if (localFragment == null)
          continue;
        localFragment.s();
      }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.q != null)
      a.a(this.q, localStringBuilder);
    while (true)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      a.a(this.o, localStringBuilder);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.p
 * JD-Core Version:    0.6.0
 */