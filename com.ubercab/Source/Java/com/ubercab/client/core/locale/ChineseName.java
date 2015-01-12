package com.ubercab.client.core.locale;

import com.ubercab.common.collect.ImmutableList.Builder;
import java.util.List;

public class ChineseName
{
  private static final List<String> FOUR_LETTER_CHINESE_COMPOUND_SURNAMES = new ImmutableList.Builder().add("愛新覺羅").add("爱新觉罗").add("孛兒只斤").add("孛儿只斤").build();
  private static final List<String> THREE_LETTER_CHINESE_COMPOUND_SURNAMES = new ImmutableList.Builder().add("阿史那").add("赫舍里").build();
  private static final List<String> TWO_LETTER_CHINESE_COMPOUND_SURNAMES = new ImmutableList.Builder().add("百里").add("淳于").add("第五").add("東方").add("东方").add("東閣").add("东阁").add("東郭").add("东郭").add("東門").add("东门").add("端木").add("獨孤").add("独孤").add("公孫").add("公孙").add("公羊").add("公冶").add("公西").add("毌丘").add("穀梁").add("賀蘭").add("贺兰").add("赫連").add("赫连").add("賀若").add("贺若").add("皇甫").add("呼延").add("令狐").add("甪里").add("閭丘").add("闾丘").add("万俟").add("慕容").add("納蘭").add("纳兰").add("南宮").add("南宫").add("歐陽").add("欧阳").add("沙吒").add("上官").add("申屠").add("司馬").add("司马").add("司徒").add("司空").add("司寇").add("太史").add("澹臺").add("澹台").add("拓跋").add("完顏").add("完颜").add("聞人").add("闻人").add("巫馬").add("巫马").add("夏侯").add("鮮于").add("鲜于").add("西門").add("西门").add("軒轅").add("轩辕").add("楊子").add("杨子").add("耶律").add("樂正").add("乐正").add("尉遲").add("尉迟").add("宇文").add("長孫").add("长孙").add("鍾離").add("钟离").add("諸葛").add("诸葛").add("祝融").add("子車").add("子车").add("左人").build();
  String mFirstName;
  String mFullName;
  String mLastName;

  public ChineseName(String paramString)
  {
    this.mFullName = paramString;
    resolveName(paramString);
  }

  public ChineseName(String paramString1, String paramString2)
  {
    this.mLastName = paramString2;
    this.mFirstName = paramString1;
    this.mFullName = (paramString2 + paramString1);
  }

  private void resolveName(String paramString)
  {
    int i = 1;
    switch (paramString.length())
    {
    default:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 4:
    case 3:
    }
    while (true)
    {
      this.mLastName = paramString.substring(0, i);
      this.mFirstName = paramString.substring(i);
      return;
      if (FOUR_LETTER_CHINESE_COMPOUND_SURNAMES.contains(paramString.substring(0, 4)))
        i = 4;
      else if (THREE_LETTER_CHINESE_COMPOUND_SURNAMES.contains(paramString.substring(0, 3)))
        i = 3;
      else if (TWO_LETTER_CHINESE_COMPOUND_SURNAMES.contains(paramString.substring(0, 2)))
        i = 2;
    }
  }

  public String getFirstName()
  {
    return this.mFirstName;
  }

  public String getLastName()
  {
    return this.mLastName;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.ChineseName
 * JD-Core Version:    0.6.2
 */