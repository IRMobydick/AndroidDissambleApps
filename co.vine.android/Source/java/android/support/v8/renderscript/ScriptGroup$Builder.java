package android.support.v8.renderscript;

import java.util.ArrayList;

public final class ScriptGroup$Builder
{
  private int mKernelCount;
  private ArrayList<ScriptGroup.ConnectLine> mLines = new ArrayList();
  private ArrayList<ScriptGroup.Node> mNodes = new ArrayList();
  private RenderScript mRS;
  private ScriptGroupThunker.Builder mT;

  public ScriptGroup$Builder(RenderScript paramRenderScript)
  {
    if (RenderScript.isNative)
      this.mT = new ScriptGroupThunker.Builder(paramRenderScript);
    this.mRS = paramRenderScript;
  }

  private ScriptGroup.Node findNode(Script.KernelID paramKernelID)
  {
    int i = 0;
    ScriptGroup.Node localNode;
    int j;
    if (i < this.mNodes.size())
    {
      localNode = (ScriptGroup.Node)this.mNodes.get(i);
      j = 0;
      label28: if (j < localNode.mKernels.size())
        if (paramKernelID != localNode.mKernels.get(j));
    }
    while (true)
    {
      return localNode;
      j++;
      break label28;
      i++;
      break;
      localNode = null;
    }
  }

