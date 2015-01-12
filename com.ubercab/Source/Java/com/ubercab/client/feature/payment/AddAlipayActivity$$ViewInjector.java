package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class AddAlipayActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AddAlipayActivity paramAddAlipayActivity, Object paramObject)
  {
    paramAddAlipayActivity.mEditTextAccountId = ((AutoCompleteTextView)paramFinder.findRequiredView(paramObject, 2131427553, "field 'mEditTextAccountId'"));
    paramAddAlipayActivity.mEditTextMobile = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427556, "field 'mEditTextMobile'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427557, "field 'mButtonSubmit' and method 'onSubmitTapped'");
    paramAddAlipayActivity.mButtonSubmit = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onSubmitTapped();
      }
    });
    paramAddAlipayActivity.mTextLegalDescription = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427558, "field 'mTextLegalDescription'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427559, "field 'mButtonLegal' and method 'onLegalClicked'");
    paramAddAlipayActivity.mButtonLegal = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onLegalClicked();
      }
    });
    paramAddAlipayActivity.mTextAlipayAccountLabel = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427552, "field 'mTextAlipayAccountLabel'"));
    paramAddAlipayActivity.mTextAlipayPhoneLabel = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427555, "field 'mTextAlipayPhoneLabel'"));
    paramAddAlipayActivity.mLayoutAlipayPhoneLayout = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427554, "field 'mLayoutAlipayPhoneLayout'"));
  }

  public static void reset(AddAlipayActivity paramAddAlipayActivity)
  {
    paramAddAlipayActivity.mEditTextAccountId = null;
    paramAddAlipayActivity.mEditTextMobile = null;
    paramAddAlipayActivity.mButtonSubmit = null;
    paramAddAlipayActivity.mTextLegalDescription = null;
    paramAddAlipayActivity.mButtonLegal = null;
    paramAddAlipayActivity.mTextAlipayAccountLabel = null;
    paramAddAlipayActivity.mTextAlipayPhoneLabel = null;
    paramAddAlipayActivity.mLayoutAlipayPhoneLayout = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddAlipayActivity..ViewInjector
 * JD-Core Version:    0.6.2
 */