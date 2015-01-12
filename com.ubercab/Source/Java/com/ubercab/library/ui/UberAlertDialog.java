package com.ubercab.library.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;

public final class UberAlertDialog extends AlertDialog
{
  private UberAlertDialog(Context paramContext)
  {
    super(paramContext);
  }

  private UberAlertDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public static AlertDialog create(Context paramContext)
  {
    return new UberAlertDialog(paramContext);
  }

  public static AlertDialog create(Context paramContext, int paramInt)
  {
    return new UberAlertDialog(paramContext, paramInt);
  }

  public static final class Builder extends AlertDialog.Builder
  {
    private Builder(Context paramContext)
    {
      super();
    }

    public static Builder create(Context paramContext)
    {
      return new Builder(paramContext);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.UberAlertDialog
 * JD-Core Version:    0.6.2
 */