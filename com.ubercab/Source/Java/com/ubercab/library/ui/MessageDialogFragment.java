package com.ubercab.library.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.ubercab.library.app.UberActivity;

public final class MessageDialogFragment extends TextDialogFragment
{
  private static final String BUNDLE_BUTTON = "dialog.button_positive_text";

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2)
  {
    show(paramUberActivity, paramInt, paramString1, paramString2, paramUberActivity.getString(17039370));
  }

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    show(paramUberActivity, paramInt, paramString1, paramString2, paramString3, null);
  }

  public static void show(UberActivity paramUberActivity, int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Bundle localBundle = createArguments(paramString1, paramString2, paramInt);
    localBundle.putString("dialog.button_positive_text", paramString3);
    if (paramBundle != null)
      localBundle.putAll(paramBundle);
    MessageDialogFragment localMessageDialogFragment = new MessageDialogFragment();
    localMessageDialogFragment.setArguments(localBundle);
    localMessageDialogFragment.show(paramUberActivity.getFragmentManager(), localMessageDialogFragment.getClass().getName());
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
    AlertDialog localAlertDialog = createDialog();
    localAlertDialog.setCanceledOnTouchOutside(false);
    if ((getArguments() != null) && (!TextUtils.isEmpty(getArguments().getString("dialog.button_positive_text"))))
      localAlertDialog.setButton(-1, getArguments().getString("dialog.button_positive_text"), this);
    return localAlertDialog;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.MessageDialogFragment
 * JD-Core Version:    0.6.2
 */