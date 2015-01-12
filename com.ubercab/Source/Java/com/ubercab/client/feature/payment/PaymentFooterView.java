package com.ubercab.client.feature.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.feature.payment.event.SelectExpenseInfoEvent;
import com.ubercab.client.feature.payment.event.SelectPromoCodeEvent;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import javax.inject.Inject;

public class PaymentFooterView extends LinearLayout
{

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;

  @InjectView(2131427566)
  Button mExpenseInfoButton;

  @InjectView(2131427567)
  Button mPromoButton;

  public PaymentFooterView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PaymentFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PaymentFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      UberApplication.get(paramContext).inject(this);
  }

  void hideExpenseInfoButton()
  {
    if (this.mPromoButton.getVisibility() == 0)
    {
      int i = this.mPromoButton.getPaddingLeft();
      int j = this.mPromoButton.getPaddingRight();
      int k = this.mPromoButton.getPaddingTop();
      int m = this.mPromoButton.getPaddingBottom();
      this.mPromoButton.setBackgroundResource(2130837684);
      this.mPromoButton.setPadding(i, k, j, m);
    }
    this.mExpenseInfoButton.setVisibility(8);
  }

  void hidePromoButton()
  {
    if (this.mExpenseInfoButton.getVisibility() == 0)
    {
      int i = this.mExpenseInfoButton.getPaddingLeft();
      int j = this.mExpenseInfoButton.getPaddingRight();
      int k = this.mExpenseInfoButton.getPaddingTop();
      int m = this.mExpenseInfoButton.getPaddingBottom();
      this.mExpenseInfoButton.setBackgroundResource(2130837684);
      this.mExpenseInfoButton.setPadding(i, k, j, m);
    }
    this.mPromoButton.setVisibility(8);
  }

  @OnClick({2131427566})
  public void onClickExpenseInfo()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EXPENSE_BUTTON_PAYMENT);
    this.mBus.post(new SelectExpenseInfoEvent(null, false));
  }

  @OnClick({2131427567})
  public void onClickPromoApply()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PROMO_CODE_OPEN_PAYMENT_LIST);
    this.mBus.post(new SelectPromoCodeEvent());
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    this.mExpenseInfoButton.setText(getContext().getString(2131558848));
    this.mPromoButton.setText(getContext().getString(2131559015));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentFooterView
 * JD-Core Version:    0.6.2
 */