package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.aW;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.c;

public final class PayPalConfiguration
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new K();
  public static final String ENVIRONMENT_NO_NETWORK = "mock";
  public static final String ENVIRONMENT_PRODUCTION = "live";
  public static final String ENVIRONMENT_SANDBOX = "sandbox";
  private static final String a = PayPalConfiguration.class.getSimpleName();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private boolean g;
  private String h;
  private String i;
  private boolean j;
  private String k;
  private String l;
  private Uri m;
  private Uri n;
  private boolean o;

  public PayPalConfiguration()
  {
    this.j = true;
    this.o = true;
  }

  private PayPalConfiguration(Parcel paramParcel)
  {
    this.j = i1;
    this.o = i1;
    this.c = paramParcel.readString();
    this.b = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    int i2;
    int i3;
    if (paramParcel.readByte() == i1)
    {
      i2 = i1;
      this.g = i2;
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      if (paramParcel.readByte() != i1)
        break label163;
      i3 = i1;
      label98: this.j = i3;
      this.k = paramParcel.readString();
      this.l = paramParcel.readString();
      this.m = ((Uri)paramParcel.readParcelable(null));
      this.n = ((Uri)paramParcel.readParcelable(null));
      if (paramParcel.readByte() != i1)
        break label169;
    }
    while (true)
    {
      this.o = i1;
      return;
      i2 = 0;
      break;
      label163: i3 = 0;
      break label98;
      label169: i1 = 0;
    }
  }

  private static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      Log.e(a, paramString + " is invalid.  Please see the docs.");
  }

  public static final String getApplicationCorrelationId(Activity paramActivity)
  {
    b localb = b.a();
    if (localb.b() == null)
    {
      new m();
      localb.a(paramActivity, "AndroidBasePrefs");
    }
    String str = aW.a().a(paramActivity, b.a().c().e(), bb.b, "2.2.2", null, false);
    aW.a().d();
    return str;
  }

  public static final String getLibraryVersion()
  {
    return "2.2.2";
  }

  final String a()
  {
    return this.b;
  }

  public final PayPalConfiguration acceptCreditCards(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }

  final String b()
  {
    if (R.a(this.c))
    {
      this.c = "live";
      Log.w(a, "defaulting to production environment");
    }
    return this.c;
  }

  final String c()
  {
    return this.d;
  }

  public final PayPalConfiguration clientId(String paramString)
  {
    this.k = paramString;
    return this;
  }

  final String d()
  {
    return this.e;
  }

  public final PayPalConfiguration defaultUserEmail(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public final PayPalConfiguration defaultUserPhone(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public final PayPalConfiguration defaultUserPhoneCountryCode(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public final int describeContents()
  {
    return 0;
  }

  final String e()
  {
    return this.f;
  }

  public final PayPalConfiguration environment(String paramString)
  {
    this.c = paramString;
    return this;
  }

  final boolean f()
  {
    return this.g;
  }

  public final PayPalConfiguration forceDefaultsOnSandbox(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }

  final String g()
  {
    return this.h;
  }

  final String h()
  {
    return this.i;
  }

  final boolean i()
  {
    return this.j;
  }

  final boolean j()
  {
    return this.o;
  }

  final String k()
  {
    return this.k;
  }

  final String l()
  {
    return this.l;
  }

  public final PayPalConfiguration languageOrLocale(String paramString)
  {
    this.b = paramString;
    return this;
  }

  final String m()
  {
    return this.m.toString();
  }

  public final PayPalConfiguration merchantName(String paramString)
  {
    this.l = paramString;
    return this;
  }

  public final PayPalConfiguration merchantPrivacyPolicyUri(Uri paramUri)
  {
    this.m = paramUri;
    return this;
  }

  public final PayPalConfiguration merchantUserAgreementUri(Uri paramUri)
  {
    this.n = paramUri;
    return this;
  }

  final String n()
  {
    return this.n.toString();
  }

  final boolean o()
  {
    boolean bool1 = d.a(a, b(), "environment");
    a(bool1, "environment");
    boolean bool2;
    if (bool1)
      if (b().equals("mock"))
        bool2 = true;
    while (true)
      if ((bool1) && (bool2))
      {
        return true;
        bool2 = d.a(a, this.k, "clientId");
        a(bool2, "clientId");
      }
      else
      {
        return false;
        bool2 = false;
      }
  }

  public final PayPalConfiguration rememberUser(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }

  public final PayPalConfiguration sandboxUserPassword(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public final PayPalConfiguration sandboxUserPin(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public final String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.b;
    return String.format("PayPalConfig: {environment:%s: languageOrLocale:%s}", arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    int i2;
    int i3;
    if (this.g)
    {
      i2 = i1;
      paramParcel.writeByte((byte)i2);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      if (!this.j)
        break label146;
      i3 = i1;
      label85: paramParcel.writeByte((byte)i3);
      paramParcel.writeString(this.k);
      paramParcel.writeString(this.l);
      paramParcel.writeParcelable(this.m, 0);
      paramParcel.writeParcelable(this.n, 0);
      if (!this.o)
        break label152;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i1);
      return;
      i2 = 0;
      break;
      label146: i3 = 0;
      break label85;
      label152: i1 = 0;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalConfiguration
 * JD-Core Version:    0.6.2
 */