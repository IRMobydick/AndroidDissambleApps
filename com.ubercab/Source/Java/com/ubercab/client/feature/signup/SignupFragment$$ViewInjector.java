package com.ubercab.client.feature.signup;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class SignupFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignupFragment paramSignupFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427727, "field 'mButtonNext' and method 'onNextClicked'");
    paramSignupFragment.mButtonNext = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onNextClicked();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427757, "field 'mButtonFacebook' and method 'onFacebookSignupClicked'");
    paramSignupFragment.mButtonFacebook = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onFacebookSignupClicked();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427756, "field 'mButtonGoogle' and method 'onGoogleSigninClicked'");
    paramSignupFragment.mButtonGoogle = ((UberButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onGoogleSigninClicked();
      }
    });
    paramSignupFragment.mTextViewOr = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewOr'"));
    paramSignupFragment.mEditTextPhone = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427726, "field 'mEditTextPhone'"));
    paramSignupFragment.mViewGroupContent = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427721, "field 'mViewGroupContent'"));
    paramSignupFragment.mEditTextLastName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427723, "field 'mEditTextLastName'"));
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427725, "field 'mFlagButtonCountry' and method 'onFlagClicked'");
    paramSignupFragment.mFlagButtonCountry = ((FlagButton)localView4);
    localView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onFlagClicked();
      }
    });
    View localView5 = paramFinder.findRequiredView(paramObject, 2131427762, "field 'mEditTextPassword' and method 'onPasswordEditorAction'");
    paramSignupFragment.mEditTextPassword = ((UberEditText)localView5);
    ((TextView)localView5).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return this.val$target.onPasswordEditorAction();
      }
    });
    paramSignupFragment.mEditTextEmail = ((AutoCompleteTextView)paramFinder.findRequiredView(paramObject, 2131427761, "field 'mEditTextEmail'"));
    paramSignupFragment.mEditTextFirstName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427722, "field 'mEditTextFirstName'"));
    paramSignupFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427763, "field 'mProgressBarLoading'"));
    paramSignupFragment.mViewGroupThirdPartySignIn = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427755, "field 'mViewGroupThirdPartySignIn'"));
    paramSignupFragment.mNameTwoFields = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427758, "field 'mNameTwoFields'"));
    paramSignupFragment.mNameOneFields = ((LinearLayout)paramFinder.findRequiredView(paramObject, 2131427759, "field 'mNameOneFields'"));
    paramSignupFragment.mEditTextFullName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427760, "field 'mEditTextFullName'"));
  }

  public static void reset(SignupFragment paramSignupFragment)
  {
    paramSignupFragment.mButtonNext = null;
    paramSignupFragment.mButtonFacebook = null;
    paramSignupFragment.mButtonGoogle = null;
    paramSignupFragment.mTextViewOr = null;
    paramSignupFragment.mEditTextPhone = null;
    paramSignupFragment.mViewGroupContent = null;
    paramSignupFragment.mEditTextLastName = null;
    paramSignupFragment.mFlagButtonCountry = null;
    paramSignupFragment.mEditTextPassword = null;
    paramSignupFragment.mEditTextEmail = null;
    paramSignupFragment.mEditTextFirstName = null;
    paramSignupFragment.mProgressBarLoading = null;
    paramSignupFragment.mViewGroupThirdPartySignIn = null;
    paramSignupFragment.mNameTwoFields = null;
    paramSignupFragment.mNameOneFields = null;
    paramSignupFragment.mEditTextFullName = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */