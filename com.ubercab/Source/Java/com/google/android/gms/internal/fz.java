package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@ez
public final class fz
{
  public final int errorCode;
  public final int orientation;
  public final String qA;
  public final co qB;
  public final List<String> qf;
  public final List<String> qg;
  public final long qj;
  public final cl qy;
  public final cu qz;
  public final gv rN;
  public final String tA;
  public final long tH;
  public final boolean tI;
  public final long tJ;
  public final List<String> tK;
  public final String tN;
  public final av tx;
  public final JSONObject vp;
  public final cm vq;
  public final ay vr;
  public final long vs;
  public final long vt;
  public final bq.a vu;

  public fz(av paramav, gv paramgv, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, cl paramcl, cu paramcu, String paramString2, cm paramcm, co paramco, long paramLong2, ay paramay, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, bq.a parama)
  {
    this.tx = paramav;
    this.rN = paramgv;
    List localList1;
    List localList2;
    if (paramList1 != null)
    {
      localList1 = Collections.unmodifiableList(paramList1);
      this.qf = localList1;
      this.errorCode = paramInt1;
      if (paramList2 == null)
        break label181;
      localList2 = Collections.unmodifiableList(paramList2);
      label48: this.qg = localList2;
      if (paramList3 == null)
        break label187;
    }
    label181: label187: for (List localList3 = Collections.unmodifiableList(paramList3); ; localList3 = null)
    {
      this.tK = localList3;
      this.orientation = paramInt2;
      this.qj = paramLong1;
      this.tA = paramString1;
      this.tI = paramBoolean;
      this.qy = paramcl;
      this.qz = paramcu;
      this.qA = paramString2;
      this.vq = paramcm;
      this.qB = paramco;
      this.tJ = paramLong2;
      this.vr = paramay;
      this.tH = paramLong3;
      this.vs = paramLong4;
      this.vt = paramLong5;
      this.tN = paramString3;
      this.vp = paramJSONObject;
      this.vu = parama;
      return;
      localList1 = null;
      break;
      localList2 = null;
      break label48;
    }
  }

  public fz(a parama, gv paramgv, cl paramcl, cu paramcu, String paramString, co paramco, bq.a parama1)
  {
    this(parama.vv.tx, paramgv, parama.vw.qf, parama.errorCode, parama.vw.qg, parama.vw.tK, parama.vw.orientation, parama.vw.qj, parama.vv.tA, parama.vw.tI, paramcl, paramcu, paramString, parama.vq, paramco, parama.vw.tJ, parama.lH, parama.vw.tH, parama.vs, parama.vt, parama.vw.tN, parama.vp, parama1);
  }

  @ez
  public static final class a
  {
    public final int errorCode;
    public final ay lH;
    public final JSONObject vp;
    public final cm vq;
    public final long vs;
    public final long vt;
    public final fi vv;
    public final fk vw;

    public a(fi paramfi, fk paramfk, cm paramcm, ay paramay, int paramInt, long paramLong1, long paramLong2, JSONObject paramJSONObject)
    {
      this.vv = paramfi;
      this.vw = paramfk;
      this.vq = paramcm;
      this.lH = paramay;
      this.errorCode = paramInt;
      this.vs = paramLong1;
      this.vt = paramLong2;
      this.vp = paramJSONObject;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fz
 * JD-Core Version:    0.6.2
 */