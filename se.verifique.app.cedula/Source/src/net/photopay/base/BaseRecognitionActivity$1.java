package net.photopay.base;

import java.util.Timer;
import java.util.TimerTask;
import net.photopay.util.Log;
import net.photopay.view.viewfinder.AbstractViewFinder;

final class BaseRecognitionActivity$1 extends TimerTask
{
  public final void run()
  {
    if (!this.jdField_llIIlIlIIl_of_type_NetPhotopayViewViewfinderAbstractViewFinder.isAnimationInProgress())
    {
      this.jdField_llIIlIlIIl_of_type_JavaUtilTimer.cancel();
      BaseRecognitionActivity.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseRecognitionActivity);
    }
    while (true)
    {
      return;
      Log.v(this.jdField_llIIlIlIIl_of_type_NetPhotopayBaseBaseRecognitionActivity, "Waiting for animations to end...", new Object[0]);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseRecognitionActivity.1
 * JD-Core Version:    0.6.0
 */