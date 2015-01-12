package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class t
{
  public static void a(Bundle paramBundle, String paramString, Parcelable paramParcelable)
  {
    paramBundle.setClassLoader(t.class.getClassLoader());
    Bundle localBundle = paramBundle.getBundle("map_state");
    if (localBundle == null)
      localBundle = new Bundle();
    localBundle.setClassLoader(t.class.getClassLoader());
    localBundle.putParcelable(paramString, paramParcelable);
    paramBundle.putBundle("map_state", localBundle);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.t
 * JD-Core Version:    0.6.2
 */