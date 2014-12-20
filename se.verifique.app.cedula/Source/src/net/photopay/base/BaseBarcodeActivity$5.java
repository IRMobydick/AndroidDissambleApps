package net.photopay.base;

import android.os.Handler;
import net.photopay.recognition.NativeRecognizerWrapper.IlIllIlIIl;
import net.photopay.recognition.RecognitionData;
import net.photopay.util.Log;

final class BaseBarcodeActivity$5
  implements NativeRecognizerWrapper.IlIllIlIIl
{
  public final void IlIllIlIIl(RecognitionData paramRecognitionData)
  {
    Log.d(this, "recognition done with timeout", new Object[0]);
    this.llIIlIlIIl.mHandler.post(new BaseBarcodeActivity.5.2(this, paramRecognitionData));
  }

  public final void llIIlIlIIl(RecognitionData paramRecognitionData)
  {
    Log.d(this, "recognition done", new Object[0]);
    this.llIIlIlIIl.mHandler.post(new BaseBarcodeActivity.5.1(this, paramRecognitionData));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseBarcodeActivity.5
 * JD-Core Version:    0.6.0
 */