package net.photopay.settings;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.Set;
import net.photopay.recognition.NativeRecognizerWrapper;
import net.photopay.util.Log;

public final class llIIlIlIIl
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new llIIlIlIIl.1();
  private Bundle IlIllIlIIl = null;

  public llIIlIlIIl()
  {
    this.IlIllIlIIl = new Bundle();
  }

  private llIIlIlIIl(Parcel paramParcel)
  {
    this.IlIllIlIIl = paramParcel.readBundle();
  }

  public final int IIlIIIllIl()
  {
    return this.IlIllIlIIl.getInt("photopaymode", 0);
  }

  public final void IIlIIIllIl(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("datamatrix", paramBoolean);
  }

  public final void IlIIlIIIII()
  {
    Iterator localIterator = IlIllIlIIl.IIlIIIllIl.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.IlIllIlIIl.putBoolean(str, false);
    }
  }

  public final void IlIllIlllI(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("itf", paramBoolean);
  }

  public final void IllIIIIllI(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("aztec", paramBoolean);
  }

  public final void IllIIIllII(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2))
      paramInt = 0;
    this.IlIllIlIIl.putInt("photopaymode", paramInt);
  }

  public final void IllIIlIIII(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("upca", paramBoolean);
  }

  public final void IlllIIIllI()
  {
    Iterator localIterator = IlIllIlIIl.lllIIIlIlI.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.IlIllIlIIl.putBoolean(str, false);
    }
  }

  public final int describeContents()
  {
    return 0;
  }

  public final Bundle getAsBundle()
  {
    return this.IlIllIlIIl;
  }

  public final void lIIIIIlIlI(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("upce", paramBoolean);
  }

  public final void lIIIIIllll(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("ean13", paramBoolean);
  }

  public final void lIlIIIIlIl(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("code128", paramBoolean);
  }

  public final void llIIIlllll(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("pdf417", paramBoolean);
  }

  public final void llIIlIIlll(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("code39", paramBoolean);
  }

  public final RecognizerSettingsStatus llIIlIlIIl()
  {
    int i = 1;
    Iterator localIterator1 = IlIllIlIIl.IIlIIIllIl.iterator();
    String str2;
    do
    {
      if (!localIterator1.hasNext())
        break;
      str2 = (String)localIterator1.next();
    }
    while (!this.IlIllIlIIl.getBoolean(str2, false));
    for (int j = i; ; j = 0)
    {
      Iterator localIterator2 = IlIllIlIIl.lllIIIlIlI.iterator();
      String str1;
      do
      {
        if (!localIterator2.hasNext())
          break;
        str1 = (String)localIterator2.next();
      }
      while (!this.IlIllIlIIl.getBoolean(str1, false));
      while (true)
      {
        RecognizerSettingsStatus localRecognizerSettingsStatus;
        if ((i != 0) && (j != 0))
          localRecognizerSettingsStatus = RecognizerSettingsStatus.llIIlIlIIl;
        while (true)
        {
          return localRecognizerSettingsStatus;
          if (i != 0)
          {
            localRecognizerSettingsStatus = RecognizerSettingsStatus.IllIIIllII;
            continue;
          }
          if (j != 0)
          {
            localRecognizerSettingsStatus = RecognizerSettingsStatus.IlIllIlIIl;
            continue;
          }
          localRecognizerSettingsStatus = RecognizerSettingsStatus.llIIIlllll;
        }
        i = 0;
      }
    }
  }

  public final void lllIIIlIlI(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("ean8", paramBoolean);
  }

  public final void lllIIlIIlI()
  {
    NativeLibraryInfo localNativeLibraryInfo = NativeRecognizerWrapper.llIIlIlIIl();
    if (localNativeLibraryInfo == null)
    {
      Log.e(this, "libPhotoPay.so has not been loaded", new Object[0]);
      this.IlIllIlIIl.clear();
    }
    while (true)
    {
      return;
      Log.d(this, "Building settings object from library info", new Object[0]);
      Bundle localBundle = localNativeLibraryInfo.getAsBundle();
      Iterator localIterator = IlIllIlIIl.IlIllIlllI.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.IlIllIlIIl.putBoolean(str, localBundle.getBoolean(str, false));
      }
    }
  }

  public final void lllIlIlIIl(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("qrcode", paramBoolean);
  }

  public final void setInverseScanning(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("scaninverse", paramBoolean);
  }

  public final void setNullQuietZoneAllowed(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("nullquietzone", paramBoolean);
  }

  public final void setUncertainScanning(boolean paramBoolean)
  {
    this.IlIllIlIIl.putBoolean("scanuncertain", paramBoolean);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.IlIllIlIIl);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.settings.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */