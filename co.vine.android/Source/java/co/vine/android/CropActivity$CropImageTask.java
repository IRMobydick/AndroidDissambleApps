package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import co.vine.android.client.AppController;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.util.image.ImageUtils.BitmapInfo;
import co.vine.android.widget.CroppableImageView;
import java.io.ByteArrayOutputStream;

class CropActivity$CropImageTask extends AsyncTask<Void, Void, Boolean>
{
  CropActivity mActivity;
  final int mBitmapHeight;
  final int mBitmapHeightOffset;
  final int mBitmapWidth;
  final int mBitmapWidthOffset;
  final Context mContext;
  final Rect mCropRect;
  final int mFileToViewScale;
  final Intent mIntent;
  final Uri mUri;
  ImageView mView;
  Bitmap mViewBitmap;

  CropActivity$CropImageTask(CropActivity paramCropActivity)
  {
    this.mActivity = paramCropActivity;
    this.mContext = paramCropActivity.getApplicationContext();
    this.mFileToViewScale = paramCropActivity.mFileToViewScale;
    this.mBitmapWidthOffset = paramCropActivity.mBitmapWidthOffset;
    this.mBitmapHeightOffset = paramCropActivity.mBitmapHeightOffset;
    this.mBitmapHeight = paramCropActivity.mBitmapHeight;
    this.mBitmapWidth = paramCropActivity.mBitmapWidth;
    this.mUri = paramCropActivity.mUri;
    this.mIntent = new Intent();
    this.mView = paramCropActivity.mView;
    RectF localRectF = ((CroppableImageView)this.mView).getCropRect();
    this.mCropRect = new Rect((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
  }

  private Boolean basicCrop()
  {
    Context localContext = this.mContext;
    Rect localRect1 = this.mCropRect;
    Bitmap localBitmap1 = this.mViewBitmap;
    Boolean localBoolean;
    if (localBitmap1 == null)
      localBoolean = Boolean.FALSE;
    while (true)
    {
      return localBoolean;
      Rect localRect2 = new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight());
      int i = localRect1.height();
      if ((localRect1.width() <= 1) || (i <= 1))
      {
        localBoolean = Boolean.FALSE;
        continue;
      }
      if (localRect2.contains(localRect1))
      {
        Bitmap localBitmap2 = ImageUtils.createBitmap(localContext, localBitmap1, localRect1.left, localRect1.top, localRect1.width(), localRect1.height());
        if (localBitmap2 != null)
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          localBitmap2.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
          ImageUtils.BitmapInfo localBitmapInfo = ImageUtils.resizeBitmap(localContext, localByteArrayOutputStream.toByteArray(), 200, 200);
          if ((localBitmapInfo != null) && (localBitmapInfo.bitmap != null))
          {
            long l = AppController.getInstance(localContext).getActiveId();
            Uri localUri = ImageUtils.writePicToFile(localContext, localBitmapInfo.bitmap, l);
            if (localUri != null)
            {
              int j = this.mFileToViewScale;
              localRect1.set(j * localRect1.left, j * localRect1.top, j * (localRect1.right - this.mBitmapWidthOffset), j * (localRect1.bottom - this.mBitmapHeightOffset));
              this.mIntent.putExtra("cropped_rect", localRect1);
              this.mIntent.putExtra("uri", localUri);
              localBoolean = Boolean.TRUE;
              continue;
            }
          }
        }
      }
      localBoolean = Boolean.FALSE;
    }
  }

  public void attachActivity(CropActivity paramCropActivity)
  {
    this.mActivity = paramCropActivity;
  }

  public void detachActivity()
  {
    this.mActivity = null;
    this.mView = null;
  }

  protected Boolean doInBackground(Void[] paramArrayOfVoid)
  {
    return basicCrop();
  }

  protected void onPostExecute(Boolean paramBoolean)
  {
    if (this.mActivity != null)
    {
      this.mActivity.removeDialog(0);
      this.mActivity.onCropDone(paramBoolean.booleanValue(), this.mIntent);
    }
  }

  protected void onPreExecute()
  {
    ImageView localImageView = this.mView;
    if ((this.mActivity != null) && (localImageView != null) && (localImageView.getDrawable() != null))
    {
      this.mViewBitmap = ((BitmapDrawable)localImageView.getDrawable()).getBitmap();
      this.mActivity.showDialog(0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CropActivity.CropImageTask
 * JD-Core Version:    0.6.0
 */