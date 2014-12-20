package android.support.v7.internal.widget;

import android.database.DataSetObserver;

class ActivityChooserView$1 extends DataSetObserver
{
  public void onChanged()
  {
    super.onChanged();
    ActivityChooserView.access$000(this.this$0).notifyDataSetChanged();
  }

  public void onInvalidated()
  {
    super.onInvalidated();
    ActivityChooserView.access$000(this.this$0).notifyDataSetInvalidated();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.1
 * JD-Core Version:    0.6.0
 */