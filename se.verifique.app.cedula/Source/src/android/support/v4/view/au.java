package android.support.v4.view;

import android.database.DataSetObserver;

class au extends DataSetObserver
{
  private au(ViewPager paramViewPager)
  {
  }

  public void onChanged()
  {
    this.a.a();
  }

  public void onInvalidated()
  {
    this.a.a();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.au
 * JD-Core Version:    0.6.0
 */