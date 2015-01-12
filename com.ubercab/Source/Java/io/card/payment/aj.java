package io.card.payment;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

final class aj extends HttpEntityWrapper
{
  private GZIPInputStream a;

  public aj(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }

  public final void consumeContent()
  {
    this.a.close();
    this.a = null;
    super.consumeContent();
  }

  public final InputStream getContent()
  {
    if (this.a == null)
      this.a = new GZIPInputStream(this.wrappedEntity.getContent());
    return this.a;
  }

  public final long getContentLength()
  {
    return -1L;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.aj
 * JD-Core Version:    0.6.2
 */