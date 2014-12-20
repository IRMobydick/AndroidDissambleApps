package net.photopay.recognition;

import android.content.Context;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.photopay.settings.NativeLibraryInfo;
import net.photopay.settings.llIIlIlIIl;
import net.photopay.util.Log;

final class NativeRecognizerWrapper$llIIlIlIIl$2
  implements Runnable
{
  public final void run()
  {
    NativeRecognizerWrapper localNativeRecognizerWrapper1 = this.IlIllIlIIl.IllIIIllII;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).name();
    Log.d(localNativeRecognizerWrapper1, "Initializing photopay of state: {}", arrayOfObject1);
    if ((NativeRecognizerWrapper.llIllIIlll()) && (NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII) == RecognizerState.IlIllIlIIl) && (NativeRecognizerWrapper.llIIlIlIIl.llIIlIlIIl(this.IlIllIlIIl) == 0))
    {
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, RecognizerState.IllIIIllII);
      Map localMap = ResourceManager.llIIlIlIIl.llIIlIlIIl(this.llIIlIlIIl);
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, str, (ByteBuffer)localMap.get(str));
      }
      Log.d(this.IlIllIlIIl.IllIIIllII, "Calling native init...", new Object[0]);
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).getAsBundle()));
      if (NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).isLibrarySuccessfultInitialized())
        break label352;
      Log.e(this.IlIllIlIIl.IllIIIllII, "Failed to initialize native PhotoPay library!", new Object[0]);
      NativeRecognizerWrapper localNativeRecognizerWrapper3 = this.IlIllIlIIl.IllIIIllII;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).getErrorList();
      Log.e(localNativeRecognizerWrapper3, "Reason: {}", arrayOfObject3);
      this.IlIllIlIIl.lllllIlIll();
      NativeRecognizerWrapper.lllllIlIll();
    }
    while (true)
    {
      NativeRecognizerWrapper.llIIlIlIIl.IlIllIlIIl(this.IlIllIlIIl);
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, RecognizerState.llIIIlllll);
      NativeRecognizerWrapper localNativeRecognizerWrapper2 = this.IlIllIlIIl.IllIIIllII;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(NativeRecognizerWrapper.llIIlIlIIl.llIIlIlIIl(this.IlIllIlIIl));
      Log.d(localNativeRecognizerWrapper2, "(init) PhotoPay init count: {}", arrayOfObject2);
      return;
      label352: Log.d(this.IlIllIlIIl.IllIIIllII, "Native library has initialized.", new Object[0]);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.NativeRecognizerWrapper.llIIlIlIIl.2
 * JD-Core Version:    0.6.0
 */