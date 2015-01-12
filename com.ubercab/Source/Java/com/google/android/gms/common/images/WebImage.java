package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new b();
  private final int BR;
  private final Uri KQ;
  private final int lf;
  private final int lg;

  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.BR = paramInt1;
    this.KQ = paramUri;
    this.lf = paramInt2;
    this.lg = paramInt3;
  }

  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }

  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null)
      throw new IllegalArgumentException("url cannot be null");
    if ((paramInt1 < 0) || (paramInt2 < 0))
      throw new IllegalArgumentException("width and height must not be negative");
  }

  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(d(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }

  private static Uri d(JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.has("url");
    Object localObject = null;
    if (bool);
    try
    {
      Uri localUri = Uri.parse(paramJSONObject.getString("url"));
      localObject = localUri;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public JSONObject bK()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.KQ.toString());
      localJSONObject.put("width", this.lf);
      localJSONObject.put("height", this.lg);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    WebImage localWebImage;
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof WebImage)))
        return false;
      localWebImage = (WebImage)paramObject;
    }
    while ((n.equal(this.KQ, localWebImage.KQ)) && (this.lf == localWebImage.lf) && (this.lg == localWebImage.lg));
    return false;
  }

  public int getHeight()
  {
    return this.lg;
  }

  public Uri getUrl()
  {
    return this.KQ;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public int getWidth()
  {
    return this.lf;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.KQ;
    arrayOfObject[1] = Integer.valueOf(this.lf);
    arrayOfObject[2] = Integer.valueOf(this.lg);
    return n.hashCode(arrayOfObject);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.lf);
    arrayOfObject[1] = Integer.valueOf(this.lg);
    arrayOfObject[2] = this.KQ.toString();
    return String.format("Image %dx%d %s", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.6.2
 */