package com.ubercab.client.feature.faresplit.master;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class FareSplitClientViewHolder
{

  @InjectView(2131427471)
  ImageButton mButtonRemove;
  private Context mContext;

  @InjectView(2131427457)
  ImageView mImageView;

  @Inject
  Picasso mPicasso;

  @InjectView(2131427469)
  UberTextView mTextViewName;

  @InjectView(2131427470)
  UberTextView mTextViewStatus;

  public FareSplitClientViewHolder(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.mContext = paramView.getContext();
    RiderApplication.get(this.mContext).inject(this);
    ButterKnife.inject(this, paramView);
    this.mButtonRemove.setContentDescription(this.mContext.getString(2131558872));
    this.mButtonRemove.setOnClickListener(paramOnClickListener);
  }

  private int colorForStatus(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -2081881145:
    case 982065527:
    case 632840270:
    case -58529607:
    case -522759168:
    case 61987014:
    }
    while (true)
      switch (i)
      {
      default:
        return this.mContext.getResources().getColor(2131296329);
        if (paramString.equals("Accepted"))
        {
          i = 0;
          continue;
          if (paramString.equals("Pending"))
          {
            i = 1;
            continue;
            if (paramString.equals("Declined"))
            {
              i = 2;
              continue;
              if (paramString.equals("Canceled"))
              {
                i = 3;
                continue;
                if (paramString.equals("InvalidNumber"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("InviteFailed"))
                    i = 5;
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    return this.mContext.getResources().getColor(2131296321);
    return this.mContext.getResources().getColor(2131296333);
    return this.mContext.getResources().getColor(2131296325);
  }

  public void update(FareSplitClient paramFareSplitClient, int paramInt, boolean paramBoolean)
  {
    int i = 8;
    String str1 = paramFareSplitClient.getPictureUrl();
    label105: ImageButton localImageButton2;
    if (!TextUtils.isEmpty(str1))
    {
      this.mPicasso.load(str1).placeholder(2130837854).error(2130837854).into(this.mImageView);
      this.mTextViewName.setText(paramFareSplitClient.getDisplayNameOrNumber());
      String str2 = paramFareSplitClient.getDisplayStatus(this.mContext);
      if (TextUtils.isEmpty(str2))
        break label153;
      this.mTextViewStatus.setTextColor(colorForStatus(paramFareSplitClient.getStatus()));
      this.mTextViewStatus.setText(str2);
      this.mTextViewStatus.setVisibility(0);
      if (!paramBoolean)
        break label171;
      localImageButton2 = this.mButtonRemove;
      if (!paramFareSplitClient.isSelf())
        break label165;
    }
    while (true)
    {
      localImageButton2.setVisibility(i);
      this.mButtonRemove.setTag(Integer.valueOf(paramInt));
      return;
      this.mImageView.setImageResource(2130837854);
      break;
      label153: this.mTextViewStatus.setVisibility(i);
      break label105;
      label165: i = 0;
    }
    label171: ImageButton localImageButton1 = this.mButtonRemove;
    boolean bool = paramFareSplitClient.isSelf();
    int j = 0;
    if (bool);
    while (true)
    {
      localImageButton1.setVisibility(j);
      break;
      j = i;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitClientViewHolder
 * JD-Core Version:    0.6.2
 */