package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.Date;
import java.util.List;

public class BusLineResult extends SearchResult
{
  private String a = null;
  private String b = null;
  private boolean c;
  private Date d;
  private Date e;
  private String f;
  private List<BusStation> g = null;
  private List<BusStep> h = null;

  BusLineResult()
  {
  }

  BusLineResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  void a(String paramString)
  {
    this.b = paramString;
  }

  void a(Date paramDate)
  {
    this.d = paramDate;
  }

  void a(List<BusStation> paramList)
  {
    this.g = paramList;
  }

  void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  void b(String paramString)
  {
    this.f = paramString;
  }

  void b(Date paramDate)
  {
    this.e = paramDate;
  }

  void b(List<BusStep> paramList)
  {
    this.h = paramList;
  }

  public String getBusCompany()
  {
    return this.a;
  }

  public String getBusLineName()
  {
    return this.b;
  }

  public Date getEndTime()
  {
    return this.e;
  }

  public Date getStartTime()
  {
    return this.d;
  }

  public List<BusStation> getStations()
  {
    return this.g;
  }

  public List<BusStep> getSteps()
  {
    return this.h;
  }

  public String getUid()
  {
    return this.f;
  }

  public boolean isMonthTicket()
  {
    return this.c;
  }

  public static class BusStation extends RouteNode
  {
  }

  public static class BusStep extends RouteStep
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.busline.BusLineResult
 * JD-Core Version:    0.6.2
 */