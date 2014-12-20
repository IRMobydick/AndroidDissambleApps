package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList a;
  private Context b;
  private n c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private w f;
  private boolean g;

  private x a(String paramString, x paramx)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < this.a.size())
    {
      localObject2 = (w)this.a.get(i);
      if (!w.b((w)localObject2).equals(paramString))
        break label202;
    }
    while (true)
    {
      i++;
      localObject1 = localObject2;
      break;
      if (localObject1 == null)
        throw new IllegalStateException("No tab known for tag " + paramString);
      if (this.f != localObject1)
      {
        if (paramx == null)
          paramx = this.c.a();
        if ((this.f != null) && (w.a(this.f) != null))
          paramx.a(w.a(this.f));
        if (localObject1 != null)
        {
          if (w.a(localObject1) != null)
            break label190;
          w.a(localObject1, Fragment.a(this.b, w.c(localObject1).getName(), w.d(localObject1)));
          paramx.a(this.d, w.a(localObject1), w.b(localObject1));
        }
      }
      while (true)
      {
        this.f = localObject1;
        return paramx;
        label190: paramx.b(w.a(localObject1));
      }
      label202: localObject2 = localObject1;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    x localx1 = null;
    int i = 0;
    if (i < this.a.size())
    {
      w localw = (w)this.a.get(i);
      w.a(localw, this.c.a(w.b(localw)));
      if ((w.a(localw) != null) && (!w.a(localw).e()))
      {
        if (!w.b(localw).equals(str))
          break label98;
        this.f = localw;
      }
      while (true)
      {
        i++;
        break;
        label98: if (localx1 == null)
          localx1 = this.c.a();
        localx1.a(w.a(localw));
      }
    }
    this.g = true;
    x localx2 = a(str, localx1);
    if (localx2 != null)
    {
      localx2.a();
      this.c.b();
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g = false;
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    FragmentTabHost.SavedState localSavedState = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setCurrentTabByTag(localSavedState.a);
  }

  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.a = getCurrentTabTag();
    return localSavedState;
  }

  public void onTabChanged(String paramString)
  {
    if (this.g)
    {
      x localx = a(paramString, null);
      if (localx != null)
        localx.a();
    }
    if (this.e != null)
      this.e.onTabChanged(paramString);
  }

  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.e = paramOnTabChangeListener;
  }

  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.6.0
 */