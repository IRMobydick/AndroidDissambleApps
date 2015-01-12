package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PackageStats
  implements Parcelable
{
  public static final Parcelable.Creator<PackageStats> CREATOR = new Parcelable.Creator()
  {
    public PackageStats createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PackageStats(paramAnonymousParcel);
    }

    public PackageStats[] newArray(int paramAnonymousInt)
    {
      return new PackageStats[paramAnonymousInt];
    }
  };
  public long cacheSize;
  public long codeSize;
  public long dataSize;
  public String packageName;

  public PackageStats(PackageStats paramPackageStats)
  {
    this.packageName = paramPackageStats.packageName;
    this.codeSize = paramPackageStats.codeSize;
    this.dataSize = paramPackageStats.dataSize;
    this.cacheSize = paramPackageStats.cacheSize;
  }

  public PackageStats(Parcel paramParcel)
  {
    this.packageName = paramParcel.readString();
    this.codeSize = paramParcel.readLong();
    this.dataSize = paramParcel.readLong();
    this.cacheSize = paramParcel.readLong();
  }

  public PackageStats(String paramString)
  {
    this.packageName = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "PackageStats{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.packageName);
    paramParcel.writeLong(this.codeSize);
    paramParcel.writeLong(this.dataSize);
    paramParcel.writeLong(this.cacheSize);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.content.pm.PackageStats
 * JD-Core Version:    0.6.2
 */