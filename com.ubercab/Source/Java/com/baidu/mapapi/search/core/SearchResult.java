package com.baidu.mapapi.search.core;

public class SearchResult
{
  public ERRORNO error;

  public SearchResult()
  {
    this.error = ERRORNO.NO_ERROR;
  }

  public SearchResult(ERRORNO paramERRORNO)
  {
    this.error = paramERRORNO;
  }

  public static enum ERRORNO
  {
    static
    {
      AMBIGUOUS_KEYWORD = new ERRORNO("AMBIGUOUS_KEYWORD", 2);
      AMBIGUOUS_ROURE_ADDR = new ERRORNO("AMBIGUOUS_ROURE_ADDR", 3);
      NOT_SUPPORT_BUS = new ERRORNO("NOT_SUPPORT_BUS", 4);
      NOT_SUPPORT_BUS_2CITY = new ERRORNO("NOT_SUPPORT_BUS_2CITY", 5);
      ST_EN_TOO_NEAR = new ERRORNO("ST_EN_TOO_NEAR", 6);
      ERRORNO[] arrayOfERRORNO = new ERRORNO[7];
      arrayOfERRORNO[0] = NO_ERROR;
      arrayOfERRORNO[1] = RESULT_NOT_FOUND;
      arrayOfERRORNO[2] = AMBIGUOUS_KEYWORD;
      arrayOfERRORNO[3] = AMBIGUOUS_ROURE_ADDR;
      arrayOfERRORNO[4] = NOT_SUPPORT_BUS;
      arrayOfERRORNO[5] = NOT_SUPPORT_BUS_2CITY;
      arrayOfERRORNO[6] = ST_EN_TOO_NEAR;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.core.SearchResult
 * JD-Core Version:    0.6.2
 */