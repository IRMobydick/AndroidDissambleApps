package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.c.a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final HashMap P = new HashMap();
  boolean A;
  boolean B;
  boolean C;
  boolean D;
  boolean E = true;
  boolean F;
  int G;
  ViewGroup H;
  View I;
  View J;
  boolean K;
  boolean L = true;
  ad M;
  boolean N;
  boolean O;
  int a = 0;
  View b;
  int c;
  Bundle d;
  SparseArray e;
  int f = -1;
  String g;
  Bundle h;
  Fragment i;
  int j = -1;
  int k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  int r;
  p s;
  h t;
  p u;
  Fragment v;
  int w;
  int x;
  String y;
  boolean z;

  public static Fragment a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass = (Class)P.get(paramString);
      if (localClass == null)
      {
        localClass = paramContext.getClassLoader().loadClass(paramString);
        P.put(paramString, localClass);
      }
      Fragment localFragment = (Fragment)localClass.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(localFragment.getClass().getClassLoader());
        localFragment.h = paramBundle;
      }
      return localFragment;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new f("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new f("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new f("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localIllegalAccessException);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }

  public Animation a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  final void a(int paramInt, Fragment paramFragment)
  {
    this.f = paramInt;
    if (paramFragment != null);
    for (this.g = (paramFragment.g + ":" + this.f); ; this.g = ("android:fragment:" + this.f))
      return;
  }

  public void a(Activity paramActivity)
  {
    this.F = true;
  }

  public void a(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.F = true;
  }

  void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.u != null)
      this.u.a(paramConfiguration);
  }

  final void a(Bundle paramBundle)
  {
    if (this.e != null)
    {
      this.J.restoreHierarchyState(this.e);
      this.e = null;
    }
    this.F = false;
    f(paramBundle);
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onViewStateRestored()");
  }

  public void a(Menu paramMenu)
  {
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
  }

  public void a(View paramView, Bundle paramBundle)
  {
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.w));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.x));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.y);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.g);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.r);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.l);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.m);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.p);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.z);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.A);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.E);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.D);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.B);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.C);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.L);
    if (this.s != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.s);
    }
    if (this.t != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mActivity=");
      paramPrintWriter.println(this.t);
    }
    if (this.v != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.v);
    }
    if (this.h != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.h);
    }
    if (this.d != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.d);
    }
    if (this.e != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.e);
    }
    if (this.i != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.i);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.k);
    }
    if (this.G != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.G);
    }
    if (this.H != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.H);
    }
    if (this.I != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.I);
    }
    if (this.J != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.I);
    }
    if (this.b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.b);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.c);
    }
    if (this.M != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.M.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.u != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.u + ":");
      this.u.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  public void a(boolean paramBoolean)
  {
  }

  final boolean a()
  {
    if (this.r > 0);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    return false;
  }

  public final Bundle b()
  {
    return this.h;
  }

  View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.u != null)
      this.u.i();
    return a(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void b(Bundle paramBundle)
  {
    if (this.f >= 0)
      throw new IllegalStateException("Fragment already active");
    this.h = paramBundle;
  }

  public void b(Menu paramMenu)
  {
  }

  boolean b(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool = false;
    if (!this.z)
    {
      if ((this.D) && (this.E))
      {
        bool = true;
        a(paramMenu, paramMenuInflater);
      }
      if (this.u != null)
        bool |= this.u.a(paramMenu, paramMenuInflater);
    }
    return bool;
  }

  public boolean b(MenuItem paramMenuItem)
  {
    return false;
  }

  public final h c()
  {
    return this.t;
  }

  public LayoutInflater c(Bundle paramBundle)
  {
    return this.t.getLayoutInflater();
  }

  boolean c(Menu paramMenu)
  {
    boolean bool = false;
    if (!this.z)
    {
      if ((this.D) && (this.E))
      {
        bool = true;
        a(paramMenu);
      }
      if (this.u != null)
        bool |= this.u.a(paramMenu);
    }
    return bool;
  }

  boolean c(MenuItem paramMenuItem)
  {
    int i1 = 1;
    if (!this.z)
      if ((!this.D) || (!this.E) || (!a(paramMenuItem)));
    while (true)
    {
      return i1;
      if ((this.u != null) && (this.u.a(paramMenuItem)))
        continue;
      i1 = 0;
    }
  }

  public final Resources d()
  {
    if (this.t == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    return this.t.getResources();
  }

  public void d(Bundle paramBundle)
  {
    this.F = true;
  }

  void d(Menu paramMenu)
  {
    if (!this.z)
    {
      if ((this.D) && (this.E))
        b(paramMenu);
      if (this.u != null)
        this.u.b(paramMenu);
    }
  }

  boolean d(MenuItem paramMenuItem)
  {
    int i1 = 1;
    if (!this.z)
      if (!b(paramMenuItem));
    while (true)
    {
      return i1;
      if ((this.u != null) && (this.u.b(paramMenuItem)))
        continue;
      i1 = 0;
    }
  }

  public void e(Bundle paramBundle)
  {
    this.F = true;
  }

  public final boolean e()
  {
    return this.A;
  }

  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  public View f()
  {
    return this.I;
  }

  public void f(Bundle paramBundle)
  {
    this.F = true;
  }

  public void g()
  {
    this.F = true;
    if (!this.N)
    {
      this.N = true;
      if (!this.O)
      {
        this.O = true;
        this.M = this.t.a(this.g, this.N, false);
      }
      if (this.M != null)
        this.M.b();
    }
  }

  public void g(Bundle paramBundle)
  {
  }

  public void h()
  {
    this.F = true;
  }

  void h(Bundle paramBundle)
  {
    if (this.u != null)
      this.u.i();
    this.F = false;
    d(paramBundle);
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onCreate()");
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      if (localParcelable != null)
      {
        if (this.u == null)
          p();
        this.u.a(localParcelable, null);
        this.u.j();
      }
    }
  }

  public final int hashCode()
  {
    return super.hashCode();
  }

  public void i()
  {
    this.F = true;
  }

  void i(Bundle paramBundle)
  {
    if (this.u != null)
      this.u.i();
    this.F = false;
    e(paramBundle);
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onActivityCreated()");
    if (this.u != null)
      this.u.k();
  }

  public void j()
  {
    this.F = true;
  }

  void j(Bundle paramBundle)
  {
    g(paramBundle);
    if (this.u != null)
    {
      Parcelable localParcelable = this.u.h();
      if (localParcelable != null)
        paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }

  public void k()
  {
    this.F = true;
  }

  public void l()
  {
    this.F = true;
    if (!this.O)
    {
      this.O = true;
      this.M = this.t.a(this.g, this.N, false);
    }
    if (this.M != null)
      this.M.h();
  }

  void m()
  {
    this.f = -1;
    this.g = null;
    this.l = false;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = 0;
    this.s = null;
    this.t = null;
    this.w = 0;
    this.x = 0;
    this.y = null;
    this.z = false;
    this.A = false;
    this.C = false;
    this.M = null;
    this.N = false;
    this.O = false;
  }

  public void n()
  {
    this.F = true;
  }

  public void o()
  {
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.F = true;
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    c().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onLowMemory()
  {
    this.F = true;
  }

  void p()
  {
    this.u = new p();
    this.u.a(this.t, new e(this), this);
  }

  void q()
  {
    if (this.u != null)
    {
      this.u.i();
      this.u.e();
    }
    this.F = false;
    g();
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onStart()");
    if (this.u != null)
      this.u.l();
    if (this.M != null)
      this.M.g();
  }

  void r()
  {
    if (this.u != null)
    {
      this.u.i();
      this.u.e();
    }
    this.F = false;
    h();
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onResume()");
    if (this.u != null)
    {
      this.u.m();
      this.u.e();
    }
  }

  void s()
  {
    onLowMemory();
    if (this.u != null)
      this.u.s();
  }

  void t()
  {
    if (this.u != null)
      this.u.n();
    this.F = false;
    i();
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onPause()");
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    a.a(this, localStringBuilder);
    if (this.f >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.f);
    }
    if (this.w != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.w));
    }
    if (this.y != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.y);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  void u()
  {
    if (this.u != null)
      this.u.o();
    this.F = false;
    j();
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onStop()");
  }

  void v()
  {
    if (this.u != null)
      this.u.p();
    if (this.N)
    {
      this.N = false;
      if (!this.O)
      {
        this.O = true;
        this.M = this.t.a(this.g, this.N, false);
      }
      if (this.M != null)
      {
        if (this.t.h)
          break label83;
        this.M.c();
      }
    }
    while (true)
    {
      return;
      label83: this.M.d();
    }
  }

  void w()
  {
    if (this.u != null)
      this.u.q();
    this.F = false;
    k();
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onDestroyView()");
    if (this.M != null)
      this.M.f();
  }

  void x()
  {
    if (this.u != null)
      this.u.r();
    this.F = false;
    l();
    if (!this.F)
      throw new al("Fragment " + this + " did not call through to super.onDestroy()");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.6.0
 */