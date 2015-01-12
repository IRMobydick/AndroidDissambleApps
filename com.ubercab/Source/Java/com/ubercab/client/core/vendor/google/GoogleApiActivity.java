package com.ubercab.client.core.vendor.google;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;
import com.ubercab.client.core.app.RiderPublicActivity;

public abstract class GoogleApiActivity extends RiderPublicActivity
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private static final String BUNDLE_RESOLVING_ERROR = "resolving_error";
  private static final String DIALOG_ERROR = "dialog_error";
  public static final String EXTRA_ACCOUNT_NAME = "com.ubercab.ACCOUNT_NAME";
  private static final int REQUEST_RESOLVE_ERROR = 1001;
  protected GoogleApiClient mGoogleApiClient;
  private boolean mResolvingError = false;

  private void showErrorDialog(int paramInt)
  {
    ErrorDialogFragment localErrorDialogFragment = new ErrorDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("dialog_error", paramInt);
    localErrorDialogFragment.setArguments(localBundle);
    localErrorDialogFragment.show(getFragmentManager(), "errordialog");
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      this.mResolvingError = false;
      if (paramInt2 != -1)
        break label51;
      if ((!this.mGoogleApiClient.isConnecting()) && (!this.mGoogleApiClient.isConnected()))
        this.mGoogleApiClient.connect();
    }
    return;
    label51: setResult(paramInt2);
    finish();
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    if (this.mResolvingError)
      return;
    if (paramConnectionResult.hasResolution())
      try
      {
        this.mResolvingError = true;
        paramConnectionResult.startResolutionForResult(this, 1001);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        this.mGoogleApiClient.connect();
        return;
      }
    showErrorDialog(paramConnectionResult.getErrorCode());
    this.mResolvingError = true;
  }

  public void onConnectionSuspended(int paramInt)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GoogleApiClient.Builder localBuilder = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).addScope(Plus.SCOPE_PLUS_PROFILE);
    if (getIntent().hasExtra("com.ubercab.ACCOUNT_NAME"))
      localBuilder.setAccountName(getIntent().getStringExtra("com.ubercab.ACCOUNT_NAME"));
    this.mGoogleApiClient = localBuilder.build();
    if (paramBundle != null)
      this.mResolvingError = paramBundle.getBoolean("resolving_error", false);
  }

  public void onDialogDismissed()
  {
    this.mResolvingError = false;
    setResult(0);
    finish();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.mResolvingError);
  }

  protected void onStart()
  {
    super.onStart();
    if (!this.mResolvingError)
      this.mGoogleApiClient.connect();
  }

  protected void onStop()
  {
    if ((this.mGoogleApiClient != null) && (this.mGoogleApiClient.isConnected()))
      this.mGoogleApiClient.disconnect();
    super.onStop();
  }

  public static class ErrorDialogFragment extends DialogFragment
  {
    public static final String TAG = "errordialog";

    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return GooglePlayServicesUtil.getErrorDialog(getArguments().getInt("dialog_error"), getActivity(), 1001);
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      ((GoogleApiActivity)getActivity()).onDialogDismissed();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GoogleApiActivity
 * JD-Core Version:    0.6.2
 */