package net.photopay.recognition;

import net.photopay.ocr.OcrResult;

public abstract interface RecognizerDelegate
{
  public abstract boolean onDetectedForm(float[] paramArrayOfFloat, int paramInt1, int paramInt2);

  public abstract void onDetectionFailed();

  public abstract void onDetectionStarted();

  public abstract void onDisplayOcrResult(OcrResult paramOcrResult);

  public abstract void onRecognitionFinished(RecognitionData paramRecognitionData);

  public abstract void onRecognitionStarted();

  public abstract void publishProgress(int paramInt);

  public abstract void setPaused(boolean paramBoolean);

  public abstract boolean shouldRecognitionStop();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.RecognizerDelegate
 * JD-Core Version:    0.6.0
 */