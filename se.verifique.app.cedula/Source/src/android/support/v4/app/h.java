package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class h extends Activity
{
  final Handler a = new i(this);
  final p b = new p();
  final m c = new j(this);
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  HashMap l;
  ad m;

  private static String a(View paramView)
  {
    char c1 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    switch (paramView.getVisibility())
    {
    default:
      localStringBuilder.append(c2);
    case 0:
    case 4:
    case 8:
    }
    while (true)
    {
      char c3;
      label108: char c4;
      label126: char c5;
      label143: char c6;
      label161: char c7;
      label179: char c8;
      label197: char c9;
      label215: label236: char c10;
      label253: int n;
      Resources localResources;
      if (paramView.isFocusable())
      {
        c3 = c1;
        localStringBuilder.append(c3);
        if (!paramView.isEnabled())
          break label533;
        c4 = 'E';
        localStringBuilder.append(c4);
        if (!paramView.willNotDraw())
          break label539;
        c5 = c2;
        localStringBuilder.append(c5);
        if (!paramView.isHorizontalScrollBarEnabled())
          break label546;
        c6 = 'H';
        localStringBuilder.append(c6);
        if (!paramView.isVerticalScrollBarEnabled())
          break label552;
        c7 = 'V';
        localStringBuilder.append(c7);
        if (!paramView.isClickable())
          break label558;
        c8 = 'C';
        localStringBuilder.append(c8);
        if (!paramView.isLongClickable())
          break label564;
        c9 = 'L';
        localStringBuilder.append(c9);
        localStringBuilder.append(' ');
        if (!paramView.isFocused())
          break label570;
        localStringBuilder.append(c1);
        if (!paramView.isSelected())
          break label575;
        c10 = 'S';
        localStringBuilder.append(c10);
        if (paramView.isPressed())
          c2 = 'P';
        localStringBuilder.append(c2);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        n = paramView.getId();
        if (n != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(n));
          localResources = paramView.getResources();
          if ((n != 0) && (localResources != null))
            switch (0xFF000000 & n)
            {
            default:
            case 2130706432:
            case 16777216:
            }
        }
      }
      try
      {
        String str1 = localResources.getResourcePackageName(n);
        while (true)
        {
          String str2 = localResources.getResourceTypeName(n);
          String str3 = localResources.getResourceEntryName(n);
          localStringBuilder.append(" ");
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          localStringBuilder.append("/");
          localStringBuilder.append(str3);
          label485: localStringBuilder.append("}");
          return localStringBuilder.toString();
          localStringBuilder.append('V');
          break;
          localStringBuilder.append('I');
          break;
          localStringBuilder.append('G');
          break;
          c3 = c2;
          break label108;
          label533: c4 = c2;
          break label126;
          label539: c5 = 'D';
          break label143;
          label546: c6 = c2;
          break label161;
          label552: c7 = c2;
          break label179;
          label558: c8 = c2;
          break label197;
          label564: c9 = c2;
          break label215;
          label570: c1 = c2;
          break label236;
          label575: c10 = c2;
          break label253;
          str1 = "app";
          continue;
          str1 = "android";
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label485;
      }
    }
  }

  private void a(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null)
      paramPrintWriter.println("null");
    while (true)
    {
      return;
      paramPrintWriter.println(a(paramView));
      if (!(paramView instanceof ViewGroup))
        continue;
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int n = localViewGroup.getChildCount();
      if (n <= 0)
        continue;
      String str = paramString + "  ";
      for (int i1 = 0; i1 < n; i1++)
        a(str, paramPrintWriter, localViewGroup.getChildAt(i1));
    }
  }

  ad a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.l == null)
      this.l = new HashMap();
    ad localad = (ad)this.l.get(paramString);
    if (localad == null)
      if (paramBoolean2)
      {
        localad = new ad(paramString, this, paramBoolean1);
        this.l.put(paramString, localad);
      }
    while (true)
    {
      return localad;
      localad.a(this);
    }
  }

  protected void a()
  {
    this.b.m();
  }

  public void a(Fragment paramFragment)
  {
  }

  void a(String paramString)
  {
    if (this.l != null)
    {
      ad localad = (ad)this.l.get(paramString);
      if ((localad != null) && (!localad.g))
      {
        localad.h();
        this.l.remove(paramString);
      }
    }
  }

  void a(boolean paramBoolean)
  {
    if (!this.g)
    {
      this.g = true;
      this.h = paramBoolean;
      this.a.removeMessages(1);
      d();
    }
  }

  public Object b()
  {
    return null;
  }

  public void c()
  {
    if (Build.VERSION.SDK_INT >= 11)
      a.a(this);
    while (true)
    {
      return;
      this.i = true;
    }
  }

  void d()
  {
    if (this.k)
    {
      this.k = false;
      if (this.m != null)
      {
        if (this.h)
          break label41;
        this.m.c();
      }
    }
    while (true)
    {
      this.b.p();
      return;
      label41: this.m.d();
    }
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 11);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.d);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.e);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.g);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.k);
    if (this.m != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.m)));
      paramPrintWriter.println(":");
      this.m.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.b.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }

  public n e()
  {
    return this.b;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.i();
    int n = paramInt1 >> 16;
    int i1;
    if (n != 0)
    {
      i1 = n - 1;
      if ((this.b.f == null) || (i1 < 0) || (i1 >= this.b.f.size()))
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
    }
    while (true)
    {
      return;
      Fragment localFragment = (Fragment)this.b.f.get(i1);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        continue;
      }
      localFragment.a(0xFFFF & paramInt1, paramInt2, paramIntent);
      continue;
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }

  public void onBackPressed()
  {
    if (!this.b.c())
      finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.b.a(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.b.a(this, this.c, null);
    if (getLayoutInflater().getFactory() == null)
      getLayoutInflater().setFactory(this);
    super.onCreate(paramBundle);
    l locall = (l)getLastNonConfigurationInstance();
    if (locall != null)
      this.l = locall.e;
    Parcelable localParcelable;
    p localp;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      localp = this.b;
      if (locall == null)
        break label100;
    }
    label100: for (ArrayList localArrayList = locall.d; ; localArrayList = null)
    {
      localp.a(localParcelable, localArrayList);
      this.b.j();
      return;
    }
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.b.a(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT < 11);
    }
    while (true)
    {
      return bool;
      bool = true;
      continue;
      bool = super.onCreatePanelMenu(paramInt, paramMenu);
    }
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int n = 0;
    Object localObject = null;
    if (!"fragment".equals(paramString));
    for (View localView = super.onCreateView(paramString, paramContext, paramAttributeSet); ; localView = ((Fragment)localObject).I)
    {
      return localView;
      String str1 = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, k.a);
      if (str1 == null)
        str1 = localTypedArray.getString(0);
      int i1 = localTypedArray.getResourceId(1, -1);
      String str2 = localTypedArray.getString(2);
      localTypedArray.recycle();
      if (0 != 0)
        n = null.getId();
      if ((n == -1) && (i1 == -1) && (str2 == null))
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      if (i1 != -1)
        localObject = this.b.a(i1);
      if ((localObject == null) && (str2 != null))
        localObject = this.b.a(str2);
      if ((localObject == null) && (n != -1))
        localObject = this.b.a(n);
      if (p.a)
        Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(i1) + " fname=" + str1 + " existing=" + localObject);
      int i2;
      if (localObject == null)
      {
        Fragment localFragment = Fragment.a(this, str1);
        localFragment.o = true;
        if (i1 != 0)
        {
          i2 = i1;
          localFragment.w = i2;
          localFragment.x = n;
          localFragment.y = str2;
          localFragment.p = true;
          localFragment.s = this.b;
          localFragment.a(this, paramAttributeSet, localFragment.d);
          this.b.a(localFragment, true);
          localObject = localFragment;
        }
      }
      while (true)
      {
        if (((Fragment)localObject).I != null)
          break label537;
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        i2 = n;
        break;
        if (((Fragment)localObject).p)
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i1) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(n) + " with another fragment for " + str1);
        ((Fragment)localObject).p = true;
        if (!((Fragment)localObject).C)
          ((Fragment)localObject).a(this, paramAttributeSet, ((Fragment)localObject).d);
        this.b.b((Fragment)localObject);
      }
      label537: if (i1 != 0)
        ((Fragment)localObject).I.setId(i1);
      if (((Fragment)localObject).I.getTag() != null)
        continue;
      ((Fragment)localObject).I.setTag(str2);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    a(false);
    this.b.r();
    if (this.m != null)
      this.m.h();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
      onBackPressed();
    for (boolean bool = true; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return bool;
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    this.b.s();
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool;
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      bool = true;
    while (true)
    {
      return bool;
      switch (paramInt)
      {
      default:
        bool = false;
        break;
      case 0:
        bool = this.b.a(paramMenuItem);
        break;
      case 6:
        bool = this.b.b(paramMenuItem);
      }
    }
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.i();
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    default:
    case 0:
    }
    while (true)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.b.b(paramMenu);
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.e = false;
    if (this.a.hasMessages(2))
    {
      this.a.removeMessages(2);
      a();
    }
    this.b.n();
  }

  protected void onPostResume()
  {
    super.onPostResume();
    this.a.removeMessages(2);
    a();
    this.b.e();
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
      if (this.i)
      {
        this.i = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
    for (boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu) | this.b.a(paramMenu); ; bool = super.onPreparePanel(paramInt, paramView, paramMenu))
      return bool;
  }

  protected void onResume()
  {
    super.onResume();
    this.a.sendEmptyMessage(2);
    this.e = true;
    this.b.e();
  }

  public final Object onRetainNonConfigurationInstance()
  {
    int n = 0;
    if (this.f)
      a(true);
    Object localObject = b();
    ArrayList localArrayList = this.b.g();
    if (this.l != null)
    {
      ad[] arrayOfad = new ad[this.l.size()];
      this.l.values().toArray(arrayOfad);
      if (arrayOfad != null)
      {
        int i1 = 0;
        if (n < arrayOfad.length)
        {
          ad localad = arrayOfad[n];
          if (localad.g)
            i1 = 1;
          while (true)
          {
            n++;
            break;
            localad.h();
            this.l.remove(localad.d);
          }
        }
        n = i1;
      }
    }
    l locall;
    if ((localArrayList == null) && (n == 0) && (localObject == null))
      locall = null;
    while (true)
    {
      return locall;
      locall = new l();
      locall.a = null;
      locall.b = localObject;
      locall.c = null;
      locall.d = localArrayList;
      locall.e = this.l;
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.b.h();
    if (localParcelable != null)
      paramBundle.putParcelable("android:support:fragments", localParcelable);
  }

  protected void onStart()
  {
    int n = 0;
    super.onStart();
    this.f = false;
    this.g = false;
    this.a.removeMessages(1);
    if (!this.d)
    {
      this.d = true;
      this.b.k();
    }
    this.b.i();
    this.b.e();
    if (!this.k)
    {
      this.k = true;
      if (this.m == null)
        break label159;
      this.m.b();
    }
    while (true)
    {
      this.j = true;
      this.b.l();
      if (this.l == null)
        break;
      ad[] arrayOfad = new ad[this.l.size()];
      this.l.values().toArray(arrayOfad);
      if (arrayOfad == null)
        break;
      while (n < arrayOfad.length)
      {
        ad localad = arrayOfad[n];
        localad.e();
        localad.g();
        n++;
      }
      label159: if (this.j)
        continue;
      this.m = a(null, this.k, false);
      if ((this.m == null) || (this.m.f))
        continue;
      this.m.b();
    }
  }

  protected void onStop()
  {
    super.onStop();
    this.f = true;
    this.a.sendEmptyMessage(1);
    this.b.o();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0))
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.h
 * JD-Core Version:    0.6.0
 */