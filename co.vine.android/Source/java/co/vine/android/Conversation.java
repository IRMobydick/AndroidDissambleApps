package co.vine.android;

import org.json.JSONException;
import org.json.JSONObject;

public class Conversation extends JSONObject
{
  public Conversation(Builder paramBuilder)
    throws JSONException
  {
    put("connected", paramBuilder.connected);
    put("typing", paramBuilder.typing);
    if (paramBuilder.lastMessageId > 0L)
      put("last_message_id", paramBuilder.lastMessageId);
  }

  public static class Builder
  {
    private boolean connected = false;
    private long lastMessageId = 0L;
    private boolean typing = false;

    public Conversation build()
    {
      try
      {
        Conversation localConversation = new Conversation(this);
        return localConversation;
      }
      catch (JSONException localJSONException)
      {
      }
      throw new RuntimeException(localJSONException);
    }

    public Builder setConnected()
    {
      this.connected = true;
      return this;
    }

    public Builder setLastMessageId(long paramLong)
    {
      this.lastMessageId = paramLong;
      return this;
    }

    public Builder setTyping(boolean paramBoolean)
    {
      this.typing = paramBoolean;
      return this;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.Conversation
 * JD-Core Version:    0.6.0
 */