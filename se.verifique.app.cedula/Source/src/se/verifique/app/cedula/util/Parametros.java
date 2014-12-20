package se.verifique.app.cedula.util;

import android.app.Application;
import android.content.Context;
import java.util.List;
import java.util.Map;

public class Parametros extends Application
{
  private static Context b = new Parametros();
  public List a;
  private Map c;

  public static void a(Context paramContext)
  {
    b = paramContext;
  }

  public static Context b()
  {
    return b;
  }

  public Map a()
  {
    return this.c;
  }

  // ERROR //
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 28	java/io/File
    //   3: dup
    //   4: new 30	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 34	se/verifique/app/cedula/util/Parametros:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   12: getfield 40	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   15: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: ldc 50
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: new 61	java/io/FileOutputStream
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 64	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 68	java/lang/String:getBytes	()[B
    //   47: invokevirtual 72	java/io/FileOutputStream:write	([B)V
    //   50: aload_3
    //   51: ifnull +7 -> 58
    //   54: aload_3
    //   55: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_3
    //   63: aload 4
    //   65: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   68: aload_3
    //   69: ifnull -11 -> 58
    //   72: aload_3
    //   73: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   76: goto -18 -> 58
    //   79: astore 7
    //   81: goto -23 -> 58
    //   84: astore 5
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   96: aload 5
    //   98: athrow
    //   99: astore 6
    //   101: goto -5 -> 96
    //   104: astore 8
    //   106: goto -48 -> 58
    //   109: astore 5
    //   111: goto -23 -> 88
    //   114: astore 4
    //   116: goto -53 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   33	42	59	java/lang/Exception
    //   72	76	79	java/lang/Exception
    //   33	42	84	finally
    //   92	96	99	java/lang/Exception
    //   54	58	104	java/lang/Exception
    //   42	50	109	finally
    //   63	68	109	finally
    //   42	50	114	java/lang/Exception
  }

  public void a(Map paramMap)
  {
    this.c = paramMap;
  }

  // ERROR //
  public boolean b(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 28	java/io/File
    //   3: dup
    //   4: new 30	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 34	se/verifique/app/cedula/util/Parametros:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   12: getfield 40	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   15: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: ldc 82
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_2
    //   33: iconst_0
    //   34: istore_3
    //   35: new 61	java/io/FileOutputStream
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 64	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: astore 4
    //   45: aload 4
    //   47: aload_1
    //   48: invokevirtual 68	java/lang/String:getBytes	()[B
    //   51: invokevirtual 72	java/io/FileOutputStream:write	([B)V
    //   54: iconst_1
    //   55: istore_3
    //   56: aload 4
    //   58: ifnull +8 -> 66
    //   61: aload 4
    //   63: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   66: iload_3
    //   67: ireturn
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 4
    //   73: aload 5
    //   75: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   78: aload 4
    //   80: ifnull -14 -> 66
    //   83: aload 4
    //   85: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   88: goto -22 -> 66
    //   91: astore 8
    //   93: goto -27 -> 66
    //   96: astore 6
    //   98: aconst_null
    //   99: astore 4
    //   101: aload 4
    //   103: ifnull +8 -> 111
    //   106: aload 4
    //   108: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   111: aload 6
    //   113: athrow
    //   114: astore 7
    //   116: goto -5 -> 111
    //   119: astore 9
    //   121: goto -55 -> 66
    //   124: astore 6
    //   126: goto -25 -> 101
    //   129: astore 5
    //   131: goto -58 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   35	45	68	java/lang/Exception
    //   83	88	91	java/lang/Exception
    //   35	45	96	finally
    //   106	111	114	java/lang/Exception
    //   61	66	119	java/lang/Exception
    //   45	54	124	finally
    //   73	78	124	finally
    //   45	54	129	java/lang/Exception
  }

