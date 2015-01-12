package com.ubercab.client.feature.faresplit.master;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.model.RecentFareSplitter;
import com.ubercab.client.core.util.ContactsUtil;
import com.ubercab.client.core.util.ContactsUtil.Contact;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class FareSplitContactViewHolder
{

  @InjectView(2131427472)
  CheckBox mCheckBoxIsInvited;
  private Context mContext;

  @InjectView(2131427457)
  ImageView mImageViewPicture;

  @Inject
  Picasso mPicasso;

  @InjectView(2131427469)
  UberTextView mTextViewName;

  @InjectView(2131427470)
  UberTextView mTextViewNumber;

  public FareSplitContactViewHolder(View paramView, boolean paramBoolean)
  {
    this.mContext = paramView.getContext();
    RiderApplication.get(this.mContext).inject(this);
    ButterKnife.inject(this, paramView);
    CheckBox localCheckBox = this.mCheckBoxIsInvited;
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localCheckBox.setVisibility(i);
      return;
    }
  }

  public void update(RecentFareSplitter paramRecentFareSplitter, boolean paramBoolean)
  {
    this.mTextViewName.setText(paramRecentFareSplitter.getName());
    String str1 = paramRecentFareSplitter.getMobileDigits();
    String str2 = paramRecentFareSplitter.getMobileCountryIso2();
    boolean bool1 = TextUtils.isEmpty(str1);
    String str3 = null;
    if (!bool1)
    {
      boolean bool2 = TextUtils.isEmpty(str2);
      str3 = null;
      if (!bool2)
        str3 = PhoneNumberUtils.getDisplayPhoneNumber(str1, str2);
    }
    this.mTextViewNumber.setText(str3);
    this.mCheckBoxIsInvited.setChecked(paramBoolean);
    if (!TextUtils.isEmpty(paramRecentFareSplitter.getPictureUrl()))
    {
      this.mPicasso.load(paramRecentFareSplitter.getPictureUrl()).placeholder(2130837854).error(2130837854).into(this.mImageViewPicture);
      return;
    }
    this.mImageViewPicture.setImageResource(2130837854);
  }

  public void update(ContactsUtil.Contact paramContact, boolean paramBoolean)
  {
    if (paramContact == null)
      return;
    String str1 = String.format("%s %s", new Object[] { paramContact.getNumber(), ContactsUtil.getTypeOrLabel(this.mContext, paramContact) });
    if (paramContact.getThumbnailUri() != null);
    for (String str2 = paramContact.getThumbnailUri().toString(); ; str2 = null)
    {
      this.mTextViewName.setText(paramContact.getDisplayName());
      this.mTextViewNumber.setText(str1);
      this.mCheckBoxIsInvited.setChecked(paramBoolean);
      if (TextUtils.isEmpty(str2))
        break;
      this.mPicasso.load(str2).placeholder(2130837854).error(2130837854).into(this.mImageViewPicture);
      return;
    }
    this.mImageViewPicture.setImageResource(2130837854);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitContactViewHolder
 * JD-Core Version:    0.6.2
 */