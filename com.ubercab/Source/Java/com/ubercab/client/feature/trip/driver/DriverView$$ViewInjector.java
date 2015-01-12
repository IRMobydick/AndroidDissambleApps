package com.ubercab.client.feature.trip.driver;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class DriverView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DriverView paramDriverView, Object paramObject)
  {
    paramDriverView.mDiscountBar = ((DiscountBar)paramFinder.findRequiredView(paramObject, 2131427883, "field 'mDiscountBar'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427891, "field 'mImageViewContact' and method 'onClickContact'");
    paramDriverView.mImageViewContact = ((ImageView)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickContact();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427885, "field 'mImagePicture' and method 'onClickImageDriver'");
    paramDriverView.mImagePicture = ((ImageView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickImageDriver();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427886, "field 'mImageVehicle' and method 'onClickImageVehicle'");
    paramDriverView.mImageVehicle = ((ImageView)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickImageVehicle();
      }
    });
    paramDriverView.mTextName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427887, "field 'mTextName'"));
    paramDriverView.mTextRating = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427888, "field 'mTextRating'"));
    paramDriverView.mTextLicense = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427890, "field 'mTextLicense'"));
    paramDriverView.mTextVehicleMake = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427889, "field 'mTextVehicleMake'"));
    paramDriverView.mViewFlipperPictures = ((ViewFlipper)paramFinder.findRequiredView(paramObject, 2131427884, "field 'mViewFlipperPictures'"));
  }

  public static void reset(DriverView paramDriverView)
  {
    paramDriverView.mDiscountBar = null;
    paramDriverView.mImageViewContact = null;
    paramDriverView.mImagePicture = null;
    paramDriverView.mImageVehicle = null;
    paramDriverView.mTextName = null;
    paramDriverView.mTextRating = null;
    paramDriverView.mTextLicense = null;
    paramDriverView.mTextVehicleMake = null;
    paramDriverView.mViewFlipperPictures = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.DriverView..ViewInjector
 * JD-Core Version:    0.6.2
 */