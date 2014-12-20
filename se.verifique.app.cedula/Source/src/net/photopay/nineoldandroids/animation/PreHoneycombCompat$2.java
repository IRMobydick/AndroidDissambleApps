package net.photopay.nineoldandroids.animation;

import android.view.View;
import net.photopay.nineoldandroids.util.FloatProperty;
import net.photopay.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat$2 extends FloatProperty
{
  public final Float get(View paramView)
  {
    return Float.valueOf(AnimatorProxy.wrap(paramView).getPivotX());
  }

  public final void setValue(View paramView, float paramFloat)
  {
    AnimatorProxy.wrap(paramView).setPivotX(paramFloat);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.animation.PreHoneycombCompat.2
 * JD-Core Version:    0.6.0
 */