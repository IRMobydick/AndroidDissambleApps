package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ubercab.client.core.util.ContactsUtil;
import com.ubercab.client.core.util.ContactsUtil.Contact;
import com.ubercab.client.core.util.PhotoUtils;
import com.ubercab.ui.FontUtils;

public class ContactChipAdapter
  implements ChipEditText.Adapter
{
  private Context mContext;
  private Drawable mDrawableTokenBg;
  private int mMarginRight;
  private int mPadding;
  private Paint mPaintText;
  private Rect mTextBounds;

  public ContactChipAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    Resources localResources = paramContext.getResources();
    this.mPadding = localResources.getDimensionPixelSize(2131361847);
    this.mMarginRight = localResources.getDimensionPixelSize(2131361848);
    this.mDrawableTokenBg = this.mContext.getResources().getDrawable(2130837912);
    this.mTextBounds = new Rect();
    this.mPaintText = new Paint();
    this.mPaintText.setAntiAlias(true);
    this.mPaintText.setTypeface(FontUtils.getDefaultTypeface(paramContext));
    this.mPaintText.setTextSize(localResources.getDimensionPixelSize(2131361997));
    this.mPaintText.getTextBounds("W", 0, 1, this.mTextBounds);
  }

  public ChipEditText.Chip createChipInBackground(String paramString)
  {
    String str1 = "";
    ContactsUtil.Contact localContact = ContactsUtil.getContactWithPhoneNumber(this.mContext, paramString);
    Bitmap localBitmap = null;
    if (localContact != null)
    {
      str1 = localContact.getDisplayName();
      Uri localUri = localContact.getThumbnailUri();
      localBitmap = null;
      if (localUri != null)
      {
        byte[] arrayOfByte = PhotoUtils.getPhoto(this.mContext, localContact.getThumbnailUri());
        localBitmap = null;
        if (arrayOfByte != null)
          localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("name", str1);
    localBundle.putString("number", paramString);
    localBundle.putParcelable("photo", localBitmap);
    if (!TextUtils.isEmpty(str1));
    for (String str2 = String.format("%s (%s)", new Object[] { str1, paramString }); ; str2 = paramString)
      return new ChipEditText.Chip(paramString, localBundle, str2);
  }

  public Bitmap drawChip(ChipEditText.Chip paramChip, int paramInt)
  {
    Bitmap localBitmap1 = (Bitmap)paramChip.getData().getParcelable("photo");
    String str1 = paramChip.getData().getString("name");
    String str2 = paramChip.getData().getString("number");
    if (!TextUtils.isEmpty(str1));
    for (String str3 = str1; ; str3 = str2)
    {
      int i = (int)(this.mPaintText.measureText(str3) + 2 * this.mPadding);
      float f1 = this.mPadding;
      float f2 = paramInt / 2.0F + this.mTextBounds.height() / 2.0F;
      if (localBitmap1 != null)
        i += paramInt;
      Bitmap localBitmap2 = Bitmap.createBitmap(i + this.mMarginRight, paramInt, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      this.mDrawableTokenBg.setBounds(0, 0, i, paramInt);
      this.mDrawableTokenBg.draw(localCanvas);
      if (localBitmap1 != null)
      {
        Paint localPaint = new Paint();
        localPaint.setFilterBitmap(true);
        localCanvas.drawBitmap(localBitmap1, null, new Rect(this.mPadding, this.mPadding, paramInt - this.mPadding, paramInt - this.mPadding), localPaint);
        f1 += paramInt - this.mPadding / 2;
      }
      localCanvas.drawText(str3, 0, str3.length(), f1, f2, this.mPaintText);
      return localBitmap2;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.ContactChipAdapter
 * JD-Core Version:    0.6.2
 */