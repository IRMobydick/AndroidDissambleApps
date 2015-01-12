package com.crashlytics.android.internal;

final class aO extends Z
  implements ba
{
  public aO(String paramString1, String paramString2, av paramav)
  {
    this(paramString1, paramString2, paramav, ax.a);
  }

  private aO(String paramString1, String paramString2, av paramav, ax paramax)
  {
    super(paramString1, paramString2, paramav, paramax);
  }

  // ERROR //
  public final org.json.JSONObject a(aZ paramaZ)
  {
    // Byte code:
    //   0: new 23	java/util/HashMap
    //   3: dup
    //   4: invokespecial 26	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 28
    //   11: aload_1
    //   12: getfield 34	com/crashlytics/android/internal/aZ:e	Ljava/lang/String;
    //   15: invokeinterface 40 3 0
    //   20: pop
    //   21: aload_2
    //   22: ldc 42
    //   24: aload_1
    //   25: getfield 45	com/crashlytics/android/internal/aZ:d	Ljava/lang/String;
    //   28: invokeinterface 40 3 0
    //   33: pop
    //   34: aload_2
    //   35: ldc 47
    //   37: aload_1
    //   38: getfield 51	com/crashlytics/android/internal/aZ:f	I
    //   41: invokestatic 57	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   44: invokeinterface 40 3 0
    //   49: pop
    //   50: aload_1
    //   51: getfield 60	com/crashlytics/android/internal/aZ:g	Ljava/lang/String;
    //   54: ifnull +16 -> 70
    //   57: aload_2
    //   58: ldc 62
    //   60: aload_1
    //   61: getfield 60	com/crashlytics/android/internal/aZ:g	Ljava/lang/String;
    //   64: invokeinterface 40 3 0
    //   69: pop
    //   70: aload_1
    //   71: getfield 65	com/crashlytics/android/internal/aZ:c	Ljava/lang/String;
    //   74: astore 9
    //   76: aload 9
    //   78: invokestatic 70	com/crashlytics/android/internal/ab:e	(Ljava/lang/String;)Z
    //   81: ifne +14 -> 95
    //   84: aload_2
    //   85: ldc 72
    //   87: aload 9
    //   89: invokeinterface 40 3 0
    //   94: pop
    //   95: aload_0
    //   96: aload_2
    //   97: invokevirtual 75	com/crashlytics/android/internal/aO:a	(Ljava/util/Map;)Lcom/crashlytics/android/internal/ay;
    //   100: astore 10
    //   102: aload 10
    //   104: astore 4
    //   106: aload 4
    //   108: ldc 77
    //   110: aload_1
    //   111: getfield 79	com/crashlytics/android/internal/aZ:a	Ljava/lang/String;
    //   114: invokevirtual 84	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/crashlytics/android/internal/ay;
    //   117: ldc 86
    //   119: ldc 88
    //   121: invokevirtual 84	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/crashlytics/android/internal/ay;
    //   124: ldc 90
    //   126: aload_1
    //   127: getfield 93	com/crashlytics/android/internal/aZ:b	Ljava/lang/String;
    //   130: invokevirtual 84	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/crashlytics/android/internal/ay;
    //   133: ldc 95
    //   135: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   138: invokevirtual 104	com/crashlytics/android/internal/v:getVersion	()Ljava/lang/String;
    //   141: invokevirtual 84	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/crashlytics/android/internal/ay;
    //   144: ldc 106
    //   146: ldc 108
    //   148: invokevirtual 84	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/crashlytics/android/internal/ay;
    //   151: astore 4
    //   153: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   156: invokevirtual 111	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   159: ldc 113
    //   161: new 115	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 117
    //   167: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 122	com/crashlytics/android/internal/aO:a	()Ljava/lang/String;
    //   174: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokeinterface 133 3 0
    //   185: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   188: invokevirtual 111	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   191: ldc 113
    //   193: new 115	java/lang/StringBuilder
    //   196: dup
    //   197: ldc 135
    //   199: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_2
    //   203: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokeinterface 133 3 0
    //   214: new 140	org/json/JSONObject
    //   217: dup
    //   218: aload 4
    //   220: invokevirtual 142	com/crashlytics/android/internal/ay:c	()Ljava/lang/String;
    //   223: invokespecial 143	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   226: astore 11
    //   228: aload 4
    //   230: ifnull +38 -> 268
    //   233: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   236: invokevirtual 111	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   239: ldc 113
    //   241: new 115	java/lang/StringBuilder
    //   244: dup
    //   245: ldc 145
    //   247: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 4
    //   252: ldc 147
    //   254: invokevirtual 150	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;)Ljava/lang/String;
    //   257: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokeinterface 133 3 0
    //   268: aload 11
    //   270: areturn
    //   271: astore 5
    //   273: aconst_null
    //   274: astore 4
    //   276: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   279: invokevirtual 111	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   282: ldc 113
    //   284: new 115	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 152
    //   290: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload_0
    //   294: invokevirtual 122	com/crashlytics/android/internal/aO:a	()Ljava/lang/String;
    //   297: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: aload 5
    //   305: invokeinterface 155 4 0
    //   310: aload 4
    //   312: ifnull +95 -> 407
    //   315: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   318: invokevirtual 111	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   321: ldc 113
    //   323: new 115	java/lang/StringBuilder
    //   326: dup
    //   327: ldc 145
    //   329: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: aload 4
    //   334: ldc 147
    //   336: invokevirtual 150	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokeinterface 133 3 0
    //   350: aconst_null
    //   351: areturn
    //   352: astore_3
    //   353: aconst_null
    //   354: astore 4
    //   356: aload 4
    //   358: ifnull +38 -> 396
    //   361: invokestatic 100	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   364: invokevirtual 111	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   367: ldc 113
    //   369: new 115	java/lang/StringBuilder
    //   372: dup
    //   373: ldc 145
    //   375: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload 4
    //   380: ldc 147
    //   382: invokevirtual 150	com/crashlytics/android/internal/ay:a	(Ljava/lang/String;)Ljava/lang/String;
    //   385: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokeinterface 133 3 0
    //   396: aload_3
    //   397: athrow
    //   398: astore_3
    //   399: goto -43 -> 356
    //   402: astore 5
    //   404: goto -128 -> 276
    //   407: aconst_null
    //   408: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	70	271	java/lang/Exception
    //   70	95	271	java/lang/Exception
    //   95	102	271	java/lang/Exception
    //   0	70	352	finally
    //   70	95	352	finally
    //   95	102	352	finally
    //   106	228	398	finally
    //   276	310	398	finally
    //   106	228	402	java/lang/Exception
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.aO
 * JD-Core Version:    0.6.2
 */