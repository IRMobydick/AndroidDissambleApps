package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONObject;

public final class BDLocation
  implements n, Parcelable
{
  public static final Parcelable.Creator CREATOR = new BDLocation.1();
  public static final int OPERATORS_TYPE_MOBILE = 1;
  public static final int OPERATORS_TYPE_TELECOMU = 3;
  public static final int OPERATORS_TYPE_UNICOM = 2;
  public static final int OPERATORS_TYPE_UNKONW = 0;
  public static final int TypeCacheLocation = 65;
  public static final int TypeCriteriaException = 62;
  public static final int TypeGpsLocation = 61;
  public static final int TypeNetWorkException = 63;
  public static final int TypeNetWorkLocation = 161;
  public static final int TypeNone = 0;
  public static final int TypeOffLineLocation = 66;
  public static final int TypeOffLineLocationFail = 67;
  public static final int TypeOffLineLocationNetworkFail = 68;
  public static final int TypeServerError = 167;
  private int g0;
  private String gF = null;
  private int gG = -1;
  private double gH = 4.9E-324D;
  private String gI = null;
  private boolean gJ = false;
  private boolean gK = false;
  private String gL = "";
  private float gM = -1.0F;
  private double gN = 4.9E-324D;
  private boolean gO = false;
  private a gP = new a();
  private boolean gQ = false;
  private String gR = null;
  private float gS = 0.0F;
  private boolean gT = false;
  private int gU = 0;
  private double gV = 4.9E-324D;
  private boolean gW = false;
  private float gX = 0.0F;
  private String gY = null;
  private String gZ = null;

  public BDLocation()
  {
  }

  private BDLocation(Parcel paramParcel)
  {
    this.gU = paramParcel.readInt();
    this.gY = paramParcel.readString();
    this.gH = paramParcel.readDouble();
    this.gV = paramParcel.readDouble();
    this.gN = paramParcel.readDouble();
    this.gX = paramParcel.readFloat();
    this.gS = paramParcel.readFloat();
    this.gG = paramParcel.readInt();
    this.gM = paramParcel.readFloat();
    this.gI = paramParcel.readString();
    this.gR = paramParcel.readString();
    this.gP.jdField_if = paramParcel.readString();
    this.gP.jdField_new = paramParcel.readString();
    this.gP.jdField_int = paramParcel.readString();
    this.gP.jdField_byte = paramParcel.readString();
    this.gP.jdField_do = paramParcel.readString();
    this.gP.jdField_for = paramParcel.readString();
    this.gP.jdField_try = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[6];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.gJ = arrayOfBoolean[0];
    this.gK = arrayOfBoolean[1];
    this.gQ = arrayOfBoolean[2];
    this.gW = arrayOfBoolean[3];
    this.gT = arrayOfBoolean[4];
    this.gO = arrayOfBoolean[5];
    this.g0 = paramParcel.readInt();
    this.gL = paramParcel.readString();
  }

  public BDLocation(BDLocation paramBDLocation)
  {
    this.gU = paramBDLocation.gU;
    this.gY = paramBDLocation.gY;
    this.gH = paramBDLocation.gH;
    this.gV = paramBDLocation.gV;
    this.gJ = paramBDLocation.gJ;
    paramBDLocation.gN = paramBDLocation.gN;
    this.gK = paramBDLocation.gK;
    this.gX = paramBDLocation.gX;
    this.gQ = paramBDLocation.gQ;
    this.gS = paramBDLocation.gS;
    this.gW = paramBDLocation.gW;
    this.gG = paramBDLocation.gG;
    this.gM = paramBDLocation.gM;
    this.gZ = paramBDLocation.gZ;
    this.gT = paramBDLocation.gT;
    this.gF = paramBDLocation.gF;
    this.gO = paramBDLocation.gO;
    this.gP = new a();
    this.gP.jdField_if = paramBDLocation.gP.jdField_if;
    this.gP.jdField_new = paramBDLocation.gP.jdField_new;
    this.gP.jdField_int = paramBDLocation.gP.jdField_int;
    this.gP.jdField_byte = paramBDLocation.gP.jdField_byte;
    this.gP.jdField_do = paramBDLocation.gP.jdField_do;
    this.gP.jdField_for = paramBDLocation.gP.jdField_for;
    this.gP.jdField_try = paramBDLocation.gP.jdField_try;
    this.gI = paramBDLocation.gI;
    this.gR = paramBDLocation.gR;
    this.g0 = paramBDLocation.g0;
    this.gL = paramBDLocation.gL;
  }

  protected BDLocation(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
      return;
    JSONObject localJSONObject1;
    int i;
    try
    {
      localJSONObject1 = new JSONObject(paramString);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("result");
      i = Integer.parseInt(localJSONObject2.getString("error"));
      setLocType(i);
      setTime(localJSONObject2.getString("time"));
      if (i == 61)
      {
        JSONObject localJSONObject3 = localJSONObject1.getJSONObject("content");
        JSONObject localJSONObject4 = localJSONObject3.getJSONObject("point");
        setLatitude(Double.parseDouble(localJSONObject4.getString("y")));
        setLongitude(Double.parseDouble(localJSONObject4.getString("x")));
        setRadius(Float.parseFloat(localJSONObject3.getString("radius")));
        setSpeed(Float.parseFloat(localJSONObject3.getString("s")));
        setDirection(Float.parseFloat(localJSONObject3.getString("d")));
        setSatelliteNumber(Integer.parseInt(localJSONObject3.getString("n")));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.gU = 0;
      this.gT = false;
      return;
    }
    if (i == 161)
    {
      JSONObject localJSONObject7 = localJSONObject1.getJSONObject("content");
      JSONObject localJSONObject8 = localJSONObject7.getJSONObject("point");
      setLatitude(Double.parseDouble(localJSONObject8.getString("y")));
      setLongitude(Double.parseDouble(localJSONObject8.getString("x")));
      setRadius(Float.parseFloat(localJSONObject7.getString("radius")));
      String str2;
      if (localJSONObject7.has("addr"))
      {
        String str1 = localJSONObject7.getString("addr");
        this.gP.jdField_try = str1;
        String[] arrayOfString = str1.split(",");
        this.gP.jdField_if = arrayOfString[0];
        this.gP.jdField_new = arrayOfString[1];
        this.gP.jdField_int = arrayOfString[2];
        this.gP.jdField_byte = arrayOfString[3];
        this.gP.jdField_do = arrayOfString[4];
        this.gP.jdField_for = arrayOfString[5];
        if (((this.gP.jdField_if.contains("北京")) && (this.gP.jdField_new.contains("北京"))) || ((this.gP.jdField_if.contains("上海")) && (this.gP.jdField_new.contains("上海"))) || ((this.gP.jdField_if.contains("天津")) && (this.gP.jdField_new.contains("天津"))) || ((this.gP.jdField_if.contains("重庆")) && (this.gP.jdField_new.contains("重庆"))))
        {
          str2 = this.gP.jdField_if;
          label621: String str3 = str2 + this.gP.jdField_int + this.gP.jdField_byte + this.gP.jdField_do;
          this.gP.jdField_try = str3;
          this.gT = true;
        }
      }
      while (true)
      {
        if (localJSONObject7.has("floor"))
        {
          this.gI = localJSONObject7.getString("floor");
          if (TextUtils.isEmpty(this.gI))
            this.gI = null;
        }
        if (!localJSONObject7.has("loctp"))
          break;
        this.gR = localJSONObject7.getString("loctp");
        if (!TextUtils.isEmpty(this.gR))
          break;
        this.gR = null;
        return;
        str2 = this.gP.jdField_if + this.gP.jdField_new;
        break label621;
        this.gT = false;
        setAddrStr(null);
      }
    }
    while (true)
    {
      JSONObject localJSONObject5 = localJSONObject1.getJSONObject("content");
      JSONObject localJSONObject6 = localJSONObject5.getJSONObject("point");
      setLatitude(Double.parseDouble(localJSONObject6.getString("y")));
      setLongitude(Double.parseDouble(localJSONObject6.getString("x")));
      setRadius(Float.parseFloat(localJSONObject5.getString("radius")));
      jdMethod_if(Boolean.valueOf(Boolean.parseBoolean(localJSONObject5.getString("isCellChanged"))));
      return;
      if (i != 66)
        if (i != 68)
          break;
    }
  }

  private String bn()
  {
    return this.gL;
  }

  private static String bo()
  {
    return Build.MODEL;
  }

  private void jdMethod_if(Boolean paramBoolean)
  {
    this.gO = paramBoolean.booleanValue();
  }

  protected String bm()
  {
    return null;
  }

  protected void jdMethod_byte(int paramInt)
  {
    this.g0 = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAdUrl(String paramString)
  {
    String str1 = String.valueOf(this.gH);
    String str2 = String.valueOf(this.gV);
    String str3 = bn();
    String str4 = bo();
    String str5 = CommonEncrypt.a("ak=" + paramString + "&" + "lat=" + str1 + "&" + "lng=" + str2 + "&" + "cu=" + str3 + "&" + "mb=" + str4);
    return "http://lba.baidu.com/" + "?a=" + str5;
  }

  public String getAddrStr()
  {
    return this.gP.jdField_try;
  }

  public double getAltitude()
  {
    return this.gN;
  }

  public String getCity()
  {
    return this.gP.jdField_new;
  }

  public String getCityCode()
  {
    return this.gP.jdField_for;
  }

  public String getCoorType()
  {
    return this.gZ;
  }

  public float getDirection()
  {
    return this.gM;
  }

  public String getDistrict()
  {
    return this.gP.jdField_int;
  }

  public String getFloor()
  {
    return this.gI;
  }

  public double getLatitude()
  {
    return this.gH;
  }

  public int getLocType()
  {
    return this.gU;
  }

  public double getLongitude()
  {
    return this.gV;
  }

  public String getNetworkLocationType()
  {
    return this.gR;
  }

  public int getOperators()
  {
    return this.g0;
  }

  public String getProvince()
  {
    return this.gP.jdField_if;
  }

  public float getRadius()
  {
    return this.gS;
  }

  public int getSatelliteNumber()
  {
    this.gW = true;
    return this.gG;
  }

  public float getSpeed()
  {
    return this.gX;
  }

  public String getStreet()
  {
    return this.gP.jdField_byte;
  }

  public String getStreetNumber()
  {
    return this.gP.jdField_do;
  }

  public String getTime()
  {
    return this.gY;
  }

  public boolean hasAddr()
  {
    return this.gT;
  }

  public boolean hasAltitude()
  {
    return this.gJ;
  }

  public boolean hasRadius()
  {
    return this.gQ;
  }

  public boolean hasSateNumber()
  {
    return this.gW;
  }

  public boolean hasSpeed()
  {
    return this.gK;
  }

  public void internalSet(int paramInt, String paramString)
  {
    if (paramString == null);
    while (paramInt != 0)
      return;
    this.gL = paramString;
  }

  public boolean isCellChangeFlag()
  {
    return this.gO;
  }

  protected BDLocation p(String paramString)
  {
    return null;
  }

  public void setAddrStr(String paramString)
  {
    this.gF = paramString;
    if (paramString == null)
    {
      this.gT = false;
      return;
    }
    this.gT = true;
  }

  public void setAltitude(double paramDouble)
  {
    this.gN = paramDouble;
    this.gJ = true;
  }

  public void setCoorType(String paramString)
  {
    this.gZ = paramString;
  }

  public void setDirection(float paramFloat)
  {
    this.gM = paramFloat;
  }

  public void setLatitude(double paramDouble)
  {
    this.gH = paramDouble;
  }

  public void setLocType(int paramInt)
  {
    this.gU = paramInt;
  }

  public void setLongitude(double paramDouble)
  {
    this.gV = paramDouble;
  }

  public void setRadius(float paramFloat)
  {
    this.gS = paramFloat;
    this.gQ = true;
  }

  public void setSatelliteNumber(int paramInt)
  {
    this.gG = paramInt;
  }

  public void setSpeed(float paramFloat)
  {
    this.gX = paramFloat;
    this.gK = true;
  }

  public void setTime(String paramString)
  {
    this.gY = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.gU);
    paramParcel.writeString(this.gY);
    paramParcel.writeDouble(this.gH);
    paramParcel.writeDouble(this.gV);
    paramParcel.writeDouble(this.gN);
    paramParcel.writeFloat(this.gX);
    paramParcel.writeFloat(this.gS);
    paramParcel.writeInt(this.gG);
    paramParcel.writeFloat(this.gM);
    paramParcel.writeString(this.gI);
    paramParcel.writeString(this.gR);
    paramParcel.writeString(this.gP.jdField_if);
    paramParcel.writeString(this.gP.jdField_new);
    paramParcel.writeString(this.gP.jdField_int);
    paramParcel.writeString(this.gP.jdField_byte);
    paramParcel.writeString(this.gP.jdField_do);
    paramParcel.writeString(this.gP.jdField_for);
    paramParcel.writeString(this.gP.jdField_try);
    boolean[] arrayOfBoolean = new boolean[6];
    arrayOfBoolean[0] = this.gJ;
    arrayOfBoolean[1] = this.gK;
    arrayOfBoolean[2] = this.gQ;
    arrayOfBoolean[3] = this.gW;
    arrayOfBoolean[4] = this.gT;
    arrayOfBoolean[5] = this.gO;
    paramParcel.writeBooleanArray(arrayOfBoolean);
    paramParcel.writeInt(this.g0);
    paramParcel.writeString(this.gL);
  }

  public class a
  {
    public String jdField_byte = null;
    public String jdField_do = null;
    public String jdField_for = null;
    public String jdField_if = null;
    public String jdField_int = null;
    public String jdField_new = null;
    public String jdField_try = null;

    public a()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.BDLocation
 * JD-Core Version:    0.6.2
 */