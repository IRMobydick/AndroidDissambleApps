package com.google.android.gms.common;

import android.app.PendingIntent;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class a
{
  public static final a a = new a(0, null);
  private final PendingIntent b;
  private final int c;

  public a(int paramInt, PendingIntent paramPendingIntent)
  {
    this.c = paramInt;
    this.b = paramPendingIntent;
  }

  private String a()
  {
    String str;
    switch (this.c)
    {
    case 12:
    default:
      str = "unknown status code " + this.c;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 13:
    case 14:
    case 15:
    }
    while (true)
    {
      return str;
      str = "SUCCESS";
      continue;
      str = "SERVICE_MISSING";
      continue;
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      continue;
      str = "SERVICE_DISABLED";
      continue;
      str = "SIGN_IN_REQUIRED";
      continue;
      str = "INVALID_ACCOUNT";
      continue;
      str = "RESOLUTION_REQUIRED";
      continue;
      str = "NETWORK_ERROR";
      continue;
      str = "INTERNAL_ERROR";
      continue;
      str = "SERVICE_INVALID";
      continue;
      str = "DEVELOPER_ERROR";
      continue;
      str = "LICENSE_CHECK_FAILED";
      continue;
      str = "CANCELED";
      continue;
      str = "TIMEOUT";
      continue;
      str = "INTERRUPTED";
    }
  }

  public String toString()
  {
    return kt.a(this).a("statusCode", a()).a("resolution", this.b).toString();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.a
 * JD-Core Version:    0.6.0
 */