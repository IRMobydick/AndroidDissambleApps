package com.ubercab.client.feature.signup;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;

public class VerifyFacebookProfileFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, VerifyFacebookProfileFragment paramVerifyFacebookProfileFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427727, "field 'mButtonNext' and method 'onNextClicked'");
    paramVerifyFacebookProfileFragment.mButtonNext = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onNextClicked();
      }
    });
    paramVerifyFacebookProfileFragment.mEditTextEmail = ((AutoCompleteTextView)paramFinder.findRequiredView(paramObject, 2131427761, "field 'mEditTextEmail'"));
    paramVerifyFacebookProfileFragment.mEditTextFirstName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427722, "field 'mEditTextFirstName'"));
    paramVerifyFacebookProfileFragment.mEditTextLastName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427723, "field 'mEditTextLastName'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427726, "field 'mEditTextPhone' and method 'onEditorActionPhone'");
    paramVerifyFacebookProfileFragment.mEditTextPhone = ((UberEditText)localView2);
    ((TextView)localView2).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return this.val$target.onEditorActionPhone();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427725, "field 'mFlagButtonCountry' and method 'onFlagClicked'");
    paramVerifyFacebookProfileFragment.mFlagButtonCountry = ((FlagButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onFlagClicked();
      }
    });
  }

  public static void reset(VerifyFacebookProfileFragment paramVerifyFacebookProfileFragment)
  {
    paramVerifyFacebookProfileFragment.mButtonNext = null;
    paramVerifyFacebookProfileFragment.mEditTextEmail = null;
    paramVerifyFacebookProfileFragment.mEditTextFirstName = null;
    paramVerifyFacebookProfileFragment.mEditTextLastName = null;
    paramVerifyFacebookProfileFragment.mEditTextPhone = null;
    paramVerifyFacebookProfileFragment.mFlagButtonCountry = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.VerifyFacebookProfileFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */