package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class hs
  implements SafeParcelable
{
  public static final ht CREATOR = new ht();
  final int BR;
  final hg CD;
  final long CE;
  final int CF;
  final he CG;
  public final String oT;

  hs(int paramInt1, hg paramhg, long paramLong, int paramInt2, String paramString, he paramhe)
  {
    this.BR = paramInt1;
    this.CD = paramhg;
    this.CE = paramLong;
    this.CF = paramInt2;
    this.oT = paramString;
    this.CG = paramhe;
  }

  public hs(hg paramhg, long paramLong, int paramInt)
  {
    this(1, paramhg, paramLong, paramInt, null, null);
  }

  public hs(String paramString1, Intent paramIntent, String paramString2, Uri paramUri, String paramString3, List<AppIndexApi.AppIndexingLink> paramList)
  {
    this(1, a(paramString1, paramIntent), System.currentTimeMillis(), 0, null, a(paramIntent, paramString2, paramUri, paramString3, paramList).fj());
  }

  public static he.a a(Intent paramIntent, String paramString1, Uri paramUri, String paramString2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    he.a locala = new he.a();
    locala.a(av(paramString1));
    if (paramUri != null)
      locala.a(f(paramUri));
    if (paramList != null)
      locala.a(b(paramList));
    String str1 = paramIntent.getAction();
    if (str1 != null)
      locala.a(j("intent_action", str1));
    String str2 = paramIntent.getDataString();
    if (str2 != null)
      locala.a(j("intent_data", str2));
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null)
      locala.a(j("intent_activity", localComponentName.getClassName()));
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
    {
      String str3 = localBundle.getString("intent_extra_data_key");
      if (str3 != null)
        locala.a(j("intent_extra_data", str3));
    }
    return locala.ar(paramString2).D(true);
  }

  public static hg a(String paramString, Intent paramIntent)
  {
    return i(paramString, g(paramIntent));
  }

  private static hi av(String paramString)
  {
    return new hi(paramString, new hq.a("title").P(1).F(true).au("name").fm(), "text1");
  }

  private static hi b(List<AppIndexApi.AppIndexingLink> paramList)
  {
    ll.a locala = new ll.a();
    ll.a.a[] arrayOfa = new ll.a.a[paramList.size()];
    for (int i = 0; i < arrayOfa.length; i++)
    {
      arrayOfa[i] = new ll.a.a();
      AppIndexApi.AppIndexingLink localAppIndexingLink = (AppIndexApi.AppIndexingLink)paramList.get(i);
      arrayOfa[i].adG = localAppIndexingLink.appIndexingUrl.toString();
      arrayOfa[i].adH = localAppIndexingLink.webUrl.toString();
      arrayOfa[i].viewId = localAppIndexingLink.viewId;
    }
    locala.adE = arrayOfa;
    return new hi(pn.f(locala), new hq.a("outlinks").E(true).au(".private:outLinks").at("blob").fm());
  }

  private static hi f(Uri paramUri)
  {
    return new hi(paramUri.toString(), new hq.a("web_url").P(4).E(true).au("url").fm());
  }

  private static String g(Intent paramIntent)
  {
    String str = paramIntent.toUri(1);
    CRC32 localCRC32 = new CRC32();
    try
    {
      localCRC32.update(str.getBytes("UTF-8"));
      return Long.toHexString(localCRC32.getValue());
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException(localUnsupportedEncodingException);
    }
  }

  private static hg i(String paramString1, String paramString2)
  {
    return new hg(paramString1, "", paramString2);
  }

  private static hi j(String paramString1, String paramString2)
  {
    return new hi(paramString2, new hq.a(paramString1).E(true).fm(), paramString1);
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.CD;
    arrayOfObject[1] = Long.valueOf(this.CE);
    arrayOfObject[2] = Integer.valueOf(this.CF);
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ht.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hs
 * JD-Core Version:    0.6.2
 */