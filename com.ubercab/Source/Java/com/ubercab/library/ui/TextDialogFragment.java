package com.ubercab.library.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.ubercab.library.app.UberDialogFragment;

public abstract class TextDialogFragment extends UberDialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String BUNDLE_MESSAGE = "dialog.message";
  private static final String BUNDLE_TITLE = "dialog.title";

  protected static Bundle createArguments(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dialog.title", paramString1);
    localBundle.putString("dialog.message", paramString2);
    localBundle.putInt("dialog.request_code", paramInt);
    return localBundle;
  }

  protected AlertDialog createDialog()
  {
    AlertDialog localAlertDialog = UberAlertDialog.create(getActivity());
    localAlertDialog.setTitle(getTitle());
    localAlertDialog.setMessage(getMessage());
    localAlertDialog.setCancelable(true);
    return localAlertDialog;
  }

  protected String getMessage()
  {
    if (getArguments() == null)
      return "";
    return getArguments().getString("dialog.message");
  }

  protected String getTitle()
  {
    if (getArguments() == null)
      return "";
    return getArguments().getString("dialog.title");
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    dismiss();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.ui.TextDialogFragment
 * JD-Core Version:    0.6.2
 */