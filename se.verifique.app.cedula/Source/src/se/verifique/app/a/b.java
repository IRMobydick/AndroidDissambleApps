package se.verifique.app.a;

import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import se.verifique.app.cedula.util.f;

public class b
  implements Runnable
{
  public boolean a = false;
  public boolean b = false;
  public String c = "";
  public Header[] d;
  private f e = new f();

  public b(String paramString1, int paramInt, List paramList, Map paramMap1, CredentialsProvider paramCredentialsProvider, Map paramMap2, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    this.e.a(paramMap1);
    this.e.a(paramCredentialsProvider);
    this.e.b(paramBoolean2);
    this.e.b(paramMap2);
    this.e.a(paramList);
    this.e.a(paramBoolean1);
    this.e.a(paramString2);
    this.e.a(paramInt);
    this.e.b(paramString1);
  }

  public DefaultHttpClient a(String paramString)
  {
    return new DefaultHttpClient();
  }

  // ERROR //
  public String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 68	se/verifique/app/a/b:a	(Ljava/lang/String;)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   5: astore 11
    //   7: aload_0
    //   8: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   11: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   14: ifnull +167 -> 181
    //   17: aload_0
    //   18: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   21: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   24: invokeinterface 77 1 0
    //   29: ifne +152 -> 181
    //   32: aload_0
    //   33: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   36: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   39: ldc 79
    //   41: invokeinterface 83 2 0
    //   46: checkcast 85	java/lang/String
    //   49: astore 39
    //   51: aload_0
    //   52: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   55: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   58: ldc 79
    //   60: invokeinterface 88 2 0
    //   65: pop
    //   66: aload_0
    //   67: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   70: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   73: ldc 90
    //   75: invokeinterface 83 2 0
    //   80: checkcast 85	java/lang/String
    //   83: astore 41
    //   85: aload_0
    //   86: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   89: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   92: ldc 90
    //   94: invokeinterface 88 2 0
    //   99: pop
    //   100: new 92	org/apache/http/impl/client/BasicCookieStore
    //   103: dup
    //   104: invokespecial 93	org/apache/http/impl/client/BasicCookieStore:<init>	()V
    //   107: astore 43
    //   109: invokestatic 99	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   112: astore 44
    //   114: aload 44
    //   116: bipush 6
    //   118: bipush 100
    //   120: invokevirtual 103	java/util/Calendar:add	(II)V
    //   123: aload 44
    //   125: invokevirtual 107	java/util/Calendar:getTime	()Ljava/util/Date;
    //   128: astore 45
    //   130: aload_0
    //   131: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   134: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   137: invokeinterface 111 1 0
    //   142: invokeinterface 117 1 0
    //   147: astore 46
    //   149: aload 46
    //   151: invokeinterface 122 1 0
    //   156: ifne +244 -> 400
    //   159: aload 11
    //   161: invokevirtual 126	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   164: ldc 128
    //   166: ldc 130
    //   168: invokeinterface 136 3 0
    //   173: pop
    //   174: aload 11
    //   176: aload 43
    //   178: invokevirtual 140	org/apache/http/impl/client/DefaultHttpClient:setCookieStore	(Lorg/apache/http/client/CookieStore;)V
    //   181: aload_0
    //   182: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   185: invokevirtual 143	se/verifique/app/cedula/util/f:d	()Lorg/apache/http/client/CredentialsProvider;
    //   188: ifnull +15 -> 203
    //   191: aload 11
    //   193: aload_0
    //   194: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   197: invokevirtual 143	se/verifique/app/cedula/util/f:d	()Lorg/apache/http/client/CredentialsProvider;
    //   200: invokevirtual 146	org/apache/http/impl/client/DefaultHttpClient:setCredentialsProvider	(Lorg/apache/http/client/CredentialsProvider;)V
    //   203: aload_0
    //   204: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   207: invokevirtual 149	se/verifique/app/cedula/util/f:a	()I
    //   210: tableswitch	default:+18 -> 228, 2:+512->722
    //   229: nop
    //   230: dcmpl
    //   231: dup
    //   232: aload_0
    //   233: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   236: invokevirtual 155	se/verifique/app/cedula/util/f:i	()Ljava/lang/String;
    //   239: invokespecial 157	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   242: astore 33
    //   244: aload 33
    //   246: invokevirtual 158	org/apache/http/client/methods/HttpGet:getParams	()Lorg/apache/http/params/HttpParams;
    //   249: astore 34
    //   251: aload_0
    //   252: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   255: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   258: ifnull +32 -> 290
    //   261: aload_0
    //   262: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   265: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   268: invokeinterface 111 1 0
    //   273: invokeinterface 117 1 0
    //   278: astore 35
    //   280: aload 35
    //   282: invokeinterface 122 1 0
    //   287: ifne +257 -> 544
    //   290: aload 11
    //   292: aload 33
    //   294: invokevirtual 164	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   297: astore 17
    //   299: getstatic 170	java/lang/System:out	Ljava/io/PrintStream;
    //   302: new 172	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 174
    //   308: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: aload 17
    //   313: invokeinterface 181 1 0
    //   318: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 193	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: aload 17
    //   330: invokeinterface 197 1 0
    //   335: putfield 199	se/verifique/app/a/b:d	[Lorg/apache/http/Header;
    //   338: aload_0
    //   339: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   342: invokevirtual 202	se/verifique/app/cedula/util/f:h	()Z
    //   345: ifne +735 -> 1080
    //   348: new 204	java/io/BufferedReader
    //   351: dup
    //   352: new 206	java/io/InputStreamReader
    //   355: dup
    //   356: aload 17
    //   358: invokeinterface 210 1 0
    //   363: invokeinterface 216 1 0
    //   368: invokespecial 219	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   371: invokespecial 222	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   374: astore 18
    //   376: ldc 26
    //   378: astore 8
    //   380: aload 18
    //   382: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   385: astore 20
    //   387: aload 20
    //   389: ifnonnull +662 -> 1051
    //   392: aload 18
    //   394: invokevirtual 228	java/io/BufferedReader:close	()V
    //   397: aload 8
    //   399: areturn
    //   400: aload 46
    //   402: invokeinterface 232 1 0
    //   407: checkcast 85	java/lang/String
    //   410: astore 47
    //   412: new 234	org/apache/http/impl/cookie/BasicClientCookie
    //   415: dup
    //   416: aload 47
    //   418: aload_0
    //   419: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   422: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   425: aload 47
    //   427: invokeinterface 83 2 0
    //   432: checkcast 85	java/lang/String
    //   435: invokespecial 237	org/apache/http/impl/cookie/BasicClientCookie:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: astore 48
    //   440: aload 48
    //   442: aload 39
    //   444: invokevirtual 240	org/apache/http/impl/cookie/BasicClientCookie:setDomain	(Ljava/lang/String;)V
    //   447: aload 48
    //   449: aload 45
    //   451: invokevirtual 244	org/apache/http/impl/cookie/BasicClientCookie:setExpiryDate	(Ljava/util/Date;)V
    //   454: aload 48
    //   456: aload 41
    //   458: invokevirtual 247	org/apache/http/impl/cookie/BasicClientCookie:setPath	(Ljava/lang/String;)V
    //   461: getstatic 170	java/lang/System:out	Ljava/io/PrintStream;
    //   464: new 172	java/lang/StringBuilder
    //   467: dup
    //   468: ldc 249
    //   470: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload 47
    //   475: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc 254
    //   480: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_0
    //   484: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   487: invokevirtual 71	se/verifique/app/cedula/util/f:c	()Ljava/util/Map;
    //   490: aload 47
    //   492: invokeinterface 83 2 0
    //   497: checkcast 85	java/lang/String
    //   500: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokevirtual 193	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   509: aload 43
    //   511: aload 48
    //   513: invokeinterface 260 2 0
    //   518: goto -369 -> 149
    //   521: astore 9
    //   523: aload 9
    //   525: astore 10
    //   527: ldc 26
    //   529: astore 8
    //   531: aload 10
    //   533: invokevirtual 263	java/io/IOException:printStackTrace	()V
    //   536: aload_0
    //   537: iconst_1
    //   538: putfield 24	se/verifique/app/a/b:b	Z
    //   541: goto -144 -> 397
    //   544: aload 35
    //   546: invokeinterface 232 1 0
    //   551: checkcast 85	java/lang/String
    //   554: astore 36
    //   556: ldc_w 265
    //   559: aload 36
    //   561: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   564: ifeq +131 -> 695
    //   567: ldc_w 271
    //   570: aload_0
    //   571: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   574: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   577: aload 36
    //   579: invokeinterface 83 2 0
    //   584: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   587: ifeq +91 -> 678
    //   590: aload 34
    //   592: ldc_w 273
    //   595: getstatic 279	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   598: invokeinterface 136 3 0
    //   603: pop
    //   604: goto -324 -> 280
    //   607: astore_2
    //   608: aload_2
    //   609: astore_3
    //   610: ldc 26
    //   612: astore 4
    //   614: new 172	java/lang/StringBuilder
    //   617: dup
    //   618: ldc_w 281
    //   621: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   624: astore 5
    //   626: aload_0
    //   627: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   630: invokevirtual 149	se/verifique/app/cedula/util/f:a	()I
    //   633: iconst_1
    //   634: if_icmpne +645 -> 1279
    //   637: ldc_w 283
    //   640: astore 6
    //   642: aload 5
    //   644: aload 6
    //   646: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 285
    //   652: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: ldc_w 287
    //   661: aload_3
    //   662: invokestatic 292	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   665: pop
    //   666: aload_0
    //   667: iconst_1
    //   668: putfield 24	se/verifique/app/a/b:b	Z
    //   671: aload 4
    //   673: astore 8
    //   675: goto -278 -> 397
    //   678: aload 34
    //   680: ldc_w 273
    //   683: getstatic 295	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   686: invokeinterface 136 3 0
    //   691: pop
    //   692: goto -412 -> 280
    //   695: aload 33
    //   697: aload 36
    //   699: aload_0
    //   700: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   703: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   706: aload 36
    //   708: invokeinterface 83 2 0
    //   713: checkcast 85	java/lang/String
    //   716: invokevirtual 298	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: goto -439 -> 280
    //   722: new 300	org/apache/http/client/methods/HttpPost
    //   725: dup
    //   726: aload_0
    //   727: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   730: invokevirtual 155	se/verifique/app/cedula/util/f:i	()Ljava/lang/String;
    //   733: invokespecial 301	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   736: astore 12
    //   738: aload 12
    //   740: invokevirtual 302	org/apache/http/client/methods/HttpPost:getParams	()Lorg/apache/http/params/HttpParams;
    //   743: astore 13
    //   745: aload_0
    //   746: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   749: invokevirtual 305	se/verifique/app/cedula/util/f:f	()Z
    //   752: ifne +101 -> 853
    //   755: aload_0
    //   756: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   759: invokevirtual 308	se/verifique/app/cedula/util/f:b	()Ljava/util/List;
    //   762: ifnull +22 -> 784
    //   765: aload 12
    //   767: new 310	org/apache/http/client/entity/UrlEncodedFormEntity
    //   770: dup
    //   771: aload_0
    //   772: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   775: invokevirtual 308	se/verifique/app/cedula/util/f:b	()Ljava/util/List;
    //   778: invokespecial 312	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;)V
    //   781: invokevirtual 316	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   784: aload_0
    //   785: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   788: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   791: ifnull +32 -> 823
    //   794: aload_0
    //   795: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   798: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   801: invokeinterface 111 1 0
    //   806: invokeinterface 117 1 0
    //   811: astore 29
    //   813: aload 29
    //   815: invokeinterface 122 1 0
    //   820: ifne +55 -> 875
    //   823: aload 12
    //   825: invokevirtual 317	org/apache/http/client/methods/HttpPost:getAllHeaders	()[Lorg/apache/http/Header;
    //   828: astore 14
    //   830: iconst_0
    //   831: istore 15
    //   833: iload 15
    //   835: aload 14
    //   837: arraylength
    //   838: if_icmplt +144 -> 982
    //   841: aload 11
    //   843: aload 12
    //   845: invokevirtual 164	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   848: astore 17
    //   850: goto -551 -> 299
    //   853: aload 12
    //   855: new 319	org/apache/http/entity/StringEntity
    //   858: dup
    //   859: aload_0
    //   860: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   863: invokevirtual 322	se/verifique/app/cedula/util/f:g	()Ljava/lang/String;
    //   866: invokespecial 323	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   869: invokevirtual 316	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   872: goto -88 -> 784
    //   875: aload 29
    //   877: invokeinterface 232 1 0
    //   882: checkcast 85	java/lang/String
    //   885: astore 30
    //   887: ldc_w 265
    //   890: aload 30
    //   892: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   895: ifeq +60 -> 955
    //   898: ldc_w 271
    //   901: aload_0
    //   902: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   905: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   908: aload 30
    //   910: invokeinterface 83 2 0
    //   915: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   918: ifeq +20 -> 938
    //   921: aload 13
    //   923: ldc_w 273
    //   926: getstatic 279	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   929: invokeinterface 136 3 0
    //   934: pop
    //   935: goto -122 -> 813
    //   938: aload 13
    //   940: ldc_w 273
    //   943: getstatic 295	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   946: invokeinterface 136 3 0
    //   951: pop
    //   952: goto -139 -> 813
    //   955: aload 12
    //   957: aload 30
    //   959: aload_0
    //   960: getfield 33	se/verifique/app/a/b:e	Lse/verifique/app/cedula/util/f;
    //   963: invokevirtual 160	se/verifique/app/cedula/util/f:e	()Ljava/util/Map;
    //   966: aload 30
    //   968: invokeinterface 83 2 0
    //   973: checkcast 85	java/lang/String
    //   976: invokevirtual 324	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: goto -166 -> 813
    //   982: aload 14
    //   984: iload 15
    //   986: aaload
    //   987: astore 16
    //   989: getstatic 170	java/lang/System:out	Ljava/io/PrintStream;
    //   992: new 172	java/lang/StringBuilder
    //   995: dup
    //   996: ldc_w 326
    //   999: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1002: iload 15
    //   1004: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1007: ldc_w 331
    //   1010: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: aload 16
    //   1015: invokeinterface 336 1 0
    //   1020: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 338
    //   1026: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload 16
    //   1031: invokeinterface 341 1 0
    //   1036: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: invokevirtual 193	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1045: iinc 15 1
    //   1048: goto -215 -> 833
    //   1051: new 172	java/lang/StringBuilder
    //   1054: dup
    //   1055: aload 8
    //   1057: invokestatic 345	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1060: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1063: aload 20
    //   1065: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: astore 21
    //   1073: aload 21
    //   1075: astore 8
    //   1077: goto -697 -> 380
    //   1080: invokestatic 350	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   1083: ifnull +221 -> 1304
    //   1086: new 352	java/util/Random
    //   1089: dup
    //   1090: invokespecial 353	java/util/Random:<init>	()V
    //   1093: astore 22
    //   1095: new 355	java/io/File
    //   1098: dup
    //   1099: new 172	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 356	java/lang/StringBuilder:<init>	()V
    //   1106: invokestatic 360	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   1109: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1112: ldc_w 362
    //   1115: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   1124: astore 23
    //   1126: aload 23
    //   1128: invokevirtual 366	java/io/File:exists	()Z
    //   1131: ifne +9 -> 1140
    //   1134: aload 23
    //   1136: invokevirtual 369	java/io/File:mkdir	()Z
    //   1139: pop
    //   1140: aload 23
    //   1142: invokevirtual 366	java/io/File:exists	()Z
    //   1145: ifeq +159 -> 1304
    //   1148: new 172	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 356	java/lang/StringBuilder:<init>	()V
    //   1155: invokestatic 360	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   1158: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1161: ldc_w 371
    //   1164: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: aload 22
    //   1169: invokevirtual 374	java/util/Random:nextInt	()I
    //   1172: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1175: ldc_w 376
    //   1178: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: astore 8
    //   1186: new 378	java/io/BufferedInputStream
    //   1189: dup
    //   1190: aload 17
    //   1192: invokeinterface 210 1 0
    //   1197: invokeinterface 216 1 0
    //   1202: invokespecial 379	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1205: astore 25
    //   1207: new 381	java/io/BufferedOutputStream
    //   1210: dup
    //   1211: new 383	java/io/FileOutputStream
    //   1214: dup
    //   1215: new 355	java/io/File
    //   1218: dup
    //   1219: aload 8
    //   1221: invokespecial 363	java/io/File:<init>	(Ljava/lang/String;)V
    //   1224: invokespecial 386	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1227: invokespecial 389	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1230: astore 26
    //   1232: aload 25
    //   1234: invokevirtual 392	java/io/BufferedInputStream:read	()I
    //   1237: istore 27
    //   1239: iload 27
    //   1241: bipush 255
    //   1243: if_icmpne +26 -> 1269
    //   1246: aload 25
    //   1248: invokevirtual 393	java/io/BufferedInputStream:close	()V
    //   1251: aload 26
    //   1253: invokevirtual 394	java/io/BufferedOutputStream:close	()V
    //   1256: goto -859 -> 397
    //   1259: astore 24
    //   1261: ldc_w 396
    //   1264: astore 8
    //   1266: goto -869 -> 397
    //   1269: aload 26
    //   1271: iload 27
    //   1273: invokevirtual 399	java/io/BufferedOutputStream:write	(I)V
    //   1276: goto -44 -> 1232
    //   1279: ldc_w 401
    //   1282: astore 6
    //   1284: goto -642 -> 642
    //   1287: astore 19
    //   1289: aload 19
    //   1291: astore_3
    //   1292: aload 8
    //   1294: astore 4
    //   1296: goto -682 -> 614
    //   1299: astore 10
    //   1301: goto -770 -> 531
    //   1304: ldc 26
    //   1306: astore 8
    //   1308: goto -911 -> 397
    //
    // Exception table:
    //   from	to	target	type
    //   0	376	521	java/io/IOException
    //   400	518	521	java/io/IOException
    //   544	604	521	java/io/IOException
    //   678	1045	521	java/io/IOException
    //   1080	1126	521	java/io/IOException
    //   1126	1256	521	java/io/IOException
    //   1261	1266	521	java/io/IOException
    //   1269	1276	521	java/io/IOException
    //   0	376	607	java/lang/Exception
    //   400	518	607	java/lang/Exception
    //   544	604	607	java/lang/Exception
    //   678	1045	607	java/lang/Exception
    //   1080	1126	607	java/lang/Exception
    //   1261	1266	607	java/lang/Exception
    //   1126	1256	1259	java/lang/Exception
    //   1269	1276	1259	java/lang/Exception
    //   380	397	1287	java/lang/Exception
    //   1051	1073	1287	java/lang/Exception
    //   380	397	1299	java/io/IOException
    //   1051	1073	1299	java/io/IOException
  }

  public void run()
  {
    this.c = b(this.e.i());
    this.a = true;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.a.b
 * JD-Core Version:    0.6.0
 */