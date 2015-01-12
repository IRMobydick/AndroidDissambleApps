package com.ubercab.client.feature.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocationSearchFooterView extends FrameLayout
{
  private int mFooterMarginTop = (int)getResources().getDimension(2131361957);

  @InjectView(2131427696)
  UberTextView mFooterTitle;

  @InjectView(2131427698)
  ImageView mImageViewPoweredByGoogle;
  private List<Listener> mListeners = new ArrayList();

  @InjectView(2131427697)
  UberButton mRemoveTaggedButton;

  @InjectView(2131427694)
  ViewGroup mViewGroupSearchMore;

  public LocationSearchFooterView(Context paramContext)
  {
    this(paramContext, null);
  }

  public LocationSearchFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LocationSearchFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void addSearchMoreFooterMargins()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = getSearchMoreLayoutParams();
    localMarginLayoutParams.setMargins(0, this.mFooterMarginTop, 0, 0);
    this.mViewGroupSearchMore.setLayoutParams(localMarginLayoutParams);
  }

  private ViewGroup.MarginLayoutParams getSearchMoreLayoutParams()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mViewGroupSearchMore.getLayoutParams();
    if (localMarginLayoutParams == null)
      localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    return localMarginLayoutParams;
  }

  private void removeSearchMoreFooterMargins()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = getSearchMoreLayoutParams();
    localMarginLayoutParams.setMargins(0, 0, 0, 0);
    this.mViewGroupSearchMore.setLayoutParams(localMarginLayoutParams);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  public void hidePoweredByGoogle()
  {
    this.mImageViewPoweredByGoogle.setVisibility(8);
  }

  public void hideRemoveButton()
  {
    this.mRemoveTaggedButton.setVisibility(8);
  }

  public void hideSearchMore()
  {
    this.mViewGroupSearchMore.setVisibility(8);
    removeSearchMoreFooterMargins();
  }

  @OnClick({2131427697})
  public void onClickRemoveButton()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickRemoveTagged();
  }

  @OnClick({2131427694})
  public void onClickSearchMore()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickSearchMore();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setRemoveButtonText(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      hideRemoveButton();
      return;
    }
    this.mRemoveTaggedButton.setText(getResources().getString(2131559027, new Object[] { paramString }));
  }

  public void showRemoveButton()
  {
    this.mRemoveTaggedButton.setVisibility(0);
  }

  public void showSearchMore(boolean paramBoolean, String paramString)
  {
    this.mViewGroupSearchMore.setVisibility(0);
    update(paramBoolean, paramString);
  }

  public void update(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
      addSearchMoreFooterMargins();
    while (true)
    {
      this.mFooterTitle.setText(paramString);
      return;
      removeSearchMoreFooterMargins();
    }
  }

  static abstract interface Listener
  {
    public abstract void onClickRemoveTagged();

    public abstract void onClickSearchMore();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchFooterView
 * JD-Core Version:    0.6.2
 */