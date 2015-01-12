package com.ubercab.client.feature.notification;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.feature.notification.data.TripNotificationData;
import com.ubercab.library.util.BitmapUtils;
import com.ubercab.library.util.DeviceUtils;
import com.ubercab.ui.FontUtils;
import java.io.IOException;
import java.util.Locale;
import javax.inject.Inject;
import timber.log.Timber;

public final class NotificationPainter
{
  private final int mActionsHeight;
  private final Bitmap mBitmapGrid;
  private final int mColorBigPictureBg;
  private final int mContentSpacing;
  private final int mContentTextHeight;
  private final Context mContext;
  private final int mIconSizeLarge;
  private final int mLineSpacingEta;
  private final Paint mPaintPhotoBg;
  private final Paint mPaintPhotoOutline;
  private final int mPhotoCircleRadius;

  @Inject
  Picasso mPicasso;
  private final Paint mTextPaintContent;
  private final Paint mTextPaintContentExtra;
  private final Paint mTextPaintEtaLabel;
  private final Paint mTextPaintEtaNumber;
  private final int mTripBigPictureHeight;

  public NotificationPainter(Context paramContext)
  {
    RiderApplication.get(paramContext).inject(this);
    this.mContext = paramContext;
    Resources localResources = paramContext.getResources();
    this.mActionsHeight = localResources.getDimensionPixelSize(2131361906);
    this.mLineSpacingEta = localResources.getDimensionPixelSize(2131361907);
    this.mTripBigPictureHeight = localResources.getDimensionPixelSize(2131361916);
    this.mPhotoCircleRadius = localResources.getDimensionPixelSize(2131361908);
    this.mContentSpacing = localResources.getDimensionPixelSize(2131361910);
    this.mColorBigPictureBg = localResources.getColor(2131296331);
    this.mBitmapGrid = ((BitmapDrawable)localResources.getDrawable(2130837625)).getBitmap();
    int i = localResources.getColor(2131296322);
    Typeface localTypeface = FontUtils.getDefaultTypeface(paramContext);
    int j = localResources.getDimensionPixelSize(2131361914);
    this.mTextPaintEtaLabel = new Paint();
    this.mTextPaintEtaLabel.setAntiAlias(true);
    this.mTextPaintEtaLabel.setTypeface(localTypeface);
    this.mTextPaintEtaLabel.setColor(i);
    this.mTextPaintEtaLabel.setTextSize(j);
    int k = localResources.getDimensionPixelSize(2131361915);
    this.mTextPaintEtaNumber = new Paint();
    this.mTextPaintEtaNumber.setAntiAlias(true);
    this.mTextPaintEtaNumber.setTypeface(localTypeface);
    this.mTextPaintEtaNumber.setColor(i);
    this.mTextPaintEtaNumber.setTextSize(k);
    this.mPaintPhotoBg = new Paint();
    this.mPaintPhotoBg.setAntiAlias(true);
    this.mPaintPhotoBg.setStyle(Paint.Style.FILL);
    this.mPaintPhotoBg.setColor(-1);
    int m = localResources.getDimensionPixelOffset(2131361911);
    this.mPaintPhotoOutline = new Paint();
    this.mPaintPhotoOutline.setAntiAlias(true);
    this.mPaintPhotoOutline.setStyle(Paint.Style.STROKE);
    this.mPaintPhotoOutline.setStrokeWidth(m);
    this.mPaintPhotoOutline.setColor(-1);
    int n = localResources.getDimensionPixelSize(2131361912);
    this.mTextPaintContent = new Paint();
    this.mTextPaintContent.setTypeface(localTypeface);
    this.mTextPaintContent.setTextSize(n);
    this.mTextPaintContent.setAntiAlias(true);
    this.mTextPaintContent.setColor(-1);
    int i1 = localResources.getDimensionPixelSize(2131361913);
    this.mTextPaintContentExtra = new Paint();
    this.mTextPaintContentExtra.setTypeface(localTypeface);
    this.mTextPaintContentExtra.setTextSize(i1);
    this.mTextPaintContentExtra.setAntiAlias(true);
    this.mTextPaintContentExtra.setColor(localResources.getColor(2131296327));
    Rect localRect = new Rect();
    this.mTextPaintContent.getTextBounds("W", 0, 1, localRect);
    this.mContentTextHeight = localRect.height();
    this.mIconSizeLarge = paramContext.getResources().getDimensionPixelSize(2131361909);
  }

