package okio;

final class SegmentPool
{
  static final SegmentPool INSTANCE = new SegmentPool();
  static final long MAX_SIZE = 65536L;
  long byteCount;
  private Segment next;

  void recycle(Segment paramSegment)
  {
    if ((paramSegment.next != null) || (paramSegment.prev != null))
      throw new IllegalArgumentException();
    try
    {
      if (2048L + this.byteCount > 65536L)
        return;
      this.byteCount = (2048L + this.byteCount);
      paramSegment.next = this.next;
      paramSegment.limit = 0;
      paramSegment.pos = 0;
      this.next = paramSegment;
      return;
    }
    finally
    {
    }
  }

  Segment take()
  {
    try
    {
      if (this.next != null)
      {
        Segment localSegment = this.next;
        this.next = localSegment.next;
        localSegment.next = null;
        this.byteCount -= 2048L;
        return localSegment;
      }
      return new Segment();
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.SegmentPool
 * JD-Core Version:    0.6.2
 */