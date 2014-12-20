package net.photopay.hardware.camera.focus;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import java.util.List;
import net.photopay.util.Log;

final class llIIlIlIIl$2
  implements Camera.AutoFocusCallback
{
  private void setFocusMode(String paramString)
  {
    if (this.llIIlIlIIl.llIIlIlIIl == null);
    while (true)
    {
      return;
      Camera.Parameters localParameters = this.llIIlIlIIl.llIIlIlIIl.getParameters();
      List localList = localParameters.getSupportedFocusModes();
      String str = localParameters.getFocusMode();
      if ((paramString == null) || (!localList.contains(paramString)) || (paramString.equals(str)))
        continue;
      localParameters.setFocusMode(paramString);
      llIIlIlIIl localllIIlIlIIl = this.llIIlIlIIl;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramString;
      Log.d(localllIIlIlIIl, "Setting focus mode to {}", arrayOfObject);
      try
      {
        this.llIIlIlIIl.llIIlIlIIl.setParameters(localParameters);
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e(this.llIIlIlIIl, localRuntimeException, "Setting new camera parameters failed!", new Object[0]);
      }
    }
  }

  // ERROR //
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 21
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   9: iconst_0
    //   10: putfield 79	net/photopay/hardware/camera/focus/llIIlIlIIl:IIIIIIIIII	Z
    //   13: aload_0
    //   14: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   17: invokestatic 82	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)I
    //   20: pop
    //   21: aload_0
    //   22: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   25: astore 6
    //   27: iconst_2
    //   28: anewarray 4	java/lang/Object
    //   31: astore 7
    //   33: aload 7
    //   35: iconst_0
    //   36: iload_1
    //   37: invokestatic 88	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: aastore
    //   41: aload 7
    //   43: iconst_1
    //   44: aload_0
    //   45: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   48: invokestatic 91	net/photopay/hardware/camera/focus/llIIlIlIIl:IlIllIlIIl	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)I
    //   51: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: aload 6
    //   57: ldc 98
    //   59: aload 7
    //   61: invokestatic 101	net/photopay/util/Log:i	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   68: iload_1
    //   69: putfield 104	net/photopay/hardware/camera/focus/llIIlIlIIl:mFocused	Z
    //   72: iload_1
    //   73: ifeq +40 -> 113
    //   76: aload_0
    //   77: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   80: invokestatic 106	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)V
    //   83: aload_0
    //   84: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   87: invokestatic 109	net/photopay/hardware/camera/focus/llIIlIlIIl:IllIIIllII	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)I
    //   90: pop
    //   91: ldc 21
    //   93: monitorexit
    //   94: iload_3
    //   95: ifeq +17 -> 112
    //   98: ldc2_w 110
    //   101: invokestatic 117	java/lang/Thread:sleep	(J)V
    //   104: aload_0
    //   105: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   108: iconst_1
    //   109: invokevirtual 120	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	(Z)V
    //   112: return
    //   113: aload_0
    //   114: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   117: invokestatic 123	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)Z
    //   120: ifne -29 -> 91
    //   123: aload_0
    //   124: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   127: invokestatic 126	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIIlllll	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)I
    //   130: pop
    //   131: aload_0
    //   132: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   135: getfield 24	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	Landroid/hardware/Camera;
    //   138: ifnull +34 -> 172
    //   141: aload_0
    //   142: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   145: getfield 24	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	Landroid/hardware/Camera;
    //   148: invokevirtual 30	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   151: invokevirtual 40	android/hardware/Camera$Parameters:getFocusMode	()Ljava/lang/String;
    //   154: astore 10
    //   156: ldc 128
    //   158: aload 10
    //   160: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifeq +45 -> 208
    //   166: aload_0
    //   167: ldc 130
    //   169: invokespecial 131	net/photopay/hardware/camera/focus/llIIlIlIIl$2:setFocusMode	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   176: invokestatic 134	net/photopay/hardware/camera/focus/llIIlIlIIl:IllIIIIllI	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)I
    //   179: iconst_3
    //   180: if_icmpne +60 -> 240
    //   183: aload_0
    //   184: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   187: invokestatic 137	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)Lnet/photopay/hardware/camera/focus/AutofocusStatusView;
    //   190: ifnull +50 -> 240
    //   193: aload_0
    //   194: getfield 12	net/photopay/hardware/camera/focus/llIIlIlIIl$2:llIIlIlIIl	Lnet/photopay/hardware/camera/focus/llIIlIlIIl;
    //   197: invokestatic 137	net/photopay/hardware/camera/focus/llIIlIlIIl:llIIlIlIIl	(Lnet/photopay/hardware/camera/focus/llIIlIlIIl;)Lnet/photopay/hardware/camera/focus/AutofocusStatusView;
    //   200: invokeinterface 142 1 0
    //   205: goto +35 -> 240
    //   208: ldc 130
    //   210: aload 10
    //   212: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq -43 -> 172
    //   218: aload_0
    //   219: ldc 128
    //   221: invokespecial 131	net/photopay/hardware/camera/focus/llIIlIlIIl$2:setFocusMode	(Ljava/lang/String;)V
    //   224: goto -52 -> 172
    //   227: astore 4
    //   229: ldc 21
    //   231: monitorexit
    //   232: aload 4
    //   234: athrow
    //   235: astore 9
    //   237: goto -133 -> 104
    //   240: iconst_1
    //   241: istore_3
    //   242: goto -151 -> 91
    //
    // Exception table:
    //   from	to	target	type
    //   5	94	227	finally
    //   113	224	227	finally
    //   98	104	235	java/lang/InterruptedException
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.focus.llIIlIlIIl.2
 * JD-Core Version:    0.6.0
 */