package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintManager;
import java.io.FileNotFoundException;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  private final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;

  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramRectF.width() / paramInt1;
    float f2;
    if (paramInt3 == 2)
      f2 = Math.max(f1, paramRectF.height() / paramInt2);
    while (true)
    {
      localMatrix.postScale(f2, f2);
      localMatrix.postTranslate((paramRectF.width() - f2 * paramInt1) / 2.0F, (paramRectF.height() - f2 * paramInt2) / 2.0F);
      return localMatrix;
      f2 = Math.min(f1, paramRectF.height() / paramInt2);
    }
  }

  // ERROR //
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 45	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   8: ifnonnull +13 -> 21
    //   11: new 95	java/lang/IllegalArgumentException
    //   14: dup
    //   15: ldc 97
    //   17: invokespecial 100	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 45	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   27: invokevirtual 106	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: aload_1
    //   31: invokevirtual 112	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   34: astore_3
    //   35: aload_3
    //   36: aconst_null
    //   37: aload_2
    //   38: invokestatic 118	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   41: astore 7
    //   43: aload_3
    //   44: ifnull +7 -> 51
    //   47: aload_3
    //   48: invokevirtual 123	java/io/InputStream:close	()V
    //   51: aload 7
    //   53: areturn
    //   54: astore 8
    //   56: ldc 13
    //   58: ldc 125
    //   60: aload 8
    //   62: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   65: pop
    //   66: goto -15 -> 51
    //   69: astore 4
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 123	java/io/InputStream:close	()V
    //   79: aload 4
    //   81: athrow
    //   82: astore 5
    //   84: ldc 13
    //   86: ldc 125
    //   88: aload 5
    //   90: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   93: pop
    //   94: goto -15 -> 79
    //
    // Exception table:
    //   from	to	target	type
    //   47	51	54	java/io/IOException
    //   23	43	69	finally
    //   75	79	82	java/io/IOException
  }

  // ERROR //
  private Bitmap loadConstrainedBitmap(Uri paramUri, int paramInt)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iload_2
    //   3: ifle +14 -> 17
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: getfield 45	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   14: ifnonnull +13 -> 27
    //   17: new 95	java/lang/IllegalArgumentException
    //   20: dup
    //   21: ldc 133
    //   23: invokespecial 100	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: new 135	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 136	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 4
    //   36: aload 4
    //   38: iconst_1
    //   39: putfield 140	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload_0
    //   43: aload_1
    //   44: aload 4
    //   46: invokespecial 142	android/support/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload 4
    //   52: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   55: istore 6
    //   57: aload 4
    //   59: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   62: istore 7
    //   64: iload 6
    //   66: ifle +8 -> 74
    //   69: iload 7
    //   71: ifgt +5 -> 76
    //   74: aload_3
    //   75: areturn
    //   76: iload 6
    //   78: iload 7
    //   80: invokestatic 151	java/lang/Math:max	(II)I
    //   83: istore 8
    //   85: iconst_1
    //   86: istore 9
    //   88: iload 8
    //   90: iload_2
    //   91: if_icmple +18 -> 109
    //   94: iload 8
    //   96: iconst_1
    //   97: iushr
    //   98: istore 8
    //   100: iload 9
    //   102: iconst_1
    //   103: ishl
    //   104: istore 9
    //   106: goto -18 -> 88
    //   109: iload 9
    //   111: ifle -37 -> 74
    //   114: iload 6
    //   116: iload 7
    //   118: invokestatic 153	java/lang/Math:min	(II)I
    //   121: iload 9
    //   123: idiv
    //   124: ifle -50 -> 74
    //   127: aload_0
    //   128: getfield 37	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   131: astore 10
    //   133: aload 10
    //   135: monitorenter
    //   136: aload_0
    //   137: new 135	android/graphics/BitmapFactory$Options
    //   140: dup
    //   141: invokespecial 136	android/graphics/BitmapFactory$Options:<init>	()V
    //   144: putfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   147: aload_0
    //   148: getfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   151: iconst_1
    //   152: putfield 156	android/graphics/BitmapFactory$Options:inMutable	Z
    //   155: aload_0
    //   156: getfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   159: iload 9
    //   161: putfield 159	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   164: aload_0
    //   165: getfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   168: astore 12
    //   170: aload 10
    //   172: monitorexit
    //   173: aload_0
    //   174: aload_1
    //   175: aload 12
    //   177: invokespecial 142	android/support/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   180: astore 16
    //   182: aload 16
    //   184: astore_3
    //   185: aload_0
    //   186: getfield 37	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   189: astore 17
    //   191: aload 17
    //   193: monitorenter
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   199: aload 17
    //   201: monitorexit
    //   202: goto -128 -> 74
    //   205: astore 18
    //   207: aload 17
    //   209: monitorexit
    //   210: aload 18
    //   212: athrow
    //   213: astore 11
    //   215: aload 10
    //   217: monitorexit
    //   218: aload 11
    //   220: athrow
    //   221: astore 13
    //   223: aload_0
    //   224: getfield 37	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   227: astore 14
    //   229: aload 14
    //   231: monitorenter
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 35	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   237: aload 14
    //   239: monitorexit
    //   240: aload 13
    //   242: athrow
    //   243: astore 15
    //   245: aload 14
    //   247: monitorexit
    //   248: aload 15
    //   250: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   194	210	205	finally
    //   136	173	213	finally
    //   215	218	213	finally
    //   173	182	221	finally
    //   232	240	243	finally
    //   245	248	243	finally
  }

  public int getColorMode()
  {
    return this.mColorMode;
  }

  public int getOrientation()
  {
    return this.mOrientation;
  }

  public int getScaleMode()
  {
    return this.mScaleMode;
  }

  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null);
    while (true)
    {
      return;
      int i = this.mScaleMode;
      PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
      PrintAttributes.MediaSize localMediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      if (paramBitmap.getWidth() > paramBitmap.getHeight())
        localMediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      PrintAttributes localPrintAttributes = new PrintAttributes.Builder().setMediaSize(localMediaSize).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintHelperKitkat.1(this, paramString, paramBitmap, i), localPrintAttributes);
    }
  }

  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    PrintHelperKitkat.2 local2 = new PrintHelperKitkat.2(this, paramString, paramUri, this.mScaleMode);
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if (this.mOrientation == 1)
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    while (true)
    {
      localPrintManager.print(paramString, local2, localBuilder.build());
      return;
      if (this.mOrientation != 2)
        continue;
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
    }
  }

  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }

  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }

  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat
 * JD-Core Version:    0.6.0
 */