package com.ubercab.client.feature.payment;

import com.ubercab.library.app.UberActivity;
import com.ubercab.library.ui.ConfirmDialogFragment;
import javax.inject.Inject;

public final class DeletePaymentDialogPresenter
{
  public void show(UberActivity paramUberActivity, int paramInt)
  {
    ConfirmDialogFragment.show(paramUberActivity, paramInt, paramUberActivity.getString(2131558515), paramUberActivity.getString(2131558800), paramUberActivity.getString(2131558799), paramUberActivity.getString(2131558467));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.DeletePaymentDialogPresenter
 * JD-Core Version:    0.6.2
 */