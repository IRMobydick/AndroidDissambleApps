package com.ubercab.client.feature.promo;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;

public class PromoFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PromoFragment paramPromoFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427673, "field 'mButtonApply' and method 'onClickApply'");
    paramPromoFragment.mButtonApply = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickApply();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427672, "field 'mEditTextCode', method 'onEditorActionCode', and method 'onTextChangedPromo'");
    paramPromoFragment.mEditTextCode = ((UberEditText)localView2);
    ((TextView)localView2).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return this.val$target.onEditorActionCode();
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
    paramPromoFragment.mViewGroupContent = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427671, "field 'mViewGroupContent'"));
    paramPromoFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427674, "field 'mProgressBarLoading'"));
    View localView3 = paramFinder.findOptionalView(paramObject, 2131427675);
    if (localView3 != null)
      localView3.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          this.val$target.onClickCancel();
        }
      });
  }

  public static void reset(PromoFragment paramPromoFragment)
  {
    paramPromoFragment.mButtonApply = null;
    paramPromoFragment.mEditTextCode = null;
    paramPromoFragment.mViewGroupContent = null;
    paramPromoFragment.mProgressBarLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.promo.PromoFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */