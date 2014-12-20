package android.support.v8.renderscript;

import android.content.res.Resources;
import android.renderscript.Script.FieldID;
import android.renderscript.Script.KernelID;
import android.renderscript.ScriptC;

class ScriptCThunker extends ScriptC
{
  private static final String TAG = "ScriptC";

  protected ScriptCThunker(RenderScriptThunker paramRenderScriptThunker, Resources paramResources, int paramInt)
  {
    super(paramRenderScriptThunker.mN, paramResources, paramInt);
  }

  void thunkBindAllocation(Allocation paramAllocation, int paramInt)
  {
    android.renderscript.Allocation localAllocation = null;
    if (paramAllocation != null)
      localAllocation = ((AllocationThunker)paramAllocation).mN;
    bindAllocation(localAllocation, paramInt);
  }

  Script.FieldID thunkCreateFieldID(int paramInt, Element paramElement)
  {
    return createFieldID(paramInt, ((ElementThunker)paramElement).getNObj());
  }

  Script.KernelID thunkCreateKernelID(int paramInt1, int paramInt2, Element paramElement1, Element paramElement2)
  {
    android.renderscript.Element localElement1 = null;
    android.renderscript.Element localElement2 = null;
    if (paramElement1 != null)
      localElement1 = ((ElementThunker)paramElement1).mN;
    if (paramElement2 != null)
      localElement2 = ((ElementThunker)paramElement2).mN;
    return createKernelID(paramInt1, paramInt2, localElement1, localElement2);
  }

  void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker)
  {
    android.renderscript.Allocation localAllocation1 = null;
    android.renderscript.Allocation localAllocation2 = null;
    android.renderscript.FieldPacker localFieldPacker = null;
    if (paramAllocation1 != null)
      localAllocation1 = ((AllocationThunker)paramAllocation1).mN;
    if (paramAllocation2 != null)
      localAllocation2 = ((AllocationThunker)paramAllocation2).mN;
    if (paramFieldPacker != null)
      localFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
    forEach(paramInt, localAllocation1, localAllocation2, localFieldPacker);
  }

  void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, Script.LaunchOptions paramLaunchOptions)
  {
    android.renderscript.Script.LaunchOptions localLaunchOptions = null;
    if (paramLaunchOptions != null)
    {
      localLaunchOptions = new android.renderscript.Script.LaunchOptions();
      if (paramLaunchOptions.getXEnd() > 0)
        localLaunchOptions.setX(paramLaunchOptions.getXStart(), paramLaunchOptions.getXEnd());
      if (paramLaunchOptions.getYEnd() > 0)
        localLaunchOptions.setY(paramLaunchOptions.getYStart(), paramLaunchOptions.getYEnd());
      if (paramLaunchOptions.getZEnd() > 0)
        localLaunchOptions.setZ(paramLaunchOptions.getZStart(), paramLaunchOptions.getZEnd());
    }
    android.renderscript.Allocation localAllocation1 = null;
    android.renderscript.Allocation localAllocation2 = null;
    android.renderscript.FieldPacker localFieldPacker = null;
    if (paramAllocation1 != null)
      localAllocation1 = ((AllocationThunker)paramAllocation1).mN;
    if (paramAllocation2 != null)
      localAllocation2 = ((AllocationThunker)paramAllocation2).mN;
    if (paramFieldPacker != null)
      localFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
    forEach(paramInt, localAllocation1, localAllocation2, localFieldPacker, localLaunchOptions);
  }

  void thunkInvoke(int paramInt)
  {
    invoke(paramInt);
  }

  void thunkInvoke(int paramInt, FieldPacker paramFieldPacker)
  {
    invoke(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
  }

  void thunkSetTimeZone(String paramString)
  {
    setTimeZone(paramString);
  }

  void thunkSetVar(int paramInt, double paramDouble)
  {
    setVar(paramInt, paramDouble);
  }

  void thunkSetVar(int paramInt, float paramFloat)
  {
    setVar(paramInt, paramFloat);
  }

  void thunkSetVar(int paramInt1, int paramInt2)
  {
    setVar(paramInt1, paramInt2);
  }

  void thunkSetVar(int paramInt, long paramLong)
  {
    setVar(paramInt, paramLong);
  }

  void thunkSetVar(int paramInt, BaseObj paramBaseObj)
  {
    if (paramBaseObj == null)
      setVar(paramInt, 0);
    while (true)
    {
      return;
      setVar(paramInt, paramBaseObj.getNObj());
    }
  }

  void thunkSetVar(int paramInt, FieldPacker paramFieldPacker)
  {
    setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
  }

  void thunkSetVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt)
  {
    setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()), ((ElementThunker)paramElement).mN, paramArrayOfInt);
  }

  void thunkSetVar(int paramInt, boolean paramBoolean)
  {
    setVar(paramInt, paramBoolean);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptCThunker
 * JD-Core Version:    0.6.0
 */