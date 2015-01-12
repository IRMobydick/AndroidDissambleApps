package com.ubercab.client.feature.launch;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.ButterKnife.Finder;
import com.ubercab.library.ui.LongPressLayout;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class MagicActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MagicActivity paramMagicActivity, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427481, "field 'mButtonSignIn' and method 'onSignInButtonClicked'");
    paramMagicActivity.mButtonSignIn = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onSignInButtonClicked();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427482, "field 'mButtonRegister' and method 'onRegisterButtonClicked'");
    paramMagicActivity.mButtonRegister = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onRegisterButtonClicked();
      }
    });
    paramMagicActivity.mLayoutRoot = ((LongPressLayout)paramFinder.findRequiredView(paramObject, 2131427479, "field 'mLayoutRoot'"));
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427480, "field 'mTextViewDevServer' and method 'onClickTextViewDevServer'");
    paramMagicActivity.mTextViewDevServer = ((UberTextView)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickTextViewDevServer();
      }
    });
    paramMagicActivity.mTextViewSlogan = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427485, "field 'mTextViewSlogan'"));
    paramMagicActivity.mViewGroupEmployee = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427483, "field 'mViewGroupEmployee'"));
    paramFinder.findRequiredView(paramObject, 2131427484, "method 'onClickButtonEmployee'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonEmployee();
      }
    });
  }

  public static void reset(MagicActivity paramMagicActivity)
  {
    paramMagicActivity.mButtonSignIn = null;
    paramMagicActivity.mButtonRegister = null;
    paramMagicActivity.mLayoutRoot = null;
    paramMagicActivity.mTextViewDevServer = null;
    paramMagicActivity.mTextViewSlogan = null;
    paramMagicActivity.mViewGroupEmployee = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.MagicActivity..ViewInjector
 * JD-Core Version:    0.6.2
 */