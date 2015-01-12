package com.ubercab.client.feature.notification.data;

import android.os.Bundle;
import com.ubercab.library.util.StringUtils;

public final class MessageNotificationData extends NotificationData
{
  private static final String KEY_LARGE_IMAGE_URL = "large_image_url";
  private static final String KEY_TEXT = "text";
  private static final String KEY_TICKER = "ticker";
  private static final String KEY_TITLE = "title";
  private static final String KEY_URL = "url";
  public static final String TYPE = "message";
  private String mImageUrl;
  private String mText;
  private String mTicker;
  private String mTitle;
  private String mUrl;

  private MessageNotificationData(NotificationData.Source paramSource)
  {
    super("message", paramSource);
  }

  public static MessageNotificationData createFakeData()
  {
    MessageNotificationData localMessageNotificationData = new MessageNotificationData(NotificationData.Source.FAKE);
    localMessageNotificationData.mTitle = "Breaking News";
    localMessageNotificationData.mText = "The quick brown fox jumps over the lazy dog!!";
    localMessageNotificationData.mTicker = "Breaking News: The quick brown fox jumps over the lazy dog!!";
    localMessageNotificationData.mImageUrl = null;
    localMessageNotificationData.mUrl = "https://uber.com";
    return localMessageNotificationData;
  }

  public static MessageNotificationData fromGcmBundle(Bundle paramBundle)
  {
    MessageNotificationData localMessageNotificationData = new MessageNotificationData(NotificationData.Source.PUSH);
    localMessageNotificationData.mTitle = paramBundle.getString("title");
    localMessageNotificationData.mText = paramBundle.getString("text");
    localMessageNotificationData.mTicker = paramBundle.getString("ticker");
    localMessageNotificationData.mImageUrl = paramBundle.getString("large_image_url");
    localMessageNotificationData.mUrl = paramBundle.getString("url");
    return localMessageNotificationData;
  }

  public String getLargeImageUrl()
  {
    return this.mImageUrl;
  }

  public String getTag()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.mTitle;
    arrayOfObject[1] = this.mText;
    arrayOfObject[2] = this.mTicker;
    arrayOfObject[3] = this.mImageUrl;
    arrayOfObject[4] = this.mUrl;
    return StringUtils.md5(String.format("%s%s%s%s%s", arrayOfObject));
  }

  public String getText()
  {
    return this.mText;
  }

  public String getTicker()
  {
    return this.mTicker;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getUrl()
  {
    return this.mUrl;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.MessageNotificationData
 * JD-Core Version:    0.6.2
 */