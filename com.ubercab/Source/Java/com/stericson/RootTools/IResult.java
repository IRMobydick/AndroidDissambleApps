package com.stericson.RootTools;

import java.io.Serializable;

public abstract interface IResult
{
  public abstract Serializable getData();

  public abstract int getError();

  public abstract Process getProcess();

  public abstract void onComplete(int paramInt);

  public abstract void onFailure(Exception paramException);

  public abstract void process(String paramString)
    throws Exception;

  public abstract void processError(String paramString)
    throws Exception;

  public abstract IResult setData(Serializable paramSerializable);

  public abstract IResult setError(int paramInt);

  public abstract IResult setProcess(Process paramProcess);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.IResult
 * JD-Core Version:    0.6.2
 */