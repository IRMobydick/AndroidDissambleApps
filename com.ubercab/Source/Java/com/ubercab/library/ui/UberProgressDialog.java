package com.ubercab.library.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;

public final class UberProgressDialog extends ProgressDialog
{
  private UberProgressDialog(Context paramContext)
  {
    super(paramContext);
  }

  private UberProgressDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public static ProgressDialog create(Context paramContext, CharSequence paramCharSequence)
  {
    return create(paramContext, paramCharSequence, false, null);
  }

  public static ProgressDialog create(Context paramContext, CharSequence paramCharSequence, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return create(paramContext, paramCharSequence, false, paramOnDismissListener);
  }

  public static ProgressDialog create(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    return create(paramContext, paramCharSequence, paramBoolean, null);
  }

  public static ProgressDialog create(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return decorateDialog(new UberProgressDialog(paramContext), paramContext, paramCharSequence, paramBoolean, paramOnDismissListener);
  }

  public static ProgressDialog create(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return decorateDialog(new UberProgressDialog(paramContext, paramInt), paramContext, paramCharSequence, paramBoolean, paramOnDismissListener);
  }

  private static ProgressDialog decorateDialog(ProgressDialog paramProgressDialog, Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramProgressDialog.setMessage(paramCharSequence);
    paramProgressDialog.setIndeterminate(true);
    paramProgressDialog.setCancelable(paramBoolean);
    paramProgressDialog.setOnDismissListener(paramOnDismissListener);
    paramProgressDialog.setCanceledOnTouchOutside(false);
    paramProgressDialog.setProgress(0);
    return paramProgressDialog;
  }

  public static ProgressDialog show(Context paramContext, CharSequence paramCharSequence)
  {
    ProgressDialog localProgressDialog = create(paramContext, paramCharSequence);
    localProgressDialog.show();
    return localProgressDialog;
  }

  public static ProgressDialog show(Context paramContext, CharSequence paramCharSequence, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ProgressDialog localProgressDialog = create(paramContext, paramCharSequence, paramOnDismissListener);
    localProgressDialog.show();
    return localProgressDialog;
  }

  public static ProgressDialog show(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean)
  {
    ProgressDialog localProgressDialog = create(paramContext, paramCharSequence, paramBoolean);
    localProgressDialog.show();
    return localProgressDialog;
  }

  public static ProgressDialog show(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ProgressDialog localProgressDialog = create(paramContext, paramCharSequence, paramBoolean, paramOnDismissListener);
    localProgressDialog.show();
    return localProgressDialog;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.UberProgressDialog
 * JD-Core Version:    0.6.2
 */