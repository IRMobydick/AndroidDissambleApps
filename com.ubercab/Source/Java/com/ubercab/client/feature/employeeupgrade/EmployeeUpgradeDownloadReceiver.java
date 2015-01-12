package com.ubercab.client.feature.employeeupgrade;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;

public class EmployeeUpgradeDownloadReceiver extends BroadcastReceiver
{
  private long mDownloadId;

  public EmployeeUpgradeDownloadReceiver(long paramLong)
  {
    this.mDownloadId = paramLong;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    DownloadManager localDownloadManager = (DownloadManager)paramContext.getSystemService("download");
    Long localLong = Long.valueOf(paramIntent.getLongExtra("extra_download_id", 0L));
    int i;
    if (localLong.longValue() == this.mDownloadId)
    {
      DownloadManager.Query localQuery = new DownloadManager.Query();
      long[] arrayOfLong = new long[1];
      arrayOfLong[0] = localLong.longValue();
      Cursor localCursor = localDownloadManager.query(localQuery.setFilterById(arrayOfLong));
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        i = localCursor.getInt(localCursor.getColumnIndex("status"));
        if (i != 8)
          break label142;
        EmployeeUpgradeUtils.startInstallIntent(paramContext, Uri.fromFile(new File(localCursor.getString(localCursor.getColumnIndex("local_filename")))));
      }
    }
    label142: 
    while (i != 16)
      return;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(2131559132);
    localBuilder.setNeutralButton(2131559291, null);
    localBuilder.show();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeDownloadReceiver
 * JD-Core Version:    0.6.2
 */