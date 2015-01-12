package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.util.ValidationUtils;
import com.ubercab.client.core.vendor.alipay.model.AlipayCredentials;
import com.ubercab.common.collect.ImmutableMap;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddAlipayActivity extends RiderPublicActivity
{
  private static final String ALIPAY_TERMS_URL = "https://www.uber.com/alipay/terms";
  public static final String EXTRA_ALIPAY_CREDENTIALS = "alipay_credentials";

  @InjectView(2131427559)
  UberButton mButtonLegal;

  @InjectView(2131427557)
  UberButton mButtonSubmit;

  @InjectView(2131427553)
  AutoCompleteTextView mEditTextAccountId;

  @InjectView(2131427556)
  UberEditText mEditTextMobile;

  @InjectView(2131427554)
  LinearLayout mLayoutAlipayPhoneLayout;
  private UpdateAlipayAccountTextWatcher mLayoutWatcherUpdateAlipayAccount;

  @InjectView(2131427552)
  UberTextView mTextAlipayAccountLabel;

  @InjectView(2131427555)
  UberTextView mTextAlipayPhoneLabel;

  @InjectView(2131427558)
  UberTextView mTextLegalDescription;
  private UpdateUITextWatcher mTextWatcherUpdateUI;

  public static boolean isEligible(GeoManager paramGeoManager)
  {
    return paramGeoManager.getGeo() == 3;
  }

  private void updateUI()
  {
    if (this.mEditTextAccountId.getText().toString().contains("@"))
    {
      if (!TextUtils.isEmpty(this.mEditTextMobile.getText()));
      for (bool = true; ; bool = false)
      {
        this.mButtonSubmit.setEnabled(bool);
        return;
      }
    }
    if (!TextUtils.isEmpty(this.mEditTextAccountId.getText()));
    for (boolean bool = true; ; bool = false)
      break;
  }

  private String validateAccountId(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      Matcher localMatcher = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", 2).matcher(paramString);
      String str = getString(2131558899);
      if (localMatcher.matches())
        str = null;
      return str;
    }
    return validatePhone(true, paramString);
  }

  private String validatePhone(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (Pattern.compile("^1\\d{10}$", 2).matcher(paramString).matches()))
      return null;
    return getString(2131558943);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903125);
    ButterKnife.inject(this);
    String str = getString(2131558441);
    getActionBar().setTitle(str);
    this.mTextWatcherUpdateUI = new UpdateUITextWatcher(null);
    this.mLayoutWatcherUpdateAlipayAccount = new UpdateAlipayAccountTextWatcher(null);
    this.mTextAlipayAccountLabel.setText(getString(2131558442));
    this.mEditTextAccountId.setHint(getString(2131558829));
    this.mEditTextAccountId.addTextChangedListener(this.mLayoutWatcherUpdateAlipayAccount);
    this.mTextAlipayPhoneLabel.setText(getString(2131558443));
    this.mEditTextMobile.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mLayoutAlipayPhoneLayout.setVisibility(8);
    this.mButtonSubmit.setText(getString(2131559087));
    this.mButtonSubmit.setEnabled(false);
    this.mTextLegalDescription.setText(getString(2131558445));
    this.mButtonLegal.setText(getString(2131558444));
    this.mButtonLegal.setPaintFlags(0x8 | this.mButtonLegal.getPaintFlags());
  }

  @OnClick({2131427559})
  public void onLegalClicked()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("https://www.uber.com/alipay/terms"));
    startActivity(localIntent);
  }

  @OnClick({2131427557})
  public void onSubmitTapped()
  {
    String str1 = this.mEditTextAccountId.getText().toString().trim();
    boolean bool = str1.contains("@");
    if (bool);
    for (String str2 = this.mEditTextMobile.getText().toString().trim(); ; str2 = str1)
    {
      HashMap localHashMap = new HashMap();
      String str3 = validateAccountId(bool, str1);
      if (str3 != null)
        localHashMap.put("account_id", str3);
      String str4 = validatePhone(bool, str2);
      if (str4 != null)
        localHashMap.put("mobile", str4);
      if (localHashMap.isEmpty())
        break;
      ValidationUtils.showValidationErrors(localHashMap, ImmutableMap.of("account_id", this.mEditTextAccountId, "mobile", this.mEditTextMobile));
      return;
    }
    KeyboardUtils.hideKeyboard(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("alipay_credentials", new AlipayCredentials(str1, str2));
    setResult(-1, localIntent);
    finish();
  }

  private class UpdateAlipayAccountTextWatcher extends AddAlipayActivity.UpdateUITextWatcher
  {
    private UpdateAlipayAccountTextWatcher()
    {
      super(null);
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (AddAlipayActivity.this.mEditTextAccountId.getText().toString().contains("@"))
      {
        AddAlipayActivity.this.mLayoutAlipayPhoneLayout.setVisibility(0);
        return;
      }
      AddAlipayActivity.this.mLayoutAlipayPhoneLayout.setVisibility(8);
    }
  }

  private class UpdateUITextWatcher extends TextWatcherAdapter
  {
    private UpdateUITextWatcher()
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AddAlipayActivity.this.updateUI();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddAlipayActivity
 * JD-Core Version:    0.6.2
 */