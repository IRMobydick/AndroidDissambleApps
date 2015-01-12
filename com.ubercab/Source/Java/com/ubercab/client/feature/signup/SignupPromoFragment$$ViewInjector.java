package com.ubercab.client.feature.signup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;

public class SignupPromoFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignupPromoFragment paramSignupPromoFragment, Object paramObject)
  {
    paramSignupPromoFragment.mViewContent = paramFinder.findRequiredView(paramObject, 2131427751, "field 'mViewContent'");
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427754, "field 'mButtonAddPromo' and method 'onAddPromoClicked'");
    paramSignupPromoFragment.mButtonAddPromo = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onAddPromoClicked();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427752, "field 'mEditTextPromo', method 'onEditorActionPromo', and method 'onTextChangedPromo'");
    paramSignupPromoFragment.mEditTextPromo = ((UberEditText)localView2);
    ((TextView)localView2).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return this.val$target.onEditorActionPromo();
      }
    });
    ((TextView)localView2).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.val$target.onTextChangedPromo(paramAnonymousCharSequence);
      }
    });
    paramSignupPromoFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427463, "field 'mProgressBarLoading'"));
    paramFinder.findRequiredView(paramObject, 2131427753, "method 'onCancelClicked'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onCancelClicked();
      }
    });
  }

  public static void reset(SignupPromoFragment paramSignupPromoFragment)
  {
    paramSignupPromoFragment.mViewContent = null;
    paramSignupPromoFragment.mButtonAddPromo = null;
    paramSignupPromoFragment.mEditTextPromo = null;
    paramSignupPromoFragment.mProgressBarLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPromoFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */