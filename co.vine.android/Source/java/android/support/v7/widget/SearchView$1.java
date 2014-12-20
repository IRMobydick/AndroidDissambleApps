package android.support.v7.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

class SearchView$1
  implements Runnable
{
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
      SearchView.HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(localInputMethodManager, this.this$0, 0);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView.1
 * JD-Core Version:    0.6.0
 */