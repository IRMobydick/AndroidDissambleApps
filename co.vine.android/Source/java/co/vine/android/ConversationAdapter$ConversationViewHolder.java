package co.vine.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.drawable.ColoredOvalDrawable;
import co.vine.android.player.OnListVideoClickListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.util.image.ImageKey;

public class ConversationAdapter$ConversationViewHolder
{
  public ImageKey avatarKey;
  public final View bottomPaddingView;
  public int color;
  public final TextView errorMessage;
  public boolean hasVideoImage;
  public boolean isCurrentUser;
  public boolean isSharedPost;
  public boolean isVideoImageLoaded;
  public final View loadImage;
  public VinePrivateMessage message;
  public final ViewGroup messageContainer;
  public final TextView messageContainerMessage;
  public final ImageView messageContainerUserImage;
  public final View nibs;
  public final View nibsChatNib;
  public int position;
  public final ViewGroup postMessageContainer;
  public final TextView postMessageContainerMessage;
  public View postNibs;
  public final View secondaryMessageContainer;
  public final TextView secondaryMessageContainerMessage;
  public ColoredOvalDrawable timerOval;
  public final TextView timestamp;
  public final ViewGroup topMessageContainer;
  public final TextView topMessageContainerMessage;
  public final ImageView topMessageContainerUserImage;
  public View userImageProgressNormal;
  public View userImageProgressTop;
  public final View vanishMessageContainer;
  public final TextView vanishMessageOverlay;
  public final View vanishPlayButton;
  public ConversationAdapter.VanishPlayButtonListener vanishPlayButtonListener;
  public final View vanishThumbnailOverlay;
  public final TextView vanishTimerText;
  public final ImageView vanishUserImage;
  public final View videoContainer;
  public final ImageView videoImage;
  public ImageKey videoImageKey;
  public OnListVideoClickListener videoListener;
  public SdkVideoView videoView;

  public ConversationAdapter$ConversationViewHolder(View paramView)
  {
    this.messageContainer = ((ViewGroup)paramView.findViewById(2131362122));
    this.messageContainerUserImage = ((ImageView)paramView.findViewById(2131362123));
    this.messageContainerMessage = ((TextView)paramView.findViewById(2131362125));
    this.topMessageContainer = ((ViewGroup)paramView.findViewById(2131362134));
    this.topMessageContainerUserImage = ((ImageView)paramView.findViewById(2131362135));
    this.topMessageContainerMessage = ((TextView)paramView.findViewById(2131362137));
    this.vanishThumbnailOverlay = paramView.findViewById(2131362113);
    this.vanishMessageOverlay = ((TextView)paramView.findViewById(2131361970));
    this.vanishMessageContainer = paramView.findViewById(2131362114);
    this.vanishUserImage = ((ImageView)paramView.findViewById(2131362115));
    this.vanishPlayButton = paramView.findViewById(2131362116);
    this.vanishTimerText = ((TextView)paramView.findViewById(2131362121));
    this.postMessageContainer = ((ViewGroup)paramView.findViewById(2131362126));
    this.postMessageContainerMessage = ((TextView)paramView.findViewById(2131362127));
    this.userImageProgressNormal = paramView.findViewById(2131362131);
    this.userImageProgressTop = paramView.findViewById(2131362136);
    this.secondaryMessageContainer = paramView.findViewById(2131362128);
    this.secondaryMessageContainerMessage = ((TextView)paramView.findViewById(2131362129));
    this.videoContainer = paramView.findViewById(2131362067);
    this.videoImage = ((ImageView)paramView.findViewById(2131362112));
    this.videoView = ((SdkVideoView)paramView.findViewById(2131362117));
    this.loadImage = paramView.findViewById(2131361909);
    this.errorMessage = ((TextView)paramView.findViewById(2131362132));
    this.bottomPaddingView = paramView.findViewById(2131362130);
    this.nibs = paramView.findViewById(2131362118);
    this.postNibs = paramView.findViewById(2131362119);
    this.nibsChatNib = paramView.findViewById(2131362124);
    this.timestamp = ((TextView)paramView.findViewById(2131362133));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.ConversationViewHolder
 * JD-Core Version:    0.6.0
 */