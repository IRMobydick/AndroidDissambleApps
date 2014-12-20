package net.photopay.hardware.orientation;

public enum Orientation
{
  private boolean horizontal;
  private int value;
  private boolean vertical;

  static
  {
    ORIENTATION_LANDSCAPE_RIGHT = new Orientation("ORIENTATION_LANDSCAPE_RIGHT", 1, 1, false, true);
    ORIENTATION_PORTRAIT_UPSIDE = new Orientation("ORIENTATION_PORTRAIT_UPSIDE", 2, 2, true, false);
    ORIENTATION_LANDSCAPE_LEFT = new Orientation("ORIENTATION_LANDSCAPE_LEFT", 3, 3, false, true);
    ORIENTATION_UNKNOWN = new Orientation("ORIENTATION_UNKNOWN", 4, 4, false, false);
    Orientation[] arrayOfOrientation = new Orientation[5];
    arrayOfOrientation[0] = ORIENTATION_PORTRAIT;
    arrayOfOrientation[1] = ORIENTATION_LANDSCAPE_RIGHT;
    arrayOfOrientation[2] = ORIENTATION_PORTRAIT_UPSIDE;
    arrayOfOrientation[3] = ORIENTATION_LANDSCAPE_LEFT;
    arrayOfOrientation[4] = ORIENTATION_UNKNOWN;
    $VALUES = arrayOfOrientation;
  }

  private Orientation(int paramBoolean2, boolean arg4, boolean arg5)
  {
    this.value = paramBoolean2;
    boolean bool1;
    this.vertical = bool1;
    boolean bool2;
    this.horizontal = bool2;
  }

  public static Orientation fromInt(int paramInt)
  {
    Orientation localOrientation;
    switch (paramInt)
    {
    default:
      localOrientation = ORIENTATION_UNKNOWN;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localOrientation;
      localOrientation = ORIENTATION_PORTRAIT;
      continue;
      localOrientation = ORIENTATION_LANDSCAPE_RIGHT;
      continue;
      localOrientation = ORIENTATION_PORTRAIT_UPSIDE;
      continue;
      localOrientation = ORIENTATION_LANDSCAPE_LEFT;
    }
  }

  public final int intValue()
  {
    return this.value;
  }

  public final boolean isHorizontal()
  {
    return this.horizontal;
  }

  public final boolean isVertical()
  {
    return this.vertical;
  }

  public final String toString()
  {
    String str;
    switch (this.value)
    {
    default:
      str = "Unknown";
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "Portrait";
      continue;
      str = "Landscape right";
      continue;
      str = "Inverse portrait";
      continue;
      str = "Landscape left";
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.orientation.Orientation
 * JD-Core Version:    0.6.0
 */