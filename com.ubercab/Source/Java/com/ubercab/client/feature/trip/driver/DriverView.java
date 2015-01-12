package com.ubercab.client.feature.trip.driver;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.TripVehicle;
import com.ubercab.client.core.model.TripVehiclePictureImage;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.library.app.UberActivity;
import com.ubercab.ui.UberTextView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class DriverView extends LinearLayout
{
  private static final long DELAY_SHOW_VEHICLE_PHOTO = 1000L;
  private final Animation mAnimSlideInLeft;
  private final Animation mAnimSlideInRight;
  private final Animation mAnimSlideOutLeft;
  private final Animation mAnimSlideOutRight;

  @InjectView(2131427883)
  DiscountBar mDiscountBar;
  private boolean mDriverPhotoDownloading;

  @InjectView(2131427885)
  ImageView mImagePicture;

  @InjectView(2131427886)
  ImageView mImageVehicle;

  @InjectView(2131427891)
  ImageView mImageViewContact;
  private String mLastDriverPhotoUrl;
  private String mLastVehiclePhotoUrl;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();

  @Inject
  Picasso mPicasso;

  @Inject
  RiderPreferences mRiderPreferences;
  private int mState;

  @InjectView(2131427890)
  UberTextView mTextLicense;

  @InjectView(2131427887)
  UberTextView mTextName;

  @InjectView(2131427888)
  UberTextView mTextRating;

  @InjectView(2131427889)
  UberTextView mTextVehicleMake;

  @Inject
  TripUIStateManager mTripUIStateManager;
  private boolean mVehiclePhotoDownloading;
  private boolean mVehiclePhotoLoaded;

  @InjectView(2131427884)
  ViewFlipper mViewFlipperPictures;

  public DriverView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DriverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DriverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      ((UberActivity)paramContext).inject(this);
    this.mAnimSlideInLeft = AnimationUtils.loadAnimation(paramContext, 2130968586);
    this.mAnimSlideOutLeft = AnimationUtils.loadAnimation(paramContext, 2130968588);
    this.mAnimSlideInRight = AnimationUtils.loadAnimation(paramContext, 2130968587);
    this.mAnimSlideOutRight = AnimationUtils.loadAnimation(paramContext, 2130968589);
  }

  private void showDriverPhoto(boolean paramBoolean)
  {
    if (this.mViewFlipperPictures.getDisplayedChild() == 0)
      return;
    ViewFlipper localViewFlipper1 = this.mViewFlipperPictures;
    if (paramBoolean);
    for (Animation localAnimation1 = this.mAnimSlideInLeft; ; localAnimation1 = null)
    {
      localViewFlipper1.setInAnimation(localAnimation1);
      ViewFlipper localViewFlipper2 = this.mViewFlipperPictures;
      Animation localAnimation2 = null;
      if (paramBoolean)
        localAnimation2 = this.mAnimSlideOutLeft;
      localViewFlipper2.setOutAnimation(localAnimation2);
      this.mViewFlipperPictures.setDisplayedChild(0);
      return;
    }
  }

  private void showVehiclePhoto()
  {
    if ((!this.mVehiclePhotoLoaded) || (this.mViewFlipperPictures.getDisplayedChild() == 1))
      return;
    this.mViewFlipperPictures.setInAnimation(this.mAnimSlideInRight);
    this.mViewFlipperPictures.setOutAnimation(this.mAnimSlideOutRight);
    this.mViewFlipperPictures.setDisplayedChild(1);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  @OnClick({2131427891})
  public void onClickContact()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onContactDriverClicked();
  }

  @OnClick({2131427885})
  public void onClickImageDriver()
  {
    showVehiclePhoto();
  }

  @OnClick({2131427886})
  public void onClickImageVehicle()
  {
    showDriverPhoto(true);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    this.mImageViewContact.setContentDescription(getContext().getString(2131558522));
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void update(Ping paramPing)
  {
    if (!PingUtils.hasTrip(paramPing))
    {
      this.mDiscountBar.setVisibility(8);
      this.mDriverPhotoDownloading = false;
      this.mLastDriverPhotoUrl = null;
      this.mVehiclePhotoDownloading = false;
      this.mVehiclePhotoLoaded = false;
      this.mLastVehiclePhotoUrl = null;
      this.mImagePicture.setImageDrawable(null);
      this.mImageVehicle.setImageDrawable(null);
      showDriverPhoto(false);
    }
    int i;
    label226: label484: 
    do
    {
      return;
      this.mDiscountBar.update(paramPing);
      TripDriver localTripDriver = paramPing.getTrip().getDriver();
      TripVehicle localTripVehicle = paramPing.getTrip().getVehicle();
      String str;
      int j;
      if ((localTripVehicle.getPictureImages() != null) && (!localTripVehicle.getPictureImages().isEmpty()))
      {
        str = ((TripVehiclePictureImage)localTripVehicle.getPictureImages().get(0)).getUrl();
        i = this.mState;
        this.mState = this.mTripUIStateManager.getState();
        this.mTextName.setText(localTripDriver.getName());
        UberTextView localUberTextView = this.mTextRating;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Float.valueOf(localTripDriver.getRating());
        localUberTextView.setText(String.format("%1.1f", arrayOfObject));
        this.mTextVehicleMake.setText(localTripVehicle.getFormattedMake());
        this.mTextLicense.setText(localTripVehicle.getFormattedLicensePlate());
        ImageView localImageView = this.mImageViewContact;
        if (!PingUtils.isTripMaster(paramPing))
          break label436;
        j = 0;
        localImageView.setVisibility(j);
        if ((this.mLastDriverPhotoUrl != null) && (!this.mLastDriverPhotoUrl.equals(localTripDriver.getPictureUrl())))
        {
          this.mDriverPhotoDownloading = false;
          this.mLastDriverPhotoUrl = null;
          this.mImagePicture.setImageDrawable(null);
        }
        if ((this.mLastVehiclePhotoUrl != null) && (!this.mLastVehiclePhotoUrl.equals(str)))
        {
          this.mVehiclePhotoDownloading = false;
          this.mVehiclePhotoLoaded = false;
          this.mLastVehiclePhotoUrl = null;
          this.mImageVehicle.setImageDrawable(null);
          showDriverPhoto(false);
        }
        if (TextUtils.isEmpty(localTripDriver.getPictureUrl()))
          break label443;
        if (!this.mDriverPhotoDownloading)
        {
          this.mDriverPhotoDownloading = true;
          this.mPicasso.load(localTripDriver.getPictureUrl()).placeholder(2130837854).error(2130837854).into(this.mImagePicture);
        }
      }
      while (true)
      {
        if (str == null)
          break label456;
        if ((this.mVehiclePhotoLoaded) || (this.mVehiclePhotoDownloading))
          break label484;
        this.mVehiclePhotoDownloading = true;
        this.mPicasso.load(str).transform(new VehicleImageTransformation()).into(this.mImageVehicle, new Callback()
        {
          public void onError()
          {
          }

          public void onSuccess()
          {
            DriverView.access$002(DriverView.this, true);
            DriverView.this.mImageViewContact.postDelayed(new Runnable()
            {
              public void run()
              {
                if (DriverView.this.mState < 5)
                  DriverView.this.showVehiclePhoto();
              }
            }
            , 1000L);
          }
        });
        return;
        str = null;
        break;
        j = 8;
        break label226;
        this.mImagePicture.setImageResource(2130837854);
      }
      if (this.mImageVehicle.getDrawable() != null)
      {
        this.mImageVehicle.setImageDrawable(null);
        this.mVehiclePhotoLoaded = false;
        showDriverPhoto(true);
      }
    }
    while ((!this.mVehiclePhotoLoaded) || (i == 5) || (this.mState != 5));
    label436: label443: label456: showDriverPhoto(true);
  }

  public static abstract interface Listener
  {
    public abstract void onContactDriverClicked();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.DriverView
 * JD-Core Version:    0.6.2
 */