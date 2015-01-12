package com.baidu.platform.comapi.b;

import android.os.Bundle;
import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class d
{
  private static final String a = d.class.getSimpleName();
  private com.baidu.platform.comjni.map.search.a b = null;
  private int c = this.b.a();
  private c d = null;
  private Handler e = null;
  private int f = 10;
  private Bundle g = null;

  public d()
  {
    com.baidu.platform.comjni.engine.a.a(2000, this.e);
    this.d.a(this);
  }

  private Bundle a(a parama)
  {
    if (parama == null)
      return null;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", parama.a);
    localBundle.putString("uid", parama.d);
    if (parama.b != null)
    {
      localBundle.putInt("x", parama.b.a());
      localBundle.putInt("y", parama.b.b());
    }
    localBundle.putString("keyword", parama.c);
    return localBundle;
  }

  private Bundle b()
  {
    if (this.g == null)
      this.g = new Bundle();
    while (true)
    {
      return this.g;
      this.g.clear();
    }
  }

  public void a()
  {
    com.baidu.platform.comjni.engine.a.b(2000, this.e);
    this.b.b();
    this.d.a();
    this.e = null;
    this.b = null;
    this.g = null;
    this.d = null;
    this.c = 0;
  }

  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 50))
      this.f = paramInt;
  }

  public void a(b paramb)
  {
    this.d.a(paramb);
  }

  public boolean a(com.baidu.platform.comapi.a.d paramd)
  {
    if (paramd == null)
      return false;
    int i = paramd.b();
    int j = paramd.a();
    return this.b.a(j, i);
  }

  public boolean a(com.baidu.platform.comapi.a.d paramd, String paramString1, String paramString2)
  {
    if ((paramd == null) || (paramString1 == null) || (paramString2 == null))
      return false;
    return this.b.a(paramd.a(), paramd.b(), paramString1, paramString2);
  }

  public boolean a(a parama1, a parama2, String paramString, com.baidu.platform.comapi.a.c paramc, int paramInt1, int paramInt2, Map<String, Object> paramMap)
  {
    if ((paramString == null) || (paramString.equals("")));
    Bundle localBundle1;
    do
    {
      Bundle localBundle2;
      Bundle localBundle3;
      do
      {
        return false;
        localBundle1 = b();
        localBundle2 = a(parama1);
        localBundle3 = a(parama2);
      }
      while ((localBundle2 == null) || (localBundle3 == null));
      localBundle1.putBundle("start", localBundle2);
      localBundle1.putBundle("end", localBundle3);
    }
    while ((paramInt2 < 3) || (paramInt2 > 6));
    localBundle1.putInt("strategy", paramInt2);
    localBundle1.putString("cityid", paramString);
    if ((paramc != null) && (paramc.a != null) && (paramc.b != null))
    {
      Bundle localBundle5 = new Bundle();
      localBundle5.putInt("level", paramInt1);
      localBundle5.putInt("ll_x", paramc.a.a());
      localBundle5.putInt("ll_y", paramc.a.b());
      localBundle5.putInt("ru_x", paramc.b.a());
      localBundle5.putInt("ru_y", paramc.b.b());
      localBundle1.putBundle("mapbound", localBundle5);
    }
    if (paramMap != null)
    {
      Bundle localBundle4 = new Bundle();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramMap.get(str);
        localBundle4.putString(str.toString(), localObject.toString());
      }
      localBundle1.putBundle("extparams", localBundle4);
    }
    return this.b.c(localBundle1);
  }

  // ERROR //
  public boolean a(a parama1, a parama2, String paramString1, String paramString2, String paramString3, com.baidu.platform.comapi.a.c paramc, int paramInt1, int paramInt2, int paramInt3, java.util.ArrayList<f> paramArrayList, Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   14: ifnonnull +20 -> 34
    //   17: aload 4
    //   19: ifnull +13 -> 32
    //   22: aload 4
    //   24: ldc 127
    //   26: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_2
    //   35: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   38: ifnonnull +20 -> 58
    //   41: aload 5
    //   43: ifnull +13 -> 56
    //   46: aload 5
    //   48: ldc 127
    //   50: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_0
    //   59: invokespecial 135	com/baidu/platform/comapi/b/d:b	()Landroid/os/Bundle;
    //   62: astore 12
    //   64: aload 12
    //   66: ldc 205
    //   68: aload_1
    //   69: getfield 74	com/baidu/platform/comapi/b/a:a	I
    //   72: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   75: aload_1
    //   76: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   79: ifnull +31 -> 110
    //   82: aload 12
    //   84: ldc 207
    //   86: aload_1
    //   87: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   90: invokevirtual 94	com/baidu/platform/comapi/a/d:a	()I
    //   93: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   96: aload 12
    //   98: ldc 209
    //   100: aload_1
    //   101: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   104: invokevirtual 98	com/baidu/platform/comapi/a/d:b	()I
    //   107: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   110: aload 12
    //   112: ldc 211
    //   114: aload_1
    //   115: getfield 102	com/baidu/platform/comapi/b/a:c	Ljava/lang/String;
    //   118: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 12
    //   123: ldc 213
    //   125: aload_1
    //   126: getfield 82	com/baidu/platform/comapi/b/a:d	Ljava/lang/String;
    //   129: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload 12
    //   134: ldc 215
    //   136: aload_2
    //   137: getfield 74	com/baidu/platform/comapi/b/a:a	I
    //   140: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   143: aload_2
    //   144: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   147: ifnull +31 -> 178
    //   150: aload 12
    //   152: ldc 217
    //   154: aload_2
    //   155: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   158: invokevirtual 94	com/baidu/platform/comapi/a/d:a	()I
    //   161: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   164: aload 12
    //   166: ldc 219
    //   168: aload_2
    //   169: getfield 89	com/baidu/platform/comapi/b/a:b	Lcom/baidu/platform/comapi/a/d;
    //   172: invokevirtual 98	com/baidu/platform/comapi/a/d:b	()I
    //   175: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   178: aload 12
    //   180: ldc 221
    //   182: aload_2
    //   183: getfield 102	com/baidu/platform/comapi/b/a:c	Ljava/lang/String;
    //   186: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload 12
    //   191: ldc 223
    //   193: aload_2
    //   194: getfield 82	com/baidu/platform/comapi/b/a:d	Ljava/lang/String;
    //   197: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 12
    //   202: ldc 156
    //   204: iload 7
    //   206: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   209: aload 6
    //   211: ifnull +79 -> 290
    //   214: aload 6
    //   216: getfield 153	com/baidu/platform/comapi/a/c:a	Lcom/baidu/platform/comapi/a/d;
    //   219: ifnull +71 -> 290
    //   222: aload 6
    //   224: getfield 154	com/baidu/platform/comapi/a/c:b	Lcom/baidu/platform/comapi/a/d;
    //   227: ifnull +63 -> 290
    //   230: aload 12
    //   232: ldc 158
    //   234: aload 6
    //   236: getfield 153	com/baidu/platform/comapi/a/c:a	Lcom/baidu/platform/comapi/a/d;
    //   239: invokevirtual 94	com/baidu/platform/comapi/a/d:a	()I
    //   242: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   245: aload 12
    //   247: ldc 160
    //   249: aload 6
    //   251: getfield 153	com/baidu/platform/comapi/a/c:a	Lcom/baidu/platform/comapi/a/d;
    //   254: invokevirtual 98	com/baidu/platform/comapi/a/d:b	()I
    //   257: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   260: aload 12
    //   262: ldc 162
    //   264: aload 6
    //   266: getfield 154	com/baidu/platform/comapi/a/c:b	Lcom/baidu/platform/comapi/a/d;
    //   269: invokevirtual 94	com/baidu/platform/comapi/a/d:a	()I
    //   272: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   275: aload 12
    //   277: ldc 164
    //   279: aload 6
    //   281: getfield 154	com/baidu/platform/comapi/a/c:b	Lcom/baidu/platform/comapi/a/d;
    //   284: invokevirtual 98	com/baidu/platform/comapi/a/d:b	()I
    //   287: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   290: aload 12
    //   292: ldc 147
    //   294: iload 8
    //   296: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   299: aload 12
    //   301: ldc 149
    //   303: aload_3
    //   304: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 12
    //   309: ldc 225
    //   311: aload 4
    //   313: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 12
    //   318: ldc 227
    //   320: aload 5
    //   322: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload 12
    //   327: ldc 229
    //   329: iload 9
    //   331: invokevirtual 78	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   334: aload 10
    //   336: ifnull +366 -> 702
    //   339: aload 10
    //   341: invokevirtual 234	java/util/ArrayList:size	()I
    //   344: istore 17
    //   346: iconst_0
    //   347: istore 18
    //   349: ldc 127
    //   351: astore 19
    //   353: ldc 127
    //   355: astore 20
    //   357: iconst_0
    //   358: istore 21
    //   360: iload 21
    //   362: iload 17
    //   364: if_icmpge +318 -> 682
    //   367: new 236	org/json/JSONObject
    //   370: dup
    //   371: invokespecial 237	org/json/JSONObject:<init>	()V
    //   374: astore 22
    //   376: aload 10
    //   378: iload 21
    //   380: invokevirtual 240	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   383: checkcast 242	com/baidu/platform/comapi/b/f
    //   386: getfield 243	com/baidu/platform/comapi/b/f:a	Lcom/baidu/platform/comapi/a/d;
    //   389: ifnull +259 -> 648
    //   392: aload 22
    //   394: ldc 70
    //   396: iconst_1
    //   397: invokevirtual 247	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload 22
    //   403: ldc 100
    //   405: aload 10
    //   407: iload 21
    //   409: invokevirtual 240	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   412: checkcast 242	com/baidu/platform/comapi/b/f
    //   415: getfield 249	com/baidu/platform/comapi/b/f:b	Ljava/lang/String;
    //   418: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 10
    //   424: iload 21
    //   426: invokevirtual 240	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   429: checkcast 242	com/baidu/platform/comapi/b/f
    //   432: getfield 243	com/baidu/platform/comapi/b/f:a	Lcom/baidu/platform/comapi/a/d;
    //   435: ifnull +71 -> 506
    //   438: aload 22
    //   440: ldc 254
    //   442: new 256	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   449: aload 10
    //   451: iload 21
    //   453: invokevirtual 240	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   456: checkcast 242	com/baidu/platform/comapi/b/f
    //   459: getfield 243	com/baidu/platform/comapi/b/f:a	Lcom/baidu/platform/comapi/a/d;
    //   462: getfield 258	com/baidu/platform/comapi/a/d:a	I
    //   465: invokestatic 262	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   468: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc_w 268
    //   474: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 10
    //   479: iload 21
    //   481: invokevirtual 240	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   484: checkcast 242	com/baidu/platform/comapi/b/f
    //   487: getfield 243	com/baidu/platform/comapi/b/f:a	Lcom/baidu/platform/comapi/a/d;
    //   490: getfield 270	com/baidu/platform/comapi/a/d:b	I
    //   493: invokestatic 262	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   496: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   505: pop
    //   506: new 256	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   513: aload 20
    //   515: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 10
    //   520: iload 21
    //   522: invokevirtual 240	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   525: checkcast 242	com/baidu/platform/comapi/b/f
    //   528: getfield 272	com/baidu/platform/comapi/b/f:c	Ljava/lang/String;
    //   531: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: astore 29
    //   539: aload 29
    //   541: astore 24
    //   543: new 256	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   550: aload 19
    //   552: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 22
    //   557: invokevirtual 273	org/json/JSONObject:toString	()Ljava/lang/String;
    //   560: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: astore 31
    //   568: aload 31
    //   570: astore 25
    //   572: iload 18
    //   574: iload 17
    //   576: iconst_1
    //   577: isub
    //   578: if_icmpeq +53 -> 631
    //   581: new 256	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   588: aload 25
    //   590: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: ldc_w 275
    //   596: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: astore 25
    //   604: new 256	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   611: aload 24
    //   613: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: ldc_w 275
    //   619: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: astore 32
    //   627: aload 32
    //   629: astore 24
    //   631: iinc 18 1
    //   634: iinc 21 1
    //   637: aload 25
    //   639: astore 19
    //   641: aload 24
    //   643: astore 20
    //   645: goto -285 -> 360
    //   648: aload 22
    //   650: ldc 70
    //   652: iconst_2
    //   653: invokevirtual 247	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   656: pop
    //   657: goto -256 -> 401
    //   660: astore 23
    //   662: aload 20
    //   664: astore 24
    //   666: aload 19
    //   668: astore 25
    //   670: aload 23
    //   672: astore 26
    //   674: aload 26
    //   676: invokevirtual 278	org/json/JSONException:printStackTrace	()V
    //   679: goto -45 -> 634
    //   682: aload 12
    //   684: ldc_w 280
    //   687: aload 19
    //   689: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: aload 12
    //   694: ldc_w 282
    //   697: aload 20
    //   699: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: aload 11
    //   704: ifnull +86 -> 790
    //   707: new 67	android/os/Bundle
    //   710: dup
    //   711: invokespecial 68	android/os/Bundle:<init>	()V
    //   714: astore 13
    //   716: aload 11
    //   718: invokeinterface 172 1 0
    //   723: invokeinterface 178 1 0
    //   728: astore 14
    //   730: aload 14
    //   732: invokeinterface 184 1 0
    //   737: ifeq +44 -> 781
    //   740: aload 14
    //   742: invokeinterface 188 1 0
    //   747: checkcast 129	java/lang/String
    //   750: astore 15
    //   752: aload 11
    //   754: aload 15
    //   756: invokeinterface 192 2 0
    //   761: astore 16
    //   763: aload 13
    //   765: aload 15
    //   767: invokevirtual 195	java/lang/Object:toString	()Ljava/lang/String;
    //   770: aload 16
    //   772: invokevirtual 195	java/lang/Object:toString	()Ljava/lang/String;
    //   775: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   778: goto -48 -> 730
    //   781: aload 12
    //   783: ldc 197
    //   785: aload 13
    //   787: invokevirtual 143	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   790: aload_0
    //   791: getfield 32	com/baidu/platform/comapi/b/d:b	Lcom/baidu/platform/comjni/map/search/a;
    //   794: aload 12
    //   796: invokevirtual 284	com/baidu/platform/comjni/map/search/a:d	(Landroid/os/Bundle;)Z
    //   799: ireturn
    //   800: astore 26
    //   802: goto -128 -> 674
    //   805: astore 30
    //   807: aload 19
    //   809: astore 25
    //   811: aload 30
    //   813: astore 26
    //   815: goto -141 -> 674
    //
    // Exception table:
    //   from	to	target	type
    //   367	401	660	org/json/JSONException
    //   401	506	660	org/json/JSONException
    //   506	539	660	org/json/JSONException
    //   648	657	660	org/json/JSONException
    //   581	627	800	org/json/JSONException
    //   543	568	805	org/json/JSONException
  }

  public boolean a(a parama1, a parama2, String paramString1, String paramString2, String paramString3, com.baidu.platform.comapi.a.c paramc, int paramInt, Map<String, Object> paramMap)
  {
    if ((parama1 == null) || (parama2 == null));
    while (((parama1.b == null) && ((paramString2 == null) || (paramString2.equals("")))) || ((parama2.b == null) && ((paramString3 == null) || (paramString3.equals("")))))
      return false;
    Bundle localBundle1 = b();
    localBundle1.putInt("starttype", parama1.a);
    if (parama1.b != null)
    {
      localBundle1.putInt("startptx", parama1.b.a());
      localBundle1.putInt("startpty", parama1.b.b());
    }
    localBundle1.putString("startkeyword", parama1.c);
    localBundle1.putString("startuid", parama1.d);
    localBundle1.putInt("endtype", parama2.a);
    if (parama2.b != null)
    {
      localBundle1.putInt("endptx", parama2.b.a());
      localBundle1.putInt("endpty", parama2.b.b());
    }
    localBundle1.putString("endkeyword", parama2.c);
    localBundle1.putString("enduid", parama2.d);
    localBundle1.putInt("level", paramInt);
    if ((paramc != null) && (paramc.a != null) && (paramc.b != null))
    {
      localBundle1.putInt("ll_x", paramc.a.a());
      localBundle1.putInt("ll_y", paramc.a.b());
      localBundle1.putInt("ru_x", paramc.b.a());
      localBundle1.putInt("ru_y", paramc.b.b());
    }
    localBundle1.putString("cityid", paramString1);
    localBundle1.putString("st_cityid", paramString2);
    localBundle1.putString("en_cityid", paramString3);
    if (paramMap != null)
    {
      Bundle localBundle2 = new Bundle();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramMap.get(str);
        localBundle2.putString(str.toString(), localObject.toString());
      }
      localBundle1.putBundle("extparams", localBundle2);
    }
    return this.b.e(localBundle1);
  }

  public boolean a(String paramString)
  {
    if (paramString == null);
    String str;
    do
    {
      return false;
      str = paramString.trim();
    }
    while ((str.length() == 0) || (str.length() > 99));
    return this.b.a(str);
  }

  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, com.baidu.platform.comapi.a.c paramc1, com.baidu.platform.comapi.a.c paramc2, Map<String, Object> paramMap)
  {
    if (paramString == null);
    String str1;
    do
    {
      return false;
      str1 = paramString.trim();
    }
    while ((str1.length() == 0) || (str1.length() > 99));
    Bundle localBundle1 = b();
    localBundle1.putString("keyword", str1);
    localBundle1.putInt("pagenum", paramInt2);
    localBundle1.putInt("count", this.f);
    localBundle1.putInt("cityid", paramInt1);
    localBundle1.putInt("level", paramInt3);
    if (paramc2 != null)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("ll_x", paramc2.a.a());
      localBundle2.putInt("ll_y", paramc2.a.b());
      localBundle2.putInt("ru_x", paramc2.b.a());
      localBundle2.putInt("ru_y", paramc2.b.b());
      localBundle1.putBundle("mapbound", localBundle2);
    }
    if (paramc1 != null)
    {
      localBundle1.putInt("ll_x", paramc1.a.a());
      localBundle1.putInt("ll_y", paramc1.a.b());
      localBundle1.putInt("ru_x", paramc1.b.a());
      localBundle1.putInt("ru_y", paramc1.b.b());
      localBundle1.putInt("loc_x", (paramc1.a.a() + paramc1.b.a()) / 2);
      localBundle1.putInt("loc_y", (paramc1.a.b() + paramc1.b.b()) / 2);
    }
    if (paramMap != null)
    {
      Bundle localBundle3 = new Bundle();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject = paramMap.get(str2);
        localBundle3.putString(str2.toString(), localObject.toString());
      }
      localBundle1.putBundle("extparams", localBundle3);
    }
    return this.b.b(localBundle1);
  }

  public boolean a(String paramString, int paramInt1, int paramInt2, com.baidu.platform.comapi.a.c paramc, int paramInt3, com.baidu.platform.comapi.a.d paramd, Map<String, Object> paramMap)
  {
    if (paramc == null);
    String str1;
    do
    {
      do
        return false;
      while (paramString == null);
      str1 = paramString.trim();
    }
    while ((str1.length() == 0) || (str1.length() > 99));
    Bundle localBundle1 = b();
    localBundle1.putString("keyword", str1);
    localBundle1.putInt("pagenum", paramInt2);
    localBundle1.putInt("count", this.f);
    localBundle1.putString("cityid", String.valueOf(paramInt1));
    localBundle1.putInt("level", paramInt3);
    if (paramc != null)
    {
      localBundle1.putInt("ll_x", paramc.a.a());
      localBundle1.putInt("ll_y", paramc.a.b());
      localBundle1.putInt("ru_x", paramc.b.a());
      localBundle1.putInt("ru_y", paramc.b.b());
    }
    if (paramd != null)
    {
      localBundle1.putInt("loc_x", paramd.a);
      localBundle1.putInt("loc_y", paramd.b);
    }
    if (paramMap != null)
    {
      Bundle localBundle2 = new Bundle();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject = paramMap.get(str2);
        localBundle2.putString(str2.toString(), localObject.toString());
      }
      localBundle1.putBundle("extparams", localBundle2);
    }
    return this.b.g(localBundle1);
  }

  public boolean a(String paramString1, int paramInt1, String paramString2, com.baidu.platform.comapi.a.c paramc, int paramInt2, com.baidu.platform.comapi.a.d paramd)
  {
    if (paramString1 == null);
    String str;
    do
    {
      do
        return false;
      while ((paramInt1 != 0) && (paramInt1 != 2));
      str = paramString1.trim();
    }
    while ((str.length() == 0) || (str.length() > 99));
    Bundle localBundle1 = b();
    localBundle1.putString("keyword", paramString1);
    localBundle1.putInt("type", paramInt1);
    localBundle1.putString("cityid", paramString2);
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("level", paramInt2);
    localBundle1.putBundle("mapbound", localBundle2);
    if (paramd != null)
    {
      localBundle1.putInt("loc_x", paramd.a);
      localBundle1.putInt("loc_y", paramd.b);
    }
    return this.b.f(localBundle1);
  }

  public boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null);
    String str;
    do
    {
      do
        return false;
      while ((paramString1 == null) || (paramString1.equals("")));
      str = paramString2.trim();
    }
    while ((str.length() == 0) || (str.length() > 99));
    return this.b.a(paramString1, str);
  }

  public boolean a(String paramString1, String paramString2, int paramInt1, com.baidu.platform.comapi.a.c paramc, int paramInt2, Map<String, Object> paramMap)
  {
    if (paramString1 == null);
    String str1;
    do
    {
      return false;
      str1 = paramString1.trim();
    }
    while ((str1.length() == 0) || (str1.length() > 99));
    Bundle localBundle1 = b();
    localBundle1.putString("keyword", str1);
    localBundle1.putInt("pagenum", paramInt1);
    localBundle1.putInt("count", this.f);
    localBundle1.putString("cityid", paramString2);
    localBundle1.putInt("level", paramInt2);
    if (paramc != null)
    {
      localBundle1.putInt("ll_x", paramc.a.a());
      localBundle1.putInt("ll_y", paramc.a.b());
      localBundle1.putInt("ru_x", paramc.b.a());
      localBundle1.putInt("ru_y", paramc.b.b());
    }
    if (paramMap != null)
    {
      Bundle localBundle2 = new Bundle();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        Object localObject = paramMap.get(str2);
        localBundle2.putString(str2.toString(), localObject.toString());
      }
      localBundle1.putBundle("extparams", localBundle2);
    }
    return this.b.a(localBundle1);
  }

  String b(int paramInt)
  {
    String str = this.b.a(paramInt);
    if ((str != null) && (str.trim().length() <= 0))
      str = null;
    return str;
  }

  public boolean b(String paramString)
  {
    if (paramString == null)
      return false;
    return this.b.b(paramString);
  }

  public boolean b(String paramString1, String paramString2)
  {
    return this.b.b(paramString1, paramString2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.b.d
 * JD-Core Version:    0.6.2
 */