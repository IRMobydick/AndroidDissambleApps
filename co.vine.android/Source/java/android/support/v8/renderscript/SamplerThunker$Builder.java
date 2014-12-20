package android.support.v8.renderscript;

import android.renderscript.Sampler.Builder;

public class SamplerThunker$Builder
{
  float mAniso;
  Sampler.Value mMag;
  Sampler.Value mMin;
  RenderScriptThunker mRS;
  Sampler.Value mWrapR;
  Sampler.Value mWrapS;
  Sampler.Value mWrapT;

  public SamplerThunker$Builder(RenderScriptThunker paramRenderScriptThunker)
  {
    this.mRS = paramRenderScriptThunker;
    this.mMin = Sampler.Value.NEAREST;
    this.mMag = Sampler.Value.NEAREST;
    this.mWrapS = Sampler.Value.WRAP;
    this.mWrapT = Sampler.Value.WRAP;
    this.mWrapR = Sampler.Value.WRAP;
  }

  public Sampler create()
  {
    this.mRS.validate();
    Sampler.Builder localBuilder = new Sampler.Builder(this.mRS.mN);
    localBuilder.setMinification(SamplerThunker.convertValue(this.mMin));
    localBuilder.setMagnification(SamplerThunker.convertValue(this.mMag));
    localBuilder.setWrapS(SamplerThunker.convertValue(this.mWrapS));
    localBuilder.setWrapT(SamplerThunker.convertValue(this.mWrapT));
    localBuilder.setAnisotropy(this.mAniso);
    android.renderscript.Sampler localSampler = localBuilder.create();
    SamplerThunker localSamplerThunker = new SamplerThunker(0, this.mRS);
    localSamplerThunker.mMin = this.mMin;
    localSamplerThunker.mMag = this.mMag;
    localSamplerThunker.mWrapS = this.mWrapS;
    localSamplerThunker.mWrapT = this.mWrapT;
    localSamplerThunker.mWrapR = this.mWrapR;
    localSamplerThunker.mAniso = this.mAniso;
    localSamplerThunker.mN = localSampler;
    return localSamplerThunker;
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
 * Qualified Name:     android.support.v8.renderscript.SamplerThunker.Builder
 * JD-Core Version:    0.6.0
 */