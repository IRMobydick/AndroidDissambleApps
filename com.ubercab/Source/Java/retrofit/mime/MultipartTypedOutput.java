package retrofit.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class MultipartTypedOutput
  implements TypedOutput
{
  private final String boundary;
  private final byte[] footer;
  private long length;
  private final List<MimePart> mimeParts = new LinkedList();

  public MultipartTypedOutput()
  {
    this(UUID.randomUUID().toString());
  }

  MultipartTypedOutput(String paramString)
  {
    this.boundary = paramString;
    this.footer = buildBoundary(paramString, false, true);
    this.length = this.footer.length;
  }

  private static byte[] buildBoundary(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!paramBoolean1)
        localStringBuilder.append("\r\n");
      localStringBuilder.append("--");
      localStringBuilder.append(paramString);
      if (paramBoolean2)
        localStringBuilder.append("--");
      localStringBuilder.append("\r\n");
      byte[] arrayOfByte = localStringBuilder.toString().getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Unable to write multipart boundary", localIOException);
    }
  }

  private static byte[] buildHeader(String paramString, TypedOutput paramTypedOutput)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Content-Disposition: form-data; name=\"");
      localStringBuilder.append(paramString);
      if (paramTypedOutput.fileName() != null)
      {
        localStringBuilder.append("\"; filename=\"");
        localStringBuilder.append(paramTypedOutput.fileName());
      }
      localStringBuilder.append("\"\r\nContent-Type: ");
      localStringBuilder.append(paramTypedOutput.mimeType());
      if (paramTypedOutput.length() != -1L)
        localStringBuilder.append("\r\nContent-Length: ").append(paramTypedOutput.length());
      localStringBuilder.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
      byte[] arrayOfByte = localStringBuilder.toString().getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Unable to write multipart header", localIOException);
    }
  }

  public void addPart(String paramString, TypedOutput paramTypedOutput)
  {
    if (paramString == null)
      throw new NullPointerException("Part name must not be null.");
    if (paramTypedOutput == null)
      throw new NullPointerException("Part body must not be null.");
    MimePart localMimePart = new MimePart(paramString, paramTypedOutput, this.boundary, this.mimeParts.isEmpty());
    this.mimeParts.add(localMimePart);
    long l = localMimePart.size();
    if (l == -1L)
      this.length = -1L;
    while (this.length == -1L)
      return;
    this.length = (l + this.length);
  }

  public String fileName()
  {
    return null;
  }

  public int getPartCount()
  {
    return this.mimeParts.size();
  }

  List<byte[]> getParts()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList(this.mimeParts.size());
    Iterator localIterator = this.mimeParts.iterator();
    while (localIterator.hasNext())
    {
      MimePart localMimePart = (MimePart)localIterator.next();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localMimePart.writeTo(localByteArrayOutputStream);
      localArrayList.add(localByteArrayOutputStream.toByteArray());
    }
    return localArrayList;
  }

  public long length()
  {
    return this.length;
  }

  public String mimeType()
  {
    return "multipart/form-data; boundary=" + this.boundary;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    Iterator localIterator = this.mimeParts.iterator();
    while (localIterator.hasNext())
      ((MimePart)localIterator.next()).writeTo(paramOutputStream);
    paramOutputStream.write(this.footer);
  }

  private static final class MimePart
  {
    private final TypedOutput body;
    private final String boundary;
    private boolean isBuilt;
    private final boolean isFirst;
    private final String name;
    private byte[] partBoundary;
    private byte[] partHeader;

    public MimePart(String paramString1, TypedOutput paramTypedOutput, String paramString2, boolean paramBoolean)
    {
      this.name = paramString1;
      this.body = paramTypedOutput;
      this.isFirst = paramBoolean;
      this.boundary = paramString2;
    }

    private void build()
    {
      if (this.isBuilt)
        return;
      this.partBoundary = MultipartTypedOutput.buildBoundary(this.boundary, this.isFirst, false);
      this.partHeader = MultipartTypedOutput.buildHeader(this.name, this.body);
      this.isBuilt = true;
    }

    public long size()
    {
      long l = -1L;
      build();
      if (this.body.length() > l)
        l = this.body.length() + this.partBoundary.length + this.partHeader.length;
      return l;
    }

    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      build();
      paramOutputStream.write(this.partBoundary);
      paramOutputStream.write(this.partHeader);
      this.body.writeTo(paramOutputStream);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.mime.MultipartTypedOutput
 * JD-Core Version:    0.6.2
 */