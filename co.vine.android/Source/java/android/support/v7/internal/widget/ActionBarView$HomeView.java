package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.id;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import java.util.List;

class ActionBarView$HomeView extends FrameLayout
{
  private Drawable mDefaultUpIndicator;
  private ImageView mIconView;
  private int mUpIndicatorRes;
  private ImageView mUpView;
  private int mUpWidth;

  public ActionBarView$HomeView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionBarView$HomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    CharSequence localCharSequence = getContentDescription();
    if (!TextUtils.isEmpty(localCharSequence))
      paramAccessibilityEvent.getText().add(localCharSequence);
    return true;
  }

  public int getLeftOffset()
  {
    if (this.mUpView.getVisibility() == 8);
    for (int i = this.mUpWidth; ; i = 0)
      return i;
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mUpIndicatorRes != 0)
      setUpIndicator(this.mUpIndicatorRes);
  }

  protected void onFinishInflate()
  {
    this.mUpView = ((ImageView)findViewById(R.id.up));
    this.mIconView = ((ImageView)findViewById(R.id.home));
    this.mDefaultUpIndicator = this.mUpView.getDrawable();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = (paramInt4 - paramInt2) / 2;
    int j = paramInt3 - paramInt1;
    int k = 0;
    if (this.mUpView.getVisibility() != 8)
    {
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
      int i4 = this.mUpView.getMeasuredHeight();
      int i5 = this.mUpView.getMeasuredWidth();
      int i6 = i - i4 / 2;
      this.mUpView.layout(0, i6, i5, i6 + i4);
      k = i5 + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin;
      (j - k);
      paramInt1 += k;
    }
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
    int m = this.mIconView.getMeasuredHeight();
    int n = this.mIconView.getMeasuredWidth();
    int i1 = (paramInt3 - paramInt1) / 2;
    int i2 = k + Math.max(localLayoutParams1.leftMargin, i1 - n / 2);
    int i3 = Math.max(localLayoutParams1.topMargin, i - m / 2);
    this.mIconView.layout(i2, i3, i2 + n, i3 + m);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildWithMargins(this.mUpView, paramInt1, 0, paramInt2, 0);
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
    this.mUpWidth = (localLayoutParams1.leftMargin + this.mUpView.getMeasuredWidth() + localLayoutParams1.rightMargin);
    int i;
    int k;
    int m;
    int i2;
    int i3;
    if (this.mUpView.getVisibility() == 8)
    {
      i = 0;
      int j = localLayoutParams1.topMargin + this.mUpView.getMeasuredHeight() + localLayoutParams1.bottomMargin;
      measureChildWithMargins(this.mIconView, paramInt1, i, paramInt2, 0);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
      k = i + (localLayoutParams2.leftMargin + this.mIconView.getMeasuredWidth() + localLayoutParams2.rightMargin);
      m = Math.max(j, localLayoutParams2.topMargin + this.mIconView.getMeasuredHeight() + localLayoutParams2.bottomMargin);
      int n = View.MeasureSpec.getMode(paramInt1);
      int i1 = View.MeasureSpec.getMode(paramInt2);
      i2 = View.MeasureSpec.getSize(paramInt1);
      i3 = View.MeasureSpec.getSize(paramInt2);
      switch (n)
      {
      default:
        label204: switch (i1)
        {
        default:
        case -2147483648:
        case 1073741824:
        }
      case -2147483648:
      case 1073741824:
      }
    }
    while (true)
    {
      setMeasuredDimension(k, m);
      return;
      i = this.mUpWidth;
      break;
      k = Math.min(k, i2);
      break label204;
      k = i2;
      break label204;
      m = Math.min(m, i3);
      continue;
      m = i3;
    }
  }

  public void setIcon(Drawable paramDrawable)
  {
    this.mIconView.setImageDrawable(paramDrawable);
  }

  public void setUp(boolean paramBoolean)
  {
    ImageView localImageView = this.mUpView;
    if (paramBoolean);
    for (int i = 0; ; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }

  public void setUpIndicator(int paramInt)
  {
    this.mUpIndicatorRes = paramInt;
    ImageView localImageView = this.mUpView;
    if (paramInt != 0);
    for (Drawable localDrawable = getResources().getDrawable(paramInt); ; localDrawable = this.mDefaultUpIndicator)
    {
      localImageView.setImageDrawable(localDrawable);
      return;
    }
  }

  public void setUpIndicator(Drawable paramDrawable)
  {
    ImageView localImageView = this.mUpView;
    if (paramDrawable != null);
    while (true)
    {
      localImageView.setImageDrawable(paramDrawable);
      this.mUpIndicatorRes = 0;
      return;
      paramDrawable = this.mDefaultUpIndicator;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarView.HomeView
 * JD-Core Version:    0.6.0
 */