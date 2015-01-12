package io.card.payment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import java.lang.reflect.Constructor;
import java.util.Date;

public final class CardIOActivity extends Activity
  implements c
{
  public static final String EXTRA_APP_TOKEN = "io.card.payment.appToken";
  public static final String EXTRA_GUIDE_COLOR = "io.card.payment.guideColor";
  public static final String EXTRA_LANGUAGE_OR_LOCALE = "io.card.payment.languageOrLocale";
  public static final String EXTRA_NO_CAMERA = "io.card.payment.noCamera";
  public static final String EXTRA_REQUIRE_CVV = "io.card.payment.requireCVV";
  public static final String EXTRA_REQUIRE_EXPIRY = "io.card.payment.requireExpiry";
  public static final String EXTRA_REQUIRE_POSTAL_CODE = "io.card.payment.requirePostalCode";
  public static final String EXTRA_REQUIRE_ZIP = "io.card.payment.requireZip";
  public static final String EXTRA_SCAN_RESULT = "io.card.payment.scanResult";
  public static final String EXTRA_SUPPRESS_CONFIRMATION = "io.card.payment.suppressConfirmation";
  public static final String EXTRA_SUPPRESS_MANUAL_ENTRY = "io.card.payment.suppressManual";
  public static final String EXTRA_USE_CARDIO_LOGO = "io.card.payment.useCardIOLogo";
  public static final int RESULT_CARD_INFO;
  public static final int RESULT_CONFIRMATION_SUPPRESSED;
  public static final int RESULT_ENTRY_CANCELED;
  public static final int RESULT_SCAN_NOT_AVAILABLE;
  public static final int RESULT_SCAN_SUPPRESSED;
  static Bitmap a;
  private static int b;
  private static final long[] c;
  private static final int d;
  private static String e;
  private static int q;
  private static boolean u;
  private ab f;
  private OrientationEventListener g;
  private ac h;
  private CreditCard i;
  private Rect j;
  private int k;
  private int l;
  private boolean m = false;
  private boolean n = false;
  private RelativeLayout o;
  private FrameLayout p;
  private CardScanner r;
  private P s;
  private boolean t = false;

  static
  {
    if (!CardIOActivity.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      v = bool;
      b = 13274384;
      b = 13274385;
      RESULT_CARD_INFO = 13274384;
      int i1 = b;
      b = i1 + 1;
      RESULT_ENTRY_CANCELED = i1;
      int i2 = b;
      b = i2 + 1;
      RESULT_SCAN_NOT_AVAILABLE = i2;
      int i3 = b;
      b = i3 + 1;
      RESULT_SCAN_SUPPRESSED = i3;
      int i4 = b;
      b = i4 + 1;
      RESULT_CONFIRMATION_SUPPRESSED = i4;
      c = new long[] { 0L, 70L, 10L, 40L };
      d = 10;
      q = 0;
      u = true;
      a = null;
      return;
    }
  }

  private void a(int paramInt)
  {
    if ((paramInt < 0) || (this.r == null))
      return;
    int i1 = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
    int i2;
    label42: int i3;
    if (i1 != 0)
      if (i1 == 1)
      {
        i2 = 90;
        i3 = i2 + paramInt;
        if (i3 <= 360)
          break label288;
      }
    label286: label288: for (int i4 = i3 - 360; ; i4 = i3)
    {
      int i5 = -1;
      if ((i4 < 15) || (i4 > 345))
      {
        this.l = 1;
        i5 = 0;
      }
      while (true)
      {
        if ((i5 < 0) || (i5 == this.k))
          break label286;
        new StringBuilder("onOrientationChanged(").append(i5).append(") calling setDeviceOrientation(").append(this.l).append(")").toString();
        this.r.a(this.l);
        b(i5);
        if ((i5 == 90) || (i5 == 270))
          break;
        i5;
        return;
        if (i1 == 2)
        {
          i2 = 180;
          break label42;
        }
        if (i1 == 3)
        {
          i2 = 270;
          break label42;
        }
        i2 = 0;
        break label42;
        if ((i4 > 75) && (i4 < 105))
        {
          this.l = 4;
          i5 = 90;
        }
        else if ((i4 > 165) && (i4 < 195))
        {
          i5 = 180;
          this.l = 2;
        }
        else if ((i4 > 255) && (i4 < 285))
        {
          this.l = 3;
          i5 = 270;
        }
      }
      break;
    }
  }

  private void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    a = null;
    finish();
  }

  private void a(Exception paramException)
  {
    ao localao = ao.w;
    String str = an.a(localao);
    Log.e("card.io", "Unkown exception - please send the stack trace to support@card.io", paramException);
    Toast localToast = Toast.makeText(this, str, 1);
    localToast.setGravity(17, 0, -75);
    localToast.show();
    this.t = true;
    this.s.a(localao, paramException, null);
  }

  private void a(boolean paramBoolean)
  {
    if ((this.h != null) && (this.f != null) && (this.r.b(paramBoolean)));
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        this.f.a(paramBoolean);
      return;
    }
  }

  private void b(int paramInt)
  {
    SurfaceView localSurfaceView = this.h.a();
    if (localSurfaceView == null)
    {
      Log.wtf("card.io", "surface view is null.. recovering... rotation might be weird.");
      return;
    }
    this.j = this.r.a(localSurfaceView.getWidth(), localSurfaceView.getHeight());
    Rect localRect1 = this.j;
    localRect1.top += localSurfaceView.getTop();
    Rect localRect2 = this.j;
    localRect2.bottom += localSurfaceView.getTop();
    this.f.a(this.j, paramInt);
    this.k = paramInt;
  }

  public static boolean canReadCardWithCamera()
  {
    try
    {
      boolean bool1 = u;
      boolean bool2 = false;
      if (bool1)
      {
        boolean bool3 = af.a();
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
      return bool2;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("CardIOActivity", "RuntimeException accessing Util.hardwareSupported()");
      return false;
    }
    catch (CameraUnavailableException localCameraUnavailableException)
    {
    }
    return false;
  }

  public static boolean canReadCardWithCamera(Context paramContext)
  {
    return canReadCardWithCamera();
  }

  private void e()
  {
    if (!u)
      return;
    Intent localIntent1 = getIntent();
    if ((localIntent1 != null) && (localIntent1.getBooleanExtra("io.card.payment.suppressConfirmation", false)))
    {
      Intent localIntent2 = new Intent(this, DataEntryActivity.class);
      localIntent2.putExtra("io.card.payment.scanResult", this.i);
      this.i = null;
      a(RESULT_CONFIRMATION_SUPPRESSED, localIntent2);
      return;
    }
    new Handler().post(new e(this));
  }

  public static Date sdkBuildDate()
  {
    return new Date("04/30/2014 22:39:27 -0500");
  }

  public static String sdkVersion()
  {
    return "sdk-3.1.5";
  }

  final void a()
  {
    SurfaceView localSurfaceView = this.h.a();
    if (this.f != null)
      this.f.a(new Rect(localSurfaceView.getLeft(), localSurfaceView.getTop(), localSurfaceView.getRight(), localSurfaceView.getBottom()));
    this.l = 1;
    b(0);
    if (1 != this.l)
      Log.wtf("card.io", "the orientation of the scanner doesn't match the orientation of the activity");
    a(new DetectionInfo());
  }

  final void a(Bitmap paramBitmap, DetectionInfo paramDetectionInfo)
  {
    try
    {
      ((Vibrator)getSystemService("vibrator")).vibrate(c, -1);
      this.r.c();
      this.o.setVisibility(4);
      if (paramDetectionInfo.a())
      {
        this.i = paramDetectionInfo.b();
        this.f.a(this.i);
        this.s.c(this.r.e());
      }
      if ((this.l == 1) || (this.l == 2))
      {
        f1 = 0.95F * (this.j.right / 428.0F);
        Matrix localMatrix = new Matrix();
        new StringBuilder("Scale factor: ").append(f1).toString();
        localMatrix.postScale(f1, f1);
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
        this.f.a(localBitmap);
        e();
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        Log.e("card.io", "Could not activate vibration feedback. Please add <uses-permission android:name=\"android.permission.VIBRATE\" /> to your application's manifest.");
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.w("card.io", "Exception while attempting to vibrate: ", localException);
        continue;
        float f1 = 1.15F * (this.j.right / 428.0F);
      }
    }
  }

  final void a(DetectionInfo paramDetectionInfo)
  {
    this.f.a(paramDetectionInfo);
  }

  public final void authorizeScanFailed(Throwable paramThrowable)
  {
    Log.w("CardIOActivity", "Scan authorization failed: " + paramThrowable.getMessage());
  }

  public final void authorizeScanSuccessful()
  {
  }

  public final void authorizeScanUnsuccessful()
  {
    if (!u)
      return;
    u = false;
    Log.e("card.io", "This app is not authorized to scan. Please register it at https://card.io. All card scans will be disabled.");
    new AlertDialog.Builder(this).setTitle(an.a(ao.t)).setMessage(an.a(ao.a)).setNegativeButton(an.a(ao.b), new i(this)).setCancelable(false).create().show();
  }

  final void b()
  {
    if (!this.r.f());
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  final void c()
  {
    this.r.a(true);
  }

  public final Rect getTorchRect()
  {
    if (this.f == null)
      return null;
    return this.f.d();
  }

  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    String.format("onActivityResult(requestCode:%d, resultCode:%d, ...", arrayOfObject);
    if ((paramInt2 == RESULT_CARD_INFO) || (paramInt2 == RESULT_ENTRY_CANCELED) || (this.t))
    {
      if ((paramIntent != null) && (paramIntent.hasExtra("io.card.payment.scanResult")))
        new StringBuilder("data entry result: ").append(paramIntent.getParcelableExtra("io.card.payment.scanResult")).toString();
      a(paramInt2, paramIntent);
    }
    while (this.o == null)
      return;
    this.o.setVisibility(0);
  }

  public final void onBackPressed()
  {
    if (!this.t)
      ab.c();
    if ((this.s != null) && (this.r != null))
    {
      this.s.a(this.r.e());
      super.onBackPressed();
    }
  }

  protected final void onCreate(Bundle paramBundle)
  {
    int i1 = 1 + q;
    q = i1;
    if (i1 != 1)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(q);
      String.format("INTERNAL WARNING: There are %d (not 1) CardIOActivity allocations!", arrayOfObject2);
    }
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    an.a(localIntent);
    String str1 = localIntent.getStringExtra("io.card.payment.appToken");
    e = str1;
    if ((str1 == null) || (e.length() == 0) || (e.contains(" ")))
      throw new IllegalArgumentException("A valid card.io app token must be supplied as a stringExtra with the key CardIOActivity.EXTRA_APP_TOKEN. Get one at https://card.io");
    this.n = false;
    this.s = new P(this, e, false);
    String str2 = e;
    a locala = X.a();
    locala.a(str2, null);
    locala.a(this, "https://api.card.io/0/sdk/auth.json", new ad(this));
    String str3 = af.a(getPackageManager().resolveActivity(localIntent, 65536), CardIOActivity.class);
    if (str3 != null)
      throw new RuntimeException(str3);
    this.m = localIntent.getBooleanExtra("io.card.payment.suppressManual", false);
    if (localIntent.getBooleanExtra("io.card.payment.noCamera", false))
      this.t = true;
    while (true)
    {
      if ((u) && (!this.t))
        try
        {
          requestWindowFeature(1);
          this.j = new Rect();
          this.l = 1;
          if (!localIntent.getBooleanExtra("io.card.payment.cameraBypassTestMode", false))
            break label1176;
          if (getPackageName().contentEquals("io.card.development"))
            break;
          Log.e("CardIOActivity", getPackageName() + " is not correct");
          throw new IllegalStateException("illegal access of private extra");
        }
        catch (Exception localException2)
        {
          a(localException2);
        }
      if (((this.t) || (!u)) && (this.m))
        a(RESULT_SCAN_NOT_AVAILABLE, null);
      return;
      try
      {
        if (!af.a())
        {
          ao localao2 = ao.u;
          String str5 = an.a(localao2);
          Log.w("card.io", localao2 + ": " + str5);
          this.t = true;
          this.s.a(localao2, null);
        }
      }
      catch (CameraUnavailableException localCameraUnavailableException)
      {
        ao localao1 = ao.v;
        String str4 = an.a(localao1);
        Log.e("card.io", localao1 + ": " + str4);
        Toast localToast = Toast.makeText(this, str4, 1);
        localToast.setGravity(17, 0, -75);
        localToast.show();
        this.t = true;
        this.s.a(localao1, localCameraUnavailableException, null);
      }
      catch (Exception localException1)
      {
        a(localException1);
      }
    }
    Class localClass = Class.forName("io.card.payment.CardScannerTester");
    Class[] arrayOfClass = new Class[2];
    arrayOfClass[0] = getClass();
    arrayOfClass[1] = Integer.TYPE;
    Constructor localConstructor = localClass.getConstructor(arrayOfClass);
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this;
    arrayOfObject1[1] = Integer.valueOf(this.l);
    this.r = ((CardScanner)localConstructor.newInstance(arrayOfObject1));
    label599: this.r.b();
    this.p = new FrameLayout(this);
    this.p.setBackgroundColor(-16777216);
    this.p.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setId(1);
    this.r.getClass();
    this.r.getClass();
    this.h = new ac(this);
    this.h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 48));
    localFrameLayout.addView(this.h);
    this.f = new ab(this, af.a(this));
    this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (getIntent() != null)
    {
      boolean bool = getIntent().getBooleanExtra("io.card.payment.useCardIOLogo", false);
      this.f.b(bool);
      int i3 = getIntent().getIntExtra("io.card.payment.guideColor", 0);
      if (i3 == 0)
        break label1195;
      int i4 = 0xFF000000 | i3;
      if (i3 != i4)
        Log.w("card.io", "Removing transparency from provided guide color.");
      this.f.a(i4);
    }
    while (true)
    {
      localFrameLayout.addView(this.f);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams1.addRule(10);
      localLayoutParams1.addRule(2, 2);
      this.p.addView(localFrameLayout, localLayoutParams1);
      this.o = new RelativeLayout(this);
      this.o.setGravity(80);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      this.o.setLayoutParams(localLayoutParams2);
      this.o.setId(2);
      this.o.setGravity(85);
      if (!this.m)
      {
        Button localButton = new Button(this);
        localButton.setId(3);
        localButton.setText(an.a(ao.q));
        localButton.setTextSize(12.0F);
        localButton.setOnClickListener(new g(this));
        this.o.addView(localButton);
        m.a(localButton, false, this);
        localButton.setTextSize(14.0F);
        localButton.setMinimumHeight(m.a("42dip", this));
        RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)localButton.getLayoutParams();
        localLayoutParams3.width = -2;
        localLayoutParams3.height = -2;
        localLayoutParams3.addRule(12);
        m.a(localButton, "16dip", null, "16dip", null);
        m.b(localButton, "4dip", "4dip", "4dip", "4dip");
      }
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams4.addRule(12);
      int i2 = (int)(0.5F + 15.0F * getResources().getDisplayMetrics().density);
      localLayoutParams4.setMargins(0, i2, 0, i2);
      this.p.addView(this.o, localLayoutParams4);
      setContentView(this.p);
      this.g = new d(this, this);
      break;
      label1176: this.r = new CardScanner(this, this.l);
      break label599;
      label1195: this.f.a(-16711936);
    }
  }

  protected final void onDestroy()
  {
    this.f = null;
    q = -1 + q;
    if (this.r != null)
    {
      this.r.d();
      this.r = null;
    }
    super.onDestroy();
  }

  protected final void onPause()
  {
    super.onPause();
    if (this.g != null)
      this.g.disable();
    a(false);
    if (this.r != null)
      this.r.c();
    while (this.t)
      return;
    Log.wtf("card.io", "cardScanner is null in onPause()");
  }

  protected final void onResume()
  {
    super.onResume();
    if (this.t)
    {
      this.s.b(null);
      e();
      return;
    }
    if (!u)
    {
      Log.e("card.io", "This app is not authorized to scan");
      a(0, null);
      return;
    }
    af.b();
    getWindow().addFlags(1024);
    getWindow().addFlags(128);
    setRequestedOrientation(1);
    this.g.enable();
    this.i = null;
    if ((!v) && (this.h == null))
      throw new AssertionError();
    boolean bool = this.r.a(this.h.b());
    if (bool)
      this.o.setVisibility(0);
    if (!bool)
    {
      Log.e("CardIOActivity", "Could not connect to camera.");
      ao localao = ao.w;
      String str = an.a(localao);
      Log.e("card.io", "error display: " + str);
      Toast.makeText(this, str, 1).show();
      e();
      this.s.a(localao, this.r.e());
    }
    while (true)
    {
      a(this.k);
      return;
      a(false);
      this.s.a();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.CardIOActivity
 * JD-Core Version:    0.6.2
 */