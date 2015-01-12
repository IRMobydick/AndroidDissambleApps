package com.ubercab.library.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ubercab.library.app.UberActivity;

public final class ConfirmDialogFragment extends TextDialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String BUNDLE_CANCELED_ON_TOUCH_OUTSIDE = "dialog.canceled_on_touch_outside";
  private static final String BUNDLE_NEGATIVE = "dialog.button_negative_text";
  private static final String BUNDLE_POSITIVE = "dialog.button_positive_text";

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2)
  {
    show(paramUberActivity, paramInt, paramString1, paramString2, paramUberActivity.getString(17039370), paramUberActivity.getString(17039360));
  }

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    show(paramUberActivity, paramInt, paramString1, paramString2, paramString3, paramString4, null);
  }

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    Bundle localBundle = createArguments(paramString1, paramString2, paramInt);
    localBundle.putString("dialog.button_positive_text", paramString3);
    localBundle.putString("dialog.button_negative_text", paramString4);
    if (paramBundle != null)
      localBundle.putAll(paramBundle);
    ConfirmDialogFragment localConfirmDialogFragment = new ConfirmDialogFragment();
    localConfirmDialogFragment.setArguments(localBundle);
    localConfirmDialogFragment.show(paramUberActivity.getFragmentManager(), localConfirmDialogFragment.getClass().getName());
  }

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("dialog.canceled_on_touch_outside", paramBoolean);
    show(paramUberActivity, paramInt, paramString1, paramString2, paramString3, paramString4, localBundle);
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = -1;
    if (paramInt == i);
    while (true)
    {
      onResult(i);
      dismiss();
      return;
      i = 0;
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    AlertDialog localAlertDialog = createDialog();
    localAlertDialog.setButton(-1, localBundle.getString("dialog.button_positive_text"), this);
    localAlertDialog.setButton(-2, localBundle.getString("dialog.button_negative_text"), this);
    localAlertDialog.setCanceledOnTouchOutside(localBundle.getBoolean("dialog.canceled_on_touch_outside"));
    return localAlertDialog;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.ConfirmDialogFragment
 * JD-Core Version:    0.6.2
 */