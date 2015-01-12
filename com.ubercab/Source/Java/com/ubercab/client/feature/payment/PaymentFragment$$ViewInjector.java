package com.ubercab.client.feature.payment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;

public class PaymentFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentFragment paramPaymentFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427568, "field 'mListView' and method 'onItemClick'");
    paramPaymentFragment.mListView = ((ListView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onItemClick(paramAnonymousInt);
      }
    });
  }

  public static void reset(PaymentFragment paramPaymentFragment)
  {
    paramPaymentFragment.mListView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */