package com.ubercab.client.feature.payment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.model.Balance;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.client.feature.payment.event.PaymentProfileSelectedEvent;
import com.ubercab.client.feature.payment.reward.PointBalanceFormatter;
import com.ubercab.payment.util.CreditCardUtils;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;
import java.util.List;

public class PaymentProfileAdapter extends BaseAdapter
{
  private static final int ITEM_VIEW_TYPE_CREDIT_CARD = 0;
  private static final int ITEM_VIEW_TYPE_MOBILE_WALLET = 1;
  private static final int ITEM_VIEW_TYPE_REWARDS_INFO = 2;
  private static final int ITEM_VIEW_TYPE_REWARDS_SELECT = 3;
  private final Bus mBus;
  private final Context mContext;
  private PaymentProfile mInitialPaymentProfile;
  private final boolean mIsUsingPoints;
  private final LayoutInflater mLayoutInflater;
  private List<PaymentProfile> mListPaymentProfiles = new ArrayList();
  private final int mMode;
  private String mPaymentProfileBalance;
  private PaymentProfile mSelectedPaymentProfile;
  private final boolean mShowCheckBox;
  private final boolean mShowRewardsFeatureFlag;

  public PaymentProfileAdapter(boolean paramBoolean1, Bus paramBus, Context paramContext, int paramInt, PaymentProfile paramPaymentProfile, boolean paramBoolean2)
  {
    this.mShowRewardsFeatureFlag = paramBoolean1;
    this.mBus = paramBus;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mMode = paramInt;
    this.mInitialPaymentProfile = paramPaymentProfile;
    this.mSelectedPaymentProfile = paramPaymentProfile;
    this.mIsUsingPoints = paramBoolean2;
    if ((paramInt == i) || (paramInt == 2));
    while (true)
    {
      this.mShowCheckBox = i;
      return;
      i = 0;
    }
  }

