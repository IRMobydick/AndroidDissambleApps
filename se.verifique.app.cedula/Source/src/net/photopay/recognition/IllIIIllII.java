package net.photopay.recognition;

import java.util.Timer;
import net.photopay.geometry.Point;
import net.photopay.ocr.OcrResult;
import net.photopay.settings.llIIlIlIIl;
import net.photopay.view.viewfinder.AbstractViewFinder;

public final class IllIIIllII
  implements RecognizerDelegate
{
  private final int IIIllIlIIl;
  private String IIlIIIllIl = null;
  private boolean IIlIIlIllI = false;
  private Timer jdField_IlIllIlIIl_of_type_JavaUtilTimer = null;
  private AbstractViewFinder jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder = null;
  private boolean IllIllIllI = false;
  private volatile boolean lIlIIIlIll = false;
  private IllIIIllII.llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl = null;
  private llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl = null;
  boolean llIIllIlII = false;
  private boolean llllIllllI = false;

  public IllIIIllII(AbstractViewFinder paramAbstractViewFinder, boolean paramBoolean, llIIlIlIIl paramllIIlIlIIl)
  {
    this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder = paramAbstractViewFinder;
    this.IllIllIllI = paramBoolean;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl = paramllIIlIlIIl;
    this.IIIllIlIIl = this.jdField_llIIlIlIIl_of_type_NetPhotopaySettingsLlIIlIlIIl.IIlIIIllIl();
    if (this.IIIllIlIIl != 0)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl = new IllIIIllII.llIIlIlIIl(this, 0);
  }

  public final boolean onDetectedForm(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    long l = net.photopay.util.IllIIIllII.llIIlIlIIl();
    StringBuilder localStringBuilder;
    boolean bool1;
    label170: int i;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl != null)
    {
      localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("Last detection time: ");
      localStringBuilder.append(l);
      localStringBuilder.append(" ms\n");
      if (paramInt1 != 2)
      {
        IllIIIllII.llIIlIlIIl localllIIlIlIIl = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl;
        localllIIlIlIIl.llIlIlIlIl = (1 + localllIIlIlIIl.llIlIlIlIl);
      }
      localStringBuilder.append("Detections: successful ");
      localStringBuilder.append(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl.llIlIlIlIl);
      localStringBuilder.append(" of ");
      localStringBuilder.append(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl.lIIIlIIllI);
      localStringBuilder.append(" attempts.\n");
      if ((this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null) && (this.IIIllIlIIl == 2))
        this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.displayDebugStatus(localStringBuilder.toString());
    }
    else
    {
      if ((this.IIIllIlIIl == 2) || ((paramInt1 != 1) && (paramInt1 != 16)))
        break label199;
      bool1 = true;
      this.llIIllIlII = bool1;
      if (paramInt1 != 2)
        break label205;
      i = 0;
    }
    while (true)
    {
      return i;
      this.IIlIIIllIl = localStringBuilder.toString();
      break;
      label199: bool1 = false;
      break label170;
      label205: boolean bool2;
      label291: AbstractViewFinder localAbstractViewFinder2;
      if ((this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null) && (((this.IIIllIlIIl != 2) && ((paramInt1 == 1) || (paramInt1 == 8) || (paramInt1 == 32) || (paramInt1 == 4) || (paramInt1 == 64))) || (this.IIIllIlIIl == 2)))
      {
        if ((paramInt1 != 8) && (paramInt1 != 32))
          break label348;
        AbstractViewFinder localAbstractViewFinder1 = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
        if ((!this.IllIllIllI) || (!this.llIIllIlII))
          break label336;
        bool2 = true;
        localAbstractViewFinder1.setDefaultTarget(paramInt1, bool2);
        localAbstractViewFinder2 = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
        if (paramInt1 != 32)
          break label342;
      }
      label336: label342: for (boolean bool3 = true; ; bool3 = false)
      {
        localAbstractViewFinder2.setPointSet(paramArrayOfFloat, bool3);
        if (this.IIIllIlIIl != 2)
          break label559;
        i = 0;
        break;
        bool2 = false;
        break label291;
      }
      label348: if (paramArrayOfFloat != null)
      {
        if (paramArrayOfFloat.length == 8)
        {
          Point localPoint1 = new Point(paramArrayOfFloat[0], paramArrayOfFloat[1]);
          Point localPoint2 = new Point(paramArrayOfFloat[2], paramArrayOfFloat[3]);
          Point localPoint3 = new Point(paramArrayOfFloat[4], paramArrayOfFloat[5]);
          Point localPoint4 = new Point(paramArrayOfFloat[6], paramArrayOfFloat[7]);
          AbstractViewFinder localAbstractViewFinder4 = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
          if ((this.IllIllIllI) && (this.llIIllIlII));
          for (boolean bool5 = true; ; bool5 = false)
          {
            localAbstractViewFinder4.setNewTarget(localPoint1, localPoint2, localPoint3, localPoint4, paramInt2, paramInt1, bool5);
            break;
          }
        }
        AbstractViewFinder localAbstractViewFinder5 = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
        if ((this.IllIllIllI) && (this.llIIllIlII));
        for (boolean bool6 = true; ; bool6 = false)
        {
          localAbstractViewFinder5.setDefaultTarget(paramInt1, bool6);
          this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.setPointSet(paramArrayOfFloat, false);
          break;
        }
      }
      AbstractViewFinder localAbstractViewFinder3 = this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder;
      if ((this.IllIllIllI) && (this.llIIllIlII));
      for (boolean bool4 = true; ; bool4 = false)
      {
        localAbstractViewFinder3.setDefaultTarget(paramInt1, bool4);
        break;
      }
      label559: if ((paramInt1 == 1) || (paramInt1 == 8) || (paramInt1 == 32))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public final void onDetectionFailed()
  {
    if (this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null)
      this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.setDefaultTarget(2, false);
  }

  public final void onDetectionStarted()
  {
    net.photopay.util.IllIIIllII.start();
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl != null)
    {
      IllIIIllII.llIIlIlIIl localllIIlIlIIl = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl;
      localllIIlIlIIl.lIIIlIIllI = (1 + localllIIlIlIIl.lIIIlIIllI);
    }
  }

  public final void onDisplayOcrResult(OcrResult paramOcrResult)
  {
    if ((this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null) && (paramOcrResult != null))
      this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.displayOcrResult(paramOcrResult);
  }

  public final void onRecognitionFinished(RecognitionData paramRecognitionData)
  {
    this.lIlIIIlIll = false;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl != null)
    {
      if ((paramRecognitionData != null) && (paramRecognitionData.isValid()))
      {
        IllIIIllII.llIIlIlIIl localllIIlIlIIl = this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl;
        localllIIlIlIIl.lIlIIlIIll = (1 + localllIIlIlIIl.lIlIIlIIll);
      }
      if (this.IIIllIlIIl == 1)
      {
        StringBuilder localStringBuilder = new StringBuilder(500);
        if (this.IIlIIIllIl != null)
        {
          localStringBuilder.append(this.IIlIIIllIl);
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("Last recognition time: ");
        localStringBuilder.append(net.photopay.util.IllIIIllII.llIIlIlIIl());
        localStringBuilder.append(" ms\n");
        localStringBuilder.append("Recognitions: successful ");
        localStringBuilder.append(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl.lIlIIlIIll);
        localStringBuilder.append(" of ");
        localStringBuilder.append(this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl.llIlIlIlIl);
        localStringBuilder.append(" attempts.");
        if (this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null)
          this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.displayDebugStatus(localStringBuilder.toString());
      }
    }
  }

  public final void onRecognitionStarted()
  {
    this.lIlIIIlIll = true;
    if ((this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null) && (this.IllIllIllI) && (this.llIIllIlII))
      this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.startProgressAnimation();
    if (this.IllIllIllI)
    {
      if (this.jdField_IlIllIlIIl_of_type_JavaUtilTimer != null)
        this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.cancel();
      this.IIlIIlIllI = false;
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = new Timer(true);
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.schedule(new IllIIIllII.2(this), 500L);
    }
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionIllIIIllII$llIIlIlIIl != null)
      net.photopay.util.IllIIIllII.start();
  }

  public final void publishProgress(int paramInt)
  {
    if ((this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder != null) && (this.IllIllIllI) && (this.IIlIIlIllI))
    {
      this.jdField_IlIllIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.showRawProgress(paramInt);
      this.IIlIIlIllI = false;
      if (this.jdField_IlIllIlIIl_of_type_JavaUtilTimer != null)
        this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.cancel();
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer = new Timer(true);
      this.jdField_IlIllIlIIl_of_type_JavaUtilTimer.schedule(new IllIIIllII.1(this), 500L);
    }
  }

  public final void setPaused(boolean paramBoolean)
  {
    this.llllIllllI = paramBoolean;
  }

  public final boolean shouldRecognitionStop()
  {
    return this.llllIllllI;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.IllIIIllII
 * JD-Core Version:    0.6.0
 */