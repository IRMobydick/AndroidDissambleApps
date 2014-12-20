package android.support.v8.renderscript;

class ScriptGroup$ConnectLine
{
  Type mAllocationType;
  Script.KernelID mFrom;
  Script.FieldID mToF;
  Script.KernelID mToK;

  ScriptGroup$ConnectLine(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
  {
    this.mFrom = paramKernelID;
    this.mToF = paramFieldID;
    this.mAllocationType = paramType;
  }

  ScriptGroup$ConnectLine(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
  {
    this.mFrom = paramKernelID1;
    this.mToK = paramKernelID2;
    this.mAllocationType = paramType;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup.ConnectLine
 * JD-Core Version:    0.6.0
 */