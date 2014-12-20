package android.support.v7.widget;

import android.support.v4.widget.CursorAdapter;

class SearchView$3
  implements Runnable
{
  public void run()
  {
    if ((SearchView.access$100(this.this$0) != null) && ((SearchView.access$100(this.this$0) instanceof SuggestionsAdapter)))
      SearchView.access$100(this.this$0).changeCursor(null);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView.3
 * JD-Core Version:    0.6.0
 */