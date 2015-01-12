package com.ubercab.client.feature.receipt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.model.FeedbackType;
import java.util.List;

public class FeedbackAdapter extends ArrayAdapter<FeedbackType>
{
  public FeedbackAdapter(Context paramContext, List<FeedbackType> paramList)
  {
    super(paramContext, 17367048, paramList);
    RiderApplication.get(paramContext).inject(this);
    setDropDownViewResource(17367049);
    insert(new FeedbackType(paramContext.getString(2131559077)), 0);
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getDropDownView(paramInt, paramView, paramViewGroup);
    FeedbackType localFeedbackType = (FeedbackType)getItem(paramInt);
    ((TextView)localView.findViewById(16908308)).setText(localFeedbackType.getDescription());
    return localView;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    FeedbackType localFeedbackType = (FeedbackType)getItem(paramInt);
    ((TextView)localView.findViewById(16908308)).setText(localFeedbackType.getDescription());
    return localView;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.FeedbackAdapter
 * JD-Core Version:    0.6.2
 */