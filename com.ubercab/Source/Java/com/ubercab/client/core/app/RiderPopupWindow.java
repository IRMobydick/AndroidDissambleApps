package com.ubercab.client.core.app;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import butterknife.ButterKnife;
import com.squareup.otto.Bus;
import javax.inject.Inject;

public abstract class RiderPopupWindow extends PopupWindow
{

  @Inject
  Bus mBus;
  private RiderActivity mRiderActivity;

  protected RiderPopupWindow(Activity paramActivity)
  {
    this.mRiderActivity = ((RiderActivity)paramActivity);
    this.mRiderActivity.inject(this);
  }

  public void dismiss()
  {
    super.dismiss();
    this.mBus.unregister(this);
    ButterKnife.reset(this);
  }

  protected Activity getActivity()
  {
    return this.mRiderActivity;
  }

  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.mBus.register(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderPopupWindow
 * JD-Core Version:    0.6.2
 */