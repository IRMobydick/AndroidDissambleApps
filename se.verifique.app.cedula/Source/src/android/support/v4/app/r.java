package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class r
  implements Animation.AnimationListener
{
  r(p paramp, Fragment paramFragment)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.b != null)
    {
      this.a.b = null;
      this.b.a(this.a, this.a.c, 0, 0, false);
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.r
 * JD-Core Version:    0.6.0
 */