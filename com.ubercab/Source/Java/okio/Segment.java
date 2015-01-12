package okio;

final class Segment
{
  static final int SIZE = 2048;
  final byte[] data = new byte[2048];
  int limit;
  Segment next;
  int pos;
  Segment prev;

  public void compact()
  {
    if (this.prev == this)
      throw new IllegalStateException();
    if (this.prev.limit - this.prev.pos + (this.limit - this.pos) > 2048)
      return;
    writeTo(this.prev, this.limit - this.pos);
    pop();
    SegmentPool.INSTANCE.recycle(this);
  }

  public Segment pop()
  {
    if (this.next != this);
    for (Segment localSegment = this.next; ; localSegment = null)
    {
      this.prev.next = this.next;
      this.next.prev = this.prev;
      this.next = null;
      this.prev = null;
      return localSegment;
    }
  }

  public Segment push(Segment paramSegment)
  {
    paramSegment.prev = this;
    paramSegment.next = this.next;
    this.next.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }

  public Segment split(int paramInt)
  {
    int i = this.limit - this.pos - paramInt;
    if ((paramInt <= 0) || (i <= 0))
      throw new IllegalArgumentException();
    if (paramInt < i)
    {
      Segment localSegment2 = SegmentPool.INSTANCE.take();
      System.arraycopy(this.data, this.pos, localSegment2.data, localSegment2.pos, paramInt);
      this.pos = (paramInt + this.pos);
      localSegment2.limit = (paramInt + localSegment2.limit);
      this.prev.push(localSegment2);
      return localSegment2;
    }
    Segment localSegment1 = SegmentPool.INSTANCE.take();
    System.arraycopy(this.data, paramInt + this.pos, localSegment1.data, localSegment1.pos, i);
    this.limit -= i;
    localSegment1.limit = (i + localSegment1.limit);
    push(localSegment1);
    return this;
  }

  public void writeTo(Segment paramSegment, int paramInt)
  {
    if (paramInt + (paramSegment.limit - paramSegment.pos) > 2048)
      throw new IllegalArgumentException();
    if (paramInt + paramSegment.limit > 2048)
    {
      System.arraycopy(paramSegment.data, paramSegment.pos, paramSegment.data, 0, paramSegment.limit - paramSegment.pos);
      paramSegment.limit -= paramSegment.pos;
      paramSegment.pos = 0;
    }
    System.arraycopy(this.data, this.pos, paramSegment.data, paramSegment.limit, paramInt);
    paramSegment.limit = (paramInt + paramSegment.limit);
    this.pos = (paramInt + this.pos);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.Segment
 * JD-Core Version:    0.6.2
 */