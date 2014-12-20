package net.photopay.recognition;

import net.photopay.hardware.camera.CameraDataFormat;

final class NativeRecognizerWrapper$llIIlIlIIl$4
  implements Runnable
{
  public final void run()
  {
    RecognitionData localRecognitionData;
    if (NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII) == RecognizerState.llIIIlllll)
    {
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, RecognizerState.IllIIIIllI);
      localRecognitionData = NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, this.llIIlIlIIl.llIIlIlIIl(), this.llIIlIlIIl.getWidth(), this.llIIlIlIIl.getHeight(), this.llIIlIlIIl.llIIlIlIIl().llIIIlllll(), this.llIIlIlIIl.IlIlllllII(), this.llIIlIlIIl.llIIlIIIll(), NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII));
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, RecognizerState.lIlIIIIlIl);
      if (NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII) == null)
        break label185;
      if ((!NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII)) && (this.llIIlIlIIl.llIIlIlIIl() != CameraDataFormat.IllIIIllII))
        break label166;
      NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).IlIllIlIIl(localRecognitionData);
    }
    while (true)
    {
      return;
      label166: NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII).llIIlIlIIl(localRecognitionData);
      continue;
      label185: NativeRecognizerWrapper.llIIlIlIIl(this.IlIllIlIIl.IllIIIllII, RecognizerState.llIIIlllll);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.NativeRecognizerWrapper.llIIlIlIIl.4
 * JD-Core Version:    0.6.0
 */