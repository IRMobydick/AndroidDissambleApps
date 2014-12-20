package co.vine.android;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class ConversationFragment$HeightAnimation extends Animation
{
  private View mView;

  public ConversationFragment$HeightAnimation(ConversationFragment paramConversationFragment, View paramView, Runnable paramRunnable)
  {
    setFillAfter(true);
    setDuration(300L);
    this.mView = paramView;
    setAnimationListener(new ConversationFragment.HeightAnimation.1(this, paramConversationFragment, paramRunnable));
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = this.this$0.getResources().getDimensionPixelSize(2131427360);
    this.mView.getLayoutParams().height = (int)(i * (1.0F - paramFloat));
    this.mView.requestLayout();
  }

  public boolean willChangeBounds()
  {
    return true;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationFragment.HeightAnimation
 * JD-Core Version:    0.6.0
 */