package net.photopay.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimatorSet$Builder
{
  private AnimatorSet.Node mCurrentNode;

  AnimatorSet$Builder(AnimatorSet paramAnimatorSet, Animator paramAnimator)
  {
    this.mCurrentNode = ((AnimatorSet.Node)AnimatorSet.access$100(paramAnimatorSet).get(paramAnimator));
    if (this.mCurrentNode == null)
    {
      this.mCurrentNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$100(paramAnimatorSet).put(paramAnimator, this.mCurrentNode);
      AnimatorSet.access$400(paramAnimatorSet).add(this.mCurrentNode);
    }
  }

  public Builder after(long paramLong)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 1.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat);
    localValueAnimator.setDuration(paramLong);
    after(localValueAnimator);
    return this;
  }

  public Builder after(Animator paramAnimator)
  {
    AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.access$100(this.this$0).get(paramAnimator);
    if (localNode == null)
    {
      localNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$100(this.this$0).put(paramAnimator, localNode);
      AnimatorSet.access$400(this.this$0).add(localNode);
    }
    AnimatorSet.Dependency localDependency = new AnimatorSet.Dependency(localNode, 1);
    this.mCurrentNode.addDependency(localDependency);
    return this;
  }

  public Builder before(Animator paramAnimator)
  {
    AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.access$100(this.this$0).get(paramAnimator);
    if (localNode == null)
    {
      localNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$100(this.this$0).put(paramAnimator, localNode);
      AnimatorSet.access$400(this.this$0).add(localNode);
    }
    localNode.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 1));
    return this;
  }

  public Builder with(Animator paramAnimator)
  {
    AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.access$100(this.this$0).get(paramAnimator);
    if (localNode == null)
    {
      localNode = new AnimatorSet.Node(paramAnimator);
      AnimatorSet.access$100(this.this$0).put(paramAnimator, localNode);
      AnimatorSet.access$400(this.this$0).add(localNode);
    }
    localNode.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 0));
    return this;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.animation.AnimatorSet.Builder
 * JD-Core Version:    0.6.0
 */