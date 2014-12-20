package net.photopay.recognition;

public enum Right
{
  private String lIIIIIllll;
  private int lllIIIlIlI;

  static
  {
    jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRight = new Right("ALLOW_CUSTOM_UI", 0, 0, "ALLOW_CUSTOM_UI: allow custom camera overlay when using library");
    IlIllIlIIl = new Right("PDF417_ALLOW_DISABLE_OVERLAY_LOGO", 1, 1, "PDF417_ALLOW_DISABLE_OVERLAY_LOGO: allow disabling overlay logo when using PDF417.mobi library");
    IllIIIllII = new Right("PDF417_ALLOW_DISABLE_SCAN_DIALOG", 2, 2, "PDF417_ALLOW_DISABLE_SCAN_DIALOG: allow disabling scan dialog when using PDF417.mobi library");
    llIIIlllll = new Right("PDF417_ALLOW_USDL", 3, 3, "PDF417_ALLOW_USDL: allow US driver license scanner inside PDF417.mobi library");
    Right[] arrayOfRight = new Right[4];
    arrayOfRight[0] = jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRight;
    arrayOfRight[1] = IlIllIlIIl;
    arrayOfRight[2] = IllIIIllII;
    arrayOfRight[3] = llIIIlllll;
    jdField_llIIlIlIIl_of_type_ArrayOfNetPhotopayRecognitionRight = arrayOfRight;
  }

  private Right(int arg3, String arg4)
  {
    int i;
    this.lllIIIlIlI = i;
    Object localObject;
    this.lIIIIIllll = localObject;
  }

  public static Right fromIntValue(int paramInt)
  {
    Right localRight;
    switch (paramInt)
    {
    default:
      localRight = null;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localRight;
      localRight = jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionRight;
      continue;
      localRight = IlIllIlIIl;
      continue;
      localRight = IllIIIllII;
      continue;
      localRight = llIIIlllll;
    }
  }

  public final String toString()
  {
    return this.lIIIIIllll;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.Right
 * JD-Core Version:    0.6.0
 */