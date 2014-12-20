package co.vine.android;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.widget.Toast;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.util.image.ImageUtils.BitmapInfo;
import java.lang.ref.WeakReference;

class CropActivity$LoadImageTask extends AsyncTask<Void, Void, Bitmap>
{
  private final WeakReference<CropActivity> mActivity;

  CropActivity$LoadImageTask(CropActivity paramCropActivity1, CropActivity paramCropActivity2)
  {
    this.mActivity = new WeakReference(paramCropActivity2);
    paramCropActivity1.mBitmapLoaded = false;
  }

  protected Bitmap doInBackground(Void[] paramArrayOfVoid)
  {
    DisplayMetrics localDisplayMetrics = this.this$0.getResources().getDisplayMetrics();
    ImageUtils.BitmapInfo localBitmapInfo = ImageUtils.safeDecode(this.this$0, this.this$0.mUri, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, true);
    if (localBitmapInfo != null)
    {
      int i = localBitmapInfo.scale;
      this.this$0.mBitmapWidth = localBitmapInfo.origWidth;
      this.this$0.mBitmapHeight = localBitmapInfo.origHeight;
      this.this$0.mBitmapWidthOffset = (localBitmapInfo.origWidth % i);
      this.this$0.mBitmapHeightOffset = (localBitmapInfo.origHeight % i);
      this.this$0.mFileToViewScale = i;
    }
    for (Bitmap localBitmap = localBitmapInfo.bitmap; ; localBitmap = null)
      return localBitmap;
  }

  protected void onPostExecute(Bitmap paramBitmap)
  {
    CropActivity localCropActivity = (CropActivity)this.mActivity.get();
    if (localCropActivity == null)
      return;
    if (paramBitmap != null)
    {
      localCropActivity.mBitmapLoaded = true;
      localCropActivity.onBitmapProcessingDone(paramBitmap);
    }
    while (true)
    {
      this.this$0.removeDialog(1);
      break;
      Toast.makeText(this.this$0, 2131624242, 1).show();
      this.this$0.removeDialog(1);
      this.this$0.setResult(0);
      this.this$0.finish();
    }
  }

  protected void onPreExecute()
  {
    this.this$0.showDialog(1);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CropActivity.LoadImageTask
 * JD-Core Version:    0.6.0
 */