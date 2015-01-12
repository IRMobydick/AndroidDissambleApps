package com.ubercab.client.feature.trip.confirm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Balance;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.ui.PaymentTextView;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResource;
import com.ubercab.client.feature.payment.reward.PointBalanceFormatter;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.payment.util.CreditCardUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class ConfirmationView extends LinearLayout
{
  private static final int TAB_EARN_POINTS = 0;
  private static final int TAB_USE_POINTS = 1;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @InjectView(2131427868)
  UberButton mButtonRequest;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();

  @InjectView(16908306)
  TabHost mTabHost;

  @InjectView(2131427869)
  UberTextView mTextEta;

  @InjectView(2131427865)
  UberTextView mTextViewFareQuote;

  @InjectView(2131427859)
  PaymentTextView mTextViewPayment;

  @InjectView(2131427862)
  UberTextView mTextViewPaymentCredits;

  @InjectView(2131427856)
  UberTextView mTextViewPaymentNotIncluded;

  @InjectView(2131427861)
  UberTextView mTextViewPointBalance;

  @InjectView(2131427867)
  UberTextView mTextViewPromo;

  @InjectView(2131427857)
  UberTextView mTextViewRewardsDoNotApply;

  @InjectView(2131427863)
  ViewGroup mViewGroupButtons;

  @InjectView(2131427858)
  ViewGroup mViewGroupPayment;

  @InjectView(2131427855)
  ViewGroup mViewGroupPaymentDisclosure;

  @InjectView(2131427860)
  ViewGroup mViewGroupPointBalance;

  public ConfirmationView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ConfirmationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!isInEditMode())
      UberApplication.get(paramContext).inject(this);
  }

  private TabHost.TabSpec createTab(String paramString1, int paramInt, String paramString2)
  {
    return this.mTabHost.newTabSpec(paramString1).setIndicator(createTabView(paramInt, paramString2)).setContent(16908305);
  }

  private View createTabView(int paramInt, String paramString)
  {
    View localView = LayoutInflater.from(getContext()).inflate(paramInt, null);
    ((UberTextView)localView.findViewById(2131427765)).setText(paramString);
    return localView;
  }

  private void setupTabs()
  {
    this.mTabHost.setup();
    this.mTabHost.getTabWidget().setDividerDrawable(null);
    this.mTabHost.addTab(createTab("earn_2x_points", 2130903187, getContext().getString(2131558820)));
    this.mTabHost.addTab(createTab("use_points", 2130903188, getContext().getString(2131559324)));
    this.mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
    {
      public void onTabChanged(String paramAnonymousString)
      {
        switch (ConfirmationView.this.mTabHost.getCurrentTab())
        {
        default:
        case 0:
        case 1:
        }
        while (true)
        {
          return;
          Iterator localIterator2 = ConfirmationView.this.mListeners.iterator();
          while (localIterator2.hasNext())
            ((ConfirmationView.Listener)localIterator2.next()).onEarnPointsClicked();
          continue;
          Iterator localIterator1 = ConfirmationView.this.mListeners.iterator();
          while (localIterator1.hasNext())
            ((ConfirmationView.Listener)localIterator1.next()).onUsePointsClicked();
        }
      }
    });
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  @OnClick({2131427864})
  public void onClickButtonFareQuote()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onFareQuoteClicked(this);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_DROPOFF_OPEN_PRODUCTDETAIL);
  }

  @OnClick({2131427858})
  public void onClickPaymentButton()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onSelectPaymentClicked(this);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_BUTTON_CONFIRM);
  }

  @OnClick({2131427866})
  public void onClickPromoButton()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PROMO_CODE_OPEN_CONFIRM);
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onPromoCodeClicked(this);
  }

  @OnClick({2131427868})
  public void onClickRequestButton()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PRODUCT_REQUEST);
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onRequestUberClicked(this);
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    Context localContext = getContext();
    this.mTextViewFareQuote.setText(localContext.getString(2131558852));
    this.mTextViewPromo.setText(localContext.getString(2131559015));
    this.mTextViewPaymentCredits.setText(localContext.getString(2131558791));
    setupTabs();
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setIsSendExpense(boolean paramBoolean, ExpenseLinkResource paramExpenseLinkResource)
  {
    if ((paramExpenseLinkResource != null) && (paramBoolean));
    for (int i = 1; i != 0; i = 0)
    {
      this.mTextViewPayment.setInlineRightDrawable(paramExpenseLinkResource.getDrawableIcon());
      return;
    }
    this.mTextViewPayment.setInlineRightDrawable(0);
  }

  public void setIsUsingCredits(boolean paramBoolean1, boolean paramBoolean2)
  {
    UberTextView localUberTextView;
    if (paramBoolean1)
    {
      this.mTextViewPaymentCredits.setBackgroundResource(2130837730);
      localUberTextView = this.mTextViewPaymentCredits;
      if (!paramBoolean2)
        break label46;
    }
    label46: for (int i = 0; ; i = 8)
    {
      localUberTextView.setVisibility(i);
      return;
      this.mTextViewPaymentCredits.setBackgroundResource(2130837729);
      break;
    }
  }

  public void setIsUsingPoints(boolean paramBoolean, PaymentProfile paramPaymentProfile)
  {
    TabHost localTabHost = this.mTabHost;
    int i;
    if (paramBoolean)
    {
      i = 1;
      localTabHost.setCurrentTab(i);
      if (!paramBoolean)
        break label153;
      RewardInfo localRewardInfo = paramPaymentProfile.getRewardInfo();
      if ((localRewardInfo == null) || (!localRewardInfo.isEnrolled()) || (localRewardInfo.isEarnOnly()))
        break label135;
      if (!localRewardInfo.hasBalance())
        break label115;
      Balance localBalance = localRewardInfo.getBalance();
      PointBalanceFormatter localPointBalanceFormatter = new PointBalanceFormatter(getContext());
      this.mTextViewPointBalance.setText(localPointBalanceFormatter.format(localBalance));
    }
    while (true)
    {
      this.mTextViewPayment.setVisibility(8);
      this.mViewGroupPointBalance.setVisibility(0);
      return;
      i = 0;
      break;
      label115: this.mTextViewPointBalance.setText(getContext().getString(2131558461));
    }
    label135: this.mTextViewPayment.setVisibility(0);
    this.mViewGroupPointBalance.setVisibility(8);
    return;
    label153: this.mTextViewPayment.setVisibility(0);
    this.mViewGroupPointBalance.setVisibility(8);
  }

  public void setPaymentProfile(PaymentProfile paramPaymentProfile, List<PaymentProfile> paramList)
  {
    if (paramPaymentProfile == null)
    {
      this.mTextViewPayment.setText(getContext().getString(2131558941));
      Drawable localDrawable2 = CreditCardUtils.getImage(getContext(), "");
      this.mTextViewPayment.setLeftDrawable(localDrawable2);
      return;
    }
    Drawable localDrawable1 = CreditCardUtils.getImage(getContext(), paramPaymentProfile.getCardType());
    this.mTextViewPayment.setLeftDrawable(localDrawable1);
    this.mTextViewPayment.setText(paramPaymentProfile.getDisplayText(getContext(), paramList));
  }

  public void updateClosestVehicleEta(Ping paramPing, VehicleView paramVehicleView)
  {
    NearbyVehicle localNearbyVehicle = (NearbyVehicle)paramPing.getNearbyVehicles().get(paramVehicleView.getId());
    if (localNearbyVehicle == null)
      return;
    String str = localNearbyVehicle.getEtaString();
    if (!TextUtils.isEmpty(str))
    {
      this.mTextEta.setText(paramVehicleView.getFormattedPickupEtaString(str));
      this.mTextEta.setVisibility(0);
      return;
    }
    this.mTextEta.setText(2131559290);
    this.mTextEta.setVisibility(8);
  }

  public void updateRequestUberButton(VehicleView paramVehicleView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(paramVehicleView.getFormattedRequestPickupButtonString()))
      localSpannableStringBuilder.append(paramVehicleView.getFormattedRequestPickupButtonString());
    if (paramVehicleView.isSurging())
    {
      Drawable localDrawable = getResources().getDrawable(2130837683);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      ImageSpan localImageSpan = new ImageSpan(localDrawable, 0);
      String str = getContext().getString(2131559096);
      localSpannableStringBuilder.insert(0, str);
      localSpannableStringBuilder.setSpan(localImageSpan, 0, str.length(), 17);
      localSpannableStringBuilder.insert(str.length(), " ");
      this.mButtonRequest.setGravity(49);
    }
    while (true)
    {
      this.mButtonRequest.setText(localSpannableStringBuilder);
      return;
      this.mButtonRequest.setGravity(17);
    }
  }

  public void updateUI(boolean paramBoolean1, boolean paramBoolean2, VehicleView paramVehicleView)
  {
    int i = this.mViewGroupPayment.getPaddingLeft();
    int j = this.mViewGroupPayment.getPaddingRight();
    int k = this.mViewGroupPayment.getPaddingTop();
    int m = this.mViewGroupPayment.getPaddingBottom();
    int n;
    label124: int i1;
    label157: int i2;
    label182: ViewGroup localViewGroup2;
    int i3;
    if ((paramVehicleView != null) && (paramVehicleView.isCashOnly()))
    {
      n = 1;
      if (n != 0)
      {
        this.mTextViewPaymentNotIncluded.setText(getContext().getString(2131558990));
        this.mTextViewRewardsDoNotApply.setText(getContext().getString(2131559040));
        this.mTextViewPayment.setVisibility(0);
        this.mViewGroupPointBalance.setVisibility(8);
      }
      if (!paramBoolean2)
        break label229;
      if (!paramBoolean1)
        break label216;
      this.mViewGroupPayment.setBackgroundResource(2130837699);
      this.mViewGroupPayment.setPadding(i, k, j, m);
      ViewGroup localViewGroup1 = this.mViewGroupPaymentDisclosure;
      if ((!paramBoolean2) || (n == 0))
        break label259;
      i1 = 0;
      localViewGroup1.setVisibility(i1);
      TabHost localTabHost = this.mTabHost;
      if ((!paramBoolean2) || (n != 0))
        break label266;
      i2 = 0;
      localTabHost.setVisibility(i2);
      localViewGroup2 = this.mViewGroupButtons;
      i3 = 0;
      if (!paramBoolean1)
        break label273;
    }
    while (true)
    {
      localViewGroup2.setVisibility(i3);
      return;
      n = 0;
      break;
      label216: this.mViewGroupPayment.setBackgroundResource(2130837686);
      break label124;
      label229: if (paramBoolean1)
      {
        this.mViewGroupPayment.setBackgroundResource(2130837716);
        break label124;
      }
      this.mViewGroupPayment.setBackgroundResource(2130837684);
      break label124;
      label259: i1 = 8;
      break label157;
      label266: i2 = 8;
      break label182;
      label273: i3 = 8;
    }
  }

  public static abstract interface Listener
  {
    public abstract void onEarnPointsClicked();

    public abstract void onFareQuoteClicked(ConfirmationView paramConfirmationView);

    public abstract void onPromoCodeClicked(ConfirmationView paramConfirmationView);

    public abstract void onRequestUberClicked(ConfirmationView paramConfirmationView);

    public abstract void onSelectPaymentClicked(ConfirmationView paramConfirmationView);

    public abstract void onUsePointsClicked();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.confirm.ConfirmationView
 * JD-Core Version:    0.6.2
 */