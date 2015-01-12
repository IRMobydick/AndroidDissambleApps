package com.baidu.mapapi.cloud;

import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

class a extends Handler
{
  a(CloudManager paramCloudManager)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    if (CloudManager.a(this.a) == null);
    while ((paramMessage.what != 131072) || (CloudManager.b(this.a) == null))
      return;
    String str2;
    switch (paramMessage.arg1)
    {
    default:
      return;
    case 10001:
      if (paramMessage.arg2 == 0)
        str2 = CloudManager.a(this.a, 10001);
      break;
    case 10002:
    }
    for (CloudSearchResult localCloudSearchResult = new CloudSearchResult(); ; localCloudSearchResult = null)
    {
      try
      {
        localCloudSearchResult.a(new JSONObject(str2));
        CloudManager.b(this.a).onGetSearchResult(localCloudSearchResult, paramMessage.arg2);
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          CloudManager.b(this.a).onGetSearchResult(null, -1);
        }
      }
      int i = paramMessage.arg2;
      Object localObject = null;
      String str1;
      DetailSearchResult localDetailSearchResult;
      if (i == 0)
      {
        str1 = CloudManager.a(this.a, 10002);
        localDetailSearchResult = new DetailSearchResult();
      }
      try
      {
        localDetailSearchResult.a(new JSONObject(str1));
        localObject = localDetailSearchResult;
        CloudManager.b(this.a).onGetDetailSearchResult(localObject, paramMessage.arg2);
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          CloudManager.b(this.a).onGetDetailSearchResult(null, -1);
          localObject = localDetailSearchResult;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.a
 * JD-Core Version:    0.6.2
 */