  private Paint createCircleBitmapPaint(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(paramFloat1 - this.mPhotoCircleRadius, paramFloat2 - this.mPhotoCircleRadius);
    localBitmapShader.setLocalMatrix(localMatrix);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setShader(localBitmapShader);
    return localPaint;
  }

  private void drawContentText(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    paramCanvas.drawText(paramString, paramFloat1 - localRect.width() / 2.0F - localRect.left, paramFloat2 + this.mPhotoCircleRadius + this.mContentSpacing + this.mContentTextHeight, paramPaint);
  }

  private int getScreenWidth()
  {
    return DeviceUtils.getScreenSize(this.mContext).x;
  }

  private Bitmap loadBitmapWithDimensions(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      Bitmap localBitmap = this.mPicasso.load(paramString).resize(paramInt1, paramInt2).centerCrop().get();
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      Timber.d(localIOException, "Failed to load bitmap for notification: " + paramString, new Object[0]);
    }
    return null;
  }

  public Bitmap drawEtaBitmap(int paramInt)
  {
    int i = this.mIconSizeLarge;
    int j = this.mIconSizeLarge;
    String str1 = String.valueOf(paramInt);
    String str2 = this.mContext.getString(2131558927).toUpperCase(Locale.getDefault());
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect1 = new Rect();
    this.mTextPaintEtaNumber.getTextBounds(str1, 0, str1.length(), localRect1);
    Rect localRect2 = new Rect();
    this.mTextPaintEtaLabel.getTextBounds(str2, 0, str2.length(), localRect2);
    int k = localRect1.height();
    int m = localRect2.height();
    int n = m + (k + this.mLineSpacingEta);
    float f1 = i / 2.0F;
    float f2 = j / 2.0F - n / 2.0F;
    localCanvas.drawText(str1, f1 - localRect1.width() / 2.0F - localRect1.left, f2 + k, this.mTextPaintEtaNumber);
    float f3 = f2 + (k + this.mLineSpacingEta);
    localCanvas.drawText(str2, f1 - localRect2.width() / 2.0F - localRect2.left, f3 + m, this.mTextPaintEtaLabel);
    return localBitmap;
  }

  public Bitmap drawTripBigPicture(TripNotificationData paramTripNotificationData, boolean paramBoolean)
  {
    int i = getScreenWidth();
    int j = this.mTripBigPictureHeight;
    int k = 2 * getPhotoCircleRadius();
    Bitmap localBitmap1 = loadBitmap(paramTripNotificationData.getVehiclePhotoUrl(), k);
    if (localBitmap1 == null)
      localBitmap1 = loadMonoBitmap(paramTripNotificationData.getVehicleViewMonoImageUrl(), k, false);
    Bitmap localBitmap2 = loadBitmap(paramTripNotificationData.getDriverPhotoUrl(), k);
    Bitmap localBitmap3 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap3);
    localCanvas.drawColor(this.mColorBigPictureBg);
    Paint localPaint1 = new Paint();
    localPaint1.setShader(new BitmapShader(this.mBitmapGrid, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    localCanvas.drawRect(0.0F, 0.0F, i, j, localPaint1);
    if (paramBoolean)
      localCanvas.translate(0.0F, -(this.mActionsHeight / 2));
    float f1 = i / 4.0F;
    float f2 = j / 2.0F - this.mContentTextHeight;
    localCanvas.drawCircle(f1, f2, this.mPhotoCircleRadius, this.mPaintPhotoBg);
    if (localBitmap1 != null)
    {
      Paint localPaint3 = createCircleBitmapPaint(localBitmap1, f1, f2);
      localCanvas.drawCircle(f1, f2, this.mPhotoCircleRadius, localPaint3);
      localCanvas.drawCircle(f1, f2, this.mPhotoCircleRadius, this.mPaintPhotoOutline);
    }
    drawContentText(localCanvas, this.mTextPaintContent, f1, f2, paramTripNotificationData.getVehicleDisplayName());
    float f3 = f1 * 3.0F;
    localCanvas.drawCircle(f3, f2, this.mPhotoCircleRadius, this.mPaintPhotoBg);
    if (localBitmap2 != null)
    {
      Paint localPaint2 = createCircleBitmapPaint(localBitmap2, f3, f2);
      localCanvas.drawCircle(f3, f2, this.mPhotoCircleRadius, localPaint2);
      localCanvas.drawCircle(f3, f2, this.mPhotoCircleRadius, this.mPaintPhotoOutline);
    }
    drawContentText(localCanvas, this.mTextPaintContent, f3, f2, paramTripNotificationData.getDriverName());
    drawContentText(localCanvas, this.mTextPaintContentExtra, f3, f2 + this.mContentTextHeight, paramTripNotificationData.getDriverExtra());
    return localBitmap3;
  }

  public int getIconSizeLarge()
  {
    return this.mIconSizeLarge;
  }

  public int getPhotoCircleRadius()
  {
    return this.mPhotoCircleRadius;
  }

  public Bitmap loadBitmap(String paramString, int paramInt)
  {
    return loadBitmapWithDimensions(paramString, paramInt, paramInt);
  }

  public Bitmap loadBitmapLargeImage(String paramString, boolean paramBoolean)
  {
    int i = getScreenWidth();
    if (paramBoolean);
    Bitmap localBitmap1;
    for (int j = this.mTripBigPictureHeight - this.mActionsHeight; ; j = this.mTripBigPictureHeight)
    {
      localBitmap1 = loadBitmapWithDimensions(paramString, i, j);
      if ((paramBoolean) && (localBitmap1 != null))
        break;
      return localBitmap1;
    }
    Bitmap localBitmap2 = Bitmap.createBitmap(getScreenWidth(), this.mTripBigPictureHeight, Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap2).drawBitmap(localBitmap1, 0.0F, 0.0F, null);
    return localBitmap2;
  }

  public Bitmap loadMonoBitmap(String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      RequestCreator localRequestCreator = this.mPicasso.load(paramString).transform(new SquareTransformation(paramInt));
      if (paramBoolean)
        localRequestCreator = localRequestCreator.transform(new WhiteIconTransformation(null));
      Bitmap localBitmap = localRequestCreator.get();
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      Timber.d(localIOException, "Failed to load mono bitmap for notification: " + paramString, new Object[0]);
    }
    return null;
  }

  private static class SquareTransformation
    implements Transformation
  {
    private final int mSize;

    SquareTransformation(int paramInt)
    {
      this.mSize = paramInt;
    }

    public String key()
    {
      return "square()";
    }

    public Bitmap transform(Bitmap paramBitmap)
    {
      if ((paramBitmap.getWidth() == this.mSize) && (paramBitmap.getHeight() == this.mSize))
        return paramBitmap;
      if ((paramBitmap.getWidth() > this.mSize) || (paramBitmap.getHeight() > this.mSize))
      {
        Bitmap localBitmap1 = BitmapUtils.scaleToMaxSize(paramBitmap, this.mSize);
        paramBitmap.recycle();
        paramBitmap = localBitmap1;
      }
      int i = this.mSize / 2 - paramBitmap.getWidth() / 2;
      int j = this.mSize / 2 - paramBitmap.getHeight() / 2;
      Bitmap localBitmap2 = Bitmap.createBitmap(this.mSize, this.mSize, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap2).drawBitmap(paramBitmap, i, j, null);
      paramBitmap.recycle();
      return localBitmap2;
    }
  }

  private class WhiteIconTransformation
    implements Transformation
  {
    private WhiteIconTransformation()
    {
    }

    public String key()
    {
      return "invert()";
    }

    public Bitmap transform(Bitmap paramBitmap)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setColorFilter(new PorterDuffColorFilter(NotificationPainter.this.mContext.getResources().getColor(17170443), PorterDuff.Mode.SRC_ATOP));
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      paramBitmap.recycle();
      return localBitmap;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationPainter
 * JD-Core Version:    0.6.2
 */