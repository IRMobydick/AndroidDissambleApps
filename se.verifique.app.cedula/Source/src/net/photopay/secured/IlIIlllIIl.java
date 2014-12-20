package net.photopay.secured;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import net.photopay.geometry.Point;
import net.photopay.util.FakeR;
import net.photopay.view.viewfinder.AbstractViewFinder;

public final class IlIIlllIIl extends AbstractViewFinder
{
  private Button IlIllIlIIl = null;
  private boolean IlllllIIIl = false;
  private Activity jdField_llIIlIlIIl_of_type_AndroidAppActivity = null;
  private Resources jdField_llIIlIlIIl_of_type_AndroidContentResResources = null;
  private ViewGroup jdField_llIIlIlIIl_of_type_AndroidViewViewGroup = null;
  private Button jdField_llIIlIlIIl_of_type_AndroidWidgetButton = null;
  private TextView jdField_llIIlIlIIl_of_type_AndroidWidgetTextView = null;
  private llIllIIlll jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll = null;
  private FakeR jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = null;
  private Handler mHandler = new Handler();

  public IlIIlllIIl(Activity paramActivity, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = new FakeR(paramActivity);
    this.jdField_llIIlIlIIl_of_type_AndroidAppActivity = paramActivity;
    this.jdField_llIIlIlIIl_of_type_AndroidContentResResources = paramActivity.getResources();
    this.jdField_llIIlIlIIl_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll = new llIllIIlll(paramActivity);
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.IlIlllllII(paramBoolean);
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.llIIlIlIIl(this);
    this.jdField_llIIlIlIIl_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("id", "backButton")));
    this.jdField_llIIlIlIIl_of_type_AndroidWidgetButton.setText(paramActivity.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "photopayHome")));
    this.jdField_llIIlIlIIl_of_type_AndroidWidgetButton.setOnClickListener(new IlIIlllIIl.1(this, paramActivity));
    this.IlIllIlIIl = ((Button)paramViewGroup.findViewById(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("id", "torchButton")));
    this.IlIllIlIIl.setVisibility(8);
  }

  public final void IIIIIIIIII()
  {
    if (isCameraTorchSupported())
    {
      this.IlIllIlIIl.setVisibility(0);
      this.IlIllIlIIl.setOnClickListener(new IlIIlllIIl.2(this));
    }
  }

  public final void displayAutofocusFailed()
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.displayAutofocusFailed();
  }

  public final void displayDebugStatus(CharSequence paramCharSequence)
  {
    if ((this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView != null) && (this.mHandler != null))
      this.mHandler.post(new IlIIlllIIl.3(this, paramCharSequence));
  }

  public final View getFixedView()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll;
  }

  public final View getRotatableView()
  {
    return this.jdField_llIIlIlIIl_of_type_AndroidViewViewGroup;
  }

  public final boolean isAnimationInProgress()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.isAnimationInProgress();
  }

  public final void setDefaultTarget(int paramInt, boolean paramBoolean)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.IIlIlllIIl();
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.lIlIIIIlIl(paramInt);
  }

  public final void setNewTarget(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.llIIlIlIIl(paramPoint1, paramPoint2, paramPoint3, paramPoint4, paramInt1);
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.lIlIIIIlIl(paramInt2);
  }

  public final void setPointSet(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.setPointSet(paramArrayOfFloat, paramBoolean);
  }

  public final void setRecognizerMode(int paramInt)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIllIIlll.IllIIIIllI(paramInt);
    if (paramInt != 0)
    {
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView = new TextView(this.jdField_llIIlIlIIl_of_type_AndroidAppActivity);
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView.setGravity(21);
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView.setBackgroundColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("drawable", "rounded_border"));
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView.setPadding(6, 6, 6, 6);
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView.setTextColor(this.jdField_llIIlIlIIl_of_type_AndroidContentResResources.getColor(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("color", "statusForeground")));
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView.setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      this.jdField_llIIlIlIIl_of_type_AndroidViewViewGroup.addView(this.jdField_llIIlIlIIl_of_type_AndroidWidgetTextView, localLayoutParams);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.IlIIlllIIl
 * JD-Core Version:    0.6.0
 */