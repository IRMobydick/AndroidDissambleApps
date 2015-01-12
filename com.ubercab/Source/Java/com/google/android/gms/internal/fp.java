package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public class fp
  implements fo.a<bo>
{
  public bo b(fo paramfo, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Future localFuture1 = paramfo.a(paramJSONObject, "image", true);
    Future localFuture2 = paramfo.a(paramJSONObject, "app_icon", true);
    return new bo(paramJSONObject.getString("headline"), (Drawable)localFuture1.get(), paramJSONObject.getString("body"), (Drawable)localFuture2.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.optDouble("rating", -1.0D), paramJSONObject.optString("store"), paramJSONObject.optString("price"));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fp
 * JD-Core Version:    0.6.2
 */