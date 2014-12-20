package co.vine.android;

public class AbstractRecordingActivity$SetSelectedRunnable
  implements Runnable
{
  public final DraftFragment fragmentToSetSelectedFalse;
  public final DraftFragment fragmentToSetSelectedTrue;

  public AbstractRecordingActivity$SetSelectedRunnable(AbstractRecordingActivity paramAbstractRecordingActivity, DraftFragment paramDraftFragment1, DraftFragment paramDraftFragment2)
  {
    this.fragmentToSetSelectedFalse = paramDraftFragment1;
    this.fragmentToSetSelectedTrue = paramDraftFragment2;
  }

  public void run()
  {
    if (this.fragmentToSetSelectedFalse != null)
      this.fragmentToSetSelectedFalse.setSelected(false);
    if (this.fragmentToSetSelectedTrue != null)
      this.fragmentToSetSelectedTrue.setSelected(true);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AbstractRecordingActivity.SetSelectedRunnable
 * JD-Core Version:    0.6.0
 */