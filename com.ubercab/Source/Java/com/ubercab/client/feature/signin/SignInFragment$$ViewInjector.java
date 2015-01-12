package com.ubercab.client.feature.signin;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class SignInFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignInFragment paramSignInFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427719, "field 'mButtonSignIn' and method 'onClickButtonNext'");
    paramSignInFragment.mButtonSignIn = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonNext();
      }
    });
    paramSignInFragment.mTextViewOr = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewOr'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427715, "field 'mButtonGoogle' and method 'onClickButtonGoogle'");
    paramSignInFragment.mButtonGoogle = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonGoogle();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427716, "field 'mButtonFacebook' and method 'onClickButtonFacebook'");
    paramSignInFragment.mButtonFacebook = ((UberButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonFacebook();
      }
    });
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427720, "field 'mButtonForgotPass' and method 'onClickForgotPass'");
    paramSignInFragment.mButtonForgotPass = ((UberButton)localView4);
    localView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickForgotPass();
      }
    });
    View localView5 = paramFinder.findRequiredView(paramObject, 2131427718, "field 'mEditTextPassword' and method 'onEditorActionPassword'");
    paramSignInFragment.mEditTextPassword = ((UberEditText)localView5);
    ((TextView)localView5).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return this.val$target.onEditorActionPassword(paramAnonymousInt);
      }
    });
    paramSignInFragment.mTextViewEmail = ((AutoCompleteTextView)paramFinder.findRequiredView(paramObject, 2131427717, "field 'mTextViewEmail'"));
    paramSignInFragment.mViewGroupThirdPartySignIn = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427714, "field 'mViewGroupThirdPartySignIn'"));
  }

  public static void reset(SignInFragment paramSignInFragment)
  {
    paramSignInFragment.mButtonSignIn = null;
    paramSignInFragment.mTextViewOr = null;
    paramSignInFragment.mButtonGoogle = null;
    paramSignInFragment.mButtonFacebook = null;
    paramSignInFragment.mButtonForgotPass = null;
    paramSignInFragment.mEditTextPassword = null;
    paramSignInFragment.mTextViewEmail = null;
    paramSignInFragment.mViewGroupThirdPartySignIn = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signin.SignInFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */