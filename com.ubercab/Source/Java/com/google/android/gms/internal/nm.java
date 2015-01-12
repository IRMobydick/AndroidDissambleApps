package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nm
  implements SafeParcelable
{
  public static final nn CREATOR = new nn();
  public final int akR;
  public final int akS;
  public final String akT;
  public final String akU;
  public final boolean akV;
  public final String packageName;
  public final int versionCode;

  public nm(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.packageName = paramString1;
    this.akR = paramInt2;
    this.akS = paramInt3;
    this.akT = paramString2;
    this.akU = paramString3;
    this.akV = paramBoolean;
  }

  public nm(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = 1;
    this.packageName = ((String)o.i(paramString1));
    this.akR = paramInt1;
    this.akS = paramInt2;
    this.akT = paramString2;
    this.akU = paramString3;
    this.akV = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    nm localnm;
    do
    {
      return true;
      if (!(paramObject instanceof nm))
        break;
      localnm = (nm)paramObject;
    }
    while ((this.packageName.equals(localnm.packageName)) && (this.akR == localnm.akR) && (this.akS == localnm.akS) && (n.equal(this.akT, localnm.akT)) && (n.equal(this.akU, localnm.akU)) && (this.akV == localnm.akV));
    return false;
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.packageName;
    arrayOfObject[1] = Integer.valueOf(this.akR);
    arrayOfObject[2] = Integer.valueOf(this.akS);
    arrayOfObject[3] = this.akT;
    arrayOfObject[4] = this.akU;
    arrayOfObject[5] = Boolean.valueOf(this.akV);
    return n.hashCode(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("package=").append(this.packageName).append(',');
    localStringBuilder.append("versionCode=").append(this.versionCode).append(',');
    localStringBuilder.append("logSource=").append(this.akS).append(',');
    localStringBuilder.append("uploadAccount=").append(this.akT).append(',');
    localStringBuilder.append("loggingId=").append(this.akU).append(',');
    localStringBuilder.append("logAndroidId=").append(this.akV);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nn.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nm
 * JD-Core Version:    0.6.2
 */