package com.ubercab.client.core.vendor.google;

import android.net.Uri;
import android.text.TextUtils;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.AddressComponent;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.library.location.model.UberLatLng;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GmmUtils
{
  private static final Pattern ADDRESS_PARTS = Pattern.compile("(\\w+)\\[([\\w_,]+)\\]\\[?(\\w+)?\\]?=(.*?)(?:&|$)");
  private static final String DESCRIPTION_TYPE_LONG_NAME = "long_name";
  private static final String DESCRIPTION_TYPE_SHORT_NAME = "short_name";
  private static final List<String> LIST_ADDRESS_COMPONENT_TYPES = new ImmutableList.Builder().add("street_number").add("route").add("locality").add("postal_code").add("administrative_area_level_1").add("administrative_area_level_2").add("country").build();
  private static final String PARAMETER_LOCATION_DROPOFF = "dropoff";
  private static final String PARAMETER_LOCATION_PICKUP = "pickup";
  private static final String PARAMETER_MY_LOCATION = "my_location";
  private static final String PARAMETER_PRODUCT_ID = "product_id";
  private static final String PARAMETER_SURGE = "surge";
  private static final String TYPE_FORMATTED_ADDRESS = "formatted_address";
  private static final String TYPE_LATITUDE = "latitude";
  private static final String TYPE_LONGITUDE = "longitude";
  private static final String TYPE_NICKNAME = "nickname";

  private static AddressComponent createAddressComponent(List<GmmLocationParameter> paramList, String paramString)
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = "";
    Object localObject2 = "";
    String str1 = "";
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GmmLocationParameter localGmmLocationParameter = (GmmLocationParameter)localIterator.next();
      if (localGmmLocationParameter.getAddressTypes().contains(paramString))
      {
        localHashSet.addAll(localGmmLocationParameter.getAddressTypes());
        String str2 = localGmmLocationParameter.getDescriptionType();
        if (TextUtils.isEmpty(str2))
        {
          str1 = localGmmLocationParameter.getValue();
        }
        else
        {
          if ("short_name".equals(str2))
            localObject2 = localGmmLocationParameter.getValue();
          if ("long_name".equals(str2))
            localObject1 = localGmmLocationParameter.getValue();
        }
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty(str1)))
      return null;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(str1))
        localObject1 = localObject2;
    }
    else if (TextUtils.isEmpty((CharSequence)localObject2))
      if (!TextUtils.isEmpty(str1))
        break label242;
    label242: for (localObject2 = localObject1; ; localObject2 = str1)
    {
      AddressComponent localAddressComponent = new AddressComponent();
      localAddressComponent.setShortName((String)localObject2);
      localAddressComponent.setLongName((String)localObject1);
      localAddressComponent.setTypes(new ArrayList(localHashSet));
      return localAddressComponent;
      localObject1 = str1;
      break;
    }
  }

  private static List<AddressComponent> createAddressComponents(List<GmmLocationParameter> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = LIST_ADDRESS_COMPONENT_TYPES.iterator();
    while (localIterator.hasNext())
    {
      AddressComponent localAddressComponent = createAddressComponent(paramList, (String)localIterator.next());
      if (localAddressComponent != null)
        localArrayList.add(localAddressComponent);
    }
    return localArrayList;
  }

  public static RiderLocation createDropoffLocation(Uri paramUri, RiderLocation paramRiderLocation)
  {
    if ("my_location".equals(paramUri.getQueryParameter("dropoff")))
      return paramRiderLocation;
    return createRiderLocation(paramUri, "dropoff");
  }

  public static RiderLocation createPickupLocation(Uri paramUri, RiderLocation paramRiderLocation)
  {
    if ("my_location".equals(paramUri.getQueryParameter("pickup")))
      return paramRiderLocation;
    return createRiderLocation(paramUri, "pickup");
  }

  private static RiderLocation createRiderLocation(Uri paramUri, String paramString)
  {
    List localList = getLocationsForType(parseLocationParameters(paramUri.getEncodedQuery()), paramString);
    String str1 = getValueForType(localList, "latitude");
    String str2 = getValueForType(localList, "longitude");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      return null;
    UberLatLng localUberLatLng = new UberLatLng(Double.parseDouble(str1), Double.parseDouble(str2));
    String str3 = getValueForType(localList, "nickname");
    String str4 = getValueForType(localList, "formatted_address");
    return RiderLocation.create(localUberLatLng, createAddressComponents(localList), str4, str3);
  }

  private static List<GmmLocationParameter> getLocationsForType(List<GmmLocationParameter> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GmmLocationParameter localGmmLocationParameter = (GmmLocationParameter)localIterator.next();
      if (localGmmLocationParameter.getLocationType().equals(paramString))
        localArrayList.add(localGmmLocationParameter);
    }
    return localArrayList;
  }

  private static String getValueForType(List<GmmLocationParameter> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GmmLocationParameter localGmmLocationParameter = (GmmLocationParameter)localIterator.next();
      if (localGmmLocationParameter.getAddressTypes().contains(paramString))
        return localGmmLocationParameter.getValue();
    }
    return null;
  }

  private static List<GmmLocationParameter> parseLocationParameters(String paramString)
  {
    Matcher localMatcher = ADDRESS_PARTS.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (true)
      if (localMatcher.find())
      {
        String str1 = localMatcher.group(1);
        String str2 = localMatcher.group(2);
        if (str2 == null)
          str2 = "";
        List localList = Arrays.asList(str2.split(","));
        String str3 = localMatcher.group(3);
        try
        {
          String str5 = URLDecoder.decode(localMatcher.group(4), "utf-8");
          str4 = str5;
          localArrayList.add(new GmmLocationParameter(str1, localList, str3, str4));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          while (true)
            String str4 = "";
        }
      }
    return localArrayList;
  }

  public static String parseProductId(Uri paramUri)
  {
    return paramUri.getQueryParameter("product_id");
  }

  public static Float parseSurge(Uri paramUri)
  {
    String str = paramUri.getQueryParameter("surge");
    if (TextUtils.isEmpty(str))
      return null;
    return Float.valueOf(Float.parseFloat(str));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GmmUtils
 * JD-Core Version:    0.6.2
 */