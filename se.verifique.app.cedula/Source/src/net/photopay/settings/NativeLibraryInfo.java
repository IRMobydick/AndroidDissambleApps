package net.photopay.settings;

import android.os.Bundle;
import net.photopay.util.Log;

public class NativeLibraryInfo
{
  private Bundle llIIlIlIIl;

  static
  {
    if (!NativeLibraryInfo.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      lIlllIlIlI = bool;
      return;
    }
  }

  public NativeLibraryInfo(Bundle paramBundle)
  {
    this.llIIlIlIIl = paramBundle;
    if ((!lIlllIlIlI) && (this.llIIlIlIIl == null))
      throw new AssertionError();
  }

  public static NativeLibraryInfo getThinClientLibInfo()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("libinitsuccessful", true);
    localBundle.putInt("maximagesize", 4096);
    return new NativeLibraryInfo(localBundle);
  }

  public boolean areZxingReadersEnabled()
  {
    return this.llIIlIlIIl.getBoolean("zxingenabled", false);
  }

  public Bundle getAsBundle()
  {
    return this.llIIlIlIIl;
  }

  public String getAvailableOCREngines()
  {
    String str = this.llIIlIlIIl.getString("ocrenginelist");
    if (str == null)
      str = "";
    return str;
  }

  public String getBuildVersion()
  {
    String str = this.llIIlIlIIl.getString("buildversion");
    if (str == null)
      str = "unknown";
    return str;
  }

  public String getErrorList()
  {
    String str = this.llIIlIlIIl.getString("errorlist");
    if (str == null)
      str = "";
    return str;
  }

  public int getMaxImageSize()
  {
    return this.llIIlIlIIl.getInt("maximagesize", 2000);
  }

  public boolean isAusQRCodeEnabled()
  {
    return this.llIIlIlIIl.getBoolean("ausqrcode", false);
  }

  public boolean isAusSlipEnabled()
  {
    return this.llIIlIlIIl.getBoolean("ausslip", false);
  }

  public boolean isBeSlipEnabled()
  {
    return this.llIIlIlIIl.getBoolean("beslip", false);
  }

  public boolean isCroPdf417Enabled()
  {
    return this.llIIlIlIIl.getBoolean("cropdf417", false);
  }

  public boolean isCroSlipEnabled()
  {
    return this.llIIlIlIIl.getBoolean("croslip", false);
  }

  public boolean isDeQRCodeEnabled()
  {
    return this.llIIlIlIIl.getBoolean("deqrcode", false);
  }

  public boolean isDeSlipEnabled()
  {
    return this.llIIlIlIIl.getBoolean("deslip", false);
  }

  public boolean isGpuActive()
  {
    return this.llIIlIlIIl.getBoolean("gpuactive", false);
  }

  public boolean isHuSlipEnabled()
  {
    return this.llIIlIlIIl.getBoolean("huslip", false);
  }

  public boolean isLibrarySuccessfultInitialized()
  {
    return this.llIIlIlIIl.getBoolean("libinitsuccessful", false);
  }

  public boolean isNlSlipEnabled()
  {
    int i = 0;
    if ((this.llIIlIlIIl.getBoolean("nlslip", false)) || (this.llIIlIlIIl.getBoolean("nlocrline", false)))
      i = 1;
    return i;
  }

  public boolean isOcrOnlyEnabled()
  {
    return this.llIIlIlIIl.getBoolean("ocronly", false);
  }

  public boolean isPdf417ReaderEnabled()
  {
    return this.llIIlIlIIl.getBoolean("pdf417", false);
  }

  public boolean isPhotoBullEnabled()
  {
    return this.llIIlIlIIl.getBoolean("paybull", false);
  }

  public boolean isPhotoMathEnabled()
  {
    return this.llIIlIlIIl.getBoolean("photomath", false);
  }

  public boolean isSerbBillEnabled()
  {
    return this.llIIlIlIIl.getBoolean("serbbill", false);
  }

  public boolean isSloSlipEnabled()
  {
    return this.llIIlIlIIl.getBoolean("sloslip", false);
  }

  public boolean isUSDriverLicenseEnabled()
  {
    return this.llIIlIlIIl.getBoolean("usdl", false);
  }

  public void log()
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Boolean.valueOf(isLibrarySuccessfultInitialized());
    Log.i(this, "Library initialization was successful: {}", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = getAvailableOCREngines();
    Log.i(this, "Available OCR engines: {}", arrayOfObject2);
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = Boolean.valueOf(isGpuActive());
    Log.i(this, "GPU acceleration active: {}", arrayOfObject3);
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = Integer.valueOf(getMaxImageSize());
    Log.i(this, "Maximum input image dimension: {}", arrayOfObject4);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = Boolean.valueOf(isAusSlipEnabled());
    Log.i(this, "Austrian slip scanning enabled: {}", arrayOfObject5);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = Boolean.valueOf(isAusQRCodeEnabled());
    Log.i(this, "Austrian QR code scanning enabled: {}", arrayOfObject6);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = Boolean.valueOf(isCroSlipEnabled());
    Log.i(this, "Croatian slip scanning enabled: {}", arrayOfObject7);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = Boolean.valueOf(isCroPdf417Enabled());
    Log.i(this, "Croatian PDF417 barcode scanning enabled: {}", arrayOfObject8);
    Object[] arrayOfObject9 = new Object[1];
    arrayOfObject9[0] = Boolean.valueOf(isNlSlipEnabled());
    Log.i(this, "Dutch slip scanning enabled: {}", arrayOfObject9);
    Object[] arrayOfObject10 = new Object[1];
    arrayOfObject10[0] = Boolean.valueOf(isDeSlipEnabled());
    Log.i(this, "German slip scanning enabled: {}", arrayOfObject10);
    Object[] arrayOfObject11 = new Object[1];
    arrayOfObject11[0] = Boolean.valueOf(isDeQRCodeEnabled());
    Log.i(this, "German QR code scanning enabled: {}", arrayOfObject11);
    Object[] arrayOfObject12 = new Object[1];
    arrayOfObject12[0] = Boolean.valueOf(isHuSlipEnabled());
    Log.i(this, "Hungarian slip scanning enabled: {}", arrayOfObject12);
    Object[] arrayOfObject13 = new Object[1];
    arrayOfObject13[0] = Boolean.valueOf(isSloSlipEnabled());
    Log.i(this, "Slovenian slip scanning enabled: {}", arrayOfObject13);
    Object[] arrayOfObject14 = new Object[1];
    arrayOfObject14[0] = Boolean.valueOf(isPhotoBullEnabled());
    Log.i(this, "PhotoBull QR code scanning enabled: {}", arrayOfObject14);
    Object[] arrayOfObject15 = new Object[1];
    arrayOfObject15[0] = Boolean.valueOf(isPdf417ReaderEnabled());
    Log.i(this, "PDF 417 reader enabled: {}", arrayOfObject15);
    Object[] arrayOfObject16 = new Object[1];
    arrayOfObject16[0] = Boolean.valueOf(isUSDriverLicenseEnabled());
    Log.i(this, "US driver's license enabled: {}", arrayOfObject16);
    Object[] arrayOfObject17 = new Object[1];
    arrayOfObject17[0] = Boolean.valueOf(areZxingReadersEnabled());
    Log.i(this, "ZXing barcode readers enabled: {}", arrayOfObject17);
    Object[] arrayOfObject18 = new Object[1];
    arrayOfObject18[0] = Boolean.valueOf(isPhotoMathEnabled());
    Log.i(this, "PhotoMath enabled: {}", arrayOfObject18);
    String str = getErrorList();
    if ((str == null) || ("".equals(str)))
      Log.i(this, "No reported errors in native library.", new Object[0]);
    while (true)
    {
      return;
      Object[] arrayOfObject19 = new Object[1];
      arrayOfObject19[0] = str;
      Log.e(this, "Native library reported following errors: {}", arrayOfObject19);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.settings.NativeLibraryInfo
 * JD-Core Version:    0.6.0
 */