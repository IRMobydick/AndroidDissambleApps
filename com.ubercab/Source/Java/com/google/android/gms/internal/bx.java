package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@ez
public final class bx
{
  public static final by pA = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
    }
  };
  public static final by pB = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("urls");
      if (TextUtils.isEmpty(str1))
      {
        gs.W("URLs missing in canOpenURLs GMSG.");
        return;
      }
      String[] arrayOfString1 = str1.split(",");
      HashMap localHashMap = new HashMap();
      PackageManager localPackageManager = paramAnonymousgv.getContext().getPackageManager();
      int i = arrayOfString1.length;
      int j = 0;
      if (j < i)
      {
        String str2 = arrayOfString1[j];
        String[] arrayOfString2 = str2.split(";", 2);
        String str3 = arrayOfString2[0].trim();
        String str4;
        if (arrayOfString2.length > 1)
        {
          str4 = arrayOfString2[1].trim();
          label108: if (localPackageManager.resolveActivity(new Intent(str4, Uri.parse(str3)), 65536) == null)
            break label161;
        }
        label161: for (boolean bool = true; ; bool = false)
        {
          localHashMap.put(str2, Boolean.valueOf(bool));
          j++;
          break;
          str4 = "android.intent.action.VIEW";
          break label108;
        }
      }
      paramAnonymousgv.a("openableURLs", localHashMap);
    }
  };
  public static final by pC = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("u");
      if (str1 == null)
      {
        gs.W("URL missing from click GMSG.");
        return;
      }
      Uri localUri1 = Uri.parse(str1);
      try
      {
        k localk = paramAnonymousgv.dw();
        if ((localk != null) && (localk.b(localUri1)))
        {
          Uri localUri3 = localk.a(localUri1, paramAnonymousgv.getContext());
          localUri2 = localUri3;
          String str2 = localUri2.toString();
          new gq(paramAnonymousgv.getContext(), paramAnonymousgv.dx().wD, str2).start();
          return;
        }
      }
      catch (l locall)
      {
        while (true)
        {
          gs.W("Unable to append parameter to URL: " + str1);
          Uri localUri2 = localUri1;
        }
      }
    }
  };
  public static final by pD = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      dk localdk = paramAnonymousgv.dt();
      if (localdk == null)
      {
        gs.W("A GMSG tried to close something that wasn't an overlay.");
        return;
      }
      localdk.close();
    }
  };
  public static final by pE = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousgv.o("1".equals(paramAnonymousMap.get("custom_close")));
    }
  };
  public static final by pF = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      String str = (String)paramAnonymousMap.get("u");
      if (str == null)
      {
        gs.W("URL missing from httpTrack GMSG.");
        return;
      }
      new gq(paramAnonymousgv.getContext(), paramAnonymousgv.dx().wD, str).start();
    }
  };
  public static final by pG = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      gs.U("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final by pH = new by()
  {
    public void a(gv paramAnonymousgv, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str2 = (String)paramAnonymousMap.get("ty");
      String str3 = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(str3);
        k localk = paramAnonymousgv.dw();
        if (localk != null)
          localk.z().a(i, j, k);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        gs.W("Could not parse touch parameters from gmsg.");
      }
    }
  };
  public static final by pI = new ce();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bx
 * JD-Core Version:    0.6.2
 */