  // ERROR //
  public java.lang.String c()
  {
    // Byte code:
    //   0: new 28	java/io/File
    //   3: dup
    //   4: new 30	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 34	se/verifique/app/cedula/util/Parametros:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   12: getfield 40	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   15: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: ldc 50
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: new 84	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_1
    //   43: invokevirtual 89	java/io/File:length	()J
    //   46: l2i
    //   47: newarray byte
    //   49: astore 8
    //   51: aload_2
    //   52: aload 8
    //   54: invokevirtual 93	java/io/FileInputStream:read	([B)I
    //   57: pop
    //   58: new 42	java/lang/String
    //   61: dup
    //   62: aload 8
    //   64: invokespecial 95	java/lang/String:<init>	([B)V
    //   67: astore 6
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 96	java/io/FileInputStream:close	()V
    //   77: aload 6
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_3
    //   84: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   87: aload_2
    //   88: ifnull +57 -> 145
    //   91: aload_2
    //   92: invokevirtual 96	java/io/FileInputStream:close	()V
    //   95: ldc 98
    //   97: astore 6
    //   99: goto -22 -> 77
    //   102: astore 7
    //   104: ldc 98
    //   106: astore 6
    //   108: goto -31 -> 77
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 96	java/io/FileInputStream:close	()V
    //   123: aload 4
    //   125: athrow
    //   126: astore 5
    //   128: goto -5 -> 123
    //   131: astore 10
    //   133: goto -56 -> 77
    //   136: astore 4
    //   138: goto -23 -> 115
    //   141: astore_3
    //   142: goto -59 -> 83
    //   145: ldc 98
    //   147: astore 6
    //   149: goto -72 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   33	42	80	java/lang/Exception
    //   91	95	102	java/lang/Exception
    //   33	42	111	finally
    //   119	123	126	java/lang/Exception
    //   73	77	131	java/lang/Exception
    //   42	69	136	finally
    //   83	87	136	finally
    //   42	69	141	java/lang/Exception
  }

  // ERROR //
  public java.lang.String d()
  {
    // Byte code:
    //   0: new 28	java/io/File
    //   3: dup
    //   4: new 30	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 34	se/verifique/app/cedula/util/Parametros:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   12: getfield 40	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   15: invokestatic 46	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: ldc 82
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: new 84	java/io/FileInputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_1
    //   43: invokevirtual 89	java/io/File:length	()J
    //   46: l2i
    //   47: newarray byte
    //   49: astore 8
    //   51: aload_2
    //   52: aload 8
    //   54: invokevirtual 93	java/io/FileInputStream:read	([B)I
    //   57: pop
    //   58: new 42	java/lang/String
    //   61: dup
    //   62: aload 8
    //   64: invokespecial 95	java/lang/String:<init>	([B)V
    //   67: astore 6
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 96	java/io/FileInputStream:close	()V
    //   77: aload 6
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_3
    //   84: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   87: aload_2
    //   88: ifnull +57 -> 145
    //   91: aload_2
    //   92: invokevirtual 96	java/io/FileInputStream:close	()V
    //   95: ldc 98
    //   97: astore 6
    //   99: goto -22 -> 77
    //   102: astore 7
    //   104: ldc 98
    //   106: astore 6
    //   108: goto -31 -> 77
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 96	java/io/FileInputStream:close	()V
    //   123: aload 4
    //   125: athrow
    //   126: astore 5
    //   128: goto -5 -> 123
    //   131: astore 10
    //   133: goto -56 -> 77
    //   136: astore 4
    //   138: goto -23 -> 115
    //   141: astore_3
    //   142: goto -59 -> 83
    //   145: ldc 98
    //   147: astore 6
    //   149: goto -72 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   33	42	80	java/lang/Exception
    //   91	95	102	java/lang/Exception
    //   33	42	111	finally
    //   119	123	126	java/lang/Exception
    //   73	77	131	java/lang/Exception
    //   42	69	136	finally
    //   83	87	136	finally
    //   42	69	141	java/lang/Exception
  }

  public void onCreate()
  {
    super.onCreate();
    b = this;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.util.Parametros
 * JD-Core Version:    0.6.0
 */