package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public final class cz extends FrameLayout
  implements View.OnClickListener
{
  private final Activity a;
  private final ImageButton b;

  public cz(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.a = paramActivity;
    setOnClickListener(this);
    this.b = new ImageButton(paramActivity);
    this.b.setImageResource(17301527);
    this.b.setBackgroundColor(0);
    this.b.setOnClickListener(this);
    this.b.setPadding(0, 0, 0, 0);
    int i = hh.a(paramActivity, paramInt);
    addView(this.b, new FrameLayout.LayoutParams(i, i, 17));
  }

  public void a(boolean paramBoolean)
  {
    ImageButton localImageButton = this.b;
    if (paramBoolean);
    for (int i = 4; ; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }

  public void onClick(View paramView)
  {
    this.a.finish();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cz
 * JD-Core Version:    0.6.0
 */