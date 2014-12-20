package net.photopay.nineoldandroids.view;

import android.view.View;
import net.photopay.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper
{
  public static float getAlpha(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getAlpha();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getAlpha(paramView);
    }
  }

  public static float getPivotX(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getPivotX();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getPivotX(paramView);
    }
  }

  public static float getPivotY(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getPivotY();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getPivotY(paramView);
    }
  }

  public static float getRotation(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getRotation();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getRotation(paramView);
    }
  }

  public static float getRotationX(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getRotationX();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getRotationX(paramView);
    }
  }

  public static float getRotationY(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getRotationY();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getRotationY(paramView);
    }
  }

  public static float getScaleX(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getScaleX();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getScaleX(paramView);
    }
  }

  public static float getScaleY(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getScaleY();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getScaleY(paramView);
    }
  }

  public static float getScrollX(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getScrollX();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getScrollX(paramView);
    }
  }

  public static float getScrollY(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getScrollY();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getScrollY(paramView);
    }
  }

  public static float getTranslationX(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getTranslationX();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getTranslationX(paramView);
    }
  }

  public static float getTranslationY(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getTranslationY();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getTranslationY(paramView);
    }
  }

  public static float getX(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getX();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getX(paramView);
    }
  }

  public static float getY(View paramView)
  {
    float f;
    if (AnimatorProxy.NEEDS_PROXY)
      f = AnimatorProxy.wrap(paramView).getY();
    while (true)
    {
      return f;
      f = ViewHelper.Honeycomb.getY(paramView);
    }
  }

  public static void setAlpha(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setAlpha(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setAlpha(paramView, paramFloat);
    }
  }

  public static void setPivotX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setPivotX(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setPivotX(paramView, paramFloat);
    }
  }

  public static void setPivotY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setPivotY(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setPivotY(paramView, paramFloat);
    }
  }

  public static void setRotation(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setRotation(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setRotation(paramView, paramFloat);
    }
  }

  public static void setRotationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setRotationX(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setRotationX(paramView, paramFloat);
    }
  }

  public static void setRotationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setRotationY(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setRotationY(paramView, paramFloat);
    }
  }

  public static void setScaleX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setScaleX(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setScaleX(paramView, paramFloat);
    }
  }

  public static void setScaleY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setScaleY(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setScaleY(paramView, paramFloat);
    }
  }

  public static void setScrollX(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setScrollX(paramInt);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setScrollX(paramView, paramInt);
    }
  }

  public static void setScrollY(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setScrollY(paramInt);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setScrollY(paramView, paramInt);
    }
  }

  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setTranslationX(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setTranslationX(paramView, paramFloat);
    }
  }

  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setTranslationY(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setTranslationY(paramView, paramFloat);
    }
  }

  public static void setX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setX(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setX(paramView, paramFloat);
    }
  }

  public static void setY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
      AnimatorProxy.wrap(paramView).setY(paramFloat);
    while (true)
    {
      return;
      ViewHelper.Honeycomb.setY(paramView, paramFloat);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.view.ViewHelper
 * JD-Core Version:    0.6.0
 */