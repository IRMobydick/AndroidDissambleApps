package android.support.v8.renderscript;

import java.util.ArrayList;

class ScriptGroup$Node
{
  int dagNumber;
  ArrayList<ScriptGroup.ConnectLine> mInputs = new ArrayList();
  ArrayList<Script.KernelID> mKernels = new ArrayList();
  Node mNext;
  ArrayList<ScriptGroup.ConnectLine> mOutputs = new ArrayList();
  Script mScript;

  ScriptGroup$Node(Script paramScript)
  {
    this.mScript = paramScript;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup.Node
 * JD-Core Version:    0.6.0
 */