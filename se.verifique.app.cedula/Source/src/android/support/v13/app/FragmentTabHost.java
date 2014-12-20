package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
  private FragmentManager c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private c f;
  private boolean g;

  private FragmentTransaction a(String paramString, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < this.a.size())
    {
      localObject2 = (c)this.a.get(i);
      if (!c.b((c)localObject2).equals(paramString))
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
        if (paramFragmentTransaction == null)
          paramFragmentTransaction = this.c.beginTransaction();
        if ((this.f != null) && (c.a(this.f) != null))
          paramFragmentTransaction.detach(c.a(this.f));
        if (localObject1 != null)
        {
          if (c.a(localObject1) != null)
            break label190;
          c.a(localObject1, Fragment.instantiate(this.b, c.c(localObject1).getName(), c.d(localObject1)));
          paramFragmentTransaction.add(this.d, c.a(localObject1), c.b(localObject1));
        }
      }
      while (true)
      {
        this.f = localObject1;
        return paramFragmentTransaction;
        label190: paramFragmentTransaction.attach(c.a(localObject1));
      }
      label202: localObject2 = localObject1;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    FragmentTransaction localFragmentTransaction1 = null;
    int i = 0;
    if (i < this.a.size())
    {
      c localc = (c)this.a.get(i);
      c.a(localc, this.c.findFragmentByTag(c.b(localc)));
      if ((c.a(localc) != null) && (!c.a(localc).isDetached()))
      {
        if (!c.b(localc).equals(str))
          break label98;
        this.f = localc;
      }
      while (true)
      {
        i++;
        break;
        label98: if (localFragmentTransaction1 == null)
          localFragmentTransaction1 = this.c.beginTransaction();
        localFragmentTransaction1.detach(c.a(localc));
      }
    }
    this.g = true;
    FragmentTransaction localFragmentTransaction2 = a(str, localFragmentTransaction1);
    if (localFragmentTransaction2 != null)
    {
      localFragmentTransaction2.commit();
      this.c.executePendingTransactions();
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
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null)
        localFragmentTransaction.commit();
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
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * JD-Core Version:    0.6.0
 */