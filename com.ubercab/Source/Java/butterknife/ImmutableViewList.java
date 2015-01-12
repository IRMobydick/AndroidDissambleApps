package butterknife;

import android.view.View;
import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableViewList<T extends View> extends AbstractList<T>
  implements RandomAccess
{
  private final T[] views;

  ImmutableViewList(T[] paramArrayOfT)
  {
    this.views = paramArrayOfT;
  }

  public boolean contains(Object paramObject)
  {
    View[] arrayOfView = this.views;
    int i = arrayOfView.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfView[j] == paramObject)
          bool = true;
      }
      else
        return bool;
    }
  }

  public T get(int paramInt)
  {
    return this.views[paramInt];
  }

  public int size()
  {
    return this.views.length;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.ImmutableViewList
 * JD-Core Version:    0.6.2
 */