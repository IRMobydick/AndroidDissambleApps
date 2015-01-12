package com.ubercab.library.network.log;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.ubercab.library.R.id;
import com.ubercab.library.R.layout;
import com.ubercab.library.R.string;
import com.ubercab.library.app.UberDialogFragment;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.network.cn.CnClient;
import com.ubercab.library.ui.UberAlertDialog.Builder;
import com.ubercab.ui.UberEditText;
import javax.inject.Inject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SendLogsDialogFragment extends UberDialogFragment
{
  private static final String BUNDLE_ARG_CLIENT_ID = "client_id";
  private static final String BUNDLE_ARG_CLIENT_TOKEN = "client_token";

  @Inject
  CnClient mCnClient;

  @ForApp
  @Inject
  Context mContext;
  private UberEditText mEditTextMessage;
  private LayoutInflater mLayoutInflater;

  private void sendLogs()
  {
    Bundle localBundle = getArguments();
    String str1 = localBundle.getString("client_id");
    String str2 = localBundle.getString("client_token");
    final Handler localHandler = new Handler(Looper.getMainLooper());
    this.mCnClient.sendLogs(this.mEditTextMessage.getText().toString(), str1, str2, new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
        localHandler.post(new Runnable()
        {
          public void run()
          {
            int i = R.string.ub__dialog_send_logs_error;
            Toast.makeText(SendLogsDialogFragment.this.mContext, i, 0).show();
          }
        });
      }

      public void success(Void paramAnonymousVoid, Response paramAnonymousResponse)
      {
        localHandler.post(new Runnable()
        {
          public void run()
          {
            int i = R.string.ub__dialog_send_logs_success;
            Toast.makeText(SendLogsDialogFragment.this.mContext, i, 0).show();
          }
        });
      }
    });
  }

  public static void show(Activity paramActivity, String paramString1, String paramString2)
  {
    SendLogsDialogFragment localSendLogsDialogFragment = new SendLogsDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", paramString1);
    localBundle.putString("client_token", paramString2);
    localSendLogsDialogFragment.setArguments(localBundle);
    localSendLogsDialogFragment.show(paramActivity.getFragmentManager(), localSendLogsDialogFragment.getClass().getName());
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    this.mLayoutInflater = LayoutInflater.from(getActivity());
    UberAlertDialog.Builder localBuilder = UberAlertDialog.Builder.create(getActivity());
    localBuilder.setPositiveButton(R.string.ub__send, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (SendLogsDialogFragment.this.mEditTextMessage.length() > 0)
        {
          SendLogsDialogFragment.this.sendLogs();
          return;
        }
        int i = R.string.ub__dialog_send_logs_no_description;
        Toast.makeText(SendLogsDialogFragment.this.mContext, i, 0).show();
      }
    });
    localBuilder.setNegativeButton(R.string.ub__cancel, null);
    View localView = this.mLayoutInflater.inflate(R.layout.ub__shared_fragment_send_network_logs, null);
    this.mEditTextMessage = ((UberEditText)localView.findViewById(R.id.ub__send_network_logs_edittext_message));
    localBuilder.setView(localView);
    localBuilder.setTitle(R.string.ub__dialog_title_send_logs);
    return localBuilder.create();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.log.SendLogsDialogFragment
 * JD-Core Version:    0.6.2
 */