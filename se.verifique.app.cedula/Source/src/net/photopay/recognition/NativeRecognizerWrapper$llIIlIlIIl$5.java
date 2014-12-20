package net.photopay.recognition;

import java.util.Timer;

final class NativeRecognizerWrapper$llIIlIlIIl$5
  implements Runnable
{
  public final void run()
  {
    NativeRecognizerWrapper.IlIllIlIIl(this.IlIllIlIIl.IllIIIllII);
    if (NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII) != null)
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).cancel();
    NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, false);
    NativeRecognizerWrapper.IlIllIlIIl(this.IlIllIlIIl.IllIIIllII);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.NativeRecognizerWrapper.llIIlIlIIl.5
 * JD-Core Version:    0.6.0
 */