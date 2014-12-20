package net.photopay.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator
{
  private TimeAnimator.TimeListener mListener;
  private long mPreviousTime = -1L;

  void animateValue(float paramFloat)
  {
  }

  boolean animationFrame(long paramLong)
  {
    long l1 = 0L;
    long l2;
    if (this.mPlayingState == 0)
    {
      this.mPlayingState = 1;
      if (this.mSeekTime < l1)
        this.mStartTime = paramLong;
    }
    else if (this.mListener != null)
    {
      l2 = paramLong - this.mStartTime;
      if (this.mPreviousTime >= l1)
        break label92;
    }
    while (true)
    {
      this.mPreviousTime = paramLong;
      this.mListener.onTimeUpdate(this, l2, l1);
      return false;
      this.mStartTime = (paramLong - this.mSeekTime);
      this.mSeekTime = -1L;
      break;
      label92: l1 = paramLong - this.mPreviousTime;
    }
  }

  void initAnimation()
  {
  }

  public void setTimeListener(TimeAnimator.TimeListener paramTimeListener)
  {
    this.mListener = paramTimeListener;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.animation.TimeAnimator
 * JD-Core Version:    0.6.0
 */