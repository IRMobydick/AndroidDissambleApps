package android.support.v8.renderscript;

import android.renderscript.ScriptGroup.Builder;

public final class ScriptGroupThunker$Builder
{
  ScriptGroup.Builder bN;
  RenderScript mRS;

  ScriptGroupThunker$Builder(RenderScript paramRenderScript)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    this.mRS = paramRenderScript;
    this.bN = new ScriptGroup.Builder(localRenderScriptThunker.mN);
  }

  public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
  {
    TypeThunker localTypeThunker = (TypeThunker)paramType;
    this.bN.addConnection(localTypeThunker.getNObj(), paramKernelID.mN, paramFieldID.mN);
    return this;
  }

  public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
  {
    TypeThunker localTypeThunker = (TypeThunker)paramType;
    this.bN.addConnection(localTypeThunker.getNObj(), paramKernelID1.mN, paramKernelID2.mN);
    return this;
  }

  public Builder addKernel(Script.KernelID paramKernelID)
  {
    this.bN.addKernel(paramKernelID.mN);
    return this;
  }

  public ScriptGroupThunker create()
  {
    ScriptGroupThunker localScriptGroupThunker = new ScriptGroupThunker(0, this.mRS);
    localScriptGroupThunker.mN = this.bN.create();
    return localScriptGroupThunker;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroupThunker.Builder
 * JD-Core Version:    0.6.0
 */