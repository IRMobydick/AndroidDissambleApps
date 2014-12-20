package android.support.v4.widget;

import android.support.v4.view.x;
import android.view.View;
import java.util.ArrayList;

class q
  implements Runnable
{
  final View a;

  q(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.a = paramView;
  }

  public void run()
  {
    if (this.a.getParent() == this.b)
    {
      x.a(this.a, 0, null);
      SlidingPaneLayout.a(this.b, this.a);
    }
    SlidingPaneLayout.a(this.b).remove(this);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.q
 * JD-Core Version:    0.6.0
 */