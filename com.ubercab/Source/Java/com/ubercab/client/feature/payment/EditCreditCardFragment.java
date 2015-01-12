package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.DeletePaymentProfileResponseEvent;
import com.ubercab.client.core.network.events.RewardsEnrollmentUpdateResponseEvent;
import com.ubercab.client.core.network.events.UpdatePaymentProfileResponseEvent;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.MonthEditText.Listener;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.client.core.ui.YearEditText.Listener;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.DeletedPaymentProfileEvent;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.library.ui.ZipEditText.Listener;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.payment.ui.CreditCardEditText;
import com.ubercab.payment.ui.SecurityCodeEditText;
import com.ubercab.payment.ui.SecurityCodeEditText.Listener;
import com.ubercab.payment.util.CreditCardUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

public class EditCreditCardFragment extends RiderFragment
  implements YearEditText.Listener, MonthEditText.Listener, ZipEditText.Listener, SecurityCodeEditText.Listener, View.OnClickListener
{
  private static final String ARG_PAYMENT_PROFILE_ID = "payment_profile_id";
  private static final String BUNDLE_COUNTRY_ISO2 = "com.ubercab.client.feature.payment.COUNTRY_ISO2";
  private static final String BUNDLE_IS_EDIT_MODE = "is_edit_mode";
  private static final int REQUEST_CODE_COUNTRY = 1;
  private static final int REQUEST_CODE_DELETE_CARD = 2;

  @Inject
  ActionBar mActionBar;
  private ActionViewHolder mActionViewHolder;
  private PaymentProfileUseCaseAdapter mAdapterUseCase;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  UberBraintree mBraintree;

  @Inject
  Bus mBus;

  @InjectView(2131427575)
  CountryButton mButtonCountry;

  @InjectView(2131427605)
  UberButton mButtonDelete;

  @InjectView(2131427604)
  UberButton mButtonEnrollMe;
  private String mCountryIso2Code;

  @Inject
  DeletePaymentDialogPresenter mDeletePaymentDialogPresenter;

  @InjectView(2131427573)
  SecurityCodeEditText mEditTextCreditCardCode;

  @InjectView(2131427569)
  CreditCardEditText mEditTextCreditCardNumber;

  @InjectView(2131427570)
  MonthEditText mEditTextExpirationMonth;

  @InjectView(2131427572)
  YearEditText mEditTextExpirationYear;

  @InjectView(2131427574)
  ZipEditText mEditTextZip;
  private boolean mIsEditMode;

  @Inject
  LayoutInflater mLayoutInflater;
  private MenuItem mMenuItemEdit;
  private String mPaymentProfileId;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427599)
  Spinner mSpinnerUseCase;

  @InjectView(2131427603)
  Switch mSwitchUsePoints;

  @InjectView(2131427608)
  UberTextView mTextViewRewardLink;

  @InjectView(2131427607)
  UberTextView mTextViewRewardRestrictions;

  @InjectView(2131427600)
  UberTextView mTextViewRewardsStatus;

  @InjectView(2131427602)
  UberTextView mTextViewUsePoints;
  private Boolean mUsePoints;

  @InjectView(2131427606)
  ViewGroup mViewGroupRewardRestrictions;

  @InjectView(2131427601)
  ViewGroup mViewGroupUsePoints;

  public static EditCreditCardFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payment_profile_id", paramString);
    EditCreditCardFragment localEditCreditCardFragment = new EditCreditCardFragment();
    localEditCreditCardFragment.setArguments(localBundle);
    return localEditCreditCardFragment;
  }

  private void sendDeletePaymentProfileRequest()
  {
    showLoadingDialogSticky(getString(2131558802), null);
    this.mRiderClient.deletePaymentProfile(this.mPaymentProfileId);
  }

  private void sendUpdatePaymentProfileRequest()
  {
    KeyboardUtils.hideKeyboard(getActivity(), getActivity().getCurrentFocus());
    showLoadingDialogSticky(getString(2131559322), null);
    String str1 = this.mBraintree.encrypt(this.mEditTextExpirationMonth.getText().toString());
    String str2 = this.mBraintree.encrypt(this.mEditTextExpirationYear.getText().toString());
    String str3 = this.mBraintree.encrypt(this.mEditTextCreditCardCode.getText().toString());
    String str4 = this.mEditTextZip.getText().toString();
    String str5 = this.mAdapterUseCase.getValue(this.mSpinnerUseCase.getSelectedItemPosition());
    this.mRiderClient.updatePaymentProfile(this.mPaymentProfileId, str1, str2, str3, this.mCountryIso2Code, str4, str5);
  }

  private void setCountry(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = Locale.getDefault().getCountry().toUpperCase(Locale.US);
    this.mCountryIso2Code = paramString;
    this.mEditTextZip.setCountry(paramString);
    this.mButtonCountry.setCountry(paramString);
  }

  private void setEditMode(boolean paramBoolean)
  {
    int i = 1;
    this.mIsEditMode = paramBoolean;
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasClient(localPing))
      return;
    PaymentProfile localPaymentProfile = localPing.getClient().findPaymentProfileWithId(this.mPaymentProfileId);
    if (localPaymentProfile == null)
    {
      this.mBus.post(new DeletedPaymentProfileEvent());
      return;
    }
    if (paramBoolean)
    {
      View localView2 = this.mLayoutInflater.inflate(2130903120, null);
      this.mActionViewHolder = new ActionViewHolder(localView2, null);
      this.mActionViewHolder.textViewSave.setText(getString(2131559042));
      this.mActionViewHolder.textViewCancel.setText(getString(2131558467));
      this.mActionViewHolder.actionButtonSave.setOnClickListener(this);
      this.mActionViewHolder.actionButtonCancel.setOnClickListener(this);
      this.mActionBar.setDisplayOptions(16, 26);
      this.mActionBar.setCustomView(localView2, new ActionBar.LayoutParams(-1, -1));
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
    }
    while (true)
    {
      Iterator localIterator = ImmutableList.of(this.mSpinnerUseCase, this.mEditTextZip, this.mEditTextExpirationYear, this.mEditTextExpirationMonth, this.mButtonCountry).iterator();
      while (localIterator.hasNext())
      {
        View localView1 = (View)localIterator.next();
        localView1.setEnabled(paramBoolean);
        if ((!paramBoolean) && ((localView1 instanceof TextView)))
          ((TextView)localView1).setError(null);
      }
      if (this.mActionViewHolder != null)
      {
        this.mActionViewHolder.actionButtonSave.setOnClickListener(null);
        this.mActionViewHolder.actionButtonCancel.setOnClickListener(null);
        this.mActionViewHolder = null;
      }
      this.mActionBar.setDisplayShowCustomEnabled(false);
      this.mActionBar.setDisplayShowTitleEnabled(i);
      this.mActionBar.setDisplayHomeAsUpEnabled(i);
      this.mActionBar.setDisplayShowHomeEnabled(i);
      this.mActionBar.setTitle(getString(2131558985));
      this.mEditTextCreditCardCode.setText(null);
      updateUI(localPaymentProfile, localPing);
    }
    SecurityCodeEditText localSecurityCodeEditText = this.mEditTextCreditCardCode;
    int k;
    label394: UberButton localUberButton;
    int m;
    if (paramBoolean)
    {
      k = 0;
      localSecurityCodeEditText.setVisibility(k);
      if (localPing.getClient().getPaymentProfiles().size() <= i)
        break label432;
      localUberButton = this.mButtonDelete;
      if (!paramBoolean)
        break label437;
      m = 0;
      if (i == 0)
        break label437;
    }
    while (true)
    {
      localUberButton.setVisibility(m);
      getActivity().invalidateOptionsMenu();
      return;
      k = 4;
      break;
      label432: int j = 0;
      break label394;
      label437: m = 8;
    }
  }

  private void showRestrictionsAndTerms()
  {
    this.mTextViewRewardRestrictions.setText(getString(2131559037));
    this.mTextViewRewardLink.setText(getString(2131559118));
    this.mViewGroupRewardRestrictions.setVisibility(0);
  }

  private void updateUI(PaymentProfile paramPaymentProfile, Ping paramPing)
  {
    String str1 = paramPaymentProfile.getCardType();
    String str2 = paramPaymentProfile.getUseCase();
    String str3 = paramPaymentProfile.getCardNumber();
    String str4 = paramPaymentProfile.getBillingZip();
    setCountry(paramPaymentProfile.getBillingCountryIso2());
    this.mEditTextExpirationMonth.setText(paramPaymentProfile.getExpirationMonth());
    this.mEditTextExpirationYear.setText(paramPaymentProfile.getExpirationYear());
    this.mEditTextExpirationYear.setListener(this);
    this.mEditTextExpirationMonth.setListener(this);
    this.mEditTextZip.setText(str4);
    this.mEditTextZip.setListener(this);
    Drawable localDrawable = CreditCardUtils.getImage(getActivity(), str1);
    this.mEditTextCreditCardNumber.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    String str5 = CreditCardUtils.getFormattedNumberMasked(str1, str3);
    this.mEditTextCreditCardNumber.setText(str5);
    this.mEditTextCreditCardCode.setCardType(paramPaymentProfile.getCardType());
    this.mEditTextCreditCardCode.setListener(this);
    this.mSpinnerUseCase.setSelection(PaymentProfileUseCaseAdapter.USE_CASES.indexOf(str2));
    RewardInfo localRewardInfo = paramPaymentProfile.getRewardInfo();
    boolean bool = PingUtils.hasExperimentSerial(paramPing, "amex_rewards", 1);
    if ((localRewardInfo == null) || (!bool))
    {
      this.mViewGroupRewardRestrictions.setVisibility(8);
      return;
    }
    if (localRewardInfo.isEnrolled())
    {
      if (localRewardInfo.isEarnOnly())
      {
        this.mTextViewRewardsStatus.setText(getString(2131558840));
        this.mViewGroupUsePoints.setVisibility(8);
      }
      while (true)
      {
        this.mTextViewRewardsStatus.setVisibility(0);
        this.mButtonEnrollMe.setVisibility(8);
        showRestrictionsAndTerms();
        return;
        this.mTextViewRewardsStatus.setText(getString(2131558841));
        this.mTextViewUsePoints.setText(getString(2131559069));
        this.mViewGroupUsePoints.setVisibility(0);
        if (this.mUsePoints == null)
        {
          this.mSwitchUsePoints.setChecked(localRewardInfo.isEnabled());
          this.mUsePoints = Boolean.valueOf(localRewardInfo.isEnabled());
        }
      }
    }
    if (localRewardInfo.isEligible())
    {
      if (localRewardInfo.isEarnOnly())
        this.mTextViewRewardsStatus.setText(getString(2131558825));
      while (true)
      {
        this.mTextViewRewardsStatus.setVisibility(0);
        this.mButtonEnrollMe.setText(getString(2131558834));
        this.mButtonEnrollMe.setVisibility(0);
        showRestrictionsAndTerms();
        return;
        this.mTextViewRewardsStatus.setText(getString(2131558826));
      }
    }
    this.mViewGroupRewardRestrictions.setVisibility(8);
    this.mTextViewRewardsStatus.setVisibility(8);
    this.mButtonEnrollMe.setVisibility(8);
  }

  private void validateData()
  {
    if ((this.mEditTextExpirationYear.isValid()) && (this.mEditTextExpirationMonth.isValid()));
    for (boolean bool = true; ; bool = false)
    {
      if (this.mActionViewHolder != null)
        this.mActionViewHolder.actionButtonSave.setEnabled(bool);
      return;
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
      setCountry(paramIntent.getStringExtra("country_iso2"));
  }

  public boolean onBackPressed()
  {
    boolean bool1 = this.mIsEditMode;
    boolean bool2 = false;
    if (bool1)
    {
      setEditMode(false);
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_EDIT_CC_CANCEL);
      bool2 = true;
    }
    return bool2;
  }

  public void onClick(View paramView)
  {
    if (paramView == this.mActionViewHolder.actionButtonSave)
      if (TextUtils.isEmpty(this.mEditTextCreditCardCode.getText()))
      {
        this.mEditTextCreditCardCode.setError(getString(2131558794));
        this.mEditTextCreditCardCode.requestFocus();
      }
    while (paramView != this.mActionViewHolder.actionButtonCancel)
    {
      return;
      this.mEditTextCreditCardCode.setError(null);
      sendUpdatePaymentProfileRequest();
      return;
    }
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_EDIT_CC_CANCEL);
    setEditMode(false);
  }

  @OnClick({2131427605})
  public void onClickButtonDelete()
  {
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_DELETE_CONFIRMATION);
    this.mDeletePaymentDialogPresenter.show(getRiderActivity(), 2);
  }

  @OnClick({2131427575})
  public void onClickCountry()
  {
    startActivityForResult(new Intent(getActivity(), SelectCountryActivity.class), 1);
  }

  @OnClick({2131427604})
  public void onClickEnrollMe()
  {
    showLoadingDialogSticky(getString(2131558837), null);
    this.mRiderClient.updateRewardData(this.mPaymentProfileId, Boolean.valueOf(true), null);
  }

  @OnClick({2131427606})
  public void onClickTerms()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(2131559117))));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mPaymentProfileId = localBundle.getString("payment_profile_id");
    if (paramBundle != null)
      this.mIsEditMode = paramBundle.getBoolean("is_edit_mode", false);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131689476, paramMenu);
    this.mMenuItemEdit = paramMenu.findItem(2131427938);
    this.mMenuItemEdit.setTitle(getString(2131558824));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903136, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onCreditCardCodeChanged(SecurityCodeEditText paramSecurityCodeEditText, boolean paramBoolean)
  {
    validateData();
  }

  @Subscribe
  public void onDeletePaymentProfileResponseEvent(DeletePaymentProfileResponseEvent paramDeletePaymentProfileResponseEvent)
  {
    hideLoadingDialog();
    if (!paramDeletePaymentProfileResponseEvent.isSuccess())
    {
      showToast(paramDeletePaymentProfileResponseEvent.getErrorMessage(getActivity()));
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_DELETE_SUCCESS);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  void onDialogResult(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramInt2 == -1))
      sendDeletePaymentProfileRequest();
  }

  public void onMonthChanged(MonthEditText paramMonthEditText, boolean paramBoolean)
  {
    validateData();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem == this.mMenuItemEdit)
    {
      setEditMode(true);
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_EDIT_CC_START);
      return true;
    }
    return false;
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    PaymentProfile localPaymentProfile = localPing.getClient().findPaymentProfileWithId(this.mPaymentProfileId);
    if (localPaymentProfile == null)
      this.mBus.post(new DeletedPaymentProfileEvent());
    while (this.mIsEditMode)
      return;
    updateUI(localPaymentProfile, localPing);
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    MenuItem localMenuItem = this.mMenuItemEdit;
    if (!this.mIsEditMode);
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      return;
    }
  }

  public void onResume()
  {
    super.onResume();
    setEditMode(this.mIsEditMode);
  }

  @Subscribe
  public void onRewardsProgramUpdateResponse(RewardsEnrollmentUpdateResponseEvent paramRewardsEnrollmentUpdateResponseEvent)
  {
    hideLoadingDialog();
    if (!paramRewardsEnrollmentUpdateResponseEvent.isSuccess())
      showToast(paramRewardsEnrollmentUpdateResponseEvent.getErrorMessage(getActivity()));
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("is_edit_mode", this.mIsEditMode);
    paramBundle.putString("com.ubercab.client.feature.payment.COUNTRY_ISO2", this.mCountryIso2Code);
  }

  @Subscribe
  public void onUpdatePaymentProfileResponseEvent(UpdatePaymentProfileResponseEvent paramUpdatePaymentProfileResponseEvent)
  {
    hideLoadingDialog();
    if (!paramUpdatePaymentProfileResponseEvent.isSuccess())
    {
      showToast(paramUpdatePaymentProfileResponseEvent.getErrorMessage(getActivity()));
      return;
    }
    showToast(getString(2131559089));
    setEditMode(false);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_EDIT_CC_SAVE);
  }

  @OnCheckedChanged({2131427603})
  void onUsePointsToggled(boolean paramBoolean)
  {
    if ((this.mUsePoints != null) && (this.mUsePoints.booleanValue() != paramBoolean))
    {
      this.mUsePoints = Boolean.valueOf(paramBoolean);
      this.mRiderClient.updateRewardData(this.mPaymentProfileId, null, Boolean.valueOf(paramBoolean));
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (paramBundle != null)
      setCountry(paramBundle.getString("com.ubercab.client.feature.payment.COUNTRY_ISO2"));
    this.mButtonDelete.setText(getString(2131558799));
    this.mAdapterUseCase = new PaymentProfileUseCaseAdapter(getActivity());
    this.mSpinnerUseCase.setAdapter(this.mAdapterUseCase);
    this.mEditTextZip.setHint(getString(2131559356));
  }

  public void onYearChanged(YearEditText paramYearEditText, boolean paramBoolean)
  {
    validateData();
  }

  public void onZipChanged(boolean paramBoolean)
  {
    validateData();
  }

  static final class ActionViewHolder
  {

    @InjectView(2131427547)
    View actionButtonCancel;

    @InjectView(2131427549)
    View actionButtonSave;

    @InjectView(2131427548)
    UberTextView textViewCancel;

    @InjectView(2131427550)
    UberTextView textViewSave;

    private ActionViewHolder(View paramView)
    {
      ButterKnife.inject(this, paramView);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditCreditCardFragment
 * JD-Core Version:    0.6.2
 */