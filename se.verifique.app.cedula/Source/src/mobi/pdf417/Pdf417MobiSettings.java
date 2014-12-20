package mobi.pdf417;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Pdf417MobiSettings
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Pdf417MobiSettings.1();
  private boolean IIlIIIllIl = false;
  private boolean IlIllIlIIl = true;
  private boolean IlIllIlllI = false;
  private boolean IlIlllllII = true;
  private boolean IllIIIIllI = false;
  private boolean IllIIIllII = true;
  private boolean IllIIlIIII = false;
  private boolean lIIIIIlIlI = false;
  private boolean lIIIIIllll = false;
  private boolean lIlIIIIlIl = false;
  private boolean llIIIlllll = false;
  private boolean llIIlIIIll = false;
  private boolean llIIlIIlll = false;
  private boolean llIIlIlIIl = true;
  private boolean lllIIIlIlI = false;
  private boolean lllIlIlIIl = false;

  public Pdf417MobiSettings()
  {
  }

  Pdf417MobiSettings(Parcel paramParcel)
  {
    boolean[] arrayOfBoolean = new boolean[16];
    paramParcel.readBooleanArray(arrayOfBoolean);
    llIIlIlIIl(arrayOfBoolean);
  }

  private void llIIlIlIIl(boolean[] paramArrayOfBoolean)
  {
    this.IlIllIlIIl = paramArrayOfBoolean[0];
    this.llIIlIlIIl = paramArrayOfBoolean[1];
    this.IlIlllllII = paramArrayOfBoolean[2];
    this.llIIlIIIll = paramArrayOfBoolean[3];
    this.lIlIIIIlIl = paramArrayOfBoolean[4];
    this.llIIlIIlll = paramArrayOfBoolean[5];
    this.IIlIIIllIl = paramArrayOfBoolean[6];
    this.lIIIIIllll = paramArrayOfBoolean[7];
    this.lllIIIlIlI = paramArrayOfBoolean[8];
    this.IlIllIlllI = paramArrayOfBoolean[9];
    this.lllIlIlIIl = paramArrayOfBoolean[10];
    this.IllIIIllII = paramArrayOfBoolean[11];
    this.llIIIlllll = paramArrayOfBoolean[12];
    this.IllIIIIllI = paramArrayOfBoolean[13];
    this.IllIIlIIII = paramArrayOfBoolean[14];
    this.lIIIIIlIlI = paramArrayOfBoolean[15];
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isAztecCodeEnabled()
  {
    return this.IllIIlIIII;
  }

  public boolean isCode128Enabled()
  {
    return this.lIlIIIIlIl;
  }

  public boolean isCode39Enabled()
  {
    return this.llIIlIIlll;
  }

  public boolean isDataMatrixEnabled()
  {
    return this.lIIIIIlIlI;
  }

  public boolean isDontShowDialog()
  {
    return this.llIIlIIIll;
  }

  public boolean isEAN13Enabled()
  {
    return this.IIlIIIllIl;
  }

  public boolean isEAN8Enabled()
  {
    return this.lIIIIIllll;
  }

  public boolean isITFEnabled()
  {
    return this.lllIIIlIlI;
  }

  public boolean isInverseScanMode()
  {
    return this.IllIIIIllI;
  }

  public boolean isNullQuietZoneAllowed()
  {
    return this.llIIIlllll;
  }

  public boolean isPdf417Enabled()
  {
    return this.IlIllIlIIl;
  }

  public boolean isQrCodeEnabled()
  {
    return this.llIIlIlIIl;
  }

  public boolean isRemoveOverlayEnabled()
  {
    return this.IlIlllllII;
  }

  public boolean isUPCAEnabled()
  {
    return this.IlIllIlllI;
  }

  public boolean isUPCEEnabled()
  {
    return this.lllIlIlIIl;
  }

  public boolean isUncertainScanMode()
  {
    return this.IllIIIllII;
  }

  public void setAll1DBarcodesEnabled(boolean paramBoolean)
  {
    this.lIlIIIIlIl = paramBoolean;
    this.llIIlIIlll = paramBoolean;
    this.IIlIIIllIl = paramBoolean;
    this.lIIIIIllll = paramBoolean;
    this.lllIIIlIlI = paramBoolean;
    this.IlIllIlllI = paramBoolean;
    this.lllIlIlIIl = paramBoolean;
  }

  public void setAll2DBarcodesEnabled(boolean paramBoolean)
  {
    this.llIIlIlIIl = paramBoolean;
    this.IlIllIlIIl = paramBoolean;
    this.IllIIlIIII = paramBoolean;
    this.lIIIIIlIlI = paramBoolean;
    this.IllIIIllII = false;
  }

  public void setAllSettings(boolean paramBoolean)
  {
    boolean[] arrayOfBoolean = new boolean[16];
    for (int i = 0; i < 16; i++)
      arrayOfBoolean[i] = paramBoolean;
    llIIlIlIIl(arrayOfBoolean);
  }

  public void setAztecCodeEnabled(boolean paramBoolean)
  {
    this.IllIIlIIII = paramBoolean;
  }

  public void setCode128Enabled(boolean paramBoolean)
  {
    this.lIlIIIIlIl = paramBoolean;
  }

  public void setCode39Enabled(boolean paramBoolean)
  {
    this.llIIlIIlll = paramBoolean;
  }

  public void setDataMatrixEnabled(boolean paramBoolean)
  {
    this.lIIIIIlIlI = paramBoolean;
  }

  public void setDontShowDialog(boolean paramBoolean)
  {
    this.llIIlIIIll = paramBoolean;
  }

  public void setEan13Enabled(boolean paramBoolean)
  {
    this.IIlIIIllIl = paramBoolean;
  }

  public void setEan8Enabled(boolean paramBoolean)
  {
    this.lIIIIIllll = paramBoolean;
  }

  public void setInverseScanning(boolean paramBoolean)
  {
    this.IllIIIIllI = paramBoolean;
  }

  public void setItfEnabled(boolean paramBoolean)
  {
    this.lllIIIlIlI = paramBoolean;
  }

  public void setNullQuietZoneAllowed(boolean paramBoolean)
  {
    this.llIIIlllll = paramBoolean;
  }

  public void setPdf417Enabled(boolean paramBoolean)
  {
    this.IlIllIlIIl = paramBoolean;
  }

  public void setQrCodeEnabled(boolean paramBoolean)
  {
    this.llIIlIlIIl = paramBoolean;
  }

  public void setRemoveOverlayEnabled(boolean paramBoolean)
  {
    this.IlIlllllII = paramBoolean;
  }

  public void setUncertainScanning(boolean paramBoolean)
  {
    this.IllIIIllII = paramBoolean;
  }

  public void setUpcaEnabled(boolean paramBoolean)
  {
    this.IlIllIlllI = paramBoolean;
  }

  public void setUpceEnabled(boolean paramBoolean)
  {
    this.lllIlIlIIl = paramBoolean;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[16];
    arrayOfBoolean[0] = this.IlIllIlIIl;
    arrayOfBoolean[1] = this.llIIlIlIIl;
    arrayOfBoolean[2] = this.IlIlllllII;
    arrayOfBoolean[3] = this.llIIlIIIll;
    arrayOfBoolean[4] = this.lIlIIIIlIl;
    arrayOfBoolean[5] = this.llIIlIIlll;
    arrayOfBoolean[6] = this.IIlIIIllIl;
    arrayOfBoolean[7] = this.lIIIIIllll;
    arrayOfBoolean[8] = this.lllIIIlIlI;
    arrayOfBoolean[9] = this.IlIllIlllI;
    arrayOfBoolean[10] = this.lllIlIlIIl;
    arrayOfBoolean[11] = this.IllIIIllII;
    arrayOfBoolean[12] = this.llIIIlllll;
    arrayOfBoolean[13] = this.IllIIIIllI;
    arrayOfBoolean[14] = this.IllIIlIIII;
    arrayOfBoolean[15] = this.lIIIIIlIlI;
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     mobi.pdf417.Pdf417MobiSettings
 * JD-Core Version:    0.6.0
 */