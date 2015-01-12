package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract interface Variant
{
  public abstract Protocol getProtocol();

  public abstract int maxFrameSize();

  public abstract FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean);

  public abstract FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.spdy.Variant
 * JD-Core Version:    0.6.2
 */