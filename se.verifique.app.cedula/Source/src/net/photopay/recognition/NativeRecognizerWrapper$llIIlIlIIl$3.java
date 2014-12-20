package net.photopay.recognition;

import net.photopay.util.Log;

final class NativeRecognizerWrapper$llIIlIlIIl$3
  implements Runnable
{
  public final void run()
  {
    NativeRecognizerWrapper.llIIlIlIIl.IllIIIllII(this.IlIllIlIIl);
    Log.v(this.IlIllIlIIl.IllIIIllII, "Terminating PhotoPay library", new Object[0]);
    NativeRecognizerWrapper localNativeRecognizerWrapper = this.IlIllIlIIl.IllIIIllII;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(NativeRecognizerWrapper.llIIlIlIIl.llIIlIlIIl(this.IlIllIlIIl));
    Log.d(localNativeRecognizerWrapper, "(term) PhotoPay init count: {}", arrayOfObject);
    if (NativeRecognizerWrapper.llIIlIlIIl.llIIlIlIIl(this.IlIllIlIIl) <= 0)
    {
      if ((NativeRecognizerWrapper.llIllIIlll()) && ((NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII) == RecognizerState.llIIIlllll) || (NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII) == RecognizerState.lIlIIIIlIl)))
      {
        NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII);
        NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, RecognizerState.IlIllIlIIl);
      }
      Log.v(this.IlIllIlIIl.IllIIIllII, "Releasing patterns and licence buffers", new Object[0]);
      ResourceManager.llIIlIlIIl.lIllIIlIIl();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.NativeRecognizerWrapper.llIIlIlIIl.3
 * JD-Core Version:    0.6.0
 */