  private View createView(int paramInt, PaymentProfile paramPaymentProfile, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramPaymentProfile.isMobileWallet())
    {
      localView = this.mLayoutInflater.inflate(2130903143, paramViewGroup, false);
      localObject = new MobileWalletViewHolder(localView, this.mShowCheckBox);
    }
    while (true)
    {
      localView.setTag(localObject);
      return localView;
      if ((!this.mShowRewardsFeatureFlag) || (!isEligibleForRewards(paramPaymentProfile)))
      {
        localView = this.mLayoutInflater.inflate(2130903142, paramViewGroup, false);
        localObject = new ItemViewHolder(localView, this.mShowCheckBox);
      }
      else if ((paramInt == 1) && (isEnrolledForRewards(paramPaymentProfile)))
      {
        localView = this.mLayoutInflater.inflate(2130903145, paramViewGroup, false);
        localObject = new RewardsToggleViewHolder(localView);
      }
      else if (paramInt == 0)
      {
        localView = this.mLayoutInflater.inflate(2130903144, paramViewGroup, false);
        localObject = new EnrollmentStatusViewHolder(localView);
      }
      else
      {
        localView = this.mLayoutInflater.inflate(2130903142, paramViewGroup, false);
        localObject = new ItemViewHolder(localView, this.mShowCheckBox);
      }
    }
  }

  private boolean isEligibleForRewards(PaymentProfile paramPaymentProfile)
  {
    RewardInfo localRewardInfo = paramPaymentProfile.getRewardInfo();
    return (localRewardInfo != null) && (localRewardInfo.isEligible());
  }

  private boolean isEnrolledForRewards(PaymentProfile paramPaymentProfile)
  {
    RewardInfo localRewardInfo = paramPaymentProfile.getRewardInfo();
    return (localRewardInfo != null) && (localRewardInfo.isEnrolled());
  }

  public int getCount()
  {
    return this.mListPaymentProfiles.size();
  }

  public Object getItem(int paramInt)
  {
    return this.mListPaymentProfiles.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    if (this.mListPaymentProfiles.size() == 0)
      return 0L;
    return Long.valueOf(((PaymentProfile)this.mListPaymentProfiles.get(paramInt)).getId()).longValue();
  }

  public int getItemViewType(int paramInt)
  {
    PaymentProfile localPaymentProfile = (PaymentProfile)getItem(paramInt);
    int i;
    if (localPaymentProfile.isMobileWallet())
      i = 1;
    boolean bool2;
    do
    {
      int j;
      do
      {
        boolean bool1;
        do
        {
          boolean bool3;
          do
          {
            return i;
            if ((!this.mShowRewardsFeatureFlag) || (this.mMode != 0))
              break;
            bool3 = isEligibleForRewards(localPaymentProfile);
            i = 0;
          }
          while (!bool3);
          return 2;
          bool1 = this.mShowRewardsFeatureFlag;
          i = 0;
        }
        while (!bool1);
        j = this.mMode;
        i = 0;
      }
      while (j != 1);
      bool2 = isEnrolledForRewards(localPaymentProfile);
      i = 0;
    }
    while (!bool2);
    return 3;
  }

  public PaymentProfile getSelectedPaymentProfile()
  {
    return this.mSelectedPaymentProfile;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PaymentProfile localPaymentProfile = (PaymentProfile)getItem(paramInt);
    if (paramView == null)
      paramView = createView(this.mMode, localPaymentProfile, paramViewGroup);
    ((ViewHolder)paramView.getTag()).update(localPaymentProfile, this.mListPaymentProfiles, this.mSelectedPaymentProfile);
    return paramView;
  }

  public int getViewTypeCount()
  {
    if (this.mShowRewardsFeatureFlag)
      return 4;
    return 2;
  }

  boolean isGoogleWalletEligible(Context paramContext)
  {
    return GoogleWalletActivity.isEligible(paramContext);
  }

  public void setPaymentProfileBalance(String paramString)
  {
    this.mPaymentProfileBalance = paramString;
  }

  public void setSelectedPaymentProfile(PaymentProfile paramPaymentProfile)
  {
    this.mSelectedPaymentProfile = paramPaymentProfile;
    notifyDataSetChanged();
  }

  public void update(Ping paramPing)
  {
    if (!PingUtils.hasClientPaymentProfiles(paramPing))
    {
      this.mListPaymentProfiles.clear();
      notifyDataSetChanged();
    }
    do
    {
      return;
      ArrayList localArrayList = new ArrayList(paramPing.getClient().getPaymentProfiles());
      if (isGoogleWalletEligible(this.mContext))
        localArrayList.add(PaymentProfile.GOOGLE_WALLET);
      this.mListPaymentProfiles = localArrayList;
      if (this.mMode != 2)
        break;
    }
    while (!PingUtils.hasTrip(paramPing));
    String str = paramPing.getTrip().getPaymentProfileId();
    if (TextUtils.isEmpty(str))
    {
      this.mSelectedPaymentProfile = null;
      this.mInitialPaymentProfile = null;
      notifyDataSetChanged();
      return;
    }
    int i;
    PaymentProfile localPaymentProfile;
    if (this.mInitialPaymentProfile == this.mSelectedPaymentProfile)
    {
      i = 1;
      if ((this.mSelectedPaymentProfile == null) || (i != 0))
      {
        localPaymentProfile = paramPing.getClient().findPaymentProfileWithId(str);
        if (localPaymentProfile == null)
          break label173;
      }
    }
    label173: for (this.mSelectedPaymentProfile = localPaymentProfile; ; this.mSelectedPaymentProfile = PaymentProfile.GOOGLE_WALLET)
    {
      this.mInitialPaymentProfile = this.mSelectedPaymentProfile;
      notifyDataSetChanged();
      return;
      i = 0;
      break;
    }
  }

  class EnrollmentStatusViewHolder
    implements PaymentProfileAdapter.ViewHolder
  {

    @InjectView(2131427627)
    ImageView mImageViewRewardsStatus;

    @InjectView(2131427628)
    UberTextView mTextViewLearnMore;

    @InjectView(2131427624)
    UberTextView mTextViewPaymentName;

    @InjectView(2131427600)
    UberTextView mTextViewRewardsStatus;

    @InjectView(2131427625)
    View mViewDivider;

    @InjectView(2131427626)
    ViewGroup mViewGroupRewards;

    EnrollmentStatusViewHolder(View arg2)
    {
      View localView;
      ButterKnife.inject(this, localView);
    }

    public void update(PaymentProfile paramPaymentProfile1, List<PaymentProfile> paramList, PaymentProfile paramPaymentProfile2)
    {
      Context localContext = this.mTextViewPaymentName.getContext();
      Drawable localDrawable1 = CreditCardUtils.getImage(localContext, paramPaymentProfile1.getCardType());
      this.mTextViewPaymentName.setCompoundDrawablesWithIntrinsicBounds(localDrawable1, null, null, null);
      this.mTextViewPaymentName.setText(paramPaymentProfile1.getDisplayText(PaymentProfileAdapter.this.mContext, paramList));
      RewardInfo localRewardInfo = paramPaymentProfile1.getRewardInfo();
      if ((localRewardInfo != null) && (localRewardInfo.isEnrolled()))
      {
        Drawable localDrawable2 = localContext.getResources().getDrawable(2130837838);
        this.mImageViewRewardsStatus.setImageDrawable(localDrawable2);
        this.mImageViewRewardsStatus.setVisibility(0);
        if ((localRewardInfo.isEarnOnly()) || (localRewardInfo.usePointsDisabled()))
          this.mTextViewRewardsStatus.setText(localContext.getString(2131558823));
        while (true)
        {
          this.mTextViewRewardsStatus.setVisibility(0);
          this.mTextViewLearnMore.setVisibility(8);
          this.mViewGroupRewards.setVisibility(0);
          return;
          this.mTextViewRewardsStatus.setText(localContext.getString(2131558821));
        }
      }
      if ((localRewardInfo != null) && (localRewardInfo.isEligible()))
      {
        this.mImageViewRewardsStatus.setVisibility(8);
        this.mTextViewRewardsStatus.setText(localContext.getString(2131558881).toUpperCase());
        this.mTextViewRewardsStatus.setVisibility(0);
        this.mTextViewLearnMore.setText(localContext.getString(2131558904));
        this.mTextViewLearnMore.setVisibility(0);
        this.mViewDivider.setVisibility(0);
        this.mViewGroupRewards.setVisibility(0);
        return;
      }
      this.mViewDivider.setVisibility(8);
      this.mViewGroupRewards.setVisibility(8);
    }
  }

  class ItemViewHolder
    implements PaymentProfileAdapter.ViewHolder
  {

    @InjectView(2131427621)
    CheckedTextView mCheckedTextView;

    ItemViewHolder(View paramBoolean, boolean arg3)
    {
      ButterKnife.inject(this, paramBoolean);
      int i;
      if (i == 0)
        this.mCheckedTextView.setCheckMarkDrawable(null);
    }

    public void update(PaymentProfile paramPaymentProfile1, List<PaymentProfile> paramList, PaymentProfile paramPaymentProfile2)
    {
      Drawable localDrawable = CreditCardUtils.getImage(this.mCheckedTextView.getContext(), paramPaymentProfile1.getCardType());
      this.mCheckedTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.mCheckedTextView.setText(paramPaymentProfile1.getDisplayText(PaymentProfileAdapter.this.mContext, paramList));
      if ((paramPaymentProfile2 != null) && (paramPaymentProfile1.getId().equals(paramPaymentProfile2.getId())));
      for (boolean bool = true; ; bool = false)
      {
        this.mCheckedTextView.setChecked(bool);
        return;
      }
    }
  }

  class MobileWalletViewHolder
    implements PaymentProfileAdapter.ViewHolder
  {

    @InjectView(2131427584)
    ProgressBar mProgressBarCurrentBalanceRequest;

    @InjectView(2131427623)
    RadioButton mRadioButtonItem;

    @InjectView(2131427583)
    UberTextView mTextViewCurrentBalanceValue;

    @InjectView(2131427622)
    UberTextView mTextViewProfile;

    MobileWalletViewHolder(View paramBoolean, boolean arg3)
    {
      ButterKnife.inject(this, paramBoolean);
      int i;
      if (i != 0)
      {
        this.mRadioButtonItem.setVisibility(0);
        return;
      }
      this.mRadioButtonItem.setVisibility(8);
    }

    public void update(PaymentProfile paramPaymentProfile1, List<PaymentProfile> paramList, PaymentProfile paramPaymentProfile2)
    {
      Drawable localDrawable = CreditCardUtils.getImage(this.mTextViewProfile.getContext(), paramPaymentProfile1.getCardType());
      this.mTextViewProfile.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.mTextViewProfile.setText(paramPaymentProfile1.getDisplayText(PaymentProfileAdapter.this.mContext, paramList));
      if (PaymentProfileAdapter.this.mPaymentProfileBalance != null)
        this.mProgressBarCurrentBalanceRequest.setVisibility(8);
      while (true)
      {
        this.mTextViewCurrentBalanceValue.setText(PaymentProfileAdapter.this.mPaymentProfileBalance);
        boolean bool1 = false;
        if (paramPaymentProfile2 != null)
        {
          boolean bool2 = paramPaymentProfile1.getId().equals(paramPaymentProfile2.getId());
          bool1 = false;
          if (bool2)
            bool1 = true;
        }
        this.mRadioButtonItem.setChecked(bool1);
        return;
        this.mProgressBarCurrentBalanceRequest.setVisibility(0);
      }
    }
  }

  class RewardsToggleViewHolder
    implements PaymentProfileAdapter.ViewHolder
  {
    private static final String CURRENCY_SYMBOL_PLACEHOLDER = "¤";

    @InjectView(2131427635)
    CheckedTextView mCheckedTextViewEarn;

    @InjectView(2131427632)
    CheckedTextView mCheckedTextViewEarning;

    @InjectView(2131427640)
    CheckedTextView mCheckedTextViewUse;

    @InjectView(2131427631)
    ImageView mImageViewCreditCard;

    @InjectView(2131427636)
    ImageView mImageViewRewardsEarn;

    @InjectView(2131427627)
    ImageView mImageViewRewardsStatus;
    private boolean mIsEarnOnly;
    private PaymentProfile mPaymentProfile;

    @InjectView(2131427633)
    UberTextView mTextViewPaymentName;

    @InjectView(2131427641)
    UberTextView mTextViewPointBalance;

    @InjectView(2131427637)
    UberTextView mTextViewRewardsEarn;

    @InjectView(2131427629)
    ViewGroup mViewGroupListItem;

    @InjectView(2131427634)
    ViewGroup mViewGroupRewardsEarn;

    @InjectView(2131427639)
    ViewGroup mViewGroupRewardsUse;

    @InjectView(2131427638)
    View mViewSeparator;

    RewardsToggleViewHolder(View arg2)
    {
      View localView;
      ButterKnife.inject(this, localView);
    }

    private String format(Balance paramBalance)
    {
      return new PointBalanceFormatter(PaymentProfileAdapter.this.mContext).format(paramBalance);
    }

    private void setChecked(Checkable paramCheckable)
    {
      Checkable[] arrayOfCheckable = new Checkable[3];
      arrayOfCheckable[0] = this.mCheckedTextViewEarning;
      arrayOfCheckable[1] = this.mCheckedTextViewEarn;
      arrayOfCheckable[2] = this.mCheckedTextViewUse;
      int i = arrayOfCheckable.length;
      for (int j = 0; j < i; j++)
      {
        Checkable localCheckable = arrayOfCheckable[j];
        localCheckable.setChecked(localCheckable.equals(paramCheckable));
      }
    }

    private void setEarnAndUsePointsVisibility()
    {
      this.mViewGroupListItem.setBackgroundResource(0);
      this.mViewGroupRewardsEarn.setBackgroundResource(2130837836);
      this.mCheckedTextViewEarning.setVisibility(8);
      this.mImageViewRewardsStatus.setVisibility(0);
      this.mImageViewRewardsEarn.setVisibility(8);
      this.mCheckedTextViewEarn.setVisibility(0);
      this.mViewGroupRewardsEarn.setClickable(true);
    }

    private void setEarnOnlyVisibility()
    {
      this.mViewGroupListItem.setBackgroundResource(2130837836);
      this.mViewGroupRewardsEarn.setBackgroundResource(0);
      this.mCheckedTextViewEarning.setVisibility(0);
      this.mImageViewRewardsStatus.setVisibility(8);
      this.mImageViewRewardsEarn.setVisibility(0);
      this.mCheckedTextViewEarn.setVisibility(8);
      this.mViewGroupRewardsEarn.setClickable(false);
    }

    private void uncheckAll()
    {
      setChecked(null);
    }

    @OnClick({2131427634})
    public void onClickEarn()
    {
      this.mCheckedTextViewEarn.setChecked(true);
      this.mCheckedTextViewUse.setChecked(false);
      PaymentProfileAdapter.this.mBus.post(new PaymentProfileSelectedEvent(this.mPaymentProfile, false));
    }

    @OnClick({2131427629})
    public void onClickPayment()
    {
      if (this.mIsEarnOnly)
      {
        this.mCheckedTextViewEarning.setChecked(true);
        PaymentProfileAdapter.this.mBus.post(new PaymentProfileSelectedEvent(this.mPaymentProfile, false));
      }
    }

    @OnClick({2131427639})
    public void onClickUse()
    {
      this.mCheckedTextViewEarn.setChecked(false);
      this.mCheckedTextViewUse.setChecked(true);
      PaymentProfileAdapter.this.mBus.post(new PaymentProfileSelectedEvent(this.mPaymentProfile, true));
    }

    public void update(PaymentProfile paramPaymentProfile1, List<PaymentProfile> paramList, PaymentProfile paramPaymentProfile2)
    {
      this.mPaymentProfile = paramPaymentProfile1;
      Context localContext = this.mTextViewPaymentName.getContext();
      Drawable localDrawable = CreditCardUtils.getImage(localContext, paramPaymentProfile1.getCardType());
      this.mImageViewCreditCard.setImageDrawable(localDrawable);
      this.mTextViewPaymentName.setText(paramPaymentProfile1.getDisplayText(PaymentProfileAdapter.this.mContext, paramList));
      RewardInfo localRewardInfo = paramPaymentProfile1.getRewardInfo();
      boolean bool;
      int i;
      if ((localRewardInfo != null) && ((localRewardInfo.isEarnOnly()) || (localRewardInfo.usePointsDisabled())))
      {
        bool = true;
        this.mIsEarnOnly = bool;
        if ((paramPaymentProfile2 == null) || (!paramPaymentProfile1.getId().equals(paramPaymentProfile2.getId())))
          break label180;
        i = 1;
        label110: if ((i == 0) || (!this.mIsEarnOnly))
          break label186;
        setChecked(this.mCheckedTextViewEarning);
      }
      while (true)
      {
        if (!this.mIsEarnOnly)
          break label232;
        this.mTextViewRewardsEarn.setText(localContext.getString(2131558823));
        setEarnOnlyVisibility();
        this.mViewSeparator.setVisibility(8);
        this.mViewGroupRewardsUse.setVisibility(8);
        return;
        bool = false;
        break;
        label180: i = 0;
        break label110;
        label186: if (i != 0)
        {
          if (PaymentProfileAdapter.this.mIsUsingPoints);
          for (CheckedTextView localCheckedTextView = this.mCheckedTextViewUse; ; localCheckedTextView = this.mCheckedTextViewEarn)
          {
            setChecked(localCheckedTextView);
            break;
          }
        }
        uncheckAll();
      }
      label232: this.mTextViewRewardsEarn.setText(localContext.getString(2131558820).toUpperCase());
      setEarnAndUsePointsVisibility();
      this.mCheckedTextViewUse.setText(localContext.getString(2131559324));
      this.mViewSeparator.setVisibility(0);
      this.mViewGroupRewardsUse.setVisibility(0);
      if (localRewardInfo.hasBalance())
      {
        Balance localBalance = localRewardInfo.getBalance();
        this.mTextViewPointBalance.setText(format(localBalance));
        return;
      }
      this.mTextViewPointBalance.setText(localContext.getString(2131558461));
    }
  }

  static abstract interface ViewHolder
  {
    public abstract void update(PaymentProfile paramPaymentProfile1, List<PaymentProfile> paramList, PaymentProfile paramPaymentProfile2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentProfileAdapter
 * JD-Core Version:    0.6.2
 */