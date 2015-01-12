package com.ubercab.client.feature.payment;

import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.common.collect.ObjectArrays;

abstract class PaymentBaseActivity extends RiderPingActivity
{
  protected Object[] getModules()
  {
    return ObjectArrays.concat(super.getModules(), new PaymentModule());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentBaseActivity
 * JD-Core Version:    0.6.2
 */