  private ScriptGroup.Node findNode(Script paramScript)
  {
    int i = 0;
    if (i < this.mNodes.size())
      if (paramScript != ((ScriptGroup.Node)this.mNodes.get(i)).mScript);
    for (ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i); ; localNode = null)
    {
      return localNode;
      i++;
      break;
    }
  }

  private void mergeDAGs(int paramInt1, int paramInt2)
  {
    for (int i = 0; i < this.mNodes.size(); i++)
    {
      if (((ScriptGroup.Node)this.mNodes.get(i)).dagNumber != paramInt2)
        continue;
      ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = paramInt1;
    }
  }

  private void validateCycle(ScriptGroup.Node paramNode1, ScriptGroup.Node paramNode2)
  {
    for (int i = 0; i < paramNode1.mOutputs.size(); i++)
    {
      ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode1.mOutputs.get(i);
      if (localConnectLine.mToK != null)
      {
        ScriptGroup.Node localNode2 = findNode(localConnectLine.mToK.mScript);
        if (localNode2.equals(paramNode2))
          throw new RSInvalidStateException("Loops in group not allowed.");
        validateCycle(localNode2, paramNode2);
      }
      if (localConnectLine.mToF == null)
        continue;
      ScriptGroup.Node localNode1 = findNode(localConnectLine.mToF.mScript);
      if (localNode1.equals(paramNode2))
        throw new RSInvalidStateException("Loops in group not allowed.");
      validateCycle(localNode1, paramNode2);
    }
  }

  private void validateDAG()
  {
    for (int i = 0; i < this.mNodes.size(); i++)
    {
      ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(i);
      if (localNode.mInputs.size() != 0)
        continue;
      if ((localNode.mOutputs.size() == 0) && (this.mNodes.size() > 1))
        throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
      validateDAGRecurse(localNode, i + 1);
    }
    int j = ((ScriptGroup.Node)this.mNodes.get(0)).dagNumber;
    for (int k = 0; k < this.mNodes.size(); k++)
    {
      if (((ScriptGroup.Node)this.mNodes.get(k)).dagNumber == j)
        continue;
      throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
    }
  }

  private void validateDAGRecurse(ScriptGroup.Node paramNode, int paramInt)
  {
    if ((paramNode.dagNumber != 0) && (paramNode.dagNumber != paramInt))
      mergeDAGs(paramNode.dagNumber, paramInt);
    while (true)
    {
      return;
      paramNode.dagNumber = paramInt;
      for (int i = 0; i < paramNode.mOutputs.size(); i++)
      {
        ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)paramNode.mOutputs.get(i);
        if (localConnectLine.mToK != null)
          validateDAGRecurse(findNode(localConnectLine.mToK.mScript), paramInt);
        if (localConnectLine.mToF == null)
          continue;
        validateDAGRecurse(findNode(localConnectLine.mToF.mScript), paramInt);
      }
    }
  }

  public Builder addConnection(Type paramType, Script.KernelID paramKernelID, Script.FieldID paramFieldID)
  {
    if (this.mT != null)
      this.mT.addConnection(paramType, paramKernelID, paramFieldID);
    while (true)
    {
      return this;
      ScriptGroup.Node localNode1 = findNode(paramKernelID);
      if (localNode1 == null)
        throw new RSInvalidStateException("From script not found.");
      ScriptGroup.Node localNode2 = findNode(paramFieldID.mScript);
      if (localNode2 == null)
        throw new RSInvalidStateException("To script not found.");
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID, paramFieldID));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
    }
  }

  public Builder addConnection(Type paramType, Script.KernelID paramKernelID1, Script.KernelID paramKernelID2)
  {
    if (this.mT != null)
      this.mT.addConnection(paramType, paramKernelID1, paramKernelID2);
    while (true)
    {
      return this;
      ScriptGroup.Node localNode1 = findNode(paramKernelID1);
      if (localNode1 == null)
        throw new RSInvalidStateException("From script not found.");
      ScriptGroup.Node localNode2 = findNode(paramKernelID2);
      if (localNode2 == null)
        throw new RSInvalidStateException("To script not found.");
      ScriptGroup.ConnectLine localConnectLine = new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2);
      this.mLines.add(new ScriptGroup.ConnectLine(paramType, paramKernelID1, paramKernelID2));
      localNode1.mOutputs.add(localConnectLine);
      localNode2.mInputs.add(localConnectLine);
      validateCycle(localNode1, localNode1);
    }
  }

  public Builder addKernel(Script.KernelID paramKernelID)
  {
    if (this.mT != null)
      this.mT.addKernel(paramKernelID);
    while (true)
    {
      return this;
      if (this.mLines.size() != 0)
        throw new RSInvalidStateException("Kernels may not be added once connections exist.");
      if (findNode(paramKernelID) != null)
        continue;
      this.mKernelCount = (1 + this.mKernelCount);
      ScriptGroup.Node localNode = findNode(paramKernelID.mScript);
      if (localNode == null)
      {
        localNode = new ScriptGroup.Node(paramKernelID.mScript);
        this.mNodes.add(localNode);
      }
      localNode.mKernels.add(paramKernelID);
    }
  }

  public ScriptGroup create()
  {
    Object localObject;
    if (this.mT != null)
      localObject = this.mT.create();
    while (true)
    {
      return localObject;
      if (this.mNodes.size() == 0)
        throw new RSInvalidStateException("Empty script groups are not allowed");
      for (int i = 0; i < this.mNodes.size(); i++)
        ((ScriptGroup.Node)this.mNodes.get(i)).dagNumber = 0;
      validateDAG();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int[] arrayOfInt1 = new int[this.mKernelCount];
      int j = 0;
      for (int k = 0; k < this.mNodes.size(); k++)
      {
        ScriptGroup.Node localNode = (ScriptGroup.Node)this.mNodes.get(k);
        int i3 = 0;
        while (i3 < localNode.mKernels.size())
        {
          Script.KernelID localKernelID = (Script.KernelID)localNode.mKernels.get(i3);
          int i4 = j + 1;
          arrayOfInt1[j] = localKernelID.getID(this.mRS);
          int i5 = 0;
          int i6 = 0;
          for (int i7 = 0; i7 < localNode.mInputs.size(); i7++)
          {
            if (((ScriptGroup.ConnectLine)localNode.mInputs.get(i7)).mToK != localKernelID)
              continue;
            i5 = 1;
          }
          for (int i8 = 0; i8 < localNode.mOutputs.size(); i8++)
          {
            if (((ScriptGroup.ConnectLine)localNode.mOutputs.get(i8)).mFrom != localKernelID)
              continue;
            i6 = 1;
          }
          if (i5 == 0)
            localArrayList1.add(new ScriptGroup.IO(localKernelID));
          if (i6 == 0)
            localArrayList2.add(new ScriptGroup.IO(localKernelID));
          i3++;
          j = i4;
        }
      }
      if (j != this.mKernelCount)
        throw new RSRuntimeException("Count mismatch, should not happen.");
      int[] arrayOfInt2 = new int[this.mLines.size()];
      int[] arrayOfInt3 = new int[this.mLines.size()];
      int[] arrayOfInt4 = new int[this.mLines.size()];
      int[] arrayOfInt5 = new int[this.mLines.size()];
      for (int m = 0; m < this.mLines.size(); m++)
      {
        ScriptGroup.ConnectLine localConnectLine = (ScriptGroup.ConnectLine)this.mLines.get(m);
        arrayOfInt2[m] = localConnectLine.mFrom.getID(this.mRS);
        if (localConnectLine.mToK != null)
          arrayOfInt3[m] = localConnectLine.mToK.getID(this.mRS);
        if (localConnectLine.mToF != null)
          arrayOfInt4[m] = localConnectLine.mToF.getID(this.mRS);
        arrayOfInt5[m] = localConnectLine.mAllocationType.getID(this.mRS);
      }
      int n = this.mRS.nScriptGroupCreate(arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5);
      if (n == 0)
        throw new RSRuntimeException("Object creation error, should not happen.");
      RenderScript localRenderScript = this.mRS;
      localObject = new ScriptGroup(n, localRenderScript);
      ScriptGroup.IO[] arrayOfIO1 = new ScriptGroup.IO[localArrayList2.size()];
      ((ScriptGroup)localObject).mOutputs = arrayOfIO1;
      for (int i1 = 0; i1 < localArrayList2.size(); i1++)
        localObject.mOutputs[i1] = ((ScriptGroup.IO)localArrayList2.get(i1));
      ScriptGroup.IO[] arrayOfIO2 = new ScriptGroup.IO[localArrayList1.size()];
      ((ScriptGroup)localObject).mInputs = arrayOfIO2;
      for (int i2 = 0; i2 < localArrayList1.size(); i2++)
        localObject.mInputs[i2] = ((ScriptGroup.IO)localArrayList1.get(i2));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup.Builder
 * JD-Core Version:    0.6.0
 */