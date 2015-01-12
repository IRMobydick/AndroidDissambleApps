package com.inauth.utilities.dynamicid2;

import android.util.Log;
import com.inauth.utilities.ndk.InAuthNDK;

public class DynamicID2
{
  public static String getDynamicID2(String paramString)
  {
    Log.e("currentTimeInJava", "" + System.currentTimeMillis());
    return InAuthNDK.getInstance().getDynamicIDNDK(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.dynamicid2.DynamicID2
 * JD-Core Version:    0.6.2
 */