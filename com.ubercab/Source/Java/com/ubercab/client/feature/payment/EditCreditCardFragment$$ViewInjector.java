package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.payment.ui.CreditCardEditText;
import com.ubercab.payment.ui.SecurityCodeEditText;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class EditCreditCardFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, EditCreditCardFragment paramEditCreditCardFragment, Object paramObject)
  {
    paramEditCreditCardFragment.mEditTextZip = ((ZipEditText)paramFinder.findRequiredView(paramObject, 2131427574, "field 'mEditTextZip'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427605, "field 'mButtonDelete' and method 'onClickButtonDelete'");
    paramEditCreditCardFragment.mButtonDelete = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonDelete();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427604, "field 'mButtonEnrollMe' and method 'onClickEnrollMe'");
    paramEditCreditCardFragment.mButtonEnrollMe = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickEnrollMe();
      }
    });
    paramEditCreditCardFragment.mSpinnerUseCase = ((Spinner)paramFinder.findRequiredView(paramObject, 2131427599, "field 'mSpinnerUseCase'"));
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427575, "field 'mButtonCountry' and method 'onClickCountry'");
    paramEditCreditCardFragment.mButtonCountry = ((CountryButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickCountry();
      }
    });
    paramEditCreditCardFragment.mEditTextExpirationYear = ((YearEditText)paramFinder.findRequiredView(paramObject, 2131427572, "field 'mEditTextExpirationYear'"));
    paramEditCreditCardFragment.mEditTextExpirationMonth = ((MonthEditText)paramFinder.findRequiredView(paramObject, 2131427570, "field 'mEditTextExpirationMonth'"));
    paramEditCreditCardFragment.mEditTextCreditCardCode = ((SecurityCodeEditText)paramFinder.findRequiredView(paramObject, 2131427573, "field 'mEditTextCreditCardCode'"));
    paramEditCreditCardFragment.mEditTextCreditCardNumber = ((CreditCardEditText)paramFinder.findRequiredView(paramObject, 2131427569, "field 'mEditTextCreditCardNumber'"));
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427603, "field 'mSwitchUsePoints' and method 'onUsePointsToggled'");
    paramEditCreditCardFragment.mSwitchUsePoints = ((Switch)localView4);
    ((CompoundButton)localView4).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        this.val$target.onUsePointsToggled(paramAnonymousBoolean);
      }
    });
    paramEditCreditCardFragment.mTextViewRewardsStatus = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427600, "field 'mTextViewRewardsStatus'"));
    paramEditCreditCardFragment.mTextViewUsePoints = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427602, "field 'mTextViewUsePoints'"));
    paramEditCreditCardFragment.mViewGroupUsePoints = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427601, "field 'mViewGroupUsePoints'"));
    paramEditCreditCardFragment.mTextViewRewardLink = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427608, "field 'mTextViewRewardLink'"));
    paramEditCreditCardFragment.mTextViewRewardRestrictions = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427607, "field 'mTextViewRewardRestrictions'"));
    View localView5 = paramFinder.findRequiredView(paramObject, 2131427606, "field 'mViewGroupRewardRestrictions' and method 'onClickTerms'");
    paramEditCreditCardFragment.mViewGroupRewardRestrictions = ((ViewGroup)localView5);
    localView5.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickTerms();
      }
    });
  }

  public static void reset(EditCreditCardFragment paramEditCreditCardFragment)
  {
    paramEditCreditCardFragment.mEditTextZip = null;
    paramEditCreditCardFragment.mButtonDelete = null;
    paramEditCreditCardFragment.mButtonEnrollMe = null;
    paramEditCreditCardFragment.mSpinnerUseCase = null;
    paramEditCreditCardFragment.mButtonCountry = null;
    paramEditCreditCardFragment.mEditTextExpirationYear = null;
    paramEditCreditCardFragment.mEditTextExpirationMonth = null;
    paramEditCreditCardFragment.mEditTextCreditCardCode = null;
    paramEditCreditCardFragment.mEditTextCreditCardNumber = null;
    paramEditCreditCardFragment.mSwitchUsePoints = null;
    paramEditCreditCardFragment.mTextViewRewardsStatus = null;
    paramEditCreditCardFragment.mTextViewUsePoints = null;
    paramEditCreditCardFragment.mViewGroupUsePoints = null;
    paramEditCreditCardFragment.mTextViewRewardLink = null;
    paramEditCreditCardFragment.mTextViewRewardRestrictions = null;
    paramEditCreditCardFragment.mViewGroupRewardRestrictions = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditCreditCardFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */