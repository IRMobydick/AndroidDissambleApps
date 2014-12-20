package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ln;
import java.util.ArrayList;

public class CommonWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new e();
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  int i;
  ArrayList j;
  l k;
  ArrayList l;
  String m;
  String n;
  ArrayList o;
  boolean p;
  ArrayList q;
  ArrayList r;
  ArrayList s;
  private final int t;

  CommonWalletObject()
  {
    this.t = 1;
    this.j = ln.a();
    this.l = ln.a();
    this.o = ln.a();
    this.q = ln.a();
    this.r = ln.a();
    this.s = ln.a();
  }

  CommonWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, ArrayList paramArrayList1, l paraml, ArrayList paramArrayList2, String paramString9, String paramString10, ArrayList paramArrayList3, boolean paramBoolean, ArrayList paramArrayList4, ArrayList paramArrayList5, ArrayList paramArrayList6)
  {
    this.t = paramInt1;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramInt2;
    this.j = paramArrayList1;
    this.k = paraml;
    this.l = paramArrayList2;
    this.m = paramString9;
    this.n = paramString10;
    this.o = paramArrayList3;
    this.p = paramBoolean;
    this.q = paramArrayList4;
    this.r = paramArrayList5;
    this.s = paramArrayList6;
  }

  public static c a()
  {
    CommonWalletObject localCommonWalletObject = new CommonWalletObject();
    localCommonWalletObject.getClass();
    return new c(localCommonWalletObject, null);
  }

  public int b()
  {
    return this.t;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.CommonWalletObject
 * JD-Core Version:    0.6.0
 */