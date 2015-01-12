package com.crashlytics.android;

final class ac extends com.crashlytics.android.internal.aa
{
  private final float a;

  ac(aa paramaa, float paramFloat)
  {
    this.a = paramFloat;
  }

  // ERROR //
  public final void a()
  {
    // Byte code:
    //   0: invokestatic 26	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   3: invokevirtual 29	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   6: ldc 31
    //   8: new 33	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 35
    //   14: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 17	com/crashlytics/android/ac:a	F
    //   21: invokevirtual 42	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   24: ldc 44
    //   26: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokeinterface 56 3 0
    //   37: aload_0
    //   38: getfield 17	com/crashlytics/android/ac:a	F
    //   41: fstore_3
    //   42: fload_3
    //   43: fconst_0
    //   44: fcmpl
    //   45: ifle +14 -> 59
    //   48: ldc 57
    //   50: aload_0
    //   51: getfield 17	com/crashlytics/android/ac:a	F
    //   54: fmul
    //   55: f2l
    //   56: invokestatic 63	java/lang/Thread:sleep	(J)V
    //   59: invokestatic 69	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   62: astore 4
    //   64: aload 4
    //   66: invokevirtual 73	com/crashlytics/android/Crashlytics:l	()Lcom/crashlytics/android/v;
    //   69: astore 5
    //   71: aload_0
    //   72: getfield 12	com/crashlytics/android/ac:b	Lcom/crashlytics/android/aa;
    //   75: invokevirtual 78	com/crashlytics/android/aa:a	()Ljava/util/List;
    //   78: astore 6
    //   80: aload 5
    //   82: invokevirtual 83	com/crashlytics/android/v:a	()Z
    //   85: ifne +114 -> 199
    //   88: aload 6
    //   90: invokeinterface 88 1 0
    //   95: ifne +344 -> 439
    //   98: aload 4
    //   100: invokevirtual 91	com/crashlytics/android/Crashlytics:p	()Z
    //   103: ifne +336 -> 439
    //   106: invokestatic 26	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   109: invokevirtual 29	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   112: ldc 31
    //   114: new 33	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 93
    //   120: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 6
    //   125: invokeinterface 97 1 0
    //   130: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc 102
    //   135: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokeinterface 56 3 0
    //   146: aload 6
    //   148: invokeinterface 106 1 0
    //   153: astore 18
    //   155: aload 18
    //   157: invokeinterface 111 1 0
    //   162: ifeq +37 -> 199
    //   165: aload 18
    //   167: invokeinterface 115 1 0
    //   172: checkcast 117	com/crashlytics/android/Z
    //   175: invokevirtual 118	com/crashlytics/android/Z:a	()Z
    //   178: pop
    //   179: goto -24 -> 155
    //   182: astore_1
    //   183: invokestatic 26	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   186: invokevirtual 29	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   189: ldc 31
    //   191: ldc 120
    //   193: aload_1
    //   194: invokeinterface 123 4 0
    //   199: aload_0
    //   200: getfield 12	com/crashlytics/android/ac:b	Lcom/crashlytics/android/aa;
    //   203: aconst_null
    //   204: invokestatic 126	com/crashlytics/android/aa:a	(Lcom/crashlytics/android/aa;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   207: pop
    //   208: return
    //   209: astore 20
    //   211: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   214: invokevirtual 133	java/lang/Thread:interrupt	()V
    //   217: goto -18 -> 199
    //   220: aload 6
    //   222: invokeinterface 88 1 0
    //   227: ifne -28 -> 199
    //   230: invokestatic 69	com/crashlytics/android/Crashlytics:getInstance	()Lcom/crashlytics/android/Crashlytics;
    //   233: invokevirtual 73	com/crashlytics/android/Crashlytics:l	()Lcom/crashlytics/android/v;
    //   236: invokevirtual 83	com/crashlytics/android/v:a	()Z
    //   239: ifne -40 -> 199
    //   242: invokestatic 26	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   245: invokevirtual 29	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   248: ldc 31
    //   250: new 33	java/lang/StringBuilder
    //   253: dup
    //   254: ldc 135
    //   256: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   259: aload 6
    //   261: invokeinterface 97 1 0
    //   266: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: ldc 137
    //   271: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokeinterface 56 3 0
    //   282: aload 6
    //   284: invokeinterface 106 1 0
    //   289: astore 8
    //   291: aload 8
    //   293: invokeinterface 111 1 0
    //   298: ifeq +28 -> 326
    //   301: aload 8
    //   303: invokeinterface 115 1 0
    //   308: checkcast 117	com/crashlytics/android/Z
    //   311: astore 16
    //   313: aload_0
    //   314: getfield 12	com/crashlytics/android/ac:b	Lcom/crashlytics/android/aa;
    //   317: aload 16
    //   319: invokevirtual 140	com/crashlytics/android/aa:a	(Lcom/crashlytics/android/Z;)Z
    //   322: pop
    //   323: goto -32 -> 291
    //   326: aload_0
    //   327: getfield 12	com/crashlytics/android/ac:b	Lcom/crashlytics/android/aa;
    //   330: invokevirtual 78	com/crashlytics/android/aa:a	()Ljava/util/List;
    //   333: astore 6
    //   335: aload 6
    //   337: invokeinterface 88 1 0
    //   342: ifne -122 -> 220
    //   345: invokestatic 143	com/crashlytics/android/aa:b	()[S
    //   348: astore 9
    //   350: iload 7
    //   352: iconst_1
    //   353: iadd
    //   354: istore 10
    //   356: aload 9
    //   358: iload 7
    //   360: iconst_m1
    //   361: invokestatic 143	com/crashlytics/android/aa:b	()[S
    //   364: arraylength
    //   365: iadd
    //   366: invokestatic 149	java/lang/Math:min	(II)I
    //   369: saload
    //   370: i2l
    //   371: lstore 11
    //   373: invokestatic 26	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   376: invokevirtual 29	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   379: ldc 31
    //   381: new 33	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 151
    //   387: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: lload 11
    //   392: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: ldc 156
    //   397: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokeinterface 56 3 0
    //   408: lload 11
    //   410: ldc2_w 157
    //   413: lmul
    //   414: lstore 13
    //   416: lload 13
    //   418: invokestatic 63	java/lang/Thread:sleep	(J)V
    //   421: iload 10
    //   423: istore 7
    //   425: goto -205 -> 220
    //   428: astore 15
    //   430: invokestatic 130	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   433: invokevirtual 133	java/lang/Thread:interrupt	()V
    //   436: goto -237 -> 199
    //   439: iconst_0
    //   440: istore 7
    //   442: goto -222 -> 220
    //
    // Exception table:
    //   from	to	target	type
    //   0	42	182	java/lang/Exception
    //   48	59	182	java/lang/Exception
    //   59	155	182	java/lang/Exception
    //   155	179	182	java/lang/Exception
    //   211	217	182	java/lang/Exception
    //   220	291	182	java/lang/Exception
    //   291	323	182	java/lang/Exception
    //   326	350	182	java/lang/Exception
    //   356	408	182	java/lang/Exception
    //   416	421	182	java/lang/Exception
    //   430	436	182	java/lang/Exception
    //   48	59	209	java/lang/InterruptedException
    //   416	421	428	java/lang/InterruptedException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.ac
 * JD-Core Version:    0.6.2
 */