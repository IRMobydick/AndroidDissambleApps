package com.ubercab.common.io.input;

import java.io.InputStream;

public class ClosedInputStream extends InputStream
{
  public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();

  public int read()
  {
    return -1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.io.input.ClosedInputStream
 * JD-Core Version:    0.6.2
 */