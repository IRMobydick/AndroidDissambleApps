package com.ubercab.client.feature.payment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.ClientTransaction;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.UnpaidBill;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;

public class ArrearsView extends LinearLayout
{

  @InjectView(2131427646)
  UberTextView mTextViewArrearsAmount;

  @InjectView(2131427645)
  UberTextView mTextViewArrearsMessage;
  private ArrayList<UnpaidBill> mUnpaidBills;

  public ArrearsView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ArrearsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ArrearsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private String getArrearsAmount()
  {
    String str = getContext().getString(2131559292);
    if (this.mUnpaidBills.isEmpty());
    ClientTransaction localClientTransaction;
    do
    {
      return str;
      localClientTransaction = ((UnpaidBill)this.mUnpaidBills.get(0)).getClientTransaction();
    }
    while (localClientTransaction == null);
    return localClientTransaction.getDisplayAmount();
  }

  private String getArrearsMessage(Ping paramPing)
  {
    int i;
    Context localContext;
    String str2;
    if ((GoogleWalletActivity.isEligible(getContext())) && (paramPing.getClient().isLastSelectedPaymentProfileGoogleWallet()))
    {
      i = 1;
      localContext = getContext();
      if (i == 0)
        break label74;
      str2 = localContext.getString(2131558454);
    }
    while (true)
    {
      return str2 + " " + localContext.getString(2131558456);
      i = 0;
      break;
      label74: String str1 = paramPing.getClient().getLastSelectedPaymentProfileId();
      PaymentProfile localPaymentProfile = paramPing.getClient().findPaymentProfileWithId(str1);
      if (localPaymentProfile == null)
      {
        str2 = localContext.getString(2131558453, new Object[] { localContext.getString(2131559293) });
      }
      else if ("PayPal".equals(localPaymentProfile.getCardType()))
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localPaymentProfile.getAccountName();
        str2 = localContext.getString(2131558455, arrayOfObject2);
      }
      else
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localPaymentProfile.getCardNumber();
        str2 = localContext.getString(2131558453, arrayOfObject1);
      }
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  public void setUnpaidBills(ArrayList<UnpaidBill> paramArrayList)
  {
    this.mUnpaidBills = paramArrayList;
  }

  public void update(Ping paramPing)
  {
    this.mTextViewArrearsMessage.setText(getArrearsMessage(paramPing));
    this.mTextViewArrearsAmount.setText(getArrearsAmount());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ArrearsView
 * JD-Core Version:    0.6.2
 */