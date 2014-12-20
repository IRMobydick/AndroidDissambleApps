package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import java.io.FileNotFoundException;

class PrintHelperKitkat$2$1 extends AsyncTask<Uri, Boolean, Bitmap>
{
  protected Bitmap doInBackground(Uri[] paramArrayOfUri)
  {
    try
    {
      Bitmap localBitmap2 = PrintHelperKitkat.access$200(this.this$1.this$0, this.this$1.val$imageFile, 3500);
      localBitmap1 = localBitmap2;
      return localBitmap1;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        Bitmap localBitmap1 = null;
    }
  }

  protected void onCancelled(Bitmap paramBitmap)
  {
    this.val$layoutResultCallback.onLayoutCancelled();
  }

  protected void onPostExecute(Bitmap paramBitmap)
  {
    int i = 1;
    super.onPostExecute(paramBitmap);
    this.this$1.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(this.this$1.val$jobName).setContentType(i).setPageCount(i).build();
      if (!this.val$newPrintAttributes.equals(this.val$oldPrintAttributes))
        this.val$layoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
    }
    while (true)
    {
      return;
      int j = 0;
      break;
      this.val$layoutResultCallback.onLayoutFailed(null);
    }
  }

  protected void onPreExecute()
  {
    this.val$cancellationSignal.setOnCancelListener(new PrintHelperKitkat.2.1.1(this));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat.2.1
 * JD-Core Version:    0.6.0
 */