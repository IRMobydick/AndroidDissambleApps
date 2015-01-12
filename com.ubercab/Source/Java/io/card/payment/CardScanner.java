package io.card.payment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class CardScanner
  implements Camera.AutoFocusCallback, Camera.PreviewCallback, SurfaceHolder.Callback
{
  private static boolean b;
  private static boolean p;
  private Bitmap a;
  private WeakReference c;
  private boolean d = false;
  private int e = 1;
  private boolean f = true;
  private long g = 0L;
  private long h = 0L;
  private Camera i = null;
  private byte[] j;
  private boolean k = true;
  private boolean l = false;
  private int m;
  private int n;
  private int o;

  static
  {
    boolean bool;
    if (!CardScanner.class.desiredAssertionStatus())
      bool = true;
    while (true)
    {
      q = bool;
      b = false;
      try
      {
        System.loadLibrary("cardioDecider");
        new StringBuilder("Loaded card.io decider library.  nUseNeon():").append(nUseNeon()).append(",nUseTegra():").append(nUseTegra()).toString();
        if ((nUseNeon()) || (nUseTegra()))
        {
          System.loadLibrary("opencv_core");
          System.loadLibrary("opencv_imgproc");
        }
        if (nUseNeon())
          System.loadLibrary("cardioRecognizer");
        while (true)
        {
          p = false;
          return;
          bool = false;
          break;
          if (!nUseTegra())
            break label143;
          System.loadLibrary("cardioRecognizer_tegra2");
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        while (true)
        {
          Log.e("card.io", "Failed to load native library: " + localUnsatisfiedLinkError.getMessage());
          b = true;
          continue;
          label143: Log.w("card.io", "unsupported processor - card.io scanning requires ARMv7 architecture");
          b = true;
        }
      }
    }
  }

  CardScanner(CardIOActivity paramCardIOActivity, int paramInt)
  {
    Intent localIntent = paramCardIOActivity.getIntent();
    if (localIntent != null)
    {
      localIntent.getBooleanExtra("io.card.payment.suppressScan", false);
      this.d = false;
    }
    this.c = new WeakReference(paramCardIOActivity);
    this.e = paramInt;
    nSetup(false, 6.0F);
  }

  static boolean a()
  {
    return (!b) && ((nUseNeon()) || (nUseTegra()));
  }

  private Camera b(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    if (this.k)
      i1 = paramInt;
    try
    {
      Camera localCamera = Camera.open();
      return localCamera;
    }
    catch (RuntimeException localRuntimeException)
    {
      try
      {
        do
        {
          Log.w("card.io", "Wasn't able to connect to camera service. Waiting and trying again...");
          Thread.sleep(50L);
        }
        while (System.currentTimeMillis() - l1 < i1);
        Log.w("CardScanner", "camera connect timeout");
        return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          Log.e("card.io", "Interrupted while waiting for camera", localInterruptedException);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e("card.io", "Unexpected exception. Please report it to support@card.io", localException);
        i1 = 0;
      }
    }
  }

  // ERROR //
  private boolean b(SurfaceHolder paramSurfaceHolder)
  {
    // Byte code:
    //   0: getstatic 46	io/card/payment/CardScanner:q	Z
    //   3: ifne +15 -> 18
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: new 197	java/lang/AssertionError
    //   13: dup
    //   14: invokespecial 198	java/lang/AssertionError:<init>	()V
    //   17: athrow
    //   18: getstatic 46	io/card/payment/CardScanner:q	Z
    //   21: ifne +20 -> 41
    //   24: aload_1
    //   25: invokeinterface 204 1 0
    //   30: ifnonnull +11 -> 41
    //   33: new 197	java/lang/AssertionError
    //   36: dup
    //   37: invokespecial 198	java/lang/AssertionError:<init>	()V
    //   40: athrow
    //   41: new 58	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 206
    //   47: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokeinterface 210 1 0
    //   56: invokestatic 216	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: pop
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 118	io/card/payment/CardScanner:f	Z
    //   71: aload_0
    //   72: getfield 126	io/card/payment/CardScanner:k	Z
    //   75: ifeq +26 -> 101
    //   78: aload_0
    //   79: getfield 124	io/card/payment/CardScanner:i	Landroid/hardware/Camera;
    //   82: aload_1
    //   83: invokevirtual 220	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   86: aload_0
    //   87: getfield 124	io/card/payment/CardScanner:i	Landroid/hardware/Camera;
    //   90: invokevirtual 223	android/hardware/Camera:startPreview	()V
    //   93: aload_0
    //   94: getfield 124	io/card/payment/CardScanner:i	Landroid/hardware/Camera;
    //   97: aload_0
    //   98: invokevirtual 227	android/hardware/Camera:autoFocus	(Landroid/hardware/Camera$AutoFocusCallback;)V
    //   101: iconst_1
    //   102: ireturn
    //   103: astore_3
    //   104: ldc 94
    //   106: ldc 229
    //   108: aload_3
    //   109: invokestatic 190	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   112: pop
    //   113: iconst_0
    //   114: ireturn
    //   115: astore 5
    //   117: ldc 94
    //   119: ldc 231
    //   121: aload 5
    //   123: invokestatic 190	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   126: pop
    //   127: iconst_0
    //   128: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   78	86	103	java/io/IOException
    //   86	101	115	java/lang/RuntimeException
  }

  private native void nCleanup();

  private native long nGetElapsedClock();

  private native double nGetElapsedTime();

  private native void nGetFrameCounts(int[] paramArrayOfInt);

  private native void nGetGuideFrame(int paramInt1, int paramInt2, int paramInt3, Rect paramRect);

  private native void nResetAnalytics();

  private native void nScanFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, DetectionInfo paramDetectionInfo, Bitmap paramBitmap);

  private native void nSetup(boolean paramBoolean, float paramFloat);

  private native void nSkipFrame();

  public static native boolean nUseNeon();

  public static native boolean nUseTegra();

  final Rect a(int paramInt1, int paramInt2)
  {
    int i1 = this.e;
    boolean bool = a();
    Rect localRect = null;
    if (bool)
    {
      localRect = new Rect();
      nGetGuideFrame(i1, paramInt1, paramInt2, localRect);
    }
    return localRect;
  }

  final void a(int paramInt)
  {
    this.e = paramInt;
  }

  final void a(boolean paramBoolean)
  {
    if (this.k)
      if (this.h >= this.g)
        break label91;
    label91: for (int i1 = 1; ; i1 = 0)
    {
      if (i1 == 0)
        try
        {
          this.g = System.currentTimeMillis();
          this.i.autoFocus(this);
          if (paramBoolean)
          {
            this.m = (1 + this.m);
            return;
          }
          this.n = (1 + this.n);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          Log.w("CardScanner", "could not trigger auto focus: " + localRuntimeException);
        }
      return;
    }
  }

  final boolean a(SurfaceHolder paramSurfaceHolder)
  {
    new StringBuilder("resumeScanning(").append(paramSurfaceHolder).append(")").toString();
    if (this.i == null)
      b();
    if ((this.k) && (this.i == null))
      return false;
    if ((!q) && (paramSurfaceHolder == null))
      throw new AssertionError();
    if ((this.k) && (this.j == null))
    {
      new StringBuilder("- mCamera:").append(this.i).toString();
      int i1 = this.i.getParameters().getPreviewFormat();
      new StringBuilder("- preview format: ").append(i1).toString();
      int i2 = ImageFormat.getBitsPerPixel(i1) / 8;
      new StringBuilder("- bytes per pixel: ").append(i2).toString();
      int i3 = 3 * (i2 * 307200);
      new StringBuilder("- buffer size: ").append(i3).toString();
      this.j = new byte[i3];
      this.i.addCallbackBuffer(this.j);
    }
    paramSurfaceHolder.addCallback(this);
    paramSurfaceHolder.setType(3);
    if (this.k)
      this.i.setPreviewCallbackWithBuffer(this);
    if (this.l)
      b(paramSurfaceHolder);
    b(false);
    System.currentTimeMillis();
    nResetAnalytics();
    return true;
  }

  final void b()
  {
    this.f = true;
    this.g = 0L;
    this.h = 0L;
    this.m = 0;
    this.n = 0;
    this.o = 0;
    Camera.Parameters localParameters;
    List localList;
    Camera.Size localSize1;
    if ((this.k) && (this.i == null))
    {
      this.i = b(5000);
      if (this.i == null)
      {
        Log.e("card.io", "prepare scanner couldn't connect to camera!");
        return;
      }
      this.i.setDisplayOrientation(90);
      localParameters = this.i.getParameters();
      localList = localParameters.getSupportedPreviewSizes();
      if (localList != null)
      {
        U.a(localList);
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext())
            break;
          localSize1 = (Camera.Size)localIterator.next();
        }
        while ((localSize1.width != 640) || (localSize1.height != 480));
      }
    }
    while (true)
    {
      if (localSize1 == null)
      {
        Log.w("card.io", "Didn't find a supported 640x480 resolution, so forcing");
        Camera.Size localSize2 = (Camera.Size)localList.get(0);
        localSize2.width = 640;
        localSize2.height = 480;
      }
      new StringBuilder("- parameters: ").append(localParameters).toString();
      localParameters.setPreviewSize(640, 480);
      this.i.setParameters(localParameters);
      while (this.a == null)
      {
        this.a = Bitmap.createBitmap(428, 270, Bitmap.Config.ARGB_8888);
        return;
        if (!this.k)
          Log.w("CardScanner", "useCamera is false!");
        else if (this.i != null)
          new StringBuilder("we already have a camera instance: ").append(this.i).toString();
      }
      break;
      localSize1 = null;
    }
  }

  public final boolean b(boolean paramBoolean)
  {
    if (this.i != null)
    {
      new StringBuilder("setFlashOn: ").append(paramBoolean).toString();
      try
      {
        Camera.Parameters localParameters = this.i.getParameters();
        if (paramBoolean);
        for (String str = "torch"; ; str = "off")
        {
          localParameters.setFlashMode(str);
          this.i.setParameters(localParameters);
          this.o = (1 + this.o);
          return true;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.w("CardScanner", "Could not set flash mode: " + localRuntimeException);
      }
    }
    return false;
  }

  public final void c()
  {
    b(false);
    if (this.i != null);
    try
    {
      this.i.stopPreview();
      this.i.setPreviewDisplay(null);
      this.i.setPreviewCallback(null);
      this.i.release();
      this.j = null;
      this.i = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.w("card.io", "can't stop preview display", localIOException);
    }
  }

  public final void d()
  {
    if (this.i != null)
      c();
    nCleanup();
    this.j = null;
  }

  final Map e()
  {
    HashMap localHashMap = new HashMap(11);
    int[] arrayOfInt = new int[6];
    nGetFrameCounts(arrayOfInt);
    localHashMap.put("num_frames_total", Integer.valueOf(arrayOfInt[0]));
    localHashMap.put("num_frames_captured", Integer.valueOf(arrayOfInt[1]));
    localHashMap.put("num_frames_processed", Integer.valueOf(arrayOfInt[2]));
    localHashMap.put("num_frames_in_focus", Integer.valueOf(arrayOfInt[3]));
    localHashMap.put("num_frames_scanned", Integer.valueOf(arrayOfInt[4]));
    localHashMap.put("num_frames_usable", Integer.valueOf(arrayOfInt[5]));
    localHashMap.put("elapsed_time", Double.valueOf(nGetElapsedTime()));
    localHashMap.put("elapsed_clock", Long.valueOf(nGetElapsedClock()));
    localHashMap.put("num_manual_refocusings", Integer.valueOf(this.m));
    localHashMap.put("num_auto_triggered_refocusings", Integer.valueOf(this.n));
    localHashMap.put("num_manual_torch_changes", Integer.valueOf(this.o));
    return localHashMap;
  }

  public final boolean f()
  {
    if (!this.k)
      return false;
    return this.i.getParameters().getFlashMode().equals("torch");
  }

  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.h = System.currentTimeMillis();
  }

  void onEdgeUpdate(DetectionInfo paramDetectionInfo)
  {
    ((CardIOActivity)this.c.get()).a(paramDetectionInfo);
  }

  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
      Log.w("CardScanner", "frame is null! skipping");
    do
    {
      return;
      if (!p)
        break;
      Log.e("CardScanner", "processing in progress.... dropping frame");
      nSkipFrame();
    }
    while (paramCamera == null);
    paramCamera.addCallbackBuffer(paramArrayOfByte);
    return;
    p = true;
    if (this.f)
    {
      this.f = false;
      this.e = 1;
      ((CardIOActivity)this.c.get()).a();
    }
    DetectionInfo localDetectionInfo = new DetectionInfo();
    nScanFrame(paramArrayOfByte, 640, 480, this.e, localDetectionInfo, this.a);
    int i1;
    if (localDetectionInfo.focusScore >= 6.0F)
    {
      i1 = 1;
      if (i1 != 0)
        break label148;
      a(false);
    }
    while (true)
    {
      if (paramCamera != null)
        paramCamera.addCallbackBuffer(paramArrayOfByte);
      p = false;
      return;
      i1 = 0;
      break;
      label148: if (localDetectionInfo.a())
      {
        new StringBuilder("detected card: ").append(localDetectionInfo.b()).toString();
        ((CardIOActivity)this.c.get()).a(this.a, localDetectionInfo);
      }
    }
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Object[] arrayOfObject = new Object[4];
    if (paramSurfaceHolder != null);
    for (boolean bool = true; ; bool = false)
    {
      arrayOfObject[0] = Boolean.valueOf(bool);
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = Integer.valueOf(paramInt2);
      arrayOfObject[3] = Integer.valueOf(paramInt3);
      String.format("Preview.surfaceChanged(holder?:%b, f:%d, w:%d, h:%d )", arrayOfObject);
      return;
    }
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if ((this.i != null) || (!this.k))
    {
      this.l = true;
      b(paramSurfaceHolder);
      return;
    }
    Log.wtf("card.io", "CardScanner.surfaceCreated() - camera is null!");
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.i != null);
    try
    {
      this.i.stopPreview();
      this.l = false;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("card.io", "error stopping camera", localException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.CardScanner
 * JD-Core Version:    0.6.2
 */