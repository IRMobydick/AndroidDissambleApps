package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ln;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import java.util.ArrayList;

public final class LoyaltyWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new j();
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  int k;
  ArrayList l;
  l m;
  ArrayList n;
  String o;
  String p;
  ArrayList q;
  boolean r;
  ArrayList s;
  ArrayList t;
  ArrayList u;
  f v;
  private final int w;

  LoyaltyWalletObject()
  {
    this.w = 4;
    this.l = ln.a();
    this.n = ln.a();
    this.q = ln.a();
    this.s = ln.a();
    this.t = ln.a();
    this.u = ln.a();
  }

  LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList paramArrayList1, l paraml, ArrayList paramArrayList2, String paramString11, String paramString12, ArrayList paramArrayList3, boolean paramBoolean, ArrayList paramArrayList4, ArrayList paramArrayList5, ArrayList paramArrayList6, f paramf)
  {
    this.w = paramInt1;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramInt2;
    this.l = paramArrayList1;
    this.m = paraml;
    this.n = paramArrayList2;
    this.o = paramString11;
    this.p = paramString12;
    this.q = paramArrayList3;
    this.r = paramBoolean;
    this.s = paramArrayList4;
    this.t = paramArrayList5;
    this.u = paramArrayList6;
    this.v = paramf;
  }

  public int a()
  {
    return this.w;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.LoyaltyWalletObject
 * JD-Core Version:    0.6.0
 */