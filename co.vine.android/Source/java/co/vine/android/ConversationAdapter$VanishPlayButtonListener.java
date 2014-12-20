package co.vine.android;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import co.vine.android.drawable.ColoredOvalDrawable;

public class ConversationAdapter$VanishPlayButtonListener
  implements View.OnClickListener
{
  private final ConversationAdapter.ConversationViewHolder holder;

  public ConversationAdapter$VanishPlayButtonListener(ConversationAdapter paramConversationAdapter, ConversationAdapter.ConversationViewHolder paramConversationViewHolder)
  {
    this.holder = paramConversationViewHolder;
  }

  public void onClick(View paramView)
  {
    this.holder.vanishMessageContainer.setVisibility(8);
    this.holder.vanishThumbnailOverlay.setVisibility(8);
    this.holder.loadImage.setVisibility(0);
    this.holder.timerOval.setColor(0xFF000000 | this.holder.color);
    this.holder.vanishTimerText.setVisibility(0);
    this.holder.vanishTimerText.invalidate();
    this.this$0.play(this.holder.position);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.VanishPlayButtonListener
 * JD-Core Version:    0.6.0
 */