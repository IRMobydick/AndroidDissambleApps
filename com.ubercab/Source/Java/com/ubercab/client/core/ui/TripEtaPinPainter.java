package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.ui.FontUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TripEtaPinPainter
{
  private static final SimpleDateFormat DATE_FORMAT_12 = new SimpleDateFormat("h:mm", Locale.US);
  private static final SimpleDateFormat DATE_FORMAT_24 = new SimpleDateFormat("H:mm", Locale.US);
  private static final SimpleDateFormat DATE_FORMAT_AMPM = new SimpleDateFormat("aa", Locale.US);
  private final Drawable mDrawableDestinationBg;
  private final Drawable mDrawablePickupBg;
  private final boolean mIs24HourFormat;
  private int mLineSpacing;
  private String mMinLabel;
  private final Paint mPaintTextLine1;
  private final Paint mPaintTextLine2;

  public TripEtaPinPainter(Context paramContext)
  {
    RiderApplication.get(paramContext).inject(this);
    this.mIs24HourFormat = DateFormat.is24HourFormat(paramContext);
    this.mMinLabel = paramContext.getString(2131558927).toUpperCase(Locale.getDefault());
    paramContext.getAssets();
    Resources localResources = paramContext.getResources();
    this.mDrawablePickupBg = localResources.getDrawable(2130837846);
    this.mDrawableDestinationBg = localResources.getDrawable(2130837845);
    this.mLineSpacing = localResources.getDimensionPixelSize(2131361965);
    this.mDrawablePickupBg.setBounds(0, 0, this.mDrawablePickupBg.getIntrinsicWidth(), this.mDrawablePickupBg.getIntrinsicHeight());
    this.mDrawableDestinationBg.setBounds(0, 0, this.mDrawableDestinationBg.getIntrinsicWidth(), this.mDrawableDestinationBg.getIntrinsicHeight());
    this.mPaintTextLine1 = new Paint();
    this.mPaintTextLine1.setAntiAlias(true);
    this.mPaintTextLine1.setColor(-1);
    this.mPaintTextLine1.setTypeface(FontUtils.getTypefaceFromResource(paramContext, 2131559278));
    this.mPaintTextLine1.setTextSize(localResources.getDimensionPixelSize(2131361994));
    this.mPaintTextLine1.setTextAlign(Paint.Align.CENTER);
    this.mPaintTextLine2 = new Paint();
    this.mPaintTextLine2.setAntiAlias(true);
    this.mPaintTextLine2.setColor(-1);
    this.mPaintTextLine2.setTypeface(FontUtils.getTypefaceFromResource(paramContext, 2131559274));
    this.mPaintTextLine2.setTextSize(localResources.getDimensionPixelSize(2131361995));
    this.mPaintTextLine2.setTextAlign(Paint.Align.CENTER);
  }

  private Bitmap draw(Drawable paramDrawable, String paramString1, String paramString2)
  {
    Paint localPaint1 = this.mPaintTextLine1;
    Paint localPaint2 = this.mPaintTextLine2;
    Rect localRect1 = paramDrawable.getBounds();
    Rect localRect2 = new Rect();
    localPaint1.getTextBounds(paramString1, 0, paramString1.length(), localRect2);
    Rect localRect3 = new Rect();
    if (!TextUtils.isEmpty(paramString2))
      localPaint2.getTextBounds(paramString2, 0, paramString2.length(), localRect3);
    Bitmap localBitmap = Bitmap.createBitmap(localRect1.width(), localRect1.height(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect4 = new Rect();
    paramDrawable.getPadding(localRect4);
    Rect localRect5 = new Rect(localRect4.left, localRect4.top, localRect1.width() - localRect4.right, localRect1.height() - localRect4.bottom);
    Paint localPaint3 = new Paint(localPaint1);
    float f3;
    if (localRect2.width() > localRect5.width())
    {
      f3 = localPaint3.getTextSize() - 0.5F;
      if (f3 > 0.0F);
    }
    for (Paint localPaint4 = this.mPaintTextLine1; ; localPaint4 = localPaint3)
    {
      paramDrawable.draw(localCanvas);
      localCanvas.translate(localRect5.left, localRect5.top);
      int i = localRect2.height() + localRect3.height();
      if (!TextUtils.isEmpty(paramString2))
        i += this.mLineSpacing;
      if (!TextUtils.isEmpty(paramString2))
      {
        float f1 = localRect5.width() / 2.0F;
        float f2 = localRect5.height() / 2.0F - i / 2.0F + localRect2.height();
        localCanvas.drawText(paramString1, f1, f2, localPaint4);
        localCanvas.drawText(paramString2, localRect5.width() / 2.0F, f2 + (localRect3.height() + this.mLineSpacing), localPaint2);
        return localBitmap;
        localPaint3.setTextSize(f3);
        localPaint3.getTextBounds(paramString1, 0, paramString1.length(), localRect2);
        break;
      }
      localCanvas.drawText(paramString1, localRect5.width() / 2.0F, localRect5.height() / 2.0F + i / 2.0F, localPaint4);
      return localBitmap;
    }
  }

  public Bitmap drawDestination(int paramInt, boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(13, paramInt);
    Date localDate = localCalendar.getTime();
    if (paramBoolean)
    {
      if (this.mIs24HourFormat)
      {
        String str4 = DATE_FORMAT_24.format(localDate);
        return draw(this.mDrawableDestinationBg, str4, null);
      }
      String str2 = DATE_FORMAT_12.format(localDate);
      String str3 = DATE_FORMAT_AMPM.format(localDate);
      return draw(this.mDrawableDestinationBg, str2, str3);
    }
    String str1 = String.valueOf(paramInt / 60);
    return draw(this.mDrawableDestinationBg, str1, this.mMinLabel);
  }

  public Bitmap drawPickup(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    int i;
    do
    {
      return null;
      i = paramString.indexOf(" ");
    }
    while (i <= 0);
    return draw(this.mDrawablePickupBg, paramString.substring(0, i), this.mMinLabel);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.TripEtaPinPainter
 * JD-Core Version:    0.6.2
 */