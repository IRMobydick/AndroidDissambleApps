package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

class hl extends MutableContextWrapper
{
  private Activity a;
  private Context b;

  public hl(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }

  public Context a()
  {
    return this.a;
  }

  public void setBaseContext(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity));
    for (Activity localActivity = (Activity)paramContext; ; localActivity = null)
    {
      this.a = localActivity;
      super.setBaseContext(this.b);
      return;
    }
  }

  public void startActivity(Intent paramIntent)
  {
    if (this.a != null)
      this.a.startActivity(paramIntent);
    while (true)
    {
      return;
      paramIntent.setFlags(268435456);
      this.b.startActivity(paramIntent);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hl
 * JD-Core Version:    0.6.0
 */