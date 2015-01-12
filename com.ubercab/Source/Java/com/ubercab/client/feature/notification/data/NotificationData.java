package com.ubercab.client.feature.notification.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ubercab.client.core.util.NumberUtils;

public abstract class NotificationData
{
  private static final String KEY_MESSAGE_IDENTIFIER = "message_identifier";
  private static final String KEY_TIMESTAMP = "timestamp";
  private static final String KEY_TYPE = "type";
  private int mMessageIdentifier;
  private final Source mSource;
  protected Long mTimestamp;
  private final String mType;

  protected NotificationData(String paramString, Source paramSource)
  {
    this.mSource = paramSource;
    this.mType = paramString;
  }

  public static NotificationData fromGcmBundle(Gson paramGson, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("type");
    Object localObject;
    if (TextUtils.isEmpty(str1))
    {
      localObject = null;
      return localObject;
    }
    label84: int i;
    switch (str1.hashCode())
    {
    default:
      i = -1;
      label86: localObject = null;
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      break;
    case 3568677:
    case 120981341:
    case 597429311:
    case 954925063:
    case 1082290744:
    case 109803310:
    }
    while (localObject != null)
    {
      String str2 = paramBundle.getString("message_identifier");
      String str3 = paramBundle.getString("timestamp");
      ((NotificationData)localObject).mMessageIdentifier = NumberUtils.tryParseInteger(str2, -1);
      ((NotificationData)localObject).mTimestamp = Long.valueOf(NumberUtils.tryParseLong(str3, 0L));
      return localObject;
      if (!str1.equals("trip"))
        break label84;
      i = 0;
      break label86;
      if (!str1.equals("fare_split_accepted"))
        break label84;
      i = 1;
      break label86;
      if (!str1.equals("fare_split_invite"))
        break label84;
      i = 2;
      break label86;
      if (!str1.equals("message"))
        break label84;
      i = 3;
      break label86;
      if (!str1.equals("receipt"))
        break label84;
      i = 4;
      break label86;
      if (!str1.equals("surge"))
        break label84;
      i = 5;
      break label86;
      localObject = TripNotificationData.fromGcmBundle(paramGson, paramBundle);
      continue;
      localObject = FareSplitAcceptedNotificationData.fromGcmBundle(paramBundle);
      continue;
      localObject = FareSplitInviteNotificationData.fromGcmBundle(paramBundle);
      continue;
      localObject = MessageNotificationData.fromGcmBundle(paramBundle);
      continue;
      localObject = ReceiptNotificationData.fromGcmBundle(paramBundle);
      continue;
      localObject = SurgeNotificationData.fromGcmBundle(paramBundle);
    }
  }

  public int getMessageIdentifier()
  {
    return this.mMessageIdentifier;
  }

  public Source getSource()
  {
    return this.mSource;
  }

  public abstract String getTag();

  public Long getTimestamp()
  {
    return this.mTimestamp;
  }

  public String getType()
  {
    return this.mType;
  }

  public static enum Source
  {
    static
    {
      PING = new Source("PING", 1);
      FAKE = new Source("FAKE", 2);
      Source[] arrayOfSource = new Source[3];
      arrayOfSource[0] = PUSH;
      arrayOfSource[1] = PING;
      arrayOfSource[2] = FAKE;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.NotificationData
 * JD-Core Version:    0.6.2
 */