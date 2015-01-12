package com.ubercab.client.feature.payment.reward;

import android.content.Context;
import com.ubercab.client.core.model.Balance;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class PointBalanceFormatter
{
  private static final String CURRENCY_SYMBOL_PLACEHOLDER = "¤";
  private final Context mContext;

  public PointBalanceFormatter(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private DecimalFormat createCurrencyFormat(String paramString)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat(getFormatPattern(paramString));
    localDecimalFormat.setRoundingMode(RoundingMode.DOWN);
    return localDecimalFormat;
  }

  private String getFormatPattern(String paramString)
  {
    DecimalFormat localDecimalFormat = (DecimalFormat)NumberFormat.getCurrencyInstance();
    localDecimalFormat.setGroupingUsed(false);
    localDecimalFormat.setMaximumFractionDigits(0);
    String str = Currency.getInstance(paramString).getSymbol(Locale.US);
    return localDecimalFormat.toLocalizedPattern().replace("¤", str).replaceAll("'|\\s", "");
  }

  public String format(Balance paramBalance)
  {
    String str1 = paramBalance.getCurrencyCode();
    if (str1 == null)
      str1 = "";
    String str2 = NumberFormat.getIntegerInstance().format(paramBalance.getRewardsAmount());
    String str3 = createCurrencyFormat(str1).format(paramBalance.getCurrencyAmount());
    return this.mContext.getString(2131559039, new Object[] { str2, str3 });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.reward.PointBalanceFormatter
 * JD-Core Version:    0.6.2
 */