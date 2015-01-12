package com.ubercab.client.feature.profile;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberEditText;

public class ProfileFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ProfileFragment paramProfileFragment, Object paramObject)
  {
    paramProfileFragment.mImageViewProfile = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427660, "field 'mImageViewProfile'"));
    paramProfileFragment.mTextViewEmail = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427663, "field 'mTextViewEmail'"));
    paramProfileFragment.mTextViewPhone = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427664, "field 'mTextViewPhone'"));
    paramProfileFragment.mTextViewLastName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427662, "field 'mTextViewLastName'"));
    paramProfileFragment.mTextViewFirstName = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427661, "field 'mTextViewFirstName'"));
    paramFinder.findRequiredView(paramObject, 2131427667, "method 'onClickButtonSignout'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonSignout();
      }
    });
  }

  public static void reset(ProfileFragment paramProfileFragment)
  {
    paramProfileFragment.mImageViewProfile = null;
    paramProfileFragment.mTextViewEmail = null;
    paramProfileFragment.mTextViewPhone = null;
    paramProfileFragment.mTextViewLastName = null;
    paramProfileFragment.mTextViewFirstName = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.profile.ProfileFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */