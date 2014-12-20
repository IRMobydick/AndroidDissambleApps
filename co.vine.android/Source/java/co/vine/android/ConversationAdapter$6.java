package co.vine.android;

class ConversationAdapter$6
  implements Runnable
{
  public void run()
  {
    if ((ConversationAdapter.access$800(this.this$0) != null) && (ConversationAdapter.access$900(this.this$0) != null))
      new ConversationAdapter.BlurRunnable(this.this$0, ConversationAdapter.access$900(this.this$0), ConversationAdapter.access$800(this.this$0)).run();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.6
 * JD-Core Version:    0.6.0
 */