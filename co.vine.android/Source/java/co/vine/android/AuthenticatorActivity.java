package co.vine.android;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.service.VineService;
import co.vine.android.service.VineServiceCallback;

public class AuthenticatorActivity extends AccountAuthenticatorActivity
{
  private static final int DIALOG_PROGRESS_ID = 1;
  public static final String PARAM_AUTH_TOKEN_TYPE = "auth_token_type";
  public static final String PARAM_CONFIRM_CREDENTIALS = "confirm_credentials";
  public static final String PARAM_USERNAME = "username";
  private AccountManager mAccountManager;
  Boolean mConfirmCredentials;
  private String mLoginEmail;
  private EditText mPasswordEditView;

  private void saveAuth(String paramString)
  {
    Account localAccount = new Account(this.mLoginEmail, VineAccountHelper.ACCOUNT_TYPE);
    this.mAccountManager.setAuthToken(localAccount, "co.vine.android.basic_auth.token.secret", paramString);
  }

  void finishConfirmCredentials(String paramString, boolean paramBoolean)
  {
    saveAuth(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("booleanResult", paramBoolean);
    setAccountAuthenticatorResult(localIntent.getExtras());
    setResult(-1, localIntent);
    finish();
  }

  void finishLogin(String paramString)
  {
    saveAuth(paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("authAccount", this.mLoginEmail);
    localIntent.putExtra("accountType", VineAccountHelper.ACCOUNT_TYPE);
    localIntent.putExtra("authtoken", paramString);
    setAccountAuthenticatorResult(localIntent.getExtras());
    setResult(-1, localIntent);
    AppController localAppController = AppController.getInstance(this);
    if (localAppController.isLoggedIn())
      localAppController.updateCredentials(paramString);
    finish();
  }

  public void onClickHandler(View paramView)
  {
    String str = this.mPasswordEditView.getText().toString();
    if (TextUtils.isEmpty(str));
    while (true)
    {
      return;
      showDialog(1);
      AuthenticatorActivity.1 local1 = new AuthenticatorActivity.1(this);
      Intent localIntent = new Intent(this, VineService.class);
      localIntent.setAction("co.vine.android.session.login");
      localIntent.putExtra("login", this.mLoginEmail);
      localIntent.putExtra("pass", str);
      localIntent.putExtra("ibinder", new VineServiceCallback(local1));
      startService(localIntent);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(3);
    setContentView(2130903124);
    getWindow().setFeatureDrawableResource(3, 17301543);
    this.mAccountManager = AccountManager.get(this);
    Intent localIntent = getIntent();
    this.mLoginEmail = localIntent.getStringExtra("username");
    this.mConfirmCredentials = Boolean.valueOf(localIntent.getBooleanExtra("confirm_credentials", false));
    ((TextView)findViewById(2131362091)).setText(this.mLoginEmail);
    this.mPasswordEditView = ((EditText)findViewById(2131362094));
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    ProgressDialog localProgressDialog;
    switch (paramInt)
    {
    default:
      localProgressDialog = null;
    case 1:
    }
    while (true)
    {
      return localProgressDialog;
      localProgressDialog = new ProgressDialog(this, 2131689527);
      localProgressDialog.setMessage(getText(2131624249));
      localProgressDialog.setIndeterminate(true);
      localProgressDialog.setCancelable(true);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AuthenticatorActivity
 * JD-Core Version:    0.6.0
 */