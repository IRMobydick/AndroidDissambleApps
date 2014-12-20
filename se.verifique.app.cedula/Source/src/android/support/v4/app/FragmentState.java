package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new t();
  final String a;
  final int b;
  final boolean c;
  final int d;
  final int e;
  final String f;
  final boolean g;
  final boolean h;
  final Bundle i;
  Bundle j;
  Fragment k;

  public FragmentState(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.c = bool2;
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readString();
      if (paramParcel.readInt() == 0)
        break label110;
      bool3 = bool1;
      label70: this.g = bool3;
      if (paramParcel.readInt() == 0)
        break label116;
    }
    while (true)
    {
      this.h = bool1;
      this.i = paramParcel.readBundle();
      this.j = paramParcel.readBundle();
      return;
      bool2 = false;
      break;
      label110: bool3 = false;
      break label70;
      label116: bool1 = false;
    }
  }

  public FragmentState(Fragment paramFragment)
  {
    this.a = paramFragment.getClass().getName();
    this.b = paramFragment.f;
    this.c = paramFragment.o;
    this.d = paramFragment.w;
    this.e = paramFragment.x;
    this.f = paramFragment.y;
    this.g = paramFragment.B;
    this.h = paramFragment.A;
    this.i = paramFragment.h;
  }

  public Fragment a(h paramh, Fragment paramFragment)
  {
    if (this.k != null);
    for (Fragment localFragment = this.k; ; localFragment = this.k)
    {
      return localFragment;
      if (this.i != null)
        this.i.setClassLoader(paramh.getClassLoader());
      this.k = Fragment.a(paramh, this.a, this.i);
      if (this.j != null)
      {
        this.j.setClassLoader(paramh.getClassLoader());
        this.k.d = this.j;
      }
      this.k.a(this.b, paramFragment);
      this.k.o = this.c;
      this.k.q = true;
      this.k.w = this.d;
      this.k.x = this.e;
      this.k.y = this.f;
      this.k.B = this.g;
      this.k.A = this.h;
      this.k.s = paramh.b;
      if (!p.a)
        continue;
      Log.v("FragmentManager", "Instantiated fragment " + this.k);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    int n;
    int i1;
    if (this.c)
    {
      n = m;
      paramParcel.writeInt(n);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeString(this.f);
      if (!this.g)
        break label109;
      i1 = m;
      label68: paramParcel.writeInt(i1);
      if (!this.h)
        break label115;
    }
    while (true)
    {
      paramParcel.writeInt(m);
      paramParcel.writeBundle(this.i);
      paramParcel.writeBundle(this.j);
      return;
      n = 0;
      break;
      label109: i1 = 0;
      break label68;
      label115: m = 0;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentState
 * JD-Core Version:    0.6.0
 */