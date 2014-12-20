package net.photopay.nineoldandroids.animation;

import java.util.ArrayList;

class AnimatorSet$1 extends AnimatorListenerAdapter
{
  boolean canceled = false;

  public void onAnimationCancel(Animator paramAnimator)
  {
    this.canceled = true;
  }

  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.canceled)
    {
      int i = this.val$nodesToStart.size();
      for (int j = 0; j < i; j++)
      {
        AnimatorSet.Node localNode = (AnimatorSet.Node)this.val$nodesToStart.get(j);
        localNode.animation.start();
        AnimatorSet.access$000(this.this$0).add(localNode.animation);
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.animation.AnimatorSet.1
 * JD-Core Version:    0.6.0
 */