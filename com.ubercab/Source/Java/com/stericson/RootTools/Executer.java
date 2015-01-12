package com.stericson.RootTools;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

class Executer
{
  protected Process process = null;
  protected RootTools.Result result = null;

  public void closeShell()
  {
    if (this.process != null);
    try
    {
      this.process.destroy();
      label14: this.process = null;
      if (this.result != null)
        this.result = null;
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }

  List<String> sendShell(String[] paramArrayOfString, int paramInt1, RootTools.Result paramResult, boolean paramBoolean, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    String str1 = InternalVariables.TAG;
    StringBuilder localStringBuilder = new StringBuilder("Sending ").append(paramArrayOfString.length).append(" shell command");
    String str2;
    if (paramArrayOfString.length > 1)
      str2 = "s";
    while (true)
    {
      RootTools.log(str1, str2);
      Worker localWorker = new Worker(this, paramArrayOfString, paramInt1, paramResult, paramBoolean, null);
      localWorker.start();
      if (paramInt2 == -1)
        paramInt2 = 300000;
      long l = paramInt2;
      try
      {
        localWorker.join(l);
        Thread.sleep(RootTools.shellDelay);
        if (localWorker.exit != -911)
        {
          List localList = localWorker.finalResponse;
          return localList;
          str2 = "";
        }
        else
        {
          throw new TimeoutException();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localWorker.interrupt();
        Thread.currentThread().interrupt();
      }
    }
    throw new TimeoutException();
  }

  protected static class Worker extends Thread
  {
    private String[] commands;
    private Executer executer;
    public int exit = -911;
    public List<String> finalResponse;
    private int sleepTime;
    private boolean useRoot;

    private Worker(Executer paramExecuter, String[] paramArrayOfString, int paramInt, RootTools.Result paramResult, boolean paramBoolean)
    {
      this.commands = paramArrayOfString;
      this.sleepTime = paramInt;
      this.executer = paramExecuter;
      this.executer.result = paramResult;
      this.useRoot = paramBoolean;
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aconst_null
      //   3: astore_2
      //   4: aconst_null
      //   5: astore_3
      //   6: aload_0
      //   7: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   10: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   13: astore 10
      //   15: aconst_null
      //   16: astore_1
      //   17: aconst_null
      //   18: astore_3
      //   19: aconst_null
      //   20: astore_2
      //   21: aload 10
      //   23: ifnonnull +98 -> 121
      //   26: invokestatic 55	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   29: invokevirtual 58	java/lang/Runtime:gc	()V
      //   32: getstatic 64	com/stericson/RootTools/RootTools:customShell	Ljava/lang/String;
      //   35: ldc 66
      //   37: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   40: ifeq +391 -> 431
      //   43: aload_0
      //   44: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   47: astore 42
      //   49: invokestatic 55	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   52: astore 43
      //   54: aload_0
      //   55: getfield 37	com/stericson/RootTools/Executer$Worker:useRoot	Z
      //   58: ifeq +366 -> 424
      //   61: ldc 74
      //   63: astore 44
      //   65: aload 42
      //   67: aload 43
      //   69: aload 44
      //   71: invokevirtual 78	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
      //   74: putfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   77: aload_0
      //   78: getfield 37	com/stericson/RootTools/Executer$Worker:useRoot	Z
      //   81: ifeq +1404 -> 1485
      //   84: ldc 80
      //   86: astore 45
      //   88: aload 45
      //   90: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   93: aload_0
      //   94: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   97: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   100: ifnull +21 -> 121
      //   103: aload_0
      //   104: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   107: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   110: aload_0
      //   111: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   114: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   117: invokevirtual 90	com/stericson/RootTools/RootTools$Result:setProcess	(Ljava/lang/Process;)Lcom/stericson/RootTools/RootTools$Result;
      //   120: pop
      //   121: new 92	java/io/DataOutputStream
      //   124: dup
      //   125: aload_0
      //   126: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   129: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   132: invokevirtual 98	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   135: invokespecial 101	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   138: astore 11
      //   140: new 103	java/io/InputStreamReader
      //   143: dup
      //   144: aload_0
      //   145: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   148: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   151: invokevirtual 107	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   154: invokespecial 110	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   157: astore 12
      //   159: new 103	java/io/InputStreamReader
      //   162: dup
      //   163: aload_0
      //   164: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   167: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   170: invokevirtual 113	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   173: invokespecial 110	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   176: astore 13
      //   178: new 115	java/io/BufferedReader
      //   181: dup
      //   182: aload 12
      //   184: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   187: astore 14
      //   189: new 115	java/io/BufferedReader
      //   192: dup
      //   193: aload 13
      //   195: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   198: astore 15
      //   200: aload_0
      //   201: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   204: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   207: astore 17
      //   209: aconst_null
      //   210: astore 18
      //   212: aload 17
      //   214: ifnonnull +12 -> 226
      //   217: new 120	java/util/LinkedList
      //   220: dup
      //   221: invokespecial 121	java/util/LinkedList:<init>	()V
      //   224: astore 18
      //   226: aload_0
      //   227: getfield 25	com/stericson/RootTools/Executer$Worker:commands	[Ljava/lang/String;
      //   230: astore 28
      //   232: aload 28
      //   234: arraylength
      //   235: istore 29
      //   237: iconst_0
      //   238: istore 30
      //   240: iload 30
      //   242: iload 29
      //   244: if_icmplt +271 -> 515
      //   247: aload 11
      //   249: ldc 123
      //   251: invokevirtual 126	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   254: aload 11
      //   256: invokevirtual 129	java/io/DataOutputStream:flush	()V
      //   259: aload 14
      //   261: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   264: astore 31
      //   266: aload 15
      //   268: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   271: astore 32
      //   273: aload 31
      //   275: ifnonnull +311 -> 586
      //   278: ldc 135
      //   280: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   283: aload 32
      //   285: ifnonnull +883 -> 1168
      //   288: ldc 137
      //   290: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   293: ldc 139
      //   295: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   298: aload_0
      //   299: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   302: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   305: ifnull +69 -> 374
      //   308: ldc 141
      //   310: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   313: aload_0
      //   314: aload 18
      //   316: putfield 143	com/stericson/RootTools/Executer$Worker:finalResponse	Ljava/util/List;
      //   319: aload_0
      //   320: iconst_m1
      //   321: putfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   324: aload_0
      //   325: aload_0
      //   326: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   329: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   332: invokevirtual 147	java/lang/Process:waitFor	()I
      //   335: putfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   338: ldc 149
      //   340: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   343: aload_0
      //   344: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   347: putstatic 152	com/stericson/RootTools/RootTools:lastExitCode	I
      //   350: aload_0
      //   351: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   354: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   357: ifnull +976 -> 1333
      //   360: aload_0
      //   361: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   364: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   367: aload_0
      //   368: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   371: invokevirtual 156	com/stericson/RootTools/RootTools$Result:onComplete	(I)V
      //   374: aload 11
      //   376: ifnull +1106 -> 1482
      //   379: aload 11
      //   381: ldc 123
      //   383: invokevirtual 126	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   386: aload 11
      //   388: invokevirtual 129	java/io/DataOutputStream:flush	()V
      //   391: aload 11
      //   393: invokevirtual 159	java/io/DataOutputStream:close	()V
      //   396: aload 12
      //   398: ifnull +1081 -> 1479
      //   401: aload 12
      //   403: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   406: aload 13
      //   408: ifnull +1068 -> 1476
      //   411: aload 13
      //   413: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   416: aload_0
      //   417: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   420: invokevirtual 163	com/stericson/RootTools/Executer:closeShell	()V
      //   423: return
      //   424: ldc 165
      //   426: astore 44
      //   428: goto -363 -> 65
      //   431: aload_0
      //   432: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   435: invokestatic 55	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   438: getstatic 64	com/stericson/RootTools/RootTools:customShell	Ljava/lang/String;
      //   441: invokevirtual 78	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
      //   444: putfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   447: new 167	java/lang/StringBuilder
      //   450: dup
      //   451: ldc 169
      //   453: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   456: getstatic 64	com/stericson/RootTools/RootTools:customShell	Ljava/lang/String;
      //   459: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   462: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   465: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   468: goto -375 -> 93
      //   471: astore 8
      //   473: aload_1
      //   474: ifnull +17 -> 491
      //   477: aload_1
      //   478: ldc 123
      //   480: invokevirtual 126	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   483: aload_1
      //   484: invokevirtual 129	java/io/DataOutputStream:flush	()V
      //   487: aload_1
      //   488: invokevirtual 159	java/io/DataOutputStream:close	()V
      //   491: aload_2
      //   492: ifnull +7 -> 499
      //   495: aload_2
      //   496: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   499: aload_3
      //   500: ifnull +7 -> 507
      //   503: aload_3
      //   504: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   507: aload_0
      //   508: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   511: invokevirtual 163	com/stericson/RootTools/Executer:closeShell	()V
      //   514: return
      //   515: aload 28
      //   517: iload 30
      //   519: aaload
      //   520: astore 38
      //   522: new 167	java/lang/StringBuilder
      //   525: dup
      //   526: ldc 180
      //   528: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   531: aload 38
      //   533: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   536: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   539: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   542: aload 11
      //   544: new 167	java/lang/StringBuilder
      //   547: dup
      //   548: aload 38
      //   550: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   553: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   556: ldc 186
      //   558: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   561: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   564: invokevirtual 126	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   567: aload 11
      //   569: invokevirtual 129	java/io/DataOutputStream:flush	()V
      //   572: aload_0
      //   573: getfield 27	com/stericson/RootTools/Executer$Worker:sleepTime	I
      //   576: i2l
      //   577: invokestatic 190	java/lang/Thread:sleep	(J)V
      //   580: iinc 30 1
      //   583: goto -343 -> 240
      //   586: aload_0
      //   587: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   590: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   593: ifnonnull +196 -> 789
      //   596: aload 18
      //   598: aload 31
      //   600: invokeinterface 195 2 0
      //   605: pop
      //   606: aload_0
      //   607: getfield 25	com/stericson/RootTools/Executer$Worker:commands	[Ljava/lang/String;
      //   610: iconst_0
      //   611: aaload
      //   612: ldc 197
      //   614: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   617: ifeq +51 -> 668
      //   620: new 199	java/util/HashSet
      //   623: dup
      //   624: aload 31
      //   626: ldc 201
      //   628: invokevirtual 205	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   631: invokestatic 211	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
      //   634: invokespecial 214	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   637: invokeinterface 220 1 0
      //   642: astore 36
      //   644: aload 36
      //   646: invokeinterface 226 1 0
      //   651: ifne +305 -> 956
      //   654: getstatic 231	com/stericson/RootTools/InternalVariables:accessGiven	Z
      //   657: ifne +11 -> 668
      //   660: getstatic 234	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
      //   663: ldc 236
      //   665: invokestatic 239	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
      //   668: aload_0
      //   669: getfield 25	com/stericson/RootTools/Executer$Worker:commands	[Ljava/lang/String;
      //   672: iconst_0
      //   673: aaload
      //   674: ldc 241
      //   676: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   679: ifeq +25 -> 704
      //   682: aload 31
      //   684: ldc 243
      //   686: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   689: ifeq +15 -> 704
      //   692: aload 31
      //   694: ldc 201
      //   696: invokevirtual 205	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   699: iconst_1
      //   700: aaload
      //   701: putstatic 250	com/stericson/RootTools/InternalVariables:busyboxVersion	Ljava/lang/String;
      //   704: aload_0
      //   705: getfield 25	com/stericson/RootTools/Executer$Worker:commands	[Ljava/lang/String;
      //   708: iconst_0
      //   709: aaload
      //   710: ldc 252
      //   712: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   715: ifeq +43 -> 758
      //   718: aload 31
      //   720: aload_0
      //   721: getfield 25	com/stericson/RootTools/Executer$Worker:commands	[Ljava/lang/String;
      //   724: iconst_0
      //   725: aaload
      //   726: iconst_2
      //   727: aload_0
      //   728: getfield 25	com/stericson/RootTools/Executer$Worker:commands	[Ljava/lang/String;
      //   731: iconst_0
      //   732: aaload
      //   733: invokevirtual 255	java/lang/String:length	()I
      //   736: invokevirtual 259	java/lang/String:substring	(II)Ljava/lang/String;
      //   739: invokevirtual 262	java/lang/String:trim	()Ljava/lang/String;
      //   742: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   745: ifeq +13 -> 758
      //   748: aload 31
      //   750: ldc 201
      //   752: invokevirtual 205	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   755: putstatic 269	com/stericson/RootTools/InternalVariables:space	[Ljava/lang/String;
      //   758: new 167	java/lang/StringBuilder
      //   761: dup
      //   762: ldc_w 271
      //   765: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   768: aload 31
      //   770: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   773: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   776: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   779: aload 14
      //   781: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   784: astore 31
      //   786: goto -513 -> 273
      //   789: aload_0
      //   790: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   793: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   796: aload 31
      //   798: invokevirtual 273	com/stericson/RootTools/RootTools$Result:process	(Ljava/lang/String;)V
      //   801: goto -195 -> 606
      //   804: astore 22
      //   806: getstatic 276	com/stericson/RootTools/RootTools:debugMode	Z
      //   809: ifeq +27 -> 836
      //   812: new 167	java/lang/StringBuilder
      //   815: dup
      //   816: ldc_w 278
      //   819: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   822: aload 22
      //   824: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   827: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   830: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   833: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   836: aload_0
      //   837: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   840: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   843: ifnull +15 -> 858
      //   846: aload_0
      //   847: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   850: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   853: aload 22
      //   855: invokevirtual 285	com/stericson/RootTools/RootTools$Result:onFailure	(Ljava/lang/Exception;)V
      //   858: ldc 139
      //   860: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   863: aload_0
      //   864: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   867: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   870: ifnull -496 -> 374
      //   873: ldc 141
      //   875: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   878: aload_0
      //   879: aload 18
      //   881: putfield 143	com/stericson/RootTools/Executer$Worker:finalResponse	Ljava/util/List;
      //   884: aload_0
      //   885: iconst_m1
      //   886: putfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   889: aload_0
      //   890: aload_0
      //   891: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   894: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   897: invokevirtual 147	java/lang/Process:waitFor	()I
      //   900: putfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   903: ldc 149
      //   905: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   908: aload_0
      //   909: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   912: putstatic 152	com/stericson/RootTools/RootTools:lastExitCode	I
      //   915: aload_0
      //   916: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   919: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   922: ifnull +312 -> 1234
      //   925: aload_0
      //   926: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   929: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   932: aload_0
      //   933: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   936: invokevirtual 156	com/stericson/RootTools/RootTools$Result:onComplete	(I)V
      //   939: goto -565 -> 374
      //   942: astore 16
      //   944: aload 13
      //   946: astore_3
      //   947: aload 12
      //   949: astore_2
      //   950: aload 11
      //   952: astore_1
      //   953: goto -480 -> 473
      //   956: aload 36
      //   958: invokeinterface 289 1 0
      //   963: checkcast 68	java/lang/String
      //   966: invokevirtual 292	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   969: ldc_w 294
      //   972: invokevirtual 266	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   975: ifeq -331 -> 644
      //   978: iconst_1
      //   979: putstatic 231	com/stericson/RootTools/InternalVariables:accessGiven	Z
      //   982: getstatic 234	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
      //   985: ldc_w 296
      //   988: invokestatic 239	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
      //   991: goto -337 -> 654
      //   994: astore 19
      //   996: ldc 139
      //   998: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   1001: aload_0
      //   1002: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1005: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   1008: ifnull +69 -> 1077
      //   1011: ldc 141
      //   1013: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   1016: aload_0
      //   1017: aload 18
      //   1019: putfield 143	com/stericson/RootTools/Executer$Worker:finalResponse	Ljava/util/List;
      //   1022: aload_0
      //   1023: iconst_m1
      //   1024: putfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1027: aload_0
      //   1028: aload_0
      //   1029: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1032: getfield 49	com/stericson/RootTools/Executer:process	Ljava/lang/Process;
      //   1035: invokevirtual 147	java/lang/Process:waitFor	()I
      //   1038: putfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1041: ldc 149
      //   1043: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   1046: aload_0
      //   1047: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1050: putstatic 152	com/stericson/RootTools/RootTools:lastExitCode	I
      //   1053: aload_0
      //   1054: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1057: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   1060: ifnull +251 -> 1311
      //   1063: aload_0
      //   1064: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1067: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   1070: aload_0
      //   1071: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1074: invokevirtual 156	com/stericson/RootTools/RootTools$Result:onComplete	(I)V
      //   1077: aload 19
      //   1079: athrow
      //   1080: astore 4
      //   1082: aload 13
      //   1084: astore_3
      //   1085: aload 12
      //   1087: astore_2
      //   1088: aload 11
      //   1090: astore_1
      //   1091: getstatic 276	com/stericson/RootTools/RootTools:debugMode	Z
      //   1094: ifeq +32 -> 1126
      //   1097: aload 4
      //   1099: invokevirtual 299	java/lang/Exception:printStackTrace	()V
      //   1102: new 167	java/lang/StringBuilder
      //   1105: dup
      //   1106: ldc_w 278
      //   1109: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1112: aload 4
      //   1114: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1117: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1120: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1123: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   1126: aload_1
      //   1127: ifnull +17 -> 1144
      //   1130: aload_1
      //   1131: ldc 123
      //   1133: invokevirtual 126	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   1136: aload_1
      //   1137: invokevirtual 129	java/io/DataOutputStream:flush	()V
      //   1140: aload_1
      //   1141: invokevirtual 159	java/io/DataOutputStream:close	()V
      //   1144: aload_2
      //   1145: ifnull +7 -> 1152
      //   1148: aload_2
      //   1149: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   1152: aload_3
      //   1153: ifnull +7 -> 1160
      //   1156: aload_3
      //   1157: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   1160: aload_0
      //   1161: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1164: invokevirtual 163	com/stericson/RootTools/Executer:closeShell	()V
      //   1167: return
      //   1168: aload_0
      //   1169: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1172: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   1175: ifnonnull +44 -> 1219
      //   1178: aload 18
      //   1180: aload 32
      //   1182: invokeinterface 195 2 0
      //   1187: pop
      //   1188: new 167	java/lang/StringBuilder
      //   1191: dup
      //   1192: ldc_w 301
      //   1195: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1198: aload 32
      //   1200: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1203: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1206: invokestatic 84	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   1209: aload 15
      //   1211: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   1214: astore 32
      //   1216: goto -933 -> 283
      //   1219: aload_0
      //   1220: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1223: getfield 35	com/stericson/RootTools/Executer:result	Lcom/stericson/RootTools/RootTools$Result;
      //   1226: aload 32
      //   1228: invokevirtual 304	com/stericson/RootTools/RootTools$Result:processError	(Ljava/lang/String;)V
      //   1231: goto -43 -> 1188
      //   1234: aload_0
      //   1235: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1238: invokestatic 309	java/lang/Integer:toString	(I)Ljava/lang/String;
      //   1241: astore 23
      //   1243: aload 18
      //   1245: aload 23
      //   1247: invokeinterface 195 2 0
      //   1252: pop
      //   1253: goto -879 -> 374
      //   1256: astore 5
      //   1258: aload 13
      //   1260: astore_3
      //   1261: aload 12
      //   1263: astore_2
      //   1264: aload 11
      //   1266: astore_1
      //   1267: aload_1
      //   1268: ifnull +17 -> 1285
      //   1271: aload_1
      //   1272: ldc 123
      //   1274: invokevirtual 126	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   1277: aload_1
      //   1278: invokevirtual 129	java/io/DataOutputStream:flush	()V
      //   1281: aload_1
      //   1282: invokevirtual 159	java/io/DataOutputStream:close	()V
      //   1285: aload_2
      //   1286: ifnull +7 -> 1293
      //   1289: aload_2
      //   1290: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   1293: aload_3
      //   1294: ifnull +7 -> 1301
      //   1297: aload_3
      //   1298: invokevirtual 160	java/io/InputStreamReader:close	()V
      //   1301: aload_0
      //   1302: getfield 29	com/stericson/RootTools/Executer$Worker:executer	Lcom/stericson/RootTools/Executer;
      //   1305: invokevirtual 163	com/stericson/RootTools/Executer:closeShell	()V
      //   1308: aload 5
      //   1310: athrow
      //   1311: aload_0
      //   1312: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1315: invokestatic 309	java/lang/Integer:toString	(I)Ljava/lang/String;
      //   1318: astore 20
      //   1320: aload 18
      //   1322: aload 20
      //   1324: invokeinterface 195 2 0
      //   1329: pop
      //   1330: goto -253 -> 1077
      //   1333: aload_0
      //   1334: getfield 23	com/stericson/RootTools/Executer$Worker:exit	I
      //   1337: invokestatic 309	java/lang/Integer:toString	(I)Ljava/lang/String;
      //   1340: astore 33
      //   1342: aload 18
      //   1344: aload 33
      //   1346: invokeinterface 195 2 0
      //   1351: pop
      //   1352: goto -978 -> 374
      //   1355: astore 27
      //   1357: goto -941 -> 416
      //   1360: astore 26
      //   1362: goto -5 -> 1357
      //   1365: astore 25
      //   1367: goto -10 -> 1357
      //   1370: astore 6
      //   1372: goto -71 -> 1301
      //   1375: astore 5
      //   1377: goto -110 -> 1267
      //   1380: astore 5
      //   1382: aload 11
      //   1384: astore_1
      //   1385: aconst_null
      //   1386: astore_3
      //   1387: aconst_null
      //   1388: astore_2
      //   1389: goto -122 -> 1267
      //   1392: astore 5
      //   1394: aload 12
      //   1396: astore_2
      //   1397: aload 11
      //   1399: astore_1
      //   1400: aconst_null
      //   1401: astore_3
      //   1402: goto -135 -> 1267
      //   1405: astore 7
      //   1407: goto -247 -> 1160
      //   1410: astore 4
      //   1412: aconst_null
      //   1413: astore_1
      //   1414: aconst_null
      //   1415: astore_3
      //   1416: aconst_null
      //   1417: astore_2
      //   1418: goto -327 -> 1091
      //   1421: astore 4
      //   1423: aload 11
      //   1425: astore_1
      //   1426: aconst_null
      //   1427: astore_3
      //   1428: aconst_null
      //   1429: astore_2
      //   1430: goto -339 -> 1091
      //   1433: astore 4
      //   1435: aload 12
      //   1437: astore_2
      //   1438: aload 11
      //   1440: astore_1
      //   1441: aconst_null
      //   1442: astore_3
      //   1443: goto -352 -> 1091
      //   1446: astore 9
      //   1448: goto -941 -> 507
      //   1451: astore 40
      //   1453: aload 11
      //   1455: astore_1
      //   1456: aconst_null
      //   1457: astore_3
      //   1458: aconst_null
      //   1459: astore_2
      //   1460: goto -987 -> 473
      //   1463: astore 39
      //   1465: aload 12
      //   1467: astore_2
      //   1468: aload 11
      //   1470: astore_1
      //   1471: aconst_null
      //   1472: astore_3
      //   1473: goto -1000 -> 473
      //   1476: goto -1060 -> 416
      //   1479: goto -1073 -> 406
      //   1482: goto -1086 -> 396
      //   1485: ldc_w 311
      //   1488: astore 45
      //   1490: goto -1402 -> 88
      //
      // Exception table:
      //   from	to	target	type
      //   6	15	471	java/lang/InterruptedException
      //   26	61	471	java/lang/InterruptedException
      //   65	84	471	java/lang/InterruptedException
      //   88	93	471	java/lang/InterruptedException
      //   93	121	471	java/lang/InterruptedException
      //   121	140	471	java/lang/InterruptedException
      //   431	468	471	java/lang/InterruptedException
      //   226	237	804	java/lang/Exception
      //   247	273	804	java/lang/Exception
      //   278	283	804	java/lang/Exception
      //   288	293	804	java/lang/Exception
      //   515	580	804	java/lang/Exception
      //   586	606	804	java/lang/Exception
      //   606	644	804	java/lang/Exception
      //   644	654	804	java/lang/Exception
      //   654	668	804	java/lang/Exception
      //   668	704	804	java/lang/Exception
      //   704	758	804	java/lang/Exception
      //   758	786	804	java/lang/Exception
      //   789	801	804	java/lang/Exception
      //   956	991	804	java/lang/Exception
      //   1168	1188	804	java/lang/Exception
      //   1188	1216	804	java/lang/Exception
      //   1219	1231	804	java/lang/Exception
      //   178	209	942	java/lang/InterruptedException
      //   217	226	942	java/lang/InterruptedException
      //   293	374	942	java/lang/InterruptedException
      //   858	939	942	java/lang/InterruptedException
      //   996	1077	942	java/lang/InterruptedException
      //   1077	1080	942	java/lang/InterruptedException
      //   1234	1253	942	java/lang/InterruptedException
      //   1311	1330	942	java/lang/InterruptedException
      //   1333	1352	942	java/lang/InterruptedException
      //   226	237	994	finally
      //   247	273	994	finally
      //   278	283	994	finally
      //   288	293	994	finally
      //   515	580	994	finally
      //   586	606	994	finally
      //   606	644	994	finally
      //   644	654	994	finally
      //   654	668	994	finally
      //   668	704	994	finally
      //   704	758	994	finally
      //   758	786	994	finally
      //   789	801	994	finally
      //   806	836	994	finally
      //   836	858	994	finally
      //   956	991	994	finally
      //   1168	1188	994	finally
      //   1188	1216	994	finally
      //   1219	1231	994	finally
      //   178	209	1080	java/lang/Exception
      //   217	226	1080	java/lang/Exception
      //   293	374	1080	java/lang/Exception
      //   858	939	1080	java/lang/Exception
      //   996	1077	1080	java/lang/Exception
      //   1077	1080	1080	java/lang/Exception
      //   1234	1253	1080	java/lang/Exception
      //   1311	1330	1080	java/lang/Exception
      //   1333	1352	1080	java/lang/Exception
      //   178	209	1256	finally
      //   217	226	1256	finally
      //   293	374	1256	finally
      //   858	939	1256	finally
      //   996	1077	1256	finally
      //   1077	1080	1256	finally
      //   1234	1253	1256	finally
      //   1311	1330	1256	finally
      //   1333	1352	1256	finally
      //   379	396	1355	java/lang/Exception
      //   401	406	1360	java/lang/Exception
      //   411	416	1365	java/lang/Exception
      //   1271	1285	1370	java/lang/Exception
      //   1289	1293	1370	java/lang/Exception
      //   1297	1301	1370	java/lang/Exception
      //   6	15	1375	finally
      //   26	61	1375	finally
      //   65	84	1375	finally
      //   88	93	1375	finally
      //   93	121	1375	finally
      //   121	140	1375	finally
      //   431	468	1375	finally
      //   1091	1126	1375	finally
      //   140	159	1380	finally
      //   159	178	1392	finally
      //   1130	1144	1405	java/lang/Exception
      //   1148	1152	1405	java/lang/Exception
      //   1156	1160	1405	java/lang/Exception
      //   6	15	1410	java/lang/Exception
      //   26	61	1410	java/lang/Exception
      //   65	84	1410	java/lang/Exception
      //   88	93	1410	java/lang/Exception
      //   93	121	1410	java/lang/Exception
      //   121	140	1410	java/lang/Exception
      //   431	468	1410	java/lang/Exception
      //   140	159	1421	java/lang/Exception
      //   159	178	1433	java/lang/Exception
      //   477	491	1446	java/lang/Exception
      //   495	499	1446	java/lang/Exception
      //   503	507	1446	java/lang/Exception
      //   140	159	1451	java/lang/InterruptedException
      //   159	178	1463	java/lang/InterruptedException
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Executer
 * JD-Core Version:    0.6.2
 */