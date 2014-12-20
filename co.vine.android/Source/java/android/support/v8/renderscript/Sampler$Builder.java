package android.support.v8.renderscript;

public class Sampler$Builder
{
  float mAniso;
  Sampler.Value mMag;
  Sampler.Value mMin;
  RenderScript mRS;
  Sampler.Value mWrapR;
  Sampler.Value mWrapS;
  Sampler.Value mWrapT;

  public Sampler$Builder(RenderScript paramRenderScript)
  {
    this.mRS = paramRenderScript;
    this.mMin = Sampler.Value.NEAREST;
    this.mMag = Sampler.Value.NEAREST;
    this.mWrapS = Sampler.Value.WRAP;
    this.mWrapT = Sampler.Value.WRAP;
    this.mWrapR = Sampler.Value.WRAP;
    this.mAniso = 1.0F;
  }

  public Sampler create()
  {
    Sampler localSampler;
    if (RenderScript.isNative)
    {
      SamplerThunker.Builder localBuilder = new SamplerThunker.Builder((RenderScriptThunker)this.mRS);
      localBuilder.setMinification(this.mMin);
      localBuilder.setMagnification(this.mMag);
      localBuilder.setWrapS(this.mWrapS);
      localBuilder.setWrapT(this.mWrapT);
      localBuilder.setAnisotropy(this.mAniso);
      localSampler = localBuilder.create();
    }
    while (true)
    {
      return localSampler;
      this.mRS.validate();
      localSampler = new Sampler(this.mRS.nSamplerCreate(this.mMag.mID, this.mMin.mID, this.mWrapS.mID, this.mWrapT.mID, this.mWrapR.mID, this.mAniso), this.mRS);
      localSampler.mMin = this.mMin;
      localSampler.mMag = this.mMag;
      localSampler.mWrapS = this.mWrapS;
      localSampler.mWrapT = this.mWrapT;
      localSampler.mWrapR = this.mWrapR;
      localSampler.mAniso = this.mAniso;
    }
  }

  public void setAnisotropy(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.mAniso = paramFloat;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }

  public void setMagnification(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR))
    {
      this.mMag = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }

  public void setMinification(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.NEAREST) || (paramValue == Sampler.Value.LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_LINEAR) || (paramValue == Sampler.Value.LINEAR_MIP_NEAREST))
    {
      this.mMin = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }

  public void setWrapS(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
    {
      this.mWrapS = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }

  public void setWrapT(Sampler.Value paramValue)
  {
    if ((paramValue == Sampler.Value.WRAP) || (paramValue == Sampler.Value.CLAMP) || (paramValue == Sampler.Value.MIRRORED_REPEAT))
    {
      this.mWrapT = paramValue;
      return;
    }
    throw new IllegalArgumentException("Invalid value");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Sampler.Builder
 * JD-Core Version:    0.6.0
 */