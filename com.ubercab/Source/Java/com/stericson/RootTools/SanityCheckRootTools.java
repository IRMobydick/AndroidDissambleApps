package com.stericson.RootTools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ScrollView;
import android.widget.TextView;

public class SanityCheckRootTools extends Activity
{
  private ProgressDialog mPDialog;
  private ScrollView mScrollView;
  private TextView mTextView;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mTextView = new TextView(this);
    this.mTextView.setText("");
    this.mScrollView = new ScrollView(this);
    this.mScrollView.addView(this.mTextView);
    setContentView(this.mScrollView);
    String str = "?";
    try
    {
      str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      label76: print("SanityCheckRootTools v " + str + "\n\n");
      try
      {
        if (!RootTools.isAccessGiven())
        {
          print("ERROR: No root access to this device.\n");
          return;
        }
      }
      catch (Exception localException)
      {
        print("ERROR: could not determine root access to this device.\n");
        return;
      }
      this.mPDialog = new ProgressDialog(this);
      this.mPDialog.setCancelable(false);
      this.mPDialog.setProgressStyle(0);
      new SanityCheckThread(this, new TestHandler(null)).start();
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label76;
    }
  }

  protected void print(CharSequence paramCharSequence)
  {
    this.mTextView.append(paramCharSequence);
    this.mScrollView.post(new Runnable()
    {
      public void run()
      {
        SanityCheckRootTools.this.mScrollView.fullScroll(130);
      }
    });
  }

  private class SanityCheckThread extends Thread
  {
    private Handler mHandler;

    public SanityCheckThread(Context paramHandler, Handler arg3)
    {
      Object localObject;
      this.mHandler = localObject;
    }

    private void visualUpdate(int paramInt, String paramString)
    {
      Message localMessage = this.mHandler.obtainMessage();
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", paramInt);
      localBundle.putString("text", paramString);
      localMessage.setData(localBundle);
      this.mHandler.sendMessage(localMessage);
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_1
      //   2: aconst_null
      //   3: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   6: aload_0
      //   7: iconst_4
      //   8: ldc 63
      //   10: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   13: ldc 65
      //   15: invokestatic 71	com/stericson/RootTools/RootTools:getSpace	(Ljava/lang/String;)J
      //   18: lstore_1
      //   19: aload_0
      //   20: iconst_3
      //   21: ldc 73
      //   23: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   26: aload_0
      //   27: iconst_3
      //   28: new 75	java/lang/StringBuilder
      //   31: dup
      //   32: lload_1
      //   33: invokestatic 81	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   36: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   39: ldc 86
      //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   47: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   50: aload_0
      //   51: iconst_4
      //   52: ldc 96
      //   54: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   57: ldc 98
      //   59: getstatic 104	com/stericson/RootTools/InternalVariables:timeout	I
      //   62: invokestatic 108	com/stericson/RootTools/RootTools:sendShell	(Ljava/lang/String;I)Ljava/util/List;
      //   65: astore 6
      //   67: aload_0
      //   68: iconst_3
      //   69: ldc 110
      //   71: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   74: aload 6
      //   76: invokeinterface 116 1 0
      //   81: astore 7
      //   83: aload 7
      //   85: invokeinterface 122 1 0
      //   90: istore 8
      //   92: iload 8
      //   94: ifne +51 -> 145
      //   97: aload_0
      //   98: iconst_4
      //   99: ldc 124
      //   101: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   104: aload_0
      //   105: iconst_3
      //   106: ldc 126
      //   108: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   111: new 128	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$1
      //   114: dup
      //   115: aload_0
      //   116: invokespecial 131	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$1:<init>	(Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;)V
      //   119: astore 12
      //   121: ldc 98
      //   123: aload 12
      //   125: getstatic 104	com/stericson/RootTools/InternalVariables:timeout	I
      //   128: invokestatic 134	com/stericson/RootTools/RootTools:sendShell	(Ljava/lang/String;Lcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;
      //   131: pop
      //   132: aload 12
      //   134: invokevirtual 140	com/stericson/RootTools/RootTools$Result:getError	()I
      //   137: istore 14
      //   139: iload 14
      //   141: ifeq +188 -> 329
      //   144: return
      //   145: aload_0
      //   146: iconst_3
      //   147: new 75	java/lang/StringBuilder
      //   150: dup
      //   151: aload 7
      //   153: invokeinterface 144 1 0
      //   158: checkcast 77	java/lang/String
      //   161: invokestatic 147	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   164: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   167: ldc 149
      //   169: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   175: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   178: goto -95 -> 83
      //   181: astore 5
      //   183: aload_0
      //   184: iconst_2
      //   185: new 75	java/lang/StringBuilder
      //   188: dup
      //   189: ldc 151
      //   191: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   194: aload 5
      //   196: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   199: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   202: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   205: return
      //   206: astore 4
      //   208: aload_0
      //   209: iconst_2
      //   210: new 75	java/lang/StringBuilder
      //   213: dup
      //   214: ldc 156
      //   216: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   219: aload 4
      //   221: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   224: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   227: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   230: return
      //   231: astore_3
      //   232: aload_0
      //   233: iconst_2
      //   234: new 75	java/lang/StringBuilder
      //   237: dup
      //   238: ldc 158
      //   240: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   243: aload_3
      //   244: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   247: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   250: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   253: return
      //   254: astore 11
      //   256: aload_0
      //   257: iconst_2
      //   258: new 75	java/lang/StringBuilder
      //   261: dup
      //   262: ldc 151
      //   264: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   267: aload 11
      //   269: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   272: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   275: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   278: return
      //   279: astore 10
      //   281: aload_0
      //   282: iconst_2
      //   283: new 75	java/lang/StringBuilder
      //   286: dup
      //   287: ldc 156
      //   289: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   292: aload 10
      //   294: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   297: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   300: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   303: return
      //   304: astore 9
      //   306: aload_0
      //   307: iconst_2
      //   308: new 75	java/lang/StringBuilder
      //   311: dup
      //   312: ldc 158
      //   314: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   317: aload 9
      //   319: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   322: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   325: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   328: return
      //   329: aload_0
      //   330: iconst_4
      //   331: ldc 160
      //   333: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   336: aload_0
      //   337: iconst_3
      //   338: ldc 162
      //   340: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   343: new 164	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$2
      //   346: dup
      //   347: aload_0
      //   348: invokespecial 165	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread$2:<init>	(Lcom/stericson/RootTools/SanityCheckRootTools$SanityCheckThread;)V
      //   351: astore 18
      //   353: bipush 6
      //   355: anewarray 77	java/lang/String
      //   358: dup
      //   359: iconst_0
      //   360: ldc 167
      //   362: aastore
      //   363: dup
      //   364: iconst_1
      //   365: ldc 169
      //   367: aastore
      //   368: dup
      //   369: iconst_2
      //   370: ldc 171
      //   372: aastore
      //   373: dup
      //   374: iconst_3
      //   375: ldc 173
      //   377: aastore
      //   378: dup
      //   379: iconst_4
      //   380: ldc 175
      //   382: aastore
      //   383: dup
      //   384: iconst_5
      //   385: ldc 177
      //   387: aastore
      //   388: sipush 2000
      //   391: aload 18
      //   393: getstatic 104	com/stericson/RootTools/InternalVariables:timeout	I
      //   396: invokestatic 180	com/stericson/RootTools/RootTools:sendShell	([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;
      //   399: pop
      //   400: aload 18
      //   402: invokevirtual 140	com/stericson/RootTools/RootTools$Result:getError	()I
      //   405: istore 20
      //   407: iload 20
      //   409: ifne -265 -> 144
      //   412: aload_0
      //   413: iconst_4
      //   414: ldc 182
      //   416: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   419: aload_0
      //   420: iconst_2
      //   421: aconst_null
      //   422: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   425: return
      //   426: astore 17
      //   428: aload_0
      //   429: iconst_2
      //   430: new 75	java/lang/StringBuilder
      //   433: dup
      //   434: ldc 151
      //   436: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   439: aload 17
      //   441: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   444: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   447: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   450: goto -38 -> 412
      //   453: astore 16
      //   455: aload_0
      //   456: iconst_2
      //   457: new 75	java/lang/StringBuilder
      //   460: dup
      //   461: ldc 156
      //   463: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   466: aload 16
      //   468: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   471: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   474: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   477: goto -65 -> 412
      //   480: astore 15
      //   482: aload_0
      //   483: iconst_2
      //   484: new 75	java/lang/StringBuilder
      //   487: dup
      //   488: ldc 158
      //   490: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   493: aload 15
      //   495: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   498: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   501: invokespecial 23	com/stericson/RootTools/SanityCheckRootTools$SanityCheckThread:visualUpdate	(ILjava/lang/String;)V
      //   504: return
      //   505: astore 15
      //   507: goto -25 -> 482
      //   510: astore 16
      //   512: goto -57 -> 455
      //   515: astore 17
      //   517: goto -89 -> 428
      //
      // Exception table:
      //   from	to	target	type
      //   57	83	181	java/io/IOException
      //   83	92	181	java/io/IOException
      //   145	178	181	java/io/IOException
      //   57	83	206	com/stericson/RootTools/RootToolsException
      //   83	92	206	com/stericson/RootTools/RootToolsException
      //   145	178	206	com/stericson/RootTools/RootToolsException
      //   57	83	231	java/util/concurrent/TimeoutException
      //   83	92	231	java/util/concurrent/TimeoutException
      //   145	178	231	java/util/concurrent/TimeoutException
      //   104	139	254	java/io/IOException
      //   104	139	279	com/stericson/RootTools/RootToolsException
      //   104	139	304	java/util/concurrent/TimeoutException
      //   336	353	426	java/io/IOException
      //   336	353	453	com/stericson/RootTools/RootToolsException
      //   336	353	480	java/util/concurrent/TimeoutException
      //   353	407	505	java/util/concurrent/TimeoutException
      //   353	407	510	com/stericson/RootTools/RootToolsException
      //   353	407	515	java/io/IOException
    }
  }

  private class TestHandler extends Handler
  {
    public static final String ACTION = "action";
    public static final int ACTION_DISPLAY = 3;
    public static final int ACTION_HIDE = 2;
    public static final int ACTION_PDISPLAY = 4;
    public static final int ACTION_SHOW = 1;
    public static final String TEXT = "text";

    private TestHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.getData().getInt("action");
      String str = paramMessage.getData().getString("text");
      switch (i)
      {
      default:
        return;
      case 1:
        SanityCheckRootTools.this.mPDialog.show();
        SanityCheckRootTools.this.mPDialog.setMessage("Running Root Library Tests...");
        return;
      case 2:
        if (str != null)
          SanityCheckRootTools.this.print(str);
        SanityCheckRootTools.this.mPDialog.hide();
        return;
      case 3:
        SanityCheckRootTools.this.print(str);
        return;
      case 4:
      }
      SanityCheckRootTools.this.mPDialog.setMessage(str);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.SanityCheckRootTools
 * JD-Core Version:    0.6.2
 */