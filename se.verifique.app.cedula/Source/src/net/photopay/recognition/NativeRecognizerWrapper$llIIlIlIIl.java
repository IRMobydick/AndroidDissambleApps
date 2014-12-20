package net.photopay.recognition;

import android.content.Context;
import android.os.Handler;
import net.photopay.geometry.Rectangle;
import net.photopay.hardware.orientation.Orientation;

final class NativeRecognizerWrapper$llIIlIlIIl extends Thread
{
  private int IIlIlllIIl = 0;
  private Handler mHandler;

  private NativeRecognizerWrapper$llIIlIlIIl(NativeRecognizerWrapper paramNativeRecognizerWrapper)
  {
  }

  public final void IlIllIlIIl(Context paramContext)
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.2(this, paramContext));
  }

  public final void IlIllIlIIl(Rectangle paramRectangle)
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.7(this, paramRectangle));
  }

  public final void IlIllIlIIl(llIIlIlIIl paramllIIlIlIIl)
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.4(this, paramllIIlIlIIl));
  }

  public final void lIlllIlIlI()
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.5(this));
  }

  public final boolean lIlllIlIlI()
  {
    monitorenter;
    try
    {
      Handler localHandler = this.mHandler;
      if (localHandler != null)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public final void llIIlIlIIl(Orientation paramOrientation)
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.6(this, paramOrientation));
  }

  public final void lllllIlIll()
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.3(this));
  }

  public final void prepareForNextRecognition()
  {
    this.mHandler.post(new NativeRecognizerWrapper.llIIlIlIIl.1(this));
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 80	android/os/Looper:prepare	()V
    //   3: aload_0
    //   4: getfield 14	net/photopay/recognition/NativeRecognizerWrapper$llIIlIlIIl:IllIIIllII	Lnet/photopay/recognition/NativeRecognizerWrapper;
    //   7: ldc 82
    //   9: iconst_0
    //   10: anewarray 84	java/lang/Object
    //   13: invokestatic 90	net/photopay/util/Log:v	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: new 35	android/os/Handler
    //   22: dup
    //   23: invokespecial 91	android/os/Handler:<init>	()V
    //   26: putfield 28	net/photopay/recognition/NativeRecognizerWrapper$llIIlIlIIl:mHandler	Landroid/os/Handler;
    //   29: aload_0
    //   30: invokevirtual 94	java/lang/Object:notify	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: invokestatic 97	android/os/Looper:loop	()V
    //   38: aload_0
    //   39: getfield 14	net/photopay/recognition/NativeRecognizerWrapper$llIIlIlIIl:IllIIIllII	Lnet/photopay/recognition/NativeRecognizerWrapper;
    //   42: ldc 99
    //   44: iconst_0
    //   45: anewarray 84	java/lang/Object
    //   48: invokestatic 90	net/photopay/util/Log:v	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: goto +23 -> 74
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 14	net/photopay/recognition/NativeRecognizerWrapper$llIIlIlIIl:IllIIIllII	Lnet/photopay/recognition/NativeRecognizerWrapper;
    //   64: aload_1
    //   65: ldc 101
    //   67: iconst_0
    //   68: anewarray 84	java/lang/Object
    //   71: invokestatic 105	net/photopay/util/Log:e	(Ljava/lang/Object;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: return
    //
    // Exception table:
    //   from	to	target	type
    //   18	35	54	finally
    //   0	18	59	java/lang/Throwable
    //   35	59	59	java/lang/Throwable
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.NativeRecognizerWrapper.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */