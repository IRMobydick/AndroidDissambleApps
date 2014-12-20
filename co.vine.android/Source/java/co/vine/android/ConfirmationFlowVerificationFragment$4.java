package co.vine.android;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ConfirmationFlowVerificationFragment$4
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ConfirmationFlowVerificationFragment.access$400(this.this$0) != null)
      ConfirmationFlowVerificationFragment.access$400(this.this$0).setVisibility(0);
    if (ConfirmationFlowVerificationFragment.access$500(this.this$0) != null)
      ConfirmationFlowVerificationFragment.access$500(this.this$0).setVisibility(4);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConfirmationFlowVerificationFragment.4
 * JD-Core Version:    0.6.0
 */