package com.ubercab.client.core.analytics.event;

import java.util.HashMap;
import java.util.Map;

@Deprecated
final class EventBuilder
{
  static final String PARAM_EVENT_NAME = "eventName";
  private static final String PARAM_PARAMETERS = "parameters";
  Map<String, Object> mData = new HashMap();

  Map<String, Object> build()
  {
    return this.mData;
  }

  EventBuilder putParameter(String paramString, Object paramObject)
  {
    if (!this.mData.containsKey("parameters"))
      this.mData.put("parameters", new HashMap());
    ((Map)this.mData.get("parameters")).put(paramString, paramObject);
    return this;
  }

  EventBuilder setEventName(String paramString)
  {
    this.mData.put("eventName", paramString);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.EventBuilder
 * JD-Core Version:    0.6.2
 */