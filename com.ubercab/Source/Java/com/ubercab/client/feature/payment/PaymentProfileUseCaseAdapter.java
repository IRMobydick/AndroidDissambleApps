package com.ubercab.client.feature.payment;

import android.content.Context;
import android.widget.SimpleAdapter;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;

class PaymentProfileUseCaseAdapter extends SimpleAdapter
{
  private static final String LABEL = "label";
  static final List<String> USE_CASES = ImmutableList.of("personal", "business");
  private static final String VALUE = "value";

  PaymentProfileUseCaseAdapter(Context paramContext)
  {
    super(paramContext, createData(paramContext), 17367048, new String[] { "label" }, new int[] { 16908308 });
    setDropDownViewResource(17367049);
  }

  private static List<Map<String, ?>> createData(Context paramContext)
  {
    String str1 = paramContext.getString(2131559001);
    String str2 = paramContext.getString(2131558464);
    return ImmutableList.of(ImmutableMap.of("value", "personal", "label", str1), ImmutableMap.of("value", "business", "label", str2));
  }

  public Map<String, ?> getItem(int paramInt)
  {
    return (Map)super.getItem(paramInt);
  }

  String getValue(int paramInt)
  {
    return (String)getItem(paramInt).get("value");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentProfileUseCaseAdapter
 * JD-Core Version:    0.6.2
 */