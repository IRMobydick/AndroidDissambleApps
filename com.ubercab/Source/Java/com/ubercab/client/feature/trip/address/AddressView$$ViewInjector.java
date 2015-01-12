package com.ubercab.client.feature.trip.address;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class AddressView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AddressView paramAddressView, Object paramObject)
  {
    paramAddressView.mViewIcon = paramFinder.findRequiredView(paramObject, 2131427818, "field 'mViewIcon'");
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427850, "field 'mImageButtonAdd' and method 'onClickAdd'");
    paramAddressView.mImageButtonAdd = ((ImageButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAdd();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427849, "field 'mImageButtonClear' and method 'onClickClear'");
    paramAddressView.mImageButtonClear = ((ImageButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickClear();
      }
    });
    paramAddressView.mTextViewAddress = ((AddressTextView)paramFinder.findRequiredView(paramObject, 2131427820, "field 'mTextViewAddress'"));
    paramAddressView.mTextViewLabel = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427819, "field 'mTextViewLabel'"));
    paramAddressView.mTextViewSubtext = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427851, "field 'mTextViewSubtext'"));
  }

  public static void reset(AddressView paramAddressView)
  {
    paramAddressView.mViewIcon = null;
    paramAddressView.mImageButtonAdd = null;
    paramAddressView.mImageButtonClear = null;
    paramAddressView.mTextViewAddress = null;
    paramAddressView.mTextViewLabel = null;
    paramAddressView.mTextViewSubtext = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.address.AddressView..ViewInjector
 * JD-Core Version:    0.6.2
 */