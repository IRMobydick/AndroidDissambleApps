package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import co.vine.android.api.VinePost;
import co.vine.android.widget.FeedAdapter;

class BaseTimelineFragment$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("co.vine.android.service.mergePostFeed".equals(paramIntent.getAction())))
    {
      VinePost localVinePost = (VinePost)paramIntent.getExtras().getParcelable("post");
      ((FeedAdapter)this.this$0.mFeedAdapter).mergeMyPost(localVinePost);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.BaseTimelineFragment.1
 * JD-Core Version:    0.6.0
 */