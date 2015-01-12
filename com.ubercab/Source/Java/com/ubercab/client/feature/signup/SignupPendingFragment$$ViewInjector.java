package com.ubercab.client.feature.signup;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class SignupPendingFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignupPendingFragment paramSignupPendingFragment, Object paramObject)
  {
    paramSignupPendingFragment.mExplanation = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427747, "field 'mExplanation'"));
    paramSignupPendingFragment.mEmail = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427748, "field 'mEmail'"));
    paramSignupPendingFragment.mNextSteps = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427749, "field 'mNextSteps'"));
    View localView = paramFinder.findRequiredView(paramObject, 2131427750, "field 'mDoneButton' and method 'onClickDone'");
    paramSignupPendingFragment.mDoneButton = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickDone();
      }
    });
  }

  public static void reset(SignupPendingFragment paramSignupPendingFragment)
  {
    paramSignupPendingFragment.mExplanation = null;
    paramSignupPendingFragment.mEmail = null;
    paramSignupPendingFragment.mNextSteps = null;
    paramSignupPendingFragment.mDoneButton = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPendingFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */