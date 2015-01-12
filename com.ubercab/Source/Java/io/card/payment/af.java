package io.card.payment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

final class af
{
  private static final boolean a = Build.MODEL.equals("DROID2");
  private static Boolean b;

  public static Rect a(Point paramPoint, int paramInt1, int paramInt2)
  {
    return new Rect(paramPoint.x - paramInt1 / 2, paramPoint.y - paramInt2 / 2, paramPoint.x + paramInt1 / 2, paramPoint.y + paramInt2 / 2);
  }

  public static String a(ResolveInfo paramResolveInfo, Class paramClass)
  {
    int i = 1;
    String str;
    if (paramResolveInfo == null)
    {
      Object[] arrayOfObject = new Object[i];
      arrayOfObject[0] = paramClass.getName();
      str = String.format("Didn't find %s in the AndroidManifest.xml", arrayOfObject);
      if (str != null)
        Log.e("card.io", str);
      return str;
    }
    if ((0x80 & paramResolveInfo.activityInfo.configChanges) == 128);
    while (true)
    {
      str = null;
      if (i != 0)
        break;
      str = paramClass.getName() + " requires attribute android:configChanges=\"orientation\"";
      break;
      i = 0;
    }
  }

  public static void a(Paint paramPaint)
  {
    paramPaint.setColor(-1);
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
    paramPaint.setAntiAlias(true);
    paramPaint.setShadowLayer(1.5F, 0.5F, 0.0F, Color.HSVToColor(200, new float[] { 0.0F, 0.0F, 0.0F }));
  }

  public static boolean a()
  {
    if (b == null)
      b = Boolean.valueOf(c());
    return b.booleanValue();
  }

  public static boolean a(Context paramContext)
  {
    return (!a) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash"));
  }

  public static void b()
  {
    new StringBuilder("Native memory stats: ").append("(free/alloc'd/total)" + Debug.getNativeHeapFreeSize() + "/" + Debug.getNativeHeapAllocatedSize() + "/" + Debug.getNativeHeapSize()).toString();
  }

  private static boolean c()
  {
    if (Build.VERSION.SDK_INT < 8)
    {
      Log.w("card.io", "- Android SDK too old. Minimum Android 2.2 / API level 8+ (Froyo) required");
      return false;
    }
    if (!CardScanner.a())
    {
      Log.w("card.io", "- Processor type is not supported");
      return false;
    }
    Camera localCamera;
    try
    {
      localCamera = Camera.open();
      if (localCamera == null)
      {
        Log.w("card.io", "- No camera found");
        return false;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("card.io", "- Error opening camera: " + localRuntimeException);
      throw new CameraUnavailableException();
    }
    List localList = localCamera.getParameters().getSupportedPreviewSizes();
    localCamera.release();
    Iterator localIterator = localList.iterator();
    Camera.Size localSize;
    do
    {
      if (!localIterator.hasNext())
        break;
      localSize = (Camera.Size)localIterator.next();
    }
    while ((localSize.width != 640) || (localSize.height != 480));
    for (int i = 1; ; i = 0)
    {
      if (i == 0)
      {
        Log.w("card.io", "- Camera resolution is insufficient");
        return false;
      }
      return true;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.af
 * JD-Core Version:    0.6.2
 */