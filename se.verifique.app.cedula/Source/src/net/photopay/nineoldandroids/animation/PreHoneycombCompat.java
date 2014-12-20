package net.photopay.nineoldandroids.animation;

import net.photopay.nineoldandroids.util.Property;

final class PreHoneycombCompat
{
  static Property ALPHA = new PreHoneycombCompat.1("alpha");
  static Property PIVOT_X = new PreHoneycombCompat.2("pivotX");
  static Property PIVOT_Y = new PreHoneycombCompat.3("pivotY");
  static Property ROTATION;
  static Property ROTATION_X;
  static Property ROTATION_Y;
  static Property SCALE_X;
  static Property SCALE_Y;
  static Property SCROLL_X;
  static Property SCROLL_Y;
  static Property TRANSLATION_X = new PreHoneycombCompat.4("translationX");
  static Property TRANSLATION_Y = new PreHoneycombCompat.5("translationY");
  static Property X;
  static Property Y;

  static
  {
    ROTATION = new PreHoneycombCompat.6("rotation");
    ROTATION_X = new PreHoneycombCompat.7("rotationX");
    ROTATION_Y = new PreHoneycombCompat.8("rotationY");
    SCALE_X = new PreHoneycombCompat.9("scaleX");
    SCALE_Y = new PreHoneycombCompat.10("scaleY");
    SCROLL_X = new PreHoneycombCompat.11("scrollX");
    SCROLL_Y = new PreHoneycombCompat.12("scrollY");
    X = new PreHoneycombCompat.13("x");
    Y = new PreHoneycombCompat.14("y");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.animation.PreHoneycombCompat
 * JD-Core Version:    0.6.0
 */